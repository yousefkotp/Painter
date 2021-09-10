package finalprojectpaint_v1;

import java.awt.event.MouseEvent;

public class ShapeFiller {

    public ShapeFiller(){ }

    public  void fillShape(MouseEvent e){

        for (int i = PaintBoard.shapes.size() - 1; i >= 0; i--) {
            GeometricShape shape = PaintBoard.shapes.get(i);

            if (shape instanceof Rectangle) {
                Rectangle xr = (Rectangle) shape;
                if (xr.select(e.getX(), e.getY())) {
                    xr.fill(shape);
                    break;
                }
            } else if (shape instanceof Square) {
                Square xs = (Square) shape;
                if (xs.select(e.getX(), e.getY())) {
                    xs.fill(shape);
                    break;
                }
            } else if (shape instanceof Triangle) {
                Triangle xt = (Triangle) shape;
                if (xt.select(e.getX(), e.getY())) {
                    xt.fill(shape);
                    break;
                }
            } else if (shape instanceof Circle) {
                Circle xc = (Circle) shape;
                if (xc.select(e.getX(), e.getY())) {
                    xc.fill(shape);
                    break;
                }
            } else if (shape instanceof ClearedScreen) {
                break;
            }
        }

    }

}
