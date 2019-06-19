package IO;

import mail_packages.MailPackage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class PackageDeliveryIO {

    // constant used for CSV file
    final private String PACKAGE_INPUT_FILE = "resources/Shipment_Table.csv";

    // output list for MailPackage objects
    private ArrayList<MailPackage> packageList = new ArrayList<>();

    // default constructor
    public PackageDeliveryIO(){}

    public void read_CSV_File(){

        try{
            Reader in = new FileReader(PACKAGE_INPUT_FILE);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(in);

            for (CSVRecord record : records){

                // obtain string values from applicable columns
                String shipper = record.get(0);
                String origination = record.get(1);
                String address = record.get(2);
                String weight = record.get(3);

                // create new MailPackage object to store above values
                MailPackage mp = new MailPackage();

                // set String variables
                mp.setShipper(shipper);
                mp.setOrigination(origination);
                mp.setAddress(address);

                // set Double variable
                mp.setWeight(Double.parseDouble(weight));

                // add MailPackage object to packageList
                packageList.add(mp);
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("File Not Found");
            ex.printStackTrace();
        }
        catch (IOException ex){
            System.out.println("Caught IOException while opening " + PACKAGE_INPUT_FILE);
            ex.printStackTrace();
        }

    }

    // accessor method for packageList
    public ArrayList<MailPackage> getPackageList(){return packageList;}

}
