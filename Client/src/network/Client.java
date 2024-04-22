package network;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

public class Client {
    ObjectOutputStream serverWriter;
    ObjectInputStream serverReader;
    Socket clientSocekt;

    public Respons sendRequest(Request request) throws IOException, ClassNotFoundException {
        this.openClientSocet();
        serverWriter.writeObject(request);
        serverWriter.flush();
        Respons respons = (Respons) serverReader.readObject();
        this.closeClientSocet();
        return respons;
    }

    private void openClientSocet() throws IOException {
        int port;
        String host;

        Properties props = new Properties();
        props.load(new FileInputStream("C:\\Users\\USER\\IdeaProjects\\Client\\src\\res.properties"));
        port = Integer.parseInt(props.getProperty("port"));
        host = String.valueOf(props.getProperty("host"));
        try {
            clientSocekt = new Socket(host, port);
            serverWriter = new ObjectOutputStream(clientSocekt.getOutputStream());
            serverReader = new ObjectInputStream(clientSocekt.getInputStream());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void closeClientSocet() throws IOException {
        clientSocekt.close();
        serverWriter.close();
        serverReader.close();
    }

}
