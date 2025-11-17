package Networking1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Client started.");
        Thread.sleep(2000);
        Socket socket = new Socket("127.0.0.1",32222);
        System.out.println("Client Connected.");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        oos.writeObject(msg);
    }
}
