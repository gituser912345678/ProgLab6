package network;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Client {
    ObjectOutputStream serverWriter;
    ObjectInputStream serverReader;
    Socket clientSocekt;
    Properties props = new Properties();

    public Respons sendRequest(Request request) throws IOException, ClassNotFoundException {
        this.openClientSocet();
        serverWriter.writeObject(request);
        serverWriter.flush();
        Respons respons = (Respons) serverReader.readObject();
        this.closeClientSocet();
        return respons;
    }

    private void openClientSocet() throws IOException {
        final int port;
        final String host;

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("res.properties");

        this.props.load(in);
        port = Integer.parseInt(this.props.getProperty("port"));
        host = String.valueOf(this.props.getProperty("host"));
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
