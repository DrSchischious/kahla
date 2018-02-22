import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.Serializable;
/**
 * Write a description of class Checkpoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint extends GameObjects implements Serializable
{
    
    public boolean isChecked = false;
    private boolean firstAct = true;
    /**
     * Act - do whatever the Checkpoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Checkpoint() {
        int i = Greenfoot.getRandomNumber(5);
        this.drawCheckpoint(i);
    }
    
    public Checkpoint(int i) {
        if (i < 0 || i > 4) {
            this.drawCheckpoint(0);
        } else {
            this.drawCheckpoint(i);
        }
    }
    
    public void redraw() {
        this.drawCheckpoint(0);
    }
    
    private void putIntoStage() {
        this.getWorldOfType(Stage.class).checkpoints.add(this);
    }
    
    public void drawCheckpoint(int k) {
        GreenfootImage bg = new GreenfootImage("Checkpoint0"+(k+1)+".png");
        bg.scale(30, 30);
        this.setImage(bg);
        
    }
    
    public void check() {
        this.isChecked=true;
        //sound
        
    }
    
    public void act() 
    {
        if (this.firstAct == true) {
            this.putIntoStage();
            this.firstAct = false;
        }
    }    
}
