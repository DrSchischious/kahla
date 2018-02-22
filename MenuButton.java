import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
/**
 * Write a description of class MenuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuButton extends Button  implements Serializable
{
    /**
     * Act - do whatever the MenuButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Menu menu;
    String sub;
    

    public MenuButton(String s, Menu m) {
        super(s);
        menu = m;
        sub = "";
        this.enable();
       
        
        
    }
    
    public MenuButton(String s, Menu m, String sub) {
        super(s);
        menu = m;
        this.sub = sub;
        this.enable();
        
        
        
    }
    
    
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.text.equals("   Levelauswahl   ")) {
                this.levelSelect();

            } else if (this.text.equals("   Credits   ")) {
                this.credits();

            } else if (this.text.equals("   Statistiken   ")) {
                this.statistics();

            } else if (this.text.equals("   Weitere Modi   ")) {
                //Missing
            } else if (this.text.equals("   Optionen   ")) {
                this.options();

            } else if (this.text.equals("   Befehlsliste   ")) {
                this.commands(1);
            } else if (this.text.equals("   Befehle   ")) {
                this.commands(2);
            } else if (this.text.equals("   Schritt   ")) {
                this.commands(200);
            } else if (this.text.equals("   Aufheben   ")) {
                this.commands(201);
            }  else if (this.text.equals("   Schießen   ")) {
                this.commands(202);
            } else if (this.text.equals("   LinksDrehen   ")) {
                this.commands(203);
            } else if (this.text.equals("   RechtsDrehen   ")) {
                this.commands(204);
            } else if (this.text.equals("   Färben   ")) {
                this.commands(205);
            } else if (this.text.equals("   Nehmen   ")) {
                this.commands(206);
            } else if (this.text.equals("   Hinlegen   ")) {
                this.commands(207);
            } else if (this.text.equals("   Bedingungen   ")) {
                this.commands(3);
            } else if (this.text.equals("   SiehtCheckpoint   ")) {
                this.commands(300);
            } else if (this.text.equals("   IstAufToken   ")) {
                this.commands(301);
            } else if (this.text.equals("   IstZielscheibeInReichweite   ")) {
                this.commands(302);
            } else if (this.text.equals("   IstAufMarkierung   ")) {
                this.commands(303);
            } else if (this.text.equals("   IstVorWand   ")) {
                this.commands(304);
            } else if (this.text.equals("   IstVorKugel   ")) {
                this.commands(305);
            } else if (this.text.equals("   HatKugel   ")) {
                this.commands(306);
            } else if (this.text.equals("   Syntax   ")) {
                this.commands(4);
            } else if (this.text.equals("   Lesehinweise   ")) {
                this.commands(400);
            } else if (this.text.equals("   Programm   ")) {
                this.commands(401);
            } else if (this.text.equals("   Prozeduren   ") && this.sub.equals("Syntax")) {
                this.commands(402);
            } else if (this.text.equals("   Abfragen   ") && this.sub.equals("Syntax")) {
                this.commands(403);
            } else if (this.text.equals("   Schleifen   ") && this.sub.equals("Syntax")) {
                this.commands(404);
            } else if (this.text.equals("   Boolsche Funktionen   ") && this.sub.equals("Syntax")) {
                this.commands(405);
            } else if (this.text.equals("   Konzepte   ")) {
                this.commands(5);
            } else if (this.text.equals("   Programmierung   ")) {
                this.commands(500);
            } else if (this.text.equals("   Teile & Herrsche   ")) {
                this.commands(501);
            } else if (this.text.equals("   Prozeduren   ") && this.sub.equals("Konzepte")) {
                this.commands(502);
            } else if (this.text.equals("   Camelcode   ")) {
                this.commands(503);
            } else if (this.text.equals("   Allgemeinheit   ")) {
                this.commands(504);
            } else if (this.text.equals("   Abfragen   ") && this.sub.equals("Konzepte")) {
                this.commands(505);
            } else if (this.text.equals("   Schleifen   ") && this.sub.equals("Konzepte")) {
                this.commands(506);
            } else if (this.text.equals("   Verneinung   ")) {
                this.commands(507);
            } else if (this.text.equals("   Boolsche Funktionen   ") && this.sub.equals("Konzepte")) {
                this.commands(508);
            } else if (this.text.equals("   Endlosschleife   ")) {
                this.commands(509);
            } else if (this.text.equals("   Boolsche Verknüpfungen   ")) {
                this.commands(510);
            } else if (this.text.equals("   Spielelemente   ")) {
                this.commands(6);
            } else if (this.text.equals("   Welt   ")) {
                this.commands(600);
            } else if (this.text.equals("   Spielfigur   ")) {
                this.commands(601);
            } else if (this.text.equals("   Wand   ")) {
                this.commands(602);
            } else if (this.text.equals("   Checkpoint   ")) {
                this.commands(603);
            } else if (this.text.equals("   Token   ")) {
                this.commands(604);
            } else if (this.text.equals("   Zielscheibe   ")) {
                this.commands(605);
            } else if (this.text.equals("   Markierung   ")) {
                this.commands(606);
            } else if (this.text.equals("   Multi-Levels   ")) {
                this.commands(607);
            } else if (this.text.equals("   Kugel   ")) {
                this.commands(608);
            } else if (this.text.equals("   Plattform   ")) {
                this.commands(609);
            } else if (this.text.equals("   Allgemeines   ")) {
                this.commands(7);
            } else if (this.text.equals("   Ändern der Spielfigur   ")) {
                this.commands(700);
            } else if (this.text.equals("   Erfahrungspunkte   ")) {
                this.commands(701);
            } else if (this.text.equals("   Lines of Code   ")) {
                this.commands(702);
            } else if (this.text.equals("   Levelbewertung   ")) {
                this.commands(703);
            } else if (this.text.equals("   Lösungen   ") && this.sub.equals("General")) {
                this.commands(704);
            }
            
            /*else if (this.text.equals("   Schritt   ")) {
                this.commands(1);
            } else if (this.text.equals("   Aufheben   ")) {
                this.commands(2);
            } else if (this.text.equals("   Schießen   ")) {
                this.commands(3);
            } else if (this.text.equals("   LinksDrehen   ")) {
                this.commands(4);
            } else if (this.text.equals("   RechtsDrehen   ")) {
                this.commands(5);
            } else if (this.text.equals("   Syntax   ")) {
                this.commands(8);
            } else if (this.text.equals("   Prozeduren   ")) {
                this.commands(9);
            } else if (this.text.equals("   Abfragen   ")) {
                this.commands(10);
            }*/ else if (this.text.equals("   Back   ")) {
                this.main();

            } else if (this.text.equals("   Lösungen   ") && this.sub.equals("Main")) {
                this.solutions();

            }  else if (this.text.equals("    Back    ")) {
              
                String actualLevel = this.getLevel();
                if (actualLevel.equals("C01L01")) {
                    Greenfoot.setWorld(new CampaignLevel(1,1,10,3,50));
                    Greenfoot.start();
                    
                } else if (actualLevel.equals("C01L02")) {
                    Greenfoot.setWorld(new CampaignLevel(1,2,10,3,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L03")) {
                    Greenfoot.setWorld(new CampaignLevel(1,3,10,3,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L04")) {
                    Greenfoot.setWorld(new CampaignLevel(1,4,10,3,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L05")) {
                    Greenfoot.setWorld(new CampaignLevel(1,5,10,4,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L06")) {
                    Greenfoot.setWorld(new CampaignLevel(1,6,11,6,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L07")) {
                    Greenfoot.setWorld(new CampaignLevel(1,7,11,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L08")) {
                    Greenfoot.setWorld(new CampaignLevel(1,8,10,4,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L09")) {
                    Greenfoot.setWorld(new CampaignLevel(1,9,11,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C01L10")) {
                    Greenfoot.setWorld(new CampaignLevel(1,10,10,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L01")) {
                    Greenfoot.setWorld(new CampaignLevel(2,1,11,3,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L02")) {
                    Greenfoot.setWorld(new CampaignLevel(2,2,11,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L03")) {
                    Greenfoot.setWorld(new CampaignLevel(2,3,9,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L04")) {
                    Greenfoot.setWorld(new CampaignLevel(2,4,11,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L05")) {
                    Greenfoot.setWorld(new CampaignLevel(2,5,11,6,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L06")) {
                    Greenfoot.setWorld(new CampaignLevel(2,6,10,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L07")) {
                    Greenfoot.setWorld(new CampaignLevel(2,7,12,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L08")) {
                    Greenfoot.setWorld(new CampaignLevel(2,8,13,8,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L09")) {
                    Greenfoot.setWorld(new CampaignLevel(2,9,13,13,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C02L10")) {
                    Greenfoot.setWorld(new CampaignLevel(2,10,17,8,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L01")) {
                    Greenfoot.setWorld(new CampaignLevel(3,1,11,3,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L02")) {
                    Greenfoot.setWorld(new CampaignLevel(3,2,10,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L03")) {
                    Greenfoot.setWorld(new CampaignLevel(3,3,11,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L04")) {
                    Greenfoot.setWorld(new CampaignLevel(3,4,11,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L05")) {
                    Greenfoot.setWorld(new CampaignLevel(3,5,9,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L06")) {
                    Greenfoot.setWorld(new CampaignLevel(3,6,11,8,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L07")) {
                    Greenfoot.setWorld(new CampaignLevel(3,7,9,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L08")) {
                    Greenfoot.setWorld(new CampaignLevel(3,8,13,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L09")) {
                    Greenfoot.setWorld(new CampaignLevel(3,9,11,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C03L10")) {
                    Greenfoot.setWorld(new CampaignLevel(3,10,11,5,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L01")) {
                    Greenfoot.setWorld(new CampaignLevel(4,1,10,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L02")) {
                    Greenfoot.setWorld(new CampaignLevel(4,2,9,7,50)); 
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L03")) {
                    Greenfoot.setWorld(new CampaignLevel(4,3,9,8,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L04")) {
                    Greenfoot.setWorld(new CampaignLevel(4,4,9,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L05")) {
                    Greenfoot.setWorld(new CampaignLevel(4,5,11,12,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L06")) {
                    Greenfoot.setWorld(new CampaignLevel(4,6,13,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L07")) {
                    Greenfoot.setWorld(new CampaignLevel(4,7,12,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L08")) {
                    Greenfoot.setWorld(new CampaignLevel(4,8,11,11,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L09")) {
                    Greenfoot.setWorld(new CampaignLevel(4,9,12,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C04L10")) {
                    Greenfoot.setWorld(new CampaignLevel(4,10,11,11,50));
                    Greenfoot.start();
                }  else if (actualLevel.equals("C05L01")) {
                    Greenfoot.setWorld(new CampaignLevel(5,1,9,3,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L02")) {
                    Greenfoot.setWorld(new CampaignLevel(5,2,9,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L03")) {
                    Greenfoot.setWorld(new CampaignLevel(5,3,9,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L04")) {
                    Greenfoot.setWorld(new CampaignLevel(5,4,10,13,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L05")) {
                    Greenfoot.setWorld(new CampaignLevel(5,5,11,10,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L06")) {
                    Greenfoot.setWorld(new CampaignLevel(5,6,10,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L07")) {
                    Greenfoot.setWorld(new CampaignLevel(5,7,9,11,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L08")) {
                    Greenfoot.setWorld(new CampaignLevel(5,8,13,9,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L09")) {
                    Greenfoot.setWorld(new CampaignLevel(5,9,13,13,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C05L10")) {
                    Greenfoot.setWorld(new CampaignLevel(5,10,13,13,50));
                    Greenfoot.start();
                }  else if (actualLevel.equals("C06L01")) {
                    Greenfoot.setWorld(new CampaignLevel(6,1,13,6,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L02")) {
                    Greenfoot.setWorld(new CampaignLevel(6,2,13,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L03")) {
                    Greenfoot.setWorld(new CampaignLevel(6,3,13,11,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L04")) {
                    Greenfoot.setWorld(new CampaignLevel(6,4,13,11,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L05")) {
                    Greenfoot.setWorld(new CampaignLevel(6,5,15,11,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L06")) {
                    Greenfoot.setWorld(new CampaignLevel(6,6,15,11,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L07")) {
                    Greenfoot.setWorld(new CampaignLevel(6,7,12,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L08")) {
                    Greenfoot.setWorld(new CampaignLevel(6,8,12,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L09")) {
                    Greenfoot.setWorld(new CampaignLevel(6,9,13,7,50));
                    Greenfoot.start();
                } else if (actualLevel.equals("C06L10")) {
                    Greenfoot.setWorld(new CampaignLevel(6,10,13,7,50));
                    Greenfoot.start();
                }
                        
                
                
                
                
                
                
                
                

            } else if (this.text.equals("   Kahla   ")) {
                this.kahla();

            } else if (this.text.equals("   Farbi   ")) {
                this.farbi();

            } else if (this.text.equals("   Zurücksetzen   ")) {
                if (Greenfoot.ask("Möchtest du wirklich alle Daten zurücksetzen? (Ja/Nein)").equals("Ja")) {
                    this.resetGame();
                }
                

            } else if (this.text.equals("   Hilfe   ")) {
                this.commands(0);
            }
            this.menu.draw();
            
            
        }
    }
    
    
    
    public void drawButton(String text) {
        
        this.getImage().clear();
        
        if (this.isEnabled()) {
            
            GreenfootImage button = new GreenfootImage(300,40);
            
            
            button.setFont(new Font(30));
            button.setColor(new Color(0,0,0,255));
            if (this.text.equals("   Levelauswahl   ")) {
                button.drawString(text,40,30);
            } else if (this.text.equals("   Credits   ")) {
                button.drawString(text,83,30);
            } else if (this.text.equals("   Statistiken   ")) {
                button.drawString(text,62,30);
            } else if (this.text.equals("   Lösungen   ") && !this.sub.equals("General")) {
                if (this.menu.mode.equals("Options")) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(30));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,12,30);
                } else {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text, 25,30);
                }
                
            }  else if (this.text.equals("   Back   ")) {
                button = new GreenfootImage(115,40);
                button.setFont(new Font(30));
                button.setColor(new Color(0,0,0,255));
                button.drawString(text,0,30);
                
            } else if (this.text.equals("    Back    ")) {
                button = new GreenfootImage(125,40);
                button.setFont(new Font(30));
                button.setColor(new Color(0,0,0,255));
                button.drawString(text,0,30);
                
            } else if (this.text.equals("   Optionen   ")) {
                button.drawString(text,67,30);
            } else if (this.text.equals("   Weitere Modi   ")) {
                button.drawString(text,40,30);
            } else if (this.text.equals("   Kahla   ") && this.isKahla == false) {
                button = new GreenfootImage(150,40);
                button.setFont(new Font(30));
                button.setColor(new Color(0,0,0,255));
                button.drawString(text,12,30);
            } else if (this.text.equals("   Kahla   ") && this.isKahla == true) {
                button = new GreenfootImage(150,40);
                button.setColor(new Color(100,100,100,255));
                button.fillRect(0,0,button.getWidth()-1,button.getHeight()-1);
                
                button.setFont(new Font(30));
                button.setColor(new Color(0,0,0,255));
                button.drawString(text,12,30);
            } else if (this.text.equals("   Farbi   ") && this.isKahla == true) {
                button = new GreenfootImage(150,40);
                button.setFont(new Font(30));
                button.setColor(new Color(0,0,0,255));
                button.drawString(text,12,30);
            } else if (this.text.equals("   Farbi   ") && this.isKahla == false) {
                button = new GreenfootImage(150,40);
                button.setColor(new Color(100,100,100,255));
                button.fillRect(0,0,button.getWidth()-1,button.getHeight()-1);
                
                button.setFont(new Font(30));
                button.setColor(new Color(0,0,0,255));
                button.drawString(text,12,30);
            } else if (this.text.equals("   Zurücksetzen   ")) {
                button = new GreenfootImage(220,40);
                button.setFont(new Font(30));
                button.setColor(new Color(0,0,0,255));
                button.drawString(text,0,30);
            } else if (this.text.equals("   Hilfe   ")) {
                button.drawString(text, 100,30);
            } else if (this.text.equals("   Befehlsliste   ")) {
                 if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text, 16,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Befehle   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,35,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Schritt   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,40,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Aufheben   ")) {
                if (menu.progress[2] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,25,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Schießen   ")) {
                if (menu.progress[3] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,25,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   LinksDrehen   ")) {
                if (menu.progress[4] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,10,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   RechtsDrehen   ")) {
                if (menu.progress[4] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,0,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Färben   ")) {
                if (menu.progress[10] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,40,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Nehmen   ")) {
                if (menu.progress[40] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,30,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Hinlegen   ")) {
                if (menu.progress[40] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,28,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Bedingungen   ")) {
                if (menu.progress[21] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,7,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   SiehtCheckpoint   ")) {
                if (menu.progress[21] == true) {
                    button = new GreenfootImage(350,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,60,30);
                } else {
                    button = new GreenfootImage(350,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   IstAufToken   ")) {
                if (menu.progress[22] == true) {
                    button = new GreenfootImage(350,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,90,30);
                } else {
                    button = new GreenfootImage(350,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   IstZielscheibeInReichweite   ")) {
                if (menu.progress[23] == true) {
                    button = new GreenfootImage(350,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,5,30);
                } else {
                    button = new GreenfootImage(350,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   IstAufMarkierung   ")) {
                if (menu.progress[25] == true) {
                    button = new GreenfootImage(350,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,60,30);
                } else {
                    button = new GreenfootImage(350,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   IstVorWand   ")) {
                if (menu.progress[32] == true) {
                    button = new GreenfootImage(350,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,90,30);
                } else {
                    button = new GreenfootImage(350,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   IstVorKugel   ")) {
                if (menu.progress[45] == true) {
                    button = new GreenfootImage(350,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,92,30);
                } else {
                    button = new GreenfootImage(350,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   HatKugel   ")) {
                if (menu.progress[45] == true) {
                    button = new GreenfootImage(350,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,110,30);
                } else {
                    button = new GreenfootImage(350,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Syntax   ")) {
                 if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text, 42,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }  else if (this.text.equals("   Lesehinweise   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,40,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }  else if (this.text.equals("   Programm   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,58,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }  else if (this.text.equals("   Prozeduren   ") && this.sub.equals("Syntax")){
                if (menu.progress[11] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,53,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }  else if (this.text.equals("   Abfragen   ") && this.sub.equals("Syntax")) {
                if (menu.progress[21] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,67,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }  else if (this.text.equals("   Schleifen   ") && this.sub.equals("Syntax")) {
                if (menu.progress[30] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,65,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Boolsche Funktionen   ") && this.sub.equals("Syntax")) {
                if (menu.progress[43] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,0,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Konzepte   ")) {
                 if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text, 28,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Programmierung   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,50,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Teile & Herrsche   ")) {
                if (menu.progress[9] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,50,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Prozeduren   ")) {
                if (menu.progress[11] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,75,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Camelcode   ")) {
                if (menu.progress[12] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,75,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Allgemeinheit   ")) {
                if (menu.progress[20] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,60,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Abfragen   ")) {
                if (menu.progress[21] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,87,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Schleifen   ")) {
                if (menu.progress[30] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,86,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Verneinung   ")) {
                if (menu.progress[31] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,75,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Boolsche Funktionen   ")) {
                if (menu.progress[43] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,25,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Endlosschleifen   ")) {
                if (menu.progress[44] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,50,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Boolsche Verknüpfungen   ")) {
                if (menu.progress[45] == true) {
                    button = new GreenfootImage(325,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,0,30);
                } else {
                    button = new GreenfootImage(325,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Spielelemente   ")) {
                 if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text, 0,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Welt   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,50,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Spielfigur   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,25,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Wand   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,43,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Checkpoint   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,15,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Token   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,45,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Zielscheibe   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,15,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Markierung   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,15,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Multi-Levels   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,10,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Kugel   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,45,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Plattform   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,30,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Allgemeines   ")) {
                 if (menu.progress[0] == true) {
                    button = new GreenfootImage(200,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text, 10,30);
                } else {
                    button = new GreenfootImage(200,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Ändern der Spielfigur   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,0,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }
             else if (this.text.equals("   Erfahrungspunkte   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,25,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }
             else if (this.text.equals("   Lines of Code   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,40,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Levelbewertung   ")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,30,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            } else if (this.text.equals("   Lösungen   ") & this.sub.equals("General")) {
                if (menu.progress[0] == true) {
                    button = new GreenfootImage(275,40);
                    button.setFont(new Font(25));
                    button.setColor(new Color(0,0,0,255));
                    button.drawString(text,60,30);
                } else {
                    button = new GreenfootImage(275,40);
                    GreenfootImage gfi = new GreenfootImage("keyhole.png");
                    gfi.scale(30,30);
                    button.drawImage(gfi,85,5);
                    
                    this.disable();
                }
            }
            
            
            
            button.drawRect(0, 0, button.getWidth()-1, button.getHeight()-1);
            this.setImage(button);
        } else {
            GreenfootImage button = new GreenfootImage(text,40,new Color(128,128,128,255),new Color(0,0,0,0));
            button.setColor(new Color(0,0,0,255));
            button.drawRect(0, 0, button.getWidth()-1, button.getHeight()-1);
            this.setImage(button);
        }
        
    }
    
    static boolean isWindowsSystem() { 
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.indexOf("windows") >= 0;
    }
      
    static boolean isLinuxSystem() { 
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.indexOf("linux") >= 0;
    }
      
    static void printWindowsCommand(String command) throws Exception {
        File directory = new File(".");
        File[] flist = directory.listFiles();
        /*
        for (File file: flist) {
            System.out.println(file.getName());
        }
        */
        
        File html = new File("data\\Lösungen\\index.html");
        
        /*
        System.out.println("Windows command: " + command);
        String line;
        */
        //Process process = Runtime.getRuntime().exec("cmd /c " + command);
        Process process = Runtime.getRuntime().exec("cmd /c " + html);
        
        /*
        Reader r = new InputStreamReader(process.getInputStream());
        BufferedReader in = new BufferedReader(r);
        while((line = in.readLine()) != null) 
            System.out.println(line);
        in.close();
        */
    }
      
    static void printLinuxCommand(String command) throws Exception { 
        System.out.println("Linux command: " + command);
        String line;
        Process process = Runtime.getRuntime().exec(command);
        Reader r = new InputStreamReader(process.getInputStream());
        BufferedReader in = new BufferedReader(r);
        while((line = in.readLine()) != null) 
            System.out.println(line);
        in.close();
    }
    
    public void solutions() {
        if (isWindowsSystem()) { 
            
            try {
                printWindowsCommand("");
            } catch(Exception e) {
                
            }

        } else if (isLinuxSystem()) { 
            
            try {
                printLinuxCommand("ps -U hermann u");
            } catch(Exception e) {
                
            }
            
        } else { 
            System.err.println("Unknown System");
            System.exit(1);
        }
    }
    
   
    
    public void levelSelect() {
        //Change Mode in menu
        this.menu.setMode("Level Select");
    }
    
    public void credits() {
        //Change Mode in menu
        this.menu.setMode("Credits");
    }
    
    public void statistics() {
        //Change Mode in menu
        this.menu.setMode("Statistics");
    }
    
    public void main() {
        //Change Mode in menu
        this.menu.setMode("Main");
    }
    
    public void options() {
        //Change Mode in menu
        this.menu.setMode("Options");
    }
    
    public void commands(int i) {
        if (i == 0) {
            this.menu.setMode("Hilfe");
        } else if (i == 1) {
            this.menu.setMode("Befehlsliste");
        } else if (i == 2) {
            this.menu.setMode("Befehle");
        } else if (i == 3) {
            this.menu.setMode("Bedingungen");
        }  else if (i == 4) {
            this.menu.setMode("Syntax");
        }  else if (i == 5) {
            this.menu.setMode("Konzepte");
        }  else if (i == 6) {
            this.menu.setMode("Spielelemente");
        }  else if (i == 7) {
            this.menu.setMode("Allgemeines");
        }
        
        
        
        
        
        else if (i == 200) {
            this.menu.setMode("Schritt");
        } else if (i == 201) {
            this.menu.setMode("Aufheben");
        } else if (i == 202) {
            this.menu.setMode("Schießen");
        } else if (i == 203) {
            this.menu.setMode("LinksDrehen");
        } else if (i == 204) {
            this.menu.setMode("RechtsDrehen");
        } else if (i == 205) {
            this.menu.setMode("Färben");
        } else if (i == 206) {
            this.menu.setMode("Nehmen");
        } else if (i == 207) {
            this.menu.setMode("Hinlegen");
        } 
        
        else if (i == 300) {
            this.menu.setMode("SiehtCheckpoint");
        } else if (i == 301) {
            this.menu.setMode("IstAufToken");
        } else if (i == 302) {
            this.menu.setMode("IstZielscheibeInReichweite");
        } else if (i == 303) {
            this.menu.setMode("IstAufMarkierung");
        } else if (i == 304) {
            this.menu.setMode("IstVorWand");
        } else if (i == 305) {
            this.menu.setMode("IstVorKugel");
        } else if (i == 306) {
            this.menu.setMode("HatKugel");
        }
        
        else if (i == 400) {
            this.menu.setMode("Lesehinweise");
        } else if (i == 401) {
            this.menu.setMode("Programm");
        } else if (i == 402) {
            this.menu.setMode("Prozeduren");
        } else if (i == 403) {
            this.menu.setMode("Abfragen");
        } else if (i == 404) {
            this.menu.setMode("Schleifen");
        } else if (i == 405) {
            this.menu.setMode("Boolsche Funktionen");
        }
        
        else if (i == 500) {
            this.menu.setMode("Programmierung");
        } else if (i == 501) {
            this.menu.setMode("Teile & Herrsche");
        } else if (i == 502) {
            this.menu.setMode("Prozeduren_2");
        } else if (i == 503) {
            this.menu.setMode("Camelcode");
        } else if (i == 504) {
            this.menu.setMode("Allgemeinheit");
        } else if (i == 505) {
            this.menu.setMode("Abfragen_2");
        } else if (i == 506) {
            this.menu.setMode("Schleifen_2");
        } else if (i == 507) {
            this.menu.setMode("Verneinung");
        } else if (i == 508) {
            this.menu.setMode("Boolsche Funktionen_2");
        } else if (i == 509) {
            this.menu.setMode("Endlosschleifen");
        } else if (i == 510) {
            this.menu.setMode("Boolsche Verknüpfungen");
        }
        
        else if (i == 600) {
            this.menu.setMode("Welt");
        } else if (i == 601) {
            this.menu.setMode("Spielfigur");
        } else if (i == 602) {
            this.menu.setMode("Wand");
        } else if (i == 603) {
            this.menu.setMode("Checkpoint");
        } else if (i == 604) {
            this.menu.setMode("Token");
        } else if (i == 605) {
            this.menu.setMode("Zielscheibe");
        } else if (i == 606) {
            this.menu.setMode("Markierung");
        } else if (i == 607) {
            this.menu.setMode("Multi-Levels");
        } else if (i == 608) {
            this.menu.setMode("Kugel");
        } else if (i == 609) {
            this.menu.setMode("Plattform");
        }
        
        else if (i == 700) {
            this.menu.setMode("Ändern der Spielfigur");
        } else if (i == 701) {
            this.menu.setMode("Erfahrungspunkte");
        } else if (i == 702) {
            this.menu.setMode("Lines of Code");
        } else if (i == 703) {
            this.menu.setMode("Levelbewertung");
        } else if (i == 704) {
            this.menu.setMode("Lösungen_2");
        }
        
        /* else if (i == 3) {
            this.menu.setMode("Schießen");
        } else if (i == 4) {
            this.menu.setMode("LinksDrehen");
        } else if (i == 5) {
            this.menu.setMode("RechtsDrehen");
        } else if (i == 6) {
            this.menu.setMode("Teile & Herrsche");
        } else if (i == 7) {
            this.menu.setMode("Färben");
        } else if (i == 8) {
            this.menu.setMode("Syntax");
        } else if (i == 9) {
            this.menu.setMode("Prozeduren");
        } else if (i == 10) {
            this.menu.setMode("Abfragen");
        }  else if (i == 11) {
            this.menu.setMode("Checkpoint");
        }  else if (i == 12) {
            this.menu.setMode("Token");
        } else if (i == 13) {
            this.menu.setMode("Zielscheibe");
        } else if (i == 14) {
            this.menu.setMode("Markierung");
        }*/
        
        
        
    }
    
    public void farbi() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/character.txt"));  
            out.write("Farbi");
            out.close();
            
        } catch(IOException e) {
            
        } 
        this.isKahla = false;

        
    }
    
    public void kahla() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/character.txt"));  
            out.write("Kahla");
            out.close();
            
        } catch(IOException e) {
            
        } 
        this.isKahla = true;
    }
    
    public void resetGame() {
        
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
            out1.write("");
            out1.close();
            
            BufferedWriter out2 = new BufferedWriter(new FileWriter("data/actualPage.txt"));  
            out2.write("");
            out2.close();
            
            BufferedWriter out3 = new BufferedWriter(new FileWriter("data/character.txt"));  
            out3.write("");
            out3.close();
            
            BufferedWriter out4 = new BufferedWriter(new FileWriter("data/state.txt"));  
            out4.write("");
            out4.close();
            
            BufferedWriter out5 = new BufferedWriter(new FileWriter("data/name.txt"));  
            out5.write("");
            out5.close();
            
            BufferedWriter out6 = new BufferedWriter(new FileWriter("data/actualChapter.txt"));  
            out6.write("");
            out6.close();
            //TODO: Lines zurücksetzen
            
            /*  Delete All Solutions
             * 
             * 
             */
            
            this.menu.setKahla();

            this.menu.name = this.menu.getName();
            
        } catch(IOException e) {
            
        } 
    }
    
    public String getLevel() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/actualLevel.txt"));
           return in.readLine();
        } catch(IOException e) {
           return "";
        } 
    }
    
    public void act() 
    {
        if (this.isEnabled()) {
            this.action();
        }
    }    
}   
