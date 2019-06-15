package database;

import parcels.Parcel;

import java.sql.SQLException;
import java.util.LinkedHashMap;

public class DBMain {

    private static void insertParcels(LinkedHashMap<String, Parcel> parcelMap){
        //DBInput.insert("'0000000000'", "24 Beacon Street", "Commercial");

        for (Parcel p : parcelMap.values()){
            DBInput.insert(p.getParcelID(), p.getAddress(), p.getType());
        }
    }

    private static void selectParcels(){
        DBInput.select();
    }

    public static void displayDB(LinkedHashMap<String, Parcel> parcelMap) {

        try{
            System.out.println("*** Initializing allparcels table");
            DBInput.init();

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



}
