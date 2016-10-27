package tests.Exceptions;

/**
 * Created by solbon on 25.11.2014.
 */
public class App00 {
    public static void main(String[] args) {
        try {
            int i = 1;
            int j = 0;
            System.out.println(i/j);
        }
        catch (Exception e) {
//            System.out.println(e.printStackTrace());
//            e.printStackTrace();
            System.err.println(e.getCause().getMessage());
        }
        finally {
            System.err.println("finally");
//            return;
        }
    }
}
