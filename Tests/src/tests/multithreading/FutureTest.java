package tests.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Solbon Daribazaron <s.daribazaron@visiona.pl>
 */
public class FutureTest {

    public static void main(String[] args) {

        //Build a task and an executor
        MyTask task = new MyTask(2, 0);
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();

        try {
            //Compute the task in a separate thread
            int result = (int) threadExecutor.submit(task).get();
            System.out.println("The result is " + result);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (ExecutionException e) {
            System.out.println(e);
            //Handle the exception thrown by the child thread
            if (e.getMessage().contains("cannot devide by zero"))
                System.out.println("error in child thread caused by zero division");
        } catch (InterruptedException e) {
            //This exception is thrown if the child thread is interrupted.
            e.printStackTrace();
        }
    }

}

class MyTask implements Callable<Integer> {

    private int numerator;
    private int denominator;

    public MyTask(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }

    @Override
    //The call method may throw an exception
    public Integer call()  {
        if (denominator == 0)
            throw new RuntimeException("cannot devide by zero");
        else
            return numerator/denominator;
    }
}