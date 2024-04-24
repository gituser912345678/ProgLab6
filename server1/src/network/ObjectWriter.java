package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.channels.SocketChannel;

public class ObjectWriter {
    ObjectOutputStream toUser;
    public void writeObject(ObjectOutputStream toUser, Respons respons) throws IOException {
        toUser.writeObject(respons);
        toUser.flush();
    }
}
