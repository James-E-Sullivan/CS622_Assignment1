package parcels;

public abstract class Parcel {

    // Parcel Class variables
    protected String parcelID;
    protected String address;
    protected String type;
    protected String propertyValue;
    protected String landArea;

    // Default constructor
    public Parcel(){}

    // Secondary constructor with known parcelID
    public Parcel(String pid){
        parcelID = pid;
    }

    // method used to print Parcel information to the console and/or write to file
    public abstract String display();

    // abstract getter methods
    public abstract String getParcelID();
    public abstract String getAddress();
    public abstract String getType();
    public abstract String getPropertyValue();
    public abstract String getLandArea();

    // abstract setter methods
    public abstract void setParcelID(String pid);
    public abstract void setAddress(String add);
    public abstract void setType(String t);
    public abstract void setPropertyValue(String pv);
    public abstract void setLandArea(String la);

}
