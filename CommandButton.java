import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
/**
 * Write a description of class Pagebutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandButton extends Button
{
    
    //Kapitel in Datei speichern und dann zu dem Modus zurück?
    
    
    /**
     * Act - do whatever the Pagebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public CommandButton() {
        super("");
        this.enable();
    }
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {

            this.command();
        }
    }
    
    public void command() {
        /*
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
            //TODO LEVEL SPEICHERN
            out.write("");
            out.close();
            
        } catch(IOException e) {
            
        } 
        
        try {
            
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualPage.txt"));  
            out.write(""+1);
            out.close();
            
        } catch(IOException e) {
            
        } 
        */
        
        Menu m = new Menu(true);
        
        m.setMode("Hilfe");  
                
        Greenfoot.setWorld(m);
        m.draw();
        
    }
    
    public void drawButton(String text) {
        this.getImage().clear();
        
        GreenfootImage button = new GreenfootImage(30,30);
        button.setColor(new Color(0,0,0,255));
        GreenfootImage scroll = new GreenfootImage("scroll.png");
        scroll.scale(28,28);
        button.drawImage(scroll, 1, 1);
        button.drawRect(0, 0, button.getWidth()-1, button.getHeight()-1);
        this.setImage(button);
        
        
    }
    
    private int loadChapter() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/actualChapter.txt"));
           try {
               String i = in.readLine();
               int j;
               if (i != null) {
                   j = Integer.parseInt(i);
               } else {
                   j = 1;
               }
               return j;
               
           } catch(IOException e) {
               return 1;
           }

        } catch (FileNotFoundException e) {
            return 1;
        }
    }
    
    public void act() 
    {
        if (this.isEnabled()) {
            this.action();
        }
    }    
}
