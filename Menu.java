import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

/**
 * This class helps traversing the features.
 * For one, users can see their statistics, options, credits and also just play.
 * 
 * @author Daniel Schisch
 * @version 0.7
 */
public class Menu extends World
{
    String mode;
    MenuButton[] buttons;
    ArrayList<LevelButton> lbuttons;
    ArrayList<ChapterButton> cbuttons;
    String actualLevel = "";
    String name = "";
    
    boolean[] progress; 
    int[][] loc;
    int exp;
    int linesOfCode = 0;
    
    boolean isOnCommand = false;
    boolean firstAct = true;
    
    /**
     * Standard Constructor, which is called on many occasions like:
     * - Starting the game for the first time
     * - Resetting the game
     * - Accessing and changing the code
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        
        this.actualLevel = this.getLevel();
        
        if (this.actualLevel != null) {
            
            Level lv = this.reloadLevel(actualLevel);
                
            Greenfoot.setWorld(new CampaignLevel(lv.width,lv.height,lv));
            Greenfoot.start();
            
            /*if (this.actualLevel.equals("C01L01")) {
                Greenfoot.setWorld(new CampaignLevel(1,1,10,3,50));
                Greenfoot.start();
                
            } else if (this.actualLevel.equals("C01L02")) {
                Greenfoot.setWorld(new CampaignLevel(1,2,10,3,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L03")) {
                Greenfoot.setWorld(new CampaignLevel(1,3,10,3,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L04")) {
                Greenfoot.setWorld(new CampaignLevel(1,4,10,3,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L05")) {
                Greenfoot.setWorld(new CampaignLevel(1,5,10,4,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L06")) {
                Greenfoot.setWorld(new CampaignLevel(1,6,11,6,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L07")) {
                Greenfoot.setWorld(new CampaignLevel(1,7,11,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L08")) {
                Greenfoot.setWorld(new CampaignLevel(1,8,10,4,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L09")) {
                Greenfoot.setWorld(new CampaignLevel(1,9,11,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C01L10")) {
                Greenfoot.setWorld(new CampaignLevel(1,10,10,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L01")) {
                Greenfoot.setWorld(new CampaignLevel(2,1,11,3,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L02")) {
                Greenfoot.setWorld(new CampaignLevel(2,2,11,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L03")) {
                Greenfoot.setWorld(new CampaignLevel(2,3,9,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L04")) {
                Greenfoot.setWorld(new CampaignLevel(2,4,11,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L05")) {
                Greenfoot.setWorld(new CampaignLevel(2,5,11,6,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L06")) {
                Greenfoot.setWorld(new CampaignLevel(2,6,10,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L07")) {
                Greenfoot.setWorld(new CampaignLevel(2,7,12,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L08")) {
                Greenfoot.setWorld(new CampaignLevel(2,8,13,8,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L09")) {
                Greenfoot.setWorld(new CampaignLevel(2,9,13,13,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C02L10")) {
                Greenfoot.setWorld(new CampaignLevel(2,10,17,8,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L01")) {
                Greenfoot.setWorld(new CampaignLevel(3,1,11,3,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L02")) {
                Greenfoot.setWorld(new CampaignLevel(3,2,10,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L03")) {
                Greenfoot.setWorld(new CampaignLevel(3,3,11,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L04")) {
                Greenfoot.setWorld(new CampaignLevel(3,4,11,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L05")) {
                Greenfoot.setWorld(new CampaignLevel(3,5,9,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L06")) {
                Greenfoot.setWorld(new CampaignLevel(3,6,11,8,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L07")) {
                Greenfoot.setWorld(new CampaignLevel(3,7,9,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L08")) {
                Greenfoot.setWorld(new CampaignLevel(3,8,13,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L09")) {
                Greenfoot.setWorld(new CampaignLevel(3,9,11,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C03L10")) {
                Greenfoot.setWorld(new CampaignLevel(3,10,11,5,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L01")) {
                Greenfoot.setWorld(new CampaignLevel(4,1,10,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L02")) {
                Greenfoot.setWorld(new CampaignLevel(4,2,9,7,50)); 
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L03")) {
                Greenfoot.setWorld(new CampaignLevel(4,3,9,8,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L04")) {
                Greenfoot.setWorld(new CampaignLevel(4,4,9,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L05")) {
                Greenfoot.setWorld(new CampaignLevel(4,5,11,12,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L06")) {
                Greenfoot.setWorld(new CampaignLevel(4,6,13,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L07")) {
                Greenfoot.setWorld(new CampaignLevel(4,7,12,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L08")) {
                Greenfoot.setWorld(new CampaignLevel(4,8,11,11,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L09")) {
                Greenfoot.setWorld(new CampaignLevel(4,9,12,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C04L10")) {
                Greenfoot.setWorld(new CampaignLevel(4,10,11,11,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L01")) {
                Greenfoot.setWorld(new CampaignLevel(5,1,9,3,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L02")) {
                Greenfoot.setWorld(new CampaignLevel(5,2,9,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L03")) {
                Greenfoot.setWorld(new CampaignLevel(5,3,9,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L04")) {
                Greenfoot.setWorld(new CampaignLevel(5,4,10,13,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L05")) {
                Greenfoot.setWorld(new CampaignLevel(5,5,11,10,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L06")) {
                Greenfoot.setWorld(new CampaignLevel(5,6,10,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L07")) {
                Greenfoot.setWorld(new CampaignLevel(5,7,9,11,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L08")) {
                Greenfoot.setWorld(new CampaignLevel(5,8,13,9,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L09")) {
                Greenfoot.setWorld(new CampaignLevel(5,9,13,13,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C05L10")) {
                Greenfoot.setWorld(new CampaignLevel(5,10,13,13,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L01")) {
                Greenfoot.setWorld(new CampaignLevel(6,1,13,6,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L02")) {
                Greenfoot.setWorld(new CampaignLevel(6,2,13,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L03")) {
                Greenfoot.setWorld(new CampaignLevel(6,3,13,11,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L04")) {
                Greenfoot.setWorld(new CampaignLevel(6,4,13,11,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L05")) {
                Greenfoot.setWorld(new CampaignLevel(6,5,15,11,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L06")) {
                Greenfoot.setWorld(new CampaignLevel(6,6,15,11,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L07")) {
                Greenfoot.setWorld(new CampaignLevel(6,7,12,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L08")) {
                Greenfoot.setWorld(new CampaignLevel(6,8,12,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L09")) {
                Greenfoot.setWorld(new CampaignLevel(6,9,13,7,50));
                Greenfoot.start();
            } else if (this.actualLevel.equals("C06L10")) {
                Greenfoot.setWorld(new CampaignLevel(6,10,13,7,50));
                Greenfoot.start();
            } else {
                this.buttons = new MenuButton[20];
                this.lbuttons = new ArrayList<LevelButton>();
                this.cbuttons = new ArrayList<ChapterButton>();
                this.progress = this.loadState();
                this.linesOfCode = this.getLinesOfCode();
                

                //If State does not exist: FIRST MODE
                //Name & Charakter
                this.exp = this.getExp(this.progress);
                this.setMode("Main");
                
              
                
                this.draw();
                
               
                
                
                Greenfoot.start();
                
                
                                
            } */
        } else {
            
            this.buttons = new MenuButton[20];
            this.lbuttons = new ArrayList<LevelButton>();
            this.cbuttons = new ArrayList<ChapterButton>();

            //If State does not exist: FIRST MODE
            //Name & Charakter
            this.progress = this.loadState();
            this.linesOfCode = this.getLinesOfCode();
            
            this.exp = this.getExp(this.progress);
            this.setMode("Main");

            
        
            this.draw();
            
            
            Greenfoot.start();
            
     
            
                        
        }
        
        
    }
    
    public Menu(boolean command)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        this.isOnCommand = command;
        
        this.buttons = new MenuButton[20];
        this.lbuttons = new ArrayList<LevelButton>();
        this.cbuttons = new ArrayList<ChapterButton>();
        this.progress = this.loadState();
        this.linesOfCode = this.getLinesOfCode();

        //If State does not exist: FIRST MODE
        //Name & Charakter
        this.exp = this.getExp(this.progress);
        this.setMode("Main");
        

        this.draw();
        this.actualLevel = this.getLevel();

        Greenfoot.start();
        
        
    }
    
    public Level reloadLevel(String path) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Level read = null;
        
        try {
            fis = new FileInputStream(path);
            
            ois = new ObjectInputStream(fis);
          
            read = (Level)ois.readObject();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if (ois != null) {
                try {
                    ois.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return read;
    }
    
    public int getLinesOfCode() {
        this.loc = new int[7][10];
        int sum = 0;
        
        int i = 0;
        //i = 0 --> [0][0]
        //i = 1 --> [0][1]
        //i = 10 --> [1][0]
        try {
            BufferedReader in = new BufferedReader(new FileReader("data/lines.txt"));
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                  this.loc[(int)(i/10)][(i%10)] = Integer.parseInt(x);
                  sum += this.loc[(int)(i/10)][(i%10)];
                  i++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        }
        
        /*
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if (progress[(i*10) + j] == true) {
                    //progress[0] (i = 0; j = 0) --> C01L01
                    //progess[1] (i = 0; j = 1) -->C01L02

                    sum += getLinesOfData(i+1,j+1);
                    

                }
            }

        }
        */
        return sum;
    }
    
    public int getNumberOfDoneLevels() {
        int sum = 0;
        for (int i = 0; i < this.progress.length; i++) {
            if (progress[i] == true) {
                sum++;
            }
        }
        return sum;
    }
    
    public int getLinesOfData(int chapter, int level) {
        int i = 0;
        try {
           BufferedReader in;
           
           if (level < 10) {

               in = new BufferedReader(new FileReader("../Lösungen/Lösung-Chapter0"+chapter+"-Level0"+level+".txt"));
           } else {

               in = new BufferedReader(new FileReader("../Lösungen/Lösung-Chapter0"+chapter+"-Level"+level+".txt"));
           }
           
           for (String x = in.readLine(); x != null; x = in.readLine()) {
              
               
               
               if ((x.contains("//") || x.contains("/*") || x.contains("*") || x.contains("*/")) && !x.contains(";")){

               } else {
                   i++;
                }
               
                
           }
           i -= 2;
           
           in.close();
           
           
           /* Array mit LoC
            * 
            * 
            */
           this.loc[chapter-1][level-1] = i;
           
           return i;
           
          
        } catch(IOException e) {
           return 0;
        } 

    }
    
    /**
     * Reads the currently accessed level, if the game was resetted while being in a level.
     * The level is being written in a file.
     */
    public String getLevel() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/actualLevel.txt"));
           return in.readLine();
        } catch(IOException e) {
           return "";
        } 
    }
    
    public String getName() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/name.txt"));
           String n = in.readLine();

           in.close();
           if (n != null) {
               if (n.equals("")) {
                   n = Greenfoot.ask("Wie ist dein Vorname?");
                
                   
                   this.saveName(n);
                   this.setKahla();
                   //Set Kahla as Standard-Character
                   
                   
                }
            } else {
                
                n = "";
               
                n = Greenfoot.ask("Wie ist dein Vorname?");
                
                this.saveName(n);
                this.setKahla();
            }
          
           return n;
        } catch(IOException e) {
            
           String n = Greenfoot.ask("Wie ist dein Vorname?");
          
           this.saveName(n);
           this.setKahla();
           return n;
        } 
    }
    
    public void saveName(String n) {
        try {
            
            BufferedWriter out = new BufferedWriter(new FileWriter("data/name.txt"));
            if (n == null) {
                out.write("");
            } else {
                out.write(n);
            }
            
            
            out.close();
        } catch (IOException e) {
            
        }
    }
    
    public void setKahla() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/character.txt"));  
            out.write("Kahla");
            out.close();
            
        } catch(IOException e) {
            
        } 
    }
    
    /**
     * Draws the Menu-Screen with Buttons, based on the current mode.
     * Main - Main-Menu
     * Level Select - Chapter-Selection
     * Credits - Credits
     * Statistics - Currently Experience
     * Chapter X - Level-Selection of a chosen Chapter
     */
    public void draw() {
        //Dependend on the Mode
        if (this.mode != null) {
            GreenfootImage gf = new GreenfootImage(600,800);
            this.clearButtons();
        
            if (this.mode.equals("Main")) {
                gf = this.drawMain(gf);
                this.addMainButtons();
            } else if (this.mode.equals("Level Select")) {
                gf = this.drawChapter(gf);
                this.addChapterMenuButtons();
            } else if (this.mode.equals("Credits")) {
                gf = this.drawCredits(gf);
                this.addCreditButtons();
            } else if (this.mode.equals("Statistics")) {
                gf = this.drawStatistics(gf);
                this.addStatisticsButtons();
            } else if (this.mode.equals("Options")) {
                gf = this.drawOptions(gf);
                this.addOptionsButtons();
            } else if (this.mode.equals("Hilfe")) {
                gf = this.drawHelp(gf,0);
                this.addHelpButtons();
            } else if (this.mode.equals("Others")) {
                gf = this.drawOthers(gf);
                this.addOthersButtons();
            } else if (this.mode.equals("Befehlsliste")) {
                gf = this.drawHelp(gf,1);
                this.addLevelOneButtons();
            } else if (this.mode.equals("Befehle")) {
                gf = this.drawHelp(gf,2);
                this.addLevelOneButtons();
            } else if (this.mode.equals("Bedingungen")) {
                gf = this.drawHelp(gf,3);
                this.addLevelOneButtons();
            } else if (this.mode.equals("Syntax")) {
                gf = this.drawHelp(gf,4);
                this.addLevelOneButtons();
            } else if (this.mode.equals("Konzepte")) {
                gf = this.drawHelp(gf,5);
                this.addLevelOneButtons();
            } else if (this.mode.equals("Spielelemente")) {
                gf = this.drawHelp(gf,6);
                this.addLevelOneButtons();
            } else if (this.mode.equals("Allgemeines")) {
                gf = this.drawHelp(gf,7);
                this.addLevelOneButtons();
            }
            
            else if (this.mode.equals("Schritt")) {
                gf = this.drawHelp(gf,200);
                this.addLevelTwoButtonsToCommand();
            } else if (this.mode.equals("Aufheben")) {
                gf = this.drawHelp(gf,201);
                this.addLevelTwoButtonsToCommand();
            } else if (this.mode.equals("Schießen")) {
                gf = this.drawHelp(gf,202);
                this.addLevelTwoButtonsToCommand();
            } else if (this.mode.equals("LinksDrehen")) {
                gf = this.drawHelp(gf,203);
                this.addLevelTwoButtonsToCommand();
            } else if (this.mode.equals("RechtsDrehen")) {
                gf = this.drawHelp(gf,204);
                this.addLevelTwoButtonsToCommand();
            } else if (this.mode.equals("Färben")) {
                gf = this.drawHelp(gf,205);
                this.addLevelTwoButtonsToCommand();
            } else if (this.mode.equals("Nehmen")) {
                gf = this.drawHelp(gf,206);
                this.addLevelTwoButtonsToCommand();
            } else if (this.mode.equals("Hinlegen")) {
                gf = this.drawHelp(gf,207);
                this.addLevelTwoButtonsToCommand();
            }
            
            
            else if (this.mode.equals("SiehtCheckpoint")) {
                gf = this.drawHelp(gf,300);
                this.addLevelTwoButtonsToCondition();
            } else if (this.mode.equals("IstAufToken")) {
                gf = this.drawHelp(gf,301);
                this.addLevelTwoButtonsToCondition();
            } else if (this.mode.equals("IstZielscheibeInReichweite")) {
                gf = this.drawHelp(gf,302);
                this.addLevelTwoButtonsToCondition();
            } else if (this.mode.equals("IstAufMarkierung")) {
                gf = this.drawHelp(gf,303);
                this.addLevelTwoButtonsToCondition();
            } else if (this.mode.equals("IstVorWand")) {
                gf = this.drawHelp(gf,304);
                this.addLevelTwoButtonsToCondition();
            } else if (this.mode.equals("IstVorKugel")) {
                gf = this.drawHelp(gf,305);
                this.addLevelTwoButtonsToCondition();
            } else if (this.mode.equals("HatKugel")) {
                gf = this.drawHelp(gf,306);
                this.addLevelTwoButtonsToCondition();
            }
            
            else if (this.mode.equals("Lesehinweise")) {
                gf = this.drawHelp(gf,400);
                this.addLevelTwoButtonsToSyntax();
            } else if (this.mode.equals("Programm")) {
                gf = this.drawHelp(gf,401);
                this.addLevelTwoButtonsToSyntax();
            }  else if (this.mode.equals("Prozeduren")) {
                gf = this.drawHelp(gf,402);
                this.addLevelTwoButtonsToSyntax();
            }  else if (this.mode.equals("Abfragen")) {
                gf = this.drawHelp(gf,403);
                this.addLevelTwoButtonsToSyntax();
            }  else if (this.mode.equals("Schleifen")) {
                gf = this.drawHelp(gf,404);
                this.addLevelTwoButtonsToSyntax();
            } else if (this.mode.equals("Boolsche Funktionen")) {
                gf = this.drawHelp(gf,405);
                this.addLevelTwoButtonsToSyntax();
            }
            
            
            else if (this.mode.equals("Programmierung")) {
                gf = this.drawHelp(gf,500);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Teile & Herrsche")) {
                gf = this.drawHelp(gf,501);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Prozeduren_2")) {
                gf = this.drawHelp(gf,502);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Camelcode")) {
                gf = this.drawHelp(gf,503);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Allgemeinheit")) {
                gf = this.drawHelp(gf,504);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Abfragen_2")) {
                gf = this.drawHelp(gf,505);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Schleifen_2")) {
                gf = this.drawHelp(gf,506);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Verneinung")) {
                gf = this.drawHelp(gf,507);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Boolsche Funktionen_2")) {
                gf = this.drawHelp(gf,508);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Endlosschleifen")) {
                gf = this.drawHelp(gf,509);
                this.addLevelTwoButtonsToConcept();
            } else if (this.mode.equals("Boolsche Verknüpfungen")) {
                gf = this.drawHelp(gf,510);
                this.addLevelTwoButtonsToConcept();
            } 
            
            else if (this.mode.equals("Welt")) {
                gf = this.drawHelp(gf,600);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Spielfigur")) {
                gf = this.drawHelp(gf,601);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Wand")) {
                gf = this.drawHelp(gf,602);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Checkpoint")) {
                gf = this.drawHelp(gf,603);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Token")) {
                gf = this.drawHelp(gf,604);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Zielscheibe")) {
                gf = this.drawHelp(gf,605);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Markierung")) {
                gf = this.drawHelp(gf,606);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Multi-Levels")) {
                gf = this.drawHelp(gf,607);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Kugel")) {
                gf = this.drawHelp(gf,608);
                this.addLevelTwoButtonsToElement();
            } else if (this.mode.equals("Plattform")) {
                gf = this.drawHelp(gf,609);
                this.addLevelTwoButtonsToElement();
            } 
            
            else if (this.mode.equals("Ändern der Spielfigur")) {
                gf = this.drawHelp(gf,700);
                this.addLevelTwoButtonsToGeneral();
            } else if (this.mode.equals("Erfahrungspunkte")) {
                gf = this.drawHelp(gf,701);
                this.addLevelTwoButtonsToGeneral();
            } else if (this.mode.equals("Lines of Code")) {
                gf = this.drawHelp(gf,702);
                this.addLevelTwoButtonsToGeneral();
            } else if (this.mode.equals("Levelbewertung")) {
                gf = this.drawHelp(gf,703);
                this.addLevelTwoButtonsToGeneral();
            } else if (this.mode.equals("Lösungen_2")) {
                gf = this.drawHelp(gf,704);
                this.addLevelTwoButtonsToGeneral();
            } 
            /* else if (this.mode.equals("Schritt")) {
                gf = this.drawCommands(gf,1);
                this.addCommandsExtraButtons();
            } else if (this.mode.equals("Aufheben")) {
                gf = this.drawCommands(gf,2);
                this.addCommandsExtraButtons();
            } else if (this.mode.equals("Schießen")) {
                gf = this.drawCommands(gf,3);
                this.addCommandsExtraButtons();
            } else if (this.mode.equals("LinksDrehen")) {
                gf = this.drawCommands(gf,4);
                this.addCommandsExtraButtons();
            } else if (this.mode.equals("RechtsDrehen")) {
                gf = this.drawCommands(gf,5);
                this.addCommandsExtraButtons();
            } else if (this.mode.equals("Syntax")) {
                gf = this.drawCommands(gf,8);
                this.addCommandsExtraButtons();
            } else if (this.mode.equals("Prozeduren")) {
                gf = this.drawCommands(gf,9);
                this.addCommandsExtraButtons();
            } else if (this.mode.equals("Abfragen")) {
                gf = this.drawCommands(gf,10);
                this.addCommandsExtraButtons();
            }*/ else if (this.mode.equals("Chapter One")) {
                gf = this.drawLevel(gf, 1);
                this.addLevelButtons();
            } else if (this.mode.equals("Chapter Two")) {
                gf = this.drawLevel(gf, 2);
                this.addLevelButtons();
            } else if (this.mode.equals("Chapter Three")) {
                gf = this.drawLevel(gf, 3);
                this.addLevelButtons();
            } else if (this.mode.equals("Chapter Four")) {
                gf = this.drawLevel(gf, 4);
                this.addLevelButtons();
            } else if (this.mode.equals("Chapter Five")) {
                gf = this.drawLevel(gf, 5);
                this.addLevelButtons();
            } else if (this.mode.equals("Chapter Six")) {
                gf = this.drawLevel(gf, 6);
                this.addLevelButtons();
            } else if (this.mode.equals("Chapter Seven")) {
                gf = this.drawLevel(gf, 7);
                this.addLevelButtons();
            }
            
            
            this.setBackground(gf);
        }
        
        //TODO ALLE BEFEHLE
        //TODO ALLE BEDINGUNGEN
        
        /*
         * 
         * this.buttons[0] = new MenuButton("Back",this);
        this.buttons[1] = new MenuButton("Schritt",this);
        this.buttons[2] = new MenuButton("Aufheben",this);
        this.buttons[3] = new MenuButton("Schießen",this);
        this.buttons[4] = new MenuButton("LinksDrehen",this);
        this.buttons[5] = new MenuButton("RechtsDrehen",this);
        this.buttons[6] = new MenuButton("Färben",this);
        
        this.buttons[7] = new MenuButton("Teile & Herrsche",this);
        this.buttons[8] = new MenuButton("Prozeduren",this);
        this.buttons[9] = new MenuButton("Syntax",this);
        this.buttons[10] = new MenuButton("Abfragen",this);
        
        this.buttons[11] = new MenuButton("Checkpoint",this);
        this.buttons[12] = new MenuButton("Token",this);
        this.buttons[13] = new MenuButton("Zielscheibe",this);
        this.buttons[14] = new MenuButton("Markierung",this);
    
        
         * 
         * 
         */
        
    }
    
    /**
     * Removes every used button on the Screen.
     * Used in every Mode-Change.
     */
    public void clearButtons() {
        if (buttons == null) {
            this.buttons = new MenuButton[20];
        }
        for (int i = 0; i < buttons.length; i++) {
            if (this.buttons[i] != null) {
                this.removeObject(this.buttons[i]);
            }
        }
        if (lbuttons == null) {
            this.lbuttons = new ArrayList<LevelButton>();
        }
        for (int i = 0; i < lbuttons.size(); i++) {
            this.removeObject(this.lbuttons.get(i));
        }
        if (cbuttons == null) {
            this.cbuttons = new ArrayList<ChapterButton>();
        }
        for (int i = 0; i < cbuttons.size(); i++) {
            this.removeObject(this.cbuttons.get(i));
        }
    }
    
    
    /**
     * Draws the main hub, which is the first seen screen.
     * Everything else is accessible from here.
     */
    public GreenfootImage drawMain(GreenfootImage gf) {
        this.progress = this.loadState();
        this.exp = this.getExp(this.progress);
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        gf.setColor(new Color(0,0,0,255));
        gf.setFont(new Font(30));
        gf.drawString("Willkommen bei Java mit Kahla", 90, 60);
        
        GreenfootImage cover = new GreenfootImage("Cover.png");
        cover.scale(400,400);
        gf.drawImage(cover,100,80);
        
        gf.setFont(new Font(24));
        
        
        gf.drawString("Willkommen, " + this.name + ".",60,780);
        
        gf.setFont(new Font(12));
        gf.drawString("V. 1.4.6",550,790);
        
        
        return gf;
    }
    
    public GreenfootImage drawOptions(GreenfootImage gf) {
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        gf.setColor(new Color(0,0,0,255));
        gf.setFont(new Font(30));
        gf.drawString("Optionen", 10, 60);
        gf.setFont(new Font(25));
        gf.drawString("Welchen Charakter möchtest du spielen?",20,100);
        
        gf.drawString("Möchtest du deinen Spielstand zurücksetzen?",20,200);
        gf.drawString("Möchtest du deine Lösungen einsehen?",20,310);
        
        return gf;
    }
    
    public GreenfootImage drawOthers(GreenfootImage gf) {
        // TODO
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        gf.setColor(new Color(0,0,0,255));
        gf.setFont(new Font(30));
        gf.drawString("Weitere Modi", 20, 60);
        gf.setFont(new Font(25));
        
        return gf;
    }
    
    /**
     * Draws the Chapter menu, which just lets the player choose a chapter.
     */
    public GreenfootImage drawChapter(GreenfootImage gf) {
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        gf.setColor(new Color(0,0,0,255));
        gf.setFont(new Font(30));
        gf.drawString("Kapitelauswahl", 10, 40);
        
        gf.setColor(new Color(0,0,130,255));
        gf.setFont(new Font(15));
        if (this.exp < 100) {
            gf.drawString("Noch " + (100-this.exp) + " EXP zum 2. Kapitel",400,30);
        } else if (this.exp < 200) {
            gf.drawString("Noch " + (200-this.exp) + " EXP zum 3. Kapitel",400,30);
        } else if (this.exp < 300) {
            gf.drawString("Noch " + (300-this.exp) + " EXP zum 4. Kapitel",400,30);
        } else if (this.exp < 400) {
            gf.drawString("Noch " + (400-this.exp) + " EXP zum 5. Kapitel",400,30);
        } else if (this.exp < 500) {
            gf.drawString("Noch " + (500-this.exp) + " EXP zum 6. Kapitel",400,30);
        } else if (this.exp < 600) {
            gf.drawString("Noch " + (600-this.exp) + " EXP zum 7. Kapitel",400,30);
        } 
        this.addChapterImage();
        
        
        
        
        return gf;
    }
    
    private void saveChapter(int chapter) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualChapter.txt"));  
            out.write(""+chapter);
            out.close();
            
        } catch(IOException e) {
            
        } 
    }
    
    /**
     * Draws the Level menu, based on a chosen chapter and lets the player choose a level.
     */
    public GreenfootImage drawLevel(GreenfootImage gf, int chapter) {
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        gf.setColor(new Color(0,0,0,255));
        gf.setFont(new Font(30));
        gf.drawString("Levelauswahl: Kapitel " + chapter, 10, 40);
        gf.setColor(new Color(0,0,130,255));
        gf.setFont(new Font(15));
        if (this.exp < 100) {
            gf.drawString("Noch " + (100-this.exp) + " EXP zum 2. Kapitel",400,30);
        } else if (this.exp < 200) {
            gf.drawString("Noch " + (200-this.exp) + " EXP zum 3. Kapitel",400,30);
        } else if (this.exp < 300) {
            gf.drawString("Noch " + (300-this.exp) + " EXP zum 4. Kapitel",400,30);
        } else if (this.exp < 400) {
            gf.drawString("Noch " + (400-this.exp) + " EXP zum 5. Kapitel",400,30);
        } else if (this.exp < 500) {
            gf.drawString("Noch " + (500-this.exp) + " EXP zum 6. Kapitel",400,30);
        } else if (this.exp < 600) {
            gf.drawString("Noch " + (600-this.exp) + " EXP zum 7. Kapitel",400,30);
        } 
        
        this.addLevelImage(chapter);
        this.saveChapter(chapter);
        
        return gf;
    }
    
    /**
     * Draws a credits screen with information about the author and the program.
     */
    public GreenfootImage drawCredits(GreenfootImage gf) {
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        gf.setColor(new Color(0,0,0,255));
        gf.setFont(new Font(30));
        gf.drawString("Credits", 80, 200);
        gf.drawString("Entwickler: Daniel Schisch", 80, 250);
        gf.drawString("Illustrationen: Hannah Elsner",80,290);
        
        
        
        return gf;
    }
    
    /**
     * Draws a statistics screen with information about the players progress.
     */
    public GreenfootImage drawStatistics(GreenfootImage gf) {
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        gf.setColor(new Color(0,0,0,255));
        gf.setFont(new Font(30));
        gf.drawString("Statistiken", 50, 200);
            
        gf.drawString("Erfahrungspunkte: "+exp+" EXP",50,240);
        gf.drawString("Geschaffte Levels: "+this.getNumberOfDoneLevels()+"/60 Levels",50,280);
        gf.drawString("LoC (Lines of Code): "+linesOfCode+" Zeilen",50,320);
        
        
        return gf;
    }
    
    public GreenfootImage drawHelp(GreenfootImage gf,int command) {
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        
        
        
        drawCommand(gf,command);
        
        /*
         * 
         * 
         * this.buttons[0] = new MenuButton("Back",this);
        this.buttons[1] = new MenuButton("Schritt",this);
        this.buttons[2] = new MenuButton("Aufheben",this);
        this.buttons[3] = new MenuButton("Schießen",this);
        this.buttons[4] = new MenuButton("LinksDrehen",this);
        this.buttons[5] = new MenuButton("RechtsDrehen",this);
        this.buttons[6] = new MenuButton("Färben",this);
        
        this.buttons[7] = new MenuButton("Teile & Herrsche",this);
        this.buttons[8] = new MenuButton("Prozeduren",this);
        this.buttons[9] = new MenuButton("Syntax",this);
        this.buttons[10] = new MenuButton("Abfragen",this);
        
        this.buttons[11] = new MenuButton("Checkpoint",this);
        this.buttons[12] = new MenuButton("Token",this);
        this.buttons[13] = new MenuButton("Zielscheibe",this);
        this.buttons[14] = new MenuButton("Markierung",this);
    
        
         * 
         * 
         */

        
        return gf;
    }
    
    public void drawCommand(GreenfootImage gf, int command) {
        gf.setColor(new Color(0,0,0,255));
        //gf.setFont(new Font("Arial", true, false, 25));
        
        if (command == 0) {
            //Texte und Inhalt zu Hilfe
            gf.setFont(new Font(30));
            gf.drawString("Hilfe", 20, 40);
        } else if (command == 1) {
            //Texte und Inhalte zur Befehlsliste
            gf.setFont(new Font(30));
            gf.drawString("Befehlsliste",20,40);
            
            gf.setFont(new Font(20));
            if (progress[0] == true) {
                gf.drawString("schritt();",60,120);
            }
            if (progress[2] == true) {
                gf.drawString("aufheben();",60,145);
            }
            if (progress[3] == true) {
                gf.drawString("schießen();",60,170);
            }
            if (progress[4] == true) {
                gf.drawString("linksDrehen();",60,195);
                gf.drawString("rechtsDrehen();",60,220);
            }
            if (progress[10] == true) {
                gf.drawString("färben();",60,245);
            }
            if (progress[21] == true) {
                gf.drawString("siehtCheckpoint()",300,120);
            }
            if (progress[22] == true) {
                gf.drawString("istAufToken()",300,145);
            }
            if (progress[23] == true) {
                gf.drawString("istZielscheibeInReichweite()",300,170);
            }
            if (progress[25] == true) {
                gf.drawString("istAufMarkierung()",300,195);
            }
            if (progress[32] == true) {
                gf.drawString("istVorWand()",300,220);
            }
            if (progress[40] == true) {
                gf.drawString("nehmen()",60,270);
                gf.drawString("hinlegen()",60,295);
            }
            if (progress[45] == true) {
                gf.drawString("istVorKugel()",300,245);
                gf.drawString("hatKugel()",300,270);
            }
        } else if (command == 2) {
            //Texte und Inhalte zu Befehlen
            gf.setFont(new Font(30));
            gf.drawString("Befehle",20,40);
            
            addCommandsButtons();
            
            
        } else if (command == 3) {
            //Texte und Inhalte zu Bedingungen
            gf.setFont(new Font(30));
            gf.drawString("Bedingungen",20,40);
            
            addConditionsButtons();
        } else if (command == 4) {
            //Texte und Inhalte zu Bedingungen
            gf.setFont(new Font(30));
            gf.drawString("Syntax",20,40);
            
            addSyntaxButtons();
        } else if (command == 5) {
            //Texte und Inhalte zu Bedingungen
            gf.setFont(new Font(30));
            gf.drawString("Konzepte",20,40);
            
            addConceptButtons();
        } else if (command == 6) {
            //Texte und Inhalte zu Bedingungen
            gf.setFont(new Font(30));
            gf.drawString("Spielelemente",20,40);
            
            addElementButtons();
        } else if (command == 7) {
            //Texte und Inhalte zu Bedingungen
            gf.setFont(new Font(30));
            gf.drawString("Allgemeines",20,40);
            
            addGeneralButtons();
        }
        
        else if (command == 200) {
            //Texte und Inhalte zu Schritt als Befehl
            gf.setFont(new Font(30));
            gf.drawString("Befehle",20,40);
            
            gf.setColor(new Color(0,0,0,255));
            gf.setFont(new Font("Arial", true, false, 25));
            int x = 50;
            int y = 75;
            gf.drawRect(x,y,500,100);
            gf.drawString("schritt();",x+50,y+55);
            //Bild hinzufügen
            GreenfootImage s1 = new GreenfootImage("Schritt1-2.png");
            gf.drawImage(s1,x+225,y+25);
            
            GreenfootImage s2 = new GreenfootImage("Schritt2.png");
            gf.drawImage(s2,x+375,y+25);
            GreenfootImage s3 = new GreenfootImage("Pfeil2.png");
            s3.scale(50, 50);
            gf.drawImage(s3,x+330,y+27);
            
            gf.setFont(new Font(24));
            gf.drawString("Der Schritt-Befehl lässt die Spielfigur genau\nein Feld in Blickrichtung bewegen.",x+10,y+140);
            //Erklärung
            
            gf.drawRect(x,y,200,100);
            gf.drawRect(x,y,500,200);
            
            
        } else if (command == 201) {
            //Texte und Inhalte zu Aufheben als Befehl
            gf.setFont(new Font(30));
            gf.drawString("Befehle",20,40);
            
            gf.setColor(new Color(0,0,0,255));
            gf.setFont(new Font("Arial", true, false, 25));
            int x = 50;
            int y = 75;
            gf.drawRect(x,y,500,100);
            gf.drawString("aufheben();",x+10,y+55);
            //Bild hinzufügen
            GreenfootImage s1 = new GreenfootImage("Token2.png");
           
            gf.drawImage(s1,x+165,y+25);
            
            GreenfootImage s2 = new GreenfootImage("Token3.PNG");
            gf.drawImage(s2,x+320,y+25);
            GreenfootImage s3 = new GreenfootImage("Pfeil2.png");
            s3.scale(50, 50);
            gf.drawImage(s3,x+270,y+27);
            
            GreenfootImage s4 = new GreenfootImage("Token4.PNG");
            gf.drawImage(s4,x+425,y+25);
            GreenfootImage s5 = new GreenfootImage("Pfeil2.png");
            s5.scale(50, 50);
            gf.drawImage(s5,x+375,y+27);
            
            
            gf.setFont(new Font(24));
            gf.drawString("Der Aufheben-Befehl lässt die Spielfigur ein\nToken aufheben, wenn sich dieses genau\nunter ihr befindet.",x+10,y+140);
            gf.drawRect(x,y,150,100);
            gf.drawRect(x,y,500,300);
        } else if (command == 202) {
            //Texte und Inhalte zu Schießen als Befehl
            gf.setFont(new Font(30));
            gf.drawString("Befehle",20,40);
            
            gf.setColor(new Color(0,0,0,255));
            gf.setFont(new Font("Arial", true, false, 25));
            int x = 50;
            int y = 75;
            gf.drawRect(x,y,500,100);
            gf.drawString("schießen();",x+10,y+55);
            //Bild hinzufügen
            
            
            GreenfootImage s2 = new GreenfootImage("Target2.PNG");
            s2.scale(140,50);
            gf.drawImage(s2,x+155,y+25);
            GreenfootImage s3 = new GreenfootImage("Pfeil2.png");
            s3.scale(50, 50);
            gf.drawImage(s3,x+295,y+27);
            
            GreenfootImage s4 = new GreenfootImage("Target3.PNG");
            s4.scale(140,50);
            gf.drawImage(s4,x+345,y+25);
            
            
            gf.setFont(new Font(24));
            gf.drawString("Der Schießen-Befehl lässt deine Figur einen\nFarbkleks in die Blickrichtung schießen.\nDieser Farbklecks trifft stets das Feld,\nwelches sich genau zwei Felder vor ihr\nbefindet.\nDadurch kann man auch Zielscheiben treffen.",x+10,y+140);
            gf.drawRect(x,y,150,100);
            gf.drawRect(x,y,500,320);
        } else if (command == 203) {
            //Texte und Inhalte zu LinksDrehen als Befehl
            gf.setFont(new Font(30));
            gf.drawString("Befehle",20,40);
            
            gf.setColor(new Color(0,0,0,255));
            gf.setFont(new Font("Arial", true, false, 25));
            int x = 50;
            int y = 75;
            gf.drawRect(x,y,500,100);
            gf.drawString("linksDrehen();",x+20,y+55);
            //Bild hinzufügen
            GreenfootImage s1 = new GreenfootImage("Turn1-1.png");
            gf.drawImage(s1,x+260,y+25);
            
            GreenfootImage s3 = new GreenfootImage("Pfeil2.png");
            s3.scale(50, 50);
            gf.drawImage(s3,x+320,y+27);
            
            GreenfootImage s2 = new GreenfootImage("Turn2.PNG");
            gf.drawImage(s2,x+370,y+25);
            gf.setFont(new Font(24));
            gf.drawString("Der LinksDrehen-Befehl lässt deine Figur\neine Drehung um genau 90° nach\nlinks durchführen.",x+10,y+140);
            gf.drawRect(x,y,200,100);
            gf.drawRect(x,y,500,250);
        } else if (command == 204) {
             //Texte und Inhalte zu RechtsDrehen als Befehl
            gf.setFont(new Font(30));
            gf.drawString("Befehle",20,40);
            
            gf.setColor(new Color(0,0,0,255));
            gf.setFont(new Font("Arial", true, false, 25));
            int x = 50;
            int y = 75;
            gf.drawRect(x,y,500,100);
            gf.drawString("rechtsDrehen();",x+10,y+55);
            //Bild hinzufügen
            GreenfootImage s1 = new GreenfootImage("Turn1-2.png");
            gf.drawImage(s1,x+260,y+25);
            
            GreenfootImage s3 = new GreenfootImage("Pfeil2.png");
            s3.scale(50, 50);
            gf.drawImage(s3,x+320,y+27);
            
            GreenfootImage s2 = new GreenfootImage("Turn3.PNG");
            gf.drawImage(s2,x+370,y+25);
            gf.setFont(new Font(24));
            gf.drawString("Der LinksDrehen-Befehl lässt deine Figur\neine Drehung um genau 90° nach\nrechts durchführen.",x+10,y+140);
            gf.drawRect(x,y,200,100);
            gf.drawRect(x,y,500,250);
        }
        
        
        
        
        
        
        
        
        else if (command == 500) {
            //Texte und Inhalte zu Programmierung als Konzept
            gf.setFont(new Font(30));
            gf.drawString("Konzepte",20,40);
            
            gf.setFont(new Font(28));
            gf.drawString("Programmierung",180,120);
            
            gf.setFont(new Font(25));
            gf.drawString("Unter Programmierung versteht man die gezielte\nSteuerung eines Gegenstandes zur Lösung von\nProblemen.\n\nUm einen solchen Gegenstand steuern zu können,\nmuss man sich erst in einer Sprache ausdrücken,\ndie dieser versteht.\nDiese Sprache wird als Programmiersprache\nbezeichnet und unterliegt strengen Regeln, auch\nSyntax genannt.\n\nIn unserem Beispiel möchten wir Kahla oder Farbi\nin ihrer Welt steuern. Dazu verwenden wir die\nProgrammiersprache 'Java-Kahla', welches eine\nUnterart der bekannten Programmiersprache\n'Java' ist.",20,170);
            
            
            
        } else if (command == 501) {
            //Texte und Inhalte zu Teile & Herrsche als Konzept
            gf.setFont(new Font(30));
            gf.drawString("Konzepte",20,40);
            
            gf.setFont(new Font(28));
            gf.drawString("Teile & Herrsche",210,120);
            
            gf.setFont(new Font(25));
            gf.drawString("Wenn ein umständliches oder großes Problem\nvorliegt, kann es sehr schwer sein, dieses auf\nAnhieb zu lösen.\nIn diesen Fällen eignet es sich sehr, mit einer\nanderen Vorgehensweise das Problem anzugehen.\nEine solche Vorgehensweise findet sich mit dem\nKonzept 'Teile & Herrsche'\n(Divide et impera oder Divide and Conquer).\n\nVom Prinzip her verläuft die Lösung eines großen\nProblems dabei in drei Schritten:\n1. Teile das Problem in möglichst viele kleine\nTeilprobleme auf.\n2. Löse diese Teilprobleme.\n3. Kombiniere diese Teillösungen zu einer\nGesamtlösung.",20,170);
            
            
            
        }
        /*
        
        
       
        } else if (command == 6) {
            
        } else if (command == 8) {
            //Befehlssyntax.

            if (progress[21] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,150);
                GreenfootImage s1 = new GreenfootImage("UI/A07/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Befehle:",x+10,y+210);
                
                gf.drawRect(x-20,y+220,540,320);
                GreenfootImage s2 = new GreenfootImage("UI/A07/Befehl.png");
                gf.drawImage(s2,x,y+230);
            } else if (progress[11] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,100);
                GreenfootImage s1 = new GreenfootImage("UI/A06/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Befehle:",x+10,y+160);
                
                gf.drawRect(x-20,y+170,540,320);
                GreenfootImage s2 = new GreenfootImage("UI/A06/Befehl.png");
                gf.drawImage(s2,x,y+180);
            } else if (progress[10] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,100);
                GreenfootImage s1 = new GreenfootImage("UI/A05/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Befehle:",x+10,y+160);
                
                gf.drawRect(x-20,y+170,540,270);
                GreenfootImage s2 = new GreenfootImage("UI/A05/Befehl.png");
                gf.drawImage(s2,x,y+180);
            } else if (progress[4] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,100);
                GreenfootImage s1 = new GreenfootImage("UI/A04/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Befehle:",x+10,y+160);
                
                gf.drawRect(x-20,y+170,540,230);
                GreenfootImage s2 = new GreenfootImage("UI/A04/Befehl.png");
                gf.drawImage(s2,x,y+180);
            } else if (progress[3] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,100);
                GreenfootImage s1 = new GreenfootImage("UI/A03/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Befehle:",x+10,y+160);
                
                gf.drawRect(x-20,y+170,540,140);
                GreenfootImage s2 = new GreenfootImage("UI/A03/Befehl.png");
                gf.drawImage(s2,x,y+180);
            } else if (progress[2] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,100);
                GreenfootImage s1 = new GreenfootImage("UI/A02/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Befehle:",x+10,y+160);
                
                gf.drawRect(x-20,y+170,540,100);
                GreenfootImage s2 = new GreenfootImage("UI/A02/Befehl.png");
                gf.drawImage(s2,x,y+180);
            } else if (progress[0] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                gf.drawRect(x-20,y+20,540,100);
                GreenfootImage s1 = new GreenfootImage("UI/A01/Programm.png");
                gf.drawImage(s1,x,y+30);
            }
        } else if (command == 9) {
            //Prozedursyntax.

            if (progress[21] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,150);
                GreenfootImage s1 = new GreenfootImage("UI/A07/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Prozedur:",x+10,y+210);
                
                gf.drawRect(x-20,y+220,540,150);
                GreenfootImage s2 = new GreenfootImage("UI/A07/Prozedur.png");
                gf.drawImage(s2,x,y+230);
                
                gf.setFont(new Font(24));
                gf.drawString("public void prozedurName() {\n//Hier steht, was dein Befehl machen soll.\n}",30,500);
            } else if (progress[11] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,100);
                GreenfootImage s1 = new GreenfootImage("UI/A06/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Prozedur:",x+10,y+160);
                
                gf.drawRect(x-20,y+170,540,100);
                GreenfootImage s2 = new GreenfootImage("UI/A06/Prozedur.png");
                gf.drawImage(s2,x,y+180);
                gf.setFont(new Font(24));
                gf.drawString("public void prozedurName() {\n//Hier steht, was dein Befehl machen soll.\n}",30,500);
            }
        } else if (command == 10) {
            //Abfragensyntax.
            
            if (progress[24] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,150);
                GreenfootImage s1 = new GreenfootImage("UI/A10/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Abfrage:",x+10,y+210);
                
                gf.drawRect(x-20,y+220,540,160);
                GreenfootImage s2 = new GreenfootImage("UI/A10/Abfrage.png");
                gf.drawImage(s2,x,y+230);
                
                gf.drawString("Alternative:",x+10,y+410);
                
                gf.drawRect(x-20,y+430,540,200);
                GreenfootImage s3 = new GreenfootImage("UI/A10/Alternative.png");
                gf.drawImage(s3,x,y+440);
                
                
            } else if (progress[23] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,150);
                GreenfootImage s1 = new GreenfootImage("UI/A09/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Abfrage:",x+10,y+210);
                
                gf.drawRect(x-20,y+220,540,150);
                GreenfootImage s2 = new GreenfootImage("UI/A09/Abfrage.png");
                gf.drawImage(s2,x,y+230);
                
                gf.drawString("Bedingung:",x+10,y+410);
                
                gf.drawRect(x-20,y+430,540,150);
                GreenfootImage s3 = new GreenfootImage("UI/A09/Bedingung.png");
                gf.drawImage(s3,x,y+440);
                
                
            } else if (progress[22] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,150);
                GreenfootImage s1 = new GreenfootImage("UI/A08/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Abfrage:",x+10,y+210);
                
                gf.drawRect(x-20,y+220,540,150);
                GreenfootImage s2 = new GreenfootImage("UI/A08/Abfrage.png");
                gf.drawImage(s2,x,y+230);
                
                gf.drawString("Bedingung:",x+10,y+410);
                
                gf.drawRect(x-20,y+430,540,100);
                GreenfootImage s3 = new GreenfootImage("UI/A08/Bedingung.png");
                gf.drawImage(s3,x,y+440);
                
                
            } else if (progress[21] == true) {
                gf.drawString("Syntax:",x+10,y+10);
                
                gf.drawRect(x-20,y+20,540,150);
                GreenfootImage s1 = new GreenfootImage("UI/A07/Programm.png");
                gf.drawImage(s1,x,y+30);
                
                gf.drawString("Abfrage:",x+10,y+210);
                
                gf.drawRect(x-20,y+220,540,150);
                GreenfootImage s2 = new GreenfootImage("UI/A07/Abfrage.png");
                gf.drawImage(s2,x,y+230);
            }
        }
        */
        /*
         * 
         * this.buttons[0] = new MenuButton("Back",this);
        this.buttons[1] = new MenuButton("Schritt",this);
        this.buttons[2] = new MenuButton("Aufheben",this);
        this.buttons[3] = new MenuButton("Schießen",this);
        this.buttons[4] = new MenuButton("LinksDrehen",this);
        this.buttons[5] = new MenuButton("RechtsDrehen",this);
        this.buttons[6] = new MenuButton("Färben",this);
        
        this.buttons[7] = new MenuButton("Teile & Herrsche",this);
        this.buttons[8] = new MenuButton("Prozeduren",this);
        this.buttons[9] = new MenuButton("Syntax",this);
        this.buttons[10] = new MenuButton("Abfragen",this);
        
        this.buttons[11] = new MenuButton("Checkpoint",this);
        this.buttons[12] = new MenuButton("Token",this);
        this.buttons[13] = new MenuButton("Zielscheibe",this);
        this.buttons[14] = new MenuButton("Markierung",this);
    
        
         * 
         * 
         */
        
        
    }
    
    public void addHelpButtons() {
       
        if (this.isOnCommand == true) {
            this.buttons[0] = new MenuButton(" Back ",this);
        } else {
            this.buttons[0] = new MenuButton("Back",this);
        }
        
        this.buttons[1] = new MenuButton("Befehlsliste",this);
        this.buttons[2] = new MenuButton("Befehle",this);
        this.buttons[3] = new MenuButton("Bedingungen",this);
        this.buttons[4] = new MenuButton("Syntax",this);
        this.buttons[5] = new MenuButton("Konzepte",this);
        this.buttons[6] = new MenuButton("Spielelemente",this);
        this.buttons[7] = new MenuButton("Allgemeines",this);

        
        this.addObject(this.buttons[0],500,750);
        this.addObject(this.buttons[1],200,100);
        this.addObject(this.buttons[2],200,150);
        this.addObject(this.buttons[3],200,200);
        this.addObject(this.buttons[4],200,250);
        this.addObject(this.buttons[5],200,300);
        this.addObject(this.buttons[6],200,350);
        this.addObject(this.buttons[7],200,400);
        
     
        this.buttons[15] = new MenuButton("Lösungen",this,"Main");
        this.addObject(this.buttons[15],200,750);
                        
    }
    
    
    
    public void addLevelOneButtons() {
        
        this.buttons[0] = new MenuButton("Hilfe",this);
        this.addObject(this.buttons[0],300,750);

    }
    
    public void addLevelTwoButtonsToCommand() {
        this.buttons[0] = new MenuButton("Befehle",this);
        this.addObject(this.buttons[0],300,750);
    }
    
    public void addLevelTwoButtonsToCondition() {
        this.buttons[0] = new MenuButton("Bedingungen",this);
        this.addObject(this.buttons[0],300,750);
    }
    
    public void addLevelTwoButtonsToSyntax() {
        this.buttons[0] = new MenuButton("Syntax",this);
        this.addObject(this.buttons[0],300,750);
    }
    
    public void addLevelTwoButtonsToConcept() {
        this.buttons[0] = new MenuButton("Konzepte",this);
        this.addObject(this.buttons[0],300,750);
    }
    
    public void addLevelTwoButtonsToElement() {
        this.buttons[0] = new MenuButton("Spielelemente",this);
        this.addObject(this.buttons[0],300,750);
    }
    
    public void addLevelTwoButtonsToGeneral() {
        this.buttons[0] = new MenuButton("Allgemeines",this);
        this.addObject(this.buttons[0],300,750);
    }
    
    
    public void addCommandsButtons() {
        this.buttons[1] = new MenuButton("Schritt",this);
        this.buttons[2] = new MenuButton("Aufheben",this);
        this.buttons[3] = new MenuButton("Schießen",this);
        this.buttons[4] = new MenuButton("LinksDrehen",this);
        this.buttons[5] = new MenuButton("RechtsDrehen",this);
        this.buttons[6] = new MenuButton("Färben",this);
        this.buttons[7] = new MenuButton("Nehmen",this);
        this.buttons[8] = new MenuButton("Hinlegen",this);
        
        this.addObject(this.buttons[1],200,100);
        this.addObject(this.buttons[2],200,150);
        this.addObject(this.buttons[3],200,200);
        this.addObject(this.buttons[4],200,250);
        this.addObject(this.buttons[5],200,300);
        this.addObject(this.buttons[6],200,350);
        this.addObject(this.buttons[7],200,400);
        this.addObject(this.buttons[8],200,450);
    }
    
    public void addConditionsButtons() {
        this.buttons[1] = new MenuButton("SiehtCheckpoint",this);
        this.buttons[2] = new MenuButton("IstAufToken",this);
        this.buttons[3] = new MenuButton("IstZielscheibeInReichweite",this);
        this.buttons[4] = new MenuButton("IstAufMarkierung",this);
        this.buttons[5] = new MenuButton("IstVorWand",this);
        this.buttons[6] = new MenuButton("IstVorKugel",this);
        this.buttons[7] = new MenuButton("HatKugel",this);
        
        this.addObject(this.buttons[1],200,100);
        this.addObject(this.buttons[2],200,150);
        this.addObject(this.buttons[3],200,200);
        this.addObject(this.buttons[4],200,250);
        this.addObject(this.buttons[5],200,300);
        this.addObject(this.buttons[6],200,350);
        this.addObject(this.buttons[7],200,400);
    }
    
    public void addSyntaxButtons() {
        this.buttons[1] = new MenuButton("Lesehinweise",this);
        this.buttons[2] = new MenuButton("Programm",this);
        this.buttons[3] = new MenuButton("Prozeduren",this,"Syntax");
        this.buttons[4] = new MenuButton("Abfragen",this,"Syntax");
        this.buttons[5] = new MenuButton("Schleifen",this,"Syntax");
        this.buttons[6] = new MenuButton("Boolsche Funktionen",this,"Syntax");

        
        this.addObject(this.buttons[1],200,100);
        this.addObject(this.buttons[2],200,150);
        this.addObject(this.buttons[3],200,200);
        this.addObject(this.buttons[4],200,250);
        this.addObject(this.buttons[5],200,300);
        this.addObject(this.buttons[6],200,350);
    }
    
    public void addConceptButtons() {
        this.buttons[1] = new MenuButton("Programmierung",this);
        this.buttons[2] = new MenuButton("Teile & Herrsche",this);
        this.buttons[3] = new MenuButton("Prozeduren",this,"Konzepte");
        this.buttons[4] = new MenuButton("Camelcode",this);
        this.buttons[5] = new MenuButton("Allgemeinheit",this);
        this.buttons[6] = new MenuButton("Abfragen",this,"Konzepte");
        this.buttons[7] = new MenuButton("Schleifen",this,"Konzepte");
        this.buttons[8] = new MenuButton("Verneinung",this);
        this.buttons[9] = new MenuButton("Boolsche Funktionen",this,"Konzepte");
        this.buttons[10] = new MenuButton("Endlosschleifen",this);
        this.buttons[11] = new MenuButton("Boolsche Verknüpfungen",this);

        
        this.addObject(this.buttons[1],200,100);
        this.addObject(this.buttons[2],200,150);
        this.addObject(this.buttons[3],200,200);
        this.addObject(this.buttons[4],200,250);
        this.addObject(this.buttons[5],200,300);
        this.addObject(this.buttons[6],200,350);
        this.addObject(this.buttons[7],200,400);
        this.addObject(this.buttons[8],200,450);
        this.addObject(this.buttons[9],200,500);
        this.addObject(this.buttons[10],200,550);
        this.addObject(this.buttons[11],200,600);
    }
    
    public void addElementButtons() {
        this.buttons[1] = new MenuButton("Welt",this);
        this.buttons[2] = new MenuButton("Spielfigur",this);
        this.buttons[3] = new MenuButton("Wand",this);
        this.buttons[4] = new MenuButton("Checkpoint",this);
        this.buttons[5] = new MenuButton("Token",this);
        this.buttons[6] = new MenuButton("Zielscheibe",this);
        this.buttons[7] = new MenuButton("Markierung",this);
        this.buttons[8] = new MenuButton("Multi-Levels",this);
        this.buttons[9] = new MenuButton("Kugel",this);
        this.buttons[10] = new MenuButton("Plattform",this);


        
        this.addObject(this.buttons[1],200,100);
        this.addObject(this.buttons[2],200,150);
        this.addObject(this.buttons[3],200,200);
        this.addObject(this.buttons[4],200,250);
        this.addObject(this.buttons[5],200,300);
        this.addObject(this.buttons[6],200,350);
        this.addObject(this.buttons[7],200,400);
        this.addObject(this.buttons[8],200,450);
        this.addObject(this.buttons[9],200,500);
        this.addObject(this.buttons[10],200,550);
    }
    
    public void addGeneralButtons() {
        this.buttons[1] = new MenuButton("Ändern der Spielfigur",this);
        this.buttons[2] = new MenuButton("Erfahrungspunkte",this);
        this.buttons[3] = new MenuButton("Lines of Code",this);
        this.buttons[4] = new MenuButton("Levelbewertung",this);
        this.buttons[5] = new MenuButton("Lösungen",this,"General");
        
        
        this.addObject(this.buttons[1],200,100);
        this.addObject(this.buttons[2],200,150);
        this.addObject(this.buttons[3],200,200);
        this.addObject(this.buttons[4],200,250);
        this.addObject(this.buttons[5],200,300);
        
    }
    
    public boolean checkChapterProgress(int chapter) {
        return (progress[(chapter-1)*10+0] && progress[(chapter-1)*10+1] && progress[(chapter-1)*10+2] && progress[(chapter-1)*10+3] && progress[(chapter-1)*10 +4] && progress[(chapter-1)*10+5] && progress[(chapter-1)*10+6] && progress[(chapter-1)*10+7] && progress[(chapter-1)*10+8] && progress[(chapter-1)*10+9]);
    }
    /**
     * Designs the chapter Menu and equips it with the correct buttons.
     */
    public void addChapterImage() {
        
        if (checkChapterProgress(1)) {
            ChapterButton cb1 = new ChapterButton("Kapitel 1 ★",this);
            this.cbuttons.add(cb1);
            this.addObject(cb1, 300, 150);
        } else {
            ChapterButton cb1 = new ChapterButton("Kapitel 1",this);
            this.cbuttons.add(cb1);
            this.addObject(cb1, 300, 150);
        }
        
        if (checkChapterProgress(2)) {
            ChapterButton cb2 = new ChapterButton("Kapitel 2 ★",this);
            this.cbuttons.add(cb2);
            this.addObject(cb2, 300, 250);
        } else {
            ChapterButton cb2 = new ChapterButton("Kapitel 2",this);
            this.cbuttons.add(cb2);
            this.addObject(cb2, 300, 250);
        }
        
        if (checkChapterProgress(3)) {
            ChapterButton cb3 = new ChapterButton("Kapitel 3 ★",this);
            this.cbuttons.add(cb3);
            this.addObject(cb3, 300, 350);
        } else {
            ChapterButton cb3 = new ChapterButton("Kapitel 3",this);
            this.cbuttons.add(cb3);
            this.addObject(cb3, 300, 350);
        }
        
        if (checkChapterProgress(4)) {
            ChapterButton cb4 = new ChapterButton("Kapitel 4 ★",this);
            this.cbuttons.add(cb4);
            this.addObject(cb4, 300, 450);
        } else {
            ChapterButton cb4 = new ChapterButton("Kapitel 4",this);
            this.cbuttons.add(cb4);
            this.addObject(cb4, 300, 450);
        }
        
        if (checkChapterProgress(5)) {
            ChapterButton cb5 = new ChapterButton("Kapitel 5 ★",this);
            this.cbuttons.add(cb5);
            this.addObject(cb5, 300, 550);
        } else {
            ChapterButton cb5 = new ChapterButton("Kapitel 5",this);
            this.cbuttons.add(cb5);
            this.addObject(cb5, 300, 550);
        }
        
        if (checkChapterProgress(6)) {
            ChapterButton cb6 = new ChapterButton("Kapitel 6 ★",this);
            this.cbuttons.add(cb6);
            this.addObject(cb6, 300, 650);
        } else {
            ChapterButton cb6 = new ChapterButton("Kapitel 6",this);
            this.cbuttons.add(cb6);
            this.addObject(cb6, 300, 650);
        } 
    }
    
    /**
     * Loads the progress from a file.
     * Has information about every finished stage.
     */
    public boolean[] loadState() {
        boolean[] progress = new boolean[60];
        
        String txt = "";
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/state.txt"));
           int i = 0;
           try {
               for (String x = in.readLine(); x != null; x = in.readLine()) {
                   if (x.contains("y")) {
                       progress[i] = true;    
                   } else if (x.contains("n")) {
                       progress[i] = false;
                   }
                   i++;
               }
           } catch(IOException e) {
               for (int j = 0; j < 60; j++) {
                   progress[j] = false;
               }
           }
           
        } catch (FileNotFoundException e) {
            for (int j = 0; j < 60; j++) {
                   progress[j] = false;
            }
        }
        
        return progress;
    }
    
    /**
     * Keeps information, which levels are locked under circumstances.
     */
    private boolean getLocked(int chapter, int level) {
        //New Conditions
        if (chapter == 1) {
            //Tutorial-Conditions
            if (level == 1) {
                return false;
            }
            if (level == 2 && progress[0]) {
                return false;
            }
            if (level == 3 && progress[0] && progress[1]) {
                return false;
            }
            if (level == 4 && progress[0] && progress[1] && progress[2]) {
                return false;
            }
            if (progress[0] && progress[1] && progress[2] && progress[3]) {
                if (level == 5) {
                    return false;
                }
                if (progress[4]) {
                    return false;
                }
                
            }
        } else if (chapter == 2) {
            //Tutorial-Conditions
            if (level == 1) {
                return false;
            }
            if (level == 2 && progress[10]) {
                return false;
            }
            //Nicht-Tutorial-Levels
            if (progress[10] && progress[11]) {
                return false;
            }
        } else if (chapter == 3) {
            if (level == 1) {
                return false;
            }
            if (level == 2 && progress[20]) {
                return false;
            }
            if (level == 3 && progress[20] && progress[21]) {
                return false;
            }
            if (level == 4 && progress[20] && progress[21] && progress[22]) {
                return false;
            }
            if (level == 5 && progress[20] && progress[21] && progress[22] && progress[23]) {
                return false;
            }
            if (progress[20] && progress[21] && progress[22] && progress[23] && progress[24]) {
                return false;
            }
        } else if (chapter == 4) {
            if (level == 1) {
                return false;
            }
            if (level == 2 && progress[30]) {
                return false;
            }
            if (level == 3 && progress[30] && progress[31]) {
                return false;
            }
            if (level == 4 && progress[30] && progress[31] && progress[32]) {
                return false;
            }
            if (level == 5 && progress[30] && progress[31] && progress[32] && progress[33]) {
                return false;
            }
            if (progress[30] && progress[31] && progress[32] && progress[33] && progress[34]) {
                return false;
            }
        } else if (chapter == 5) {
            if (level == 1) {
                return false;
            }
            if (level == 2 && progress[40]) {
                return false;
            }
            if (level == 3 && progress[40] && progress[41]) {
                return false;
            }
            if (level == 4 && progress[40] && progress[41] && progress[42]) {
                return false;
            }
            if (level == 5 && progress[40] && progress[41] && progress[42] && progress[43]) {
                return false;
            }
            if (progress[40] && progress[41] && progress[42] && progress[43] && progress[44]) {
                return false;
            }
        } else if (chapter == 6) {
            if (level == 1) {
                return false;
            }
            if (level == 2 && progress[50]) {
                return false;
            }
            if (level == 3 && progress[50]) {
                return false;
            }
            if (level == 4 && progress[50]) {
                return false;
            }
            if (level == 5 && progress[53]) {
                return false;
            }
            if (level == 6 && progress[54]) {
                return false;
            }
            if (level == 7 && progress[50]) {
                return false;
            }
            if (level == 8 && progress[56]) {
                return false;
            }
            if (level == 9 && progress[57]) {
                return false;
            }
            if (level == 10 && progress[58]) {
                return false;
            }
            
        }
        return true;
    }
    
    /**
     * Returns a statement, whether a certain level has been completed.
     */
    private boolean getDone(int chapter, int level) {
        return this.progress[(chapter-1)*10+(level-1)];
    }
    
    /**
     * Calculates the EXP, based on the current progress.
     */
    private int getExp(boolean[] progress) {
        
        int exp = 0;
        if (progress[0] == true) {
            exp += 10;
        }
        if (progress[1] == true) {
            exp += 10;
        }
        if (progress[2] == true) {
            exp += 10;
        }
        if (progress[3] == true) {
            exp += 10;
        }
        if (progress[4] == true) {
            exp += 10;
        }
        if (progress[5] == true) {
            exp += 10;
        }
        if (progress[6] == true) {
            exp += 10;
        }
        if (progress[7] == true) {
            exp += 20;
        }
        if (progress[8] == true) {
            exp += 20;
        }
        if (progress[9] == true) {
            exp += 30;
        }
        if (progress[10] == true) {
            exp += 10;
        }
        if (progress[11] == true) {
            exp += 10;
        }
        if (progress[12] == true) {
            exp += 10;
        }
        if (progress[13] == true) {
            exp += 10;
        }
        if (progress[14] == true) {
            exp += 10;
        }
        if (progress[15] == true) {
            exp += 10;
        }
        if (progress[16] == true) {
            exp += 10;
        }
        if (progress[17] == true) {
            exp += 20;
        }
        if (progress[18] == true) {
            exp += 20;
        }
        if (progress[19] == true) {
            exp += 30;
        }
        if (progress[20] == true) {
            exp += 10;
        }
        if (progress[21] == true) {
            exp += 10;
        }
        if (progress[22] == true) {
            exp += 10;
        }
        if (progress[23] == true) {
            exp += 10;
        }
        if (progress[24] == true) {
            exp += 10;
        }
        if (progress[25] == true) {
            exp += 10;
        }
        if (progress[26] == true) {
            exp += 10;
        }
        if (progress[27] == true) {
            exp += 20;
        }
        if (progress[28] == true) {
            exp += 20;
        }
        if (progress[29] == true) {
            exp += 30;
        }
        if (progress[30] == true) {
            exp += 10;
        }
        if (progress[31] == true) {
            exp += 10;
        }
        if (progress[32] == true) {
            exp += 10;
        }
        if (progress[33] == true) {
            exp += 10;
        }
        if (progress[34] == true) {
            exp += 10;
        }
        if (progress[35] == true) {
            exp += 10;
        }
        if (progress[36] == true) {
            exp += 10;
        }
        if (progress[37] == true) {
            exp += 20;
        }
        if (progress[38] == true) {
            exp += 20;
        }
        if (progress[39] == true) {
            exp += 30;
        }
        if (progress[40] == true) {
            exp += 10;
        }
        if (progress[41] == true) {
            exp += 10;
        }
        if (progress[42] == true) {
            exp += 10;
        }
        if (progress[43] == true) {
            exp += 10;
        }
        if (progress[44] == true) {
            exp += 10;
        }
        if (progress[45] == true) {
            exp += 10;
        }
        if (progress[46] == true) {
            exp += 10;
        }
        if (progress[47] == true) {
            exp += 20;
        }
        if (progress[48] == true) {
            exp += 20;
        }
        if (progress[49] == true) {
            exp += 30;
        }
        if (progress[50] == true) {
            exp += 10;
        }
        if (progress[51] == true) {
            exp += 10;
        }
        if (progress[52] == true) {
            exp += 10;
        }
        if (progress[53] == true) {
            exp += 10;
        }
        if (progress[54] == true) {
            exp += 10;
        }
        if (progress[55] == true) {
            exp += 10;
        }
        if (progress[56] == true) {
            exp += 10;
        }
        if (progress[57] == true) {
            exp += 20;
        }
        if (progress[58] == true) {
            exp += 20;
        }
        if (progress[59] == true) {
            exp += 30;
        }
        
        return exp;
    }
    
    /**
     * Adds Level Buttons, based on the chapter, that the user can use to access a certain level.
     */
    public void addLevelImage(int chapter) {
        
        LevelButton lb1 = new LevelButton("C0"+chapter+"L01",this.getDone(chapter,1),this.getLocked(chapter,1),this.loc[chapter-1][0]);
        LevelButton lb2 = new LevelButton("C0"+chapter+"L02",this.getDone(chapter,2),this.getLocked(chapter,2),this.loc[chapter-1][1]);
        LevelButton lb3 = new LevelButton("C0"+chapter+"L03",this.getDone(chapter,3),this.getLocked(chapter,3),this.loc[chapter-1][2]);
        LevelButton lb4 = new LevelButton("C0"+chapter+"L04",this.getDone(chapter,4),this.getLocked(chapter,4),this.loc[chapter-1][3]);
        LevelButton lb5 = new LevelButton("C0"+chapter+"L05",this.getDone(chapter,5),this.getLocked(chapter,5),this.loc[chapter-1][4]);
        LevelButton lb6 = new LevelButton("C0"+chapter+"L06",this.getDone(chapter,6),this.getLocked(chapter,6),this.loc[chapter-1][5]);
        LevelButton lb7 = new LevelButton("C0"+chapter+"L07",this.getDone(chapter,7),this.getLocked(chapter,7),this.loc[chapter-1][6]);
        LevelButton lb8 = new LevelButton("C0"+chapter+"L08",this.getDone(chapter,8),this.getLocked(chapter,8),this.loc[chapter-1][7]);
        LevelButton lb9 = new LevelButton("C0"+chapter+"L09",this.getDone(chapter,9),this.getLocked(chapter,9),this.loc[chapter-1][8]);
        LevelButton lb10 = new LevelButton("C0"+chapter+"L10",this.getDone(chapter,10),this.getLocked(chapter,10),this.loc[chapter-1][9]);
        
        
        this.lbuttons.add(lb1);
        this.addObject(lb1,100,120);
        this.lbuttons.add(lb2);
        this.addObject(lb2,300,120);
        this.lbuttons.add(lb3);
        this.addObject(lb3,500,120);
        this.lbuttons.add(lb4);
        this.addObject(lb4,100,320);
        this.lbuttons.add(lb5);
        this.addObject(lb5,300,320);
        this.lbuttons.add(lb6);
        this.addObject(lb6,500,320);
        this.lbuttons.add(lb7);
        this.addObject(lb7,100,520);
        this.lbuttons.add(lb8);
        this.addObject(lb8,300,520);
        this.lbuttons.add(lb9);
        this.addObject(lb9,500,520);
        this.lbuttons.add(lb10);
        this.addObject(lb10,100,720);

        
    }
    
    /**
     * Changes the current mode.
     */
    public void setMode(String s) {
        this.mode = s;
    }
    
    /**
     * Adds Main Menu buttons for traversion.
     */
    public void addMainButtons() {
        this.buttons[0] = new MenuButton("Levelauswahl",this);
        this.buttons[1] = new MenuButton("Weitere Modi", this);
        this.buttons[2] = new MenuButton("Hilfe",this);
        this.buttons[3] = new MenuButton("Optionen",this);
        this.buttons[4] = new MenuButton("Statistiken",this);
        


        this.addObject(this.buttons[0], 300, 500);
        this.addObject(this.buttons[1], 300 ,550);
        this.addObject(this.buttons[2], 300, 600);
        this.addObject(this.buttons[3], 300, 650);
        this.addObject(this.buttons[4], 300, 700);

    }
    
    /**
     * Adds a Back-Button to get back to the Chapter-Menu from the Level Selection.
     */
    public void addLevelButtons() {
        this.buttons[0] = new MenuButton("Levelauswahl",this);
        this.addObject(this.buttons[0],400,750);
    }
    
    /**
     * Adds a Back-Button to get back to the Main Menu.
     */
    public void addCreditButtons() {
        this.buttons[0] = new MenuButton("Optionen",this);
        this.addObject(this.buttons[0],300,750);
    }
    
    public void addOptionsButtons() {
        this.buttons[0] = new MenuButton("Back",this);
        this.addObject(this.buttons[0],500,750);
        this.buttons[1] = new MenuButton("Kahla",this);
        this.addObject(this.buttons[1],100,140);
        this.buttons[2] = new MenuButton("Farbi",this);
        this.addObject(this.buttons[2],300,140);
        this.buttons[3] = new MenuButton("Zurücksetzen",this);
        this.addObject(this.buttons[3],200,250);
        
        this.buttons[4] = new MenuButton("Credits",this);
        this.addObject(this.buttons[4],200,750);
        
        this.buttons[5] = new MenuButton("Lösungen",this,"Main");
        this.addObject(this.buttons[5],200,360);
        
    }
    
    public void addOthersButtons() {
        this.buttons[0] = new MenuButton("Back",this);
        this.addObject(this.buttons[0],500,750);
        this.buttons[1] = new MenuButton("Level laden", this);
        this.addObject(this.buttons[1],200,100);
        this.buttons[2] = new MenuButton("Level-Editor", this);
        this.addObject(this.buttons[2],200,150);
        
        this.buttons[3] = new MenuButton("Multiplayer", this);
        this.addObject(this.buttons[3],200,200);
       
    }
    
    
    /**
     * Addas a Back-Button to get back to the Main Menu.
     */
    public void addChapterMenuButtons() {
        //Diverse Buttons für die Einzelnen Kapitel
        
        this.buttons[0] = new MenuButton("Back",this);
        this.addObject(this.buttons[0],500,750);
    }
    
    
    /**
     * Adds a Back-Button to get back to the Main Menu.
     */
    public void addStatisticsButtons() {
        this.buttons[0] = new MenuButton("Back",this);
        this.addObject(this.buttons[0],500,750);
    }
    
    public void act() {
        if (this.firstAct) {
            if ((this.name.equals("") || this.name == null)) {
                this.name = this.getName();
                this.draw();
            }
            this.firstAct = false;
        }
        
    }

}
