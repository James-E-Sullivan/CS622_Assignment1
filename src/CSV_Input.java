import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import parcels.CommercialParcel;
import parcels.Parcel;
import parcels.ResidentialParcel;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class CSV_Input {

    private static HashMap<String, ResidentialParcel> residentialMap = new HashMap<>();
    private static HashMap<String, CommercialParcel> commercialMap = new HashMap<>();

    // default constructor
    public CSV_Input(){}

    //String[] CSV_HEADERS = {};

    public void read_CSV_File() throws IOException{

        Reader in = new FileReader("resources/Parcels_2016_Data_Full.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);

        for(CSVRecord record : records){

            if(record.get(11).contains("Residential")){
                ResidentialParcel rp = new ResidentialParcel();
                rp.setParcelID(record.get(3));  // sets parcelID
                rp.setAddress(record.get(58));  // set address
                rp.setType(record.get(11));     // sets type to listed land use
                rp.setPropertyValue(record.get(19));
                rp.setLandArea(record.get(21));
                rp.setLivingArea(record.get(25));
                rp.setBedrooms(record.get(32));

                // add new ResidentialParcel object to residentialMap
                residentialMap.put(rp.getParcelID(), rp);
            }
            else if(record.get(11).contains("Commercial")){
                CommercialParcel cp = new CommercialParcel();
                cp.setParcelID(record.get(3));
                cp.setAddress(record.get(58));
                cp.setPropertyValue((record.get(19)));
                cp.setLandArea(record.get(21));

                // add new CommercialParcel object to commercialMap
                commercialMap.put(cp.getParcelID(), cp);
            }
        }
    }

    // accessor methods for Parcel HashMaps
    public HashMap<String, ResidentialParcel> getResidentialMap(){return residentialMap;}
    public HashMap<String, CommercialParcel> getCommercialMap(){return commercialMap;}

    /*
    public static void main(String[] args) throws IOException {
        read_CSV_File();

        for(ResidentialParcel rp : residentialMap.values()){
            System.out.println();
            rp.display();
        }

        for(CommercialParcel cp : commercialMap.values()){
            System.out.println();
            cp.display();
        }
    }

     */


}
