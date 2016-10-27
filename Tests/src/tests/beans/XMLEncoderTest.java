package tests.beans;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by sdaribazaron on 2016-03-30.
 */
public class XMLEncoderTest {
    public static void main(String[] args) throws FileNotFoundException {
        PersonBean person = new PersonBean("John", "Smith", 35);

        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("C:\\tmp\\PersonBean.xml")));
        encoder.writeObject(person);
        encoder.close();

        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("C:\\tmp\\PersonBean.xml")));
        PersonBean bean = (PersonBean) decoder.readObject();

        System.out.println(bean);

    }
}
