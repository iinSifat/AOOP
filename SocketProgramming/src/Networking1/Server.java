package Networking1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(32222);
        System.out.println("Networking1.Server started.");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

            try {
                Object msg = ois.readObject();
                System.out.println((String) msg);
            } catch (Exception e) {
            }


        }
    }
}