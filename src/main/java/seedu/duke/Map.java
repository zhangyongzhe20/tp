package seedu.duke;

import control.*;
import entity.Location;

import java.util.Scanner;

import control.loadData;
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
        System.out.println("What would you like to do?");
    }

    public static void show_exit_msg() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public static void executeCommand(String input, Command c) throws InvalidCommandException, EmptyInputException {
        switch (c) {
        case LIST_ALL_LOCATIONS:
            String location = parser.getLocationsList(input);
            Feature.listAllLocations(location);
            break;
        case SEARCH:
            String facility = parser.getFacilitySearch(input);
            int id = parser.getIdSearch(input);
            searchFacility.query(facility, id);
            break;
        case SEARCH_IN:
            parser.getBuilding(input);
            break;
        case FIND_FACILITY:
            String facilityLocation = parser.getFindFacilityLocation(input);
            Location currentLocation = findNearest.findFacilityByName(dataController, facilityLocation).getLocation();
            String facilityType = parser.getFindFacilityType(input);
            int topK = parser.getTopK(input);
            new findNearest(dataController).findTopKFacility(currentLocation, facilityType, topK);
            break;
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
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } catch (EmptyInputException e) {
                System.out.println("OOPS!!! The description of a new task cannot be empty.");
            }
            userInput = ui.getString(in);

        }

    }

}
