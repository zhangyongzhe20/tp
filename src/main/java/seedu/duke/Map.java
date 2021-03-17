package seedu.duke;

import control.FileIsEmptyException;
import control.loadData;
import entity.Facility;
import entity.Location;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.SearchFacility;
import control.loadData;

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
            Location currentLocation = findFacilityByName(dataController, facilityLocation).getLocation();
            String facilityType = parser.getFindFacilityType(input);
            int topK = parser.getTopK(input);
            findTopKFacility(currentLocation, facilityType, topK);
            break;
        case INVALID:
            throw new InvalidCommandException();
        default:
            break;
        }

    }

    private static void findTopKFacility(Location currentLocation, String facilityType, int topK) throws InvalidCommandException {
        List<Facility> facilityList = new ArrayList<Facility>();
        switch (facilityType) {
        case "CANTEEN":
            facilityList = new ArrayList<Facility>(dataController.getCanteens());
            break;
        case "LIBRARY":
            facilityList = new ArrayList<Facility>(dataController.getLibraries());
            break;
        case "LECTURETHEATER":
            facilityList = new ArrayList<Facility>(dataController.getLectureTheaters());
            break;
        default:
            throw new InvalidCommandException();
        }
        for (int i = 0; i < topK; i++) {
            int minIndex = 0;

            for (int j = 1; j < facilityList.size(); j++) {
                double newDistance = facilityList.get(j).getLocation().distanceTo(currentLocation);
                double shortestDistance = facilityList.get(minIndex).getLocation().distanceTo(currentLocation);
                if (newDistance<shortestDistance) {
                    minIndex = j;
                }
            }
            Facility facilityFound = facilityList.get(minIndex);
            System.out.println(facilityFound.getName()+"@"+facilityFound.getLocation().getAddress());
            facilityList.remove(minIndex);
        }
    }

    public static Facility findFacilityByName(loadData ld, String facilityLocation) throws InvalidCommandException {
        for (Facility f: ld.getLibraries()) {
            if (f.getName().equals(facilityLocation)) {
                return f;
            }
        }
        for (Facility f: ld.getCanteens()) {
            if (f.getName().equals(facilityLocation)) {
                return f;
            }
        }
        for (Facility f: ld.getLectureTheaters()) {
            if (f.getName().equals(facilityLocation)) {
                return f;
            }
        }
        throw new InvalidCommandException();
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
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! You need to add time for new Event or Deadline with '/at' or '/by'!!");
            }
            userInput = ui.getString(in);

        }

    }

}
