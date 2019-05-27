package parcels;

public class CommercialParcel extends Parcel{

    // Parcel Class variables
    protected String parcelID;
    protected String address;
    protected String type = "Commercial";
    protected String propertyValue;
    protected String landArea;


    // default constructor
    public CommercialParcel(){}

    // secondary constructor with known parcelID
    public CommercialParcel(String pid){
        parcelID = pid;
    }

    // prints CommercialParcel information to console
    public String display(){

        String displayString = "Parcel ID (PID): " + parcelID +
                "\nAddress: " + address +
                "\nLand Use: " + type +
                "\nProperty Value: " + propertyValue +
                "\nLand Area: " + landArea;

        System.out.println(displayString);
        return displayString;



        /*
        System.out.println("Parcel ID (PID): " + parcelID);
        System.out.println("Address: " + address);
        System.out.println("Land Use: " + type);
        System.out.println("Property Value: " + propertyValue);
        System.out.println("Land Area: " + landArea);

         */
    }

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
