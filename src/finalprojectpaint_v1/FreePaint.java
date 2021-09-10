package finalprojectpaint_v1;

import java.awt.*;
import java.util.ArrayList;

public class FreePaint extends GeometricShape {

    public ArrayList<Integer> xCoordinates = new ArrayList<>();
    public ArrayList<Integer> yCoordinates = new ArrayList<>();

   

    public FreePaint(Color color, CoordinatePoint point1, int stroke) {
        super(color);
        this.setPoint1(point1);
        this.setStroke(stroke);
    }

    public FreePaint() { }


    @Override
    public void draw(Graphics g,boolean f) {
        int arrayListSize = this.xCoordinates.size();
        int[] x = new int[arrayListSize];
        int[] y = new int[arrayListSize];

        for (int j = 0; j < arrayListSize; j++) {
            x[j] = this.xCoordinates.get(j);
            y[j] = this.yCoordinates.get(j);
        }
        g.drawPolyline(x, y, arrayListSize);
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
