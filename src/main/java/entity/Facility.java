package entity;

public abstract class Facility {
    private int facilityID;
    private String name;
    private facilityType type;
    private Location location;

    public Facility(int facilityID, String name, Location location, facilityType type) {
        this.facilityID = facilityID;
        this.name = name;
        this.location = location;
        this.type = type;
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

    public facilityType getType() {
        return type;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(String x, String y) {
        this.location = new Location(Double.parseDouble(x),Double.parseDouble(y));
    }

    public enum facilityType {
		LECTURETHEATER, CANTEEN, LIBRARY
	}

    public facilityType strToFacilityType(String type) {
        facilityType fType = null;
        if (type.equalsIgnoreCase("LECTURETHEATER")) {
            fType = facilityType.LECTURETHEATER;
        } else if (type.equalsIgnoreCase("CANTEEN")) {
            fType = facilityType.CANTEEN;
        } else if (type.equalsIgnoreCase("LIBRARY")) {
            fType = facilityType.LIBRARY;
        }
        return fType;
    }

    // return string representation of this facility
    public String toString() {
        return this.facilityID + " (" +  this.name + " )"  +
                " locates at " + this.location.toString();
    }
}
