package tests.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by solbon on 27.02.2015.
 */
public class ConnectionTest {
    static List<User> users = new ArrayList<>();
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:db2://localhost:50000/sample";
        Connection conn = DriverManager.getConnection(url, "solbon", "ldar1702");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from org");

        while (rs.next()) {
            int deptNumb = rs.getInt("deptNumb");
            String deptName = rs.getString("deptName");
            int manager = rs.getInt("manager");
            String division = rs.getString("division");
            String location = rs.getString("location");

            User user = new User(deptNumb, deptName, manager, division, location);
            users.add(user);
        }

        for (User user : users) {
            System.out.println(user);
        }

    }
}
