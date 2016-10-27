/*
import java.sql.*;


public class DbConn
{
    public static void main(String argv[])
    {
        try
        {
            Db  db = new Db(argv);

            System.out.println();
            System.out.println(
                    "THIS SAMPLE SHOWS " +
                            "HOW TO CONNECT TO/DISCONNECT FROM DATABASES.");

            System.out.println();
            System.out.println(
                    "----------------------------------------------------------\n" +
                            "USE JAVA 2 CLASSES:\n" +
                            "  Connection\n" +
                            "  DriverManager\n" +
                            "TO CONNECT TO/DISCONNECT FROM A DATABASE.");

            // connect to the 'sample' database
            db.connect();

            // disconnect from the 'sample' database
            db.disconnect();
        }
        catch (Exception e)
        {
            JdbcException jdbcExc = new JdbcException(e);
            jdbcExc.handle();
        }
    } // main
} // DbConn

*/