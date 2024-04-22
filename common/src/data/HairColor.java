package data;

import java.io.Serial;
import java.io.Serializable;

public enum HairColor implements Serializable {
    RED(1),
    BLACK(2),
    YELLOW(3),
    WHITE(4),
    BROWN(5);
    @Serial
    private final static long serialVersionUID = 500L;
    private final int value;
    HairColor(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
