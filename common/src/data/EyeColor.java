package data;

import java.io.Serial;
import java.io.Serializable;

public enum EyeColor implements Serializable {
    GREEN,
    BLACK,
    YELLOW,
    WHITE,
    BROWN;
    @Serial
    private final static long serialVersionUID = 339L;
}
