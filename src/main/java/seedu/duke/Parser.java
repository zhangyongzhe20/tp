package seedu.duke;

public class Parser {

    public static String getFacilitySearch(String user_input){
        int index = user_input.indexOf('/');
        String facility = user_input.substring(6,index);
        return facility;


    }
    public static int getIdSearch(String user_input){
        int index = user_input.indexOf('/');
        int id = Integer.parseInt(user_input.substring(index));
        return id;

    }

    public static String getFindFacilityLocation(String user_input){
        int index1 = user_input.indexOf('<');
        int index2 = user_input.indexOf('>');
        String location = user_input.substring(index1+1,index2);
        return location;
    }

    public static String getFindFacilityType(String user_input){
        int index1 = user_input.indexOf('>');
        String substring = user_input.substring(index1+1);
        int index2 = substring.indexOf('<');
        int index3 = substring.indexOf('>');
        String facilityType = substring.substring(index2+1,index3);
        return facilityType;
    }

    public static int getTopK(String user_input){
        int index1 = user_input.indexOf('>');
        String substring1 = user_input.substring(index1+1);
        int index2 = substring1.indexOf('>');
        String substring2 = substring1.substring(index2+1);
        int index3 = substring2.indexOf('<');
        int index4 = substring2.indexOf('>');
        String stringTopK = substring2.substring(index3+1,index4);
        int topK = Integer.parseInt(stringTopK);
        return topK;
    }

    public static String getLocationsList(String user_input){
        int index1 = user_input.indexOf('<');
        int index2 = user_input.indexOf('>');
        String location = user_input.substring(index1+1,index2);
        return location;
    }

    public static String getBuilding (String user_input){
        String buildingName = user_input.substring(10);
        return buildingName;
    }

    public static boolean isList(String user_input){
        if (user_input.length() > 16) {
            if (user_input.substring(0, 16).equals("listAllLocations")) {
                return true;
            }
        }
        return false;
    }
    public static boolean isSearch(String user_input){
        if (user_input.length() > 6) {
            if (user_input.substring(0, 6).equals("search")) {
                return true;
            }
        }
        return false;
    }
    public static boolean isSearchIn(String user_input){
        if (user_input.length() > 9) {
            if (user_input.substring(0, 6).equals("search in")) {
                return true;
            }
        }
        return false;
    }
    public static boolean isFind(String user_input){
        if (user_input.length() > 12) {
            if (user_input.substring(0, 12).equals("findFacility")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBye(String user_input) {
        if (user_input.equals("bye")) {
            return true;
        } else {
            return false;
        }
    }


}
