package entity;

public class Canteen extends Facility{
    public Canteen(int facilityID, String name, Location location, facilityType type){
        super(facilityID, name, location, type);
    }

    public Canteen() {
        super();
    }
}
