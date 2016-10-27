package tests.multithreading;

/**
 * Created by solbon on 10.01.2015.
 */
public class Locks implements Runnable {
    public static void main(String[] args) {
        Locks r1 = new Locks();
        Locks r2 = new Locks();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    private synchronized void go() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private  void foo() {
        System.out.println("this is foo function of thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        go();
        foo();
    }
}
