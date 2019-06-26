package ConcurrencyTestPackage;

public class Runnable1 implements Runnable {

    @Override
    public void run() {
        method1();
    }


    private void method1(){
        System.out.println("\nStart Thread 1\n");

        for(int i=1000; i<2000; i++){
            System.out.println(i);
        }

        System.out.println("\nEnd Thread 1\n");
    }

}
