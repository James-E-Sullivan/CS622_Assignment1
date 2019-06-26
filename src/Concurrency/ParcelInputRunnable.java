package Concurrency;

import IO.ParcelIO;
import IO.Parcel_CSV_Input;
import parcels.Parcel;

import java.util.LinkedHashMap;

public class ParcelInputRunnable implements Runnable{

    @Override
    public void run() {
        rwParcels();
    }

    /**
     * Reads Parcel info from csv file
     * Writes Parcels to Parcel object output file
     */
    private void rwParcels(){
        Parcel_CSV_Input parcelInput = new Parcel_CSV_Input();
        parcelInput.read_CSV_File();
        LinkedHashMap<String, Parcel> parcelMap = parcelInput.getParcelMap();
        ParcelIO.writeParcel(parcelMap);
    }
}
