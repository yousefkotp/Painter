package finalprojectpaint_v1;

import java.awt.event.MouseEvent;

public class ShapeCopier {

    public void copy(MouseEvent e){

        PaintBoard.p3 = new CoordinatePoint(e.getX(), e.getY());

        for (int i = PaintBoard.shapes.size() - 1; i >= 0; i--) {
            GeometricShape shape= PaintBoard.shapes.get(i);

            if(shape instanceof ClearedScreen)
                break;
            if (shape instanceof LineSegment) {
                LineSegment line = (LineSegment) shape;
                if (line.select(e.getX(), e.getY())) {
                    PaintBoard.copiedShape = new LineSegment(
                            line.isFilled(),line.getColor(),line.getPoint1(),line.getPoint2(),line.getStroke());
                    break;
                }
            } else if (shape instanceof Rectangle) {
                Rectangle xs = (Rectangle) shape;
                if (xs.select(e.getX(), e.getY())) {
                    PaintBoard.copiedShape = new Rectangle(
                            xs.isFilled(),xs.getColor(),xs.getPoint1(),xs.getPoint2(),xs.getStroke());
                    break;
                }
            } else if (shape instanceof Square) {
                Square xs = (Square) shape;
                if (xs.select(e.getX(), e.getY())) {
                    PaintBoard.copiedShape = new Square(
                            xs.isFilled(),xs.getColor(),xs.getPoint1(),xs.getPoint2(),xs.getStroke());
                    break;
                }
            } else if (shape instanceof Triangle) {
                Triangle xt = (Triangle) shape;
                if (xt.select(e.getX(), e.getY())) {
                    PaintBoard.copiedShape = new Triangle(
                            xt.isFilled(),xt.getColor(),xt.getPoint1(),xt.getPoint2(), xt.getPoint3(), xt.getStroke());
                    PaintBoard.tmpPt= xt.getPoint3();
                    break;
                }
            } else if (shape instanceof Circle) {
                Circle xc = (Circle) shape;
                if (xc.select(e.getX(), e.getY())) {
                    PaintBoard.copiedShape = new Circle(
                            xc.isFilled(),xc.getColor(),xc.getPoint1(),xc.getPoint2(),xc.getStroke());
                    break;
                }
            }
        }

    }

    public void paste(MouseEvent e){

        if (PaintBoard.copiedShape != null) {

            if (PaintBoard.copiedShape instanceof LineSegment) {
                try {
                    LineSegment line = (LineSegment) ((LineSegment) PaintBoard.copiedShape).clone();

                    line.setPoint1(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint1().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint1().getY() + (e.getY() - PaintBoard.p3.getY())));
                    line.setPoint2(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint2().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint2().getY() + (e.getY() - PaintBoard.p3.getY())));

                    PaintBoard.done.add(line);
                    PaintBoard.shapes.add(line);
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    //
                }
            } else if (PaintBoard.copiedShape instanceof Rectangle) {
                try {
                    Rectangle rectangle = (Rectangle) ((Rectangle) PaintBoard.copiedShape).clone();

                    rectangle.setPoint1(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint1().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint1().getY() + (e.getY() - PaintBoard.p3.getY())));
                    rectangle.setPoint2(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint2().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint2().getY() + (e.getY() - PaintBoard.p3.getY())));

                    PaintBoard.done.add(rectangle);
                    PaintBoard.shapes.add(rectangle);
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    //
                }
            } else if (PaintBoard.copiedShape instanceof Square) {
                try {
                    Square square = (Square) ((Square) PaintBoard.copiedShape).clone();

                    square.setPoint1(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint1().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint1().getY() + (e.getY() - PaintBoard.p3.getY())));
                    square.setPoint2(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint2().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint2().getY() + (e.getY() - PaintBoard.p3.getY())));

                    PaintBoard.done.add(square);
                    PaintBoard.shapes.add(square);
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    //
                }
            } else if (PaintBoard.copiedShape instanceof Circle) {
                try {
                    Circle circle = (Circle) ((Circle) PaintBoard.copiedShape).clone();

                    circle.setPoint1(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint1().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint1().getY() + (e.getY() - PaintBoard.p3.getY())));
                    circle.setPoint2(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint2().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint2().getY() + (e.getY() - PaintBoard.p3.getY())));

                    PaintBoard.done.add(circle);
                    PaintBoard.shapes.add(circle);
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    //
                }
            } else if (PaintBoard.copiedShape instanceof Triangle) {
                try {
                    Triangle triangle = (Triangle) ((Triangle) PaintBoard.copiedShape).clone();

                    triangle.setPoint1(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint1().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint1().getY() + (e.getY() - PaintBoard.p3.getY())));
                    triangle.setPoint2(
                            new CoordinatePoint(PaintBoard.copiedShape.getPoint2().getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.copiedShape.getPoint2().getY() + (e.getY() - PaintBoard.p3.getY())));

                    triangle.setPoint3(
                            new CoordinatePoint(
                                    PaintBoard.tmpPt.getX() + (e.getX() - PaintBoard.p3.getX()),
                                    PaintBoard.tmpPt.getY() + (e.getY() - PaintBoard.p3.getY())));
                    PaintBoard.done.add(triangle);
                    PaintBoard.shapes.add(triangle);

//                    Triangle tx = (Triangle) ((Triangle) copiedShape).clone();
//                    done.add(tx);
//                    tx.setPoint1(new CoordinatePoint(copiedShape.getPoint1().getX() + (e.getX() - p3.getX()), copiedShape.getPoint1().getY() + (e.getY() - p3.getY())));
//                    tx.setPoint2(new CoordinatePoint(copiedShape.getPoint2().getX() + (e.getX() - p3.getX()), copiedShape.getPoint2().getY() + (e.getY() - p3.getY())));
//                    tx.setPoint3(new CoordinatePoint(tmpPt.getX() + (e.getX() - p3.getX()), tmpPt.getY() + (e.getY() - p3.getY())));
//                    shapes.add(tx);

                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    //
                }
            }
        }

    }

}
