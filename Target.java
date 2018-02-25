import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.Serializable;
/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends GameObjects implements Serializable
{
    /**
     * Act - do whatever the Target wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean firstAct;
    public boolean isHit = false;
    
    public Target() {
        this.firstAct = true;
    }
    
    public void drawTarget() {
        
        GreenfootImage bg = new GreenfootImage(60, 60);
        bg.clear();
        bg.setColor(new Color(255,0,0,255));
        bg.fillOval(0, 0, 60, 60);
        bg.setColor(new Color(255,255,255,255));
        bg.fillOval(10,10,40,40);
        bg.setColor(new Color(255,0,0,255));
        bg.fillOval(20,20,20,20);
        bg.scale(45, 45);
        this.setImage(bg);
    }
    
    public void redraw() {
        this.drawTarget();
    }
    
    private void putIntoStage() {
        this.getWorldOfType(Stage.class).targets.add(this);
    }
    
    public void hit() {
        this.isHit = true;
        //Sound
    }
    
    public void act() 
    {
        if (this.firstAct == true) {
            this.drawTarget();
            this.putIntoStage();
            this.firstAct = false;
        }
        
        // Add your action code here.
    }    
}
