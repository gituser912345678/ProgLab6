package data;

import java.io.Serial;
import java.io.Serializable;

public class Coordinates implements Serializable {
    @Serial
    private final static long serialVersionUID = 335L;
    private Double x; //Поле не может быть null
    private int y;
    public Coordinates(Double x, int y){
        this.x = x;
        this.y = y;
    }
}
