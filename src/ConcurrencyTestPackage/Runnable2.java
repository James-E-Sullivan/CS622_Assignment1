package ConcurrencyTestPackage;

public class Runnable2 implements Runnable {

    @Override
    public void run() {

        System.out.println("\nStart Thread 2\n");

        for(int i=200; i<300; i++){
            System.out.println(i);
        }

        System.out.println("\nEnd Thread 2\n");
    }
}
