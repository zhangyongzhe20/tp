package control;

import java.io.FileNotFoundException;
import java.util.List;

import entity.Facility;
import exceptions.FacilityNotFoundException;

public class SearchFacility {
    loadData dataController;

    public SearchFacility(loadData dataController) {
        this.dataController = dataController;
    }

    private Facility findCanteen(int facilityId, List<Facility> canteens) throws FacilityNotFoundException {
        for (Facility canteen : canteens) {
            if (canteen.getFacilityID() == facilityId) {
                return canteen;
            }
        }
        throw new FacilityNotFoundException("Aiyoh where got this canteen one");
    }

    private Facility findLibrary(int facilityId, List<Facility> libraries) throws FacilityNotFoundException {
        for (Facility library : libraries) {
            if (library.getFacilityID() == facilityId) {
                return library;
            }
        }
        throw new FacilityNotFoundException("Aiyoh where got this library one");
    }

    private Facility findLectureTheater(int facilityId, List<Facility> lectureTheaters) throws FacilityNotFoundException {
        for (Facility lectureTheater : lectureTheaters) {
            if (lectureTheater.getFacilityID() == facilityId) {
                return lectureTheater;
            }
        }
        throw new FacilityNotFoundException("Aiyoh where got this lecture theater one");
    }


    public void query(String facilityType, int facilityId) {

        Facility facilityFound = null;
        try {
            switch (facilityType) {
            case "canteen":
                facilityFound = this.findCanteen(facilityId, this.dataController.getCanteens());
                break;
            case "library":
                facilityFound = this.findLibrary(facilityId, this.dataController.getLibraries());
                break;
            case "lectureTheater":
                facilityFound = this.findLectureTheater(facilityId, this.dataController.getLectureTheaters());
                break;
            default:
                throw new FacilityNotFoundException("Go die lah where got this kind of facility one");
            }
            System.out.println(facilityFound.getLocation());
        } catch (FacilityNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
