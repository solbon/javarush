package tests.jmx.servercontroller;

//import com.juriy.mbeans.*;
import javax.management.*;
import java.util.concurrent.*;
import java.util.*;
import java.lang.management.*;
/**
* @author Yuriy Bura
* @version $Id: $
*/
/**
 * Created by sdaribazaron on 2016-03-08.
 */
public class TestServer {
    private ThreadPoolExecutor executor;
    private int rejected = 0;

    public TestServer(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    private static class Task implements Runnable {
        public void run() {
            Random random = new Random();
            int numLoops = Math.abs(random.nextInt()%5);
            for (int i = 0; i < numLoops; i++) {
                try {
                    System.out.println("Running in [" + Thread.currentThread().getName() + "]");
                    Thread.sleep(Math.abs(random.nextInt()%5000));
                } catch(Exception e) {
                    System.out.println("Interrupted");
                }
            }
        }
    }

    public void runServer()	{
        executor.prestartAllCoreThreads();
        while (true) {
            try {
                executor.execute(new Task());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            } catch(RejectedExecutionException e) {
            rejected++;
        }
    }
}

    public ThreadPoolExecutor getExecutor()	{
        return executor;
    }

    public int getRejected() {
        return rejected;
    }

    public void flushRejected() {
        rejected = 0;
    }

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, 10, 10L,
                TimeUnit.SECONDS,
                new SynchronousQueue < Runnable > ()
        );
        executor.prestartAllCoreThreads();
        TestServer server = new TestServer(executor);

        ServerController serverController = new ServerController(server);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.juriy.mbeans:type=ServerController");
        mbs.registerMBean(serverController, name);

        server.runServer();
    }
}
