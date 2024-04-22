package data;

import java.io.Serial;
import java.io.Serializable;

public class Location implements Serializable {
    @Serial
    private final static long serialVersionUID = 501L;
    private double x;
    private long y;
    private int z;

    public Location(double x, long y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(long y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
