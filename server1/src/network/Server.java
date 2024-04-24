package network;

import collectionManager.StartCommand;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Properties;

public class Server {
    private ServerSocketChannel serverSocketChannel;
    ObjectInputStream userRequest;
    ObjectOutputStream toUser;
    Properties props = new Properties();

    public void start() {

        try {
            openServerSocket();
            while (true) {
                SocketChannel clientSocket = serverSocketChannel.accept();
                if (clientSocket != null) {

                    clientRequest(clientSocket);
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void clientRequest(SocketChannel socket) throws IOException {

        try {

            userRequest = new ObjectInputStream(socket.socket().getInputStream());
            toUser = new ObjectOutputStream(socket.socket().getOutputStream());

            StartCommand startCommand = new StartCommand();
            ObjectReader objectReader = new ObjectReader();
            ObjectWriter objectWriter = new ObjectWriter();

            objectWriter.writeObject(toUser, objectReader.objectReader(userRequest, startCommand));

        } catch (ClassNotFoundException | InvalidClassException | NotSerializableException | UnknowElementException |
                 NoElementException exception) {
            System.out.println(exception.getMessage());
        } finally {
            socket.close();
        }

    }

    private void openServerSocket() throws IOException {
        final int port;

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("res.properties");

        this.props.load(in);
        port = Integer.parseInt(this.props.getProperty("port"));

        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
        } catch (IOException exception) {
            System.out.println("Проблема подключения сервера");
        }
    }
}
