package finalprojectpaint_v1;

import java.awt.*;

public class ClearedScreen extends GeometricShape {

    @Override
    public void draw(Graphics g,boolean f) {
        ((Graphics2D) g).setStroke(new BasicStroke(1));
        g.setColor(Color.white);
        g.fillRect(0, 0, PaintBoard.paintBoardSize.width, PaintBoard.paintBoardSize.height);
        g.setColor(PaintBoard.currentColor);
        ((Graphics2D) g).setStroke(new BasicStroke(PaintBoard.currentStroke));
    }
    public ClearedScreen() {

    }

    public static void clearScreen() {
        ClearedScreen clearedScreen = new ClearedScreen();
        PaintBoard.done.add(clearedScreen);
        PaintBoard.shapes.add(clearedScreen);
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
