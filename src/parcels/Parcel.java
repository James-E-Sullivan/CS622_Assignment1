package parcels;

public abstract class Parcel<T> {

    // Parcel Class variables
    protected String parcelID;
    protected String address;
    protected String type;
    protected Integer propertyValue;
    protected Integer landArea;

    // variable to be used as
    protected T keyVariable;

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
    public abstract Integer getPropertyValue();
    public abstract Integer getLandArea();

    // abstract setter methods
    public abstract void setParcelID(String pid);
    public abstract void setAddress(String add);
    public abstract void setType(String t);
    public abstract void setPropertyValue(Integer pv);
    public abstract void setLandArea(Integer la);

}
