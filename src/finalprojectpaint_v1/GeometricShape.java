package finalprojectpaint_v1;

import java.awt.*;


public abstract class GeometricShape implements Cloneable {

    private Color color;
    private CoordinatePoint point1;
    private CoordinatePoint point2;
    private int stroke;
    private boolean isFilled;
    private GeometricShape previousShape = null;

    public GeometricShape(Color color) {
        this.color = color;
    }


    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public GeometricShape(boolean isFilled, Color color, CoordinatePoint point1, CoordinatePoint point2, int stroke) {
        this.isFilled = isFilled;
        this.color = color;
        this.point1 = point1;
        this.point2 = point2;
        this.stroke = stroke;
        this.previousShape = null;
    }


    public GeometricShape(Color color, CoordinatePoint point1, CoordinatePoint point2) {
        this.color = color;
        this.point1 = point1;
        this.point2 = point2;
    }

    public GeometricShape(CoordinatePoint point1, CoordinatePoint point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public GeometricShape() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CoordinatePoint getPoint1() {
        return point1;
    }

    public void setPoint1(CoordinatePoint point1) {
        this.point1 = point1;
    }

    public CoordinatePoint getPoint2() {
        return point2;
    }

    public void setPoint2(CoordinatePoint point2) {
        this.point2 = point2;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public int getStroke() {
        return stroke;
    }

    public void setPreviousShape(GeometricShape nextShape) {
        this.previousShape = nextShape;
    }

    public GeometricShape getPreviousShape() {
        return previousShape;
    }

    public abstract void draw(Graphics g, boolean isFilled);
    public abstract boolean select(int x,int y);
    public abstract void resize(GeometricShape geometricShape);
    public abstract void move(GeometricShape geometricShape);
    public abstract void fill(GeometricShape geometricShape);

}
