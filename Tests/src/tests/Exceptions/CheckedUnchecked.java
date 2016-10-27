package tests.Exceptions;

import java.sql.SQLException;

/**
 * @author Solbon Daribazaron <s.daribazaron@visiona.pl>
 */
public class CheckedUnchecked {
    public static void main(String[] args) throws SQLException {
//        if (true) throw new SQLException("This is SQLException");
        throw new RuntimeException("This is RuntimeException");
    }
}
