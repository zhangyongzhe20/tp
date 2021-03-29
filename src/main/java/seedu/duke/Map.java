package seedu.duke;

import control.*;
import entity.Location;

import java.util.Scanner;

import control.loadData;
import exceptions.InvalidCommandException;

//@@chenling
public class Map {
    private static loadData dataController = new loadData();
    private static Parser parser = new Parser();
    private static UI ui = new UI();
    private static SearchFacility searchFacility = new SearchFacility(dataController);

    public static loadData getDataController() {
        return dataController;
    }

    public static void show_welcome_msg() {
        System.out.println("Welcome to NTU Map \n");
    }

    public static void promptInput() {
        System.out.println("What would you like to do?");
    }

    public static void showExitMsg() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public static void executeCommand(String input, Command c) throws InvalidCommandException {
        switch (c) {
        case LIST_ALL_LOCATIONS: {
            String facilityType = parser.getFacilityType(input);
            Feature.listAllLocations(facilityType);
            break;
        }
        case SEARCH: {
            String facility = parser.getFacilitySearch(input);
            int id = parser.getIdSearch(input);
            searchFacility.query(facility, id);
            break;
        }
        case SEARCH_IN: {
            parser.getBuilding(input);
            break;
        }
        case FIND_FACILITY: {
            String facilityLocation = parser.getFindFacilityLocation(input);
            Location currentLocation = findNearest.findFacilityByName(dataController, facilityLocation).getLocation();
            String facilityType = parser.getFindFacilityType(input);
            int topK = parser.getTopK(input);
            new findNearest(dataController).findTopKFacility(currentLocation, facilityType, topK);
            break;
        }
        case INVALID:
            throw new InvalidCommandException();
        default:
            break;
        }

    }

    public static void main(String[] args) {
        show_welcome_msg();
        Command command;
        Scanner in = new Scanner(System.in);
        promptInput();
        String userInput = ui.getString(in);

        while (!parser.isBye(userInput)) {
            if (parser.isList(userInput)) {
                command = Command.LIST_ALL_LOCATIONS;
            } else if (parser.isFind(userInput)) {
                command = Command.FIND_FACILITY;
            } else if (parser.isList(userInput)) {
                command = Command.LIST_ALL_LOCATIONS;
            } else if (parser.isSearch(userInput)) {
                command = Command.SEARCH;
            } else if (parser.isSearchIn(userInput)) {
                command = Command.SEARCH_IN;
            } else {
                command = Command.INVALID;
            }

            try {
                executeCommand(userInput, command);
            } catch (InvalidCommandException e) {
                System.err.println(e.getMessage());
//                if (e.getMessage() != null) {
//                    System.err.println(e.getMessage());
//                } else {
//                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
//                }
            }
            promptInput();
            userInput = ui.getString(in);
        }
        showExitMsg();
    }

}
