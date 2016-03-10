package tests.JDBC;

/**
 * Created by solbon on 27.02.2015.
 */
public class User {
    private int deptNum;
    private String deptName;
    private int manager;
    private String division;
    private String location;

    public User(int deptNum, String deptName, int manager, String division, String location) {
        this.deptNum = deptNum;
        this.deptName = deptName;
        this.manager = manager;
        this.division = division;
        this.location = location;
    }

    public String toString() {
        String result = "";
        if (deptName.length() < 8)
            result =  deptNum + "\t" + deptName + "\t\t\t" + manager + "\t" + division + "\t\t" + location;
        else if (deptName.length() < 12)
            result =  deptNum + "\t" + deptName + "\t\t" + manager + "\t" + division + "\t" + location;
        else if (deptName.length() < 90)
            result =  deptNum + "\t" + deptName + "\t" + manager + "\t" + division + "\t" + location;

        return result;

    }
}
