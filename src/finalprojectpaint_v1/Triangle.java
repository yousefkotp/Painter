/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;

import java.awt.*;


public class Triangle extends GeometricShape implements Cloneable{

    private CoordinatePoint Point3;


    public Triangle(boolean x, Color currentColor, CoordinatePoint p1, CoordinatePoint p2, CoordinatePoint p3, int stroke) {
        super(x,currentColor, p1, p2, stroke);
        this.Point3 = p3;
    }

    public CoordinatePoint getPoint3() {
        return Point3;
    }

    public void setPoint3(CoordinatePoint Point3) {
        this.Point3 = Point3;
    }

    public Triangle() { }

    @Override
    public void draw(Graphics g,boolean f) {
        if(!f){
            int[] x = {this.getPoint1().getX(), this.getPoint2().getX(), this.getPoint3().getX()};
            int[] y = {this.getPoint1().getY(), this.getPoint2().getY(), this.getPoint3().getY()};
            g.drawPolygon(x, y, 3);
        }else{
            int[] x = {this.getPoint1().getX(), this.getPoint2().getX(), this.getPoint3().getX()};
            int[] y = {this.getPoint1().getY(), this.getPoint2().getY(), this.getPoint3().getY()};
            g.fillPolygon(x, y, 3);
        }


    }
    @Override
    public boolean select(int x,int y) {
        int x1 = this.getPoint1().getX() , x2 = this.getPoint2().getX() , x3 = this.getPoint3().getX();
        int y1 = this.getPoint1().getY() , y2 = this.getPoint2().getY() , y3 = this.getPoint3().getY();

        Polygon p = new Polygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        return p.contains(x,y);
    }


    @Override
    public void resize(GeometricShape shape){

        Triangle triangle = (Triangle) shape;
        PaintBoard.newShape = new Triangle(
                triangle.isFilled(), triangle.getColor(), PaintBoard.p1, PaintBoard.p2, triangle.getPoint3(),triangle.getStroke());
        PaintBoard.newShape.setPreviousShape(triangle);
        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);
    }


    @Override
    public void move(GeometricShape shape){
        Triangle triangle = (Triangle) shape;

        PaintBoard.p1 = new CoordinatePoint(triangle.getPoint1().getX(), triangle.getPoint1().getY());
        PaintBoard.p2 = new CoordinatePoint(triangle.getPoint2().getX(), triangle.getPoint2().getY());
        PaintBoard.tmpPt = new CoordinatePoint(triangle.getPoint3().getX(), triangle.getPoint3().getY());

        PaintBoard.newShape = new Triangle(
                triangle.isFilled(), triangle.getColor(), triangle.getPoint1(), triangle.getPoint2(),triangle.getPoint3(), triangle.getStroke());
        PaintBoard.newShape.setPreviousShape(triangle);

        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);
    }

    @Override
    public void fill(GeometricShape shape) {
        Triangle t = (Triangle) shape;

        PaintBoard.selectedShape = new Triangle(
                true, PaintBoard.currentColor, t.getPoint1(), t.getPoint2(), t.getPoint3(), t.getStroke());
        PaintBoard.selectedShape.setPreviousShape(t);
        PaintBoard.done.add(PaintBoard.selectedShape);
        PaintBoard.shapes.add(PaintBoard.selectedShape);
        PaintBoard.shapes.remove(t);
    }


    @Override
    protected Object clone() throws CloneNotSupportedException{
      Triangle c=(Triangle) super.clone();
      c.setPoint1((CoordinatePoint)c.getPoint1().clone());
      c.setPoint2((CoordinatePoint)c.getPoint2().clone());
      c.setPoint3((CoordinatePoint)c.getPoint3().clone());
      c.setColor(null);
      c.setColor(this.getColor());
      
        
    
    return c;
    }
}
