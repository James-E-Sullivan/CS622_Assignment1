package database;

import IO.PackageDeliveryIO;
import mail_packages.MailPackage;

import java.util.ArrayList;

public class PackageTableMain {

    public static void Package_DB_Output(){

        PackageDeliveryIO packageData = new PackageDeliveryIO();

        PackageTableSQL packageDB = new PackageTableSQL("Packages");

        try{

            System.out.println("*** Initializing Package Table");

            packageData.read_CSV_File();
            ArrayList<MailPackage> allPackages = packageData.getPackageList();

            packageDB.init();

            for (MailPackage mp : allPackages){
                packageDB.insert(mp);
            }

            packageDB.select();
        }
        catch (NumberFormatException ex){
            System.out.println("NumberFormatException");
            ex.printStackTrace();
        }
        finally{
            ConnectionFactory.shutdownDerby();
        }

    }

    // for testing
    public static void main(String[] args) {

        Package_DB_Output();

    }

}
