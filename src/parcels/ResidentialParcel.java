package parcels;

public class ResidentialParcel extends Parcel {

    // Parcel Class variables
    protected String parcelID;
    protected String address;
    protected String type;
    protected String propertyValue;
    protected String landArea;

    // ResidentialParcel specific variables
    protected String livingArea;
    protected String bedrooms;

    // default constructor
    public ResidentialParcel(){}

    // secondary constructor with known parcelID
    public ResidentialParcel(String pid){
        parcelID = pid;
    }

    // Prints ResidentialParcel information to console
    public String display(){

        String displayString = "Parcel ID (PID): " + parcelID +
                "\nAddress: " + address +
                "\nLand Use: " + type +
                "\nProperty Value: " + propertyValue +
                "\nLand Area: " + landArea +
                "\nLiving Area: " + livingArea +
                "\nBedrooms: " + bedrooms;

        return displayString;
    }

    // ResidentialParcel setter methods
    public void setParcelID(String pid){parcelID = pid;}
    public void setAddress(String add){address = add;}
    public void setType(String t){type = t;}
    public void setPropertyValue(String pv){propertyValue = pv;}
    public void setLandArea(String la){landArea = la;}
    public void setLivingArea(String liv_A){livingArea = liv_A;}
    public void setBedrooms(String beds){bedrooms = beds;}

    // ResidentialParcel accessor methods
    public String getParcelID(){return parcelID;}
    public String getAddress(){return address;}
    public String getType(){return type;}
    public String getPropertyValue(){return propertyValue;}
    public String getLandArea(){return landArea;}
    public String getLivingArea(){return livingArea;}
    public String getBedrooms(){return bedrooms;}

}
