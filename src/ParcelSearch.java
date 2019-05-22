import parcels.CommercialParcel;
import parcels.Parcel;
import parcels.ResidentialParcel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ParcelSearch {

    public static void executeSearch(SearchParameters param){

    }

    public static void main(String[] args) throws IOException {

        CSV_Input bostonParcels = new CSV_Input();
        bostonParcels.read_CSV_File();              // reads commercial and residential parcel info into HashMaps
        HashMap<String, ResidentialParcel> bostonResidentialMap = bostonParcels.getResidentialMap();
        HashMap<String, CommercialParcel> bostonCommercialMap = bostonParcels.getCommercialMap();

        Scanner scan = new Scanner(System.in);
        String input;
        SearchParameters userParameters = new SearchParameters();

        boolean done = false;
        while (!done){

            System.out.println("Please Enter the type of property you would like to purchase:");
            System.out.println("    1. Commercial");
            System.out.println("    2. Residential");
            input = scan.nextLine();

            if (input.equals("1") | input.toLowerCase().equals("commercial")){
                userParameters.setLandUseType("Commercial");
            }
            else if (input.equals("2") | input.toLowerCase().equals("residential")){
                userParameters.setLandUseType("Residential");
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

                try{
                    if(input.equals("1") | input.toLowerCase().equals("parcel id")){
                        System.out.println("Enter the desired Parcel ID: ");
                        userParameters.setParcelID(scan.nextLine());    // does not check for validity
                    }
                    else if(input.equals("2") | input.toLowerCase().equals("address")){
                        System.out.println("Enter an address: ");
                        userParameters.setAddress(scan.nextLine());
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

        done = true;

        }

        if(userParameters.getLandUseType().equals("Residential")){
            for(ResidentialParcel rp : bostonResidentialMap.values()){

                if((userParameters.getParcelID() != null) &&
                        !(rp.getParcelID().equals(userParameters.getParcelID()))){
                    continue;
                }
                else if((userParameters.getAddress() != null) &&
                        !(rp.getAddress().toLowerCase().contains(userParameters.getAddress().toLowerCase()))){
                    continue;
                }
                System.out.println();
                rp.display();
            }
        }
        else if(userParameters.getLandUseType().equals("Commercial")){
            for(CommercialParcel cp : bostonCommercialMap.values()){

                if((userParameters.getParcelID() != null) &&
                        !(cp.getParcelID().equals(userParameters.getParcelID()))){
                    continue;
                }
                else if((userParameters.getAddress() != null) &&
                        !(cp.getAddress().toLowerCase().contains(userParameters.getAddress().toLowerCase()))){
                    continue;
                }
                System.out.println();
                cp.display();
            }
        }



    }

}
