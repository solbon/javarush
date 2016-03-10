package tests.Sockets;

import java.net.*;
import java.io.*;

/**
 * Created by solbon on 09.01.2015.
 */
public class DailyAdviceServer {
    String[] advices = {"first advice", "second advice", "3rd advice"};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * advices.length);
        return advices[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
