package ConcurrencyTestPackage;

public class ConcurrencyTest {


    public static void main(String[] args) throws InterruptedException{

        Runnable1 r1 = new Runnable1();
        Runnable2 r2 = new Runnable2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

}
