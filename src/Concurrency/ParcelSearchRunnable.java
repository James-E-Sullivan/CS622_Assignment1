package Concurrency;

import search.ParcelSearch;

public class ParcelSearchRunnable implements Runnable {

    @Override
    public void run() {
        search();
    }

    public void search(){
        ParcelSearch.searchIO();
    }
}
