package tests.Threads;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Solbon Daribazaron <s.daribazaron@visiona.pl>
 */
public class ExecutorTest {
//    public static void main(String[] args) {
//        ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
//        ExecutorService es = new ScheduledThreadPoolExecutor(0);
//        System.out.println("Before");
//        es.execute(new Run1());
//        System.out.println("After");
//        es.shutdown();

        static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor( 0 );

    public static void main(String[] args) throws IOException
    {
        executor.schedule( new Runnable(){

            @Override
            public void run()
            {
                System.out.println( "END" );
            }

        }, 30, TimeUnit.SECONDS );
    }
}

class Run1 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Before run");
            Thread.sleep(3000);
            System.out.println("After run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
