package Concurrency;

import search.ParcelSearch;

public class ParcelSearchRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("\nStarting Parcel Search Thread\n");

        ParcelSearch.searchIO();

        System.out.println("\nEnding Parcel Search Thread\n");
    }
}
