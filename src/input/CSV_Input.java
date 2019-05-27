package input;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import parcels.CommercialParcel;
import parcels.Parcel;
import parcels.ResidentialParcel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class CSV_Input {

    // Constant used for CSV file
    final private String CSV_INPUT_FILE = "resources/Parcels_2016_Data_Full.csv";

    // HashMaps for Res & Comm Parcels, with PID/Parcel pairs
    private static HashMap<String, Parcel> residentialMap = new HashMap<>();
    private static HashMap<String, Parcel> commercialMap = new HashMap<>();

    // default constructor
    public CSV_Input(){}

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

                // creates new ResidentialParcel object, sets values, and adds it to residentialMap
                if(record.get(11).contains("Residential")){

                    //Create ResidentialParcel object (removed unnecessary downcasting)
                    ResidentialParcel rp = new ResidentialParcel();

                    //set ResidentialParcel variables
                    rp.setParcelID(record.get(3));
                    rp.setAddress(record.get(58));
                    rp.setType(record.get(11));
                    rp.setPropertyValue(record.get(19));
                    rp.setLandArea(record.get(21));
                    rp.setLivingArea(record.get(25));
                    rp.setBedrooms(record.get(32));

                    // add new ResidentialParcel object to residentialMap
                    residentialMap.put(rp.getParcelID(), rp);
                }

                // creates new CommercialParcel object, sets values, adds it to CommercialMap
                else if(record.get(11).contains("Commercial")){

                    // create CommercialParcel object without using downcasting
                    CommercialParcel cp = new CommercialParcel();

                    // set CommercialParcel variables
                    cp.setParcelID(record.get(3));
                    cp.setAddress(record.get(58));
                    cp.setPropertyValue((record.get(19)));
                    cp.setLandArea(record.get(21));

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
    public HashMap<String, Parcel> getResidentialMap(){return residentialMap;}
    public HashMap<String, Parcel> getCommercialMap(){return commercialMap;}


}
