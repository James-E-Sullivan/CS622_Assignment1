public class SearchParameters {
    /*
    Search parameters used as an object to narrow down search results.
     */

    // private class variables
    private String parcelID;
    private String address;
    private Integer propertyValueUpper;
    private Integer propertyValueLower;
    private Integer landAreaUpper;
    private Integer landAreaLower;
    private Integer livingAreaUpper;
    private Integer livingAreaLower;
    private Integer bedroomsUpper;
    private Integer bedroomsLower;

    // default constructor
    public SearchParameters(){}

    // setter methods
    public void setParcelID(String pid){parcelID = pid;}
    public void setAddress(String add){address = add;}
    public void setPropertyValueUpper(Integer upperBound){propertyValueUpper = upperBound;}
    public void setPropertyValueLower(Integer lowerBound){propertyValueLower = lowerBound;}
    public void setLandAreaUpper(Integer upperBound){landAreaUpper = upperBound;}
    public void setLandAreaLower(Integer lowerBound){landAreaLower = lowerBound;}
    public void setLivingAreaUpper(Integer upperBound){livingAreaUpper = upperBound;}
    public void setLivingAreaLower(Integer lowerBound){livingAreaLower = lowerBound;}
    public void setBedroomsUpper(Integer upperBound){bedroomsUpper = upperBound;}
    public void setBedroomsLower(Integer lowerBound){bedroomsLower = lowerBound;}

    // accessor methods
    public String getParcelID(){return parcelID;}
    public String getAddress(){return address;}
    public Integer getPropertyValueUpper(){return propertyValueUpper;}
    public Integer getPropertyValueLower(){return propertyValueLower;}
    public Integer getLandAreaUpper(){return landAreaUpper;}
    public Integer getLandAreaLower(){return landAreaLower;}
    public Integer getLivingAreaUpper(){return livingAreaUpper;}
    public Integer getLivingAreaLower(){return livingAreaLower;}
    public Integer getBedroomsUpper(){return bedroomsUpper;}
    public Integer getBedroomsLower(){return bedroomsLower;}
}
