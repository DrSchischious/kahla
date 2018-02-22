import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pagebutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PageButton extends Button
{
    Multiheader h;
    boolean forward;
    
    /**
     * Act - do whatever the Pagebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PageButton(Multiheader h, String s, boolean forward) {
        super(s);
        this.forward = forward;
        this.h = h;
    }
    
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.forward) {
                this.h.nextPage();
            } else {
                this.h.lastPage();
            }
        }
    }
    
    
    public void act() 
    {
        if (this.isEnabled()) {
            this.action();
        }
    }    
}
