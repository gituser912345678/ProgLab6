package network;

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
    public void openStreams(SocketChannel socket) throws IOException {
        userRequest = new ObjectInputStream(socket.socket().getInputStream());
        toUser = new ObjectOutputStream(socket.socket().getOutputStream());
    }

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
        Request request;
        Respons respons;
        openStreams(socket);
        StartCommand startCommand = new StartCommand();

        try {
            request = (Request) userRequest.readObject();
            respons = startCommand.startExecute(request);
            toUser.writeObject(respons);

            toUser.flush();

        } catch (ClassNotFoundException | InvalidClassException | NotSerializableException | UnknowElementException |
                 NoElementException exception) {
            System.out.println(exception.getMessage());
        } finally {
            socket.close();
        }


    }

    private void openServerSocket() throws IOException {
        int port;

        Properties props = new Properties();
        props.load(new FileInputStream("C:\\Users\\USER\\IdeaProjects\\server1\\src\\res.properties"));
        port = Integer.parseInt(props.getProperty("port"));

        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
        } catch (IOException exception) {
            System.out.println("Проблема подключения сервера");
        }
    }
}
