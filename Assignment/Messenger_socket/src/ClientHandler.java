import java.io.*;
import java.util.List;

public class ClientHandler implements Runnable {
    private final ClientInformation clientInfo;
    private final List<ClientInformation> clientList;
    private final List<String> msg_history;

    public ClientHandler(ClientInformation clientInfo, List<ClientInformation> clientList, List<String> messageHistory) {
        this.clientInfo = clientInfo;
        this.clientList = clientList;
        this.msg_history = messageHistory;
    }

    private static void SaveEvents(String event) {
        try (FileWriter fw = new FileWriter("events.txt", true)) {
            fw.write(event + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientInfo.getSocket().getInputStream())); BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientInfo.getSocket().getOutputStream()))) {

            // Send previous messages to the new client
            sendPreviousMessages(out);

            String message;
            while ((message = in.readLine()) != null) {
                String fullMessage = clientInfo.getName() + ": " + message;

                // Log and broadcast the message
                System.out.println(fullMessage);
                SaveEvents(fullMessage);
                broadcastMessage(fullMessage);
            }
        } catch (IOException e) {
            System.out.println(clientInfo.getName() + " disconnected.");
            SaveEvents(clientInfo.getName() + " disconnected.");
        } finally {
            // Remove client from the list and close the socket
            synchronized (clientList) {
                clientList.remove(clientInfo);
            }
            try {
                clientInfo.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendPreviousMessages(BufferedWriter bufferedWriter) throws IOException {
        synchronized (msg_history) {
            for (String message : msg_history) {
                bufferedWriter.write(message + System.lineSeparator());
            }
            bufferedWriter.flush();
        }
    }

    private void broadcastMessage(String message) {
        synchronized (clientList) {
            msg_history.add(message);
            for (ClientInformation client : clientList) {
                if (!client.equals(clientInfo)) { //was giving thyself msg
                    try {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getSocket().getOutputStream()));
                        writer.write(message + System.lineSeparator());
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        SaveEvents("Error broadcasting to " + client.getName() + ": " + e.getMessage());
                    }
                }
            }
        }
    }
}
