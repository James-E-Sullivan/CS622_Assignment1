package Concurrency;

import IO.Parcel_CSV_Input;

public class ParcelInputRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("\nStarting Parcel CSV Thread\n");

        Parcel_CSV_Input parcelInput = new Parcel_CSV_Input();
        parcelInput.read_CSV_File();

        System.out.println("\nEnding Parcel CSV Thread\n");
    }
}
