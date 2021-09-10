package finalprojectpaint_v1;

import java.awt.*;
import java.util.ArrayList;

public class Eraser extends GeometricShape implements Cloneable {

    public ArrayList<Integer> xCoordinates = new ArrayList<>();
    public ArrayList<Integer> yCoordinates = new ArrayList<>();

  
    public Eraser(CoordinatePoint point1, int stroke) {
        super(Color.white);
        this.setPoint1(point1);
        this.setStroke(stroke);
    }

    public Eraser() {
    }
    @Override
    public void draw(Graphics g,boolean f) {
        int arrayListSize = this.xCoordinates.size();
        int[] x = new int[arrayListSize];
        int[] y = new int[arrayListSize];

        g.setColor(Color.white);
        if (this.getStroke() < 10) {
            ((Graphics2D) g).setStroke(new BasicStroke(10));
        }

        for (int j = 0; j < arrayListSize; j++) {
            x[j] = this.xCoordinates.get(j);
            y[j] = this.yCoordinates.get(j);
        }

        g.drawPolyline(x, y, arrayListSize);
        ((Graphics2D) g).setStroke(new BasicStroke(PaintBoard.currentStroke));
        g.setColor(PaintBoard.currentColor);
    }

    @Override
    public boolean select(int x, int y) {
        return false;
    }

    @Override
    public void resize(GeometricShape geometricShape) { }

    @Override
    public void move(GeometricShape geometricShape) { }

    @Override
    public void fill(GeometricShape geometricShape) { }


}
