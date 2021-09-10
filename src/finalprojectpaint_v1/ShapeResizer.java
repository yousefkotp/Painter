package finalprojectpaint_v1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShapeResizer{

    public ShapeResizer(){ }

    public void resize(MouseEvent e){


        for (int i = PaintBoard.shapes.size() - 1; i >= 0; i--) {
            GeometricShape shape = PaintBoard.shapes.get(i);

            if(shape instanceof ClearedScreen)
                break; // Perform resize on all objects in "shapes" after the last clearedScreen instance

            PaintBoard.p1 = new CoordinatePoint(shape.getPoint1().getX(), shape.getPoint1().getY());
            PaintBoard.p2 = new CoordinatePoint(shape.getPoint2().getX(), shape.getPoint2().getY());

            if (shape instanceof LineSegment) {
                LineSegment line = (LineSegment) shape;
                if (line.select(e.getX(), e.getY())) {
                    line.resize(shape);
                    break;
                }
            } else if (shape instanceof Rectangle) {
                Rectangle xr = (Rectangle) shape;
                if (xr.select(e.getX(), e.getY())) {
                    xr.resize(shape);
                    break;
                }
            } else if (shape instanceof Square) {
                Square xs = (Square) shape;
                if (xs.select(e.getX(), e.getY())) {
                    xs.resize(shape);
                    break;
                }
            } else if (shape instanceof Circle) {
                Circle xc = (Circle) shape;
                if (xc.select(e.getX(), e.getY())) {
                    xc.resize(shape);
                    break;
                }
            } else if (shape instanceof Triangle) {
                Triangle xt = (Triangle) shape;
                if (xt.select(e.getX(), e.getY())) {
                    xt.resize(shape);
                    break;
                }
            }
        }

    }

}
