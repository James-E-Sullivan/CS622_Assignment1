package mail_packages;

import IO.Package_CSV_Input;

import java.util.ArrayList;

public class MailPackageTest {

    // Info from MailPackage objects (from Shipment_Table.csv) displayed on console
    public static void main(String[] args) {
        Package_CSV_Input packageIn = new Package_CSV_Input();
        packageIn.read_CSV_File();
        ArrayList<MailPackage> packageList = packageIn.getPackageList();

        for (MailPackage mp : packageList){
            mp.display();
        }
    }
}
