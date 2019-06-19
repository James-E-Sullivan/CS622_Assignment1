package database;

import IO.Parcel_CSV_Input;
import parcels.Parcel;
import java.util.ArrayList;

public class ParcelTableMain {

    public static void Parcel_DB_Output(){

        Parcel_CSV_Input parcelData = new Parcel_CSV_Input();

        ParcelTableSQL parcelDB = new ParcelTableSQL("Parcels");


        try{
            // obtain iterable records from csv file
            System.out.println("*** Initializing Parcel Table");
            //records = parcelData.getCSVRecords();

            ArrayList<Parcel> allParcels = parcelData.readParcelFromFile();

            // initialize parcel table
            parcelDB.initFullParcelTable();

            for (Parcel p : allParcels){
                parcelDB.insertParcelObject(p);
            }

            parcelDB.selectByPropertyValue(100000000);

        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        finally{
            ConnectionFactory.shutdownDerby();
        }

    }

    // for testing
    public static void main(String[] args) {

        Parcel_DB_Output();

    }





}
