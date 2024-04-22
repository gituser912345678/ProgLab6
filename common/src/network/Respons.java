package network;

import java.io.Serial;
import java.io.Serializable;

public class Respons implements Serializable {
    @Serial
    private final static long serialVersionUID = 10L;
    private String message;

    public Respons(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
