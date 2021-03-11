package seedu.duke;

public class Parser {

    public static String getFacilitySearch(String userInput) {
        int index = userInput.indexOf('/');
        String facility = userInput.substring(6,index);
        return facility;


    }

    public static int getIdSearch(String userInput) {
        int index = userInput.indexOf('/');
        int id = Integer.parseInt(userInput.substring(index));
        return id;

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
        if (userInput.length() > 6) {
            if (userInput.substring(0, 6).equals("search")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSearchIn(String userInput) {
        if (userInput.length() > 9) {
            if (userInput.substring(0, 6).equals("search in")) {
                return true;
            }
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
