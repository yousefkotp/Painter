/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;

import java.awt.*;


public class Circle extends GeometricShape implements Cloneable {

    public Circle(Color color) {
        super(color);
    }

    public Circle(boolean x, Color color, CoordinatePoint point1, CoordinatePoint point2, int stroke) {
        super(x,color, point1, point2, stroke);
    }

    public Circle(CoordinatePoint point1, CoordinatePoint point2) {
        super(point1, point2);
    }

    public Circle() {
    }

    @Override
    public void draw(Graphics g,boolean x) {
        if(!x){
            if (this.getPoint2().getX() > this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //1st Quad
            {
                g.drawOval(this.getPoint1().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY())//2nd Quad
            {
                g.drawOval(this.getPoint2().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() > this.getPoint1().getY()) //3rd Quad
            {
                g.drawOval(this.getPoint2().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else {
                g.drawOval(this.getPoint1().getX(), this.getPoint1().getY(), this.getPoint2().getX() - this.getPoint1().getX(), this.getPoint2().getX() - this.getPoint1().getX());
            }
        }else{
            if (this.getPoint2().getX() > this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //1st Quad
            {
                g.fillOval(this.getPoint1().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY())//2nd Quad
            {
                g.fillOval(this.getPoint2().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() > this.getPoint1().getY()) //3rd Quad
            {
                g.fillOval(this.getPoint2().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else {
                g.fillOval(this.getPoint1().getX(), this.getPoint1().getY(), this.getPoint2().getX() - this.getPoint1().getX(), this.getPoint2().getX() - this.getPoint1().getX());
            }
        }

    }
    @Override
    public boolean select(int x,int y) {
        int x1 = this.getPoint1().getX() , x2 = this.getPoint2().getX();
        int y1 = this.getPoint1().getY() , y2 = this.getPoint2().getY();

        java.awt.Rectangle r = new java.awt.Rectangle(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x2-x1),Math.abs(x2-x1));
        return r.contains(x,y);
    }

    @Override
    public void resize(GeometricShape shape){

        Circle circle = (Circle) shape;
        PaintBoard.newShape = new Circle(
                circle.isFilled(), circle.getColor(), PaintBoard.p1, PaintBoard.p2, circle.getStroke());
        PaintBoard.newShape.setPreviousShape(circle);
        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);
    }


    @Override
    public void move(GeometricShape shape){
        Circle circle = (Circle) shape;

        PaintBoard.p1 = new CoordinatePoint(circle.getPoint1().getX(), circle.getPoint1().getY());
        PaintBoard.p2 = new CoordinatePoint(circle.getPoint2().getX(), circle.getPoint2().getY());
        PaintBoard.newShape = new Circle(
                circle.isFilled(), circle.getColor(), PaintBoard.p1, PaintBoard.p2, circle.getStroke());
        PaintBoard.newShape.setPreviousShape(circle);

        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);

    }

    @Override
    public void fill(GeometricShape shape) {
        Circle circle = (Circle) shape;

        PaintBoard.selectedShape = new Circle(
                true, PaintBoard.currentColor, circle.getPoint1(), circle.getPoint2(), circle.getStroke());
        PaintBoard.selectedShape.setPreviousShape(circle);
        PaintBoard.done.add(PaintBoard.selectedShape);
        PaintBoard.shapes.add(PaintBoard.selectedShape);
        PaintBoard.shapes.remove(circle);
    }


    @Override
    protected Object clone() throws CloneNotSupportedException{
      Circle c=(Circle) super.clone();
      c.setPoint1((CoordinatePoint)c.getPoint1().clone());
      c.setPoint2((CoordinatePoint)c.getPoint2().clone());
      c.setColor(null);
      c.setColor(this.getColor());
      
        
    
    return c;
    
    
}


}
