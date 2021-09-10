package finalprojectpaint_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PaintBoard extends JPanel implements MouseListener, MouseMotionListener {

    // Global Variables
    public static CoordinatePoint p1, p2, p3, tmpPt;
    public static int found; //TODO: check uses for found and delete if redundant


    // Containers
    public static ArrayList<GeometricShape> shapes = new ArrayList<>();
    public static Stack<GeometricShape> done = new Stack<>();
    public static Stack<GeometricShape> redo = new Stack<>();


    // State variables
    public static Color currentColor = Color.BLACK;
    public static int currentStroke = 1;
    private int state;
    public static int currentMode = 5;
    /* Mode Numbers:
    * 0 for line segment , 1 for rectangle , 2 for square , 3 for triangle , 4 for circle
    * 5 for free paint , 6 for eraser , 7 for resize , 8 for move , 9 for copy
    * 10 for paste , 11 for fill
    * */


    // Global references
    public static GeometricShape oldShape = null;
    public static GeometricShape newShape = null;
    public static GeometricShape selectedShape = null;
    public static GeometricShape copiedShape = null;
    public static ShapeFactory shapeFactory = new ShapeFactory();
    private final Observer observer = new Observer();


    // Utility variables
    public static Dimension paintBoardSize;
    public static Toolkit jFrameToolkit;


    /*                           Observer Methods                                */
    public int getState() {
        return state;
    }

    public void notifyallObservers() {
        observer.update();
    }

    public void setState(int state) {
        this.state = state;
        notifyallObservers();
    }
    //****************************************************************************//


    //Constructor for paint board instance
    public PaintBoard() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    // Called by repaint() method. Refreshes the paint board and keeps it up to date.
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enable antialiasing
        Iterator<GeometricShape> it = shapes.iterator(); // Implementation of Iterator design pattern

        while (it.hasNext()) {

            GeometricShape tempShape = it.next();
            g.setColor(tempShape.getColor());
            ((Graphics2D) g).setStroke(new BasicStroke(tempShape.getStroke()));

            if (tempShape instanceof LineSegment) {
                ShapeMakerFacade smfl = new ShapeMakerFacade((LineSegment) tempShape);
                smfl.drawLineSegment(g, tempShape.isFilled());

            } else if (tempShape instanceof Rectangle) {
                ShapeMakerFacade smfr = new ShapeMakerFacade((Rectangle) tempShape);
                smfr.drawRectangle(g, tempShape.isFilled());

            } else if (tempShape instanceof Square) {
                ShapeMakerFacade smf = new ShapeMakerFacade((Square) tempShape);
                smf.drawSquare(g, tempShape.isFilled());

            } else if (tempShape instanceof Circle) {
                ShapeMakerFacade smfc = new ShapeMakerFacade((Circle) tempShape);
                smfc.drawCircle(g, tempShape.isFilled());

            } else if (tempShape instanceof Triangle) {
                ShapeMakerFacade smft = new ShapeMakerFacade((Triangle) tempShape);
                smft.drawTriangle(g, tempShape.isFilled());

            } else if (tempShape instanceof ClearedScreen) {
                paintBoardSize = getSize();
                ShapeMakerFacade smfcs = new ShapeMakerFacade((ClearedScreen) tempShape);
                smfcs.clearScreen(g);

            } else if (tempShape instanceof FreePaint) {
                tempShape.draw(g, false);

            } else if (tempShape instanceof Eraser) {
                tempShape.draw(g, false);
            }
        }
    }


    // Set state after every action performed on the board. For implementing Observer design pattern
    @Override
    public void mouseReleased(MouseEvent e) {
        setState(1);
    }

    // Used to construct new shape instances or perform actions like move, copy, resize, etc.
    @Override
    public void mousePressed(MouseEvent e) {

        selectedShape = null;
        oldShape = null;
        newShape = null;

        switch (currentMode) {

            case 0: // Create line segment

                p1 = new CoordinatePoint(e.getX(), e.getY());

                // Implementation of Factory design pattern
                LineSegment l = (LineSegment) shapeFactory.CreateShape(0);
                l.setColor(currentColor);
                l.setPoint1(p1);
                l.setPoint2(p1);
                l.setStroke(currentStroke);

                shapes.add(l);
                done.add(l);
                break;

            case 1: // Create rectangle

                p1 = new CoordinatePoint(e.getX(), e.getY());

                // Implementation of Factory design pattern
                Rectangle r = (Rectangle) shapeFactory.CreateShape(1);
                r.setColor(currentColor);
                r.setPoint1(p1);
                r.setPoint2(p1);
                r.setStroke(currentStroke);

                shapes.add(r);
                done.add(r);
                break;

            case 2: // Create square

                p1 = new CoordinatePoint(e.getX(), e.getY());

                // Implementation of Factory design pattern
                Square s = (Square) shapeFactory.CreateShape(2);
                s.setColor(currentColor);
                s.setPoint1(p1);
                s.setPoint2(p1);
                s.setStroke(currentStroke);

                shapes.add(s);
                done.add(s);
                break;

            case 3: // Create triangle

                p1 = new CoordinatePoint(e.getX(), e.getY());

                // Implementation of Factory design pattern
                Triangle t = (Triangle) shapeFactory.CreateShape(3);
                t.setColor(currentColor);
                t.setPoint1(p1);
                t.setPoint2(p1);
                t.setPoint3(p1);
                t.setStroke(currentStroke);

                shapes.add(t);
                done.add(t);
                break;

            case 4: // Create circle

                p1 = new CoordinatePoint(e.getX(), e.getY());

                // Implementation of Factory design pattern
                Circle c = (Circle) shapeFactory.CreateShape(4);
                c.setColor(currentColor);
                c.setPoint1(p1);
                c.setPoint2(p1);
                c.setStroke(currentStroke);

                shapes.add(c);
                done.add(c);
                break;

            case 5: // Free paint

                p1 = new CoordinatePoint(e.getX(), e.getY());

                // Implementation of Factory design pattern
                FreePaint freePaint = (FreePaint) shapeFactory.CreateShape(5);
                freePaint.setColor(currentColor);
                freePaint.setPoint1(p1);
                freePaint.setStroke(currentStroke);

                shapes.add(freePaint);
                done.add(freePaint);
                break;

            case 6: // Create eraser

                p1 = new CoordinatePoint(e.getX(), e.getY());

                // Implementation of Factory design pattern
                Eraser eraser = (Eraser) shapeFactory.CreateShape(6);
                eraser.setPoint1(p1);
                eraser.setStroke(currentStroke);

                shapes.add(eraser);
                done.add(eraser);
                break;

            case 7: // Resize

                ShapeResizer shapeResizer = new ShapeResizer();
                shapeResizer.resize(e);
                break;

            case 8: // Move

                ShapeMover shapeMover = new ShapeMover();
                shapeMover.move(e);
                break;

            case 9: // Copy

                ShapeCopier shapeCopier = new ShapeCopier();
                shapeCopier.copy(e);
                break;

            case 10: // Paste

                ShapeCopier shapeCopier1 = new ShapeCopier();
                shapeCopier1.paste(e);
                break;

            case 11: // Fill

                ShapeFiller shapeFiller = new ShapeFiller();
                shapeFiller.fillShape(e);
                break;
        }
        repaint();
    }



    @Override
    public void mouseDragged(MouseEvent e) {

        if (currentMode >= 0 && currentMode < 7) {
            p2 = new CoordinatePoint(e.getX(), e.getY());
            p3 = new CoordinatePoint(e.getX(), e.getY());
            GeometricShape s = shapes.get(shapes.size() - 1);
            if (s instanceof LineSegment) {
                LineSegment l = (LineSegment) s;
                l.setPoint2(p2);
            } else if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                r.setPoint2(p2);
            } else if (s instanceof Square) {
                Square square = (Square) s;
                square.setPoint2(p2);
            } else if (s instanceof Circle) {
                Circle c = (Circle) s;
                c.setPoint2(p2);
            } else if (s instanceof Triangle) {
                Triangle t = (Triangle) s;
                p3.setY(t.getPoint1().getY());
                t.setPoint3(p3);
                p2.setX(p3.getX() - (p3.getX() - p1.getX()) / 2);
                p2.setY(e.getY());
                t.setPoint2(p2);
            } else if (s instanceof FreePaint) {
                FreePaint freePaint = (FreePaint) s;
                freePaint.xCoordinates.add(p2.getX());
                freePaint.yCoordinates.add(p2.getY());
                freePaint.setPoint2(p2);
            } else if (s instanceof Eraser) {
                Eraser eraser = (Eraser) s;
                eraser.xCoordinates.add(p2.getX());
                eraser.yCoordinates.add(p2.getY());
                eraser.setPoint2(p2);
            }
            repaint();
        } else if (currentMode == 7 && newShape != null) {//resize
            p2 = new CoordinatePoint(e.getX(), e.getY());
            p3 = new CoordinatePoint(e.getX(), e.getY());
            if (newShape instanceof LineSegment) {
                LineSegment l = (LineSegment) newShape;
                l.setPoint2(new CoordinatePoint(e.getX(), e.getY()));
            } else if (newShape instanceof Rectangle) {
                newShape.setPoint2(new CoordinatePoint(e.getX(), e.getY()));
            } else if (newShape instanceof Circle) {
                Circle c = (Circle) newShape;
                c.setPoint2(new CoordinatePoint(e.getX(), e.getY()));
            } else if (newShape instanceof Square) {
                Square sq = (Square) newShape;
                sq.setPoint2(new CoordinatePoint(e.getX(), e.getY()));
            } else if (newShape instanceof Triangle) {
                Triangle t = (Triangle) newShape;

                p3.setY(t.getPoint1().getY());
                t.setPoint3(p3);
                p2.setX(p3.getX() - (p3.getX() - p1.getX()) / 2);
                p2.setY(e.getY());
                t.setPoint2(p2);
            }
            repaint();
        } else if (currentMode == 8) {
            if (newShape instanceof LineSegment) {
                LineSegment l = (LineSegment) newShape;
                l.setPoint1(new CoordinatePoint(p1.getX() + (e.getX() - p3.getX()), p1.getY() + (e.getY() - p3.getY())));
                l.setPoint2(new CoordinatePoint(p2.getX() + (e.getX() - p3.getX()), p2.getY() + (e.getY() - p3.getY())));
            } else if (newShape instanceof Rectangle) {
                Rectangle r = (Rectangle) newShape;
                r.setPoint1(new CoordinatePoint(p1.getX() + (e.getX() - p3.getX()), p1.getY() + (e.getY() - p3.getY())));
                r.setPoint2(new CoordinatePoint(p2.getX() + (e.getX() - p3.getX()), p2.getY() + (e.getY() - p3.getY())));
            } else if (newShape instanceof Circle) {
                Circle c = (Circle) newShape;
                c.setPoint1(new CoordinatePoint(p1.getX() + (e.getX() - p3.getX()), p1.getY() + (e.getY() - p3.getY())));
                c.setPoint2(new CoordinatePoint(p2.getX() + (e.getX() - p3.getX()), p2.getY() + (e.getY() - p3.getY())));
            } else if (newShape instanceof Square) {
                Square sq = (Square) newShape;
                sq.setPoint1(new CoordinatePoint(p1.getX() + (e.getX() - p3.getX()), p1.getY() + (e.getY() - p3.getY())));
                sq.setPoint2(new CoordinatePoint(p2.getX() + (e.getX() - p3.getX()), p2.getY() + (e.getY() - p3.getY())));
            } else if (newShape instanceof Triangle) {
                Triangle t = (Triangle) newShape; //tmpPt -> point 3
                t.setPoint1(new CoordinatePoint(p1.getX() + (e.getX() - p3.getX()), p1.getY() + (e.getY() - p3.getY())));
                t.setPoint2(new CoordinatePoint(p2.getX() + (e.getX() - p3.getX()), p2.getY() + (e.getY() - p3.getY())));
                t.setPoint3(new CoordinatePoint(tmpPt.getX() + (e.getX() - p3.getX()), tmpPt.getY() + (e.getY() - p3.getY())));
            }
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) { }
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }


}
