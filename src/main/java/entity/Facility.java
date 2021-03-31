package entity;
//@@author zhangyongzhe20
public abstract class Facility {
    private int facilityID;
    private String name;
    private FacilityType type;
    private Location location;
    private Location address;

    public Facility(int facilityID, String name, Location location, Location address, FacilityType type) {
        this.facilityID = facilityID;
        this.name = name;
        this.location = location;
        this.type = type;
        this.address = address;
    }

    public Facility() {

    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = Integer.parseInt(facilityID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacilityType getType() {
        return type;
    }

    public Location getLocation() {return location; }
    public String getAddress() {return getLocation().getAddress(); }

    public void setLocation(String x, String y, String address, String building) {
        this.location = new Location(Double.parseDouble(x),Double.parseDouble(y), address, building);
    }

    public enum facilityType {
        LECTURETHEATER, CANTEEN, LIBRARY
    }
    public void strToFacilityType(String type) {
        if (type.equalsIgnoreCase("LECTURETHEATER")) {
            this.type = FacilityType.LECTURETHEATER;
        } else if (type.equalsIgnoreCase("CANTEEN")) {
            this.type = FacilityType.CANTEEN;
        } else if (type.equalsIgnoreCase("LIBRARY")) {
            this.type = FacilityType.LIBRARY;
        }
    }

    // return string representation of this facility
    public String toString() {
        return this.facilityID + " (" +  this.name + " )"  +
                " locates at " + this.location.toString();
    }
}
