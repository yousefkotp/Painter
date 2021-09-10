/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;

import java.awt.*;


public class Rectangle extends GeometricShape implements Cloneable{

    public Rectangle(Color color) {
        super(color);
    }

    public Rectangle(boolean x, Color color, CoordinatePoint point1, CoordinatePoint point2, int stroke) {
        super(x,color, point1, point2, stroke);
    }

    public Rectangle(CoordinatePoint point1, CoordinatePoint point2) {
        super(point1, point2);
    }

    public Rectangle() {

    }


    @Override
    public void draw(Graphics g,boolean x) {
        if(!x){
            if (this.getPoint2().getX() > this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //1st Quad
            {
                g.drawRect(this.getPoint1().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //2nd Quad
            {
                g.drawRect(this.getPoint2().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() > this.getPoint1().getY()) { //3rd Quad
                g.drawRect(this.getPoint2().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else {
                g.drawRect(this.getPoint1().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            }

        }else{
            if (this.getPoint2().getX() > this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //1st Quad
            {
                g.fillRect(this.getPoint1().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //2nd Quad
            {
                g.fillRect(this.getPoint2().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() > this.getPoint1().getY()) { //3rd Quad
                g.fillRect(this.getPoint2().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else {
                g.fillRect(this.getPoint1().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            }
        }


    }
    @Override
    public boolean select(int x,int y) {
        int x1 = this.getPoint1().getX() , x2 = this.getPoint2().getX();
        int y1 = this.getPoint1().getY() , y2 = this.getPoint2().getY();

        java.awt.Rectangle r = new java.awt.Rectangle(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x2-x1),Math.abs(y2-y1));
        return r.contains(x,y);
    }

    public void setPoint2(int x, int y) {
        this.setPoint2(x,y);
    }

    @Override
    public void resize(GeometricShape shape){

        Rectangle rectangle = (Rectangle) shape;
        PaintBoard.newShape = new Rectangle(
                rectangle.isFilled(), rectangle.getColor(), PaintBoard.p1, PaintBoard.p2, rectangle.getStroke());
        PaintBoard.newShape.setPreviousShape(rectangle);
        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);
    }


    @Override
    public void move(GeometricShape shape){
        Rectangle rectangle = (Rectangle) shape;

        PaintBoard.p1 = new CoordinatePoint(rectangle.getPoint1().getX(), rectangle.getPoint1().getY());
        PaintBoard.p2 = new CoordinatePoint(rectangle.getPoint2().getX(), rectangle.getPoint2().getY());
        PaintBoard.newShape = new Rectangle(
                rectangle.isFilled(), rectangle.getColor(), PaintBoard.p1, PaintBoard.p2, rectangle.getStroke());
        PaintBoard.newShape.setPreviousShape(rectangle);

        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);

    }

    @Override
    public void fill(GeometricShape shape) {
        Rectangle rectangle = (Rectangle) shape;

        PaintBoard.selectedShape = new Rectangle(
                true, PaintBoard.currentColor, rectangle.getPoint1(), rectangle.getPoint2(), rectangle.getStroke());
        PaintBoard.selectedShape.setPreviousShape(rectangle);
        PaintBoard.done.add(PaintBoard.selectedShape);
        PaintBoard.shapes.add(PaintBoard.selectedShape);
        PaintBoard.shapes.remove(rectangle);
    }


    @Override
    protected Object clone() throws CloneNotSupportedException{
      Rectangle c=(Rectangle) super.clone();
      c.setPoint1((CoordinatePoint)c.getPoint1().clone());
      c.setPoint2((CoordinatePoint)c.getPoint2().clone());
      c.setColor(null);
      c.setColor(this.getColor());
      c.setPreviousShape(this.getPreviousShape());
      c.setFilled(this.isFilled());

    return c;
    }
}
