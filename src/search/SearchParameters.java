package search;

public class SearchParameters {
    /*
    Search parameters used as an object to narrow down search results.
     */

    // private class variables
    private String landUseType;
    private String parcelID;
    private String address;

    // default constructor
    public SearchParameters(){}

    // general setter methods
    public void setLandUseType(String type){landUseType = type;}
    public void setParcelID(String pid){parcelID = pid;}
    public void setAddress(String add){address = add;}

    // general accessor methods
    public String getLandUseType(){return landUseType;}
    public String getParcelID(){return parcelID;}
    public String getAddress(){return address;}

    // returns String of all parameters
    public String getAllParameters(){
        return "Land Use Type: " + landUseType +
                "\nParcel ID: " + parcelID +
                "\nAddress: " + address;
    }


}
