package Concurrency;

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

        System.out.println("\nEnd main thread\n");


    }

}
