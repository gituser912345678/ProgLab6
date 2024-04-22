package data;

import java.io.Serial;
import java.io.Serializable;

public enum Country implements Serializable {
    UNITED_KINGDOM,
    CHINA,
    VATICAN,
    THAILAND,
    NORTH_KOREA;
    @Serial
    private final static long serialVersionUID = 337L;
}
