package ConcurrencyTestPackage;

public class Runnable2 implements Runnable {

    @Override
    public void run() {

        System.out.println("\nStart Thread 2\n");

        for(int i=2000; i<3000; i++){
            System.out.println(i);
        }

        System.out.println("\nEnd Thread 2\n");
    }
}
