package seedu.duke;

import exceptions.InvalidSearchException;

//@@chenling
public class Parser {

    public static String getFacilitySearch(String userInput) throws InvalidSearchException {
        if (userInput.length() < 7) {
            throw new InvalidSearchException("No parameters provided for search function :(");
        }
        int index = userInput.indexOf('/');
        if (index == -1) {
            throw new InvalidSearchException("Invalid syntax for search!!! It must be: \"search facilityType/facilityId\"");
        }
        String facility = userInput.substring(7,index);
        return facility;
    }

    public static int getIdSearch(String userInput) throws InvalidSearchException {
        int index = userInput.indexOf('/');
        if (index == -1) {
            throw new InvalidSearchException("Invalid syntax for search!!! It must be: \"search facilityType/facilityId\"");
        }
        String searchIdString = userInput.substring(index + 1);
        try {
            return Integer.parseInt(searchIdString);
        } catch (NumberFormatException exception) {
            throw new InvalidSearchException(String.format("facilityId provided to search must be an integer! " +
                    "\"%s\" is not a valid integer.", searchIdString));
        }

    }

    public static String getBuildingName(String userInput) {
        return userInput.substring(9).strip();
    }

    public static String getFindFacilityLocation(String userInput) {
        int index1 = userInput.indexOf('<');
        int index2 = userInput.indexOf('>');
        String location = userInput.substring(index1 + 1,index2);
        return location;
    }

    public static String getFindFacilityType(String userInput) {
        int index1 = userInput.indexOf('>');
        String substring = userInput.substring(index1 + 1);
        int index2 = substring.indexOf('<');
        int index3 = substring.indexOf('>');
        String facilityType = substring.substring(index2 + 1,index3);
        return facilityType;
    }

    public static int getTopK(String userInput) {
        int index1 = userInput.indexOf('>');
        String substring1 = userInput.substring(index1 + 1);
        int index2 = substring1.indexOf('>');
        String substring2 = substring1.substring(index2 + 1);
        int index3 = substring2.indexOf('<');
        int index4 = substring2.indexOf('>');
        String stringTopK = substring2.substring(index3 + 1,index4);
        int topK = Integer.parseInt(stringTopK);
        return topK;
    }

    public static String getLocationsList(String userInput) {
        int index1 = userInput.indexOf('<');
        int index2 = userInput.indexOf('>');
        String location = userInput.substring(index1 + 1,index2);
        return location;
    }

    public static String getBuilding(String userInput) {
        String buildingName = userInput.substring(10);
        return buildingName;
    }

    public static boolean isList(String userInput) {
        if (userInput.length() > 16) {
            if (userInput.substring(0, 16).equals("listAllLocations")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSearch(String userInput) {
        if (userInput.length() >= 6) {
            return userInput.startsWith("search");
        }
        return false;
    }

    public static boolean isSearchIn(String userInput) {
        if (userInput.length() >= 9) {
            return userInput.startsWith("search in");
        }
        return false;
    }

    public static boolean isFind(String userInput) {
        if (userInput.length() > 12) {
            if (userInput.substring(0, 12).equals("findFacility")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBye(String userInput) {
        if (userInput.equals("bye")) {
            return true;
        } else {
            return false;
        }
    }


}
