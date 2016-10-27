package tests.multithreading;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by sdaribazaron on 2016-03-22.
 */
public class HighCPU {
        static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor( 1 );

        public static void main(String[] args) throws IOException
        {
            executor.setKeepAliveTime(30, TimeUnit.SECONDS);
            executor.allowCoreThreadTimeOut(true);
            executor.schedule( new Runnable(){

                @Override
                public void run()
                {
                    System.out.println( "END" );
                }

            }, 30, TimeUnit.SECONDS );
        }
}
