package entity;

public class Library extends Facility{
    public Library(int facilityID, String name, Location location, Location address){
        super(facilityID, name, location, address, FacilityType.LIBRARY);
    }

    public Library() {

    }
}
