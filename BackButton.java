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
public class BackButton extends Button
{
    
    //Kapitel in Datei speichern und dann zu dem Modus zurück?
    
    
    /**
     * Act - do whatever the Pagebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BackButton() {
        super("X");
        this.enable();
    }
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {

            this.back();
        }
    }
    
    public void back() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
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
        Menu m = new Menu();
        int i = this.loadChapter();
        if (i == 1) {
            m.setMode("Chapter One");
        } else if (i == 2) {
            m.setMode("Chapter Two");
        } else if (i == 3) {
            m.setMode("Chapter Three");
        } else if (i == 4) {
            m.setMode("Chapter Four");
        } else if (i == 5) {
            m.setMode("Chapter Five");
        } else if (i == 6) {
            m.setMode("Chapter Six");
        }
        Greenfoot.setWorld(m);
        m.draw();
        
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
