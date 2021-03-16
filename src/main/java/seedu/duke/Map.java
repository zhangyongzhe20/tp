package seedu.duke;

import java.util.Scanner;

//import control.SearchFacility;
import control.loadData;

public class Map {
    private static loadData dataController = new loadData();
    private static Parser parser = new Parser();
    private static UI ui = new UI();
//    private static SearchFacility searchFacility = new SearchFacility(dataController);

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
            parser.getLocationsList(input);
            break;
        case SEARCH:
            String facility = parser.getFacilitySearch(input);
            int id = parser.getIdSearch(input);
//            searchFacility.query(facility, id);
            break;
        case SEARCH_IN:
            parser.getBuilding(input);
            break;
        case FIND_FACILITY:
            parser.getFindFacilityLocation(input);
            parser.getFindFacilityType(input);
            parser.getTopK(input);
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
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! You need to add time for new Event or Deadline with '/at' or '/by'!!");
            }
            userInput = ui.getString(in);

        }

    }

}
