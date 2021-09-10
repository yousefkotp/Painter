/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpaint_v1;


public class Observer {
    
    
    public void update(){
    Screenshotter screenshotter = Screenshotter.createScreenshotter();
    screenshotter.screenShot();
    }
    
    
}
