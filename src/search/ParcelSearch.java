package search;
import input.CSV_Input;
import parcels.Parcel;
import output.SearchOutput;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ParcelSearch {


    /**
     * Searches through a given Parcel HashMap and displays parcel info
     * for parcels with matching parameters.
     * @param param: search.SearchParameters object
     * @param parcelMap: HashMap with String (PID)/Parcel pairs
     */
    private static void executeSearch(SearchParameters param, HashMap<String, Parcel> parcelMap){

        LinkedList<String> outputList = new LinkedList<>();

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

            // if no parameters specified, or if parameters met, display Parcel info & write to file

            //System.out.println();
            //p.display();

            outputList.add(p.display());

        }

        SearchOutput.writeSearchResultList(outputList);
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
                input = scan.nextLine();        // get user response

                // update parcelID and/or address search parameters
                try{
                    if(input.equals("1") | input.toLowerCase().equals("parcel id")){
                        System.out.println("Enter the desired Parcel ID: ");
                        inputParameters.setParcelID(scan.nextLine());    // does not check for validity
                    }
                    else if(input.equals("2") | input.toLowerCase().equals("address")){
                        System.out.println("Enter an address: ");
                        inputParameters.setAddress(scan.nextLine());
                    }
                    else if(input.toLowerCase().equals("continue")){
                        break;
                    }
                    else{
                        System.out.println("Invalid entry. Please enter a valid response.");
                    }
                }
                catch (IllegalArgumentException ex){
                    System.err.println("Caught IllegalArgumentException: " + ex.getMessage());
                }
            }
            done = true;    // exit while loop
        }
        return inputParameters;      // return inputParameters for search
    }

    public static void main(String[] args) throws IOException {

        // Read parcel info from CSV file and store info in HashMaps
        CSV_Input bostonParcels = new CSV_Input();
        bostonParcels.read_CSV_File();              // reads commercial and residential parcel info into HashMaps
        HashMap<String, Parcel> bostonResidentialMap = bostonParcels.getResidentialMap();
        HashMap<String, Parcel> bostonCommercialMap = bostonParcels.getCommercialMap();

        // obtain search parameters from user
        SearchParameters userParameters = promptUser();

        // get current date and time
        Date currentDate = new Date();  // object contains unformatted current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // clear search result output file prior to writing
        SearchOutput.overwriteSearchResults("Date/Time of Search: " + formatter.format(currentDate) +
                "\n----------------------------------------\n");

        // Searches for and displays parcels with matching criteria
        if(userParameters.getLandUseType().equals("Residential")){
            executeSearch(userParameters, bostonResidentialMap);
        }
        else if(userParameters.getLandUseType().equals("Commercial")){
            executeSearch(userParameters, bostonCommercialMap);
        }
    }
}
