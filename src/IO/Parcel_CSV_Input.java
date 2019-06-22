package IO;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import parcels.CommercialParcel;
import parcels.Parcel;
import parcels.ResidentialParcel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

// class with methods for handling CSV file input
public class Parcel_CSV_Input {

    // Constant used for CSV file
    final private String CSV_INPUT_FILE = "resources/Parcels_2016_Data_Full.csv";

    // creates Reader object to read csv file
    Reader in;

    // HashMaps for Res & Comm Parcels, with PID/Parcel pairs
    private LinkedHashMap<String, Parcel> residentialMap = new LinkedHashMap<>();
    private LinkedHashMap<String, Parcel> commercialMap = new LinkedHashMap<>();

    // default constructor
    public Parcel_CSV_Input(){}


    /**
     * Converts String numbers into Integers
     * @param inputText: Input from CSV file entry
     * @return inputInteger
     */
    private Integer inputToInteger(String inputText){

        Integer inputInteger = null;

        try{
            inputInteger = Integer.valueOf(inputText);
        }
        catch (NumberFormatException ex){
            // ideally, this would be null - need to add functionality
            inputInteger = 0;
        }
        catch (RuntimeException ex){
            ex.printStackTrace();
        }

        return inputInteger;
    }


    public ArrayList<Parcel> readParcelFromFile(){

        ArrayList<Parcel> allParcels = new ArrayList<>();

        try{
            // opens CSV file and stores it in iterable CSVRecord object, records
            Reader in = new FileReader(CSV_INPUT_FILE);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(in);

            // iterates through records
            for(CSVRecord record : records) {

                // obtain string values from applicable columns
                String PID = record.get(3);
                String address = record.get(58);
                String type = record.get(11);
                String propertyValue = record.get(19).replaceAll("\\s+", "");
                String landArea = record.get(21).replaceAll("\\s+", "");


                //Create ResidentialParcel object
                ResidentialParcel rp = new ResidentialParcel();

                // obtain string values for residential-specific columns
                String livingArea = record.get(25).replaceAll("\\s+", "");
                String bedrooms = record.get(32).replaceAll("\\s+", "");

                //set ResidentialParcel String variables
                rp.setParcelID(PID);
                rp.setAddress(address);
                rp.setType(type);

                // Set Residential Parcel Integer variables
                rp.setPropertyValue(inputToInteger(propertyValue));
                rp.setLandArea(inputToInteger(landArea));
                rp.setLivingArea(inputToInteger(livingArea));
                rp.setBedrooms(inputToInteger(bedrooms));

                // add new ResidentialParcel object to residentialMap
                allParcels.add(rp);
            }
            // close CSV file
            in.close();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            System.err.println("Caught IOException while opening " + CSV_INPUT_FILE +
                    ex.getMessage());
            ex.printStackTrace();
        }

        return allParcels;

    }



    /**
     * Reads Boston Parcel Information CSV.
     * Known header values allow for hard-coded column numbers.
     * If a row corresponds to a res or comm parcel, a new Parcel object is
     * created and added to either the residentialMap or commercialMap.
     */
    public void read_CSV_File(){

        try{
            // opens CSV file and stores it in iterable CSVRecord object, records
            Reader in = new FileReader(CSV_INPUT_FILE);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(in);

            // iterates through records
            for(CSVRecord record : records){

                // obtain string values from applicable columns
                String PID = record.get(3);
                String address = record.get(58);
                String type = record.get(11);
                String propertyValue = record.get(19).replaceAll("\\s+","");
                String landArea = record.get(21).replaceAll("\\s+","");

                // creates new ResidentialParcel object, sets values, and adds it to residentialMap
                if(type.contains("Residential")){

                    //Create ResidentialParcel object
                    ResidentialParcel rp = new ResidentialParcel();

                    // obtain string values for residential-specific columns
                    String livingArea = record.get(25).replaceAll("\\s+","");
                    String bedrooms = record.get(32).replaceAll("\\s+","");

                    //set ResidentialParcel String variables
                    rp.setParcelID(PID);
                    rp.setAddress(address);
                    rp.setType(type);

                    // Set Residential Parcel Integer variables
                    rp.setPropertyValue(inputToInteger(propertyValue));
                    rp.setLandArea(inputToInteger(landArea));
                    rp.setLivingArea(inputToInteger(livingArea));
                    rp.setBedrooms(inputToInteger(bedrooms));

                    // add new ResidentialParcel object to residentialMap
                    residentialMap.put(rp.getParcelID(), rp);
                }

                // creates new CommercialParcel object, sets values, adds it to CommercialMap
                else if(type.contains("Commercial")){

                    // create CommercialParcel object without using down-casting
                    CommercialParcel cp = new CommercialParcel();

                    // set CommercialParcel variables
                    cp.setParcelID(PID);
                    cp.setAddress(address);
                    cp.setType(type);
                    cp.setPropertyValue(inputToInteger(propertyValue));
                    cp.setLandArea(inputToInteger(landArea));

                    // add new CommercialParcel object to commercialMap
                    commercialMap.put(cp.getParcelID(), cp);
                }
            }

            // close CSV file
            in.close();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            System.err.println("Caught IOException while opening " + CSV_INPUT_FILE +
                    ex.getMessage());
            ex.printStackTrace();
        }

    }

    // accessor methods for Parcel HashMaps
    public LinkedHashMap<String, Parcel> getResidentialMap(){return residentialMap;}
    public LinkedHashMap<String, Parcel> getCommercialMap(){return commercialMap;}


}