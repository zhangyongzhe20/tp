package seedu.duke;

import java.util.Scanner;

public class Map {
    private static Parser parser = new Parser();
    private static UI ui = new UI();

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
                parser.getFacilitySearch(input);
                parser.getIdSearch(input);
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

        }
    }

    public static void main(String[] args) {
        show_welcome_msg();
        Command command;
        Scanner in = new Scanner(System.in);
        String user_input = ui.getString(in);


        while (!parser.isBye(user_input)) {
            if (parser.isList(user_input)) {
                command = Command.LIST_ALL_LOCATIONS;
            } else if (parser.isFind(user_input)) {
                command = Command.FIND_FACILITY;
            } else if (parser.isList(user_input)) {
                command = Command.LIST_ALL_LOCATIONS;
            } else if (parser.isSearch(user_input)) {
                command = Command.SEARCH;
            } else if (parser.isSearchIn(user_input)) {
                command = Command.SEARCH_IN;
            } else {
                command = Command.INVALID;
            }

            try {
                executeCommand(user_input, command);
            } catch (InvalidCommandException e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } catch (EmptyInputException e) {
                System.out.println("OOPS!!! The description of a new task cannot be empty.");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! You need to add time for new Event or Deadline with '/at' or '/by'!!");
            }


            user_input = ui.getString(in);

        }

    }

}
