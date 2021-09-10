package finalprojectpaint_v1;

import java.awt.*;

public class Square extends GeometricShape implements Cloneable{

    public Square(Color color) {
        super(color);
    }

    public Square(boolean x, Color color, CoordinatePoint point1, CoordinatePoint point2, int stroke) {
        super(x,color, point1, point2, stroke);
    }

    public Square(CoordinatePoint point1, CoordinatePoint point2) {
        super(point1, point2);
    }

    public Square() {
    }

    @Override
    public void draw(Graphics g,boolean x) {
        if(!x){
            if (this.getPoint2().getX() > this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //1st Quad
            {
                g.drawRect(this.getPoint1().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY())//2nd Quad
            {
                g.drawRect(this.getPoint2().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() > this.getPoint1().getY()) //3rd Quad
            {
                g.drawRect(this.getPoint2().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else {
                g.drawRect(this.getPoint1().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            }
        }else{
            if (this.getPoint2().getX() > this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY()) //1st Quad
            {
                g.fillRect(this.getPoint1().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()), Math.abs(this.getPoint2().getY() - this.getPoint1().getY()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() < this.getPoint1().getY())//2nd Quad
            {
                g.fillRect(this.getPoint2().getX(), this.getPoint2().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else if (this.getPoint2().getX() < this.getPoint1().getX() && this.getPoint2().getY() > this.getPoint1().getY()) //3rd Quad
            {
                g.fillRect(this.getPoint2().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
            } else {
                g.fillRect(this.getPoint1().getX(), this.getPoint1().getY(), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()), Math.abs(this.getPoint2().getX() - this.getPoint1().getX()));
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

        Square square = (Square) shape;
        PaintBoard.newShape = new Square(
                square.isFilled(), square.getColor(), PaintBoard.p1, PaintBoard.p2, square.getStroke());
        PaintBoard.newShape.setPreviousShape(square);
        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);
    }



    @Override
    public void move(GeometricShape shape){
        Square square = (Square) shape;

        PaintBoard.p1 = new CoordinatePoint(square.getPoint1().getX(), square.getPoint1().getY());
        PaintBoard.p2 = new CoordinatePoint(square.getPoint2().getX(), square.getPoint2().getY());
        PaintBoard.newShape = new Square(
                square.isFilled(), square.getColor(), PaintBoard.p1, PaintBoard.p2, square.getStroke());
        PaintBoard.newShape.setPreviousShape(square);

        PaintBoard.shapes.remove(shape);
        PaintBoard.done.add(PaintBoard.newShape);
        PaintBoard.shapes.add(PaintBoard.newShape);

    }

    @Override
    public void fill(GeometricShape shape) {
        Square square = (Square) shape;

        PaintBoard.selectedShape = new Square(
                true, PaintBoard.currentColor, square.getPoint1(), square.getPoint2(), square.getStroke());
        PaintBoard.selectedShape.setPreviousShape(square);
        PaintBoard.done.add(PaintBoard.selectedShape);
        PaintBoard.shapes.add(PaintBoard.selectedShape);
        PaintBoard.shapes.remove(square);
    }


    @Override
    protected Object clone() throws CloneNotSupportedException{
      Square c=(Square) super.clone();
      c.setPoint1((CoordinatePoint)c.getPoint1().clone());
      c.setPoint2((CoordinatePoint)c.getPoint2().clone());
      c.setColor(null);
      c.setColor(this.getColor());
      
        
    
    return c;
    
    
}
}
