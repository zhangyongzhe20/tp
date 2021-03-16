package entity;

public class Canteen extends Facility{
    public Canteen(int facilityID, String name, Location location){
        super(facilityID, name, location, FacilityType.CANTEEN);
    }

    public Canteen() {
        super();
    }
}
