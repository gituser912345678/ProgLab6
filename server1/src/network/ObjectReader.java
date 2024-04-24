package network;

import collectionManager.StartCommand;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.channels.SocketChannel;

public class ObjectReader {
    ObjectInputStream userRequest;
    Request request;
    Respons respons;

    public Respons objectReader(ObjectInputStream userRequest, StartCommand startCommand) throws IOException, ClassNotFoundException, UnknowElementException, NoElementException {

        request = (Request) userRequest.readObject();
        respons = startCommand.startExecute(request);

        return respons;

    }
}
