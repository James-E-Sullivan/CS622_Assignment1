import parcels.CommercialParcel;
import parcels.Parcel;
import parcels.ResidentialParcel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ParcelSearch {

    /*
    private static void chooseParameters(int landUse, SearchParameters userParameters){

        boolean done = false;
        while (!done){
            if(input.equals("1") | input.toLowerCase().equals("commercial")){
                System.out.println("Please choose one of the following parameters to narrow your search." +
                        " Otherwise, enter 'continue'.");
                System.out.println("    1. Parcel ID");
                System.out.println("    2. Address");
                System.out.println("    3. Property Value");
                System.out.println("    4. Land Area");
                input = scan.nextLine();

                if(input.equals("1") | input.toLowerCase().equals("parcel id")){
                    System.out.println("Enter the desired Parcel ID: ");
                    userParameters.setParcelID(scan.nextLine());    // does not check for validity
                }
                else if(input.equals("2") | input.toLowerCase().equals("address")){
                    System.out.println("Enter an address: ");
                    userParameters.setAddress(scan.nextLine());
                }
                else if(input.equals("3") | input.toLowerCase().equals("property value")){
                    System.out.println("Enter the lower bound property value (inclusive): ");
                    userParameters.setPropertyValueLower(Integer.valueOf(scan.nextLine()));
                    System.out.println("Enter the upper bound property value (inclusive): ");
                    userParameters.setPropertyValueUpper(Integer.valueOf(scan.nextLine()));
                }
                else if(input.equals("4") | input.toLowerCase().equals("land area")){
                    System.out.println("Enter the lower bound of land area (inclusive): ");
                    userParameters.setLandAreaLower(Integer.valueOf(scan.nextLine()));
                    System.out.println("Enter the upper bound of land area (inclusive): ");
                    userParameters.setLandAreaUpper(Integer.valueOf(scan.nextLine()));
                }
                else{
                    System.out.println("Invalid entry.");
                }
        }
    }

     */

    public static void executeSearch(SearchParameters param){

    }

    public static void main(String[] args) throws IOException {

        CSV_Input bostonParcels = new CSV_Input();
        bostonParcels.read_CSV_File();              // reads commercial and residential parcel info into HashMaps
        HashMap<String, ResidentialParcel> bostonResidentialMap = bostonParcels.getResidentialMap();




        HashMap<String, CommercialParcel> bostonCommercialMap = bostonParcels.getCommercialMap();

        Scanner scan = new Scanner(System.in);
        String input;
        Integer landUse;
        SearchParameters userParameters = new SearchParameters();

        boolean done = false;
        while (!done){

            System.out.println("Please Enter the type of property you would like to purchase:");
            System.out.println("    1. Commercial");
            System.out.println("    2. Residential");
            input = scan.nextLine();

            if (input.equals("1") | input.toLowerCase().equals("commercial")){
                landUse = 1;
                userParameters.setLandUseType("Commercial");
            }
            else if (input.equals("2") | input.toLowerCase().equals("residential")){
                landUse = 2;
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
                System.out.println("    3. Property Value");
                System.out.println("    4. Land Area");
                if(landUse == 2){
                    System.out.println("    5. Living Area");
                    System.out.println("    6. Bedrooms");
                }

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
                    else if(input.equals("3") | input.toLowerCase().equals("property value")){
                        System.out.println("Enter the lower bound property value (inclusive): ");
                        userParameters.setPropertyValueLower(Integer.valueOf(scan.nextLine()));
                        System.out.println("Enter the upper bound property value (inclusive): ");
                        userParameters.setPropertyValueUpper(Integer.valueOf(scan.nextLine()));
                    }
                    else if(input.equals("4") | input.toLowerCase().equals("land area")){
                        System.out.println("Enter the lower bound of land area (inclusive): ");
                        userParameters.setLandAreaLower(Integer.valueOf(scan.nextLine()));
                        System.out.println("Enter the upper bound of land area (inclusive): ");
                        userParameters.setLandAreaUpper(Integer.valueOf(scan.nextLine()));
                    }
                    else if(landUse == 2){
                        if(input.equals("5") | input.toLowerCase().equals("living area")){
                            System.out.println("Enter the lower bound of living area");
                            userParameters.setLivingAreaLower(Integer.valueOf(scan.nextLine()));
                            System.out.println("Enter the upper bound of living area");
                            userParameters.setLivingAreaUpper(Integer.valueOf(scan.nextLine()));
                        }
                        if(input.equals("6") | input.toLowerCase().equals("bedrooms")){
                            System.out.println("Enter the lower bound for bedrooms");
                            userParameters.setBedroomsLower(Integer.valueOf(scan.nextLine()));
                            userParameters.setBedroomsUpper(Integer.valueOf(scan.nextLine()));
                        }
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
                System.out.println();
                rp.display();
            }
        }
        else if(userParameters.getLandUseType().equals("Commercial")){
            for(CommercialParcel cp : bostonCommercialMap.values()){
                System.out.println();
                cp.display();
            }
        }



    }

}
