import java.io.*;
import java.net.*;
import java.util.*;

public class MessengerServer {
    private static int clientCounter = 0;
    private static final List<ClientInformation> clientList = new ArrayList<>();
    private static final List<String> msg_history = new ArrayList<>();
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            SaveEvents("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                String clientName = "Client-" + clientCounter++;

                ClientInformation clientInfo = new ClientInformation(clientSocket, clientName);
                clientList.add(clientInfo);

                System.out.println(clientName + " connected.");
                SaveEvents(clientName + " connected.");

                // Start a new thread for the connected client
                ClientHandler clientHandler = new ClientHandler(clientInfo, clientList, msg_history);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            SaveEvents("Error: " + e.getMessage());
        }
    }
    private static void SaveEvents(String event) {
        try
        {
            FileWriter fw = new FileWriter("events.txt", true);
            fw.write(event + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
