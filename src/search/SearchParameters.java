package search;

public class SearchParameters {
    /*
    Search parameters used as an object to narrow down search results.
     */

    public interface upperFactor {
        Double ceilingCalc(Integer i, Double f);
    }

    public interface lowerFactor {
        Double floorCalc(Integer i, Double f);
    }

    // private class variables
    private String landUseType;
    private String parcelID;
    private String address;
    private Integer propertyValue;

    // upper & lower bounds for propertyValue search
    private Integer upperPropertyValue;
    private Integer lowerPropertyValue;

    // default constructor
    public SearchParameters(){}

    // general setter methods
    public void setLandUseType(String type){landUseType = type;}
    public void setParcelID(String pid){parcelID = pid;}
    public void setAddress(String add){address = add;}
    public void setPropertyValue(Integer pV){propertyValue = pV;}

    /**
     * Sets ceiling/floor bounds for propertyValue searches
     */
    public void setPropertyValueBounds(){

        // lambda methods for finding ceiling/floor search values
        upperFactor ceiling = (Integer pV, Double factor) -> pV * factor;
        lowerFactor floor = (Integer pV, Double factor) -> pV * factor;

        // set integer values of calculated ceiling/floor values
        upperPropertyValue = ceiling.ceilingCalc(propertyValue, 1.25).intValue();
        lowerPropertyValue = floor.floorCalc(propertyValue, 0.75).intValue();
    }

    // general accessor methods
    public String getLandUseType(){return landUseType;}
    public String getParcelID(){return parcelID;}
    public String getAddress(){return address;}
    public Integer getUpperPropertyValue(){return upperPropertyValue;}
    public Integer getLowerPropertyValue(){return lowerPropertyValue;}

    // returns String of all parameters
    public String getAllParameters(){
        return "Land Use Type: " + landUseType +
                "\nParcel ID: " + parcelID +
                "\nAddress: " + address;
    }





}
