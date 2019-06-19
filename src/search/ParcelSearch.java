package search;
import custom_exceptions.ParcelSearchException;
import IO.CSV_Input;
import database.ParcelTableMain;
import org.jetbrains.annotations.NotNull;
import IO.ParcelIO;
import parcels.Parcel;
import IO.SearchOutput;
import parcels.ResidentialParcel;

import java.text.SimpleDateFormat;
import java.util.*;


public class ParcelSearch {

    /**
     * Searches through a given Parcel HashMap and displays parcel info
     * for parcels with matching parameters.
     * @param param: search.SearchParameters object
     * @param parcelMap: HashMap with String (PID)/Parcel pairs
     */
    private static void executeSearch(SearchParameters param, LinkedHashMap<String, Parcel> parcelMap){

        LinkedList<String> outputList = new LinkedList<>();
        LinkedHashMap<String, Parcel> unfilteredMap = new LinkedHashMap<>();
        LinkedHashMap<String, Parcel> outputMap = new LinkedHashMap<>();

        ParcelFilter searchFilter = new ParcelFilter();
        //HashMap<String, Parcel> outputMap = searchFilter.parameterFilter(param, parcelMap);

        for(Parcel p : parcelMap.values()){

            // if parcelID parameter specified and it doesn't match given parcelID, continue
            if((param.getParcelID() != null) &&
                    !(p.getParcelID().equals(param.getParcelID()))){
                continue;
            }

            // if address parameter specified and it doesn't match given address, continue
            else if((param.getAddress() != null) &&
                    !(p.getAddress().toLowerCase().contains(param.getAddress().toLowerCase()))){
                continue;
            }

            outputList.add(p.display());
            unfilteredMap.put(p.getParcelID(), p);  // map with matching PID and addresses

            // add propertyValue filters for outputMap
            if (param.getUpperPropertyValue() != null && param.getLowerPropertyValue() != null){
                outputMap = searchFilter.propertyValueFilter(param, unfilteredMap);
            }
        }

        SearchOutput.writeSearchResultList(outputList); // Write text string to output txt file
        ParcelIO.writeParcel(outputMap);                // Write Parcel objects to file
        System.out.println("Search results successfully written to text file.");
        System.out.println("Matching Parcels saved to object output file.");

    }

    /**
     * Prompts user for information to narrow parcel search
     * @return inputParameters: User defined search parameters
     */
    private static SearchParameters promptUser(){

        // Create Scanner object to obtain user parameter input
        Scanner scan = new Scanner(System.in);
        String input;
        SearchParameters inputParameters = new SearchParameters();   // will hold user specified search info

        boolean done = false;
        while (!done){

            // prompt user for the land use type
            System.out.println("Please Enter the type of property you would like to purchase:");
            System.out.println("    1. Commercial");
            System.out.println("    2. Residential");
            input = scan.nextLine();

            if (input.equals("1") | input.toLowerCase().equals("commercial")){
                inputParameters.setLandUseType("Commercial");    // sets landUseType parameter to "Commercial"
            }
            else if (input.equals("2") | input.toLowerCase().equals("residential")){
                inputParameters.setLandUseType("Residential");   // sets landUseType parameter to "Residential"
            }
            else{
                System.out.println("Invalid entry. Please enter a valid response.");
                continue;   // Go to beginning of while loop to re-prompt user
            }

            // loop to obtain search-narrowing parameters
            while (true){

                System.out.println("Please choose one of the following parameters to narrow your search." +
                        " Otherwise, enter 'continue'.");
                System.out.println("    1. Parcel ID");
                System.out.println("    2. Address");
                System.out.println("    3. Property Value");
                input = scan.nextLine();        // get user response

                // update parcelID, address, and/or propertyValue search parameters
                try{
                    if(input.equals("1") | input.toLowerCase().equals("parcel id")){
                        System.out.println("Enter the desired Parcel ID: ");
                        inputParameters.setParcelID(scan.nextLine());    // does not check for validity
                    }
                    else if(input.equals("2") | input.toLowerCase().equals("address")){
                        System.out.println("Enter an address: ");
                        inputParameters.setAddress(scan.nextLine());
                    }
                    else if(input.equals("3") | input.toLowerCase().equals("property value")){
                        System.out.println("Enter a target property value");

                        // set propertyValue and set search bounds
                        inputParameters.setPropertyValue(Integer.valueOf(scan.nextLine()));
                        //inputParameters.setPropertyValueBounds();
                    }
                    else if(input.toLowerCase().equals("continue")){
                        break;
                    }
                    else{
                        // throw custom ParcelSearchException
                        throw new ParcelSearchException("Invalid Entry: " + input);
                    }
                }
                catch (ParcelSearchException ex){
                    ex.printStackTrace();
                }
                catch (IllegalArgumentException ex){
                    System.err.println("Caught IllegalArgumentException: " + ex.getMessage());
                }
            }
            done = true;    // exit while loop
        }
        return inputParameters;      // return inputParameters for search
    }

    /**
     * Outputs to console the greatest values for PID, Address, Property Value, Land Area
     * living area (residential only) and bedrooms (residential only).
     * @param parcelMap: HashMap with PID/Parcel as Key/Value pairs
     */
    private static void findGreatestValues(@NotNull HashMap<String, Parcel> parcelMap){

        // create new Generic Parcel Comparator
        ParcelComparator<String> stringComp = new ParcelComparator<>();
        ParcelComparator<Integer> intComp = new ParcelComparator<>();

        // initialize greatest variable values to lowest possible value
        String greatestPID = "";
        String greatestAddress = "";
        Integer greatestPropertyValue = 0;
        Integer greatestLandArea = 0;
        Integer greatestLivingArea = 0;
        Integer greatestBedrooms = 0;

        boolean residential = false;

        // iterate through parcelMap to obtain greatest values
        for (Parcel p : parcelMap.values()){
            greatestPID = stringComp.highValue(p.getParcelID(), greatestPID);
            greatestAddress = stringComp.highValue(p.getAddress(), greatestAddress);
            greatestPropertyValue = intComp.highValue(p.getPropertyValue(), greatestPropertyValue);
            greatestLandArea = intComp.highValue(p.getLandArea(), greatestLandArea);

            // determine living area and bedroom values only if Parcel is residential
            if (p instanceof ResidentialParcel){
                residential = true;
                greatestLivingArea = intComp.highValue(((ResidentialParcel) p).getLivingArea(), greatestLivingArea);
                greatestBedrooms = intComp.highValue(((ResidentialParcel) p).getBedrooms(), greatestBedrooms);
            }
        }

        // prints greatest values to console
        System.out.println("\nGreatest PID Value: " + greatestPID);
        System.out.println("Greatest Address Value: " + greatestAddress);
        System.out.println("Greatest Property Value: " + greatestPropertyValue);
        System.out.println("Greatest Land Area: " + greatestLandArea);
        if (residential){
            System.out.println("Greatest Living Area: " + greatestLivingArea);
            System.out.println("Greatest Number of Bedrooms: " + greatestBedrooms);
        }
    }


    public static void main(String[] args){

        // Read parcel info from CSV file and store info in HashMaps
        CSV_Input bostonParcels = new CSV_Input();
        bostonParcels.read_CSV_File();              // reads commercial and residential parcel info into HashMaps
        LinkedHashMap<String, Parcel> bostonResidentialMap = bostonParcels.getResidentialMap();
        LinkedHashMap<String, Parcel> bostonCommercialMap = bostonParcels.getCommercialMap();

        // obtain search parameters from user
        SearchParameters userParameters = promptUser();

        // get current date and time
        Date currentDate = new Date();  // object contains unformatted current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // clear search result IO file prior to writing
        SearchOutput.overwriteSearchResults("Date/Time of Search: " + formatter.format(currentDate));
        SearchOutput.writeSearchResults(userParameters.getAllParameters() +
                "\n----------------------------------------\n");

        // Searches parcels w/ matching criteria & writes parcel info to IO txt file
        if(userParameters.getLandUseType().equals("Residential")){
            executeSearch(userParameters, bostonResidentialMap);
        }
        else if(userParameters.getLandUseType().equals("Commercial")){
            executeSearch(userParameters, bostonCommercialMap);
        }


        // display objects from object output file
        System.out.println("\nDisplaying Parcels from object output file:\n");
        for (Parcel p : ParcelIO.readParcel().values()){
            System.out.println(p.display());
        }



        ParcelTableMain.displayDB(ParcelIO.readParcel());

        //ParcelTableMain.CSV_to_DB();


    }
}
