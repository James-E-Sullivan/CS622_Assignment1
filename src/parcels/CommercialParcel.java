package parcels;

public class CommercialParcel extends Parcel{

    // Parcel Class variables
    protected String parcelID;
    protected String address;
    protected String type = "Commercial";
    protected Integer propertyValue;
    protected Integer landArea;


    // default constructor
    public CommercialParcel(){}

    // secondary constructor with known parcelID
    public CommercialParcel(String pid){
        parcelID = pid;
    }

    // Returns CommercialParcel info String
    public String display(){

        String displayString = "Parcel ID (PID): " + parcelID +
                "\nAddress: " + address +
                "\nLand Use: " + type +
                "\nProperty Value: " + propertyValue +
                "\nLand Area: " + landArea;

        return displayString;
    }

    // setter methods
    public void setParcelID(String pid){parcelID = pid;}
    public void setAddress(String add){address = add;}
    public void setType(String t){type = t;}
    public void setPropertyValue(Integer pv){propertyValue = pv;}
    public void setLandArea(Integer la){landArea = la;}

    // accessor methods
    public String getParcelID(){return parcelID;}
    public String getAddress(){return address;}
    public String getType(){return type;}
    public Integer getPropertyValue(){return propertyValue;}
    public Integer getLandArea(){return landArea;}

}
