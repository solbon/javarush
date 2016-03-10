package tests.DataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by solbon on 12.01.2015.
 */
public class Jukebox1 {
    List<String> sondList = new ArrayList<>();

    public static void main(String[] args) {
        Jukebox1 jukebox = new Jukebox1();
        jukebox.go();
    }

    public void go() {
        getSongs();
        System.out.println(sondList);
    }

    private void getSongs() {
        try {
            File file = new File("D:/songs.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String song = null;
            while ((song = reader.readLine()) != null) {
                addSong(song);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        sondList.add(tokens[0]);
    }

}
