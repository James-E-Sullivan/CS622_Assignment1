package parcels;

public abstract class Parcel {

    protected String parcelID;
    protected String address;
    protected String type;
    protected String propertyValue;
    protected String landArea;

    public Parcel(){}

    public Parcel(String pid){
        parcelID = pid;
    }

    public abstract void display();

    /*
    public abstract void setParcelID(String pid);
    public abstract String getParcelID();
    public abstract String getAddress();
    public abstract String getType();
    public abstract Integer getPropertyValue();
    public abstract Integer getLandArea();
     */

    // setter methods
    public void setParcelID(String pid){parcelID = pid;}
    public void setAddress(String add){address = add;}
    public void setType(String t){type = t;}
    public void setPropertyValue(String pv){propertyValue = pv;}
    public void setLandArea(String la){landArea = la;}

    // accessor methods
    public String getParcelID(){return parcelID;}
    public String getAddress(){return address;}
    public String getType(){return type;}
    public String getPropertyValue(){return propertyValue;}
    public String getLandArea(){return landArea;}

}
