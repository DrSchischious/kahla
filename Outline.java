import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.Serializable;
/**
 * Write a description of class Outline here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Outline extends GameObjects implements Serializable
{
    /**
     * Act - do whatever the Outline wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean firstAct;
    public boolean isFilled = false;
    
    public boolean isSecret = false;
    
    public Outline() {
        this.firstAct = true;
    }
    
    public void setSecret() {
        this.isSecret = true;
        this.drawOutline();
    }
    
    public void drawOutline() {
        GreenfootImage bg = new GreenfootImage(50, 50);
        bg.clear();
        if (this.isSecret == false) {
            bg.setColor(new Color(0,0,0,255));
            bg.drawRect(0, 0, 50, 50);
            bg.drawRect(1, 1, 48, 48);
            bg.drawRect(2, 2, 46, 46);
            bg.drawRect(3, 3, 44, 44);
            bg.drawRect(4, 4, 42, 42);
        }
        this.setImage(bg);
    }
    
    public void redraw() {
        this.drawOutline();
    }
    
    private void putIntoStage() {
        this.getWorldOfType(Stage.class).outlines.add(this);
    }
    
    public void fill() {
        this.isFilled = true;
        //Sound
        //TODO: Normal Sound
        
        if (this.isSecret == true) {
            Greenfoot.playSound("345297__scrampunk__itemize.wav");
        }
    }
    
    public void act() 
    {
        if (this.firstAct == true) {
            this.drawOutline();
            this.putIntoStage();
            this.firstAct = false;
        }
        
        // Add your action code here.
    }       
}
