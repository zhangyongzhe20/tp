package entity;

public class Canteen extends Facility{
    public Canteen(int facilityID, String name, Location location, Location address, facilityType type){
        super(facilityID, name, location, address, type);
    }

    public Canteen() {
        super();
    }
}
