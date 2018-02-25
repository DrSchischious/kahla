import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameObjects extends Actor
{
    /**
     * Act - do whatever the GameObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int getRealX() {
        return this.getX()/this.getWorldOfType(Stage.class).width;
    }
    
    public int getRealY() {
        return this.getY()/this.getWorldOfType(Stage.class).width;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
