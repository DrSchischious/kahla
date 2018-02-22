import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends GameObjects
{
    
    private boolean firstAct = true;
    public boolean isTaken = false;
    /**
     * Act - do whatever the Checkpoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Item() {
       
    }
    
    private void putIntoStage() {
        this.getWorldOfType(Stage.class).items.add(this);
    }
    
    private void drawItem() {
        int size = this.getWorldOfType(Stage.class).width;
        GreenfootImage bg = new GreenfootImage(60, 60);
        bg.clear();
        bg.setColor(new Color(248,185,37,255));
        bg.fillPolygon(new int[]{10,40,55,25}, new int[]{35,5,20,50}, 4);
        bg.setColor(new Color(0,0,0,255));
        bg.drawPolygon(new int[]{10,40,55,25}, new int[]{35,5,20,50}, 4);
        bg.scale(45, 45);
        this.setImage(bg);
    }
    
    public void take() {
        this.isTaken = true;
        //Sound
    }
    
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if (this.firstAct == true) {
            this.putIntoStage();
            this.drawItem();
            this.firstAct = false;
        }
    }    
}
