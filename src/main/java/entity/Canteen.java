package entity;

public class Canteen extends Facility{
    public Canteen(int facilityID, String name, Location location, Location address){
        super(facilityID, name, location, address, FacilityType.CANTEEN);
    }

    public Canteen() {
        super();
    }
}
