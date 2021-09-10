/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;

public class ShapeFactory {
    //0 for line, 1 for rectangle, 2 for square, 3 for triangle, 4 for circle, 5 for free paint, 6 for eraser,7 for resize

    public GeometricShape CreateShape(int mode) {
        if (mode == 0) {
            return new LineSegment();
        } else if (mode == 1) {
            return new Rectangle();
        } else if (mode == 2) {
            return new Square();
        } else if (mode == 3) {
            return new Triangle();
        } else if (mode == 4) {
            return new Circle();
        } else if (mode == 5) {
            return new FreePaint();
        } else if (mode == 6) {
            return new Eraser();
        } else {
            return null;
        }
    }

}
