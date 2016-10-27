package tests.oop;

import java.io.*;

/**
 * Created by solbon on 10.09.2014.
 */
public class Wrapper {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        System.out.println(data);

        InputStream is = new ByteArrayInputStream(data.getBytes());
        System.setIn(is);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        while (true) {
            String line = reader.readLine();
//            if (line == null) break;
            if (line != null)
                System.out.println(line);
//        }
        reader.close();
        is.close();


    }
}
