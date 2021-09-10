package finalprojectpaint_v1;

import java.awt.event.MouseEvent;

public class ShapeMover {

    public ShapeMover(){}

    public void move(MouseEvent e){

        PaintBoard.p3 = new CoordinatePoint(e.getX(), e.getY());
        for (int i = PaintBoard.shapes.size() - 1; i >= 0; i--) {
            GeometricShape shape = PaintBoard.shapes.get(i);

            if(shape instanceof ClearedScreen)
                break; // Perform move on all objects in "shapes" after the last clearedScreen instance

            if (shape instanceof LineSegment) {
                LineSegment line = (LineSegment) shape;
                if (line.select(e.getX(), e.getY())) {
                    line.move(shape);
                    break;
                }
            } else if (shape instanceof Rectangle) {
                Rectangle xr = (Rectangle) shape;
                if (xr.select(e.getX(), e.getY())) {
                    xr.move(shape);
                    break;
                }
            } else if (shape instanceof Square) {
                Square xs = (Square) shape;
                if (xs.select(e.getX(), e.getY())) {
                    xs.move(shape);
                    break;
                }
            } else if (shape instanceof Triangle) {
                Triangle xt = (Triangle) shape;
                if (xt.select(e.getX(), e.getY())) {
                    xt.move(shape);
                    break;
                }
            } else if (shape instanceof Circle) {
                Circle xc = (Circle) shape;
                if (xc.select(e.getX(), e.getY())) {
                    xc.move(shape);
                    break;
                }
            }
        }


    }

}
