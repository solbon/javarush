package tests.Serialization;

//import com.javarush.test.level16.lesson10.task03.Solution;

import java.io.*;

/**
 * Created by solbon on 23.12.2014.
 */
public class TestSerialization implements Serializable{
    int x;
    void setX(int i) {
        x = i;
    }

    public static void main(String[] args) throws IOException {
        TestSerialization ts1 = new TestSerialization();
        ts1.setX(10);
        FileOutputStream fos = new FileOutputStream("D:/ser.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ts1);
        oos.close();
    }
}
