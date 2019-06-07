package parcels;

public class ResidentialParcel extends Parcel {

    // Parcel Class variables
    protected String parcelID;
    protected String address;
    protected String type;
    protected Integer propertyValue;
    protected Integer landArea;

    // ResidentialParcel specific variables
    protected Integer livingArea;
    protected Integer bedrooms;

    // default constructor
    public ResidentialParcel(){}

    // secondary constructor with known parcelID
    public ResidentialParcel(String pid){
        parcelID = pid;
    }

    // Returns ResidentialParcel info String
    public String display(){

        String displayString = "\nParcel ID (PID): " + parcelID +
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
    public void setPropertyValue(Integer pv){propertyValue = pv;}
    public void setLandArea(Integer la){landArea = la;}
    public void setLivingArea(Integer liv_A){livingArea = liv_A;}
    public void setBedrooms(Integer beds){bedrooms = beds;}

    // ResidentialParcel accessor methods
    public String getParcelID(){return parcelID;}
    public String getAddress(){return address;}
    public String getType(){return type;}
    public Integer getPropertyValue(){return propertyValue;}
    public Integer getLandArea(){return landArea;}
    public Integer getLivingArea(){return livingArea;}
    public Integer getBedrooms(){return bedrooms;}

}
