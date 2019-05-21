import parcels.Parcel;
import java.io.IOException;
import java.util.Scanner;

public class ParcelSearch {



    public static void main(String[] args) throws IOException {
        CSV_Input.read_CSV_File();

        Scanner scan = new Scanner(System.in);
        String input;

        boolean done = false;
        while (!done){

            System.out.println("Please Enter the type of property you would like to purchase:");
            System.out.println("    1. Commercial");
            System.out.println("    2. Residential");
            input = scan.nextLine();

            if(input.equals("1") | input.toLowerCase().equals("commercial")){
                System.out.println("Please choose one of the following parameters to narrow your search." +
                        " To continue, enter 'continue'.");
                System.out.println("    1. Parcel ID");
                System.out.println("    2. Address");
                System.out.println("    3. Property Value");
                System.out.println("    4. Land Area");
                input = scan.nextLine();


                switch(input){
                    default: "Invalid Option";
                }

            }

            else if(input.equals("2") | input.toLowerCase().equals("residential")){
                System.out.println("Please choose one of the following parameters to narrow your search." +
                        " To continue, enter 'continue'.");
                System.out.println("    1. Parcel ID");
                System.out.println("    2. Address");
                System.out.println("    3. Property Value");
                System.out.println("    4. Land Area");
                System.out.println("    5. Living Area");
                System.out.println("    6. Bedrooms");
                input = scan.nextLine();

                switch(input){
                    default: "Invalid Option";
                }
            }


        }



    }

}
