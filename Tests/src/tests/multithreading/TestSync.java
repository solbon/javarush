package tests.multithreading;

/**
 * Created by solbon on 10.01.2015.
 */
public class TestSync implements Runnable{
    private int balance;
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.err.println("Balance is " + balance);
        }
    }

    private synchronized void increment() {
        int i = balance;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = i + 1;
    }
}

class TestSyncTest {
    public static void main(String[] args) {
        TestSync testSync = new TestSync();
        Thread a = new Thread(testSync);
        Thread b = new Thread(testSync);
        a.start();
        b.start();

    }
}
