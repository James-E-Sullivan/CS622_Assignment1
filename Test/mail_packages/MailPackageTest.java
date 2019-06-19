package mail_packages;

import IO.PackageDeliveryIO;

import java.util.ArrayList;

public class MailPackageTest {

    // Info from MailPackage objects (from Shipment_Table.csv) displayed on console
    public static void main(String[] args) {
        PackageDeliveryIO packageIn = new PackageDeliveryIO();
        packageIn.read_CSV_File();
        ArrayList<MailPackage> packageList = packageIn.getPackageList();

        for (MailPackage mp : packageList){
            mp.display();
        }
    }
}
