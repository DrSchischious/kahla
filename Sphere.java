import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sphere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sphere extends GameObjects
{
    int value;
    boolean firstAct = true;
    boolean isSecret = false;
    
    /**
     * Act - do whatever the Sphere wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Sphere() {
        this.drawSphere(1);
    }
    
    public Sphere(int i) {
        this.drawSphere(i);
        this.value = i;
    }
     
    public void setSecret() {
        this.isSecret = true;
        this.drawSphere(this.value);
    }
    
    public void drawSphere(int i) {
        GreenfootImage sp = new GreenfootImage(50,50);
        
        
        
        sp.setColor(new Color(0,0,0,255));
        sp.fillOval(0, 0, 50, 50);
        sp.setColor(new Color(200,200,200,255));
        sp.fillOval(5,5,40,40);
        if (!isSecret) {
            if (i < 10) {
                sp.setFont(new Font(26));
                sp.setColor(new Color(0,0,0,255));
                sp.drawString(""+i, 18, 34);
            } else {
                sp.setFont(new Font(26));
                sp.setColor(new Color(0,0,0,255));
                sp.drawString(""+i, 12, 34);
            }
        }
        
        
        
        sp.scale(40, 40);
        this.setImage(sp);
        
    }
    
    private void putIntoStage() {
        
        this.getWorldOfType(Stage.class).spheres.add(this);
    }
    
    public void pickUp() {
        //Sound?
    }
    
    public void act() 
    {
        if (this.firstAct == true) {
            this.putIntoStage();
            this.firstAct = false;
        }
    }
}
