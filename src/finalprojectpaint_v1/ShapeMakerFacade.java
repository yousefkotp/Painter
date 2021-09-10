/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;

import java.awt.Graphics;

/**
 *
 * @author Mohamed Farid
 */
public class ShapeMakerFacade {

    private Circle circle;
    private Triangle triangle;
    private Square square;
    private LineSegment lineSegment;
    private Rectangle rectangle;
    private ClearedScreen clearedScreen;

    public ShapeMakerFacade(Circle c) {
        circle = c;
    }

    public ShapeMakerFacade(Triangle t) {
        triangle = t;
    }

    public ShapeMakerFacade(Square s) {
        square = s;
    }

    public ShapeMakerFacade(LineSegment l) {
        lineSegment = l;
    }

    public ShapeMakerFacade(Rectangle r) {
        rectangle = r;
    }

    public ShapeMakerFacade(ClearedScreen cs){
        clearedScreen = cs;
    }

    
    public void drawCircle(Graphics g, Boolean x) {
        circle.draw(g, x);
    }

    public void drawRectangle(Graphics g, Boolean x) {
        rectangle.draw(g, x);
    }

    public void drawSquare(Graphics g, Boolean x) {
        square.draw(g, x);
    }

    public void drawLineSegment(Graphics g, Boolean x) {
        lineSegment.draw(g, x);
    }

    public void clearScreen(Graphics g){
        clearedScreen.draw(g, true);
    }

    public void drawTriangle(Graphics g, Boolean x) {
        triangle.draw(g, x);
    }
}
