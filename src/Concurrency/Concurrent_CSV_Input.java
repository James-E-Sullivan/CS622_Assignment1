package Concurrency;

import IO.PackageIO;
import IO.ParcelIO;
import mail_packages.MailPackage;
import parcels.Parcel;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Concurrent_CSV_Input {

    public static void main(String[] args) throws InterruptedException{

        // instantiate runnable objects
        ParcelInputRunnable parcelRun = new ParcelInputRunnable();
        PackageInputRunnable packageRun = new PackageInputRunnable();
        ParcelSearchRunnable searchRun = new ParcelSearchRunnable();

        // create threads for runnable objects
        Thread parcelThread = new Thread(parcelRun);
        Thread packageThread = new Thread(packageRun);
        Thread searchThread = new Thread(searchRun);

        // start threads
        parcelThread.start();
        packageThread.start();
        searchThread.start();

        // join threads to main
        parcelThread.join();
        packageThread.join();
        searchThread.join();

        // main thread: obtain Parcel and Package objects from .dat files
        ArrayList<MailPackage> packageFileList = PackageIO.readPackage();
        LinkedHashMap<String, Parcel> parcelFileMap = ParcelIO.readParcel();

        // main thread: check for matching PID values between Package and Parcel objects
        int matchCount = 0;

        for (Parcel p : parcelFileMap.values()){
            for (MailPackage mp : packageFileList){
                if (p.getParcelID().equals(mp.getPID())){
                    matchCount++;
                    System.out.println("Matching Parcel (" + matchCount + "): " + p.getAddress());
                }
            }
        }

        System.out.println("Total number of matches: " + matchCount);

        System.out.println("\nEnd main thread\n");


    }

}
