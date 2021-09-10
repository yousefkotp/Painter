/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Dimension;

public class Screenshotter {

    private static Screenshotter screenshotter = null;

    private Screenshotter() {

    }

    public static Screenshotter createScreenshotter() {
        if (screenshotter == null) {
            screenshotter = new Screenshotter();
        }
        
        return screenshotter;
    
    } 

    public void screenShot() {
        try {
            Robot robot = new Robot();
            Dimension screenSize = PaintBoard.jFrameToolkit.getScreenSize();
            Rectangle rect = new Rectangle(0, 0, screenSize.width, screenSize.height);
            BufferedImage ss = robot.createScreenCapture(rect);
            ImageIO.write(ss, "JPG", new File("Screenshot.jpg"));

        } catch (Exception e) {

            System.out.println("File Not Found");
        }

    }

}
