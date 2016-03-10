package tests;

/**
 * Created by solbon on 07.09.2014.
 */
import java.lang.Thread;
public class Hello {
    public static void main(String[] args) throws InterruptedException {
        HelloRunnable hello = new HelloRunnable();
        Thread t1 = new Thread(hello);
        Thread t2 = new Thread(hello);
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(500);
        t2.interrupt();
    }
    public static class HelloRunnable implements Runnable {
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + ": Hello!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

