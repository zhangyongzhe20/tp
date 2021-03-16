package entity;

public class Library extends Facility{
    public Library(int facilityID, String name, Location location){
        super(facilityID, name, location, FacilityType.LIBRARY);
    }

    public Library() {

    }
}
