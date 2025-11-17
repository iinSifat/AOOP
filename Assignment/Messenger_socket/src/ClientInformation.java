import java.net.Socket;

public class ClientInformation {
    private final Socket socket;
    private final String name;

    public ClientInformation(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        return name;
    }
}
