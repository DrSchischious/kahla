import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends GameObjects
{
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean hasSphere = false;
    Sphere sphere = null;
    int value;
    
    boolean isSecret = false;
    boolean firstAct = true;
    
    public Platform() {
        drawPlatform(1);
    }
    
    public Platform(int i) {
        this.value = i;
        this.drawPlatform(i);
    }
    
    
    public Platform (int i, boolean b) {
        this.value = i;
        this.isSecret = b;
        
        this.drawPlatform(i);
    }
    
    public void setSecret() {
        this.isSecret = true;
        this.drawPlatform(this.value);
    }
    
    public void setValue(int i) {
        this.value = i;
    }
    
    public void putSphere(Sphere s) {
        this.sphere = s;
        this.hasSphere = true;
        
        this.drawPlatform(this.value);
    }
    
    public Sphere takeSphere() {
        Sphere s = this.sphere;
        this.sphere = null;
        this.hasSphere = false;
        
        this.drawPlatform(this.value);
        return s;
    }
    
    public boolean isCorrectSphere() {
        if (!this.hasSphere) {
            return false;
        }
        if (this.value != this.sphere.value) {
            return false;
        }
        
        return true;
    }
 
    public void drawPlatform(int i) {
        GreenfootImage sp = new GreenfootImage(50,50);
        
        
        sp.setColor(new Color(200,200,200,255));
        sp.fillPolygon(new int[]{5,10,40,45,5}, new int[]{45,20,20,45,45}, 5); //x-points, y-points, n-Points
        sp.setColor(new Color(0,0,0,255));
        sp.drawPolygon(new int[]{5,10,40,45,5}, new int[]{45,20,20,45,45}, 5);
        sp.setColor(new Color(255,255,255,255));
        sp.fillOval(12, 18, 25, 7);
        sp.setColor(new Color(0,0,0,255));
        sp.drawOval(12, 18, 25, 7);
        
        sp.setColor(new Color(255,255,255,255));
        sp.fillRect(1,1,49,20);
        
        if (!hasSphere) {
           if (!this.isSecret) {
               if (i < 0) {
                    sp.setFont(new Font(16));
                    sp.setColor(new Color(0,0,0,255));
                    sp.drawString("?",20,41);
               } else if (i < 10) {
                    sp.setFont(new Font(16));
                    sp.setColor(new Color(0,0,0,255));
                    sp.drawString(""+i, 20, 41);
                } else {
                    sp.setFont(new Font(16));
                    sp.setColor(new Color(0,0,0,255));
                    sp.drawString(""+i, 15, 41);
                }
           }
           
        } else {
            GreenfootImage sp2 = new GreenfootImage(50,50);
        
        
        
            sp2.setColor(new Color(0,0,0,255));
            sp2.fillOval(0, 0, 50, 50);
            sp2.setColor(new Color(200,200,200,255));
            sp2.fillOval(5,5,40,40);
            
            if (i < 10) {
                sp2.setFont(new Font(26));
                sp2.setColor(new Color(0,0,0,255));
                sp2.drawString(""+sphere.value, 18, 34);
            } else {
                sp2.setFont(new Font(26));
                sp2.setColor(new Color(0,0,0,255));
                sp2.drawString(""+sphere.value, 12, 34);
            }
            
            
            sp2.scale(30, 30);
            
            sp.drawImage(sp2, 10, 2);
        }
        
      
        sp.scale(50, 50);
        this.setImage(sp);
        
    }
    
    private void putIntoStage() {
        this.getWorldOfType(Stage.class).platforms.add(this);
    }
    
    public void act() 
    {
        if (this.firstAct == true) {
            this.putIntoStage();
            this.firstAct = false;
        }
    }
}
