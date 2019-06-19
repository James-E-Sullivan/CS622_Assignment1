package database;

import IO.CSV_Input;
import parcels.Parcel;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ParcelTableMain {

    private static void insertParcels(LinkedHashMap<String, Parcel> parcelMap){
        //ParcelTableSQL.insert("'0000000000'", "24 Beacon Street", "Commercial");

        for (Parcel p : parcelMap.values()){
            ParcelTableSQL.insert(p.getParcelID(), p.getAddress(), p.getType());
        }
    }

    private static void selectParcels(){
        ParcelTableSQL.selectAll();
    }

    public static void displayDB(LinkedHashMap<String, Parcel> parcelMap) {

        try{
            System.out.println("*** Initializing allparcels table");
            ParcelTableSQL.init();

            System.out.println("\n*** Insert records into allparcels table");
            insertParcels(parcelMap);

            System.out.println("\n*** Show contents in allparcels table");
            selectParcels();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            ConnectionFactory.shutdownDerby();
        }

    }


    public static void CSV_to_DB(){

        CSV_Input parcelData = new CSV_Input();

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

        CSV_to_DB();

    }





}
