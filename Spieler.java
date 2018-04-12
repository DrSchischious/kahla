import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Write a description of class Spieler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spieler extends Player implements Serializable
{
    /**
     * Act - do whatever the Spieler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Spieler() {
        super();
    }

    public Spieler(boolean b) {
        super(b);
    }

    //Unter dieser Zeile sollen deine Prozeduren stehen
    public void doppelschritt() {
        schritt();
        schritt();
    }   

    //Über dieser Zeile sollen deine Prozeduren stehen

    public void code() {
        //Unter dieser Zeile sollen deine Befehle stehen
        if (siehtCheckpoint()) {
            schritt();
        }
        //Über dieser Zeile sollen deine Befehle stehen
    }
}
