/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;

import javax.sound.sampled.Line;
import java.awt.*;

public class LineSegment extends GeometricShape implements Cloneable {

    public LineSegment(Color color) {
        super(color);
    }

    public LineSegment(boolean x, Color color, CoordinatePoint point1, CoordinatePoint point2, int stroke) {
        super(x,color, point1, point2, stroke);
    }

    public LineSegment(CoordinatePoint point1, CoordinatePoint point2) {
        super(point1, point2);
    }

    public LineSegment() { }

    @Override
    public void draw(Graphics g,boolean f) {
        g.drawLine(this.getPoint1().getX(), this.getPoint1().getY(), this.getPoint2().getX(), this.getPoint2().getY());
    }


    @Override
    public boolean select(int x, int y) {
        int x1 = this.getPoint1().getX() + 5, x2 = this.getPoint1().getX() - 5, x3 = this.getPoint2().getX() - 5, x4 = this.getPoint2().getX() + 5;
        int y1 = this.getPoint1().getY() + 5, y2 = this.getPoint1().getY() - 5, y3 = this.getPoint2().getY() - 5, y4 = this.getPoint2().getY() + 5;

        Polygon p = new Polygon(new int[]{x1, x2, x3, x4}, new int[]{y1, y2, y3, y4}, 4);
        return p.contains(x,y);
    }


    @Override
    public void resize(GeometricShape shape){

        LineSegment line = (LineSegment) shape;
            PaintBoard.newShape = new LineSegment(
                    line.isFilled(), line.getColor(), PaintBoard.p1, PaintBoard.p2, line.getStroke());
            PaintBoard.newShape.setPreviousShape(line);
            PaintBoard.shapes.remove(shape);
            PaintBoard.done.add(PaintBoard.newShape);
            PaintBoard.shapes.add(PaintBoard.newShape);
    }

    @Override
    public void move(GeometricShape shape){
        LineSegment line = (LineSegment) shape;

        PaintBoard.p1 = new CoordinatePoint(line.getPoint1().getX(), line.getPoint1().getY());
        PaintBoard.p2 = new CoordinatePoint(line.getPoint2().getX(), line.getPoint2().getY());
        PaintBoard.newShape = new LineSegment(
                line.isFilled(), line.getColor(), PaintBoard.p1, PaintBoard.p2, line.getStroke());
        PaintBoard.newShape.setPreviousShape(line);

        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);

    }

    @Override
    public void fill(GeometricShape geometricShape) { }


    @Override
    protected Object clone() throws CloneNotSupportedException{
      LineSegment c=(LineSegment) super.clone();
      c.setPoint1((CoordinatePoint)c.getPoint1().clone());
      c.setPoint2((CoordinatePoint)c.getPoint2().clone());
      c.setColor(null);
      c.setColor(this.getColor());
      
        
    
    return c;
    
    
}
}
