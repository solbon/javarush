package tests.multithreading;

/**
 * Created by solbon on 10.01.2015.
 */
public class RunThreads implements Runnable{
    public static void main(String[] args) {
        Runnable runThreads = new RunThreads();
        Thread alpha = new Thread(runThreads);
        Thread beta = new Thread(runThreads);
        alpha.setName("поток альфа");
        beta.setName("поток бета");
        alpha.start();
        beta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("Сейчас работает " + Thread.currentThread().getName());
        }

    }
}
