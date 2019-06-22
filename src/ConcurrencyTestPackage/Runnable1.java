package ConcurrencyTestPackage;

public class Runnable1 implements Runnable {

    @Override
    public void run() {

        System.out.println("\nStart Thread 1\n");

        for(int i=100; i<200; i++){
            System.out.println(i);
        }

        System.out.println("\nEnd Thread 1\n");
    }
}
