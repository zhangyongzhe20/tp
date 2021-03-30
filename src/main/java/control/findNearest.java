package control;

import entity.Facility;
import entity.Location;
import exceptions.FacilityNotFoundException;
import seedu.duke.InvalidCommandException;
import seedu.duke.Map;

import java.util.ArrayList;
import java.util.List;

//@author geezzzyyy
public class findNearest {
    static loadData dataController;
    public findNearest(loadData dataController) {
        this.dataController = dataController;
    }

    public static Facility findFacilityByName(loadData ld, String facilityLocation) throws FacilityNotFoundException {
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
        throw new FacilityNotFoundException("Your current location: " + facilityLocation + " does not exist");
    }

    public static void findTopKFacility(Location currentLocation, String facilityType, int topK) throws FacilityNotFoundException {
        List<Facility> facilityList = new ArrayList<Facility>();
        switch (facilityType.toUpperCase()) {
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
            throw new FacilityNotFoundException("Invalid Facility type! please choose from CANTEEN, LIBRARY and LECTURETHEATER");
        }
        if(topK > facilityList.size()) {
            throw new ArrayIndexOutOfBoundsException("Unable to find top" + topK + "! " +
                    "There are only " + facilityList.size() + " " + facilityType + " available");
        } else{
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
    }
}
