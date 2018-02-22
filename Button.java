import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor implements Serializable
{
    
    private boolean disabled = true;
    public String text;
    boolean isKahla;
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(String text) {
        this.text = "   " + text + "   ";
        this.drawButton(this.text);
        if (text.equals("Farbi") || text.equals("Kahla")) {
            this.isKahla = this.loadCharacter();
        }
    }
    
    public boolean loadCharacter() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/character.txt"));
           String x = in.readLine();
           if (x != null) {
               if (x.equals("Kahla")) {
                   return true;
                }
               if (x.equals("Farbi")) {
                   return false;
               }
           } else {
               return true;
           }
           
           
           
           
        } catch(IOException e) {
           return true;
        }
           
        
        
        return true;
    }
    
    public void redraw() {
        this.drawButton(text);
    }
    
    public void drawButton(String text) {
        this.getImage().clear();
        
        if (this.isEnabled()) {
            GreenfootImage button = new GreenfootImage(text,24,new Color(0,0,0,255),new Color(0,0,0,0));
            button.setColor(new Color(0,0,0,255));
            button.drawRect(0, 0, button.getWidth()-1, button.getHeight()-1);
            this.setImage(button);
        } else {
            GreenfootImage button = new GreenfootImage(text,24,new Color(128,128,128,255),new Color(0,0,0,0));
            button.setColor(new Color(0,0,0,255));
            button.drawRect(0, 0, button.getWidth()-1, button.getHeight()-1);
            this.setImage(button);
        }
        
    }
    
    public void enable() {
        this.disabled = false;
        this.drawButton(this.text);
    }
    
    public void disable() {
        this.disabled = true;
        this.drawButton(this.text);
    }
    
    public boolean isEnabled() {
        return !this.disabled;
    }
    
    public void action() {
        
    }
    
    public void act() 
    {
        
    }
}  
