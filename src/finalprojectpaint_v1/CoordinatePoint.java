package finalprojectpaint_v1;


public class CoordinatePoint implements Cloneable {

    private int x;
    private int y;

    public CoordinatePoint() {

    }

    public CoordinatePoint(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        CoordinatePoint p = (CoordinatePoint) super.clone();
        return p;
    }
    
    

}
