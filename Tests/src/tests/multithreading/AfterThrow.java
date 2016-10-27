package tests.multithreading;

/**
 * @author Solbon Daribazaron <s.daribazaron@visiona.pl>
 */
public class AfterThrow {
    public static void main(String[] args) throws Exception{
        try {
            if (true) throw new RuntimeException("this is Exception");
            System.out.println("after throw new");    // unreachable
        } catch (RuntimeException e) {
            System.out.println("in catch before throw");
            throw e;
//            System.out.println("in catch after throw");   // unreachable
        }
        System.out.println("after try-catch block");

    }
}
