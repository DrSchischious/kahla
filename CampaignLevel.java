import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 * The class represents every Stage in Campaign mode.
 * 
 * @author Daniel Schisch
 * @version 0.6
 */
public class CampaignLevel extends Stage
{
    int chapter;
    int level;
    boolean isRewritable = true;
    boolean isCampaignLevel = false;
    
    /**
     * Standard Constructor
     * Not very useful, used for testing.
     */
    public CampaignLevel()
    {
        super(10,3,50);
        
    }
    
    public CampaignLevel(int hor, int ver, Level lv){
        super(hor, ver, 50);
        this.createLevelFromFile(lv);
        
        
    }
    
    /**
     * Normal Constructor
     * Creates a stage, based on the given width and height.
     * Also calls preparation-methods, based on chapter/level.
     */
    public CampaignLevel(int chapter, int level, int horizontalCells, int verticalCells, int width) {
        super(horizontalCells, verticalCells, width);
        this.chapter = chapter;
        this.level = level;
        
        if (chapter == 1) {
            if (level == 1) {
                this.prepareC01L01();
            } else if (level == 2) {
                this.prepareC01L02();
            } else if (level == 3) {
                this.prepareC01L03();
            } else if (level == 4) {
                this.prepareC01L04();
            } else if (level == 5) {
                this.prepareC01L05();
            } else if (level == 6) {
                this.prepareC01L06();
            } else if (level == 7) {
                this.prepareC01L07();
            } else if (level == 8) {
                this.prepareC01L08();
            } else if (level == 9) {
                this.prepareC01L09();
            } else if (level == 10) {
                this.prepareC01L10();
            }
        } else if (chapter == 2) {
            if (level == 1) {
                this.prepareC02L01();
            } else if (level == 2) {
                this.prepareC02L02();
            } else if (level == 3) {
                this.prepareC02L03();
            } else if (level == 4) {
                this.prepareC02L04();
            } else if (level == 5) {
                this.prepareC02L05();
            } else if (level == 6) {
                this.prepareC02L06();
            } else if (level == 7) {
                this.prepareC02L07();
            } else if (level == 8) {
                this.prepareC02L08();
            } else if (level == 9) {
                this.prepareC02L09();
            } else if (level == 10) {
                this.prepareC02L10();
            } 
        } else if (chapter == 3) {
            if (level == 1) {
                this.prepareC03L01();
            } else if (level == 2) {
                this.prepareC03L02();
            } else if (level == 3) {
                this.prepareC03L03();
            } else if (level == 4) {
                this.prepareC03L04();
            } else if (level == 5) {
                this.prepareC03L05();
            } else if (level == 6) {
                this.prepareC03L06();
            } else if (level == 7) {
                this.prepareC03L07();
            } else if (level == 8) {
                this.prepareC03L08();
            } else if (level == 9) {
                this.prepareC03L09();
            } else if (level == 10) {
                this.prepareC03L10();
            }
        } else if (chapter == 4) {
            if (level == 1) {
                this.prepareC04L01();
            } else if (level == 2 ) {
                this.prepareC04L02();
            } else if (level == 3 ) {
                this.prepareC04L03();
            } else if (level == 4) {
                this.prepareC04L04();
            } else if (level == 5) {
                this.prepareC04L05();
            } else if (level == 6) {
                this.prepareC04L06();
            } else if (level == 7) {
                this.prepareC04L07();
            } else if (level == 8) {
                this.prepareC04L08();
            } else if (level == 9) {
                this.prepareC04L09();
            } else if (level == 10 ) {
                this.prepareC04L10();
            }
        } else if (chapter == 5) {
            if (level == 1) {
                this.prepareC05L01();
            } else if (level == 2) {
                this.prepareC05L02();
            } else if (level == 3) {
                this.prepareC05L03();
            } else if (level == 4) {
                this.prepareC05L04();
            } else if (level == 5) {
                this.prepareC05L05();
            } else if (level == 6) {
                this.prepareC05L06();
            } else if (level == 7) {
                this.prepareC05L07();
            } else if (level == 8) {
                this.prepareC05L08();
            } else if (level == 9) {
                this.prepareC05L09();
            } else if (level == 10) {
                this.prepareC05L10();
            }
        } else if (chapter == 6) {
            if (level == 1) {
                this.prepareC06L01();
            } else if (level == 2) {
                this.prepareC06L02();
            } else if (level == 3) {
                this.prepareC06L03();
            } else if (level == 4) {
                this.prepareC06L04();
            } else if (level == 5) {
                this.prepareC06L05();
            } else if (level == 6) {
                this.prepareC06L06();
            } else if (level == 7) {
                this.prepareC06L07();
            } else if (level == 8) {
                this.prepareC06L08();
            } else if (level == 9 ) {
                this.prepareC06L09();
            } else if (level == 10) {
                this.prepareC06L10();
            }
        }
        
    }
    
    public static void savePath(String path) {
        try {
            //path?
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
            out.write(path);
            out.close();
            
        } catch(IOException e) {
            
        } 
    }
    
    public static Level loadLevelFromData() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileFilter ff = new FileNameExtensionFilter("Kahla-Levels","lvl");
        
        chooser.addChoosableFileFilter(ff);
        chooser.showOpenDialog(null);
        
        File f = chooser.getSelectedFile();
        
        
        try {
            String path = f.toString();
            
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
            CampaignLevel.savePath(path);
            return read;
 
        } catch (Exception e) {
            return null;
        }
        
    }

    
    /**
     * Saves the level into a file, so that it can be accessed, even when the program is not running.
     */
    public void saveLevel() {
        try {
            //path?
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
            if (this.level < 10) {
                out.write("C0"+this.chapter+"L0"+this.level);
            } else {
                out.write("C0"+this.chapter+"L"+this.level);
            }
            out.close();
            
        } catch(IOException e) {
            
        } 
    }
    
    public Level reset() {
        String path = "";
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/actualLevel.txt"));
           path =  in.readLine();
        } catch(IOException e) {
           path = "";
        } 
        
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
    
    /**
     * Resets the Stage if interrupted by access of the code or the manual reset.
     */
    public void resetStage() {
        Level lv = this.reset();
        Greenfoot.setWorld(new CampaignLevel(lv.width,lv.height,lv));
        /* Delete, if unneccessary
        if (chapter == 1) {
            if (level == 1) {
                Greenfoot.setWorld(new CampaignLevel(1,1,10,3,50));
            } else if (level == 2) {
                Greenfoot.setWorld(new CampaignLevel(1,2,10,3,50));
            } else if (level == 3) {
                Greenfoot.setWorld(new CampaignLevel(1,3,10,3,50));
            } else if (level == 4) {
                Greenfoot.setWorld(new CampaignLevel(1,4,10,3,50));
            } else if (level == 5) {
                Greenfoot.setWorld(new CampaignLevel(1,5,10,4,50));
            } else if (level == 6) {
                Greenfoot.setWorld(new CampaignLevel(1,6,11,6,50));
            } else if (level == 7) {
                Greenfoot.setWorld(new CampaignLevel(1,7,11,7,50));
            } else if (level == 8) {
                Greenfoot.setWorld(new CampaignLevel(1,8,10,4,50));
            } else if (level == 9) {
                Greenfoot.setWorld(new CampaignLevel(1,9,11,5,50));
            } else if (level == 10) {
                Greenfoot.setWorld(new CampaignLevel(1,10,10,7,50));
            }
        } else if (chapter == 2) {
            if (level == 1) {
                Greenfoot.setWorld(new CampaignLevel(2,1,11,3,50));
            } else if (level == 2) {
                Greenfoot.setWorld(new CampaignLevel(2,2,11,7,50));
            } else if (level == 3) {
                Greenfoot.setWorld(new CampaignLevel(2,3,9,5,50));
            } else if (level == 4) {
                Greenfoot.setWorld(new CampaignLevel(2,4,11,7,50));
            } else if (level == 5) {
                Greenfoot.setWorld(new CampaignLevel(2,5,11,6,50));
            } else if (level == 6) {
                Greenfoot.setWorld(new CampaignLevel(2,6,10,5,50));
            } else if (level == 7) {
                Greenfoot.setWorld(new CampaignLevel(2,7,12,7,50));
            } else if (level == 8) {
                Greenfoot.setWorld(new CampaignLevel(2,8,13,8,50));
            } else if (level == 9) {
                Greenfoot.setWorld(new CampaignLevel(2,9,13,13,50));
            } else if (level ==10) {
                Greenfoot.setWorld(new CampaignLevel(2,10,17,8,50));
            }
        } else if (chapter == 3) {
            if (level == 1) {
                Greenfoot.setWorld(new CampaignLevel(3,1,11,3,50));
            } else if (level == 2) {
                Greenfoot.setWorld(new CampaignLevel(3,2,10,5,50));
            } else if (level == 3) {
                Greenfoot.setWorld(new CampaignLevel(3,3,11,5,50));
            } else if (level == 4) {
                Greenfoot.setWorld(new CampaignLevel(3,4,11,5,50));
            } else if (level == 5) {
                Greenfoot.setWorld(new CampaignLevel(3,5,9,5,50));
            } else if (level == 6) {
                Greenfoot.setWorld(new CampaignLevel(3,6,11,8,50));
            } else if (level == 7) {
                Greenfoot.setWorld(new CampaignLevel(3,7,9,5,50));
            } else if (level == 8) {
                Greenfoot.setWorld(new CampaignLevel(3,8,13,7,50));
            } else if (level == 9) {
                Greenfoot.setWorld(new CampaignLevel(3,9,11,7,50));
            } else if (level == 10) {
                Greenfoot.setWorld(new CampaignLevel(3,10,11,5,50));
            }
        } else if (chapter == 4) {
            if (level == 1) {
                Greenfoot.setWorld(new CampaignLevel(4,1,10,9,50));
            } else if (level == 2) {
                Greenfoot.setWorld(new CampaignLevel(4,2,9,7,50));
            } else if (level == 3) {
                Greenfoot.setWorld(new CampaignLevel(4,3,9,8,50));
            } else if (level == 4) {
                Greenfoot.setWorld(new CampaignLevel(4,4,9,9,50));
            } else if (level == 5) {
                Greenfoot.setWorld(new CampaignLevel(4,5,11,12,50));
            } else if (level == 6) {
                Greenfoot.setWorld(new CampaignLevel(4,6,13,9,50));
            } else if (level == 7) {
                Greenfoot.setWorld(new CampaignLevel(4,7,12,9,50));
            } else if (level == 8) {
                Greenfoot.setWorld(new CampaignLevel(4,8,11,11,50));
            } else if (level == 9) {
                Greenfoot.setWorld(new CampaignLevel(4,9,12,9,50));
            } else if (level == 10) {
                Greenfoot.setWorld(new CampaignLevel(4,10,11,11,50));
            }
        } else if (chapter == 5) {
            if (level == 1) {
                Greenfoot.setWorld(new CampaignLevel(5,1,9,3,50));
            } else if (level == 2) {
                Greenfoot.setWorld(new CampaignLevel(5,2,9,9,50));
            } else if (level == 3) {
                Greenfoot.setWorld(new CampaignLevel(5,3,9,9,50));
            } else if (level == 4) {
                Greenfoot.setWorld(new CampaignLevel(5,4,10,13,50));
            } else if (level == 5) {
                Greenfoot.setWorld(new CampaignLevel(5,5,11,10,50));
            } else if (level == 6) {
                Greenfoot.setWorld(new CampaignLevel(5,6,10,7,50));
            } else if (level == 7) {
                Greenfoot.setWorld(new CampaignLevel(5,7,9,11,50));
            } else if (level == 8) {
                Greenfoot.setWorld(new CampaignLevel(5,8,13,9,50));
            } else if (level == 9) {
                Greenfoot.setWorld(new CampaignLevel(5,9,13,13,50));
            } else if (level == 10) {
                Greenfoot.setWorld(new CampaignLevel(5,10,13,13,50));
            }
        } else if (chapter == 6) {
            if (level == 1) {
                Greenfoot.setWorld(new CampaignLevel(6,1,13,6,50));
            } else if (level == 2) {
                Greenfoot.setWorld(new CampaignLevel(6,2,13,7,50));
            } else if (level == 3) {
                Greenfoot.setWorld(new CampaignLevel(6,3,13,11,50));
            } else if (level == 4) {
                Greenfoot.setWorld(new CampaignLevel(6,4,13,11,50));
            } else if (level == 5) {
                Greenfoot.setWorld(new CampaignLevel(6,5,15,11,50));
            } else if (level == 6) {
                Greenfoot.setWorld(new CampaignLevel(6,6,15,11,50));
            } else if (level == 7) {
                Greenfoot.setWorld(new CampaignLevel(6,7,12,7,50));
            } else if (level == 8) {
                Greenfoot.setWorld(new CampaignLevel(6,8,12,7,50));
            } else if (level == 9) {
                Greenfoot.setWorld(new CampaignLevel(6,9,13,7,50));
            } else if (level == 10) {
                Greenfoot.setWorld(new CampaignLevel(6,10,13,7,50));
            }
        }
        */
    }
    
    public boolean loadCharacter() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/character.txt"));
           String x = in.readLine();
           if (x.equals("Kahla"))   {
               return true;
           }
           if (x.equals("Farbi")) {
               return false;
           }
           
           
           
        } catch(IOException e) {
           return true;
        }
           
        
        
        return true;
    }
    
    public void createLevelFromFile(Level lvl) {
        Spieler[] sptemp;
        
        Iterator it = lvl.players.entrySet().iterator();

        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            boolean kahla = this.loadCharacter();
            ((Player)pair.getKey()).redraw(kahla);           
            Spieler s = (Spieler)pair.getKey();
            
            addObject(s,this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
            
            
            if (s.direction == 's') {
                s.setRotation(90);
            } else if (s.direction == 'w') {
                s.setRotation(180);
            } else if (s.direction == 'n') {
                s.setRotation(270);
            } else {
                s.setRotation(0);
            }
        }
        
        List<Spieler> sp = this.getObjects(Spieler.class);
        sptemp = new Spieler[sp.size()];
        int i = 0;
        for (Spieler s : sp) {
            sptemp[i] = s;
            i++;
        }

        Multiheader mhtemp = new Multiheader(lvl.mh.getPages(), sptemp, lvl.mh.getWinningMessage());

        lvl.mh = mhtemp;
        lvl.mh.redraw();
        addObject(lvl.mh,0,0);
        lvl.mh.setLocation(0,0);

        
        it = lvl.walls.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Wall)pair.getKey()).redraw();
            addObject((Wall)pair.getKey(),this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
            
        }
        
        it = lvl.checkpoints.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Checkpoint)pair.getKey()).redraw();
            addObject((Checkpoint)pair.getKey(),this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
        }
        
        it = lvl.outlines.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Outline)pair.getKey()).redraw();
            addObject((Outline)pair.getKey(),this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
        }
        
        it = lvl.targets.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Target)pair.getKey()).redraw();
            addObject((Target)pair.getKey(),this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
        }
        
        it = lvl.items.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Item)pair.getKey()).redraw();
            addObject((Item)pair.getKey(),this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
        }
        
        it = lvl.spheres.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Sphere)pair.getKey()).redraw();
            addObject((Sphere)pair.getKey(),this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
        }
        
        it = lvl.platforms.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Platform)pair.getKey()).redraw();
            addObject((Platform)pair.getKey(),this.getRealX(((GamePoint)pair.getValue()).getX()),this.getRealY(((GamePoint)pair.getValue()).getY()));
        }
        
        
        //TODO -> ResetStage with a path(?)
    }
    
    public void exportLevel() {
        //TODO
        Level lv = new Level();
        lv.width = this.getWidth()/50;
        lv.height = (this.getHeight()/50)-4;
        
        //Spieler
         
        List<Spieler> sp = this.getObjects(Spieler.class);
        
        for (Spieler s : sp) {

            Spieler k = new Spieler(true);
            
            
            if (s.getRotation() == 90) {
                k.direction = 's';
            } else if (s.getRotation() == 180) {
                k.direction = 'w';
            } else if (s.getRotation() == 270) {
                k.direction = 'n';
            } else {
                k.direction = 'e';
            }
            
            lv.players.put(k, new GamePoint(s.getRealX(),s.getRealY()));
            
        }
        
        lv.playerArchive = new Spieler[lv.players.keySet().size()];
        
        int count = 0;
        Iterator it = lv.players.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            lv.playerArchive[count] = (Spieler)pair.getKey();
            count++;
        }
     
        //Memo
        //Multiheader mh = this.getObjects(Multiheader.class).get(0);
        lv.mh = this.getObjects(Multiheader.class).get(0);
        /*
        String[][] pages = mh.getPages();
        
        for (String[] p : pages) {
            lv.memos.add(p);
        }
        
        count = 0;
        for (String[] s : lv.memos) {
            lv.memoArchive[count] = s;
            count++;
        }
        lv.winningMessage = mh.getWinningMessage();
        
        */
       
        //Walls
        
        List<Wall> walls = this.getObjects(Wall.class);
        
        for (Wall w : walls) {
            lv.walls.put(w, new GamePoint(w.getRealX(),w.getRealY()));
        }
        
        //Other Objects
        //Checkpoints
        List<Checkpoint> checkpoints = this.getObjects(Checkpoint.class);
        
        for (Checkpoint c : checkpoints) {
            lv.checkpoints.put(c, new GamePoint(c.getRealX(),c.getRealY()));
        }
        //Items
        
        List<Item> items = this.getObjects(Item.class);
        
        for (Item i : items) {
            lv.items.put(i, new GamePoint(i.getRealX(),i.getRealY()));
        }
        
        //Targets
        List<Target> targets = this.getObjects(Target.class);
        
        for (Target t : targets) {
            lv.targets.put(t, new GamePoint(t.getRealX(),t.getRealY()));
        }
        
        //Outlines
        List<Outline> outlines = this.getObjects(Outline.class);
        
        for (Outline o : outlines) {
            lv.outlines.put(o, new GamePoint(o.getRealX(),o.getRealY()));
        }
        
        //Outlines
        List<Platform> platforms = this.getObjects(Platform.class);
        
        for (Platform p : platforms) {
            lv.platforms.put(p, new GamePoint(p.getRealX(),p.getRealY()));
        }
        
        //Sphere
        List<Sphere> spheres = this.getObjects(Sphere.class);
        
        for (Sphere s : spheres) {
            lv.spheres.put(s, new GamePoint(s.getRealX(),s.getRealY()));
        }
        
        
        //Uncomment for level-export
        lv.exportLevel();
        
    }
    
    public void prepareC01L01() {
        Spieler player = new Spieler(this.loadCharacter());
        addObject(player,this.getRealX(4),this.getRealY(5)); 
        Spieler[] P = new Spieler[]{player};
        String[] firstPage = new String[]{"Willkommen bei \"Java mit Kahla\"", "Gegeben ist das unten zu sehende Spielfeld.","","Klicke hier unten auf den Pfeil für weitere","Informationen."};
        String[] secondPage = new String[]{"Gut!","","Der kleine Kreis mit der Spitze ist deine","Spielfigur."};
        String[] thirdPage = new String[]{"Die Spitze deutet die Richtung an,","in die deine Spielfigur gedreht ist."};
        String[] fourthPage = new String[]{"Die grauen Bereiche deuten Wände","an. Deine Spielfigur kann diese nicht","begehen."};
        String[] fifthPage = new String[]{"Der türkise Kreis ist ein Checkpoint!","","Ziel dieses Levels ist es, deine Spielfigur","mit bestimmten Befehlen zum Checkpoint", "zu führen."};
        String[] sixthPage = new String[]{"Suche dazu auf der rechten Seite","das Element 'Spieler' und klicke doppelt","darauf."};
        String[] seventhPage = new String[]{"Du befindest dich nun im Editor.","Hier kannst du nun nach dem Befehl", "'public void code()' suchen.",""};
        String[] eigthPage = new String[]{"Innerhalb des Bereiches kannst du","Befehle formulieren.","","Probiere es doch mal mit dem Befehl","'schritt();'",""};
        String[] ninthPage = new String[]{"Führe dann die Befehle über den","Button 'Starte Code' aus"};
        String wm = "Sehr gut!\nDu kannst nun das nächste Level über\nden Button 'Nächstes Level' erreichen.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage, thirdPage, fourthPage,fifthPage,sixthPage,seventhPage,eigthPage,ninthPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        
        //First Row
        Wall wall01 = new Wall("FNH");
        addObject(wall01,this.getRealX(1),this.getRealY(4));
        Wall wall02 = new Wall("FNH");
        addObject(wall02,this.getRealX(2),this.getRealY(4));
        Wall wall03 = new Wall("FNH");
        addObject(wall03,this.getRealX(3),this.getRealY(4));
        Wall wall04 = new Wall("FNH");
        addObject(wall04,this.getRealX(4),this.getRealY(4));
        Wall wall05 = new Wall("FNH");
        addObject(wall05,this.getRealX(5),this.getRealY(4));
        Wall wall06 = new Wall("FNH");
        addObject(wall06,this.getRealX(6),this.getRealY(4));
        Wall wall07 = new Wall("FNH");
        addObject(wall07,this.getRealX(7),this.getRealY(4));
        Wall wall08 = new Wall("FNH");
        addObject(wall08,this.getRealX(8),this.getRealY(4));
        
        Wall wall11 = new Wall("FSH");
        addObject(wall11,this.getRealX(1),this.getRealY(6));
        Wall wall12 = new Wall("FSH");
        addObject(wall12,this.getRealX(2),this.getRealY(6));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(3),this.getRealY(6));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(4),this.getRealY(6));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(5),this.getRealY(6));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(6),this.getRealY(6));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(7),this.getRealY(6));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(8),this.getRealY(6));
        
        //Vertices
        Wall wallen = new Wall("FOLEN");
        addObject(wallen,this.getRealX(0),this.getRealY(6));
        Wall wallnw = new Wall("FOLNW");
        addObject(wallnw,this.getRealX(9),this.getRealY(6));
        Wall wallws = new Wall("FOLWS");
        addObject(wallws,this.getRealX(9),this.getRealY(4));
        Wall wallse = new Wall("FOLSE");
        addObject(wallse,this.getRealX(0),this.getRealY(4));
        
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));

        Wall wall32 = new Wall("FEV");
        addObject(wall32,this.getRealX(9),this.getRealY(5));
        
        
        Checkpoint cp = new Checkpoint(0);
        
        addObject(cp,this.getRealX(5),this.getRealY(5));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC01L02() {
       
        
        Spieler player = new Spieler(this.loadCharacter());
        addObject(player,this.getRealX(4),this.getRealY(5));
        Spieler[] P = new Spieler[]{player};
        String[] firstPage = new String[]{"Sehr gut!","Du hast dein erstes Programm geschrieben.","","Wie du siehst, unterschiedet sich dieses","Level etwas von dem vorigen."};
        String[] secondPage = new String[]{"Der Checkpoint befindet sich nun","drei Felder entfernt."};
        String[] thirdPage = new String[]{"Wenn dein Programm das Ziel nicht","nach dem Durchgang erreicht, so wird es","wieder zurückgesetzt, damit du es erneut","versuchen kannst."};
        String[] fourthPage = new String[]{"In diesem Level musst du den Befehl","'schritt();' mehrfach nutzen.","","Der Konvention halber verwenden wir pro", "Befehl eine Zeile."};
        String[] fifthPage = new String[]{"Versuche es also mal mit mehreren","Befehlen und starte deinen Code."};
        String wm = "Super.\nDu hast für dieses und das letzte Level\njeweils 10 Erfahrungspunkte bekommen.\nDiese sind nötig, um weitere Level\nfreizuschalten.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage, thirdPage, fourthPage,fifthPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        
        //First Row
        Wall wall01 = new Wall("FNH");
        addObject(wall01,this.getRealX(1),this.getRealY(4));
        Wall wall02 = new Wall("FNH");
        addObject(wall02,this.getRealX(2),this.getRealY(4));
        Wall wall03 = new Wall("FNH");
        addObject(wall03,this.getRealX(3),this.getRealY(4));
        Wall wall04 = new Wall("FNH");
        addObject(wall04,this.getRealX(4),this.getRealY(4));
        Wall wall05 = new Wall("FNH");
        addObject(wall05,this.getRealX(5),this.getRealY(4));
        Wall wall06 = new Wall("FNH");
        addObject(wall06,this.getRealX(6),this.getRealY(4));
        Wall wall07 = new Wall("FNH");
        addObject(wall07,this.getRealX(7),this.getRealY(4));
        Wall wall08 = new Wall("FNH");
        addObject(wall08,this.getRealX(8),this.getRealY(4));
        
        Wall wall11 = new Wall("FSH");
        addObject(wall11,this.getRealX(1),this.getRealY(6));
        Wall wall12 = new Wall("FSH");
        addObject(wall12,this.getRealX(2),this.getRealY(6));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(3),this.getRealY(6));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(4),this.getRealY(6));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(5),this.getRealY(6));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(6),this.getRealY(6));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(7),this.getRealY(6));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(8),this.getRealY(6));
        
        //Vertices
        Wall wallen = new Wall("FOLEN");
        addObject(wallen,this.getRealX(0),this.getRealY(6));
        Wall wallnw = new Wall("FOLNW");
        addObject(wallnw,this.getRealX(9),this.getRealY(6));
        Wall wallws = new Wall("FOLWS");
        addObject(wallws,this.getRealX(9),this.getRealY(4));
        Wall wallse = new Wall("FOLSE");
        addObject(wallse,this.getRealX(0),this.getRealY(4));
        
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));

        Wall wall32 = new Wall("FEV");
        addObject(wall32,this.getRealX(9),this.getRealY(5));
        
        Checkpoint cp = new Checkpoint(0);
        
        addObject(cp,this.getRealX(7),this.getRealY(5));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC01L03() {
        Item i = new Item();
        
        addObject(i,this.getRealX(7),this.getRealY(5));
        Spieler player = new Spieler(this.loadCharacter());
        addObject(player,this.getRealX(4),this.getRealY(5));
        Spieler[] P = new Spieler[]{player};
        String[] firstPage = new String[]{"Dieses Level setzt dir ein neues Ziel.","Das neue rechteckige Objekt ist ein Token.","","Wenn ein Level Token hat, so ist es das Ziel,", "dieses Aufzuheben."};
        String[] secondPage = new String[]{"Dazu muss die Spielfigur auf dem", "Token stehen und dieses explizit über einen", "Befehl aufheben.","","Dieser Befehl lautet: 'aufheben();'"};
        String wm = "+10 EXP\n\nGut!\nÜbrigens: Für abgeschlossene Levels erhält\nman nur einmal Erfahrungspunkte.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage,secondPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        
        //First Row
        Wall wall01 = new Wall("FNH");
        addObject(wall01,this.getRealX(1),this.getRealY(4));
        Wall wall02 = new Wall("FNH");
        addObject(wall02,this.getRealX(2),this.getRealY(4));
        Wall wall03 = new Wall("FNH");
        addObject(wall03,this.getRealX(3),this.getRealY(4));
        Wall wall04 = new Wall("FNH");
        addObject(wall04,this.getRealX(4),this.getRealY(4));
        Wall wall05 = new Wall("FNH");
        addObject(wall05,this.getRealX(5),this.getRealY(4));
        Wall wall06 = new Wall("FNH");
        addObject(wall06,this.getRealX(6),this.getRealY(4));
        Wall wall07 = new Wall("FNH");
        addObject(wall07,this.getRealX(7),this.getRealY(4));
        Wall wall08 = new Wall("FNH");
        addObject(wall08,this.getRealX(8),this.getRealY(4));
        
        Wall wall11 = new Wall("FSH");
        addObject(wall11,this.getRealX(1),this.getRealY(6));
        Wall wall12 = new Wall("FSH");
        addObject(wall12,this.getRealX(2),this.getRealY(6));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(3),this.getRealY(6));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(4),this.getRealY(6));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(5),this.getRealY(6));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(6),this.getRealY(6));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(7),this.getRealY(6));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(8),this.getRealY(6));
        
        //Vertices
        Wall wallen = new Wall("FOLEN");
        addObject(wallen,this.getRealX(0),this.getRealY(6));
        Wall wallnw = new Wall("FOLNW");
        addObject(wallnw,this.getRealX(9),this.getRealY(6));
        Wall wallws = new Wall("FOLWS");
        addObject(wallws,this.getRealX(9),this.getRealY(4));
        Wall wallse = new Wall("FOLSE");
        addObject(wallse,this.getRealX(0),this.getRealY(4));
        
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));

        Wall wall32 = new Wall("FEV");
        addObject(wall32,this.getRealX(9),this.getRealY(5));
        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
    }
    
    public void prepareC01L04() {
        Spieler player = new Spieler(this.loadCharacter());
        addObject(player,this.getRealX(4),this.getRealY(5));
        Spieler[] P = new Spieler[]{player};
        String[] firstPage = new String[]{"Dein nächstes Ziel ist die Zielscheibe.","","Unsere Spielfigur verfügt über die Fähigkeit,", "mit einer Farbpistole zu schießen."};
        String[] secondPage = new String[]{"Der Schuss trifft das Feld, das sich","genau zwei Felder vor der Spielfigur befindet.","","Versuche nun mithilfe des Befehls","'schießen();' die Zielscheibe zu treffen."};
        String wm = "+10 EXP!\nSuper!\nAll deine Lösungen werden gespeichert.\nDu findest sie unter 'Optionen' oder 'Befehle'.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        
        
        //First Row
        Wall wall01 = new Wall("FNH");
        addObject(wall01,this.getRealX(1),this.getRealY(4));
        Wall wall02 = new Wall("FNH");
        addObject(wall02,this.getRealX(2),this.getRealY(4));
        Wall wall03 = new Wall("FNH");
        addObject(wall03,this.getRealX(3),this.getRealY(4));
        Wall wall04 = new Wall("FNH");
        addObject(wall04,this.getRealX(4),this.getRealY(4));
        Wall wall05 = new Wall("FNH");
        addObject(wall05,this.getRealX(5),this.getRealY(4));
        Wall wall06 = new Wall("FNH");
        addObject(wall06,this.getRealX(6),this.getRealY(4));
        Wall wall07 = new Wall("FNH");
        addObject(wall07,this.getRealX(7),this.getRealY(4));
        Wall wall08 = new Wall("FNH");
        addObject(wall08,this.getRealX(8),this.getRealY(4));
        
        Wall wall11 = new Wall("FSH");
        addObject(wall11,this.getRealX(1),this.getRealY(6));
        Wall wall12 = new Wall("FSH");
        addObject(wall12,this.getRealX(2),this.getRealY(6));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(3),this.getRealY(6));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(4),this.getRealY(6));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(5),this.getRealY(6));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(6),this.getRealY(6));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(7),this.getRealY(6));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(8),this.getRealY(6));
        
        //Vertices
        Wall wallen = new Wall("FOLEN");
        addObject(wallen,this.getRealX(0),this.getRealY(6));
        Wall wallnw = new Wall("FOLNW");
        addObject(wallnw,this.getRealX(9),this.getRealY(6));
        Wall wallws = new Wall("FOLWS");
        addObject(wallws,this.getRealX(9),this.getRealY(4));
        Wall wallse = new Wall("FOLSE");
        addObject(wallse,this.getRealX(0),this.getRealY(4));
        
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));

        Wall wall32 = new Wall("FEV");
        addObject(wall32,this.getRealX(9),this.getRealY(5));
        Target t = new Target();
        
        addObject(t,this.getRealX(6),this.getRealY(5));
        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
        
        
    }
    
    public void prepareC01L05() {
        //10x4
        Spieler player = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player};
        addObject(player,this.getRealX(7),this.getRealY(6));
        
        
        String[] firstPage = new String[]{"Es wird Zeit, dass unsere Spielfigur","mehr Möglichkeiten zur Fortbewegung","bekommt!"};
        String[] secondPage = new String[]{"Wir möchten, dass sie sich auch in","verschiedene Richtungen drehen kann.","","Dazu verwenden wir die Befehle:","linksDrehen(); und rechtsDrehen();"};
        String[] thirdPage = new String[]{"Diese Befehle ermöglichen deiner", "Spielfigur eine Drehung um 90° in die","jeweilige Richtung.","","Versuche dich mal an diesem Problem hier."};
        String wm = "+10 EXP\nDas waren nun alle Einführungslevels\ndes ersten Kapitels!\nVersuche dich nun mit dem Gelernten\nan den richtigen Levels.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        
        
        //First Row
        Wall wall01 = new Wall("FNH");
        addObject(wall01,this.getRealX(1),this.getRealY(5));
        Wall wall02 = new Wall("FNH");
        addObject(wall02,this.getRealX(2),this.getRealY(5));
        Wall wall03 = new Wall("FNH");
        addObject(wall03,this.getRealX(3),this.getRealY(5));
        Wall wall04 = new Wall("FNH");
        addObject(wall04,this.getRealX(4),this.getRealY(5));
        Wall wall05 = new Wall("FNH");
        addObject(wall05,this.getRealX(5),this.getRealY(5));
        Wall wall06 = new Wall("FNH");
        addObject(wall06,this.getRealX(6),this.getRealY(5));
        
        Wall wall08 = new Wall("FNH");
        addObject(wall08,this.getRealX(8),this.getRealY(4));
        
        Wall wall11 = new Wall("FSH");
        addObject(wall11,this.getRealX(1),this.getRealY(7));
        Wall wall12 = new Wall("FSH");
        addObject(wall12,this.getRealX(2),this.getRealY(7));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(3),this.getRealY(7));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(4),this.getRealY(7));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(5),this.getRealY(7));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(6),this.getRealY(7));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(7),this.getRealY(7));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(8),this.getRealY(7));
        
        //Vertices
        Wall wallen = new Wall("FOLEN");
        addObject(wallen,this.getRealX(0),this.getRealY(7));
        
        Wall wallnw2 = new Wall("FILNW");
        addObject(wallnw2,this.getRealX(7),this.getRealY(5));
        
        Wall wallnw = new Wall("FOLNW");
        addObject(wallnw,this.getRealX(9),this.getRealY(7));
        Wall wallv = new Wall("FEV");
        addObject(wallv,this.getRealX(9),this.getRealY(5));
        
        Wall wallws2 = new Wall("FOLWS");
        addObject(wallws2,this.getRealX(9),this.getRealY(4));
        
        Wall wallse = new Wall("FOLSE");
        addObject(wallse,this.getRealX(0),this.getRealY(5));
        Wall wallse2 = new Wall("FOLSE");
        addObject(wallse2,this.getRealX(7),this.getRealY(4));
        
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(6));

        Wall wall32 = new Wall("FEV");
        addObject(wall32,this.getRealX(9),this.getRealY(6));
        
        Wall wallx1 = new Wall("F");
        addObject(wallx1,this.getRealX(0),this.getRealY(4));
        Wall wallx2 = new Wall("F");
        addObject(wallx2,this.getRealX(1),this.getRealY(4));
        Wall wallx3 = new Wall("F");
        addObject(wallx3,this.getRealX(2),this.getRealY(4));
        Wall wallx4 = new Wall("F");
        addObject(wallx4,this.getRealX(3),this.getRealY(4));
        Wall wallx5 = new Wall("F");
        addObject(wallx5,this.getRealX(4),this.getRealY(4));
        Wall wallx6 = new Wall("F");
        addObject(wallx6,this.getRealX(5),this.getRealY(4));
        Wall wallx7 = new Wall("F");
        addObject(wallx7,this.getRealX(6),this.getRealY(4));
        
        Checkpoint t = new Checkpoint(0);
        
        
        
        addObject(t,this.getRealX(8),this.getRealY(5));
        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
        
        
    }
    
    public void prepareC01L06() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(5),this.getRealY(7));
        player0.setRotation(270); 
        String[] firstPage = new String[]{"Wie hier kann es sein, dass ein Level","manchmal mehrere Ziele hat.","","Diese gilt es alle in einem Programm zu lösen.","Versuche also beide Checkpoints zu besuchen."};
        String wm = "+10 EXP.\n\nWenn du genügend Erfahrungspunkte hast,\nkannst du einen besonderen\nMultiplayer-Modus freischalten!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Checkpoint c1 = new Checkpoint(0);
        addObject(c1,this.getRealX(3),this.getRealY(5));
        Checkpoint c2 = new Checkpoint(0);
        addObject(c2,this.getRealX(7),this.getRealY(5));
        Wall wall3 = new Wall("FOLSE");
        addObject(wall3,this.getRealX(0),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(1),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(2),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(3),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(4),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(5),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(6),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(7),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(8),this.getRealY(4));
        Wall wall11x = new Wall("FNH");
        addObject(wall11x,this.getRealX(9),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(10),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(10),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(10),this.getRealY(8));
        Wall wall17 = new Wall("FOLNW");
        addObject(wall17,this.getRealX(10),this.getRealY(9));
        Wall wall18x = new Wall("FSH");
        addObject(wall18x,this.getRealX(9),this.getRealY(9));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(8),this.getRealY(9));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(7),this.getRealY(9));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(6),this.getRealY(9));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(6),this.getRealY(9));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(5),this.getRealY(9));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(4),this.getRealY(9));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(3),this.getRealY(9));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(2),this.getRealY(9));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(1),this.getRealY(9));
        Wall wall27 = new Wall("FOLEN");
        addObject(wall27,this.getRealX(0),this.getRealY(9));
        Wall wall28 = new Wall("FWV");
        addObject(wall28,this.getRealX(0),this.getRealY(8));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(7));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(6));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
    }
    
    public void prepareC01L07() {
        Spieler player28 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player28};
        addObject(player28,this.getRealX(5),this.getRealY(7));
        player28.setRotation(180);
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall8x = new Wall("FNH");
        addObject(wall8x,this.getRealX(9),this.getRealY(4));
        Wall wall9 = new Wall("FOLWS");
        addObject(wall9,this.getRealX(10),this.getRealY(4));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(10),this.getRealY(5));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(10),this.getRealY(6));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(7));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(8));
        Wall wall13x = new Wall("FEV");
        addObject(wall13x,this.getRealX(10),this.getRealY(9));
        Wall wall14 = new Wall("FOLNW");
        addObject(wall14,this.getRealX(10),this.getRealY(10));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(1),this.getRealY(10));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(2),this.getRealY(10));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(3),this.getRealY(10));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(4),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(5),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(6),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(7),this.getRealY(10));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(8),this.getRealY(10));
        Wall wall22x = new Wall("FSH");
        addObject(wall22x,this.getRealX(9),this.getRealY(10));
        Wall wall23 = new Wall("FOLEN");
        addObject(wall23,this.getRealX(0),this.getRealY(10));
        Wall wall24 = new Wall("FWV");
        addObject(wall24,this.getRealX(0),this.getRealY(5));
        Wall wall25 = new Wall("FWV");
        addObject(wall25,this.getRealX(0),this.getRealY(6));
        Wall wall26 = new Wall("FWV");
        addObject(wall26,this.getRealX(0),this.getRealY(7));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(8));
        Wall wall27x = new Wall("FWV");
        addObject(wall27x,this.getRealX(0),this.getRealY(9));
        
        String[] firstPage = new String[]{"Es gibt keine Musterlösung für Levels.","Manche Lösungen sind nur eventuell kürzer","und effizienter als andere."};

        String wm = "+10 EXP\n\nEs kann sich lohnen, deine Lösung mit den\nLösungen von anderen zu vergleichen.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Target t29 = new Target();
        addObject(t29,this.getRealX(5),this.getRealY(5));
        Target t30 = new Target();
        addObject(t30,this.getRealX(7),this.getRealY(7));
        Target t31 = new Target();
        addObject(t31,this.getRealX(5),this.getRealY(9));
        Target t32 = new Target();
        addObject(t32,this.getRealX(3),this.getRealY(7));
        
        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
    }
    
    public void prepareC01L08() {
        Item i1 = new Item();
        addObject(i1,this.getRealX(8),this.getRealY(5));
        Item i2 = new Item();
        addObject(i2,this.getRealX(4),this.getRealY(5));
        Item i3 = new Item();
        addObject(i3,this.getRealX(2),this.getRealY(6));
        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(8),this.getRealY(6));
        player0.setRotation(180);
        String[] firstPage = new String[]{"Manche Levels erfordern viel","Schreibaufwand und die Nutzung vieler","Befehle."};
        String wm = "+20 EXP\n\nSchwierigere Levels belohnen dich mit\nmehr Erfahrungspunkten.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        
        Wall wall4 = new Wall("FOLSE");
        addObject(wall4,this.getRealX(1),this.getRealY(5));
        Wall wall6 = new Wall("FILNW");
        addObject(wall6,this.getRealX(3),this.getRealY(5));
        Wall wall7 = new Wall("FOLSE");
        addObject(wall7,this.getRealX(3),this.getRealY(4));
        Wall wall9 = new Wall("FOLWS");
        addObject(wall9,this.getRealX(5),this.getRealY(4));
        Wall wall10 = new Wall("FILEN");
        addObject(wall10,this.getRealX(5),this.getRealY(5));
        Wall wall12 = new Wall("FILNW");
        addObject(wall12,this.getRealX(7),this.getRealY(5));
        Wall wall13 = new Wall("FOLSE");
        addObject(wall13,this.getRealX(7),this.getRealY(4));
        Wall wall15 = new Wall("FOLWS");
        addObject(wall15,this.getRealX(9),this.getRealY(4));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(9),this.getRealY(5));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(9),this.getRealY(6));
        Wall wall18 = new Wall("FOLNW");
        addObject(wall18,this.getRealX(9),this.getRealY(7));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(2),this.getRealY(7));
        Wall wall19x = new Wall("FNH");
        addObject(wall19x,this.getRealX(2),this.getRealY(5));
        Wall wall19xx = new Wall("FNH");
        addObject(wall19xx,this.getRealX(4),this.getRealY(4));
        Wall wall19xxx = new Wall("FNH");
        addObject(wall19xxx,this.getRealX(6),this.getRealY(5));
        Wall wall19xxxx = new Wall("FNH");
        addObject(wall19xxxx,this.getRealX(8),this.getRealY(4));
        Wall wall19y = new Wall("FWV");
        addObject(wall19y,this.getRealX(1),this.getRealY(6));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(3),this.getRealY(7));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(4),this.getRealY(7));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(5),this.getRealY(7));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(6),this.getRealY(7));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(7),this.getRealY(7));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(8),this.getRealY(7));
        Wall wall26 = new Wall("FOLEN");
        addObject(wall26,this.getRealX(1),this.getRealY(7));
        Wall wallp = new Wall("F");
        addObject(wallp,this.getRealX(0),this.getRealY(4));
        Wall wallp2 = new Wall("F");
        addObject(wallp2,this.getRealX(0),this.getRealY(5));
        Wall wallp3 = new Wall("F");
        addObject(wallp3,this.getRealX(0),this.getRealY(6));
        Wall wallp4 = new Wall("F");
        addObject(wallp4,this.getRealX(0),this.getRealY(7));
        
        Wall wallp5 = new Wall("F");
        addObject(wallp5,this.getRealX(1),this.getRealY(4));
        Wall wallp6 = new Wall("F");
        addObject(wallp6,this.getRealX(2),this.getRealY(4));
        
        Wall wallp7 = new Wall("F");
        addObject(wallp7,this.getRealX(6),this.getRealY(4));
        
        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
    }
    
    public void prepareC01L09() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(5),this.getRealY(6));
        player0.setRotation(270);
        String[] firstPage = new String[]{"Ist dir aufgefallen, dass alle Befehle","eine Gemeinsamkeit teilen?","","Die Form: Der Befehl ist immer kleingeschrieben."};
        String[] secondPage = new String[]{"Außerdem endet er immer mit zwei", "Klammern und ein Semikolon.","","Die Bedeutung der Klammern erlernen wir später."};
        String[] thirdPage = new String[]{"Das Semikolon dient jedoch dazu, zwei","Befehle voneinander zu trennen. In Java ist es","nämlich erlaubt, Befehle nebeneinander zu","schreiben: schritt();schritt();","Dies führt allerdings schnell zu Unlesbarkeit."};
        String wm = "+20 EXP\n\nJedes Kapitel beschäftigt sich mit einem\nKonzept der Programmierung.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Checkpoint c1 = new Checkpoint(0);
        addObject(c1,this.getRealX(5),this.getRealY(5));
        Checkpoint c2 = new Checkpoint(0);
        addObject(c2,this.getRealX(6),this.getRealY(6));
        Checkpoint c3 = new Checkpoint(0);
        addObject(c3,this.getRealX(5),this.getRealY(7));
        Checkpoint c4 = new Checkpoint(0);
        addObject(c4,this.getRealX(4),this.getRealY(6));
        Wall wall5 = new Wall("FOLSE");
        addObject(wall5,this.getRealX(3),this.getRealY(5));
        Wall wall6 = new Wall("FILNW");
        addObject(wall6,this.getRealX(4),this.getRealY(5));
        Wall wall7 = new Wall("FOLSE");
        addObject(wall7,this.getRealX(4),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(5),this.getRealY(4));
        Wall wall9 = new Wall("FOLWS");
        addObject(wall9,this.getRealX(6),this.getRealY(4));
        Wall wall10 = new Wall("FILEN");
        addObject(wall10,this.getRealX(6),this.getRealY(5));
        Wall wall11 = new Wall("FOLWS");
        addObject(wall11,this.getRealX(7),this.getRealY(5));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(7),this.getRealY(6));
        Wall wall13 = new Wall("FOLNW");
        addObject(wall13,this.getRealX(7),this.getRealY(7));
        Wall wall14 = new Wall("FILSE");
        addObject(wall14,this.getRealX(6),this.getRealY(7));
        Wall wall15 = new Wall("FOLNW");
        addObject(wall15,this.getRealX(6),this.getRealY(8));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(5),this.getRealY(8));
        Wall wall17 = new Wall("FOLEN");
        addObject(wall17,this.getRealX(4),this.getRealY(8));
        Wall wall18 = new Wall("FILWS");
        addObject(wall18,this.getRealX(4),this.getRealY(7));
        Wall wall19 = new Wall("FOLEN");
        addObject(wall19,this.getRealX(3),this.getRealY(7));
        Wall wall20 = new Wall("FWV");
        addObject(wall20,this.getRealX(3),this.getRealY(6));
        
        Wall wallp00 = new Wall("F");
        addObject(wallp00,this.getRealX(0),this.getRealY(4));
        Wall wallp01 = new Wall("F");
        addObject(wallp01,this.getRealX(0),this.getRealY(5));
        Wall wallp02 = new Wall("F");
        addObject(wallp02,this.getRealX(0),this.getRealY(6));
        Wall wallp03 = new Wall("F");
        addObject(wallp03,this.getRealX(0),this.getRealY(7));
        Wall wallp04 = new Wall("F");
        addObject(wallp04,this.getRealX(0),this.getRealY(8));
        
        Wall wallp10 = new Wall("F");
        addObject(wallp10,this.getRealX(1),this.getRealY(4));
        Wall wallp11 = new Wall("F");
        addObject(wallp11,this.getRealX(1),this.getRealY(5));
        Wall wallp12 = new Wall("F");
        addObject(wallp12,this.getRealX(1),this.getRealY(6));
        Wall wallp13 = new Wall("F");
        addObject(wallp13,this.getRealX(1),this.getRealY(7));
        Wall wallp14 = new Wall("F");
        addObject(wallp14,this.getRealX(1),this.getRealY(8));
        
        Wall wallp20 = new Wall("F");
        addObject(wallp20,this.getRealX(2),this.getRealY(4));
        Wall wallp21 = new Wall("F");
        addObject(wallp21,this.getRealX(2),this.getRealY(5));
        Wall wallp22 = new Wall("F");
        addObject(wallp22,this.getRealX(2),this.getRealY(6));
        Wall wallp23 = new Wall("F");
        addObject(wallp23,this.getRealX(2),this.getRealY(7));
        Wall wallp24 = new Wall("F");
        addObject(wallp24,this.getRealX(2),this.getRealY(8));
        
        Wall wallp30 = new Wall("F");
        addObject(wallp30,this.getRealX(8),this.getRealY(4));
        Wall wallp31 = new Wall("F");
        addObject(wallp31,this.getRealX(8),this.getRealY(5));
        Wall wallp32 = new Wall("F");
        addObject(wallp32,this.getRealX(8),this.getRealY(6));
        Wall wallp33 = new Wall("F");
        addObject(wallp33,this.getRealX(8),this.getRealY(7));
        Wall wallp34 = new Wall("F");
        addObject(wallp34,this.getRealX(8),this.getRealY(8));
        
        Wall wallp40 = new Wall("F");
        addObject(wallp40,this.getRealX(9),this.getRealY(4));
        Wall wallp41 = new Wall("F");
        addObject(wallp41,this.getRealX(9),this.getRealY(5));
        Wall wallp42 = new Wall("F");
        addObject(wallp42,this.getRealX(9),this.getRealY(6));
        Wall wallp43 = new Wall("F");
        addObject(wallp43,this.getRealX(9),this.getRealY(7));
        Wall wallp44 = new Wall("F");
        addObject(wallp44,this.getRealX(9),this.getRealY(8));
        
        Wall wallp50 = new Wall("F");
        addObject(wallp50,this.getRealX(10),this.getRealY(4));
        Wall wallp51 = new Wall("F");
        addObject(wallp51,this.getRealX(10),this.getRealY(5));
        Wall wallp52 = new Wall("F");
        addObject(wallp52,this.getRealX(10),this.getRealY(6));
        Wall wallp53 = new Wall("F");
        addObject(wallp53,this.getRealX(10),this.getRealY(7));
        Wall wallp54 = new Wall("F");
        addObject(wallp54,this.getRealX(10),this.getRealY(8));
        
        Wall wallp60 = new Wall("F");
        addObject(wallp60,this.getRealX(3),this.getRealY(4));
        Wall wallp61 = new Wall("F");
        addObject(wallp61,this.getRealX(3),this.getRealY(8));
        Wall wallp62 = new Wall("F");
        addObject(wallp62,this.getRealX(7),this.getRealY(4));
        Wall wallp63 = new Wall("F");
        addObject(wallp63,this.getRealX(7),this.getRealY(8));

        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
    }
    
    public void prepareC01L10() {
        Spieler player28 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player28};
        addObject(player28,this.getRealX(6),this.getRealY(9));
        player28.setRotation(180);
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(2),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(3),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(4),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(5),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(6),this.getRealY(4));
        Wall wall5 = new Wall("FOLWS");
        addObject(wall5,this.getRealX(7),this.getRealY(4));
        Wall wall6 = new Wall("FEV");
        addObject(wall6,this.getRealX(7),this.getRealY(5));
        Wall wall7 = new Wall("FEV");
        addObject(wall7,this.getRealX(7),this.getRealY(6));
        Wall wall8 = new Wall("FEV");
        addObject(wall8,this.getRealX(7),this.getRealY(7));
        Wall wall9 = new Wall("FTW");
        addObject(wall9,this.getRealX(7),this.getRealY(8));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(7),this.getRealY(9));
        Wall wall11 = new Wall("FOLNW");
        addObject(wall11,this.getRealX(7),this.getRealY(10));
        Wall wall12 = new Wall("FSH");
        addObject(wall12,this.getRealX(3),this.getRealY(10));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(4),this.getRealY(10));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(5),this.getRealY(10));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(6),this.getRealY(10));
        Wall wall16 = new Wall("FOLEN");
        addObject(wall16,this.getRealX(2),this.getRealY(10));
        Wall wall17 = new Wall("FWV");
        addObject(wall17,this.getRealX(2),this.getRealY(5));
        Wall wall18 = new Wall("FWV");
        addObject(wall18,this.getRealX(2),this.getRealY(6));
        Wall wall19 = new Wall("FWV");
        addObject(wall19,this.getRealX(2),this.getRealY(7));
        Wall wall20 = new Wall("FWV");
        addObject(wall20,this.getRealX(2),this.getRealY(8));
        Wall wall21 = new Wall("FWV");
        addObject(wall21,this.getRealX(2),this.getRealY(9));
        Wall wall22 = new Wall("H");
        addObject(wall22,this.getRealX(6),this.getRealY(8));
        Wall wall23 = new Wall("H");
        addObject(wall23,this.getRealX(5),this.getRealY(8));
        Wall wall24 = new Wall("LEN");
        addObject(wall24,this.getRealX(4),this.getRealY(8));
        Wall wall25 = new Wall("V");
        addObject(wall25,this.getRealX(4),this.getRealY(7));
        Wall wall26 = new Wall("LSE");
        addObject(wall26,this.getRealX(4),this.getRealY(6));
        Wall wall27 = new Wall("H");
        addObject(wall27,this.getRealX(5),this.getRealY(6));
        
        Wall wallp10 = new Wall("F");
        addObject(wallp10,this.getRealX(0),this.getRealY(4));
        Wall wallp11 = new Wall("F");
        addObject(wallp11,this.getRealX(0),this.getRealY(5));
        Wall wallp12 = new Wall("F");
        addObject(wallp12,this.getRealX(0),this.getRealY(6));
        Wall wallp13 = new Wall("F");
        addObject(wallp13,this.getRealX(0),this.getRealY(7));
        Wall wallp14 = new Wall("F");
        addObject(wallp14,this.getRealX(0),this.getRealY(8));
        Wall wallp15 = new Wall("F");
        addObject(wallp15,this.getRealX(0),this.getRealY(9));
        Wall wallp16 = new Wall("F");
        addObject(wallp16,this.getRealX(0),this.getRealY(10));
        
        Wall wallp20 = new Wall("F");
        addObject(wallp20,this.getRealX(1),this.getRealY(4));
        Wall wallp21 = new Wall("F");
        addObject(wallp21,this.getRealX(1),this.getRealY(5));
        Wall wallp22 = new Wall("F");
        addObject(wallp22,this.getRealX(1),this.getRealY(6));
        Wall wallp23 = new Wall("F");
        addObject(wallp23,this.getRealX(1),this.getRealY(7));
        Wall wallp24 = new Wall("F");
        addObject(wallp24,this.getRealX(1),this.getRealY(8));
        Wall wallp25 = new Wall("F");
        addObject(wallp25,this.getRealX(1),this.getRealY(9));
        Wall wallp26 = new Wall("F");
        addObject(wallp26,this.getRealX(1),this.getRealY(10));

        
        Wall wallp30 = new Wall("F");
        addObject(wallp30,this.getRealX(8),this.getRealY(4));
        Wall wallp31 = new Wall("F");
        addObject(wallp31,this.getRealX(8),this.getRealY(5));
        Wall wallp32 = new Wall("F");
        addObject(wallp32,this.getRealX(8),this.getRealY(6));
        Wall wallp33 = new Wall("F");
        addObject(wallp33,this.getRealX(8),this.getRealY(7));
        Wall wallp34 = new Wall("F");
        addObject(wallp34,this.getRealX(8),this.getRealY(8));
        Wall wallp35 = new Wall("F");
        addObject(wallp35,this.getRealX(8),this.getRealY(9));
        Wall wallp36 = new Wall("F");
        addObject(wallp36,this.getRealX(8),this.getRealY(10));

        
        Wall wallp40 = new Wall("F");
        addObject(wallp40,this.getRealX(9),this.getRealY(4));
        Wall wallp41 = new Wall("F");
        addObject(wallp41,this.getRealX(9),this.getRealY(5));
        Wall wallp42 = new Wall("F");
        addObject(wallp42,this.getRealX(9),this.getRealY(6));
        Wall wallp43 = new Wall("F");
        addObject(wallp43,this.getRealX(9),this.getRealY(7));
        Wall wallp44 = new Wall("F");
        addObject(wallp44,this.getRealX(9),this.getRealY(8));
        Wall wallp45 = new Wall("F");
        addObject(wallp45,this.getRealX(9),this.getRealY(9));
        Wall wallp46 = new Wall("F");
        addObject(wallp46,this.getRealX(9),this.getRealY(10));


        String[] firstPage = new String[]{"Eine übliche Technik in der","Programmierung, um große Probleme zu","lösen heißt: Teile & Herrsche."};
        String[] secondPage = new String[]{"Dabei versucht man nicht das ganze","Problem auf einmal zu lösen, sondern dieses","in kleinere Teilprobleme zu teilen und diese","dann nacheinander zu lösen."};
        String[] thirdPage = new String[]{"In diesem Level wäre es so:","Du versuchst das Programm erst zum ersten","Checkpoint zu schreiben.","Von da aus erweiterst du das Programm","dann zum nächsten Checkpoint usw."};
        String wm = "+30 EXP\n\nSuper, das war das schwerste Level des\nersten Kapitels!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Checkpoint c29 = new Checkpoint(0);
        addObject(c29,this.getRealX(3),this.getRealY(9));
        Checkpoint c30 = new Checkpoint(0);
        addObject(c30,this.getRealX(3),this.getRealY(5));
        Checkpoint c31 = new Checkpoint(0);
        addObject(c31,this.getRealX(6),this.getRealY(5));
        Checkpoint c32 = new Checkpoint(0);
        addObject(c32,this.getRealX(5),this.getRealY(7));
        
        this.isRewritable = false;
        this.isCampaignLevel = true;     
        //this.exportLevel();
    }
    
    public void prepareC02L01() {
        Outline o25 = new Outline();
        addObject(o25,this.getRealX(3),this.getRealY(5));
        Outline o26 = new Outline();
        addObject(o26,this.getRealX(4),this.getRealY(5));
        Outline o27 = new Outline();
        addObject(o27,this.getRealX(5),this.getRealY(5));
        Outline o28 = new Outline();
        addObject(o28,this.getRealX(6),this.getRealY(5));
        Outline o29 = new Outline();
        addObject(o29,this.getRealX(7),this.getRealY(5));
        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(2),this.getRealY(5));
        player0.setRotation(0);
        String[] firstPage = new String[]{"Willkommen im zweiten Kapitel!","","Wir beginnen mit der Einführung eines neuen","Level-Ziels."};
        String[] secondPage = new String[]{"Die stark umrandeten Felder sind","Markierungen.","","Wenn ein Level solche Markierungen vorweist,","so muss man alle diese einfärben."};
        String[] thirdPage = new String[]{"Dazu kann man den normalen","Schuss-Befehl nutzen, oder den neuen Befehl","färben();"};
        String[] fourthPage = new String[]{"Dieser Befehl lässt deine Figur das Feld,","auf dem sie gerade steht einfärben."};
        String wm = "+10 EXP\nSehr gut!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Wall wall1 = new Wall("FOLSE");
        addObject(wall1,this.getRealX(0),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(1),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(2),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(3),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(4),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(5),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(6),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(7),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(8),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(9),this.getRealY(4));
        Wall wall11 = new Wall("FOLWS");
        addObject(wall11,this.getRealX(10),this.getRealY(4));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(5));
        Wall wall13 = new Wall("FOLNW");
        addObject(wall13,this.getRealX(10),this.getRealY(6));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(1),this.getRealY(6));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(2),this.getRealY(6));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(3),this.getRealY(6));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(4),this.getRealY(6));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(5),this.getRealY(6));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(6),this.getRealY(6));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(7),this.getRealY(6));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(8),this.getRealY(6));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(9),this.getRealY(6));
        Wall wall23 = new Wall("FOLEN");
        addObject(wall23,this.getRealX(0),this.getRealY(6));
        Wall wall24 = new Wall("FWV");
        addObject(wall24,this.getRealX(0),this.getRealY(5));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L02() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(1),this.getRealY(7));
        player0.setRotation(270);
        String[] firstPage = new String[]{"Okay, dieses Level sieht nach einem","hohen Schreibaufwand aus.","","Es wird Zeit, etwas Neues zu lernen, dass den","Schreibaufwand reduziert."};
        String[] secondPage = new String[]{"In vielen Programmiersprachen gibt es","die Möglichkeit, eigene Befehle zu schreiben.","","Diese heißen im Fachbegriff 'Prozeduren'."};
        String[] thirdPage = new String[]{"Um eine Prozedur zu schreiben, muss","man diese im Editor vor oder nach dem","'code'-Bereich platzieren."};
        String[] fourthPage = new String[]{"Syntax:","public void prozedurName() {","//Hier steht, was dein Befehl machen soll.","","}"};
        String[] fifthPage = new String[]{"Beispiel:","public void umdrehen() {","    linksDrehen();","    linksDrehen();","}"};
        String[] sixthPage = new String[]{"Der Befehl kann dann nach dem Anlegen","im code-Bereich oder anderen Prozeduren","verwendet werden, indem man einfach","'umdrehen();' schreibt."};   
        String[] seventhPage = new String[]{"Versuche diese Aufgabe mit Prozeduren","zu lösen.","","Du kannst so viele Prozeduren anlegen, wie du","möchtest."};
        String wm = "+ 10 EXP\nSehr gut!\n\nProzeduren sind in der Programmierung von\ngroßer Wichtigkeit!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage,sixthPage,seventhPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Wall wall1 = new Wall("BFOLSE");
        addObject(wall1,this.getRealX(0),this.getRealY(4));
        Wall wall2 = new Wall("BFNH");
        addObject(wall2,this.getRealX(1),this.getRealY(4));
        Wall wall3 = new Wall("BFNH");
        addObject(wall3,this.getRealX(2),this.getRealY(4));
        Wall wall4 = new Wall("BFNH");
        addObject(wall4,this.getRealX(3),this.getRealY(4));
        Wall wall5 = new Wall("BFNH");
        addObject(wall5,this.getRealX(4),this.getRealY(4));
        Wall wall6 = new Wall("BFNH");
        addObject(wall6,this.getRealX(5),this.getRealY(4));
        Wall wall7 = new Wall("BFNH");
        addObject(wall7,this.getRealX(6),this.getRealY(4));
        Wall wall8 = new Wall("BFNH");
        addObject(wall8,this.getRealX(7),this.getRealY(4));
        Wall wall9 = new Wall("BFNH");
        addObject(wall9,this.getRealX(8),this.getRealY(4));
        Wall wall10 = new Wall("BFNH");
        addObject(wall10,this.getRealX(9),this.getRealY(4));
        Wall wall11 = new Wall("BFOLWS");
        addObject(wall11,this.getRealX(10),this.getRealY(4));
        Wall wall12 = new Wall("BFEV");
        addObject(wall12,this.getRealX(10),this.getRealY(5));
        Wall wall13 = new Wall("BFEV");
        addObject(wall13,this.getRealX(10),this.getRealY(6));
        Wall wall14 = new Wall("BFEV");
        addObject(wall14,this.getRealX(10),this.getRealY(7));
        Wall wall15 = new Wall("BFEV");
        addObject(wall15,this.getRealX(10),this.getRealY(8));
        Wall wall16 = new Wall("BFEV");
        addObject(wall16,this.getRealX(10),this.getRealY(9));
        Wall wall17 = new Wall("BFOLNW");
        addObject(wall17,this.getRealX(10),this.getRealY(10));
        Wall wall18 = new Wall("BFSH");
        addObject(wall18,this.getRealX(1),this.getRealY(10));

        Wall wall20 = new Wall("BFSH");
        addObject(wall20,this.getRealX(3),this.getRealY(10));

        Wall wall22 = new Wall("BFSH");
        addObject(wall22,this.getRealX(5),this.getRealY(10));

        Wall wall24 = new Wall("BFSH");
        addObject(wall24,this.getRealX(7),this.getRealY(10));

        Wall wall26 = new Wall("BFSH");
        addObject(wall26,this.getRealX(9),this.getRealY(10));
        Wall wall27 = new Wall("BFOLEN");
        addObject(wall27,this.getRealX(0),this.getRealY(10));
        Wall wall28 = new Wall("BFWV");
        addObject(wall28,this.getRealX(0),this.getRealY(5));
        Wall wall29 = new Wall("BFWV");
        addObject(wall29,this.getRealX(0),this.getRealY(6));
        Wall wall30 = new Wall("BFWV");
        addObject(wall30,this.getRealX(0),this.getRealY(7));
        Wall wall31 = new Wall("BFWV");
        addObject(wall31,this.getRealX(0),this.getRealY(8));
        Wall wall32 = new Wall("BFWV");
        addObject(wall32,this.getRealX(0),this.getRealY(9));
        Wall wall33 = new Wall("FTS");
        addObject(wall33,this.getRealX(2),this.getRealY(4));
        Wall wall34 = new Wall("FTS");
        addObject(wall34,this.getRealX(4),this.getRealY(4));
        Wall wall35 = new Wall("FTS");
        addObject(wall35,this.getRealX(6),this.getRealY(4));
        Wall wall36 = new Wall("FTS");
        addObject(wall36,this.getRealX(8),this.getRealY(4));
        Wall wall37 = new Wall("FTN");
        addObject(wall37,this.getRealX(2),this.getRealY(10));
        Wall wall38 = new Wall("FTN");
        addObject(wall38,this.getRealX(4),this.getRealY(10));
        Wall wall39 = new Wall("FTN");
        addObject(wall39,this.getRealX(6),this.getRealY(10));
        Wall wall40 = new Wall("FTN");
        addObject(wall40,this.getRealX(8),this.getRealY(10));
        Wall wall41 = new Wall("V");
        addObject(wall41,this.getRealX(2),this.getRealY(5));
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(2),this.getRealY(6));
        Wall wall43 = new Wall("V");
        addObject(wall43,this.getRealX(4),this.getRealY(5));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(4),this.getRealY(6));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(6),this.getRealY(5));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(6),this.getRealY(6));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(8),this.getRealY(5));
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(8),this.getRealY(6));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(2),this.getRealY(9));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(2),this.getRealY(8));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(4),this.getRealY(8));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(4),this.getRealY(9));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(6),this.getRealY(8));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(6),this.getRealY(9));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(8),this.getRealY(8));
        Wall wall56 = new Wall("V");
        addObject(wall56,this.getRealX(8),this.getRealY(9));
        Target t57 = new Target();
        addObject(t57,this.getRealX(1),this.getRealY(5));
        Target t58 = new Target();
        addObject(t58,this.getRealX(3),this.getRealY(5));
        Target t59 = new Target();
        addObject(t59,this.getRealX(5),this.getRealY(5));
        Target t60 = new Target();
        addObject(t60,this.getRealX(7),this.getRealY(5));
        Target t61 = new Target();
        addObject(t61,this.getRealX(9),this.getRealY(5));
        Target t62 = new Target();
        addObject(t62,this.getRealX(1),this.getRealY(9));
        Target t63 = new Target();
        addObject(t63,this.getRealX(3),this.getRealY(9));
        Target t64 = new Target();
        addObject(t64,this.getRealX(5),this.getRealY(9));
        Target t65 = new Target();
        addObject(t65,this.getRealX(7),this.getRealY(9));
        Target t66 = new Target();
        addObject(t66,this.getRealX(9),this.getRealY(9));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L03() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        addObject(player0,this.getRealX(1),this.getRealY(5));
        Spieler[] P = new Spieler[]{player0};
        player0.setRotation(0);
        String[] firstPage = new String[]{"Der Konvention halber schreiben","wir Prozedurnamen immer im","Camelcode."};
        String[] secondPage = new String[]{"Nach diesem werden Namen","immer, falls sie aus mehreren Wörtern","bestehen, wie ein Wort zusammen-","geschrieben."};
        String[] thirdPage = new String[]{"Die Anfangsbuchstaben jedes","Wortes, mit Ausnahme des ersten,","werden dabei großgeschrieben."};
        String[] fourthPage = new String[]{"Beispiele: (Nicht im Spiel)","geheWeiter();","dreheNachSüden();","warteVierMinutenAufDenBus();"};
        String wm = "+10 EXP\n\nDenke daran, stets den Camelcode\nzu verwenden.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Item i1 = new Item();
        addObject(i1,this.getRealX(3),this.getRealY(5));
        Item i2 = new Item();
        addObject(i2,this.getRealX(5),this.getRealY(5));
        Item i3 = new Item();
        addObject(i3,this.getRealX(7),this.getRealY(5));
        Item i4 = new Item();
        addObject(i4,this.getRealX(1),this.getRealY(7));
        Item i5 = new Item();
        addObject(i5,this.getRealX(3),this.getRealY(7));
        Item i6 = new Item();
        addObject(i6,this.getRealX(5),this.getRealY(7));
        Item i7 = new Item();
        addObject(i7,this.getRealX(7),this.getRealY(7));
        Wall wall11 = new Wall("FOLSE");
        addObject(wall11,this.getRealX(0),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(1),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(2),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(3),this.getRealY(4));
        Wall wall15 = new Wall("FNH");
        addObject(wall15,this.getRealX(4),this.getRealY(4));
        Wall wall16 = new Wall("FNH");
        addObject(wall16,this.getRealX(5),this.getRealY(4));
        Wall wall17 = new Wall("FNH");
        addObject(wall17,this.getRealX(6),this.getRealY(4));
        Wall wall18 = new Wall("FNH");
        addObject(wall18,this.getRealX(7),this.getRealY(4));
        Wall wall19 = new Wall("FOLWS");
        addObject(wall19,this.getRealX(8),this.getRealY(4));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(8),this.getRealY(5));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(8),this.getRealY(6));
        Wall wall22 = new Wall("FEV");
        addObject(wall22,this.getRealX(8),this.getRealY(7));
        Wall wall23 = new Wall("FOLNW");
        addObject(wall23,this.getRealX(8),this.getRealY(8));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(1),this.getRealY(8));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(2),this.getRealY(8));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(3),this.getRealY(8));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(4),this.getRealY(8));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(5),this.getRealY(8));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(6),this.getRealY(8));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(7),this.getRealY(8));
        Wall wall31 = new Wall("FOLEN");
        addObject(wall31,this.getRealX(0),this.getRealY(8));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(5));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(6));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(7));
        Wall wall35 = new Wall("F");
        addObject(wall35,this.getRealX(2),this.getRealY(6));
        Wall wall36 = new Wall("F");
        addObject(wall36,this.getRealX(4),this.getRealY(6));
        Wall wall37 = new Wall("F");
        addObject(wall37,this.getRealX(6),this.getRealY(6));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L04() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(1),this.getRealY(9));
        player0.setRotation(270);
        String[] firstPage = new String[]{"Wie zuvor bereits erwähnt, kann man","viele Probleme nach dem \"Teile & Herrsche\"","Prinzip lösen."};
        String[] secondPage = new String[]{"In Verbindung mit der Nutzung von","Prozeduren kann man sagen, dass man","möglichst versuchen sollte, jedes Teilproblem","mit einer Prozedur zu lösen."};
        String[] thirdPage = new String[]{"Für dieses Level könnte man drei","Teilprobleme sehen.","Eine, um die Figur bis zum Ende der Reihe","laufen zu lassen. Und zwei weitere, um","zur nächsten Reihe zu gelangen. (wie man steht)"};
        String wm = "+10 EXP";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Checkpoint c1 = new Checkpoint(0);
        addObject(c1,this.getRealX(1),this.getRealY(5));
        Checkpoint c2 = new Checkpoint(0);
        addObject(c2,this.getRealX(3),this.getRealY(5));
        Checkpoint c3 = new Checkpoint(0);
        addObject(c3,this.getRealX(3),this.getRealY(9));
        Checkpoint c4 = new Checkpoint(0);
        addObject(c4,this.getRealX(5),this.getRealY(9));
        Checkpoint c5 = new Checkpoint(0);
        addObject(c5,this.getRealX(5),this.getRealY(5));
        Checkpoint c6 = new Checkpoint(0);
        addObject(c6,this.getRealX(7),this.getRealY(5));
        Checkpoint c7 = new Checkpoint(0);
        addObject(c7,this.getRealX(7),this.getRealY(9));
        Checkpoint c8 = new Checkpoint(0);
        addObject(c8,this.getRealX(9),this.getRealY(9));
        Checkpoint c9 = new Checkpoint(0);
        addObject(c9,this.getRealX(9),this.getRealY(5));
        Wall wall10 = new Wall("FOLSE");
        addObject(wall10,this.getRealX(0),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(1),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(2),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(3),this.getRealY(4));
        Wall wall14 = new Wall("FTS");
        addObject(wall14,this.getRealX(4),this.getRealY(4));
        Wall wall15 = new Wall("FNH");
        addObject(wall15,this.getRealX(5),this.getRealY(4));
        Wall wall16 = new Wall("FNH");
        addObject(wall16,this.getRealX(6),this.getRealY(4));
        Wall wall17 = new Wall("FNH");
        addObject(wall17,this.getRealX(7),this.getRealY(4));
        Wall wall18 = new Wall("FTS");
        addObject(wall18,this.getRealX(8),this.getRealY(4));
        Wall wall19 = new Wall("FNH");
        addObject(wall19,this.getRealX(9),this.getRealY(4));
        Wall wall20 = new Wall("FOLWS");
        addObject(wall20,this.getRealX(10),this.getRealY(4));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(10),this.getRealY(5));
        Wall wall22 = new Wall("FEV");
        addObject(wall22,this.getRealX(10),this.getRealY(6));
        Wall wall23 = new Wall("FEV");
        addObject(wall23,this.getRealX(10),this.getRealY(7));
        Wall wall24 = new Wall("FEV");
        addObject(wall24,this.getRealX(10),this.getRealY(8));
        Wall wall25 = new Wall("FEV");
        addObject(wall25,this.getRealX(10),this.getRealY(9));
        Wall wall26 = new Wall("FOLNW");
        addObject(wall26,this.getRealX(10),this.getRealY(10));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(1),this.getRealY(10));
        Wall wall28 = new Wall("FTN");
        addObject(wall28,this.getRealX(2),this.getRealY(10));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(3),this.getRealY(10));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(4),this.getRealY(10));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(5),this.getRealY(10));
        Wall wall32 = new Wall("FTN");
        addObject(wall32,this.getRealX(6),this.getRealY(10));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(7),this.getRealY(10));
        Wall wall34 = new Wall("FSH");
        addObject(wall34,this.getRealX(8),this.getRealY(10));
        Wall wall35 = new Wall("FSH");
        addObject(wall35,this.getRealX(9),this.getRealY(10));
        Wall wall36 = new Wall("FOLEN");
        addObject(wall36,this.getRealX(0),this.getRealY(10));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(5));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(6));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(7));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(8));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(9));
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(2),this.getRealY(6));
        Wall wall43 = new Wall("V");
        addObject(wall43,this.getRealX(2),this.getRealY(7));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(2),this.getRealY(8));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(2),this.getRealY(9));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(4),this.getRealY(5));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(4),this.getRealY(6));
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(4),this.getRealY(7));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(4),this.getRealY(8));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(6),this.getRealY(6));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(6),this.getRealY(7));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(6),this.getRealY(8));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(6),this.getRealY(9));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(8),this.getRealY(5));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(8),this.getRealY(6));
        Wall wall56 = new Wall("V");
        addObject(wall56,this.getRealX(8),this.getRealY(7));
        Wall wall57 = new Wall("V");
        addObject(wall57,this.getRealX(8),this.getRealY(8));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }

    public void prepareC02L05() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(1),this.getRealY(6));
        player0.setRotation(0);
        String[] firstPage = new String[]{"Programmierer sollten in der Lage sein,","einzuschätzen, wann die Implementierung","einer Prozedur notwendig ist."};
        String[] secondPage = new String[]{"Sobald eine Aufgabe monotone,","wiederholende Strukturen hat, sollte man","versuchen, diese durch eine Prozedur zu lösen."};
        String wm = "+10 EXP";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Item i1 = new Item();
        addObject(i1,this.getRealX(2),this.getRealY(6));
        Item i2 = new Item();
        addObject(i2,this.getRealX(3),this.getRealY(6));
        Item i3 = new Item();
        addObject(i3,this.getRealX(2),this.getRealY(7));
        Item i4 = new Item();
        addObject(i4,this.getRealX(3),this.getRealY(7));
        Item i5 = new Item();
        addObject(i5,this.getRealX(5),this.getRealY(6));
        Item i6 = new Item();
        addObject(i6,this.getRealX(5),this.getRealY(7));
        Item i7 = new Item();
        addObject(i7,this.getRealX(6),this.getRealY(6));
        Item i8 = new Item();
        addObject(i8,this.getRealX(6),this.getRealY(7));
        Item i9 = new Item();
        addObject(i9,this.getRealX(8),this.getRealY(6));
        Item i10 = new Item();
        addObject(i10,this.getRealX(8),this.getRealY(7));
        Item i11 = new Item();
        addObject(i11,this.getRealX(9),this.getRealY(6));
        Item i12 = new Item();
        addObject(i12,this.getRealX(9),this.getRealY(7));
        Wall wall13 = new Wall("FOLSE");
        addObject(wall13,this.getRealX(0),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(1),this.getRealY(4));
        Wall wall15 = new Wall("FNH");
        addObject(wall15,this.getRealX(2),this.getRealY(4));
        Wall wall16 = new Wall("FNH");
        addObject(wall16,this.getRealX(3),this.getRealY(4));
        Wall wall17 = new Wall("FNH");
        addObject(wall17,this.getRealX(4),this.getRealY(4));
        Wall wall18 = new Wall("FNH");
        addObject(wall18,this.getRealX(5),this.getRealY(4));
        Wall wall19 = new Wall("FNH");
        addObject(wall19,this.getRealX(6),this.getRealY(4));
        Wall wall20 = new Wall("FNH");
        addObject(wall20,this.getRealX(7),this.getRealY(4));
        Wall wall21 = new Wall("FNH");
        addObject(wall21,this.getRealX(8),this.getRealY(4));
        Wall wall22 = new Wall("FNH");
        addObject(wall22,this.getRealX(9),this.getRealY(4));
        Wall wall23 = new Wall("FOLWS");
        addObject(wall23,this.getRealX(10),this.getRealY(4));
        Wall wall24 = new Wall("FEV");
        addObject(wall24,this.getRealX(10),this.getRealY(5));
        Wall wall25 = new Wall("FEV");
        addObject(wall25,this.getRealX(10),this.getRealY(6));
        Wall wall26 = new Wall("FEV");
        addObject(wall26,this.getRealX(10),this.getRealY(7));
        Wall wall27 = new Wall("FEV");
        addObject(wall27,this.getRealX(10),this.getRealY(8));
        Wall wall28 = new Wall("FOLNW");
        addObject(wall28,this.getRealX(10),this.getRealY(9));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(1),this.getRealY(9));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(2),this.getRealY(9));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(3),this.getRealY(9));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(4),this.getRealY(9));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(5),this.getRealY(9));
        Wall wall34 = new Wall("FSH");
        addObject(wall34,this.getRealX(6),this.getRealY(9));
        Wall wall35 = new Wall("FSH");
        addObject(wall35,this.getRealX(7),this.getRealY(9));
        Wall wall36 = new Wall("FSH");
        addObject(wall36,this.getRealX(8),this.getRealY(9));
        Wall wall37 = new Wall("FSH");
        addObject(wall37,this.getRealX(9),this.getRealY(9));
        Wall wall38 = new Wall("FOLEN");
        addObject(wall38,this.getRealX(0),this.getRealY(9));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(5));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(6));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(7));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(8));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L06() {
        
        Outline o0 = new Outline();
        addObject(o0,this.getRealX(1),this.getRealY(5));
        Outline o1 = new Outline();
        addObject(o1,this.getRealX(2),this.getRealY(5));
        Outline o2 = new Outline();
        addObject(o2,this.getRealX(1),this.getRealY(6));
        Outline o3 = new Outline();
        addObject(o3,this.getRealX(2),this.getRealY(6));
        Outline o4 = new Outline();
        addObject(o4,this.getRealX(1),this.getRealY(7));
        Outline o5 = new Outline();
        addObject(o5,this.getRealX(2),this.getRealY(7));
        Outline o6 = new Outline();
        addObject(o6,this.getRealX(4),this.getRealY(5));
        Outline o7 = new Outline();
        addObject(o7,this.getRealX(4),this.getRealY(6));
        Outline o8 = new Outline();
        addObject(o8,this.getRealX(4),this.getRealY(7));
        Outline o9 = new Outline();
        addObject(o9,this.getRealX(5),this.getRealY(5));
        Outline o10 = new Outline();
        addObject(o10,this.getRealX(5),this.getRealY(6));
        Outline o11 = new Outline();
        addObject(o11,this.getRealX(5),this.getRealY(7));
        Outline o12 = new Outline();
        addObject(o12,this.getRealX(7),this.getRealY(5));
        Outline o13 = new Outline();
        addObject(o13,this.getRealX(7),this.getRealY(6));
        Outline o14 = new Outline();
        addObject(o14,this.getRealX(7),this.getRealY(7));
        Outline o15 = new Outline();
        addObject(o15,this.getRealX(8),this.getRealY(5));
        Outline o16 = new Outline();
        addObject(o16,this.getRealX(8),this.getRealY(6));
        Outline o17 = new Outline();
        addObject(o17,this.getRealX(8),this.getRealY(7));
        Checkpoint c18 = new Checkpoint(0);
        addObject(c18,this.getRealX(3),this.getRealY(6));
        Checkpoint c19 = new Checkpoint(0);
        addObject(c19,this.getRealX(6),this.getRealY(6));
        
        Spieler player21 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player21};
        addObject(player21,this.getRealX(9),this.getRealY(6));
        player21.setRotation(180);
        String[] firstPage = new String[]{"Wie hier kann es auch vorkommen,","dass ein Level unterschiedliche Ziele hat.","","In einem solchen Fall, muss man alle","Aufgaben erledigen."};
        String wm = "+10 EXP";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Wall wall22 = new Wall("FOLSE");
        addObject(wall22,this.getRealX(0),this.getRealY(4));
        Wall wall23 = new Wall("FNH");
        addObject(wall23,this.getRealX(1),this.getRealY(4));
        Wall wall24 = new Wall("FNH");
        addObject(wall24,this.getRealX(2),this.getRealY(4));
        Wall wall25 = new Wall("FNH");
        addObject(wall25,this.getRealX(3),this.getRealY(4));
        Wall wall26 = new Wall("FNH");
        addObject(wall26,this.getRealX(4),this.getRealY(4));
        Wall wall27 = new Wall("FNH");
        addObject(wall27,this.getRealX(5),this.getRealY(4));
        Wall wall28 = new Wall("FNH");
        addObject(wall28,this.getRealX(6),this.getRealY(4));
        Wall wall29 = new Wall("FNH");
        addObject(wall29,this.getRealX(7),this.getRealY(4));
        Wall wall30 = new Wall("FNH");
        addObject(wall30,this.getRealX(8),this.getRealY(4));
        Wall wall31 = new Wall("FOLWS");
        addObject(wall31,this.getRealX(9),this.getRealY(4));
        Wall wall32 = new Wall("FEV");
        addObject(wall32,this.getRealX(9),this.getRealY(5));
        
        Wall wall34 = new Wall("FEV");
        addObject(wall34,this.getRealX(9),this.getRealY(7));
        Wall wall35 = new Wall("FOLNW");
        addObject(wall35,this.getRealX(9),this.getRealY(8));
        Wall wall36 = new Wall("FSH");
        addObject(wall36,this.getRealX(1),this.getRealY(8));
        Wall wall37 = new Wall("FSH");
        addObject(wall37,this.getRealX(2),this.getRealY(8));
        Wall wall38 = new Wall("FSH");
        addObject(wall38,this.getRealX(3),this.getRealY(8));
        Wall wall39 = new Wall("FSH");
        addObject(wall39,this.getRealX(4),this.getRealY(8));
        Wall wall40 = new Wall("FSH");
        addObject(wall40,this.getRealX(5),this.getRealY(8));
        Wall wall41 = new Wall("FSH");
        addObject(wall41,this.getRealX(6),this.getRealY(8));
        Wall wall42 = new Wall("FSH");
        addObject(wall42,this.getRealX(7),this.getRealY(8));
        Wall wall43 = new Wall("FSH");
        addObject(wall43,this.getRealX(8),this.getRealY(8));
        Wall wall44 = new Wall("FOLEN");
        addObject(wall44,this.getRealX(0),this.getRealY(8));
        Wall wall45 = new Wall("FWV");
        addObject(wall45,this.getRealX(0),this.getRealY(5));
        Wall wall46 = new Wall("FWV");
        addObject(wall46,this.getRealX(0),this.getRealY(6));
        Wall wall47 = new Wall("FWV");
        addObject(wall47,this.getRealX(0),this.getRealY(7));
        
        Wall wall48 = new Wall("FTS");
        addObject(wall48,this.getRealX(3),this.getRealY(4));
        Wall wall49 = new Wall("FTS");
        addObject(wall49,this.getRealX(6),this.getRealY(4));
        
        
        Wall wall50 = new Wall("FTN");
        addObject(wall50,this.getRealX(3),this.getRealY(8));
        Wall wall51 = new Wall("FTN");
        addObject(wall51,this.getRealX(6),this.getRealY(8));
        
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(3),this.getRealY(5));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(6),this.getRealY(5));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(3),this.getRealY(7));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(6),this.getRealY(7));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L07() {

        Spieler player0 = new Spieler(this.loadCharacter());
        Spieler[] P = new Spieler[]{player0};
        addObject(player0,this.getRealX(1),this.getRealY(9));
        player0.setRotation(0);
        String[] firstPage = new String[]{"In diesem Level sollst du deiner Figur helfen,","über diese Treppe zu laufen.",};
        String[] secondPage = new String[]{"Versuche dich mal daran, in diesem Level", "folgende Prozeduren zu realisieren:","stufeRauf() / stufeRunter()","treppeRauf() / treppeRunter()","treppeLaufen()"};
        String[] thirdPage = new String[]{"Du kannst die ersten beiden Prozeduren in","den anderen Prozeduren nutzen, z.B. stufeRauf()","in TreppeRauf() usw."};
        String wm = "+10 EXP";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Wall wall1 = new Wall("F");
        addObject(wall1,this.getRealX(6),this.getRealY(6));
        Checkpoint c2 = new Checkpoint(0);
        addObject(c2,this.getRealX(3),this.getRealY(8));
        Checkpoint c3 = new Checkpoint(0);
        addObject(c3,this.getRealX(4),this.getRealY(7));
        Checkpoint c4 = new Checkpoint(0);
        addObject(c4,this.getRealX(5),this.getRealY(6));
        Checkpoint c5 = new Checkpoint(0);
        addObject(c5,this.getRealX(6),this.getRealY(5));
        Checkpoint c6 = new Checkpoint(0);
        addObject(c6,this.getRealX(7),this.getRealY(6));
        Checkpoint c7 = new Checkpoint(0);
        addObject(c7,this.getRealX(8),this.getRealY(7));
        Checkpoint c8 = new Checkpoint(0);
        addObject(c8,this.getRealX(9),this.getRealY(8));
        Checkpoint c9 = new Checkpoint(0);
        addObject(c9,this.getRealX(10),this.getRealY(9));
        Wall wall10 = new Wall("FOLSE");
        addObject(wall10,this.getRealX(0),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(1),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(2),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(3),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(4),this.getRealY(4));
        Wall wall15 = new Wall("FNH");
        addObject(wall15,this.getRealX(5),this.getRealY(4));
        Wall wall16 = new Wall("FNH");
        addObject(wall16,this.getRealX(6),this.getRealY(4));
        Wall wall17 = new Wall("FNH");
        addObject(wall17,this.getRealX(7),this.getRealY(4));
        Wall wall18 = new Wall("FNH");
        addObject(wall18,this.getRealX(8),this.getRealY(4));
        Wall wall19 = new Wall("FNH");
        addObject(wall19,this.getRealX(9),this.getRealY(4));
        Wall wall20 = new Wall("FNH");
        addObject(wall20,this.getRealX(10),this.getRealY(4));
        Wall wall21 = new Wall("FOLWS");
        addObject(wall21,this.getRealX(11),this.getRealY(4));
        Wall wall22 = new Wall("FEV");
        addObject(wall22,this.getRealX(11),this.getRealY(5));
        Wall wall23 = new Wall("FEV");
        addObject(wall23,this.getRealX(11),this.getRealY(6));
        Wall wall24 = new Wall("FEV");
        addObject(wall24,this.getRealX(11),this.getRealY(7));
        Wall wall25 = new Wall("FEV");
        addObject(wall25,this.getRealX(11),this.getRealY(8));
        Wall wall26 = new Wall("FEV");
        addObject(wall26,this.getRealX(11),this.getRealY(9));
        Wall wall27 = new Wall("FOLNW");
        addObject(wall27,this.getRealX(11),this.getRealY(10));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(1),this.getRealY(10));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(2),this.getRealY(10));
        Wall wall30 = new Wall("F");
        addObject(wall30,this.getRealX(3),this.getRealY(10));
        Wall wall31 = new Wall("F");
        addObject(wall31,this.getRealX(4),this.getRealY(10));
        Wall wall32 = new Wall("F");
        addObject(wall32,this.getRealX(5),this.getRealY(10));
        Wall wall33 = new Wall("F");
        addObject(wall33,this.getRealX(6),this.getRealY(10));
        Wall wall34 = new Wall("F");
        addObject(wall34,this.getRealX(7),this.getRealY(10));
        Wall wall35 = new Wall("F");
        addObject(wall35,this.getRealX(8),this.getRealY(10));
        Wall wall36 = new Wall("F");
        addObject(wall36,this.getRealX(9),this.getRealY(10));
        Wall wall37 = new Wall("FSH");
        addObject(wall37,this.getRealX(10),this.getRealY(10));
        Wall wall38 = new Wall("FOLEN");
        addObject(wall38,this.getRealX(0),this.getRealY(10));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(5));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(6));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(7));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(8));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(9));
        
        Wall wall44 = new Wall("F");
        addObject(wall44,this.getRealX(3),this.getRealY(9));
        Wall wall45 = new Wall("F");
        addObject(wall45,this.getRealX(4),this.getRealY(9));
        Wall wall46 = new Wall("F");
        addObject(wall46,this.getRealX(5),this.getRealY(9));
        Wall wall47 = new Wall("F");
        addObject(wall47,this.getRealX(6),this.getRealY(9));
        Wall wall48 = new Wall("F");
        addObject(wall48,this.getRealX(7),this.getRealY(9));
        Wall wall49 = new Wall("F");
        addObject(wall49,this.getRealX(8),this.getRealY(9));
        Wall wall50 = new Wall("F");
        addObject(wall50,this.getRealX(9),this.getRealY(9));
        
        Wall wall51 = new Wall("F");
        addObject(wall51,this.getRealX(4),this.getRealY(8));
        Wall wall52 = new Wall("F");
        addObject(wall52,this.getRealX(5),this.getRealY(8));
        Wall wall53 = new Wall("F");
        addObject(wall53,this.getRealX(6),this.getRealY(8));
        Wall wall54 = new Wall("F");
        addObject(wall54,this.getRealX(7),this.getRealY(8));
        Wall wall55 = new Wall("F");
        addObject(wall55,this.getRealX(8),this.getRealY(8));
        
        Wall wall56 = new Wall("F");
        addObject(wall56,this.getRealX(5),this.getRealY(7));
        Wall wall57 = new Wall("F");
        addObject(wall57,this.getRealX(6),this.getRealY(7));
        Wall wall58 = new Wall("F");
        addObject(wall58,this.getRealX(7),this.getRealY(7));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L08() {
        Item i1 = new Item();
        addObject(i1,this.getRealX(3),this.getRealY(6));
        Item i2 = new Item();
        addObject(i2,this.getRealX(5),this.getRealY(6));
        Item i3 = new Item();
        addObject(i3,this.getRealX(7),this.getRealY(6));
        Item i4 = new Item();
        addObject(i4,this.getRealX(9),this.getRealY(6));
        Item i5 = new Item();
        addObject(i5,this.getRealX(3),this.getRealY(9));
        Item i6 = new Item();
        addObject(i6,this.getRealX(5),this.getRealY(9));
        Item i7 = new Item();
        addObject(i7,this.getRealX(7),this.getRealY(9));
        Item i8 = new Item();
        addObject(i8,this.getRealX(9),this.getRealY(9));
        Spieler player0 = new Spieler(this.loadCharacter());
        addObject(player0,this.getRealX(1),this.getRealY(5));
        player0.setRotation(0);
        Spieler[] P = new Spieler[]{player0};
        String[] firstPage = new String[]{"Wusstest du, dass du deine Spielfigur in den","Optionen ändern kannst?"};
        String wm = "+10 EXP";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        
        Wall wall9 = new Wall("F");
        addObject(wall9,this.getRealX(2),this.getRealY(7));
        Wall wall10 = new Wall("F");
        addObject(wall10,this.getRealX(3),this.getRealY(7));
        Wall wall11 = new Wall("F");
        addObject(wall11,this.getRealX(4),this.getRealY(7));
        Wall wall12 = new Wall("F");
        addObject(wall12,this.getRealX(5),this.getRealY(7));
        Wall wall13 = new Wall("F");
        addObject(wall13,this.getRealX(6),this.getRealY(7));
        Wall wall14 = new Wall("F");
        addObject(wall14,this.getRealX(7),this.getRealY(7));
        Wall wall15 = new Wall("F");
        addObject(wall15,this.getRealX(8),this.getRealY(7));
        Wall wall16 = new Wall("F");
        addObject(wall16,this.getRealX(9),this.getRealY(7));
        Wall wall17 = new Wall("F");
        addObject(wall17,this.getRealX(10),this.getRealY(7));
        Wall wall18 = new Wall("F");
        addObject(wall18,this.getRealX(2),this.getRealY(8));
        Wall wall19 = new Wall("F");
        addObject(wall19,this.getRealX(3),this.getRealY(8));
        Wall wall19x = new Wall("F");
        addObject(wall19x,this.getRealX(4),this.getRealY(9));
        Wall wall20 = new Wall("F");
        addObject(wall20,this.getRealX(4),this.getRealY(8));
        Wall wall21 = new Wall("F");
        addObject(wall21,this.getRealX(5),this.getRealY(8));
        Wall wall22 = new Wall("F");
        addObject(wall22,this.getRealX(6),this.getRealY(8));
        Wall wall23 = new Wall("F");
        addObject(wall23,this.getRealX(7),this.getRealY(8));
        Wall wall24 = new Wall("F");
        addObject(wall24,this.getRealX(8),this.getRealY(8));
        Wall wall25 = new Wall("F");
        addObject(wall25,this.getRealX(9),this.getRealY(8));
        Wall wall26 = new Wall("F");
        addObject(wall26,this.getRealX(10),this.getRealY(8));
        Wall wall27 = new Wall("F");
        addObject(wall27,this.getRealX(2),this.getRealY(6));
        Wall wall28 = new Wall("F");
        addObject(wall28,this.getRealX(4),this.getRealY(6));
        Wall wall29 = new Wall("F");
        addObject(wall29,this.getRealX(6),this.getRealY(6));
        Wall wall30 = new Wall("F");
        addObject(wall30,this.getRealX(8),this.getRealY(6));
        Wall wall31 = new Wall("F");
        addObject(wall31,this.getRealX(10),this.getRealY(6));
        Wall wall32 = new Wall("F");
        addObject(wall32,this.getRealX(2),this.getRealY(9));
        Wall wall33 = new Wall("F");
        addObject(wall33,this.getRealX(4),this.getRealY(6));
        Wall wall34 = new Wall("F");
        addObject(wall34,this.getRealX(6),this.getRealY(9));
        Wall wall35 = new Wall("F");
        addObject(wall35,this.getRealX(8),this.getRealY(9));
        Wall wall36 = new Wall("F");
        addObject(wall36,this.getRealX(10),this.getRealY(9));
        Wall wall37 = new Wall("FOLSE");
        addObject(wall37,this.getRealX(0),this.getRealY(4));
        Wall wall38 = new Wall("FNH");
        addObject(wall38,this.getRealX(1),this.getRealY(4));
        Wall wall39 = new Wall("FNH");
        addObject(wall39,this.getRealX(2),this.getRealY(4));
        Wall wall40 = new Wall("FNH");
        addObject(wall40,this.getRealX(3),this.getRealY(4));
        Wall wall41 = new Wall("FNH");
        addObject(wall41,this.getRealX(4),this.getRealY(4));
        Wall wall42 = new Wall("FNH");
        addObject(wall42,this.getRealX(5),this.getRealY(4));
        Wall wall43 = new Wall("FNH");
        addObject(wall43,this.getRealX(6),this.getRealY(4));
        Wall wall44 = new Wall("FNH");
        addObject(wall44,this.getRealX(7),this.getRealY(4));
        Wall wall45 = new Wall("FNH");
        addObject(wall45,this.getRealX(8),this.getRealY(4));
        Wall wall46 = new Wall("FNH");
        addObject(wall46,this.getRealX(9),this.getRealY(4));
        Wall wall47 = new Wall("FNH");
        addObject(wall47,this.getRealX(10),this.getRealY(4));
        Wall wall48 = new Wall("FNH");
        addObject(wall48,this.getRealX(11),this.getRealY(4));
        Wall wall49 = new Wall("FOLWS");
        addObject(wall49,this.getRealX(12),this.getRealY(4));
        Wall wall50 = new Wall("FEV");
        addObject(wall50,this.getRealX(12),this.getRealY(5));
        Wall wall51 = new Wall("FEV");
        addObject(wall51,this.getRealX(12),this.getRealY(6));
        Wall wall52 = new Wall("FEV");
        addObject(wall52,this.getRealX(12),this.getRealY(7));
        Wall wall53 = new Wall("FEV");
        addObject(wall53,this.getRealX(12),this.getRealY(8));
        Wall wall54 = new Wall("FEV");
        addObject(wall54,this.getRealX(12),this.getRealY(9));
        Wall wall55 = new Wall("FEV");
        addObject(wall55,this.getRealX(12),this.getRealY(10));
        Wall wall56 = new Wall("FOLNW");
        addObject(wall56,this.getRealX(12),this.getRealY(11));
        Wall wall57 = new Wall("FSH");
        addObject(wall57,this.getRealX(1),this.getRealY(11));
        Wall wall58 = new Wall("FSH");
        addObject(wall58,this.getRealX(2),this.getRealY(11));
        Wall wall59 = new Wall("FSH");
        addObject(wall59,this.getRealX(3),this.getRealY(11));
        Wall wall60 = new Wall("FSH");
        addObject(wall60,this.getRealX(4),this.getRealY(11));
        Wall wall61 = new Wall("FSH");
        addObject(wall61,this.getRealX(5),this.getRealY(11));
        Wall wall62 = new Wall("FSH");
        addObject(wall62,this.getRealX(6),this.getRealY(11));
        Wall wall63 = new Wall("FSH");
        addObject(wall63,this.getRealX(7),this.getRealY(11));
        Wall wall64 = new Wall("FSH");
        addObject(wall64,this.getRealX(8),this.getRealY(11));
        Wall wall65 = new Wall("FSH");
        addObject(wall65,this.getRealX(9),this.getRealY(11));
        Wall wall66 = new Wall("FSH");
        addObject(wall66,this.getRealX(10),this.getRealY(11));
        Wall wall67 = new Wall("FSH");
        addObject(wall67,this.getRealX(11),this.getRealY(11));
        Wall wall68 = new Wall("FOLEN");
        addObject(wall68,this.getRealX(0),this.getRealY(11));
        Wall wall69 = new Wall("FWV");
        addObject(wall69,this.getRealX(0),this.getRealY(5));
        Wall wall70 = new Wall("FWV");
        addObject(wall70,this.getRealX(0),this.getRealY(6));
        Wall wall71 = new Wall("FWV");
        addObject(wall71,this.getRealX(0),this.getRealY(7));
        Wall wall72 = new Wall("FWV");
        addObject(wall72,this.getRealX(0),this.getRealY(8));
        Wall wall73 = new Wall("FWV");
        addObject(wall73,this.getRealX(0),this.getRealY(9));
        Wall wall74 = new Wall("FWV");
        addObject(wall74,this.getRealX(0),this.getRealY(10));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L09() {
        
        Wall wall0 = new Wall("F");
        addObject(wall0,this.getRealX(6),this.getRealY(10));
        Target t1 = new Target();
        addObject(t1,this.getRealX(2),this.getRealY(8));
        Target t2 = new Target();
        addObject(t2,this.getRealX(2),this.getRealY(12));
        Target t3 = new Target();
        addObject(t3,this.getRealX(4),this.getRealY(6));
        Target t4 = new Target();
        addObject(t4,this.getRealX(4),this.getRealY(10));
        Target t5 = new Target();
        addObject(t5,this.getRealX(4),this.getRealY(14));
        Target t6 = new Target();
        addObject(t6,this.getRealX(6),this.getRealY(8));
        Target t7 = new Target();
        addObject(t7,this.getRealX(6),this.getRealY(12));
        Target t8 = new Target();
        addObject(t8,this.getRealX(8),this.getRealY(6));
        Target t9 = new Target();
        addObject(t9,this.getRealX(8),this.getRealY(10));
        Target t10 = new Target();
        addObject(t10,this.getRealX(8),this.getRealY(14));
        Target t11 = new Target();
        addObject(t11,this.getRealX(10),this.getRealY(8));
        Target t12 = new Target();
        addObject(t12,this.getRealX(10),this.getRealY(12));
        Checkpoint c13 = new Checkpoint(0);
        addObject(c13,this.getRealX(8),this.getRealY(8));
        Checkpoint c14 = new Checkpoint(0);
        addObject(c14,this.getRealX(8),this.getRealY(12));
        Checkpoint c15 = new Checkpoint(0);
        addObject(c15,this.getRealX(4),this.getRealY(12));
        Spieler player16 = new Spieler(this.loadCharacter());
        addObject(player16,this.getRealX(4),this.getRealY(8));
        player16.setRotation(270);
        Spieler[] P = new Spieler[]{player16};
        String[] firstPage = new String[]{"Manchmal geben dir Checkpoints auch Hinweise","zur Lösung eines Levels."};
        String wm = "+20 EXP";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Wall wall17 = new Wall("FOLSE");
        addObject(wall17,this.getRealX(0),this.getRealY(4));
        Wall wall18 = new Wall("FNH");
        addObject(wall18,this.getRealX(1),this.getRealY(4));
        Wall wall19 = new Wall("FNH");
        addObject(wall19,this.getRealX(2),this.getRealY(4));
        Wall wall20 = new Wall("FNH");
        addObject(wall20,this.getRealX(3),this.getRealY(4));
        Wall wall21 = new Wall("FNH");
        addObject(wall21,this.getRealX(4),this.getRealY(4));
        Wall wall22 = new Wall("FNH");
        addObject(wall22,this.getRealX(5),this.getRealY(4));
        Wall wall23 = new Wall("FNH");
        addObject(wall23,this.getRealX(6),this.getRealY(4));
        Wall wall24 = new Wall("FNH");
        addObject(wall24,this.getRealX(7),this.getRealY(4));
        Wall wall25 = new Wall("FNH");
        addObject(wall25,this.getRealX(8),this.getRealY(4));
        Wall wall26 = new Wall("FNH");
        addObject(wall26,this.getRealX(9),this.getRealY(4));
        Wall wall27 = new Wall("FNH");
        addObject(wall27,this.getRealX(10),this.getRealY(4));
        Wall wall28 = new Wall("FNH");
        addObject(wall28,this.getRealX(11),this.getRealY(4));
        Wall wall29 = new Wall("FOLWS");
        addObject(wall29,this.getRealX(12),this.getRealY(4));
        Wall wall30 = new Wall("FEV");
        addObject(wall30,this.getRealX(12),this.getRealY(5));
        Wall wall31 = new Wall("FEV");
        addObject(wall31,this.getRealX(12),this.getRealY(6));
        Wall wall32 = new Wall("FEV");
        addObject(wall32,this.getRealX(12),this.getRealY(7));
        Wall wall33 = new Wall("FEV");
        addObject(wall33,this.getRealX(12),this.getRealY(8));
        Wall wall34 = new Wall("FEV");
        addObject(wall34,this.getRealX(12),this.getRealY(9));
        Wall wall35 = new Wall("FEV");
        addObject(wall35,this.getRealX(12),this.getRealY(10));
        Wall wall36 = new Wall("FEV");
        addObject(wall36,this.getRealX(12),this.getRealY(11));
        Wall wall37 = new Wall("FEV");
        addObject(wall37,this.getRealX(12),this.getRealY(12));
        Wall wall38 = new Wall("FEV");
        addObject(wall38,this.getRealX(12),this.getRealY(13));
        Wall wall39 = new Wall("FEV");
        addObject(wall39,this.getRealX(12),this.getRealY(14));
        Wall wall40 = new Wall("FEV");
        addObject(wall40,this.getRealX(12),this.getRealY(15));
        Wall wall41 = new Wall("FOLNW");
        addObject(wall41,this.getRealX(12),this.getRealY(16));
        Wall wall42 = new Wall("FSH");
        addObject(wall42,this.getRealX(1),this.getRealY(16));
        Wall wall43 = new Wall("FSH");
        addObject(wall43,this.getRealX(2),this.getRealY(16));
        Wall wall44 = new Wall("FSH");
        addObject(wall44,this.getRealX(3),this.getRealY(16));
        Wall wall45 = new Wall("FSH");
        addObject(wall45,this.getRealX(4),this.getRealY(16));
        Wall wall46 = new Wall("FSH");
        addObject(wall46,this.getRealX(5),this.getRealY(16));
        Wall wall47 = new Wall("FSH");
        addObject(wall47,this.getRealX(6),this.getRealY(16));
        Wall wall48 = new Wall("FSH");
        addObject(wall48,this.getRealX(7),this.getRealY(16));
        Wall wall49 = new Wall("FSH");
        addObject(wall49,this.getRealX(8),this.getRealY(16));
        Wall wall50 = new Wall("FSH");
        addObject(wall50,this.getRealX(9),this.getRealY(16));
        Wall wall51 = new Wall("FSH");
        addObject(wall51,this.getRealX(10),this.getRealY(16));
        Wall wall52 = new Wall("FSH");
        addObject(wall52,this.getRealX(11),this.getRealY(16));
        Wall wall53 = new Wall("FOLEN");
        addObject(wall53,this.getRealX(0),this.getRealY(16));
        Wall wall54 = new Wall("FWV");
        addObject(wall54,this.getRealX(0),this.getRealY(5));
        Wall wall55 = new Wall("FWV");
        addObject(wall55,this.getRealX(0),this.getRealY(6));
        Wall wall56 = new Wall("FWV");
        addObject(wall56,this.getRealX(0),this.getRealY(7));
        Wall wall57 = new Wall("FWV");
        addObject(wall57,this.getRealX(0),this.getRealY(8));
        Wall wall58 = new Wall("FWV");
        addObject(wall58,this.getRealX(0),this.getRealY(9));
        Wall wall59 = new Wall("FWV");
        addObject(wall59,this.getRealX(0),this.getRealY(10));
        Wall wall60 = new Wall("FWV");
        addObject(wall60,this.getRealX(0),this.getRealY(11));
        Wall wall61 = new Wall("FWV");
        addObject(wall61,this.getRealX(0),this.getRealY(12));
        Wall wall62 = new Wall("FWV");
        addObject(wall62,this.getRealX(0),this.getRealY(13));
        Wall wall63 = new Wall("FWV");
        addObject(wall63,this.getRealX(0),this.getRealY(14));
        Wall wall64 = new Wall("FWV");
        addObject(wall64,this.getRealX(0),this.getRealY(15));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC02L10() {
        
        Outline o0 = new Outline();
        addObject(o0,this.getRealX(2),this.getRealY(6));
        Outline o1 = new Outline();
        addObject(o1,this.getRealX(2),this.getRealY(7));
        Outline o2 = new Outline();
        addObject(o2,this.getRealX(2),this.getRealY(8));
        Outline o3 = new Outline();
        addObject(o3,this.getRealX(2),this.getRealY(9));
        Outline o4 = new Outline();
        addObject(o4,this.getRealX(3),this.getRealY(6));
        Outline o5 = new Outline();
        addObject(o5,this.getRealX(3),this.getRealY(9));
        Outline o6 = new Outline();
        addObject(o6,this.getRealX(4),this.getRealY(6));
        Outline o7 = new Outline();
        addObject(o7,this.getRealX(4),this.getRealY(7));
        Outline o8 = new Outline();
        addObject(o8,this.getRealX(4),this.getRealY(8));
        Outline o9 = new Outline();
        addObject(o9,this.getRealX(4),this.getRealY(9));
        Outline o10 = new Outline();
        addObject(o10,this.getRealX(6),this.getRealY(6));
        Outline o11 = new Outline();
        addObject(o11,this.getRealX(7),this.getRealY(6));
        Outline o12 = new Outline();
        addObject(o12,this.getRealX(7),this.getRealY(7));
        Outline o13 = new Outline();
        addObject(o13,this.getRealX(7),this.getRealY(8));
        Outline o14 = new Outline();
        addObject(o14,this.getRealX(7),this.getRealY(9));
        Outline o15 = new Outline();
        addObject(o15,this.getRealX(9),this.getRealY(6));
        Outline o16 = new Outline();
        addObject(o16,this.getRealX(10),this.getRealY(6));
        Outline o17 = new Outline();
        addObject(o17,this.getRealX(10),this.getRealY(7));
        Outline o18 = new Outline();
        addObject(o18,this.getRealX(10),this.getRealY(8));
        Outline o19 = new Outline();
        addObject(o19,this.getRealX(10),this.getRealY(9));
        Outline o20 = new Outline();
        addObject(o20,this.getRealX(12),this.getRealY(6));
        Outline o21 = new Outline();
        addObject(o21,this.getRealX(12),this.getRealY(7));
        Outline o22 = new Outline();
        addObject(o22,this.getRealX(12),this.getRealY(8));
        Outline o23 = new Outline();
        addObject(o23,this.getRealX(12),this.getRealY(9));
        Outline o24 = new Outline();
        addObject(o24,this.getRealX(13),this.getRealY(6));
        Outline o25 = new Outline();
        addObject(o25,this.getRealX(13),this.getRealY(9));
        Outline o26 = new Outline();
        addObject(o26,this.getRealX(14),this.getRealY(6));
        Outline o27 = new Outline();
        addObject(o27,this.getRealX(14),this.getRealY(7));
        Outline o28 = new Outline();
        addObject(o28,this.getRealX(14),this.getRealY(8));
        Outline o29 = new Outline();
        addObject(o29,this.getRealX(14),this.getRealY(9));
        Spieler player30 = new Spieler(this.loadCharacter());
        addObject(player30,this.getRealX(1),this.getRealY(6));
        player30.setRotation(0);
        Spieler[] P = new Spieler[]{player30};
        String[] firstPage = new String[]{"Okay, das ist das letzte Level des zweiten Kapitels.","","Es ist ein wenig aufwendiger, aber dient auch als gute Übung für die","Implementierung von Prozeduren."};
        String wm = "+30 EXP\n\nSehr gut! Das zweite Kapitel ist damit abgeschlossen!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Wall wall31 = new Wall("FOLSE");
        addObject(wall31,this.getRealX(0),this.getRealY(4));
        Wall wall32 = new Wall("FNH");
        addObject(wall32,this.getRealX(1),this.getRealY(4));
        Wall wall33 = new Wall("FNH");
        addObject(wall33,this.getRealX(2),this.getRealY(4));
        Wall wall34 = new Wall("FNH");
        addObject(wall34,this.getRealX(3),this.getRealY(4));
        Wall wall35 = new Wall("FNH");
        addObject(wall35,this.getRealX(4),this.getRealY(4));
        Wall wall36 = new Wall("FNH");
        addObject(wall36,this.getRealX(5),this.getRealY(4));
        Wall wall37 = new Wall("FNH");
        addObject(wall37,this.getRealX(6),this.getRealY(4));
        Wall wall38 = new Wall("FNH");
        addObject(wall38,this.getRealX(7),this.getRealY(4));
        Wall wall39 = new Wall("FNH");
        addObject(wall39,this.getRealX(8),this.getRealY(4));
        Wall wall40 = new Wall("FNH");
        addObject(wall40,this.getRealX(9),this.getRealY(4));
        Wall wall41 = new Wall("FNH");
        addObject(wall41,this.getRealX(10),this.getRealY(4));
        Wall wall42 = new Wall("FNH");
        addObject(wall42,this.getRealX(11),this.getRealY(4));
        Wall wall43 = new Wall("FNH");
        addObject(wall43,this.getRealX(12),this.getRealY(4));
        Wall wall44 = new Wall("FNH");
        addObject(wall44,this.getRealX(13),this.getRealY(4));
        Wall wall45 = new Wall("FNH");
        addObject(wall45,this.getRealX(14),this.getRealY(4));
        Wall wall46 = new Wall("FNH");
        addObject(wall46,this.getRealX(15),this.getRealY(4));
        Wall wall47 = new Wall("FOLWS");
        addObject(wall47,this.getRealX(16),this.getRealY(4));
        Wall wall48 = new Wall("FEV");
        addObject(wall48,this.getRealX(16),this.getRealY(5));
        Wall wall49 = new Wall("FEV");
        addObject(wall49,this.getRealX(16),this.getRealY(6));
        Wall wall50 = new Wall("FEV");
        addObject(wall50,this.getRealX(16),this.getRealY(7));
        Wall wall51 = new Wall("FEV");
        addObject(wall51,this.getRealX(16),this.getRealY(8));
        Wall wall52 = new Wall("FEV");
        addObject(wall52,this.getRealX(16),this.getRealY(9));
        Wall wall53 = new Wall("FEV");
        addObject(wall53,this.getRealX(16),this.getRealY(10));
        Wall wall54 = new Wall("FOLNW");
        addObject(wall54,this.getRealX(16),this.getRealY(11));
        Wall wall55 = new Wall("FSH");
        addObject(wall55,this.getRealX(1),this.getRealY(11));
        Wall wall56 = new Wall("FSH");
        addObject(wall56,this.getRealX(2),this.getRealY(11));
        Wall wall57 = new Wall("FSH");
        addObject(wall57,this.getRealX(3),this.getRealY(11));
        Wall wall58 = new Wall("FSH");
        addObject(wall58,this.getRealX(4),this.getRealY(11));
        Wall wall59 = new Wall("FSH");
        addObject(wall59,this.getRealX(5),this.getRealY(11));
        Wall wall60 = new Wall("FSH");
        addObject(wall60,this.getRealX(6),this.getRealY(11));
        Wall wall61 = new Wall("FSH");
        addObject(wall61,this.getRealX(7),this.getRealY(11));
        Wall wall62 = new Wall("FSH");
        addObject(wall62,this.getRealX(8),this.getRealY(11));
        Wall wall63 = new Wall("FSH");
        addObject(wall63,this.getRealX(9),this.getRealY(11));
        Wall wall64 = new Wall("FSH");
        addObject(wall64,this.getRealX(10),this.getRealY(11));
        Wall wall65 = new Wall("FSH");
        addObject(wall65,this.getRealX(11),this.getRealY(11));
        Wall wall66 = new Wall("FSH");
        addObject(wall66,this.getRealX(12),this.getRealY(11));
        Wall wall67 = new Wall("FSH");
        addObject(wall67,this.getRealX(13),this.getRealY(11));
        Wall wall68 = new Wall("FSH");
        addObject(wall68,this.getRealX(14),this.getRealY(11));
        Wall wall69 = new Wall("FSH");
        addObject(wall69,this.getRealX(15),this.getRealY(11));
        Wall wall70 = new Wall("FOLEN");
        addObject(wall70,this.getRealX(0),this.getRealY(11));
        Wall wall71 = new Wall("FWV");
        addObject(wall71,this.getRealX(0),this.getRealY(5));
        Wall wall72 = new Wall("FWV");
        addObject(wall72,this.getRealX(0),this.getRealY(6));
        Wall wall73 = new Wall("FWV");
        addObject(wall73,this.getRealX(0),this.getRealY(7));
        Wall wall74 = new Wall("FWV");
        addObject(wall74,this.getRealX(0),this.getRealY(8));
        Wall wall75 = new Wall("FWV");
        addObject(wall75,this.getRealX(0),this.getRealY(9));
        Wall wall76 = new Wall("FWV");
        addObject(wall76,this.getRealX(0),this.getRealY(10));
        
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L01() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        addObject(player0,this.getRealX(1),this.getRealY(5));
        player0.setRotation(0);
        Spieler player1 = new Spieler(this.loadCharacter());
        addObject(player1,this.getRealX(4),this.getRealY(5));
        player1.setRotation(0);
        Spieler player2 = new Spieler(this.loadCharacter());
        addObject(player2,this.getRealX(7),this.getRealY(5));
        player2.setRotation(0);
        Wall wall3 = new Wall("FOLSE");
        addObject(wall3,this.getRealX(0),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(1),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(2),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(3),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(4),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(5),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(6),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(7),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(8),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(9),this.getRealY(4));
        Wall wall13 = new Wall("FOLWS");
        addObject(wall13,this.getRealX(10),this.getRealY(4));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(5));
        Wall wall15 = new Wall("FOLNW");
        addObject(wall15,this.getRealX(10),this.getRealY(6));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(1),this.getRealY(6));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(2),this.getRealY(6));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(3),this.getRealY(6));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(4),this.getRealY(6));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(5),this.getRealY(6));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(6),this.getRealY(6));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(7),this.getRealY(6));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(8),this.getRealY(6));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(9),this.getRealY(6));
        Wall wall25 = new Wall("FOLEN");
        addObject(wall25,this.getRealX(0),this.getRealY(6));
        Wall wall26 = new Wall("FWV");
        addObject(wall26,this.getRealX(0),this.getRealY(5));
        Wall wall27 = new Wall("FTS");
        addObject(wall27,this.getRealX(3),this.getRealY(4));
        Wall wall28 = new Wall("FTS");
        addObject(wall28,this.getRealX(6),this.getRealY(4));
        Wall wall29 = new Wall("FTN");
        addObject(wall29,this.getRealX(3),this.getRealY(6));
        Wall wall30 = new Wall("FTN");
        addObject(wall30,this.getRealX(6),this.getRealY(6));
        Wall wall31 = new Wall("V");
        addObject(wall31,this.getRealX(3),this.getRealY(5));
        Wall wall32 = new Wall("V");
        addObject(wall32,this.getRealX(6),this.getRealY(5));
        Checkpoint c31 = new Checkpoint(0);
        addObject(c31,this.getRealX(2),this.getRealY(5));
        Checkpoint c32 = new Checkpoint(0);
        addObject(c32,this.getRealX(8),this.getRealY(5));
        String[] firstPage = new String[]{"In diesem Kapitel führen wir Multi-Levels","ein.","","Das sind Levels, die mit mehreren Räumen","ausgestattet sind."};
        String[] secondPage = new String[]{"Jeder Raum repräsentiert einen Testfall","und ist mit einer Spielfigur ausgestattet.","","Ziel ist es, dass man das Problem jedes Raumes","löst."};
        String[] thirdPage = new String[]{"Der Haken: Man darf nur ein Programm","schreiben.","Dieses wird dann nacheinander auf alle","Spielfiguren angewendet."};
        String[] fourthPage = new String[]{"Probiere es hier mal mit dem Lösen des","ersten Raumes."};
        String wm = "+10 EXP\n\nSehr gut!\nDurch Multi-Levels können wir verschiedene\nTestfälle auf einmal testen.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage},new Spieler[]{player0,player1,player2},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }

    public void prepareC03LXX() {
        //Greenfoot.setWorld(new CampaignLevel(3,1,12,9,50));
        Spieler player0 = new Spieler(this.loadCharacter());
        
        addObject(player0,this.getRealX(2),this.getRealY(6));
        player0.setRotation(0);
        
        Spieler player1 = new Spieler(this.loadCharacter());
        addObject(player1,this.getRealX(2),this.getRealY(10));
        player1.setRotation(0);
        
        Spieler player2 = new Spieler(this.loadCharacter());
        addObject(player2,this.getRealX(7),this.getRealY(6));
        player2.setRotation(0);
        
        Spieler player3 = new Spieler(this.loadCharacter());
        addObject(player3,this.getRealX(7),this.getRealY(10));
        player3.setRotation(0);
        Spieler[] P = new Spieler[]{player0,player1,player2,player3};
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},P,wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        Checkpoint c4 = new Checkpoint(0);
        addObject(c4,this.getRealX(3),this.getRealY(6));
        Checkpoint c5 = new Checkpoint(0);
        addObject(c5,this.getRealX(8),this.getRealY(6));
        Checkpoint c6 = new Checkpoint(0);
        addObject(c6,this.getRealX(9),this.getRealY(10));
        Wall wall7 = new Wall("FOLSE");
        addObject(wall7,this.getRealX(0),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(1),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(2),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(3),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(4),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(5),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(6),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(7),this.getRealY(4));
        Wall wall15 = new Wall("FNH");
        addObject(wall15,this.getRealX(8),this.getRealY(4));
        Wall wall16 = new Wall("FNH");
        addObject(wall16,this.getRealX(9),this.getRealY(4));
        Wall wall17 = new Wall("FNH");
        addObject(wall17,this.getRealX(10),this.getRealY(4));
        Wall wall18 = new Wall("FOLWS");
        addObject(wall18,this.getRealX(11),this.getRealY(4));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(11),this.getRealY(5));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(11),this.getRealY(6));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(11),this.getRealY(7));
        Wall wall22 = new Wall("FEV");
        addObject(wall22,this.getRealX(11),this.getRealY(8));
        Wall wall23 = new Wall("FEV");
        addObject(wall23,this.getRealX(11),this.getRealY(9));
        Wall wall24 = new Wall("FEV");
        addObject(wall24,this.getRealX(11),this.getRealY(10));
        Wall wall25 = new Wall("FEV");
        addObject(wall25,this.getRealX(11),this.getRealY(11));
        Wall wall26 = new Wall("FOLNW");
        addObject(wall26,this.getRealX(11),this.getRealY(12));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(1),this.getRealY(12));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(2),this.getRealY(12));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(3),this.getRealY(12));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(4),this.getRealY(12));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(5),this.getRealY(12));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(6),this.getRealY(12));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(7),this.getRealY(12));
        Wall wall34 = new Wall("FSH");
        addObject(wall34,this.getRealX(8),this.getRealY(12));
        Wall wall35 = new Wall("FSH");
        addObject(wall35,this.getRealX(9),this.getRealY(12));
        Wall wall36 = new Wall("FSH");
        addObject(wall36,this.getRealX(10),this.getRealY(12));
        Wall wall37 = new Wall("FOLEN");
        addObject(wall37,this.getRealX(0),this.getRealY(12));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(5));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(6));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(7));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(8));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(9));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(10));
        Wall wall44 = new Wall("FWV");
        addObject(wall44,this.getRealX(0),this.getRealY(11));

                Wall wall56 = new Wall("LSE");
        addObject(wall56,this.getRealX(1),this.getRealY(5));
        Wall wall57 = new Wall("H");
        addObject(wall57,this.getRealX(2),this.getRealY(5));
        Wall wall58 = new Wall("H");
        addObject(wall58,this.getRealX(3),this.getRealY(5));
        Wall wall59 = new Wall("LWS");
        addObject(wall59,this.getRealX(4),this.getRealY(5));
        Wall wall60 = new Wall("V");
        addObject(wall60,this.getRealX(4),this.getRealY(6));
        Wall wall61 = new Wall("LNW");
        addObject(wall61,this.getRealX(4),this.getRealY(7));
        Wall wall62 = new Wall("H");
        addObject(wall62,this.getRealX(2),this.getRealY(7));
        Wall wall63 = new Wall("H");
        addObject(wall63,this.getRealX(3),this.getRealY(7));
        Wall wall64 = new Wall("LEN");
        addObject(wall64,this.getRealX(1),this.getRealY(7));
        Wall wall65 = new Wall("V");
        addObject(wall65,this.getRealX(1),this.getRealY(6));
        Wall wall66 = new Wall("LSE");
        addObject(wall66,this.getRealX(1),this.getRealY(9));
        Wall wall67 = new Wall("H");
        addObject(wall67,this.getRealX(2),this.getRealY(9));
        Wall wall68 = new Wall("H");
        addObject(wall68,this.getRealX(3),this.getRealY(9));
        Wall wall69 = new Wall("LWS");
        addObject(wall69,this.getRealX(4),this.getRealY(9));
        Wall wall70 = new Wall("V");
        addObject(wall70,this.getRealX(4),this.getRealY(10));
        Wall wall71 = new Wall("LNW");
        addObject(wall71,this.getRealX(4),this.getRealY(11));
        Wall wall72 = new Wall("H");
        addObject(wall72,this.getRealX(2),this.getRealY(11));
        Wall wall73 = new Wall("H");
        addObject(wall73,this.getRealX(3),this.getRealY(11));
        Wall wall74 = new Wall("LEN");
        addObject(wall74,this.getRealX(1),this.getRealY(11));
        Wall wall75 = new Wall("V");
        addObject(wall75,this.getRealX(1),this.getRealY(10));
        Wall wall76 = new Wall("LSE");
        addObject(wall76,this.getRealX(6),this.getRealY(5));
        Wall wall77 = new Wall("H");
        addObject(wall77,this.getRealX(7),this.getRealY(5));
        Wall wall78 = new Wall("H");
        addObject(wall78,this.getRealX(8),this.getRealY(5));
        Wall wall79 = new Wall("H");
        addObject(wall79,this.getRealX(9),this.getRealY(5));
        Wall wall80 = new Wall("LWS");
        addObject(wall80,this.getRealX(10),this.getRealY(5));
        Wall wall81 = new Wall("V");
        addObject(wall81,this.getRealX(10),this.getRealY(6));
        Wall wall82 = new Wall("LNW");
        addObject(wall82,this.getRealX(10),this.getRealY(7));
        Wall wall83 = new Wall("H");
        addObject(wall83,this.getRealX(7),this.getRealY(7));
        Wall wall84 = new Wall("H");
        addObject(wall84,this.getRealX(8),this.getRealY(7));
        Wall wall85 = new Wall("H");
        addObject(wall85,this.getRealX(9),this.getRealY(7));
        Wall wall86 = new Wall("LEN");
        addObject(wall86,this.getRealX(6),this.getRealY(7));
        Wall wall87 = new Wall("V");
        addObject(wall87,this.getRealX(6),this.getRealY(6));
        Wall wall88 = new Wall("LSE");
        addObject(wall88,this.getRealX(6),this.getRealY(9));
        Wall wall89 = new Wall("H");
        addObject(wall89,this.getRealX(7),this.getRealY(9));
        Wall wall90 = new Wall("H");
        addObject(wall90,this.getRealX(8),this.getRealY(9));
        Wall wall91 = new Wall("H");
        addObject(wall91,this.getRealX(9),this.getRealY(9));
        Wall wall92 = new Wall("LWS");
        addObject(wall92,this.getRealX(10),this.getRealY(9));
        Wall wall93 = new Wall("V");
        addObject(wall93,this.getRealX(10),this.getRealY(10));
        Wall wall94 = new Wall("LNW");
        addObject(wall94,this.getRealX(10),this.getRealY(11));
        Wall wall95 = new Wall("H");
        addObject(wall95,this.getRealX(7),this.getRealY(11));
        Wall wall96 = new Wall("H");
        addObject(wall96,this.getRealX(8),this.getRealY(11));
        Wall wall97 = new Wall("H");
        addObject(wall97,this.getRealX(9),this.getRealY(11));
        Wall wall98 = new Wall("LEN");
        addObject(wall98,this.getRealX(6),this.getRealY(11));
        Wall wall99 = new Wall("V");
        addObject(wall99,this.getRealX(6),this.getRealY(10));
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L02() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        addObject(player0,this.getRealX(2),this.getRealY(5));
        player0.setRotation(0);
        Spieler player1 = new Spieler(this.loadCharacter());
        addObject(player1,this.getRealX(2),this.getRealY(7));
        player1.setRotation(0);
        Spieler player2 = new Spieler(this.loadCharacter());
        addObject(player2,this.getRealX(6),this.getRealY(5));
        player2.setRotation(180);
        Spieler player3 = new Spieler(this.loadCharacter());
        addObject(player3,this.getRealX(7),this.getRealY(7));
        player3.setRotation(180);
        Checkpoint c4 = new Checkpoint(0);
        addObject(c4,this.getRealX(3),this.getRealY(5));
        Checkpoint c5 = new Checkpoint(0);
        addObject(c5,this.getRealX(6),this.getRealY(7));
        Wall wall6 = new Wall("FOLSE");
        addObject(wall6,this.getRealX(0),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(1),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(2),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(3),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(4),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(5),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(6),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(7),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(8),this.getRealY(4));
        Wall wall15 = new Wall("FOLWS");
        addObject(wall15,this.getRealX(9),this.getRealY(4));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(9),this.getRealY(5));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(9),this.getRealY(6));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(9),this.getRealY(7));
        Wall wall19 = new Wall("FOLNW");
        addObject(wall19,this.getRealX(9),this.getRealY(8));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(1),this.getRealY(8));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(2),this.getRealY(8));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(3),this.getRealY(8));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(4),this.getRealY(8));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(5),this.getRealY(8));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(6),this.getRealY(8));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(7),this.getRealY(8));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(8),this.getRealY(8));
        Wall wall28 = new Wall("FOLEN");
        addObject(wall28,this.getRealX(0),this.getRealY(8));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(5));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(6));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(7));
        Wall wall32 = new Wall("FTS");
        addObject(wall32,this.getRealX(5),this.getRealY(4));
        Wall wall33 = new Wall("FTN");
        addObject(wall33,this.getRealX(5),this.getRealY(8));
        Wall wall34 = new Wall("FTE");
        addObject(wall34,this.getRealX(0),this.getRealY(6));
        Wall wall35 = new Wall("FTW");
        addObject(wall35,this.getRealX(9),this.getRealY(6));
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(1),this.getRealY(6));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(2),this.getRealY(6));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(3),this.getRealY(6));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(4),this.getRealY(6));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(5),this.getRealY(6));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(6),this.getRealY(6));
        Wall wall42 = new Wall("H");
        addObject(wall42,this.getRealX(7),this.getRealY(6));
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(8),this.getRealY(6));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(5),this.getRealY(5));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(5),this.getRealY(6));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(5),this.getRealY(7));
        String[] firstPage = new String[]{"Nun erlernen wir ein weiteres","Konzept der Programmierung: Abfragen.","","Diese dienen dazu, dein Programm","dynamisch zu gestalten."};
        String[] secondPage = new String[]{"Das heißt, wir ermöglichen unserem","Programm, auf diverse Situationen","reagieren zu können."};
        String[] thirdPage = new String[]{"In diesem Level möchten wir","vermeiden, dass die obere rechte Figur","gegen die Wand läuft.","Unsere Figuren sollen nur dann laufen,","wenn sie einen Checkpoint sehen."};
        String[] fourthPage = new String[]{"Abfragen werden umgangssprachlich","folgendermaßen formuliert:","","WENN eine Situation gilt,","DANN soll dies getan werden"};
        String[] fifthPage = new String[]{"In Java:","if (Bedingung trifft zu) {","    //Dann soll dies geschehen.","}"};
        String[] sixthPage = new String[]{"Bedingungen werden in Java wie","Befehle geschrieben. Die erste Bedingung","lautet: siehtCheckpoint()"};
        String[] seventhPage = new String[]{"Wenn Bedingungen in einer Abfrage","stehen, dann lässt man das abschließende","Semikolon weg."};
        String[] eigthPage = new String[]{"Probiere es mal mit:","if (siehtCheckpoint()) {","    schritt();","}"};
        String wm = "+10 EXP\n\nWie du siehst, haben sich nur die beiden\nFiguren bewegt, die auch wirklich einen\nCheckpoint gesehen haben.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage,sixthPage,seventhPage,eigthPage},new Spieler[]{player0,player1,player2,player3},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L03() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        addObject(player0,this.getRealX(1),this.getRealY(5));
        player0.setRotation(0);
        Spieler player1 = new Spieler(this.loadCharacter());
        addObject(player1,this.getRealX(1),this.getRealY(7));
        player1.setRotation(0);
        Spieler player2 = new Spieler(this.loadCharacter());
        addObject(player2,this.getRealX(9),this.getRealY(5));
        player2.setRotation(180);
        Spieler player3 = new Spieler(this.loadCharacter());
        addObject(player3,this.getRealX(9),this.getRealY(7));
        player3.setRotation(180);
        Item i4 = new Item();
        addObject(i4,this.getRealX(3),this.getRealY(5));
        Item i5 = new Item();
        addObject(i5,this.getRealX(2),this.getRealY(7));
        Item i6 = new Item();
        addObject(i6,this.getRealX(4),this.getRealY(7));
        Item i7 = new Item();
        addObject(i7,this.getRealX(7),this.getRealY(5));
        Item i8 = new Item();
        addObject(i8,this.getRealX(8),this.getRealY(5));
        Item i9 = new Item();
        addObject(i9,this.getRealX(6),this.getRealY(7));
        Item i10 = new Item();
        addObject(i10,this.getRealX(7),this.getRealY(7));
        Item i11 = new Item();
        addObject(i11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FOLSE");
        addObject(wall12,this.getRealX(0),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(1),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(2),this.getRealY(4));
        Wall wall15 = new Wall("FNH");
        addObject(wall15,this.getRealX(3),this.getRealY(4));
        Wall wall16 = new Wall("FNH");
        addObject(wall16,this.getRealX(4),this.getRealY(4));
        Wall wall17 = new Wall("FNH");
        addObject(wall17,this.getRealX(5),this.getRealY(4));
        Wall wall18 = new Wall("FNH");
        addObject(wall18,this.getRealX(6),this.getRealY(4));
        Wall wall19 = new Wall("FNH");
        addObject(wall19,this.getRealX(7),this.getRealY(4));
        Wall wall20 = new Wall("FNH");
        addObject(wall20,this.getRealX(8),this.getRealY(4));
        Wall wall21 = new Wall("FNH");
        addObject(wall21,this.getRealX(9),this.getRealY(4));
        Wall wall22 = new Wall("FOLWS");
        addObject(wall22,this.getRealX(10),this.getRealY(4));
        Wall wall23 = new Wall("FEV");
        addObject(wall23,this.getRealX(10),this.getRealY(5));
        Wall wall24 = new Wall("FEV");
        addObject(wall24,this.getRealX(10),this.getRealY(6));
        Wall wall25 = new Wall("FEV");
        addObject(wall25,this.getRealX(10),this.getRealY(7));
        Wall wall26 = new Wall("FOLNW");
        addObject(wall26,this.getRealX(10),this.getRealY(8));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(1),this.getRealY(8));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(2),this.getRealY(8));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(3),this.getRealY(8));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(4),this.getRealY(8));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(5),this.getRealY(8));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(6),this.getRealY(8));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(7),this.getRealY(8));
        Wall wall34 = new Wall("FSH");
        addObject(wall34,this.getRealX(8),this.getRealY(8));
        Wall wall35 = new Wall("FSH");
        addObject(wall35,this.getRealX(9),this.getRealY(8));
        Wall wall36 = new Wall("FOLEN");
        addObject(wall36,this.getRealX(0),this.getRealY(8));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(5));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(6));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(7));
        Wall wall40 = new Wall("FTN");
        addObject(wall40,this.getRealX(5),this.getRealY(8));
        Wall wall41 = new Wall("FTS");
        addObject(wall41,this.getRealX(5),this.getRealY(4));
        Wall wall42 = new Wall("FTE");
        addObject(wall42,this.getRealX(0),this.getRealY(6));
        Wall wall43 = new Wall("FTW");
        addObject(wall43,this.getRealX(10),this.getRealY(6));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(1),this.getRealY(6));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(2),this.getRealY(6));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(3),this.getRealY(6));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(4),this.getRealY(6));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(5),this.getRealY(6));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(6),this.getRealY(6));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(7),this.getRealY(6));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(8),this.getRealY(6));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(9),this.getRealY(6));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(5),this.getRealY(5));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(5),this.getRealY(6));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(5),this.getRealY(7));
        String[] firstPage = new String[]{"Wenn unsere Figur versucht, ein Token","aufzuheben, wenn sich keines unter ihr befindet,","so gibt sie eine Fehlermeldung zurück."};
        String[] secondPage = new String[]{"Deshalb führen wir eine weitere","Bedingung hinzu: istAufToken()","","Dadurch lassen wir die Figur zuerst prüfen,","ob sich ein Token unter ihr befindet."};
        String wm = "+10 EXP\n\nGut! Man könnte eine Prozedur zum\n'sicheren Aufheben' schreiben, damit keinerlei\nFehlermeldung aufkommen kann.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player0,player1,player2,player3},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }

    public void prepareC03L04() {
        
        Spieler player0 = new Spieler(this.loadCharacter());
        addObject(player0,this.getRealX(1),this.getRealY(5));
        player0.setRotation(90);
        Spieler player1 = new Spieler(this.loadCharacter());
        addObject(player1,this.getRealX(3),this.getRealY(5));
        player1.setRotation(180);
        Spieler player2 = new Spieler(this.loadCharacter());
        addObject(player2,this.getRealX(5),this.getRealY(5));
        player2.setRotation(0);
        Spieler player3 = new Spieler(this.loadCharacter());
        addObject(player3,this.getRealX(7),this.getRealY(5));
        player3.setRotation(90);
        Spieler player4 = new Spieler(this.loadCharacter());
        addObject(player4,this.getRealX(9),this.getRealY(5));
        player4.setRotation(90);
        Wall wall5 = new Wall("FOLSE");
        addObject(wall5,this.getRealX(0),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(1),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(2),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(3),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(4),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(5),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(6),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(7),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(8),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(9),this.getRealY(4));
        Wall wall15 = new Wall("FOLWS");
        addObject(wall15,this.getRealX(10),this.getRealY(4));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(10),this.getRealY(5));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(10),this.getRealY(6));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(10),this.getRealY(7));
        Wall wall19 = new Wall("FOLNW");
        addObject(wall19,this.getRealX(10),this.getRealY(8));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(1),this.getRealY(8));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(2),this.getRealY(8));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(3),this.getRealY(8));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(4),this.getRealY(8));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(5),this.getRealY(8));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(6),this.getRealY(8));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(7),this.getRealY(8));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(8),this.getRealY(8));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(9),this.getRealY(8));
        Wall wall29 = new Wall("FOLEN");
        addObject(wall29,this.getRealX(0),this.getRealY(8));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(5));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(6));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(7));
        Wall wall33 = new Wall("FTS");
        addObject(wall33,this.getRealX(2),this.getRealY(4));
        Wall wall34 = new Wall("FTS");
        addObject(wall34,this.getRealX(4),this.getRealY(4));
        Wall wall35 = new Wall("FTS");
        addObject(wall35,this.getRealX(6),this.getRealY(4));
        Wall wall36 = new Wall("FTS");
        addObject(wall36,this.getRealX(8),this.getRealY(4));
        Wall wall37 = new Wall("FTN");
        addObject(wall37,this.getRealX(2),this.getRealY(8));
        Wall wall38 = new Wall("FTN");
        addObject(wall38,this.getRealX(4),this.getRealY(8));
        Wall wall39 = new Wall("FTN");
        addObject(wall39,this.getRealX(6),this.getRealY(8));
        Wall wall40 = new Wall("FTN");
        addObject(wall40,this.getRealX(8),this.getRealY(8));
        Wall wall41 = new Wall("V");
        addObject(wall41,this.getRealX(2),this.getRealY(5));
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(2),this.getRealY(6));
        Wall wall43 = new Wall("V");
        addObject(wall43,this.getRealX(2),this.getRealY(7));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(4),this.getRealY(5));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(4),this.getRealY(6));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(4),this.getRealY(7));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(6),this.getRealY(5));
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(6),this.getRealY(6));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(6),this.getRealY(7));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(8),this.getRealY(5));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(8),this.getRealY(6));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(8),this.getRealY(7));
        Target t53 = new Target();
        addObject(t53,this.getRealX(1),this.getRealY(7));
        Target t54 = new Target();
        addObject(t54,this.getRealX(7),this.getRealY(7));
        Target t55 = new Target();
        addObject(t55,this.getRealX(9),this.getRealY(7));
        String[] firstPage = new String[]{"Das Problem in diesem Level ist:","Unsere Figuren könnten das Level durch den","schießen-Befehl zwar theoretisch lösen, aber","die zweite und dritte Figur würden die anderen","Figuren treffen."};
        String[] secondPage = new String[]{"Dadurch würden sie außer Gefecht","gesetzt werden.","An sich kein Problem, allerdings kann die vierte","Figur danach die Zielscheibe nicht mehr treffen."};
        String[] thirdPage = new String[]{"Deshalb möchten wir eine weitere","Bedingung einführen: istZielscheibeInReichweite()","Diese Bedingung ist wahr, wenn eine","Zielscheibe genau in Trefferreichweite ist, sich","also genau zwei Felder vor der Figur befindet."};
        String wm = "+10 EXP\n\nWenn nur die zweite Figur die erste getroffen\nhätte, wäre dies kein Problem gewesen, da diese\ndie Zielscheibe bereits vorher getroffen hätte.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},new Spieler[]{player0,player1,player2,player3,player4},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L05() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FTS");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FTS");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FOLNW");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(1),this.getRealY(8));
        Wall wall14 = new Wall("FTN");
        addObject(wall14,this.getRealX(2),this.getRealY(8));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(3),this.getRealY(8));
        Wall wall16 = new Wall("FTN");
        addObject(wall16,this.getRealX(4),this.getRealY(8));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(5),this.getRealY(8));
        Wall wall18 = new Wall("FTN");
        addObject(wall18,this.getRealX(6),this.getRealY(8));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(7),this.getRealY(8));
        Wall wall20 = new Wall("FOLEN");
        addObject(wall20,this.getRealX(0),this.getRealY(8));
        Wall wall21 = new Wall("FWV");
        addObject(wall21,this.getRealX(0),this.getRealY(5));
        Wall wall22 = new Wall("FWV");
        addObject(wall22,this.getRealX(0),this.getRealY(6));
        Wall wall23 = new Wall("FWV");
        addObject(wall23,this.getRealX(0),this.getRealY(7));
        Checkpoint c24 = new Checkpoint(0);
        addObject(c24,this.getRealX(1),this.getRealY(7));
        Checkpoint c25 = new Checkpoint(0);
        addObject(c25,this.getRealX(7),this.getRealY(6));
        Target t26 = new Target();
        addObject(t26,this.getRealX(3),this.getRealY(5));
        Target t27 = new Target();
        addObject(t27,this.getRealX(5),this.getRealY(7));
        Spieler player28 = new Spieler(this.loadCharacter());
        addObject(player28,this.getRealX(1),this.getRealY(6));
        player28.setRotation(90);
        Spieler player29 = new Spieler(this.loadCharacter());
        addObject(player29,this.getRealX(3),this.getRealY(7));
        player29.setRotation(270);
        Spieler player30 = new Spieler(this.loadCharacter());
        addObject(player30,this.getRealX(5),this.getRealY(5));
        player30.setRotation(90);
        Spieler player31 = new Spieler(this.loadCharacter());
        addObject(player31,this.getRealX(7),this.getRealY(7));
        player31.setRotation(270);
        Wall wall32 = new Wall("V");
        addObject(wall32,this.getRealX(2),this.getRealY(5));
        Wall wall33 = new Wall("V");
        addObject(wall33,this.getRealX(2),this.getRealY(6));
        Wall wall34 = new Wall("V");
        addObject(wall34,this.getRealX(2),this.getRealY(7));
        Wall wall35 = new Wall("V");
        addObject(wall35,this.getRealX(4),this.getRealY(5));
        Wall wall36 = new Wall("V");
        addObject(wall36,this.getRealX(4),this.getRealY(6));
        Wall wall37 = new Wall("V");
        addObject(wall37,this.getRealX(4),this.getRealY(7));
        Wall wall38 = new Wall("V");
        addObject(wall38,this.getRealX(6),this.getRealY(5));
        Wall wall39 = new Wall("V");
        addObject(wall39,this.getRealX(6),this.getRealY(6));
        Wall wall40 = new Wall("V");
        addObject(wall40,this.getRealX(6),this.getRealY(7));
        String[] firstPage = new String[]{"Für Abfragen existiert in Java","noch eine Erweiterung."};
        String[] secondPage = new String[]{"Statt dass das Programm nur","auf einen Fall reagiert, soll es auch noch","auf den Gegenfall reagieren."};
        String[] thirdPage = new String[]{"Umgangssprachlich formuliert:","","WENN eine Situation gilt,","DANN soll dies getan werden,","SONST soll dies getan gewerden"};
        String[] fourthPage = new String[]{"if (Bedingung trifft zu) {","    //Dann soll dies geschehen.","} else {","    //Sonst soll dies geschehen","}"};
        String[] fifthPage = new String[]{"Versuche folgende Aufgabe mit","einer erweiterten Abfrage zu lösen."};
        String[] sixthPage = new String[]{"Falls sich ein Checkpoint vor","der Spielfigur befindet, soll dieser","erreicht werden, sonst soll geschossen","werden."};
        String wm = "+10 EXP\n\nGroßartig!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage,sixthPage},new Spieler[]{player28,player29,player30,player31},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L06() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FTS");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FTS");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FTS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FOLWS");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(10),this.getRealY(5));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(6));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(7));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(8));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(10),this.getRealY(9));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(10),this.getRealY(10));
        Wall wall17 = new Wall("FOLNW");
        addObject(wall17,this.getRealX(10),this.getRealY(11));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(1),this.getRealY(11));
        Wall wall19 = new Wall("FTN");
        addObject(wall19,this.getRealX(2),this.getRealY(11));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(3),this.getRealY(11));
        Wall wall21 = new Wall("FTN");
        addObject(wall21,this.getRealX(4),this.getRealY(11));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(5),this.getRealY(11));
        Wall wall23 = new Wall("FTN");
        addObject(wall23,this.getRealX(6),this.getRealY(11));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(7),this.getRealY(11));
        Wall wall25 = new Wall("FTN");
        addObject(wall25,this.getRealX(8),this.getRealY(11));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(9),this.getRealY(11));
        Wall wall27 = new Wall("FOLEN");
        addObject(wall27,this.getRealX(0),this.getRealY(11));
        Wall wall28 = new Wall("FWV");
        addObject(wall28,this.getRealX(0),this.getRealY(5));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(6));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(7));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(8));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(9));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(10));
        Outline o34 = new Outline();
        addObject(o34,this.getRealX(1),this.getRealY(5));
        Outline o35 = new Outline();
        addObject(o35,this.getRealX(1),this.getRealY(9));
        Outline o36 = new Outline();
        addObject(o36,this.getRealX(3),this.getRealY(6));
        Outline o37 = new Outline();
        addObject(o37,this.getRealX(3),this.getRealY(8));
        Outline o38 = new Outline();
        addObject(o38,this.getRealX(5),this.getRealY(7));
        Outline o39 = new Outline();
        addObject(o39,this.getRealX(7),this.getRealY(6));
        Outline o40 = new Outline();
        addObject(o40,this.getRealX(7),this.getRealY(8));
        Outline o41 = new Outline();
        addObject(o41,this.getRealX(9),this.getRealY(5));
        Outline o42 = new Outline();
        addObject(o42,this.getRealX(9),this.getRealY(9));
        Spieler player43 = new Spieler(this.loadCharacter());
        addObject(player43,this.getRealX(1),this.getRealY(10));
        player43.setRotation(270);
        player43.setOutlineAsOnlyGoal();
        Spieler player44 = new Spieler(this.loadCharacter());
        addObject(player44,this.getRealX(3),this.getRealY(10));
        player44.setRotation(270);
        player44.setOutlineAsOnlyGoal();
        Spieler player45 = new Spieler(this.loadCharacter());
        addObject(player45,this.getRealX(5),this.getRealY(10));
        player45.setRotation(270);
        player45.setOutlineAsOnlyGoal();
        Spieler player46 = new Spieler(this.loadCharacter());
        addObject(player46,this.getRealX(7),this.getRealY(10));
        player46.setRotation(270);
        player46.setOutlineAsOnlyGoal();
        Spieler player47 = new Spieler(this.loadCharacter());
        addObject(player47,this.getRealX(9),this.getRealY(10));
        player47.setRotation(270);
        player47.setOutlineAsOnlyGoal();
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(2),this.getRealY(5));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(2),this.getRealY(6));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(2),this.getRealY(7));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(2),this.getRealY(8));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(2),this.getRealY(9));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(2),this.getRealY(10));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(4),this.getRealY(5));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(4),this.getRealY(6));
        Wall wall56 = new Wall("V");
        addObject(wall56,this.getRealX(4),this.getRealY(7));
        Wall wall57 = new Wall("V");
        addObject(wall57,this.getRealX(4),this.getRealY(8));
        Wall wall58 = new Wall("V");
        addObject(wall58,this.getRealX(4),this.getRealY(9));
        Wall wall59 = new Wall("V");
        addObject(wall59,this.getRealX(4),this.getRealY(10));
        Wall wall60 = new Wall("V");
        addObject(wall60,this.getRealX(6),this.getRealY(5));
        Wall wall61 = new Wall("V");
        addObject(wall61,this.getRealX(6),this.getRealY(6));
        Wall wall62 = new Wall("V");
        addObject(wall62,this.getRealX(6),this.getRealY(7));
        Wall wall63 = new Wall("V");
        addObject(wall63,this.getRealX(6),this.getRealY(8));
        Wall wall64 = new Wall("V");
        addObject(wall64,this.getRealX(6),this.getRealY(9));
        Wall wall65 = new Wall("V");
        addObject(wall65,this.getRealX(6),this.getRealY(10));
        Wall wall66 = new Wall("V");
        addObject(wall66,this.getRealX(8),this.getRealY(5));
        Wall wall67 = new Wall("V");
        addObject(wall67,this.getRealX(8),this.getRealY(6));
        Wall wall68 = new Wall("V");
        addObject(wall68,this.getRealX(8),this.getRealY(7));
        Wall wall69 = new Wall("V");
        addObject(wall69,this.getRealX(8),this.getRealY(8));
        Wall wall70 = new Wall("V");
        addObject(wall70,this.getRealX(8),this.getRealY(9));
        Wall wall71 = new Wall("V");
        addObject(wall71,this.getRealX(8),this.getRealY(10));
        String[] firstPage = new String[]{"Die nächste Bedingung hat etwas mit","Markierungen zutun.","","istAufMarkierung() prüft, ob die Figur auf einer","Markierung steht."};
        String[] secondPage = new String[]{"Dieses Level lässt zur Übung explizit nicht","zu, dass nicht-markierte Felder gefärbt werden."};
        String wm = "+10 EXP\n\nDie Bedingung reagiert auch auf gefärbte\nMarkierungen.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player43,player44,player45,player46,player47},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L07() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FTW");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FOLNW");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(1),this.getRealY(8));
        Wall wall14 = new Wall("FTN");
        addObject(wall14,this.getRealX(2),this.getRealY(8));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(3),this.getRealY(8));
        Wall wall16 = new Wall("FTN");
        addObject(wall16,this.getRealX(4),this.getRealY(8));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(5),this.getRealY(8));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(6),this.getRealY(8));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(7),this.getRealY(8));
        Wall wall20 = new Wall("FOLEN");
        addObject(wall20,this.getRealX(0),this.getRealY(8));
        Wall wall21 = new Wall("FWV");
        addObject(wall21,this.getRealX(0),this.getRealY(5));
        Wall wall22 = new Wall("FTE");
        addObject(wall22,this.getRealX(0),this.getRealY(6));
        Wall wall23 = new Wall("FWV");
        addObject(wall23,this.getRealX(0),this.getRealY(7));
        Checkpoint c24 = new Checkpoint(0);
        addObject(c24,this.getRealX(2),this.getRealY(5));
        Checkpoint c25 = new Checkpoint(0);
        addObject(c25,this.getRealX(7),this.getRealY(7));
        Target t26 = new Target();
        addObject(t26,this.getRealX(7),this.getRealY(5));
        Target t27 = new Target();
        addObject(t27,this.getRealX(3),this.getRealY(7));
        Wall wall28 = new Wall("H");
        addObject(wall28,this.getRealX(1),this.getRealY(6));
        Wall wall29 = new Wall("TS");
        addObject(wall29,this.getRealX(2),this.getRealY(6));
        Wall wall30 = new Wall("H");
        addObject(wall30,this.getRealX(3),this.getRealY(6));
        Wall wall31 = new Wall("H");
        addObject(wall31,this.getRealX(4),this.getRealY(6));
        Wall wall32 = new Wall("H");
        addObject(wall32,this.getRealX(5),this.getRealY(6));
        Wall wall33 = new Wall("H");
        addObject(wall33,this.getRealX(6),this.getRealY(6));
        Wall wall34 = new Wall("H");
        addObject(wall34,this.getRealX(7),this.getRealY(6));
        Wall wall35 = new Wall("V");
        addObject(wall35,this.getRealX(4),this.getRealY(5));
        Wall wall36 = new Wall("V");
        addObject(wall36,this.getRealX(4),this.getRealY(6));
        Wall wall37 = new Wall("V");
        addObject(wall37,this.getRealX(4),this.getRealY(7));
        Wall wall38 = new Wall("V");
        addObject(wall38,this.getRealX(2),this.getRealY(7));
        Spieler player46 = new Spieler(this.loadCharacter());
        addObject(player46,this.getRealX(1),this.getRealY(5));
        player46.setRotation(0);
        Spieler player47 = new Spieler(this.loadCharacter());
        addObject(player47,this.getRealX(1),this.getRealY(7));
        player47.setRotation(0);
         Spieler player48 = new Spieler(this.loadCharacter());
        addObject(player48,this.getRealX(5),this.getRealY(5));
        player48.setRotation(0);
        Spieler player49 = new Spieler(this.loadCharacter());
        addObject(player49,this.getRealX(6),this.getRealY(7));
        player49.setRotation(0);
        
        
        
        String[] firstPage = new String[]{"Solche erweiterten Abfragen","spielen häufig eine Rolle, wenn","verschiedene Ziele in einem Level","vorhanden sind."};
        String[] secondPage = new String[]{"Man versucht dazu, das eine","Ziel mit dem DANN-Fall und das","zweite Ziel mit dem SONST-Fall","abzudecken."};
        String wm = "+10 EXP.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player46,player47,player48,player49},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }

    
    public void prepareC03L08() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FTS");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FOLNW");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(1),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(2),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(3),this.getRealY(10));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(4),this.getRealY(10));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(5),this.getRealY(10));
        Wall wall24 = new Wall("FTN");
        addObject(wall24,this.getRealX(6),this.getRealY(10));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(7),this.getRealY(10));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(8),this.getRealY(10));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(9),this.getRealY(10));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(10),this.getRealY(10));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(11),this.getRealY(10));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(10));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Target t36 = new Target();
        addObject(t36,this.getRealX(3),this.getRealY(5));
        Target t37 = new Target();
        addObject(t37,this.getRealX(5),this.getRealY(7));
        Target t38 = new Target();
        addObject(t38,this.getRealX(3),this.getRealY(9));
        Target t39 = new Target();
        addObject(t39,this.getRealX(7),this.getRealY(7));
        Target t40 = new Target();
        addObject(t40,this.getRealX(11),this.getRealY(7));
        Wall wall41 = new Wall("V");
        addObject(wall41,this.getRealX(6),this.getRealY(5));
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(6),this.getRealY(6));
        Wall wall43 = new Wall("V");
        addObject(wall43,this.getRealX(6),this.getRealY(7));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(6),this.getRealY(8));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(6),this.getRealY(9));
        Spieler player46 = new Spieler(this.loadCharacter());
        addObject(player46,this.getRealX(3),this.getRealY(7));
        player46.setRotation(270);
        Spieler player47 = new Spieler(this.loadCharacter());
        addObject(player47,this.getRealX(9),this.getRealY(7));
        player47.setRotation(270);
        String[] firstPage = new String[]{"Unsere Programme sind zwar jetzt dynamisch,","jedoch ist der Schreibaufwand in manchen Situationen","immernoch hoch.","Wichtig ist dabei nicht zu vergessen, weiterhin Prozeduren","zu nutzen."};
        String[] secondPage = new String[]{"Anhand der Farbe der gelösten Levels kannst","du erkennen, wie effizient dein Programm gestaltet ist.","Grün = Dein Programm ist effizient","Gelb = Dein Programm ist akzeptabel effizient","Rot = Dein Programm ist nicht effizient genug"};
        String wm = "+20 EXP.\n\nJede Prozedur wird wie dein Hauptprogramm gehandhabt.\nDeshalb kannst du auch Abfragen in diesen verwenden.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage,secondPage},new Spieler[]{player46,player47},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L09() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FTS");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FTS");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FTS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FOLWS");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(10),this.getRealY(5));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(6));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(7));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(8));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(10),this.getRealY(9));
        Wall wall16 = new Wall("FOLNW");
        addObject(wall16,this.getRealX(10),this.getRealY(10));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(1),this.getRealY(10));
        Wall wall18 = new Wall("FTN");
        addObject(wall18,this.getRealX(2),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(3),this.getRealY(10));
        Wall wall20 = new Wall("FTN");
        addObject(wall20,this.getRealX(4),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(5),this.getRealY(10));
        Wall wall22 = new Wall("FTN");
        addObject(wall22,this.getRealX(6),this.getRealY(10));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(7),this.getRealY(10));
        Wall wall24 = new Wall("FTN");
        addObject(wall24,this.getRealX(8),this.getRealY(10));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(9),this.getRealY(10));
        Wall wall26 = new Wall("FOLEN");
        addObject(wall26,this.getRealX(0),this.getRealY(10));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(5));
        Wall wall28 = new Wall("FWV");
        addObject(wall28,this.getRealX(0),this.getRealY(6));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(7));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(8));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(9));
        Target t32 = new Target();
        addObject(t32,this.getRealX(3),this.getRealY(6));
        Target t33 = new Target();
        addObject(t33,this.getRealX(3),this.getRealY(7));
        Target t34 = new Target();
        addObject(t34,this.getRealX(3),this.getRealY(8));
        Target t35 = new Target();
        addObject(t35,this.getRealX(5),this.getRealY(7));
        Target t36 = new Target();
        addObject(t36,this.getRealX(5),this.getRealY(8));
        Target t37 = new Target();
        addObject(t37,this.getRealX(7),this.getRealY(8));
        Spieler player38 = new Spieler(this.loadCharacter());
        addObject(player38,this.getRealX(1),this.getRealY(5));
        player38.setRotation(0);
        Spieler player39 = new Spieler(this.loadCharacter());
        addObject(player39,this.getRealX(3),this.getRealY(5));
        player39.setRotation(0);
        Spieler player40 = new Spieler(this.loadCharacter());
        addObject(player40,this.getRealX(5),this.getRealY(5));
        player40.setRotation(0);
        Spieler player41 = new Spieler(this.loadCharacter());
        addObject(player41,this.getRealX(7),this.getRealY(5));
        player41.setRotation(0);
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(2),this.getRealY(5));
        Wall wall43 = new Wall("V");
        addObject(wall43,this.getRealX(2),this.getRealY(6));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(2),this.getRealY(7));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(2),this.getRealY(8));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(2),this.getRealY(9));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(4),this.getRealY(5));
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(4),this.getRealY(6));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(4),this.getRealY(7));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(4),this.getRealY(8));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(4),this.getRealY(9));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(6),this.getRealY(5));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(6),this.getRealY(6));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(6),this.getRealY(7));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(6),this.getRealY(8));
        Wall wall56 = new Wall("V");
        addObject(wall56,this.getRealX(6),this.getRealY(9));
        Wall wall57 = new Wall("V");
        addObject(wall57,this.getRealX(8),this.getRealY(5));
        Wall wall58 = new Wall("V");
        addObject(wall58,this.getRealX(8),this.getRealY(6));
        Wall wall59 = new Wall("V");
        addObject(wall59,this.getRealX(8),this.getRealY(7));
        Wall wall60 = new Wall("V");
        addObject(wall60,this.getRealX(8),this.getRealY(8));
        Wall wall61 = new Wall("V");
        addObject(wall61,this.getRealX(8),this.getRealY(9));
        String[] firstPage = new String[]{"Levels wie diese können anfänglich","irreführende Impulse zur Lösung senden.","Natürlich gibt es viele Lösungsmöglichkeiten,","allerdings sind manche effizienter als andere."};
        String wm = "+20 EXP.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},new Spieler[]{player38,player39,player40,player41},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC03L10() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FTS");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FOLWS");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("F");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("F");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("F");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall11 = new Wall("F");
        addObject(wall11,this.getRealX(10),this.getRealY(4));
        Wall wall12 = new Wall("F");
        addObject(wall12,this.getRealX(10),this.getRealY(5));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(6));
        Wall wall14 = new Wall("F");
        addObject(wall14,this.getRealX(10),this.getRealY(7));
        Wall wall15 = new Wall("F");
        addObject(wall15,this.getRealX(10),this.getRealY(8));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(1),this.getRealY(8));
        Wall wall17 = new Wall("FTN");
        addObject(wall17,this.getRealX(2),this.getRealY(8));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(3),this.getRealY(8));
        Wall wall19 = new Wall("FTN");
        addObject(wall19,this.getRealX(4),this.getRealY(8));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(5),this.getRealY(8));
        Wall wall21 = new Wall("FTN");
        addObject(wall21,this.getRealX(6),this.getRealY(8));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(7),this.getRealY(8));
        Wall wall23 = new Wall("F");
        addObject(wall23,this.getRealX(8),this.getRealY(8));
        Wall wall24 = new Wall("F");
        addObject(wall24,this.getRealX(9),this.getRealY(8));

        Wall wall26 = new Wall("FOLEN");
        addObject(wall26,this.getRealX(0),this.getRealY(8));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(5));
        Wall wall28 = new Wall("FWV");
        addObject(wall28,this.getRealX(0),this.getRealY(6));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(7));
        Checkpoint c30 = new Checkpoint(0);
        addObject(c30,this.getRealX(1),this.getRealY(5));
        Checkpoint c31 = new Checkpoint(0);
        addObject(c31,this.getRealX(3),this.getRealY(7));
        Checkpoint c32 = new Checkpoint(0);
        addObject(c32,this.getRealX(5),this.getRealY(5));
        Checkpoint c33 = new Checkpoint(0);
        addObject(c33,this.getRealX(7),this.getRealY(7));
        Wall wall34 = new Wall("F");
        addObject(wall34,this.getRealX(7),this.getRealY(5));
        Wall wall35 = new Wall("F");
        addObject(wall35,this.getRealX(9),this.getRealY(5));
        Wall wall36 = new Wall("F");
        addObject(wall36,this.getRealX(9),this.getRealY(7));
        Spieler player37 = new Spieler(this.loadCharacter());
        addObject(player37,this.getRealX(1),this.getRealY(6));
        player37.setRotation(0);
        Spieler player38 = new Spieler(this.loadCharacter());
        addObject(player38,this.getRealX(3),this.getRealY(6));
        player38.setRotation(0);
        Spieler player39 = new Spieler(this.loadCharacter());
        addObject(player39,this.getRealX(5),this.getRealY(6));
        player39.setRotation(180);
        Spieler player40 = new Spieler(this.loadCharacter());
        addObject(player40,this.getRealX(7),this.getRealY(6));
        player40.setRotation(0);
        Spieler player41 = new Spieler(this.loadCharacter());
        addObject(player41,this.getRealX(9),this.getRealY(6));
        player41.setRotation(0);
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(2),this.getRealY(5));
        Wall wall43 = new Wall("V");
        addObject(wall43,this.getRealX(2),this.getRealY(6));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(2),this.getRealY(7));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(4),this.getRealY(5));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(4),this.getRealY(6));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(4),this.getRealY(7));
        Wall wall48 = new Wall("FEV");
        addObject(wall48,this.getRealX(6),this.getRealY(5));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(6),this.getRealY(6));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(6),this.getRealY(7));
        Wall wall51 = new Wall("F");
        addObject(wall51,this.getRealX(8),this.getRealY(5));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(8),this.getRealY(6));
        Wall wall53 = new Wall("F");
        addObject(wall53,this.getRealX(8),this.getRealY(7));
        String[] firstPage = new String[]{"Die Lösung dieses Levels bietet die","Grundlage für andere Probleme, wie den","einfachen Labyrinth-Durchsuchungs-Problemen."};

        String wm = "+30 EXP.\n\nGut gemacht! Auf zum nächsten Kapitel!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},new Spieler[]{player37,player38,player39,player40,player41},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L01() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FOLWS");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(9),this.getRealY(5));
        Wall wall11 = new Wall("FTW");
        addObject(wall11,this.getRealX(9),this.getRealY(6));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(9),this.getRealY(7));
        Wall wall13 = new Wall("FTW");
        addObject(wall13,this.getRealX(9),this.getRealY(8));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(9),this.getRealY(9));
        Wall wall15 = new Wall("FTW");
        addObject(wall15,this.getRealX(9),this.getRealY(10));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(9),this.getRealY(11));
        Wall wall17 = new Wall("FOLNW");
        addObject(wall17,this.getRealX(9),this.getRealY(12));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(1),this.getRealY(12));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(2),this.getRealY(12));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(3),this.getRealY(12));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(4),this.getRealY(12));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(5),this.getRealY(12));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(6),this.getRealY(12));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(7),this.getRealY(12));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(8),this.getRealY(12));
        Wall wall26 = new Wall("FOLEN");
        addObject(wall26,this.getRealX(0),this.getRealY(12));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(5));
        Wall wall28 = new Wall("FTE");
        addObject(wall28,this.getRealX(0),this.getRealY(6));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(7));
        Wall wall30 = new Wall("FTE");
        addObject(wall30,this.getRealX(0),this.getRealY(8));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(9));
        Wall wall32 = new Wall("FTE");
        addObject(wall32,this.getRealX(0),this.getRealY(10));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(11));
        Checkpoint c34 = new Checkpoint(0);
        addObject(c34,this.getRealX(5),this.getRealY(5));
        Checkpoint c35 = new Checkpoint(0);
        addObject(c35,this.getRealX(6),this.getRealY(7));
        Checkpoint c36 = new Checkpoint(0);
        addObject(c36,this.getRealX(6),this.getRealY(9));
        Checkpoint c37 = new Checkpoint(0);
        addObject(c37,this.getRealX(8),this.getRealY(11));
        Spieler player38 = new Spieler(this.loadCharacter());
        addObject(player38,this.getRealX(1),this.getRealY(5));
        player38.setRotation(0);
        Spieler player39 = new Spieler(this.loadCharacter());
        addObject(player39,this.getRealX(3),this.getRealY(7));
        player39.setRotation(0);
        Spieler player40 = new Spieler(this.loadCharacter());
        addObject(player40,this.getRealX(7),this.getRealY(9));
        player40.setRotation(180);
        Spieler player41 = new Spieler(this.loadCharacter());
        addObject(player41,this.getRealX(1),this.getRealY(11));
        player41.setRotation(0);
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(1),this.getRealY(6));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(2),this.getRealY(6));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(3),this.getRealY(6));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(4),this.getRealY(6));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(5),this.getRealY(6));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(6),this.getRealY(6));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(7),this.getRealY(6));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(8),this.getRealY(6));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(1),this.getRealY(8));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(2),this.getRealY(8));
        Wall wall53 = new Wall("H");
        addObject(wall53,this.getRealX(3),this.getRealY(8));
        Wall wall54 = new Wall("H");
        addObject(wall54,this.getRealX(4),this.getRealY(8));
        Wall wall55 = new Wall("H");
        addObject(wall55,this.getRealX(5),this.getRealY(8));
        Wall wall56 = new Wall("H");
        addObject(wall56,this.getRealX(6),this.getRealY(8));
        Wall wall57 = new Wall("H");
        addObject(wall57,this.getRealX(7),this.getRealY(8));
        Wall wall58 = new Wall("H");
        addObject(wall58,this.getRealX(8),this.getRealY(8));
        Wall wall59 = new Wall("H");
        addObject(wall59,this.getRealX(1),this.getRealY(10));
        Wall wall60 = new Wall("H");
        addObject(wall60,this.getRealX(2),this.getRealY(10));
        Wall wall61 = new Wall("H");
        addObject(wall61,this.getRealX(3),this.getRealY(10));
        Wall wall62 = new Wall("H");
        addObject(wall62,this.getRealX(4),this.getRealY(10));
        Wall wall63 = new Wall("H");
        addObject(wall63,this.getRealX(5),this.getRealY(10));
        Wall wall64 = new Wall("H");
        addObject(wall64,this.getRealX(6),this.getRealY(10));
        Wall wall65 = new Wall("H");
        addObject(wall65,this.getRealX(7),this.getRealY(10));
        Wall wall66 = new Wall("H");
        addObject(wall66,this.getRealX(8),this.getRealY(10));
        String[] firstPage = new String[]{"Es wird Zeit, das nächste Konzept","der Programmierung zu erlernen: Schleifen","","Diese dienen dazu, dein Programm effizient","zu machen."};
        String[] secondPage = new String[]{"Unter Effizienz versteht man unter","anderem, dass ein Programm mit wenig","Code möglichst viel bezwecken kann."};
        String[] thirdPage = new String[]{"In diesem Level zum Beispiel,","möchten wir nicht sieben Abfragen","formulieren, die die Figur bewegen, falls","diese einen Checkpoint sieht."};
        String[] fourthPage = new String[]{"Stattdessen möchten wir den Figuren","einfach sagen:","\"Bewegt euch solange, bis ihr den","Checkpoint habt.\"","Dies können wir mit einer Schleife erreichen."};
        String[] fifthPage = new String[]{"Umgangssprachlich werden","Schleifen folgendermaßen formuliert:","","SOLANGE eine Situation gilt,","SOLL dies getan werden"};
        String[] sixthPage = new String[]{"In Java:","while(Bedingung trifft zu) {","    //Soll dies geschehen.","}"};
        String[] seventhPage = new String[]{"Die vorigen Bedingungen bleiben","die Gleichen. Probiere es also mal mit:","while(siehtCheckpoint()) {","    schritt();","}"};
        String wm = "+10 EXP\n\nPerfekt! Siehst du, wie viel Schreibaufwand\ndu sparen konntest?";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage,sixthPage,seventhPage},new Spieler[]{player38,player39,player40,player41},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L02() { //Real One
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FTW");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FTW");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(8),this.getRealY(9));
        Wall wall14 = new Wall("FOLNW");
        addObject(wall14,this.getRealX(8),this.getRealY(10));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(1),this.getRealY(10));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(2),this.getRealY(10));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(3),this.getRealY(10));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(4),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(5),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(6),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(7),this.getRealY(10));
        Wall wall22 = new Wall("FOLEN");
        addObject(wall22,this.getRealX(0),this.getRealY(10));
        Wall wall23 = new Wall("FWV");
        addObject(wall23,this.getRealX(0),this.getRealY(5));
        Wall wall24 = new Wall("FTE");
        addObject(wall24,this.getRealX(0),this.getRealY(6));
        Wall wall25 = new Wall("FWV");
        addObject(wall25,this.getRealX(0),this.getRealY(7));
        Wall wall26 = new Wall("FTE");
        addObject(wall26,this.getRealX(0),this.getRealY(8));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(9));
        Outline o28 = new Outline();
        addObject(o28,this.getRealX(3),this.getRealY(5));
        Outline o29 = new Outline();
        addObject(o29,this.getRealX(4),this.getRealY(7));
        Outline o30 = new Outline();
        addObject(o30,this.getRealX(7),this.getRealY(9));
        Spieler player31 = new Spieler(this.loadCharacter());
        addObject(player31,this.getRealX(1),this.getRealY(5));
        player31.setRotation(0);
        player31.setOutlineAsOnlyGoal();
        Spieler player32 = new Spieler(this.loadCharacter());
        addObject(player32,this.getRealX(7),this.getRealY(7));
        player32.setRotation(180);
        player32.setOutlineAsOnlyGoal();
        Spieler player33 = new Spieler(this.loadCharacter());
        addObject(player33,this.getRealX(1),this.getRealY(9));
        player33.setRotation(0);
        player33.setOutlineAsOnlyGoal();
        Wall wall34 = new Wall("H");
        addObject(wall34,this.getRealX(1),this.getRealY(6));
        Wall wall35 = new Wall("H");
        addObject(wall35,this.getRealX(2),this.getRealY(6));
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(3),this.getRealY(6));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(4),this.getRealY(6));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(5),this.getRealY(6));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(6),this.getRealY(6));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(7),this.getRealY(6));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(1),this.getRealY(8));
        Wall wall42 = new Wall("H");
        addObject(wall42,this.getRealX(2),this.getRealY(8));
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(3),this.getRealY(8));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(4),this.getRealY(8));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(5),this.getRealY(8));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(6),this.getRealY(8));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(7),this.getRealY(8));
        String[] firstPage = new String[]{"Es gibt einige Situationen, in","denen man davon profitieren könnte,","wenn eine Bedingung nicht zutrifft."};
        String[] secondPage = new String[]{"Zum Beispiel sieht man hier ein","Level, in dem die Figuren am Besten","solange laufen sollen, bis sie eine","Markierung antreffen und diese dann","einfärben sollen."};
        String[] thirdPage = new String[]{"Da Kahla allerdings nur die","Bedingung \"istAufMarkierung()\" kennt,","erschwert es die Situation etwas."};
        String[] fourthPage = new String[]{"Man könnte nun lästigerweise","eine Schleife mit einer if-else-Abfrage","verwenden.","","Java bietet jedoch eine bessere Option."};
        String[] fifthPage = new String[]{"Man kann Bedingungen","verneinen.","In Java geht dies, in dem man ein","Ausrufezeichen vor eine Bedingung","schreibt."};
        String[] sixthPage = new String[]{"In diesem Beispiel steht","!istAufMarkierung() dafür, dass unsere","Figur gerade nicht auf einer Markierung","steht."};
        String[] seventhPage = new String[]{"Verwende dies mal in einer","Schleife und lasse die Figur laufen,","solange sie keine Markierung unter sich","hat."};
        String wm = "+10 EXP\n\nGroßartig! Dies spart in Zukunft einiges\nan Kraft und Schreibaufwand!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage,sixthPage,seventhPage},new Spieler[]{player31,player32,player33},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L0X() { //Fake
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FTW");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FTW");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(8),this.getRealY(9));
        Wall wall14 = new Wall("FOLNW");
        addObject(wall14,this.getRealX(8),this.getRealY(10));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(1),this.getRealY(10));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(2),this.getRealY(10));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(3),this.getRealY(10));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(4),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(5),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(6),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(7),this.getRealY(10));
        Wall wall22 = new Wall("FOLEN");
        addObject(wall22,this.getRealX(0),this.getRealY(10));
        Wall wall23 = new Wall("FWV");
        addObject(wall23,this.getRealX(0),this.getRealY(5));
        Wall wall24 = new Wall("FTE");
        addObject(wall24,this.getRealX(0),this.getRealY(6));
        Wall wall25 = new Wall("FWV");
        addObject(wall25,this.getRealX(0),this.getRealY(7));
        Wall wall26 = new Wall("FTE");
        addObject(wall26,this.getRealX(0),this.getRealY(8));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(9));
        Wall wall28 = new Wall("H");
        addObject(wall28,this.getRealX(1),this.getRealY(6));
        Wall wall29 = new Wall("H");
        addObject(wall29,this.getRealX(2),this.getRealY(6));
        Wall wall30 = new Wall("H");
        addObject(wall30,this.getRealX(3),this.getRealY(6));
        Wall wall31 = new Wall("H");
        addObject(wall31,this.getRealX(4),this.getRealY(6));
        Wall wall32 = new Wall("H");
        addObject(wall32,this.getRealX(5),this.getRealY(6));
        Wall wall33 = new Wall("H");
        addObject(wall33,this.getRealX(6),this.getRealY(6));
        Wall wall34 = new Wall("H");
        addObject(wall34,this.getRealX(7),this.getRealY(6));
        Wall wall35 = new Wall("H");
        addObject(wall35,this.getRealX(1),this.getRealY(8));
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(2),this.getRealY(8));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(3),this.getRealY(8));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(4),this.getRealY(8));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(5),this.getRealY(8));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(6),this.getRealY(8));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(7),this.getRealY(8));
        Spieler player42 = new Spieler(this.loadCharacter());
        addObject(player42,this.getRealX(1),this.getRealY(5));
        player42.setRotation(0);
        Spieler player43 = new Spieler(this.loadCharacter());
        addObject(player43,this.getRealX(2),this.getRealY(7));
        player43.setRotation(0);
        Spieler player44 = new Spieler(this.loadCharacter());
        addObject(player44,this.getRealX(1),this.getRealY(9));
        player44.setRotation(0);
        
        Target t46 = new Target();
        addObject(t46,this.getRealX(4),this.getRealY(5));
        Target t47 = new Target();
        addObject(t47,this.getRealX(5),this.getRealY(9));
        Target t48 = new Target();
        addObject(t48,this.getRealX(6),this.getRealY(5));
        
        Target t50 = new Target();
        addObject(t50,this.getRealX(4),this.getRealY(7));
        Target t51 = new Target();
        addObject(t51,this.getRealX(5),this.getRealY(7));
        Target t52 = new Target();
        addObject(t52,this.getRealX(3),this.getRealY(9));
        Target t53 = new Target();
        addObject(t53,this.getRealX(4),this.getRealY(9));
        
        Checkpoint c01 = new Checkpoint(0);
        addObject(c01,this.getRealX(7),this.getRealY(5));
        Checkpoint c02 = new Checkpoint(0);
        addObject(c02,this.getRealX(7),this.getRealY(7));
        Checkpoint c03 = new Checkpoint(0);
        addObject(c03,this.getRealX(7),this.getRealY(9));
        
        
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player42,player43,player44},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
    }
    
    public void prepareC04L03() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FOLWS");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FOLSE");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(8),this.getRealY(9));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(8),this.getRealY(10));
        Wall wall15 = new Wall("FOLNW");
        addObject(wall15,this.getRealX(8),this.getRealY(11));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(1),this.getRealY(11));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(2),this.getRealY(11));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(3),this.getRealY(11));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(4),this.getRealY(11));
        Wall wall20 = new Wall("FOLNW");
        addObject(wall20,this.getRealX(5),this.getRealY(11));
        Wall wall21 = new Wall("FOLEN");
        addObject(wall21,this.getRealX(6),this.getRealY(11));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(7),this.getRealY(11));
        Wall wall23 = new Wall("FOLEN");
        addObject(wall23,this.getRealX(0),this.getRealY(11));
        Wall wall24 = new Wall("FWV");
        addObject(wall24,this.getRealX(0),this.getRealY(5));
        Wall wall25 = new Wall("FTE");
        addObject(wall25,this.getRealX(0),this.getRealY(6));
        Wall wall26 = new Wall("FWV");
        addObject(wall26,this.getRealX(0),this.getRealY(7));
        Wall wall27 = new Wall("FTE");
        addObject(wall27,this.getRealX(0),this.getRealY(8));
        Wall wall28 = new Wall("FWV");
        addObject(wall28,this.getRealX(0),this.getRealY(9));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(10));
        Checkpoint c30 = new Checkpoint(0);
        addObject(c30,this.getRealX(4),this.getRealY(6));
        Checkpoint c31 = new Checkpoint(0);
        addObject(c31,this.getRealX(1),this.getRealY(9));
        Checkpoint c32 = new Checkpoint(0);
        addObject(c32,this.getRealX(6),this.getRealY(10));
        Spieler player33 = new Spieler(this.loadCharacter());
        addObject(player33,this.getRealX(1),this.getRealY(5));
        player33.setRotation(0);
        Spieler player34 = new Spieler(this.loadCharacter());
        addObject(player34,this.getRealX(3),this.getRealY(10));
        player34.setRotation(180);
        Spieler player35 = new Spieler(this.loadCharacter());
        addObject(player35,this.getRealX(7),this.getRealY(5));
        player35.setRotation(90);
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(1),this.getRealY(6));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(2),this.getRealY(6));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(4),this.getRealY(7));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(1),this.getRealY(8));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(3),this.getRealY(9));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(4),this.getRealY(9));
        
        Wall wall43 = new Wall("FEV");
        addObject(wall43,this.getRealX(5),this.getRealY(5));
        Wall wall44 = new Wall("FEV");
        addObject(wall44,this.getRealX(5),this.getRealY(6));
        Wall wall45 = new Wall("FTW");
        addObject(wall45,this.getRealX(5),this.getRealY(7));
        Wall wall46 = new Wall("FEV");
        addObject(wall46,this.getRealX(5),this.getRealY(8));
        Wall wall47 = new Wall("FTW");
        addObject(wall47,this.getRealX(5),this.getRealY(9));
        Wall wall48 = new Wall("FEV");
        addObject(wall48,this.getRealX(5),this.getRealY(10));
        Wall wall49 = new Wall("FWV");
        addObject(wall49,this.getRealX(6),this.getRealY(5));
        Wall wall50 = new Wall("FWV");
        addObject(wall50,this.getRealX(6),this.getRealY(6));
        Wall wall51 = new Wall("FWV");
        addObject(wall51,this.getRealX(6),this.getRealY(7));
        Wall wall52 = new Wall("FWV");
        addObject(wall52,this.getRealX(6),this.getRealY(8));
        Wall wall53 = new Wall("FWV");
        addObject(wall53,this.getRealX(6),this.getRealY(9));
        
        Wall wall54 = new Wall("LWS");
        addObject(wall54,this.getRealX(3),this.getRealY(6));
        
        Wall wall55 = new Wall("LEN");
        addObject(wall55,this.getRealX(3),this.getRealY(7));
        
        Wall wall56 = new Wall("LWS");
        addObject(wall56,this.getRealX(2),this.getRealY(8));
        
        Wall wall57 = new Wall("LEN");
        addObject(wall57,this.getRealX(2),this.getRealY(9));
        
        String[] firstPage = new String[]{"In diesem Level führen wir eine","neue Bedingung ein: istVorWand()","","Diese gibt zurück, ob die Figur direkt vor","einer Wand steht."};
        String[] secondPage = new String[]{"Dies ist besonders hilfreich,","wenn man die Figur bis zu einer Wand","laufen lassen möchte, wie in diesem","Level."};
        String wm = "+10 EXP!\n\nGut gemacht!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player33,player34,player35},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L04() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FTW");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(8),this.getRealY(9));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(8),this.getRealY(10));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(8),this.getRealY(11));
        Wall wall16 = new Wall("FOLNW");
        addObject(wall16,this.getRealX(8),this.getRealY(12));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(1),this.getRealY(12));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(2),this.getRealY(12));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(3),this.getRealY(12));
        Wall wall20 = new Wall("FTN");
        addObject(wall20,this.getRealX(4),this.getRealY(12));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(5),this.getRealY(12));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(6),this.getRealY(12));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(7),this.getRealY(12));
        Wall wall24 = new Wall("FOLEN");
        addObject(wall24,this.getRealX(0),this.getRealY(12));
        Wall wall25 = new Wall("FWV");
        addObject(wall25,this.getRealX(0),this.getRealY(5));
        Wall wall26 = new Wall("FWV");
        addObject(wall26,this.getRealX(0),this.getRealY(6));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(7));
        Wall wall28 = new Wall("FTE");
        addObject(wall28,this.getRealX(0),this.getRealY(8));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(9));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(10));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(11));
        Target t32 = new Target();
        addObject(t32,this.getRealX(1),this.getRealY(7));
        Target t33 = new Target();
        addObject(t33,this.getRealX(3),this.getRealY(11));
        Target t34 = new Target();
        addObject(t34,this.getRealX(7),this.getRealY(7));
        Target t35 = new Target();
        addObject(t35,this.getRealX(7),this.getRealY(9));
        Spieler player36 = new Spieler(this.loadCharacter());
        addObject(player36,this.getRealX(3),this.getRealY(7));
        player36.setRotation(270);
        Spieler player37 = new Spieler(this.loadCharacter());
        addObject(player37,this.getRealX(3),this.getRealY(9));
        player37.setRotation(270);
        Spieler player38 = new Spieler(this.loadCharacter());
        addObject(player38,this.getRealX(5),this.getRealY(7));
        player38.setRotation(270);
        Spieler player39 = new Spieler(this.loadCharacter());
        addObject(player39,this.getRealX(7),this.getRealY(11));
        player39.setRotation(0);
        Wall wall40 = new Wall("V");
        addObject(wall40,this.getRealX(4),this.getRealY(5));
        Wall wall41 = new Wall("V");
        addObject(wall41,this.getRealX(4),this.getRealY(6));
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(4),this.getRealY(7));
        Wall wall43 = new Wall("V");
        addObject(wall43,this.getRealX(4),this.getRealY(8));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(4),this.getRealY(9));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(4),this.getRealY(10));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(4),this.getRealY(11));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(1),this.getRealY(8));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(2),this.getRealY(8));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(3),this.getRealY(8));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(4),this.getRealY(8));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(5),this.getRealY(8));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(6),this.getRealY(8));
        Wall wall53 = new Wall("H");
        addObject(wall53,this.getRealX(7),this.getRealY(8));
        String[] firstPage = new String[]{"Ein großes Ziel bei der","Verwendung von Schleifen ist es,","Problemklassen anstelle von Problemen","zu lösen."};
        String[] secondPage = new String[]{"Hier sieht man ein Multi-Level.","","Jeder einzelne Raum repräsentiert ein","Problem, welches man an sich einfach","lösen könnte."};
        String[] thirdPage = new String[]{"Betrachtet man jedoch alle","Räume etwas genauer, so fällt einem","auf, dass diese Probleme etwas","gemeinsam haben."};
        String[] fourthPage = new String[]{"In jedem Raum steht ein Spieler","in einer Ecke und hat in mindestens einer","Richtung eine Zielschiebe in Reichweite."};
        String[] fifthPage = new String[]{"Diese Gemeinsamkeit kann man","als eine Problemklasse formulieren.","Und wenn wir diese allgemeine Klasse","lösen können, so können wir auch jeden","ähnlichen Raum lösen."};
        String[] sixthPage = new String[]{"Statt also vier einzelne Probleme","zu behandeln, lösen wir ein größeres","Problem, welches alle unsere Probleme","in diesem Level löst."};
        String wm = "+10 EXP\n\nGut.\nEin guter Programmierer versucht\nstets Problemklassen zu lösen!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage,sixthPage},new Spieler[]{player36,player37,player38,player39},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L05() {
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FOLWS");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(10),this.getRealY(5));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(6));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(7));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(8));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(10),this.getRealY(9));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(10),this.getRealY(10));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(10),this.getRealY(11));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(10),this.getRealY(12));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(10),this.getRealY(13));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(10),this.getRealY(14));
        Wall wall21 = new Wall("FOLNW");
        addObject(wall21,this.getRealX(10),this.getRealY(15));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(1),this.getRealY(15));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(2),this.getRealY(15));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(3),this.getRealY(15));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(4),this.getRealY(15));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(5),this.getRealY(15));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(6),this.getRealY(15));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(7),this.getRealY(15));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(8),this.getRealY(15));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(9),this.getRealY(15));
        Wall wall31 = new Wall("FOLEN");
        addObject(wall31,this.getRealX(0),this.getRealY(15));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(5));
        Wall wall33 = new Wall("FTE");
        addObject(wall33,this.getRealX(0),this.getRealY(6));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(7));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(8));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(9));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(10));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(11));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(12));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(13));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(14));
        Item c42 = new Item();
        addObject(c42,this.getRealX(5),this.getRealY(10));
        Spieler player43 = new Spieler(this.loadCharacter());
        addObject(player43,this.getRealX(1),this.getRealY(5));
        player43.setRotation(0);
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(1),this.getRealY(6));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(2),this.getRealY(6));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(3),this.getRealY(6));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(4),this.getRealY(6));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(5),this.getRealY(6));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(6),this.getRealY(6));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(7),this.getRealY(6));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(8),this.getRealY(7));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(8),this.getRealY(8));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(8),this.getRealY(9));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(8),this.getRealY(10));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(8),this.getRealY(11));
        Wall wall56 = new Wall("V");
        addObject(wall56,this.getRealX(8),this.getRealY(12));
        Wall wall59 = new Wall("H");
        addObject(wall59,this.getRealX(3),this.getRealY(13));
        Wall wall60 = new Wall("H");
        addObject(wall60,this.getRealX(4),this.getRealY(13));
        Wall wall61 = new Wall("H");
        addObject(wall61,this.getRealX(5),this.getRealY(13));
        Wall wall62 = new Wall("H");
        addObject(wall62,this.getRealX(6),this.getRealY(13));
        Wall wall63 = new Wall("H");
        addObject(wall63,this.getRealX(7),this.getRealY(13));
        Wall wall65 = new Wall("LWS");
        addObject(wall65,this.getRealX(8),this.getRealY(6));
        Wall wall66 = new Wall("LNW");
        addObject(wall66,this.getRealX(8),this.getRealY(13));
        Wall wall67 = new Wall("LEN");
        addObject(wall67,this.getRealX(2),this.getRealY(13));
        Wall wall68 = new Wall("V");
        addObject(wall68,this.getRealX(2),this.getRealY(9));
        Wall wall69 = new Wall("V");
        addObject(wall69,this.getRealX(2),this.getRealY(10));
        Wall wall70 = new Wall("V");
        addObject(wall70,this.getRealX(2),this.getRealY(11));
        Wall wall71 = new Wall("V");
        addObject(wall71,this.getRealX(2),this.getRealY(12));
        Wall wall72 = new Wall("LSE");
        addObject(wall72,this.getRealX(2),this.getRealY(8));
        Wall wall73 = new Wall("H");
        addObject(wall73,this.getRealX(3),this.getRealY(8));
        Wall wall74 = new Wall("H");
        addObject(wall74,this.getRealX(4),this.getRealY(8));
        Wall wall75 = new Wall("H");
        addObject(wall75,this.getRealX(5),this.getRealY(8));
        Wall wall76 = new Wall("LWS");
        addObject(wall76,this.getRealX(6),this.getRealY(8));
        Wall wall77 = new Wall("V");
        addObject(wall77,this.getRealX(6),this.getRealY(9));
        Wall wall78 = new Wall("V");
        addObject(wall78,this.getRealX(6),this.getRealY(10));
        Wall wall79 = new Wall("LNW");
        addObject(wall79,this.getRealX(6),this.getRealY(11));
        Wall wall80 = new Wall("H");
        addObject(wall80,this.getRealX(5),this.getRealY(11));
        Wall wall81 = new Wall("LEN");
        addObject(wall81,this.getRealX(4),this.getRealY(11));
        Wall wall82 = new Wall("V");
        addObject(wall82,this.getRealX(4),this.getRealY(10));
        String[] firstPage = new String[]{"Schleifen lassen sich wie Abfragen","mehrfach verschachteln.","","Dies sollte allerdings nur nach gründlicher","Überlegung verwendet werden."};
        String[] secondPage = new String[]{"Wenn man zwei Schleifen verschachtelt,","so gilt: Solange eine Bedingung gilt, wird eine","Schleife immer wieder neu ausgeführt, die","ebenfalls eine Bedingung überprüft.","Dies kann folgendermaßen aussehen:"};
        String[] thirdPage = new String[]{"while(Bedingung 1) {","    while(Bedingung 2) {","       //Befehle    ","    }","}"};
        String[] fourthPage = new String[]{"Dabei sollte die erste Bedingung das","Endziel, hier das Token, sein.","Die zweite Bedingung sollte etwas behandeln,","dass sich stets wiederholt, hier der Weg zur","Wand."};
        String[] fifthPage = new String[]{"Probiere dich mal aus und versuche das","Level mit einer verschachtelten Schleife zu lösen."};
        String wm = "+10 EXP\n\nVerschachtelte Schleifen bieten noch größere\nMöglichkeiten, effizientere Programme zu\ngestalten.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage},new Spieler[]{player43},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L06() {
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FOLWS");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FOLSE");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FOLWS");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FOLSE");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FOLSE");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FOLWS");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("F");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("F");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("F");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("F");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("F");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("F");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("F");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("F");
        addObject(wall19,this.getRealX(12),this.getRealY(11));
        Wall wall20 = new Wall("F");
        addObject(wall20,this.getRealX(12),this.getRealY(12));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(1),this.getRealY(12));
        Wall wall22 = new Wall("FOLNW");
        addObject(wall22,this.getRealX(2),this.getRealY(12));
        Wall wall23 = new Wall("FOLEN");
        addObject(wall23,this.getRealX(3),this.getRealY(12));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(4),this.getRealY(12));
        Wall wall25 = new Wall("FOLNW");
        addObject(wall25,this.getRealX(5),this.getRealY(12));
        Wall wall26 = new Wall("FOLEN");
        addObject(wall26,this.getRealX(6),this.getRealY(12));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(7),this.getRealY(12));
        Wall wall28 = new Wall("FOLNW");
        addObject(wall28,this.getRealX(8),this.getRealY(12));
        Wall wall29 = new Wall("FOLEN");
        addObject(wall29,this.getRealX(9),this.getRealY(12));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(10),this.getRealY(12));
        Wall wall31 = new Wall("FOLNW");
        addObject(wall31,this.getRealX(11),this.getRealY(12));
        Wall wall32 = new Wall("FOLEN");
        addObject(wall32,this.getRealX(0),this.getRealY(12));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(5));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(6));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(7));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(8));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(9));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(10));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(11));
        Outline o40 = new Outline();
        addObject(o40,this.getRealX(2),this.getRealY(9));
        Outline o41 = new Outline();
        addObject(o41,this.getRealX(5),this.getRealY(10));
        Outline o42 = new Outline();
        addObject(o42,this.getRealX(8),this.getRealY(11));
        Outline o43 = new Outline();
        addObject(o43,this.getRealX(11),this.getRealY(5));
        Spieler player44 = new Spieler(this.loadCharacter());
        addObject(player44,this.getRealX(1),this.getRealY(5));
        player44.setRotation(90);
        Spieler player45 = new Spieler(this.loadCharacter());
        addObject(player45,this.getRealX(4),this.getRealY(5));
        player45.setRotation(90);
        Spieler player46 = new Spieler(this.loadCharacter());
        addObject(player46,this.getRealX(7),this.getRealY(5));
        player46.setRotation(90);
        Spieler player47 = new Spieler(this.loadCharacter());
        addObject(player47,this.getRealX(10),this.getRealY(5));
        player47.setRotation(90);
        Wall wall48 = new Wall("FEV");
        addObject(wall48,this.getRealX(2),this.getRealY(5));
        Wall wall49 = new Wall("FEV");
        addObject(wall49,this.getRealX(2),this.getRealY(6));
        Wall wall50 = new Wall("FEV");
        addObject(wall50,this.getRealX(2),this.getRealY(7));
        Wall wall51 = new Wall("FEV");
        addObject(wall51,this.getRealX(2),this.getRealY(8));
        Wall wall52 = new Wall("FEV");
        addObject(wall52,this.getRealX(2),this.getRealY(10));
        Wall wall53 = new Wall("FEV");
        addObject(wall53,this.getRealX(2),this.getRealY(11));
        Wall wall54 = new Wall("FEV");
        addObject(wall54,this.getRealX(5),this.getRealY(5));
        Wall wall55 = new Wall("FEV");
        addObject(wall55,this.getRealX(5),this.getRealY(6));
        Wall wall56 = new Wall("FEV");
        addObject(wall56,this.getRealX(5),this.getRealY(7));
        Wall wall57 = new Wall("FEV");
        addObject(wall57,this.getRealX(5),this.getRealY(8));
        Wall wall58 = new Wall("FEV");
        addObject(wall58,this.getRealX(5),this.getRealY(9));
        Wall wall59 = new Wall("FEV");
        addObject(wall59,this.getRealX(5),this.getRealY(11));
        Wall wall60 = new Wall("FEV");
        addObject(wall60,this.getRealX(8),this.getRealY(5));
        Wall wall61 = new Wall("FEV");
        addObject(wall61,this.getRealX(8),this.getRealY(6));
        Wall wall62 = new Wall("FEV");
        addObject(wall62,this.getRealX(8),this.getRealY(7));
        Wall wall63 = new Wall("FEV");
        addObject(wall63,this.getRealX(8),this.getRealY(8));
        Wall wall64 = new Wall("FEV");
        addObject(wall64,this.getRealX(8),this.getRealY(9));
        Wall wall65 = new Wall("FEV");
        addObject(wall65,this.getRealX(8),this.getRealY(10));
        Wall wall66 = new Wall("FEV");
        addObject(wall66,this.getRealX(11),this.getRealY(6));
        Wall wall67 = new Wall("FEV");
        addObject(wall67,this.getRealX(11),this.getRealY(7));
        Wall wall68 = new Wall("FEV");
        addObject(wall68,this.getRealX(11),this.getRealY(8));
        Wall wall69 = new Wall("FEV");
        addObject(wall69,this.getRealX(11),this.getRealY(9));
        Wall wall70 = new Wall("FEV");
        addObject(wall70,this.getRealX(11),this.getRealY(10));
        Wall wall71 = new Wall("FEV");
        addObject(wall71,this.getRealX(11),this.getRealY(11));
        Wall wall72 = new Wall("FWV");
        addObject(wall72,this.getRealX(3),this.getRealY(5));
        Wall wall73 = new Wall("FWV");
        addObject(wall73,this.getRealX(3),this.getRealY(6));
        Wall wall74 = new Wall("FWV");
        addObject(wall74,this.getRealX(3),this.getRealY(7));
        Wall wall75 = new Wall("FWV");
        addObject(wall75,this.getRealX(3),this.getRealY(8));
        Wall wall76 = new Wall("FWV");
        addObject(wall76,this.getRealX(3),this.getRealY(9));
        Wall wall77 = new Wall("FWV");
        addObject(wall77,this.getRealX(3),this.getRealY(10));
        Wall wall78 = new Wall("FWV");
        addObject(wall78,this.getRealX(3),this.getRealY(11));
        Wall wall79 = new Wall("FWV");
        addObject(wall79,this.getRealX(6),this.getRealY(5));
        Wall wall80 = new Wall("FWV");
        addObject(wall80,this.getRealX(6),this.getRealY(6));
        Wall wall81 = new Wall("FWV");
        addObject(wall81,this.getRealX(6),this.getRealY(7));
        Wall wall82 = new Wall("FWV");
        addObject(wall82,this.getRealX(6),this.getRealY(8));
        Wall wall83 = new Wall("FWV");
        addObject(wall83,this.getRealX(6),this.getRealY(9));
        Wall wall84 = new Wall("FWV");
        addObject(wall84,this.getRealX(6),this.getRealY(10));
        Wall wall85 = new Wall("FWV");
        addObject(wall85,this.getRealX(6),this.getRealY(11));
        Wall wall86 = new Wall("FWV");
        addObject(wall86,this.getRealX(9),this.getRealY(5));
        Wall wall87 = new Wall("FWV");
        addObject(wall87,this.getRealX(9),this.getRealY(6));
        Wall wall88 = new Wall("FWV");
        addObject(wall88,this.getRealX(9),this.getRealY(7));
        Wall wall89 = new Wall("FWV");
        addObject(wall89,this.getRealX(9),this.getRealY(8));
        Wall wall90 = new Wall("FWV");
        addObject(wall90,this.getRealX(9),this.getRealY(9));
        Wall wall91 = new Wall("FWV");
        addObject(wall91,this.getRealX(9),this.getRealY(10));
        Wall wall92 = new Wall("FWV");
        addObject(wall92,this.getRealX(9),this.getRealY(11));
        String[] firstPage = new String[]{"Manchmal ist es sinnvoll, das Ziel des Levels","umgangssprachlich zu formulieren.","","'Die Figur soll in einem Gang nach einem Ausweg suchen.'"};
        String wm = "+10 EXP\n\nGut gemacht.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},new Spieler[]{player44,player45,player46,player47},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L07() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FTS");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FTS");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FTS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FOLWS");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(11),this.getRealY(5));
        Wall wall13 = new Wall("FOLNW");
        addObject(wall13,this.getRealX(11),this.getRealY(6));
        Wall wall14 = new Wall("F");
        addObject(wall14,this.getRealX(11),this.getRealY(7));
        Wall wall15 = new Wall("F");
        addObject(wall15,this.getRealX(11),this.getRealY(8));
        Wall wall16 = new Wall("F");
        addObject(wall16,this.getRealX(11),this.getRealY(9));
        Wall wall17 = new Wall("F");
        addObject(wall17,this.getRealX(11),this.getRealY(10));
        Wall wall18 = new Wall("F");
        addObject(wall18,this.getRealX(11),this.getRealY(11));
        Wall wall19 = new Wall("F");
        addObject(wall19,this.getRealX(11),this.getRealY(12));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(1),this.getRealY(12));
        Wall wall21 = new Wall("FTN");
        addObject(wall21,this.getRealX(2),this.getRealY(12));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(3),this.getRealY(12));
        Wall wall23 = new Wall("FTN");
        addObject(wall23,this.getRealX(4),this.getRealY(12));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(5),this.getRealY(12));
        Wall wall25 = new Wall("FTN");
        addObject(wall25,this.getRealX(6),this.getRealY(12));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(7),this.getRealY(12));
        Wall wall27 = new Wall("FTN");
        addObject(wall27,this.getRealX(8),this.getRealY(12));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(9),this.getRealY(12));
        Wall wall29 = new Wall("FOLNW");
        addObject(wall29,this.getRealX(10),this.getRealY(12));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(12));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(10));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(11));
        Checkpoint c38 = new Checkpoint(0);
        addObject(c38,this.getRealX(2),this.getRealY(8));
        Checkpoint c39 = new Checkpoint(0);
        addObject(c39,this.getRealX(4),this.getRealY(10));
        Checkpoint c40 = new Checkpoint(0);
        addObject(c40,this.getRealX(6),this.getRealY(7));
        Checkpoint c41 = new Checkpoint(0);
        addObject(c41,this.getRealX(8),this.getRealY(11));
        Item t42 = new Item();
        addObject(t42,this.getRealX(10),this.getRealY(5));
        Spieler player43 = new Spieler(this.loadCharacter());
        addObject(player43,this.getRealX(1),this.getRealY(5));
        player43.setRotation(0);
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(2),this.getRealY(5));
        Wall wall45 = new Wall("V");
        addObject(wall45,this.getRealX(2),this.getRealY(6));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(2),this.getRealY(7));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(2),this.getRealY(9));
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(2),this.getRealY(10));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(2),this.getRealY(11));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(4),this.getRealY(5));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(4),this.getRealY(6));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(4),this.getRealY(7));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(4),this.getRealY(8));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(4),this.getRealY(9));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(4),this.getRealY(11));
        Wall wall56 = new Wall("V");
        addObject(wall56,this.getRealX(6),this.getRealY(5));
        Wall wall57 = new Wall("V");
        addObject(wall57,this.getRealX(6),this.getRealY(6));
        Wall wall58 = new Wall("V");
        addObject(wall58,this.getRealX(6),this.getRealY(8));
        Wall wall59 = new Wall("V");
        addObject(wall59,this.getRealX(6),this.getRealY(9));
        Wall wall60 = new Wall("V");
        addObject(wall60,this.getRealX(6),this.getRealY(10));
        Wall wall61 = new Wall("V");
        addObject(wall61,this.getRealX(6),this.getRealY(11));
        Wall wall62 = new Wall("V");
        addObject(wall62,this.getRealX(8),this.getRealY(5));
        Wall wall63 = new Wall("V");
        addObject(wall63,this.getRealX(8),this.getRealY(6));
        Wall wall64 = new Wall("V");
        addObject(wall64,this.getRealX(8),this.getRealY(7));
        Wall wall65 = new Wall("V");
        addObject(wall65,this.getRealX(8),this.getRealY(8));
        Wall wall66 = new Wall("V");
        addObject(wall66,this.getRealX(8),this.getRealY(9));
        Wall wall67 = new Wall("V");
        addObject(wall67,this.getRealX(8),this.getRealY(10));
        Wall wall68 = new Wall("FILSE");
        addObject(wall68,this.getRealX(10),this.getRealY(6));
        Wall wall69 = new Wall("FEV");
        addObject(wall69,this.getRealX(10),this.getRealY(7));
        Wall wall70 = new Wall("FEV");
        addObject(wall70,this.getRealX(10),this.getRealY(8));
        Wall wall71 = new Wall("FEV");
        addObject(wall71,this.getRealX(10),this.getRealY(9));
        Wall wall72 = new Wall("FEV");
        addObject(wall72,this.getRealX(10),this.getRealY(10));
        Wall wall73 = new Wall("FEV");
        addObject(wall73,this.getRealX(10),this.getRealY(11));
        Wall wall74 = new Wall("FEV");
        addObject(wall74,this.getRealX(11),this.getRealY(5));
        
        String[] firstPage = new String[]{"Dieses Level orientiert sich an dem vorigen","Level.","Statt dass jeder Gang von einer Figur gelöst wird, soll","hier eine einzige Figur den gesamten Raum lösen."};
        String[] secondPage = new String[]{"Manchmal lohnt es sich, einen Anfangs-","zustand wiederherzustellen, d.h. man versucht, die","Figur im zweiten Gang so zu platzieren, wie sie im","ersten Gang war usw."};
        String[] thirdPage = new String[]{"Versuche also mal nach Erreichen des zweiten","Gangs, die Figur an den Anfang des Gangs zu","bringen."};
        String wm = "+10 EXP!\n\nSuper!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},new Spieler[]{player43},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L0XX() { //Fake 4-08
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FOLWS");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(10),this.getRealY(5));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(6));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(7));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(8));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(10),this.getRealY(9));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(10),this.getRealY(10));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(10),this.getRealY(11));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(10),this.getRealY(12));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(10),this.getRealY(13));
        Wall wall20 = new Wall("FOLNW");
        addObject(wall20,this.getRealX(10),this.getRealY(14));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(1),this.getRealY(14));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(2),this.getRealY(14));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(3),this.getRealY(14));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(4),this.getRealY(14));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(5),this.getRealY(14));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(6),this.getRealY(14));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(7),this.getRealY(14));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(8),this.getRealY(14));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(9),this.getRealY(14));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(14));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(10));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(11));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(12));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(13));
        Checkpoint c0 = new Checkpoint(0);
        addObject(c0,this.getRealX(1),this.getRealY(5));
        Checkpoint c1 = new Checkpoint(0);
        addObject(c1,this.getRealX(9),this.getRealY(5));
        Checkpoint c2 = new Checkpoint(0);
        addObject(c2,this.getRealX(1),this.getRealY(13));
        Checkpoint c3 = new Checkpoint(0);
        addObject(c3,this.getRealX(9),this.getRealY(13));
        Spieler player4 = new Spieler(this.loadCharacter());
        addObject(player4,this.getRealX(4),this.getRealY(5));
        player4.setRotation(0);
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player4},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
    }
    
    public void prepareC04L08() { //Real 4-08
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FOLWS");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(10),this.getRealY(5));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(6));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(7));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(8));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(10),this.getRealY(9));
        Wall wall16 = new Wall("FTW");
        addObject(wall16,this.getRealX(10),this.getRealY(10));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(10),this.getRealY(11));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(10),this.getRealY(12));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(10),this.getRealY(13));
        Wall wall20 = new Wall("FOLNW");
        addObject(wall20,this.getRealX(10),this.getRealY(14));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(1),this.getRealY(14));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(2),this.getRealY(14));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(3),this.getRealY(14));
        Wall wall24 = new Wall("FTN");
        addObject(wall24,this.getRealX(4),this.getRealY(14));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(5),this.getRealY(14));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(6),this.getRealY(14));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(7),this.getRealY(14));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(8),this.getRealY(14));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(9),this.getRealY(14));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(14));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FTE");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(10));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(11));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(12));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(13));
        Wall wall40 = new Wall("V");
        addObject(wall40,this.getRealX(4),this.getRealY(5));
        Wall wall41 = new Wall("V");
        addObject(wall41,this.getRealX(4),this.getRealY(6));
        Wall wall42 = new Wall("V");
        addObject(wall42,this.getRealX(4),this.getRealY(7));
        Wall wall43 = new Wall("TW");
        addObject(wall43,this.getRealX(4),this.getRealY(8));
        Wall wall44 = new Wall("V");
        addObject(wall44,this.getRealX(4),this.getRealY(9));
        Wall wall45 = new Wall("TE");
        addObject(wall45,this.getRealX(4),this.getRealY(10));
        Wall wall46 = new Wall("V");
        addObject(wall46,this.getRealX(4),this.getRealY(11));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(4),this.getRealY(12));
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(4),this.getRealY(13));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(1),this.getRealY(8));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(2),this.getRealY(8));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(3),this.getRealY(8));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(5),this.getRealY(10));
        Wall wall53 = new Wall("H");
        addObject(wall53,this.getRealX(6),this.getRealY(10));
        Wall wall54 = new Wall("H");
        addObject(wall54,this.getRealX(7),this.getRealY(10));
        Wall wall55 = new Wall("H");
        addObject(wall55,this.getRealX(8),this.getRealY(10));
        Wall wall56 = new Wall("H");
        addObject(wall56,this.getRealX(9),this.getRealY(10));
        Outline o57 = new Outline();
        addObject(o57,this.getRealX(2),this.getRealY(5));
        Outline o58 = new Outline();
        addObject(o58,this.getRealX(3),this.getRealY(5));
        Outline o59 = new Outline();
        addObject(o59,this.getRealX(1),this.getRealY(6));
        Outline o60 = new Outline();
        addObject(o60,this.getRealX(2),this.getRealY(6));
        Outline o61 = new Outline();
        addObject(o61,this.getRealX(3),this.getRealY(6));
        Outline o62 = new Outline();
        addObject(o62,this.getRealX(1),this.getRealY(7));
        Outline o63 = new Outline();
        addObject(o63,this.getRealX(2),this.getRealY(7));
        Outline o64 = new Outline();
        addObject(o64,this.getRealX(3),this.getRealY(7));
        Outline o65 = new Outline();
        addObject(o65,this.getRealX(1),this.getRealY(9));
        Outline o66 = new Outline();
        addObject(o66,this.getRealX(2),this.getRealY(9));
        Outline o67 = new Outline();
        addObject(o67,this.getRealX(3),this.getRealY(9));
        Outline o68 = new Outline();
        addObject(o68,this.getRealX(1),this.getRealY(10));
        Outline o69 = new Outline();
        addObject(o69,this.getRealX(2),this.getRealY(10));
        Outline o70 = new Outline();
        addObject(o70,this.getRealX(3),this.getRealY(10));
        Outline o71 = new Outline();
        addObject(o71,this.getRealX(1),this.getRealY(11));
        Outline o72 = new Outline();
        addObject(o72,this.getRealX(2),this.getRealY(11));
        Outline o73 = new Outline();
        addObject(o73,this.getRealX(3),this.getRealY(11));
        Outline o74 = new Outline();
        addObject(o74,this.getRealX(1),this.getRealY(12));
        Outline o75 = new Outline();
        addObject(o75,this.getRealX(2),this.getRealY(12));
        Outline o76 = new Outline();
        addObject(o76,this.getRealX(3),this.getRealY(12));
        Outline o77 = new Outline();
        addObject(o77,this.getRealX(2),this.getRealY(13));
        Outline o78 = new Outline();
        addObject(o78,this.getRealX(3),this.getRealY(13));
        Outline o79 = new Outline();
        addObject(o79,this.getRealX(6),this.getRealY(5));
        Outline o80 = new Outline();
        addObject(o80,this.getRealX(7),this.getRealY(5));
        Outline o81 = new Outline();
        addObject(o81,this.getRealX(8),this.getRealY(5));
        Outline o82 = new Outline();
        addObject(o82,this.getRealX(9),this.getRealY(5));
        Outline o83 = new Outline();
        addObject(o83,this.getRealX(5),this.getRealY(6));
        Outline o84 = new Outline();
        addObject(o84,this.getRealX(6),this.getRealY(6));
        Outline o85 = new Outline();
        addObject(o85,this.getRealX(7),this.getRealY(6));
        Outline o86 = new Outline();
        addObject(o86,this.getRealX(8),this.getRealY(6));
        Outline o87 = new Outline();
        addObject(o87,this.getRealX(9),this.getRealY(6));
        Outline o88 = new Outline();
        addObject(o88,this.getRealX(5),this.getRealY(7));
        Outline o89 = new Outline();
        addObject(o89,this.getRealX(6),this.getRealY(7));
        Outline o90 = new Outline();
        addObject(o90,this.getRealX(7),this.getRealY(7));
        Outline o91 = new Outline();
        addObject(o91,this.getRealX(8),this.getRealY(7));
        Outline o92 = new Outline();
        addObject(o92,this.getRealX(9),this.getRealY(7));
        Outline o93 = new Outline();
        addObject(o93,this.getRealX(5),this.getRealY(8));
        Outline o94 = new Outline();
        addObject(o94,this.getRealX(6),this.getRealY(8));
        Outline o95 = new Outline();
        addObject(o95,this.getRealX(7),this.getRealY(8));
        Outline o96 = new Outline();
        addObject(o96,this.getRealX(8),this.getRealY(8));
        Outline o97 = new Outline();
        addObject(o97,this.getRealX(9),this.getRealY(8));
        Outline o98 = new Outline();
        addObject(o98,this.getRealX(5),this.getRealY(9));
        Outline o99 = new Outline();
        addObject(o99,this.getRealX(6),this.getRealY(9));
        Outline o100 = new Outline();
        addObject(o100,this.getRealX(7),this.getRealY(9));
        Outline o101 = new Outline();
        addObject(o101,this.getRealX(8),this.getRealY(9));
        Outline o102 = new Outline();
        addObject(o102,this.getRealX(9),this.getRealY(9));
        Outline o103 = new Outline();
        addObject(o103,this.getRealX(5),this.getRealY(11));
        Outline o104 = new Outline();
        addObject(o104,this.getRealX(6),this.getRealY(11));
        Outline o105 = new Outline();
        addObject(o105,this.getRealX(7),this.getRealY(11));
        Outline o106 = new Outline();
        addObject(o106,this.getRealX(8),this.getRealY(11));
        Outline o107 = new Outline();
        addObject(o107,this.getRealX(9),this.getRealY(11));
        Outline o108 = new Outline();
        addObject(o108,this.getRealX(5),this.getRealY(12));
        Outline o109 = new Outline();
        addObject(o109,this.getRealX(6),this.getRealY(12));
        Outline o110 = new Outline();
        addObject(o110,this.getRealX(7),this.getRealY(12));
        Outline o111 = new Outline();
        addObject(o111,this.getRealX(8),this.getRealY(12));
        Outline o112 = new Outline();
        addObject(o112,this.getRealX(9),this.getRealY(12));
        Outline o113 = new Outline();
        addObject(o113,this.getRealX(6),this.getRealY(13));
        Outline o114 = new Outline();
        addObject(o114,this.getRealX(7),this.getRealY(13));
        Outline o115 = new Outline();
        addObject(o115,this.getRealX(8),this.getRealY(13));
        Outline o116 = new Outline();
        addObject(o116,this.getRealX(9),this.getRealY(13));
        Item o117 = new Item();
        addObject(o117,this.getRealX(3),this.getRealY(7));
        Item o118 = new Item();
        addObject(o118,this.getRealX(9),this.getRealY(9));
        Item o119 = new Item();
        addObject(o119,this.getRealX(3),this.getRealY(9));
        Item o120 = new Item();
        addObject(o120,this.getRealX(9),this.getRealY(11));
        Spieler player117 = new Spieler(this.loadCharacter());
        addObject(player117,this.getRealX(1),this.getRealY(5));
        player117.setRotation(0);
        Spieler player118 = new Spieler(this.loadCharacter());
        addObject(player118,this.getRealX(5),this.getRealY(5));
        player118.setRotation(0);
        Spieler player119 = new Spieler(this.loadCharacter());
        addObject(player119,this.getRealX(1),this.getRealY(13));
        player119.setRotation(270);
        Spieler player120 = new Spieler(this.loadCharacter());
        addObject(player120,this.getRealX(5),this.getRealY(13));
        player120.setRotation(270);
        //Break!
        String[] firstPage = new String[]{"Versuche dich ruhig erstmal alleine an","dem Level.","","Für Tipps kannst du auf den kommenden","Seiten nachschauen."};
        String[] secondPage = new String[]{"Tipp 1:","Zur korrekten Nutzung solltest du eine doppelte","Schleife nutzen."};
        String[] thirdPage = new String[]{"Tipp 2:","Fang erstmal mit einer Schleife an, die alle Felder","bis zur Wand färbt und versuche zur nächsten","Reihe zu kommen."};
        String wm = "+20 EXP\n\nWeiter so!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},new Spieler[]{player117,player118,player119,player120},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC04L09() {
        int k = (int)(Math.random()*2);
        Item i0 = new Item();
        if (k == 0) {
            addObject(i0,this.getRealX(2),this.getRealY(5));
        } else if (k == 1) {
            addObject(i0,this.getRealX(1),this.getRealY(11));
        }
        
        
        Spieler player1 = new Spieler(this.loadCharacter());
        addObject(player1,this.getRealX(6),this.getRealY(5));
        player1.setRotation(0);
        Wall wall11 = new Wall("F");
        addObject(wall11,this.getRealX(0),this.getRealY(4));
        Wall wall12 = new Wall("F");
        addObject(wall12,this.getRealX(0),this.getRealY(5));
        Wall wall13 = new Wall("F");
        addObject(wall13,this.getRealX(0),this.getRealY(6));
        Wall wall14 = new Wall("F");
        addObject(wall14,this.getRealX(0),this.getRealY(7));
        Wall wall15 = new Wall("F");
        addObject(wall15,this.getRealX(0),this.getRealY(8));
        Wall wall16 = new Wall("F");
        addObject(wall16,this.getRealX(0),this.getRealY(9));
        Wall wall17 = new Wall("F");
        addObject(wall17,this.getRealX(0),this.getRealY(10));
        Wall wall18 = new Wall("F");
        addObject(wall18,this.getRealX(0),this.getRealY(11));
        Wall wall19 = new Wall("F");
        addObject(wall19,this.getRealX(0),this.getRealY(12));
        Wall wall20 = new Wall("F");
        addObject(wall20,this.getRealX(1),this.getRealY(4));
        Wall wall21 = new Wall("F");
        addObject(wall21,this.getRealX(1),this.getRealY(12));
        Wall wall22 = new Wall("F");
        addObject(wall22,this.getRealX(2),this.getRealY(4));
        Wall wall23 = new Wall("F");
        addObject(wall23,this.getRealX(2),this.getRealY(6));
        Wall wall24 = new Wall("F");
        addObject(wall24,this.getRealX(2),this.getRealY(8));
        Wall wall25 = new Wall("F");
        addObject(wall25,this.getRealX(2),this.getRealY(9));
        Wall wall26 = new Wall("F");
        addObject(wall26,this.getRealX(2),this.getRealY(10));
        Wall wall27 = new Wall("F");
        addObject(wall27,this.getRealX(2),this.getRealY(11));
        Wall wall28 = new Wall("F");
        addObject(wall28,this.getRealX(2),this.getRealY(12));
        Wall wall29 = new Wall("F");
        addObject(wall29,this.getRealX(3),this.getRealY(4));
        Wall wall30 = new Wall("F");
        addObject(wall30,this.getRealX(3),this.getRealY(5));
        Wall wall31 = new Wall("F");
        addObject(wall31,this.getRealX(3),this.getRealY(6));
        Wall wall32 = new Wall("F");
        addObject(wall32,this.getRealX(3),this.getRealY(8));
        Wall wall33 = new Wall("F");
        addObject(wall33,this.getRealX(3),this.getRealY(9));
        Wall wall34 = new Wall("F");
        addObject(wall34,this.getRealX(3),this.getRealY(10));
        Wall wall35 = new Wall("F");
        addObject(wall35,this.getRealX(3),this.getRealY(11));
        Wall wall36 = new Wall("F");
        addObject(wall36,this.getRealX(3),this.getRealY(12));
        Wall wall37 = new Wall("F");
        addObject(wall37,this.getRealX(4),this.getRealY(4));
        Wall wall38 = new Wall("F");
        addObject(wall38,this.getRealX(4),this.getRealY(5));
        Wall wall39 = new Wall("F");
        addObject(wall39,this.getRealX(4),this.getRealY(6));
        Wall wall40 = new Wall("F");
        addObject(wall40,this.getRealX(4),this.getRealY(12));
        Wall wall41 = new Wall("F");
        addObject(wall41,this.getRealX(5),this.getRealY(4));
        Wall wall42 = new Wall("F");
        addObject(wall42,this.getRealX(5),this.getRealY(5));
        Wall wall43 = new Wall("F");
        addObject(wall43,this.getRealX(5),this.getRealY(6));
        Wall wall44 = new Wall("F");
        addObject(wall44,this.getRealX(5),this.getRealY(8));
        Wall wall45 = new Wall("F");
        addObject(wall45,this.getRealX(5),this.getRealY(9));
        Wall wall46 = new Wall("F");
        addObject(wall46,this.getRealX(5),this.getRealY(11));
        Wall wall47 = new Wall("F");
        addObject(wall47,this.getRealX(5),this.getRealY(12));
        Wall wall48 = new Wall("F");
        addObject(wall48,this.getRealX(6),this.getRealY(4));
        Wall wall49 = new Wall("F");
        addObject(wall49,this.getRealX(6),this.getRealY(6));
        Wall wall50 = new Wall("F");
        addObject(wall50,this.getRealX(6),this.getRealY(7));
        Wall wall51 = new Wall("F");
        addObject(wall51,this.getRealX(6),this.getRealY(8));
        Wall wall52 = new Wall("F");
        addObject(wall52,this.getRealX(6),this.getRealY(9));
        Wall wall53 = new Wall("F");
        addObject(wall53,this.getRealX(6),this.getRealY(11));
        Wall wall54 = new Wall("F");
        addObject(wall54,this.getRealX(6),this.getRealY(12));
        Wall wall55 = new Wall("F");
        addObject(wall55,this.getRealX(7),this.getRealY(4));
        Wall wall56 = new Wall("F");
        addObject(wall56,this.getRealX(7),this.getRealY(8));
        Wall wall57 = new Wall("F");
        addObject(wall57,this.getRealX(7),this.getRealY(9));
        Wall wall58 = new Wall("F");
        addObject(wall58,this.getRealX(7),this.getRealY(11));
        Wall wall59 = new Wall("F");
        addObject(wall59,this.getRealX(7),this.getRealY(12));
        Wall wall60 = new Wall("F");
        addObject(wall60,this.getRealX(8),this.getRealY(4));
        Wall wall61 = new Wall("F");
        addObject(wall61,this.getRealX(8),this.getRealY(5));
        Wall wall62 = new Wall("F");
        addObject(wall62,this.getRealX(8),this.getRealY(6));
        Wall wall63 = new Wall("F");
        addObject(wall63,this.getRealX(8),this.getRealY(8));
        Wall wall64 = new Wall("F");
        addObject(wall64,this.getRealX(8),this.getRealY(9));
        Wall wall65 = new Wall("F");
        addObject(wall65,this.getRealX(8),this.getRealY(11));
        Wall wall66 = new Wall("F");
        addObject(wall66,this.getRealX(8),this.getRealY(12));
        Wall wall67 = new Wall("F");
        addObject(wall67,this.getRealX(9),this.getRealY(4));
        Wall wall68 = new Wall("F");
        addObject(wall68,this.getRealX(9),this.getRealY(11));
        Wall wall69 = new Wall("F");
        addObject(wall69,this.getRealX(9),this.getRealY(12));
        Wall wall70 = new Wall("F");
        addObject(wall70,this.getRealX(10),this.getRealY(4));
        Wall wall71 = new Wall("F");
        addObject(wall71,this.getRealX(10),this.getRealY(5));
        Wall wall72 = new Wall("F");
        addObject(wall72,this.getRealX(10),this.getRealY(6));
        Wall wall73 = new Wall("F");
        addObject(wall73,this.getRealX(10),this.getRealY(7));
        Wall wall74 = new Wall("F");
        addObject(wall74,this.getRealX(10),this.getRealY(8));
        Wall wall75 = new Wall("F");
        addObject(wall75,this.getRealX(10),this.getRealY(9));
        Wall wall76 = new Wall("F");
        addObject(wall76,this.getRealX(10),this.getRealY(11));
        Wall wall77 = new Wall("F");
        addObject(wall77,this.getRealX(10),this.getRealY(12));
        Wall wall78 = new Wall("F");
        addObject(wall78,this.getRealX(11),this.getRealY(4));
        Wall wall79 = new Wall("F");
        addObject(wall79,this.getRealX(11),this.getRealY(5));
        Wall wall80 = new Wall("F");
        addObject(wall80,this.getRealX(11),this.getRealY(6));
        Wall wall81 = new Wall("F");
        addObject(wall81,this.getRealX(11),this.getRealY(7));
        Wall wall82 = new Wall("F");
        addObject(wall82,this.getRealX(11),this.getRealY(8));
        Wall wall83 = new Wall("F");
        addObject(wall83,this.getRealX(11),this.getRealY(9));
        Wall wall84 = new Wall("F");
        addObject(wall84,this.getRealX(11),this.getRealY(10));
        Wall wall85 = new Wall("F");
        addObject(wall85,this.getRealX(11),this.getRealY(11));
        Wall wall86 = new Wall("F");
        addObject(wall86,this.getRealX(11),this.getRealY(12));
        String[] firstPage = new String[]{"Bei diesem Level handelt es sich um ein","einfaches Labyrinth.","","Ziel ist es, die Figur geschickt zum Token zu bringen.","Das Token verändert bei jedem Versuch seine Position."};
        String[] secondPage = new String[]{"Tipp 1:","Nutze auch hier eine doppelte Schleife."};
        String[] thirdPage = new String[]{"Tipp 2:","Die eine Schleife soll prüfen, ob man das Token","erreicht hat.","Die Andere soll die Figur bis zum Ende eines Ganges","laufen lassen."};
        String[] fourthPage = new String[]{"Tipp 3:","Wenn das Ende eines Ganges erreicht ist, so","soll sich die Figur umschauen.","Falls links von ihr Platz ist, soll sie dort entlang","gehen, anderenfalls soll sie rechts nachschauen."};
        String[] fifthPage = new String[]{"Tipp 4:","Falls auch rechts kein weiterer Weg vorhanden ist,","so hat die Figur eine Sackgasse erreicht und soll sich","umdrehen."};
        String wm = "+20 EXP\n\nWow! Schaffst du auch ein komplizierteres Labyrinth?";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage},new Spieler[]{player1},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }

    public void prepareC04L10() {
        int k = (int)(Math.random()*6);
        Item i0 = new Item();
        if (k == 0) {
            addObject(i0,this.getRealX(7),this.getRealY(5));
        } else if (k == 1) {
            addObject(i0,this.getRealX(3),this.getRealY(5));
        } else if (k == 2) {
            addObject(i0,this.getRealX(2),this.getRealY(13));
        } else if (k == 3) {
            addObject(i0,this.getRealX(8),this.getRealY(13));
        } else if (k == 4) {
            addObject(i0,this.getRealX(5),this.getRealY(5));
        } else if (k == 5) {
            addObject(i0,this.getRealX(9),this.getRealY(8));
        }
        
        
        Spieler player1 = new Spieler(this.loadCharacter());
        addObject(player1,this.getRealX(3),this.getRealY(7));
        player1.setRotation(90);
        Wall wall2 = new Wall("F");
        addObject(wall2,this.getRealX(0),this.getRealY(4));
        Wall wall3 = new Wall("F");
        addObject(wall3,this.getRealX(1),this.getRealY(4));
        Wall wall4 = new Wall("F");
        addObject(wall4,this.getRealX(2),this.getRealY(4));
        Wall wall5 = new Wall("F");
        addObject(wall5,this.getRealX(3),this.getRealY(4));
        Wall wall6 = new Wall("F");
        addObject(wall6,this.getRealX(4),this.getRealY(4));
        Wall wall7 = new Wall("F");
        addObject(wall7,this.getRealX(5),this.getRealY(4));
        Wall wall8 = new Wall("F");
        addObject(wall8,this.getRealX(6),this.getRealY(4));
        Wall wall9 = new Wall("F");
        addObject(wall9,this.getRealX(7),this.getRealY(4));
        Wall wall10 = new Wall("F");
        addObject(wall10,this.getRealX(8),this.getRealY(4));
        Wall wall11 = new Wall("F");
        addObject(wall11,this.getRealX(9),this.getRealY(4));
        Wall wall12 = new Wall("F");
        addObject(wall12,this.getRealX(10),this.getRealY(4));
        Wall wall13 = new Wall("F");
        addObject(wall13,this.getRealX(0),this.getRealY(5));
        Wall wall14 = new Wall("F");
        addObject(wall14,this.getRealX(4),this.getRealY(5));
        Wall wall15 = new Wall("F");
        addObject(wall15,this.getRealX(6),this.getRealY(5));
        Wall wall16 = new Wall("F");
        addObject(wall16,this.getRealX(8),this.getRealY(5));
        Wall wall17 = new Wall("F");
        addObject(wall17,this.getRealX(10),this.getRealY(5));
        Wall wall18 = new Wall("F");
        addObject(wall18,this.getRealX(0),this.getRealY(6));
        Wall wall19 = new Wall("F");
        addObject(wall19,this.getRealX(2),this.getRealY(6));
        Wall wall20 = new Wall("F");
        addObject(wall20,this.getRealX(3),this.getRealY(6));
        Wall wall21 = new Wall("F");
        addObject(wall21,this.getRealX(4),this.getRealY(6));
        Wall wall22 = new Wall("F");
        addObject(wall22,this.getRealX(6),this.getRealY(6));
        Wall wall23 = new Wall("F");
        addObject(wall23,this.getRealX(10),this.getRealY(6));
        Wall wall24 = new Wall("F");
        addObject(wall24,this.getRealX(0),this.getRealY(7));
        Wall wall25 = new Wall("F");
        addObject(wall25,this.getRealX(2),this.getRealY(7));
        Wall wall26 = new Wall("F");
        addObject(wall26,this.getRealX(4),this.getRealY(7));
        Wall wall27 = new Wall("F");
        addObject(wall27,this.getRealX(6),this.getRealY(7));
        Wall wall28 = new Wall("F");
        addObject(wall28,this.getRealX(7),this.getRealY(7));
        Wall wall29 = new Wall("F");
        addObject(wall29,this.getRealX(9),this.getRealY(7));
        Wall wall30 = new Wall("F");
        addObject(wall30,this.getRealX(10),this.getRealY(7));
        Wall wall31 = new Wall("F");
        addObject(wall31,this.getRealX(0),this.getRealY(8));
        Wall wall32 = new Wall("F");
        addObject(wall32,this.getRealX(10),this.getRealY(8));
        Wall wall33 = new Wall("F");
        addObject(wall33,this.getRealX(0),this.getRealY(9));
        Wall wall34 = new Wall("F");
        addObject(wall34,this.getRealX(2),this.getRealY(9));
        Wall wall35 = new Wall("F");
        addObject(wall35,this.getRealX(3),this.getRealY(9));
        Wall wall36 = new Wall("F");
        addObject(wall36,this.getRealX(4),this.getRealY(9));
        Wall wall37 = new Wall("F");
        addObject(wall37,this.getRealX(6),this.getRealY(9));
        Wall wall38 = new Wall("F");
        addObject(wall38,this.getRealX(7),this.getRealY(9));
        Wall wall39 = new Wall("F");
        addObject(wall39,this.getRealX(9),this.getRealY(9));
        Wall wall40 = new Wall("F");
        addObject(wall40,this.getRealX(10),this.getRealY(9));
        Wall wall41 = new Wall("F");
        addObject(wall41,this.getRealX(0),this.getRealY(10));
        Wall wall42 = new Wall("F");
        addObject(wall42,this.getRealX(2),this.getRealY(10));
        Wall wall43 = new Wall("F");
        addObject(wall43,this.getRealX(4),this.getRealY(10));
        Wall wall44 = new Wall("F");
        addObject(wall44,this.getRealX(10),this.getRealY(10));
        Wall wall45 = new Wall("F");
        addObject(wall45,this.getRealX(0),this.getRealY(11));
        Wall wall46 = new Wall("F");
        addObject(wall46,this.getRealX(6),this.getRealY(11));
        Wall wall47 = new Wall("F");
        addObject(wall47,this.getRealX(7),this.getRealY(11));
        Wall wall48 = new Wall("F");
        addObject(wall48,this.getRealX(8),this.getRealY(11));
        Wall wall49 = new Wall("F");
        addObject(wall49,this.getRealX(10),this.getRealY(11));
        Wall wall50 = new Wall("F");
        addObject(wall50,this.getRealX(0),this.getRealY(12));
        Wall wall51 = new Wall("F");
        addObject(wall51,this.getRealX(2),this.getRealY(12));
        Wall wall52 = new Wall("F");
        addObject(wall52,this.getRealX(3),this.getRealY(12));
        Wall wall53 = new Wall("F");
        addObject(wall53,this.getRealX(4),this.getRealY(12));
        Wall wall54 = new Wall("F");
        addObject(wall54,this.getRealX(6),this.getRealY(12));
        Wall wall55 = new Wall("F");
        addObject(wall55,this.getRealX(7),this.getRealY(12));
        Wall wall56 = new Wall("F");
        addObject(wall56,this.getRealX(10),this.getRealY(12));
        Wall wall57 = new Wall("F");
        addObject(wall57,this.getRealX(0),this.getRealY(13));
        Wall wall58 = new Wall("F");
        addObject(wall58,this.getRealX(3),this.getRealY(13));
        Wall wall59 = new Wall("F");
        addObject(wall59,this.getRealX(7),this.getRealY(13));
        Wall wall60 = new Wall("F");
        addObject(wall60,this.getRealX(9),this.getRealY(13));
        Wall wall61 = new Wall("F");
        addObject(wall61,this.getRealX(10),this.getRealY(13));
        Wall wall62 = new Wall("F");
        addObject(wall62,this.getRealX(0),this.getRealY(14));
        Wall wall63 = new Wall("F");
        addObject(wall63,this.getRealX(1),this.getRealY(14));
        Wall wall64 = new Wall("F");
        addObject(wall64,this.getRealX(2),this.getRealY(14));
        Wall wall65 = new Wall("F");
        addObject(wall65,this.getRealX(3),this.getRealY(14));
        Wall wall66 = new Wall("F");
        addObject(wall66,this.getRealX(4),this.getRealY(14));
        Wall wall67 = new Wall("F");
        addObject(wall67,this.getRealX(5),this.getRealY(14));
        Wall wall68 = new Wall("F");
        addObject(wall68,this.getRealX(6),this.getRealY(14));
        Wall wall69 = new Wall("F");
        addObject(wall69,this.getRealX(7),this.getRealY(14));
        Wall wall70 = new Wall("F");
        addObject(wall70,this.getRealX(8),this.getRealY(14));
        Wall wall71 = new Wall("F");
        addObject(wall71,this.getRealX(9),this.getRealY(14));
        Wall wall72 = new Wall("F");
        addObject(wall72,this.getRealX(10),this.getRealY(14));
        Wall wall73 = new Wall("F");
        addObject(wall73,this.getRealX(3),this.getRealY(10));
        String[] firstPage = new String[]{"Okay, nun kommen wir zu einem wirklich","schweren Labyrinth.","","Ein kleiner Trick zur Lösung mancher Aufgaben","ist es, Wege mit Farbe zu kennzeichnen."};
        String[] secondPage = new String[]{"Anschließend kann man mit den neuen","Bedingungen 'istAufFarbe()' & 'istVorFarbe()'","arbeiten."};
        String[] thirdPage = new String[]{"Eine alternativ Idee wäre es, sich stets an","seiner linken Wand zu orientieren und diese","praktisch entlang zu laufen."};
        String wm = "+30 EXP\n\nDas war ziemlich beeindruckend!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage},new Spieler[]{player1},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L01() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FOLNW");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FSH");
        addObject(wall11,this.getRealX(1),this.getRealY(6));
        Wall wall12 = new Wall("FSH");
        addObject(wall12,this.getRealX(2),this.getRealY(6));
        Wall wall13 = new Wall("FSH");
        addObject(wall13,this.getRealX(3),this.getRealY(6));
        Wall wall14 = new Wall("FSH");
        addObject(wall14,this.getRealX(4),this.getRealY(6));
        Wall wall15 = new Wall("FSH");
        addObject(wall15,this.getRealX(5),this.getRealY(6));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(6),this.getRealY(6));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(7),this.getRealY(6));
        Wall wall18 = new Wall("FOLEN");
        addObject(wall18,this.getRealX(0),this.getRealY(6));
        Wall wall19 = new Wall("FWV");
        addObject(wall19,this.getRealX(0),this.getRealY(5));
        Sphere s20 = new Sphere(1);
        s20.setSecret();
        addObject(s20,this.getRealX(2),this.getRealY(5));
        Platform p21 = new Platform(1);
        p21.setSecret();
        addObject(p21,this.getRealX(6),this.getRealY(5));
        Spieler player22 = new Spieler(this.loadCharacter());
        addObject(player22,this.getRealX(4),this.getRealY(5));
        player22.setRotation(180);
        String[] firstPage = new String[]{"Für dieses Level führen wir","erneut neue Spielelemente hinzu.","","Die Kugel und die Plattform."};
        String[] secondPage = new String[]{"Beides sind feste Elemente,","durch die man nicht durchlaufen kann.","","Die Kugel lässt sich jedoch aufnehmen."};
        String[] thirdPage = new String[]{"Aber Vorsicht:","Die Spielfigur kann nur eine Kugel","tragen.","Falls sie eine andere tragen möchte,","muss sie die aktuelle zuerst ablegen."};
        String[] fourthPage = new String[]{"Sobald eine Plattform im Spiel","ist, ist ein Ziel des Levels, eine Kugel","auf diese zu legen."};
        String[] fifthPage = new String[]{"Die zugehörigen Befehle lauten:","nehmen();    Zum Aufnhemen der Kugel.","hinlegen();    Zum Hinlegen der Kugel."};
        String[] sixthPage = new String[]{"Beide Befehle agieren nur mit","Elementen, die sich direkt vor der","Spielfigur befinden."};
        String wm = "+10 EXP.\n\nGut!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage,sixthPage},new Spieler[]{player22},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L02() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(8),this.getRealY(9));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(8),this.getRealY(10));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(8),this.getRealY(11));
        Wall wall16 = new Wall("FOLNW");
        addObject(wall16,this.getRealX(8),this.getRealY(12));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(1),this.getRealY(12));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(2),this.getRealY(12));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(3),this.getRealY(12));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(4),this.getRealY(12));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(5),this.getRealY(12));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(6),this.getRealY(12));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(7),this.getRealY(12));
        Wall wall24 = new Wall("FOLEN");
        addObject(wall24,this.getRealX(0),this.getRealY(12));
        Wall wall25 = new Wall("FWV");
        addObject(wall25,this.getRealX(0),this.getRealY(5));
        Wall wall26 = new Wall("FWV");
        addObject(wall26,this.getRealX(0),this.getRealY(6));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(7));
        Wall wall28 = new Wall("FWV");
        addObject(wall28,this.getRealX(0),this.getRealY(8));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(9));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(10));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(11));
        Platform p32 = new Platform(1);
        addObject(p32,this.getRealX(4),this.getRealY(6));
        Platform p33 = new Platform(2);
        addObject(p33,this.getRealX(2),this.getRealY(8));
        Sphere s34 = new Sphere(2);
        addObject(s34,this.getRealX(6),this.getRealY(8));
        Sphere s35 = new Sphere(1);
        addObject(s35,this.getRealX(4),this.getRealY(10));
        Spieler player36 = new Spieler(this.loadCharacter());
        addObject(player36,this.getRealX(4),this.getRealY(8));
        player36.setRotation(270);
        String[] firstPage = new String[]{"Plattformen und Kugeln können","auch mit Zahlen versehen sein.","In so einem Fall müssen die passenden","Kugeln auf die Plattformen gelegt","werden."};

        String wm = "+10 EXP\n\nDie Zahlen sprechen dabei keine\nbesondere Reihenfolge an.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},new Spieler[]{player36},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }

    public void prepareC05L03() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(8),this.getRealY(9));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(8),this.getRealY(10));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(8),this.getRealY(11));
        Wall wall16 = new Wall("FOLNW");
        addObject(wall16,this.getRealX(8),this.getRealY(12));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(1),this.getRealY(12));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(2),this.getRealY(12));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(3),this.getRealY(12));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(4),this.getRealY(12));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(5),this.getRealY(12));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(6),this.getRealY(12));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(7),this.getRealY(12));
        Wall wall24 = new Wall("FOLEN");
        addObject(wall24,this.getRealX(0),this.getRealY(12));
        Wall wall25 = new Wall("FWV");
        addObject(wall25,this.getRealX(0),this.getRealY(5));
        Wall wall26 = new Wall("FWV");
        addObject(wall26,this.getRealX(0),this.getRealY(6));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(7));
        Wall wall28 = new Wall("FWV");
        addObject(wall28,this.getRealX(0),this.getRealY(8));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(9));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(10));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(11));
        Platform p32 = new Platform(3);
        
        Sphere s35 = new Sphere(7);
        p32.putSphere(s35);
        addObject(p32,this.getRealX(4),this.getRealY(6));
        Platform p33 = new Platform(7);
        addObject(p33,this.getRealX(6),this.getRealY(8));
        Sphere s34 = new Sphere(3);
        addObject(s34,this.getRealX(2),this.getRealY(8));
        
        Spieler player36 = new Spieler(this.loadCharacter());
        addObject(player36,this.getRealX(4),this.getRealY(8));
        player36.setRotation(0);
        String[] firstPage = new String[]{"Kugeln können natürlich auch","auf falschen Plattformen platziert sein.","","Man kann also Kugeln auch von","Plattformen nehmen."};
        String[] secondPage = new String[]{"In diesem Fall sieht man klar,","dass die eine Kugel zu einer anderen","Plattform gehört."};
        String wm = "+10 EXP\n\nGut!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player36},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L04() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FOLWS");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(9),this.getRealY(5));
        Wall wall11 = new Wall("FTW");
        addObject(wall11,this.getRealX(9),this.getRealY(6));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(9),this.getRealY(7));
        Wall wall13 = new Wall("FTW");
        addObject(wall13,this.getRealX(9),this.getRealY(8));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(9),this.getRealY(9));
        Wall wall15 = new Wall("FTW");
        addObject(wall15,this.getRealX(9),this.getRealY(10));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(9),this.getRealY(11));
        Wall wall17 = new Wall("FTW");
        addObject(wall17,this.getRealX(9),this.getRealY(12));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(9),this.getRealY(13));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(9),this.getRealY(14));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(9),this.getRealY(15));
        Wall wall21 = new Wall("FOLNW");
        addObject(wall21,this.getRealX(9),this.getRealY(16));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(1),this.getRealY(16));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(2),this.getRealY(16));
        Wall wall24 = new Wall("FTN");
        addObject(wall24,this.getRealX(3),this.getRealY(16));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(4),this.getRealY(16));
        Wall wall26 = new Wall("FTN");
        addObject(wall26,this.getRealX(5),this.getRealY(16));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(6),this.getRealY(16));
        Wall wall28 = new Wall("FTN");
        addObject(wall28,this.getRealX(7),this.getRealY(16));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(8),this.getRealY(16));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(16));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FTE");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FTE");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Wall wall36 = new Wall("FTE");
        addObject(wall36,this.getRealX(0),this.getRealY(10));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(11));
        Wall wall38 = new Wall("FTE");
        addObject(wall38,this.getRealX(0),this.getRealY(12));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(13));
        Wall wall40 = new Wall("FTE");
        addObject(wall40,this.getRealX(0),this.getRealY(14));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(15));
        Item i42 = new Item();
        addObject(i42,this.getRealX(3),this.getRealY(7));
        Item i43 = new Item();
        addObject(i43,this.getRealX(6),this.getRealY(7));
        Item i44 = new Item();
        addObject(i44,this.getRealX(2),this.getRealY(11));
        Item i45 = new Item();
        addObject(i45,this.getRealX(7),this.getRealY(11));
        Item i46 = new Item();
        addObject(i46,this.getRealX(4),this.getRealY(15));
        Item i47 = new Item();
        addObject(i47,this.getRealX(8),this.getRealY(15));
        Checkpoint c48 = new Checkpoint(0);
        addObject(c48,this.getRealX(8),this.getRealY(5));
        Checkpoint c49 = new Checkpoint(0);
        addObject(c49,this.getRealX(8),this.getRealY(9));
        Checkpoint c50 = new Checkpoint(0);
        addObject(c50,this.getRealX(8),this.getRealY(13));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(1),this.getRealY(8));
        Wall wall52 = new Wall("TN");
        addObject(wall52,this.getRealX(2),this.getRealY(8));
        Wall wall53 = new Wall("H");
        addObject(wall53,this.getRealX(3),this.getRealY(8));
        Wall wall54 = new Wall("TN");
        addObject(wall54,this.getRealX(4),this.getRealY(8));
        Wall wall55 = new Wall("TN");
        addObject(wall55,this.getRealX(5),this.getRealY(8));
        Wall wall56 = new Wall("H");
        addObject(wall56,this.getRealX(6),this.getRealY(8));
        Wall wall57 = new Wall("TN");
        addObject(wall57,this.getRealX(7),this.getRealY(8));
        Wall wall58 = new Wall("H");
        addObject(wall58,this.getRealX(8),this.getRealY(8));
        Wall wall59 = new Wall("TN");
        addObject(wall59,this.getRealX(1),this.getRealY(12));
        Wall wall60 = new Wall("H");
        addObject(wall60,this.getRealX(2),this.getRealY(12));
        Wall wall61 = new Wall("TN");
        addObject(wall61,this.getRealX(3),this.getRealY(12));
        Wall wall62 = new Wall("H");
        addObject(wall62,this.getRealX(4),this.getRealY(12));
        Wall wall63 = new Wall("H");
        addObject(wall63,this.getRealX(5),this.getRealY(12));
        Wall wall64 = new Wall("TN");
        addObject(wall64,this.getRealX(6),this.getRealY(12));
        Wall wall65 = new Wall("H");
        addObject(wall65,this.getRealX(7),this.getRealY(12));
        Wall wall66 = new Wall("TN");
        addObject(wall66,this.getRealX(8),this.getRealY(12));
        
        Wall wall68 = new Wall("H");
        addObject(wall68,this.getRealX(1),this.getRealY(6));
        Wall wall69 = new Wall("H");
        addObject(wall69,this.getRealX(8),this.getRealY(6));
        Wall wall70 = new Wall("H");
        addObject(wall70,this.getRealX(4),this.getRealY(10));
        Wall wall71 = new Wall("H");
        addObject(wall71,this.getRealX(5),this.getRealY(10));
        Wall wall72 = new Wall("H");
        addObject(wall72,this.getRealX(1),this.getRealY(14));
        Wall wall73 = new Wall("H");
        addObject(wall73,this.getRealX(2),this.getRealY(14));
        Wall wall74 = new Wall("H");
        addObject(wall74,this.getRealX(6),this.getRealY(14));
        Wall wall75 = new Wall("V");
        addObject(wall75,this.getRealX(2),this.getRealY(7));
        Wall wall76 = new Wall("V");
        addObject(wall76,this.getRealX(4),this.getRealY(7));
        Wall wall77 = new Wall("V");
        addObject(wall77,this.getRealX(5),this.getRealY(7));
        Wall wall78 = new Wall("V");
        addObject(wall78,this.getRealX(7),this.getRealY(7));
        Wall wall79 = new Wall("V");
        addObject(wall79,this.getRealX(1),this.getRealY(11));
        Wall wall80 = new Wall("V");
        addObject(wall80,this.getRealX(3),this.getRealY(11));
        Wall wall81 = new Wall("V");
        addObject(wall81,this.getRealX(6),this.getRealY(11));
        Wall wall82 = new Wall("V");
        addObject(wall82,this.getRealX(8),this.getRealY(11));
        Wall wall83 = new Wall("V");
        addObject(wall83,this.getRealX(3),this.getRealY(15));
        Wall wall84 = new Wall("V");
        addObject(wall84,this.getRealX(5),this.getRealY(15));
        Wall wall85 = new Wall("V");
        addObject(wall85,this.getRealX(7),this.getRealY(15));
        
        Wall wall86 = new Wall("LWS");
        addObject(wall86,this.getRealX(2),this.getRealY(6));
        Wall wall87 = new Wall("LWS");
        addObject(wall87,this.getRealX(5),this.getRealY(6));
        Wall wall88 = new Wall("LSE");
        addObject(wall88,this.getRealX(4),this.getRealY(6));
        Wall wall89 = new Wall("LSE");
        addObject(wall89,this.getRealX(7),this.getRealY(6));
        
        Wall wall90 = new Wall("LWS");
        addObject(wall90,this.getRealX(1),this.getRealY(10));
        Wall wall91 = new Wall("LWS");
        addObject(wall91,this.getRealX(6),this.getRealY(10));
        Wall wall92 = new Wall("LSE");
        addObject(wall92,this.getRealX(3),this.getRealY(10));
        Wall wall93 = new Wall("LSE");
        addObject(wall93,this.getRealX(8),this.getRealY(10));
        
        Wall wall94 = new Wall("LWS");
        addObject(wall94,this.getRealX(3),this.getRealY(14));
        Wall wall95 = new Wall("LWS");
        addObject(wall95,this.getRealX(7),this.getRealY(14));
        Wall wall96 = new Wall("LSE");
        addObject(wall96,this.getRealX(5),this.getRealY(14));
        
        Spieler player97 = new Spieler(this.loadCharacter());
        addObject(player97,this.getRealX(1),this.getRealY(5));
        player97.setRotation(0);
        Spieler player98 = new Spieler(this.loadCharacter());
        addObject(player98,this.getRealX(1),this.getRealY(9));
        player98.setRotation(0);
        Spieler player99 = new Spieler(this.loadCharacter());
        addObject(player99,this.getRealX(1),this.getRealY(13));
        player99.setRotation(0);
        
        String[] firstPage = new String[]{"Kommen wir erneut zu einem neuem","Konzept der Programmierung:","","Boolsche Funktionen"}; 
        String[] secondPage = new String[]{"Wie bei Prozeduren können wir","unser Programm damit erweitern.","","Statt dabei neue Befehle hinzuzufügen,","fügen wir neue Bedingungen hinzu."};
        String[] thirdPage = new String[]{"Dabei müssen wir genau definieren,","wann unsere Funktion 'wahr' oder 'falsch'","zurückgeben soll."};
        String[] fourthPage = new String[]{"In Java erreichen wir dies über","die Verwendung von:","    return true;     //Rückgabe wahr","    return false;    //Rückgabe falsch"};
        String[] fifthPage = new String[]{"Syntax:","public boolean funktionsName() {","//Hier steht, was überprüft werden soll","//Und irgendwo zwischendrin die Rückgaben","}"};
        String[] sixthPage = new String[]{"In eher wenigen Fällen möchten","wir, dass diese Funktionen den Zustand","der Figur verändern."};
        String[] seventhPage = new String[]{"Das heißt, wir möchten, dass die","Figur nach Ausführung der Funktion wieder","da steht und dorthin schaut, wie sie es","vorher getan hat."};
        String[] eigthPage = new String[]{"Kümmern wir uns mal um dieses","Level und schauen, wie nützlich so eine","Funktion sein kann."};
        String[] ninthPage = new String[]{"Unsere Figur soll geradeaus bis zum","Checkpoint laufen.","","Falls rechts keine Wand ist, soll sie darin das","Token aufheben."};
        String[] tenthPage = new String[]{"Dieses 'rechts keine Wand' wollen","wir als eigene Bedingung in einer Funktion","formulieren."};
        String[] eleventhPage = new String[]{"public boolean rechtsFrei() {","    rechtsDrehen()","    if (istVorWand()) {","        linksDrehen();","        return false;"};
        String[] twelthPage = new String[]{"    } else {","        linksDrehen();","        return true;","    }","}"};
        String[] thirteenthPage = new String[]{"Nun kann man diese Bedingung","in Abfragen oder Schleifen verwenden.","","if (rechtsFrei()) {","    //..."};
        String wm = "+10 EXP\nSehr gut!\nMit Funktionen kann man Schreibaufwand\nreduzieren und das Programm logischer\naufteilen.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage, thirdPage, fourthPage,fifthPage,sixthPage,seventhPage,eigthPage,ninthPage,tenthPage,eleventhPage,twelthPage,thirteenthPage},new Spieler[]{player97, player98, player99},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L05() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FTS");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FOLWS");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(10),this.getRealY(5));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(10),this.getRealY(6));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(10),this.getRealY(7));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(10),this.getRealY(8));
        Wall wall15 = new Wall("FTW");
        addObject(wall15,this.getRealX(10),this.getRealY(9));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(10),this.getRealY(10));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(10),this.getRealY(11));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(10),this.getRealY(12));
        Wall wall19 = new Wall("FOLNW");
        addObject(wall19,this.getRealX(10),this.getRealY(13));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(1),this.getRealY(13));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(2),this.getRealY(13));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(3),this.getRealY(13));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(4),this.getRealY(13));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(5),this.getRealY(13));
        Wall wall25 = new Wall("FTN");
        addObject(wall25,this.getRealX(6),this.getRealY(13));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(7),this.getRealY(13));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(8),this.getRealY(13));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(9),this.getRealY(13));
        Wall wall29 = new Wall("FOLEN");
        addObject(wall29,this.getRealX(0),this.getRealY(13));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(5));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(6));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(7));
        Wall wall33 = new Wall("FTE");
        addObject(wall33,this.getRealX(0),this.getRealY(8));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(9));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(10));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(11));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(12));
        Item i38 = new Item();
        addObject(i38,this.getRealX(2),this.getRealY(6));
        Item i39 = new Item();
        addObject(i39,this.getRealX(2),this.getRealY(7));
        Item i40 = new Item();
        addObject(i40,this.getRealX(3),this.getRealY(5));
        Item i41 = new Item();
        addObject(i41,this.getRealX(4),this.getRealY(6));
        Item i42 = new Item();
        addObject(i42,this.getRealX(7),this.getRealY(6));
        Item i43 = new Item();
        addObject(i43,this.getRealX(8),this.getRealY(7));
        Item i44 = new Item();
        addObject(i44,this.getRealX(9),this.getRealY(6));
        Item i45 = new Item();
        addObject(i45,this.getRealX(2),this.getRealY(9));
        Item i46 = new Item();
        addObject(i46,this.getRealX(2),this.getRealY(10));
        Item i47 = new Item();
        addObject(i47,this.getRealX(3),this.getRealY(10));
        Item i48 = new Item();
        addObject(i48,this.getRealX(4),this.getRealY(11));
        Item i49 = new Item();
        addObject(i49,this.getRealX(2),this.getRealY(12));
        Item i50 = new Item();
        addObject(i50,this.getRealX(7),this.getRealY(10));
        Item i51 = new Item();
        addObject(i51,this.getRealX(7),this.getRealY(12));
        Item i52 = new Item();
        addObject(i52,this.getRealX(8),this.getRealY(11));
        Item i53 = new Item();
        addObject(i53,this.getRealX(9),this.getRealY(12));
        Wall wall54 = new Wall("H");
        addObject(wall54,this.getRealX(1),this.getRealY(8));
        Wall wall55 = new Wall("H");
        addObject(wall55,this.getRealX(2),this.getRealY(8));
        Wall wall56 = new Wall("H");
        addObject(wall56,this.getRealX(3),this.getRealY(8));
        Wall wall57 = new Wall("H");
        addObject(wall57,this.getRealX(4),this.getRealY(8));
        Wall wall58 = new Wall("TN");
        addObject(wall58,this.getRealX(5),this.getRealY(8));
        Wall wall59 = new Wall("LWS");
        addObject(wall59,this.getRealX(6),this.getRealY(8));
        Wall wall60 = new Wall("TE");
        addObject(wall60,this.getRealX(6),this.getRealY(9));
        Wall wall61 = new Wall("H");
        addObject(wall61,this.getRealX(7),this.getRealY(9));
        Wall wall62 = new Wall("H");
        addObject(wall62,this.getRealX(8),this.getRealY(9));
        Wall wall63 = new Wall("H");
        addObject(wall63,this.getRealX(9),this.getRealY(9));
        Wall wall64 = new Wall("V");
        addObject(wall64,this.getRealX(5),this.getRealY(5));
        Wall wall65 = new Wall("V");
        addObject(wall65,this.getRealX(5),this.getRealY(6));
        Wall wall66 = new Wall("V");
        addObject(wall66,this.getRealX(5),this.getRealY(7));
        Wall wall67 = new Wall("V");
        addObject(wall67,this.getRealX(6),this.getRealY(10));
        Wall wall68 = new Wall("V");
        addObject(wall68,this.getRealX(6),this.getRealY(11));
        Wall wall69 = new Wall("V");
        addObject(wall69,this.getRealX(6),this.getRealY(12));
        Spieler player70 = new Spieler(this.loadCharacter());
        addObject(player70,this.getRealX(1),this.getRealY(5));
        player70.setRotation(0);
        Spieler player71 = new Spieler(this.loadCharacter());
        addObject(player71,this.getRealX(5),this.getRealY(12));
        player71.setRotation(180);
        Spieler player72 = new Spieler(this.loadCharacter());
        addObject(player72,this.getRealX(6),this.getRealY(7));
        player72.setRotation(270);
        Spieler player73 = new Spieler(this.loadCharacter());
        addObject(player73,this.getRealX(9),this.getRealY(10));
        player73.setRotation(90);
        String[] firstPage = new String[]{"In diesem Level erweitern wir unser","Wissen über Schleifen.","","Vielleicht es dir schon einmal passiert, dass deine","Schleife kein Ende gefunden hat."};
        String[] secondPage = new String[]{"Generell verursacht eine Endlosschleife","Schaden und lässt unser Programm nicht","abschließen."};
        String[] thirdPage = new String[]{"Jedoch kann man auch eine vermeintliche","Endlosschleife zur Lösung von Problemen lösen."};
        String[] fourthPage = new String[]{"Eine solche Endlosschleife sieht","folgendermaßen aus:","while(true) {","    //Hier stehen die zu wiederholenden Befehle","}"};
        String[] fifthPage = new String[]{"Um die Schleife jedoch doch irgendwann","beenden zu lassen, nutzen wir einen Befehl","zum Abbruch der Schleife.","","Dieser lautet 'break;' (Ohne Klammern)"};
        String[] sixthPage = new String[]{"In diesem Level möchten wir eine solche","Schleife zusammen mit eigenen Bedingungen","nutzen, die prüfen sollen, ob es noch eine","nächste Reihe gibt."};
        String[] seventhPage = new String[]{"Um es etwas einfacher zu machen:","Die Spielfiguren starten immer so, dass sich die","nächste Reihe rechts von ihnen befindet."};
        String wm = "+10 EXP\n\nSuper! Das Level war schon ziemlich schwer.";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage, thirdPage,fourthPage,fifthPage,sixthPage,seventhPage},new Spieler[]{player70,player71,player72,player73},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L06() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FOLWS");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FEV");
        addObject(wall10,this.getRealX(9),this.getRealY(5));
        Wall wall11 = new Wall("FTW");
        addObject(wall11,this.getRealX(9),this.getRealY(6));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(9),this.getRealY(7));
        Wall wall13 = new Wall("FTW");
        addObject(wall13,this.getRealX(9),this.getRealY(8));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(9),this.getRealY(9));
        Wall wall15 = new Wall("FOLNW");
        addObject(wall15,this.getRealX(9),this.getRealY(10));
        Wall wall16 = new Wall("FSH");
        addObject(wall16,this.getRealX(1),this.getRealY(10));
        Wall wall17 = new Wall("FSH");
        addObject(wall17,this.getRealX(2),this.getRealY(10));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(3),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(4),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(5),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(6),this.getRealY(10));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(7),this.getRealY(10));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(8),this.getRealY(10));
        Wall wall24 = new Wall("FOLEN");
        addObject(wall24,this.getRealX(0),this.getRealY(10));
        Wall wall25 = new Wall("FWV");
        addObject(wall25,this.getRealX(0),this.getRealY(5));
        Wall wall26 = new Wall("FTE");
        addObject(wall26,this.getRealX(0),this.getRealY(6));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(7));
        Wall wall28 = new Wall("FTE");
        addObject(wall28,this.getRealX(0),this.getRealY(8));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(9));
        Wall wall30 = new Wall("H");
        addObject(wall30,this.getRealX(1),this.getRealY(6));
        Wall wall31 = new Wall("H");
        addObject(wall31,this.getRealX(2),this.getRealY(6));
        Wall wall32 = new Wall("H");
        addObject(wall32,this.getRealX(3),this.getRealY(6));
        Wall wall33 = new Wall("H");
        addObject(wall33,this.getRealX(4),this.getRealY(6));
        Wall wall34 = new Wall("H");
        addObject(wall34,this.getRealX(5),this.getRealY(6));
        Wall wall35 = new Wall("H");
        addObject(wall35,this.getRealX(6),this.getRealY(6));
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(7),this.getRealY(6));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(8),this.getRealY(6));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(1),this.getRealY(8));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(2),this.getRealY(8));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(3),this.getRealY(8));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(4),this.getRealY(8));
        Wall wall42 = new Wall("H");
        addObject(wall42,this.getRealX(5),this.getRealY(8));
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(6),this.getRealY(8));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(7),this.getRealY(8));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(8),this.getRealY(8));
        Sphere s30 = new Sphere(1);
        s30.setSecret();
        addObject(s30,this.getRealX(3),this.getRealY(5));
        Sphere s31 = new Sphere(1);
        s31.setSecret();
        addObject(s31,this.getRealX(4),this.getRealY(5));
        Sphere s32 = new Sphere(1);
        s32.setSecret();
        addObject(s32,this.getRealX(5),this.getRealY(5));
        Sphere s33 = new Sphere(1);
        s33.setSecret();
        addObject(s33,this.getRealX(6),this.getRealY(5));
        Sphere s34 = new Sphere(1);
        s34.setSecret();
        addObject(s34,this.getRealX(2),this.getRealY(7));
        Sphere s35 = new Sphere(1);
        s35.setSecret();
        addObject(s35,this.getRealX(4),this.getRealY(7));
        Sphere s36 = new Sphere(1);
        s36.setSecret();
        addObject(s36,this.getRealX(6),this.getRealY(7));
        Sphere s37 = new Sphere(1);
        s37.setSecret();
        addObject(s37,this.getRealX(3),this.getRealY(9));
        Sphere s38 = new Sphere(1);
        s38.setSecret();
        addObject(s38,this.getRealX(1),this.getRealY(9));
        Sphere s39 = new Sphere(1);
        s39.setSecret();
        addObject(s39,this.getRealX(5),this.getRealY(9));
        Sphere s40 = new Sphere(1);
        s40.setSecret();
        addObject(s40,this.getRealX(6),this.getRealY(9));
        Checkpoint c41 = new Checkpoint(0);
        addObject(c41,this.getRealX(8),this.getRealY(5));
        Checkpoint c42 = new Checkpoint(0);
        addObject(c42,this.getRealX(8),this.getRealY(7));
        Checkpoint c43 = new Checkpoint(0);
        addObject(c43,this.getRealX(8),this.getRealY(9));
        Spieler player44 = new Spieler(this.loadCharacter());
        addObject(player44,this.getRealX(2),this.getRealY(5));
        player44.setRotation(0);
        Spieler player45 = new Spieler(this.loadCharacter());
        addObject(player45,this.getRealX(1),this.getRealY(7));
        player45.setRotation(0);
        Spieler player46 = new Spieler(this.loadCharacter());
        addObject(player46,this.getRealX(2),this.getRealY(9));
        player46.setRotation(0);
        String[] firstPage = new String[]{"Kugeln können wie bereits gesagt","auch ein Hindernis darstellen."};
        String[] secondPage = new String[]{"Um dich hier durchzukämpfen","könnte eine Funktion von Nutzen sein,","die prüft, ob hinter deiner Spielfigur Platz","für eine Kugel ist."};
        String[] thirdPage = new String[]{"Hierbei zählen zwei Bedingungen:","1. Befindet sich hinter mir eine Wand?","2. Befindet sich hinter mir eine Kugel?"};
        String[] fourthPage = new String[]{"In der Programmierung gibt es","die Möglichkeit, mehrere Bedingungen","miteinander zu verknüpfen."};
        String[] fifthPage = new String[]{"1. Möglichkeit: UND-Verknüpfung","BEDINGUNG A && BEDINGUNG B","Diese Verknüpfung ist wahr, wenn beide","Bedingungen wahr sind."};
        String[] sixthPage = new String[]{"2. Möglichkeit: ODER-Verknüpfung","BEDINGUNG A || BEDINGUNG B","Diese Verknüpfung ist wahr, wenn die erste","Bedingung und/oder die zweite Bedingung","wahr sind."};
        String[] seventhPage = new String[]{"Wir können also eine Funktion","hintenFrei() schreiben, die prüfen soll, ob","sich hinter dem Spieler KEINE Wand UND","KEINE Kugel befinden."};
        String[] eigthPage = new String[]{"Um zu überprüfen, ob sich eine","Kugel vor der Spielfigur befindet, kann man","die Bedingung 'istVorKugel()' verwenden."};
        String[] ninthPage = new String[]{"Um zu überprüfen, ob die Spielfigur","eine Kugel in der Hand hält, kann man","die Bedingung 'hatKugel()' verwenden."};
        String wm = "+10 EXP\n\nWow. Du schaffst selbst diese schweren\nLevel!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage, fourthPage, fifthPage, sixthPage,seventhPage,eigthPage,ninthPage},new Spieler[]{player44,player45,player46},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L07() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FOLWS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FEV");
        addObject(wall9,this.getRealX(8),this.getRealY(5));
        Wall wall10 = new Wall("FTW");
        addObject(wall10,this.getRealX(8),this.getRealY(6));
        Wall wall11 = new Wall("FEV");
        addObject(wall11,this.getRealX(8),this.getRealY(7));
        Wall wall12 = new Wall("FTW");
        addObject(wall12,this.getRealX(8),this.getRealY(8));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(8),this.getRealY(9));
        Wall wall14 = new Wall("FTW");
        addObject(wall14,this.getRealX(8),this.getRealY(10));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(8),this.getRealY(11));
        Wall wall16 = new Wall("FTW");
        addObject(wall16,this.getRealX(8),this.getRealY(12));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(8),this.getRealY(13));
        Wall wall18 = new Wall("FOLNW");
        addObject(wall18,this.getRealX(8),this.getRealY(14));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(1),this.getRealY(14));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(2),this.getRealY(14));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(3),this.getRealY(14));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(4),this.getRealY(14));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(5),this.getRealY(14));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(6),this.getRealY(14));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(7),this.getRealY(14));
        Wall wall26 = new Wall("FOLEN");
        addObject(wall26,this.getRealX(0),this.getRealY(14));
        Wall wall27 = new Wall("FWV");
        addObject(wall27,this.getRealX(0),this.getRealY(5));
        Wall wall28 = new Wall("FTE");
        addObject(wall28,this.getRealX(0),this.getRealY(6));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(7));
        Wall wall30 = new Wall("FTE");
        addObject(wall30,this.getRealX(0),this.getRealY(8));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(9));
        Wall wall32 = new Wall("FTE");
        addObject(wall32,this.getRealX(0),this.getRealY(10));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(11));
        Wall wall34 = new Wall("FTE");
        addObject(wall34,this.getRealX(0),this.getRealY(12));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(13));
        Outline o36 = new Outline();
        addObject(o36,this.getRealX(2),this.getRealY(5));
        Outline o37 = new Outline();
        addObject(o37,this.getRealX(4),this.getRealY(5));
        Outline o38 = new Outline();
        addObject(o38,this.getRealX(5),this.getRealY(5));
        Outline o39 = new Outline();
        addObject(o39,this.getRealX(6),this.getRealY(5));
        Outline o40 = new Outline();
        o40.setSecret();
        addObject(o40,this.getRealX(7),this.getRealY(5));
        Outline o41 = new Outline();
        addObject(o41,this.getRealX(3),this.getRealY(7));
        Outline o42 = new Outline();
        addObject(o42,this.getRealX(5),this.getRealY(7));
        
        Outline o44 = new Outline();
        addObject(o44,this.getRealX(2),this.getRealY(9));
        Outline o45 = new Outline();
        addObject(o45,this.getRealX(3),this.getRealY(9));
        Outline o46 = new Outline();
        addObject(o46,this.getRealX(4),this.getRealY(9));
        Outline o47 = new Outline();
        addObject(o47,this.getRealX(5),this.getRealY(9));
        Outline o48 = new Outline();
        addObject(o48,this.getRealX(6),this.getRealY(9));
        Outline o49 = new Outline();
        addObject(o49,this.getRealX(2),this.getRealY(11));
        Outline o50 = new Outline();
        addObject(o50,this.getRealX(4),this.getRealY(11));
        Outline o51 = new Outline();
        addObject(o51,this.getRealX(5),this.getRealY(11));
        Outline o52 = new Outline();
        addObject(o52,this.getRealX(6),this.getRealY(11));
        Outline o53 = new Outline();
        o53.setSecret();
        addObject(o53,this.getRealX(7),this.getRealY(11));
        Outline o54 = new Outline();
        addObject(o54,this.getRealX(2),this.getRealY(13));
        Outline o55 = new Outline();
        addObject(o55,this.getRealX(3),this.getRealY(13));
        Outline o56 = new Outline();
        addObject(o56,this.getRealX(6),this.getRealY(13));
        Wall wall57 = new Wall("H");
        addObject(wall57,this.getRealX(1),this.getRealY(6));
        Wall wall58 = new Wall("H");
        addObject(wall58,this.getRealX(2),this.getRealY(6));
        Wall wall59 = new Wall("H");
        addObject(wall59,this.getRealX(3),this.getRealY(6));
        Wall wall60 = new Wall("H");
        addObject(wall60,this.getRealX(4),this.getRealY(6));
        Wall wall61 = new Wall("H");
        addObject(wall61,this.getRealX(5),this.getRealY(6));
        Wall wall62 = new Wall("H");
        addObject(wall62,this.getRealX(6),this.getRealY(6));
        Wall wall63 = new Wall("H");
        addObject(wall63,this.getRealX(7),this.getRealY(6));
        Wall wall64 = new Wall("H");
        addObject(wall64,this.getRealX(1),this.getRealY(8));
        Wall wall65 = new Wall("H");
        addObject(wall65,this.getRealX(2),this.getRealY(8));
        Wall wall66 = new Wall("H");
        addObject(wall66,this.getRealX(3),this.getRealY(8));
        Wall wall67 = new Wall("H");
        addObject(wall67,this.getRealX(4),this.getRealY(8));
        Wall wall68 = new Wall("H");
        addObject(wall68,this.getRealX(5),this.getRealY(8));
        Wall wall69 = new Wall("H");
        addObject(wall69,this.getRealX(6),this.getRealY(8));
        Wall wall70 = new Wall("H");
        addObject(wall70,this.getRealX(7),this.getRealY(8));
        Wall wall71 = new Wall("H");
        addObject(wall71,this.getRealX(1),this.getRealY(10));
        Wall wall72 = new Wall("H");
        addObject(wall72,this.getRealX(2),this.getRealY(10));
        Wall wall73 = new Wall("H");
        addObject(wall73,this.getRealX(3),this.getRealY(10));
        Wall wall74 = new Wall("H");
        addObject(wall74,this.getRealX(4),this.getRealY(10));
        Wall wall75 = new Wall("H");
        addObject(wall75,this.getRealX(5),this.getRealY(10));
        Wall wall76 = new Wall("H");
        addObject(wall76,this.getRealX(6),this.getRealY(10));
        Wall wall77 = new Wall("H");
        addObject(wall77,this.getRealX(7),this.getRealY(10));
        Wall wall78 = new Wall("H");
        addObject(wall78,this.getRealX(1),this.getRealY(12));
        Wall wall79 = new Wall("H");
        addObject(wall79,this.getRealX(2),this.getRealY(12));
        Wall wall80 = new Wall("H");
        addObject(wall80,this.getRealX(3),this.getRealY(12));
        Wall wall81 = new Wall("H");
        addObject(wall81,this.getRealX(4),this.getRealY(12));
        Wall wall82 = new Wall("H");
        addObject(wall82,this.getRealX(5),this.getRealY(12));
        Wall wall83 = new Wall("H");
        addObject(wall83,this.getRealX(6),this.getRealY(12));
        Wall wall84 = new Wall("H");
        addObject(wall84,this.getRealX(7),this.getRealY(12));
        Spieler player85 = new Spieler(this.loadCharacter());
        addObject(player85,this.getRealX(1),this.getRealY(5));
        player85.setOutlineAsOnlyGoal();
        player85.setRotation(0);
        Spieler player86 = new Spieler(this.loadCharacter());
        addObject(player86,this.getRealX(1),this.getRealY(7));
        player86.setOutlineAsOnlyGoal();
        player86.setRotation(0);
        Spieler player87 = new Spieler(this.loadCharacter());
        addObject(player87,this.getRealX(1),this.getRealY(9));
        player87.setOutlineAsOnlyGoal();
        player87.setRotation(0);
        Spieler player88 = new Spieler(this.loadCharacter());
        addObject(player88,this.getRealX(1),this.getRealY(11));
        player88.setOutlineAsOnlyGoal();
        player88.setRotation(0);
        Spieler player89 = new Spieler(this.loadCharacter());
        addObject(player89,this.getRealX(1),this.getRealY(13));
        player89.setOutlineAsOnlyGoal();
        player89.setRotation(0);
        String[] firstPage = new String[]{"In diesem Level geht es um","Mustererkennung."};
        String[] secondPage = new String[]{"Dieses Level beinhaltet ein paar","unsichtbare Markierungen.","","Diese gilt es natürlich auch zu färben."};
        String[] thirdPage = new String[]{"Diese befinden sich auf dem","letzten Feld, falls vorher folgendes","Muster an Markierungen vorliegt:","[M][ ][M][M][M]"};
        String[] fourthPage = new String[]{"Schreibe eine Funktion, die","die Felder auf das Muster überprüft","und das letzte Feld färbt, falls dieses","zutrifft."};
        String[] fifthPage = new String[]{"In diesem Level ist es wieder","nicht erlaubt, Felder zu färben, die keine","Markierung beinhalten."};
        String wm = "+10 EXP\n\nGroßartig!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage,thirdPage,fourthPage,fifthPage},new Spieler[]{player85,player86,player87,player88,player89},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L08() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FTW");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(12),this.getRealY(11));
        Wall wall20 = new Wall("FOLNW");
        addObject(wall20,this.getRealX(12),this.getRealY(12));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(1),this.getRealY(12));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(2),this.getRealY(12));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(3),this.getRealY(12));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(4),this.getRealY(12));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(5),this.getRealY(12));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(6),this.getRealY(12));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(7),this.getRealY(12));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(8),this.getRealY(12));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(9),this.getRealY(12));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(10),this.getRealY(12));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(11),this.getRealY(12));
        Wall wall32 = new Wall("FOLEN");
        addObject(wall32,this.getRealX(0),this.getRealY(12));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(5));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(6));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(7));
        Wall wall36 = new Wall("FTE");
        addObject(wall36,this.getRealX(0),this.getRealY(8));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(9));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(10));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(11));
        Checkpoint c40 = new Checkpoint(0);
        addObject(c40,this.getRealX(2),this.getRealY(6));
        Checkpoint c41 = new Checkpoint(0);
        addObject(c41,this.getRealX(4),this.getRealY(6));
        Checkpoint c42 = new Checkpoint(0);
        addObject(c42,this.getRealX(7),this.getRealY(6));
        Checkpoint c43 = new Checkpoint(0);
        addObject(c43,this.getRealX(3),this.getRealY(10));
        Checkpoint c44 = new Checkpoint(0);
        addObject(c44,this.getRealX(5),this.getRealY(10));
        Checkpoint c45 = new Checkpoint(0);
        addObject(c45,this.getRealX(9),this.getRealY(10));
        Outline o46 = new Outline();
        addObject(o46,this.getRealX(11),this.getRealY(6));
        Outline o47 = new Outline();
        addObject(o47,this.getRealX(11),this.getRealY(10));
        Wall wall48 = new Wall("F");
        addObject(wall48,this.getRealX(3),this.getRealY(6));
        Wall wall49 = new Wall("F");
        addObject(wall49,this.getRealX(5),this.getRealY(6));
        Wall wall50 = new Wall("F");
        addObject(wall50,this.getRealX(6),this.getRealY(6));
        Wall wall51 = new Wall("F");
        addObject(wall51,this.getRealX(8),this.getRealY(6));
        Wall wall52 = new Wall("F");
        addObject(wall52,this.getRealX(9),this.getRealY(6));
        Wall wall53 = new Wall("F");
        addObject(wall53,this.getRealX(10),this.getRealY(6));
        Wall wall54 = new Wall("F");
        addObject(wall54,this.getRealX(2),this.getRealY(10));
        Wall wall55 = new Wall("F");
        addObject(wall55,this.getRealX(6),this.getRealY(10));
        Wall wall56 = new Wall("F");
        addObject(wall56,this.getRealX(7),this.getRealY(10));
        Wall wall57 = new Wall("F");
        addObject(wall57,this.getRealX(10),this.getRealY(10));
        Checkpoint c58 = new Checkpoint(0);
        addObject(c58,this.getRealX(8),this.getRealY(10));
        
        Checkpoint c59 = new Checkpoint(0);
        addObject(c59,this.getRealX(2),this.getRealY(5));
        Checkpoint c60 = new Checkpoint(0);
        addObject(c60,this.getRealX(3),this.getRealY(5));
        Checkpoint c61 = new Checkpoint(0);
        addObject(c61,this.getRealX(4),this.getRealY(5));
        
        Checkpoint c62 = new Checkpoint(0);
        addObject(c62,this.getRealX(4),this.getRealY(7));
        Checkpoint c63 = new Checkpoint(0);
        addObject(c63,this.getRealX(5),this.getRealY(7));
        Checkpoint c64 = new Checkpoint(0);
        addObject(c64,this.getRealX(6),this.getRealY(7));
        Checkpoint c65 = new Checkpoint(0);
        addObject(c65,this.getRealX(7),this.getRealY(7));
        
        Checkpoint c66 = new Checkpoint(0);
        addObject(c66,this.getRealX(7),this.getRealY(5));
        Checkpoint c67 = new Checkpoint(0);
        addObject(c67,this.getRealX(8),this.getRealY(5));
        Checkpoint c68 = new Checkpoint(0);
        addObject(c68,this.getRealX(9),this.getRealY(5));
        Checkpoint c69 = new Checkpoint(0);
        addObject(c69,this.getRealX(10),this.getRealY(5));
        Checkpoint c70 = new Checkpoint(0);
        addObject(c70,this.getRealX(11),this.getRealY(5));
        
        Checkpoint c71 = new Checkpoint(0);
        addObject(c71,this.getRealX(1),this.getRealY(9));
        Checkpoint c72 = new Checkpoint(0);
        addObject(c72,this.getRealX(2),this.getRealY(9));
        Checkpoint c73 = new Checkpoint(0);
        addObject(c73,this.getRealX(3),this.getRealY(9));
        Checkpoint c74 = new Checkpoint(0);
        addObject(c74,this.getRealX(4),this.getRealY(10));
        Checkpoint c75 = new Checkpoint(0);
        addObject(c75,this.getRealX(5),this.getRealY(11));
        
        Checkpoint c76 = new Checkpoint(0);
        addObject(c76,this.getRealX(6),this.getRealY(11));
        Checkpoint c77 = new Checkpoint(0);
        addObject(c77,this.getRealX(7),this.getRealY(11));
        Checkpoint c78 = new Checkpoint(0);
        addObject(c78,this.getRealX(8),this.getRealY(11));
        Checkpoint c79 = new Checkpoint(0);
        addObject(c79,this.getRealX(9),this.getRealY(9));
        Checkpoint c80 = new Checkpoint(0);
        addObject(c80,this.getRealX(10),this.getRealY(9));
        Checkpoint c81= new Checkpoint(0);
        addObject(c81,this.getRealX(11),this.getRealY(9));
        
        Spieler player59 = new Spieler(this.loadCharacter());
        addObject(player59,this.getRealX(1),this.getRealY(6));
        player59.setRotation(0);
        Spieler player60 = new Spieler(this.loadCharacter());
        addObject(player60,this.getRealX(1),this.getRealY(10));
        player60.setRotation(0);
        Wall wall61 = new Wall("H");
        addObject(wall61,this.getRealX(1),this.getRealY(8));
        Wall wall62 = new Wall("H");
        addObject(wall62,this.getRealX(2),this.getRealY(8));
        Wall wall63 = new Wall("H");
        addObject(wall63,this.getRealX(3),this.getRealY(8));
        Wall wall64 = new Wall("H");
        addObject(wall64,this.getRealX(4),this.getRealY(8));
        Wall wall65 = new Wall("H");
        addObject(wall65,this.getRealX(5),this.getRealY(8));
        Wall wall66 = new Wall("H");
        addObject(wall66,this.getRealX(6),this.getRealY(8));
        Wall wall67 = new Wall("H");
        addObject(wall67,this.getRealX(7),this.getRealY(8));
        Wall wall68 = new Wall("H");
        addObject(wall68,this.getRealX(8),this.getRealY(8));
        Wall wall69 = new Wall("H");
        addObject(wall69,this.getRealX(9),this.getRealY(8));
        Wall wall70 = new Wall("H");
        addObject(wall70,this.getRealX(10),this.getRealY(8));
        Wall wall71 = new Wall("H");
        addObject(wall71,this.getRealX(11),this.getRealY(8));
        String[] firstPage = new String[]{"Hier gibt es viele interessante Lösungs-","möglichkeiten.","","Probiere dich ruhig aus und arbeite mit möglichst","vielen Ideen, die du bisher gelernt hast."};
        String wm = "+20 EXP.\n\nGut!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},new Spieler[]{player59,player60},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L09() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FTW");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(12),this.getRealY(11));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(12),this.getRealY(12));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(12),this.getRealY(13));
        Wall wall22 = new Wall("FEV");
        addObject(wall22,this.getRealX(12),this.getRealY(14));
        Wall wall23 = new Wall("FEV");
        addObject(wall23,this.getRealX(12),this.getRealY(15));
        Wall wall24 = new Wall("FOLNW");
        addObject(wall24,this.getRealX(12),this.getRealY(16));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(1),this.getRealY(16));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(2),this.getRealY(16));
        Wall wall27 = new Wall("F");
        addObject(wall27,this.getRealX(3),this.getRealY(16));
        Wall wall28 = new Wall("F");
        addObject(wall28,this.getRealX(4),this.getRealY(16));
        Wall wall29 = new Wall("F");
        addObject(wall29,this.getRealX(5),this.getRealY(16));
        Wall wall30 = new Wall("F");
        addObject(wall30,this.getRealX(6),this.getRealY(16));
        Wall wall31 = new Wall("F");
        addObject(wall31,this.getRealX(7),this.getRealY(16));
        Wall wall32 = new Wall("F");
        addObject(wall32,this.getRealX(8),this.getRealY(16));
        Wall wall33 = new Wall("F");
        addObject(wall33,this.getRealX(9),this.getRealY(16));
        Wall wall34 = new Wall("F");
        addObject(wall34,this.getRealX(10),this.getRealY(16));
        Wall wall35 = new Wall("FSH");
        addObject(wall35,this.getRealX(11),this.getRealY(16));
        Wall wall36 = new Wall("FOLEN");
        addObject(wall36,this.getRealX(0),this.getRealY(16));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(5));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(6));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(7));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(8));
        Wall wall41 = new Wall("FTE");
        addObject(wall41,this.getRealX(0),this.getRealY(9));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(10));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(11));
        Wall wall44 = new Wall("FWV");
        addObject(wall44,this.getRealX(0),this.getRealY(12));
        Wall wall45 = new Wall("FWV");
        addObject(wall45,this.getRealX(0),this.getRealY(13));
        Wall wall46 = new Wall("FWV");
        addObject(wall46,this.getRealX(0),this.getRealY(14));
        Wall wall47 = new Wall("FWV");
        addObject(wall47,this.getRealX(0),this.getRealY(15));
        Outline o48 = new Outline();
        o48.setSecret();
        addObject(o48,this.getRealX(8),this.getRealY(5));
        Outline o49 = new Outline();
        o49.setSecret();
        addObject(o49,this.getRealX(7),this.getRealY(11));
        
        Outline o100 = new Outline();
        addObject(o100,this.getRealX(7),this.getRealY(11));
        Outline o101 = new Outline();
        addObject(o101,this.getRealX(11),this.getRealY(15));
        Outline o102 = new Outline();
        addObject(o102,this.getRealX(2),this.getRealY(15));
        
        Outline o103 = new Outline();
        addObject(o103,this.getRealX(8),this.getRealY(5));
        Outline o104 = new Outline();
        addObject(o104,this.getRealX(11),this.getRealY(8));
        Outline o105 = new Outline();
        addObject(o105,this.getRealX(3),this.getRealY(8));
        
        
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(1),this.getRealY(9));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(2),this.getRealY(9));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(3),this.getRealY(9));
        Wall wall53 = new Wall("FNH");
        addObject(wall53,this.getRealX(4),this.getRealY(9));
        Wall wall54 = new Wall("FNH");
        addObject(wall54,this.getRealX(5),this.getRealY(9));
        Wall wall55 = new Wall("FNH");
        addObject(wall55,this.getRealX(6),this.getRealY(9));
        Wall wall56 = new Wall("FNH");
        addObject(wall56,this.getRealX(7),this.getRealY(9));
        Wall wall57 = new Wall("FNH");
        addObject(wall57,this.getRealX(8),this.getRealY(9));
        Wall wall58 = new Wall("FNH");
        addObject(wall58,this.getRealX(9),this.getRealY(9));
        Wall wall59 = new Wall("FNH");
        addObject(wall59,this.getRealX(10),this.getRealY(9));
        Wall wall60 = new Wall("H");
        addObject(wall60,this.getRealX(11),this.getRealY(9));
        Wall wall61 = new Wall("F");
        addObject(wall61,this.getRealX(4),this.getRealY(8));
        Wall wall62 = new Wall("F");
        addObject(wall62,this.getRealX(5),this.getRealY(8));
        Wall wall63 = new Wall("F");
        addObject(wall63,this.getRealX(6),this.getRealY(7));
        Wall wall64 = new Wall("F");
        addObject(wall64,this.getRealX(6),this.getRealY(8));
        Wall wall65 = new Wall("F");
        addObject(wall65,this.getRealX(7),this.getRealY(7));
        Wall wall66 = new Wall("F");
        addObject(wall66,this.getRealX(7),this.getRealY(8));
        Wall wall67 = new Wall("F");
        addObject(wall67,this.getRealX(8),this.getRealY(6));
        Wall wall68 = new Wall("F");
        addObject(wall68,this.getRealX(8),this.getRealY(7));
        Wall wall69 = new Wall("F");
        addObject(wall69,this.getRealX(8),this.getRealY(8));
        Wall wall70 = new Wall("F");
        addObject(wall70,this.getRealX(9),this.getRealY(8));
        Wall wall71 = new Wall("F");
        addObject(wall71,this.getRealX(10),this.getRealY(8));
        Wall wall72 = new Wall("F");
        addObject(wall72,this.getRealX(3),this.getRealY(15));
        Wall wall73 = new Wall("F");
        addObject(wall73,this.getRealX(4),this.getRealY(14));
        Wall wall74 = new Wall("F");
        addObject(wall74,this.getRealX(4),this.getRealY(15));
        Wall wall75 = new Wall("F");
        addObject(wall75,this.getRealX(5),this.getRealY(13));
        Wall wall76 = new Wall("F");
        addObject(wall76,this.getRealX(5),this.getRealY(14));
        Wall wall77 = new Wall("F");
        addObject(wall77,this.getRealX(5),this.getRealY(15));
        Wall wall78 = new Wall("F");
        addObject(wall78,this.getRealX(6),this.getRealY(13));
        Wall wall79 = new Wall("F");
        addObject(wall79,this.getRealX(6),this.getRealY(14));
        Wall wall80 = new Wall("F");
        addObject(wall80,this.getRealX(6),this.getRealY(15));
        Wall wall81 = new Wall("F");
        addObject(wall81,this.getRealX(7),this.getRealY(12));
        Wall wall82 = new Wall("F");
        addObject(wall82,this.getRealX(7),this.getRealY(13));
        Wall wall83 = new Wall("F");
        addObject(wall83,this.getRealX(7),this.getRealY(14));
        Wall wall84 = new Wall("F");
        addObject(wall84,this.getRealX(7),this.getRealY(15));
        Wall wall85 = new Wall("F");
        addObject(wall85,this.getRealX(8),this.getRealY(13));
        Wall wall86 = new Wall("F");
        addObject(wall86,this.getRealX(8),this.getRealY(14));
        Wall wall87 = new Wall("F");
        addObject(wall87,this.getRealX(8),this.getRealY(15));
        Wall wall88 = new Wall("F");
        addObject(wall88,this.getRealX(9),this.getRealY(13));
        Wall wall89 = new Wall("F");
        addObject(wall89,this.getRealX(9),this.getRealY(14));
        Wall wall90 = new Wall("F");
        addObject(wall90,this.getRealX(9),this.getRealY(15));
        Wall wall91 = new Wall("F");
        addObject(wall91,this.getRealX(10),this.getRealY(14));
        Wall wall92 = new Wall("F");
        addObject(wall92,this.getRealX(10),this.getRealY(15));
        Spieler player93 = new Spieler(this.loadCharacter());
        addObject(player93,this.getRealX(1),this.getRealY(8));
        player93.setRotation(0);
        player93.setOutlineAsOnlyGoal();
        Spieler player94 = new Spieler(this.loadCharacter());
        addObject(player94,this.getRealX(1),this.getRealY(15));
        player94.setRotation(0);
        player94.setOutlineAsOnlyGoal();
        String[] firstPage = new String[]{"Ziel dieses Levels ist es, die Spitze eines Berges","ausfindig zu machen und diese zu färben.","","Auf der Spitze befindet sich eine unsichtbare Markierung."};

        String wm = "+20 EXP\n\nSuper!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage},new Spieler[]{player93,player94},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC05L10() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FTW");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(12),this.getRealY(11));
        Wall wall20 = new Wall("F");
        addObject(wall20,this.getRealX(12),this.getRealY(12));
        Wall wall21 = new Wall("F");
        addObject(wall21,this.getRealX(12),this.getRealY(13));
        Wall wall22 = new Wall("F");
        addObject(wall22,this.getRealX(12),this.getRealY(14));
        Wall wall23 = new Wall("F");
        addObject(wall23,this.getRealX(12),this.getRealY(15));
        Wall wall24 = new Wall("F");
        addObject(wall24,this.getRealX(12),this.getRealY(16));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(1),this.getRealY(16));
        Wall wall26 = new Wall("F");
        addObject(wall26,this.getRealX(2),this.getRealY(16));
        Wall wall27 = new Wall("F");
        addObject(wall27,this.getRealX(3),this.getRealY(16));
        Wall wall28 = new Wall("F");
        addObject(wall28,this.getRealX(4),this.getRealY(16));
        Wall wall29 = new Wall("F");
        addObject(wall29,this.getRealX(5),this.getRealY(16));
        Wall wall30 = new Wall("F");
        addObject(wall30,this.getRealX(6),this.getRealY(16));
        Wall wall31 = new Wall("F");
        addObject(wall31,this.getRealX(7),this.getRealY(16));
        Wall wall32 = new Wall("F");
        addObject(wall32,this.getRealX(8),this.getRealY(16));
        Wall wall33 = new Wall("F");
        addObject(wall33,this.getRealX(9),this.getRealY(16));
        Wall wall34 = new Wall("F");
        addObject(wall34,this.getRealX(10),this.getRealY(16));
        Wall wall35 = new Wall("F");
        addObject(wall35,this.getRealX(11),this.getRealY(16));
        Wall wall36 = new Wall("FOLEN");
        addObject(wall36,this.getRealX(0),this.getRealY(16));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(5));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(6));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(7));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(8));
        Wall wall41 = new Wall("FTE");
        addObject(wall41,this.getRealX(0),this.getRealY(9));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(10));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(11));
        Wall wall44 = new Wall("FWV");
        addObject(wall44,this.getRealX(0),this.getRealY(12));
        Wall wall45 = new Wall("FWV");
        addObject(wall45,this.getRealX(0),this.getRealY(13));
        Wall wall46 = new Wall("FWV");
        addObject(wall46,this.getRealX(0),this.getRealY(14));
        Wall wall47 = new Wall("FWV");
        addObject(wall47,this.getRealX(0),this.getRealY(15));
        Outline o48 = new Outline();
        //o48.setSecret();
        addObject(o48,this.getRealX(5),this.getRealY(6));
        Outline o49 = new Outline();
        //o49.setSecret();
        addObject(o49,this.getRealX(6),this.getRealY(6));
        Outline o50 = new Outline();
        o50.setSecret();
        addObject(o50,this.getRealX(6),this.getRealY(12));
        Outline o51 = new Outline();
        o51.setSecret();
        addObject(o51,this.getRealX(7),this.getRealY(12));
        Outline o52 = new Outline();
        o52.setSecret();
        addObject(o52,this.getRealX(8),this.getRealY(12));
        Outline o53 = new Outline();
        o53.setSecret();
        addObject(o53,this.getRealX(9),this.getRealY(12));
        Checkpoint c54 = new Checkpoint(0);
        addObject(c54,this.getRealX(11),this.getRealY(8));
        Checkpoint c55 = new Checkpoint(0);
        addObject(c55,this.getRealX(11),this.getRealY(11));
        Wall wall86 = new Wall("H");
        addObject(wall86,this.getRealX(1),this.getRealY(9));
        Wall wall87 = new Wall("FNH");
        addObject(wall87,this.getRealX(2),this.getRealY(9));
        Wall wall88 = new Wall("FNH");
        addObject(wall88,this.getRealX(3),this.getRealY(9));
        Wall wall89 = new Wall("FNH");
        addObject(wall89,this.getRealX(4),this.getRealY(9));
        Wall wall90 = new Wall("FNH");
        addObject(wall90,this.getRealX(5),this.getRealY(9));
        Wall wall91 = new Wall("FNH");
        addObject(wall91,this.getRealX(6),this.getRealY(9));
        Wall wall92 = new Wall("FNH");
        addObject(wall92,this.getRealX(7),this.getRealY(9));
        Wall wall93 = new Wall("FNH");
        addObject(wall93,this.getRealX(8),this.getRealY(9));
        Wall wall94 = new Wall("FNH");
        addObject(wall94,this.getRealX(9),this.getRealY(9));
        Wall wall95 = new Wall("H");
        addObject(wall95,this.getRealX(10),this.getRealY(9));
        Wall wall96 = new Wall("H");
        addObject(wall96,this.getRealX(11),this.getRealY(9));
        Wall wall56 = new Wall("F");
        addObject(wall56,this.getRealX(2),this.getRealY(8));
        Wall wall57 = new Wall("F");
        addObject(wall57,this.getRealX(3),this.getRealY(7));
        Wall wall58 = new Wall("F");
        addObject(wall58,this.getRealX(3),this.getRealY(8));
        Wall wall59 = new Wall("F");
        addObject(wall59,this.getRealX(4),this.getRealY(6));
        Wall wall60 = new Wall("F");
        addObject(wall60,this.getRealX(4),this.getRealY(7));
        Wall wall61 = new Wall("F");
        addObject(wall61,this.getRealX(4),this.getRealY(8));
        Wall wall62 = new Wall("F");
        addObject(wall62,this.getRealX(5),this.getRealY(8));
        Wall wall63 = new Wall("F");
        addObject(wall63,this.getRealX(6),this.getRealY(8));
        Wall wall64 = new Wall("F");
        addObject(wall64,this.getRealX(7),this.getRealY(6));
        Wall wall65 = new Wall("F");
        addObject(wall65,this.getRealX(7),this.getRealY(7));
        Wall wall66 = new Wall("F");
        addObject(wall66,this.getRealX(7),this.getRealY(8));
        Wall wall67 = new Wall("F");
        addObject(wall67,this.getRealX(8),this.getRealY(7));
        Wall wall68 = new Wall("F");
        addObject(wall68,this.getRealX(8),this.getRealY(8));
        Wall wall69 = new Wall("F");
        addObject(wall69,this.getRealX(9),this.getRealY(8));
        Wall wall70 = new Wall("F");
        addObject(wall70,this.getRealX(2),this.getRealY(15));
        Wall wall71 = new Wall("F");
        addObject(wall71,this.getRealX(3),this.getRealY(14));
        Wall wall72 = new Wall("F");
        addObject(wall72,this.getRealX(3),this.getRealY(15));
        
        Wall wall74 = new Wall("F");
        addObject(wall74,this.getRealX(4),this.getRealY(13));
        Wall wall75 = new Wall("F");
        addObject(wall75,this.getRealX(4),this.getRealY(14));
        Wall wall76 = new Wall("F");
        addObject(wall76,this.getRealX(4),this.getRealY(15));
        Wall wall77 = new Wall("F");
        addObject(wall77,this.getRealX(10),this.getRealY(12));
        
        Wall wall100 = new Wall("F");
        addObject(wall100,this.getRealX(5),this.getRealY(12));
        Wall wall101 = new Wall("F");
        addObject(wall101,this.getRealX(5),this.getRealY(13));
        Wall wall102 = new Wall("F");
        addObject(wall102,this.getRealX(5),this.getRealY(14));
        Wall wall103 = new Wall("F");
        addObject(wall103,this.getRealX(5),this.getRealY(15));
        
        Wall wall79 = new Wall("F");
        addObject(wall79,this.getRealX(10),this.getRealY(13));
        Wall wall80 = new Wall("F");
        addObject(wall80,this.getRealX(10),this.getRealY(14));
        Wall wall81 = new Wall("F");
        addObject(wall81,this.getRealX(10),this.getRealY(15));
        Wall wall82 = new Wall("F");
        addObject(wall82,this.getRealX(11),this.getRealY(12));
        Wall wall83 = new Wall("F");
        addObject(wall83,this.getRealX(11),this.getRealY(13));
        Wall wall84 = new Wall("F");
        addObject(wall84,this.getRealX(11),this.getRealY(14));
        Wall wall85 = new Wall("F");
        addObject(wall85,this.getRealX(11),this.getRealY(15));
        
        
        
        Spieler player86 = new Spieler(this.loadCharacter());
        addObject(player86,this.getRealX(1),this.getRealY(8));
        player86.setRotation(0);
        
        Spieler player87 = new Spieler(this.loadCharacter());
        addObject(player87,this.getRealX(1),this.getRealY(15));
        player87.setRotation(0);
        String[] firstPage = new String[]{"Das Ziel dieses Levels liegt darin, den Brückenbau","auf einem Krater zu unterstützen.","","Dazu soll unsere Spielfigur den Brückenbereich wie im","oberen Beispiel farbig markieren."};
        String[] secondPage = new String[]{"Du kannst zur Hilfe dieses Levels die Lösung","des letzten Levels zur Hand nehmen."};
        String wm = "+30 EXP\n\nGroßartig! Damit hast du das vorletzte Kapitel geschafft!";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player86,player87},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L01() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FTS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FOLNW");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(1),this.getRealY(9));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(2),this.getRealY(9));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(3),this.getRealY(9));
        Wall wall21 = new Wall("FTN");
        addObject(wall21,this.getRealX(4),this.getRealY(9));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(5),this.getRealY(9));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(6),this.getRealY(9));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(7),this.getRealY(9));
        Wall wall25 = new Wall("FTN");
        addObject(wall25,this.getRealX(8),this.getRealY(9));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(9),this.getRealY(9));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(10),this.getRealY(9));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(11),this.getRealY(9));
        Wall wall29 = new Wall("FOLEN");
        addObject(wall29,this.getRealX(0),this.getRealY(9));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(5));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(6));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(7));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(8));
        Outline o34 = new Outline();
        addObject(o34,this.getRealX(1),this.getRealY(5));
        Outline o35 = new Outline();
        addObject(o35,this.getRealX(1),this.getRealY(6));
        Outline o36 = new Outline();
        addObject(o36,this.getRealX(1),this.getRealY(7));
        Outline o37 = new Outline();
        o37.setSecret();
        addObject(o37,this.getRealX(3),this.getRealY(5));
        Outline o38 = new Outline();
        o38.setSecret();
        addObject(o38,this.getRealX(3),this.getRealY(6));
        Outline o39 = new Outline();
        o39.setSecret();
        addObject(o39,this.getRealX(3),this.getRealY(7));
        Outline o40 = new Outline();
        addObject(o40,this.getRealX(5),this.getRealY(7));
        Outline o41 = new Outline();
        o41.setSecret();
        addObject(o41,this.getRealX(7),this.getRealY(7));
        Outline o42 = new Outline();
        addObject(o42,this.getRealX(9),this.getRealY(6));
        Outline o43 = new Outline();
        addObject(o43,this.getRealX(9),this.getRealY(7));
        Outline o44 = new Outline();
        o44.setSecret();
        addObject(o44,this.getRealX(11),this.getRealY(6));
        Outline o45 = new Outline();
        o45.setSecret();
        addObject(o45,this.getRealX(11),this.getRealY(7));
        Spieler player46 = new Spieler(this.loadCharacter());
        player46.setOutlineAsOnlyGoal();
        addObject(player46,this.getRealX(1),this.getRealY(8));
        player46.setRotation(270);
        Spieler player47 = new Spieler(this.loadCharacter());
        player47.setOutlineAsOnlyGoal();
        addObject(player47,this.getRealX(5),this.getRealY(8));
        player47.setRotation(270);
        Spieler player48 = new Spieler(this.loadCharacter());
        player48.setOutlineAsOnlyGoal();
        addObject(player48,this.getRealX(9),this.getRealY(8));
        player48.setRotation(270);
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(4),this.getRealY(5));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(4),this.getRealY(6));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(4),this.getRealY(7));
        Wall wall52 = new Wall("V");
        addObject(wall52,this.getRealX(4),this.getRealY(8));
        Wall wall53 = new Wall("V");
        addObject(wall53,this.getRealX(8),this.getRealY(5));
        Wall wall54 = new Wall("V");
        addObject(wall54,this.getRealX(8),this.getRealY(6));
        Wall wall55 = new Wall("V");
        addObject(wall55,this.getRealX(8),this.getRealY(7));
        Wall wall56 = new Wall("V");
        addObject(wall56,this.getRealX(8),this.getRealY(8));
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player46,player47,player48},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L02() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FTS");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FTS");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FOLNW");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(1),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(2),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(3),this.getRealY(10));
        Wall wall22 = new Wall("FTN");
        addObject(wall22,this.getRealX(4),this.getRealY(10));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(5),this.getRealY(10));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(6),this.getRealY(10));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(7),this.getRealY(10));
        Wall wall26 = new Wall("FTN");
        addObject(wall26,this.getRealX(8),this.getRealY(10));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(9),this.getRealY(10));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(10),this.getRealY(10));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(11),this.getRealY(10));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(10));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Item i36 = new Item();
        addObject(i36,this.getRealX(2),this.getRealY(5));
        Item i37 = new Item();
        addObject(i37,this.getRealX(2),this.getRealY(6));
        Item i38 = new Item();
        addObject(i38,this.getRealX(1),this.getRealY(6));
        Item i39 = new Item();
        addObject(i39,this.getRealX(3),this.getRealY(5));
        Item i40 = new Item();
        addObject(i40,this.getRealX(3),this.getRealY(6));
        Item i41 = new Item();
        addObject(i41,this.getRealX(3),this.getRealY(7));
        Outline o42 = new Outline();
        addObject(o42,this.getRealX(2),this.getRealY(9));
        Item i43 = new Item();
        addObject(i43,this.getRealX(5),this.getRealY(7));
        Item i44 = new Item();
        addObject(i44,this.getRealX(6),this.getRealY(5));
        Item i45 = new Item();
        addObject(i45,this.getRealX(6),this.getRealY(8));
        Item i46 = new Item();
        addObject(i46,this.getRealX(7),this.getRealY(6));
        Item i47 = new Item();
        addObject(i47,this.getRealX(7),this.getRealY(8));
        Outline o48 = new Outline();
        o48.setSecret();
        addObject(o48,this.getRealX(6),this.getRealY(9));
        Outline o49 = new Outline();
        o49.setSecret();
        addObject(o49,this.getRealX(7),this.getRealY(9));
        Item i50 = new Item();
        addObject(i50,this.getRealX(10),this.getRealY(5));
        Item i51 = new Item();
        addObject(i51,this.getRealX(10),this.getRealY(6));
        Item i52 = new Item();
        addObject(i52,this.getRealX(10),this.getRealY(7));
        Item i53 = new Item();
        addObject(i53,this.getRealX(10),this.getRealY(8));
        Item i54 = new Item();
        addObject(i54,this.getRealX(11),this.getRealY(6));
        Item i55 = new Item();
        addObject(i55,this.getRealX(11),this.getRealY(7));
        Outline o56 = new Outline();
        o56.setSecret();
        addObject(o56,this.getRealX(11),this.getRealY(9));
        Spieler player57 = new Spieler(this.loadCharacter());
        addObject(player57,this.getRealX(1),this.getRealY(9));
        player57.setRotation(270);
        Spieler player58 = new Spieler(this.loadCharacter());
        addObject(player58,this.getRealX(5),this.getRealY(9));
        player58.setRotation(270);
        Spieler player59 = new Spieler(this.loadCharacter());
        addObject(player59,this.getRealX(9),this.getRealY(9));
        player59.setRotation(270);
        Wall wall60 = new Wall("V");
        addObject(wall60,this.getRealX(4),this.getRealY(5));
        Wall wall61 = new Wall("V");
        addObject(wall61,this.getRealX(4),this.getRealY(6));
        Wall wall62 = new Wall("V");
        addObject(wall62,this.getRealX(4),this.getRealY(7));
        Wall wall63 = new Wall("V");
        addObject(wall63,this.getRealX(4),this.getRealY(8));
        Wall wall64 = new Wall("V");
        addObject(wall64,this.getRealX(4),this.getRealY(9));
        Wall wall65 = new Wall("V");
        addObject(wall65,this.getRealX(8),this.getRealY(5));
        Wall wall66 = new Wall("V");
        addObject(wall66,this.getRealX(8),this.getRealY(6));
        Wall wall67 = new Wall("V");
        addObject(wall67,this.getRealX(8),this.getRealY(7));
        Wall wall68 = new Wall("V");
        addObject(wall68,this.getRealX(8),this.getRealY(8));
        Wall wall69 = new Wall("V");
        addObject(wall69,this.getRealX(8),this.getRealY(9));
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player57,player58,player59},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L03() {
        
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FTW");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(12),this.getRealY(11));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(12),this.getRealY(12));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(12),this.getRealY(13));
        Wall wall22 = new Wall("FOLNW");
        addObject(wall22,this.getRealX(12),this.getRealY(14));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(1),this.getRealY(14));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(2),this.getRealY(14));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(3),this.getRealY(14));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(4),this.getRealY(14));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(5),this.getRealY(14));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(6),this.getRealY(14));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(7),this.getRealY(14));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(8),this.getRealY(14));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(9),this.getRealY(14));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(10),this.getRealY(14));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(11),this.getRealY(14));
        Wall wall34 = new Wall("FOLEN");
        addObject(wall34,this.getRealX(0),this.getRealY(14));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(5));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(6));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(7));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(8));
        Wall wall39 = new Wall("FTE");
        addObject(wall39,this.getRealX(0),this.getRealY(9));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(10));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(11));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(12));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(13));
        
        //Randomisierter zweiter Raum!
        
        //1. Raumgröße: 4 Möglichkeiten
        Spieler player62 = new Spieler(this.loadCharacter());
        int gr = (int)(Math.random()*4);
        if (gr == 0) {
            //Voller Raum
            
            //Targets verteilen
            //eines auf 1 <= x < 6
            int t1x = (int)(Math.random()*5);
            int t1y = (int)(Math.random()*4);
            
            t1x = t1x + 1;
            t1y = t1y + 10;
            
            //eines auf 6 < x <= 10
            int t2x = (int)(Math.random()*4);
            int t2y = (int)(Math.random()*4);
            
            t2x = t2x + 7;
            t2y = t2y + 10;
            
            //Spieler auf x=6
            int px = 6;
            int py = (int)(Math.random()*4);
            py = py + 10;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            Target t59 = new Target();
            addObject(t59,this.getRealX(t1x),this.getRealY(t1y));
            Target t60 = new Target();
            addObject(t60,this.getRealX(t2x),this.getRealY(t2y));
            Outline o61 = new Outline();
            addObject(o61,this.getRealX(11),this.getRealY(13));
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
        } else if (gr == 1) {
            //Letzte Spalte weg
            Wall wallx01 = new Wall("F");
            addObject(wallx01,this.getRealX(11),this.getRealY(10));
            Wall wallx02 = new Wall("F");
            addObject(wallx02,this.getRealX(11),this.getRealY(11));
            Wall wallx03 = new Wall("F");
            addObject(wallx03,this.getRealX(11),this.getRealY(12));
            Wall wallx04 = new Wall("F");
            addObject(wallx04,this.getRealX(11),this.getRealY(13));
            
            //Targets verteilen
            //eines auf 1 <= x < 6
            int t1x = (int)(Math.random()*5);
            int t1y = (int)(Math.random()*4);
            
            t1x = t1x + 1;
            t1y = t1y + 10;
            
            //eines auf 6 < x <= 9
            int t2x = (int)(Math.random()*3);
            int t2y = (int)(Math.random()*4);
            
            t2x = t2x + 7;
            t2y = t2y + 10;
            
            //Spieler auf x=6
            int px = 6;
            int py = (int)(Math.random()*4);
            py = py + 10;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            Target t59 = new Target();
            addObject(t59,this.getRealX(t1x),this.getRealY(t1y));
            Target t60 = new Target();
            addObject(t60,this.getRealX(t2x),this.getRealY(t2y));
            Outline o61 = new Outline();
            addObject(o61,this.getRealX(10),this.getRealY(13));
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
            
        } else if (gr == 2) {
            //letzte beiden Spalten weg
            Wall wallx01 = new Wall("F");
            addObject(wallx01,this.getRealX(11),this.getRealY(10));
            Wall wallx02 = new Wall("F");
            addObject(wallx02,this.getRealX(11),this.getRealY(11));
            Wall wallx03 = new Wall("F");
            addObject(wallx03,this.getRealX(11),this.getRealY(12));
            Wall wallx04 = new Wall("F");
            addObject(wallx04,this.getRealX(11),this.getRealY(13));
            Wall wallx05 = new Wall("F");
            addObject(wallx05,this.getRealX(10),this.getRealY(10));
            Wall wallx06 = new Wall("F");
            addObject(wallx06,this.getRealX(10),this.getRealY(11));
            Wall wallx07 = new Wall("F");
            addObject(wallx07,this.getRealX(10),this.getRealY(12));
            Wall wallx08 = new Wall("F");
            addObject(wallx08,this.getRealX(10),this.getRealY(13));
            
            //Targets verteilen
            //eines auf 1 <= x < 5
            int t1x = (int)(Math.random()*4);
            int t1y = (int)(Math.random()*4);
            
            t1x = t1x + 1;
            t1y = t1y + 10;
            
            //eines auf 5 < x <= 8
            int t2x = (int)(Math.random()*3);
            int t2y = (int)(Math.random()*4);
            
            t2x = t2x + 6;
            t2y = t2y + 10;
            
            //Spieler auf x=5
            int px = 5;
            int py = (int)(Math.random()*4);
            py = py + 10;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            Target t59 = new Target();
            addObject(t59,this.getRealX(t1x),this.getRealY(t1y));
            Target t60 = new Target();
            addObject(t60,this.getRealX(t2x),this.getRealY(t2y));
            Outline o61 = new Outline();
            addObject(o61,this.getRealX(9),this.getRealY(13));
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
        } else if (gr == 3) {
            //letzte beiden Spalten und erste Zeile weg
            Wall wallx01 = new Wall("F");
            addObject(wallx01,this.getRealX(11),this.getRealY(10));
            Wall wallx02 = new Wall("F");
            addObject(wallx02,this.getRealX(11),this.getRealY(11));
            Wall wallx03 = new Wall("F");
            addObject(wallx03,this.getRealX(11),this.getRealY(12));
            Wall wallx04 = new Wall("F");
            addObject(wallx04,this.getRealX(11),this.getRealY(13));
            Wall wallx05 = new Wall("F");
            addObject(wallx05,this.getRealX(10),this.getRealY(10));
            Wall wallx06 = new Wall("F");
            addObject(wallx06,this.getRealX(10),this.getRealY(11));
            Wall wallx07 = new Wall("F");
            addObject(wallx07,this.getRealX(10),this.getRealY(12));
            Wall wallx08 = new Wall("F");
            addObject(wallx08,this.getRealX(10),this.getRealY(13));
            
            Wall wallx09 = new Wall("F");
            addObject(wallx09,this.getRealX(9),this.getRealY(10));
            Wall wallx10 = new Wall("F");
            addObject(wallx10,this.getRealX(8),this.getRealY(10));
            Wall wallx11 = new Wall("F");
            addObject(wallx11,this.getRealX(7),this.getRealY(10));
            Wall wallx12 = new Wall("F");
            addObject(wallx12,this.getRealX(6),this.getRealY(10));
            Wall wallx13 = new Wall("F");
            addObject(wallx13,this.getRealX(5),this.getRealY(10));
            Wall wallx14 = new Wall("F");
            addObject(wallx14,this.getRealX(4),this.getRealY(10));
            Wall wallx15 = new Wall("F");
            addObject(wallx15,this.getRealX(3),this.getRealY(10));
            Wall wallx16 = new Wall("F");
            addObject(wallx16,this.getRealX(2),this.getRealY(10));
            Wall wallx17 = new Wall("F");
            addObject(wallx17,this.getRealX(1),this.getRealY(10));
            
            
            //Targets verteilen
            //eines auf 1 <= x < 5
            int t1x = (int)(Math.random()*4);
            int t1y = (int)(Math.random()*3);
            
            t1x = t1x + 1;
            t1y = t1y + 11;
            
            //eines auf 5 < x <= 8
            int t2x = (int)(Math.random()*3);
            int t2y = (int)(Math.random()*3);
            
            t2x = t2x + 6;
            t2y = t2y + 11;
            
            //Spieler auf x=5
            int px = 5;
            int py = (int)(Math.random()*3);
            py = py + 11;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            Target t59 = new Target();
            addObject(t59,this.getRealX(t1x),this.getRealY(t1y));
            Target t60 = new Target();
            addObject(t60,this.getRealX(t2x),this.getRealY(t2y));
            Outline o61 = new Outline();
            addObject(o61,this.getRealX(9),this.getRealY(13));
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
        }
        
        
        Spieler player58 = new Spieler(this.loadCharacter());
        
        gr = (int)(Math.random()*4);
        if (gr == 0) {
            //Voller Raum
            
            //Targets verteilen
            //eines auf 1 <= x < 7
            int t1x = (int)(Math.random()*6);
            int t1y = (int)(Math.random()*4);
            
            t1x = t1x + 1;
            t1y = t1y + 5;
            
            //eines auf 7 < x <= 10
            int t2x = (int)(Math.random()*3);
            int t2y = (int)(Math.random()*4);
            
            t2x = t2x + 8;
            t2y = t2y + 5;
            
            //Spieler auf x=7
            int px = 7;
            int py = (int)(Math.random()*4);
            py = py + 5;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            
             Target t44 = new Target();
            addObject(t44,this.getRealX(t1x),this.getRealY(t1y));
            Target t45 = new Target();
            addObject(t45,this.getRealX(t2x),this.getRealY(t2y));
            
            Outline o46 = new Outline();
            addObject(o46,this.getRealX(11),this.getRealY(8));
        
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
            
            addObject(player58,this.getRealX(px),this.getRealY(py));
            player58.setRotation(dir);
        
            
            
        } else if (gr == 1) {
            //Letzte Spalte weg
            Wall wallx01 = new Wall("F");
            addObject(wallx01,this.getRealX(11),this.getRealY(5));
            Wall wallx02 = new Wall("F");
            addObject(wallx02,this.getRealX(11),this.getRealY(6));
            Wall wallx03 = new Wall("F");
            addObject(wallx03,this.getRealX(11),this.getRealY(7));
            Wall wallx04 = new Wall("F");
            addObject(wallx04,this.getRealX(11),this.getRealY(8));
            
            //Targets verteilen
            //eines auf 1 <= x < 7
            int t1x = (int)(Math.random()*6);
            int t1y = (int)(Math.random()*4);
            
            t1x = t1x + 1;
            t1y = t1y + 5;
            
            //eines auf 7 < x <= 9
            int t2x = (int)(Math.random()*2);
            int t2y = (int)(Math.random()*4);
            
            t2x = t2x + 8;
            t2y = t2y + 5;
            
            //Spieler auf x=7
            int px = 7;
            int py = (int)(Math.random()*4);
            py = py + 5;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            
             Target t44 = new Target();
            addObject(t44,this.getRealX(t1x),this.getRealY(t1y));
            Target t45 = new Target();
            addObject(t45,this.getRealX(t2x),this.getRealY(t2y));
            
            Outline o46 = new Outline();
            addObject(o46,this.getRealX(10),this.getRealY(8));
        
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
            
            addObject(player58,this.getRealX(px),this.getRealY(py));
            player58.setRotation(dir);
            
            
        } else if (gr == 2) {
            //letzte beiden Spalten weg
            Wall wallx01 = new Wall("F");
            addObject(wallx01,this.getRealX(11),this.getRealY(5));
            Wall wallx02 = new Wall("F");
            addObject(wallx02,this.getRealX(11),this.getRealY(6));
            Wall wallx03 = new Wall("F");
            addObject(wallx03,this.getRealX(11),this.getRealY(7));
            Wall wallx04 = new Wall("F");
            addObject(wallx04,this.getRealX(11),this.getRealY(8));
            Wall wallx05 = new Wall("F");
            addObject(wallx05,this.getRealX(10),this.getRealY(5));
            Wall wallx06 = new Wall("F");
            addObject(wallx06,this.getRealX(10),this.getRealY(6));
            Wall wallx07 = new Wall("F");
            addObject(wallx07,this.getRealX(10),this.getRealY(7));
            Wall wallx08 = new Wall("F");
            addObject(wallx08,this.getRealX(10),this.getRealY(8));
            
            //Targets verteilen
            //eines auf 1 <= x < 3
            int t1x = (int)(Math.random()*2);
            int t1y = (int)(Math.random()*4);
            
            t1x = t1x + 1;
            t1y = t1y + 5;
            
            //eines auf 4 < x <= 8
            int t2x = (int)(Math.random()*4);
            int t2y = (int)(Math.random()*4);
            
            t2x = t2x + 5;
            t2y = t2y + 5;
            
            //Spieler auf x=4
            int px = 4;
            int py = (int)(Math.random()*4);
            py = py + 5;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            
             Target t44 = new Target();
            addObject(t44,this.getRealX(t1x),this.getRealY(t1y));
            Target t45 = new Target();
            addObject(t45,this.getRealX(t2x),this.getRealY(t2y));
            
            Outline o46 = new Outline();
            addObject(o46,this.getRealX(9),this.getRealY(8));
        
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
            
            addObject(player58,this.getRealX(px),this.getRealY(py));
            player58.setRotation(dir);
            
            
        } else if (gr == 3) {
            //letzte beiden Spalten und erste Zeile weg
            Wall wallx01 = new Wall("F");
            addObject(wallx01,this.getRealX(11),this.getRealY(5));
            Wall wallx02 = new Wall("F");
            addObject(wallx02,this.getRealX(11),this.getRealY(6));
            Wall wallx03 = new Wall("F");
            addObject(wallx03,this.getRealX(11),this.getRealY(7));
            Wall wallx04 = new Wall("F");
            addObject(wallx04,this.getRealX(11),this.getRealY(8));
            Wall wallx05 = new Wall("F");
            addObject(wallx05,this.getRealX(10),this.getRealY(5));
            Wall wallx06 = new Wall("F");
            addObject(wallx06,this.getRealX(10),this.getRealY(6));
            Wall wallx07 = new Wall("F");
            addObject(wallx07,this.getRealX(10),this.getRealY(7));
            Wall wallx08 = new Wall("F");
            addObject(wallx08,this.getRealX(10),this.getRealY(8));
            
            Wall wallx09 = new Wall("F");
            addObject(wallx09,this.getRealX(9),this.getRealY(5));
            Wall wallx10 = new Wall("F");
            addObject(wallx10,this.getRealX(8),this.getRealY(5));
            Wall wallx11 = new Wall("F");
            addObject(wallx11,this.getRealX(7),this.getRealY(5));
            Wall wallx12 = new Wall("F");
            addObject(wallx12,this.getRealX(6),this.getRealY(5));
            Wall wallx13 = new Wall("F");
            addObject(wallx13,this.getRealX(5),this.getRealY(5));
            Wall wallx14 = new Wall("F");
            addObject(wallx14,this.getRealX(4),this.getRealY(5));
            Wall wallx15 = new Wall("F");
            addObject(wallx15,this.getRealX(3),this.getRealY(5));
            Wall wallx16 = new Wall("F");
            addObject(wallx16,this.getRealX(2),this.getRealY(5));
            Wall wallx17 = new Wall("F");
            addObject(wallx17,this.getRealX(1),this.getRealY(5));
            
            
            //Targets verteilen
            //eines auf 1 <= x < 3
            int t1x = (int)(Math.random()*2);
            int t1y = (int)(Math.random()*3);
            
            t1x = t1x + 1;
            t1y = t1y + 6;
            
            //eines auf 4 < x <= 8
            int t2x = (int)(Math.random()*4);
            int t2y = (int)(Math.random()*3);
            
            t2x = t2x + 5;
            t2y = t2y + 6;
            
            //Spieler auf x=4
            int px = 4;
            int py = (int)(Math.random()*3);
            py = py + 6;
            
            int dir = (int)(Math.random()*4);
            dir = dir*90;

            
            
             Target t44 = new Target();
            addObject(t44,this.getRealX(t1x),this.getRealY(t1y));
            Target t45 = new Target();
            addObject(t45,this.getRealX(t2x),this.getRealY(t2y));
            
            Outline o46 = new Outline();
            addObject(o46,this.getRealX(9),this.getRealY(8));
        
            
            addObject(player62,this.getRealX(px),this.getRealY(py));
            player62.setRotation(dir);
            
            
            addObject(player58,this.getRealX(px),this.getRealY(py));
            player58.setRotation(dir);
            
            
        }
        
       
        
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(1),this.getRealY(9));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(2),this.getRealY(9));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(3),this.getRealY(9));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(4),this.getRealY(9));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(5),this.getRealY(9));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(6),this.getRealY(9));
        Wall wall53 = new Wall("H");
        addObject(wall53,this.getRealX(7),this.getRealY(9));
        Wall wall54 = new Wall("H");
        addObject(wall54,this.getRealX(8),this.getRealY(9));
        Wall wall55 = new Wall("H");
        addObject(wall55,this.getRealX(9),this.getRealY(9));
        Wall wall56 = new Wall("H");
        addObject(wall56,this.getRealX(10),this.getRealY(9));
        Wall wall57 = new Wall("H");
        addObject(wall57,this.getRealX(11),this.getRealY(9));
        
        
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player58,player62},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L04() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FTW");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(12),this.getRealY(11));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(12),this.getRealY(12));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(12),this.getRealY(13));
        Wall wall22 = new Wall("FOLNW");
        addObject(wall22,this.getRealX(12),this.getRealY(14));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(1),this.getRealY(14));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(2),this.getRealY(14));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(3),this.getRealY(14));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(4),this.getRealY(14));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(5),this.getRealY(14));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(6),this.getRealY(14));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(7),this.getRealY(14));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(8),this.getRealY(14));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(9),this.getRealY(14));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(10),this.getRealY(14));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(11),this.getRealY(14));
        Wall wall34 = new Wall("FOLEN");
        addObject(wall34,this.getRealX(0),this.getRealY(14));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(5));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(6));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(7));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(8));
        Wall wall39 = new Wall("FTE");
        addObject(wall39,this.getRealX(0),this.getRealY(9));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(10));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(11));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(12));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(13));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(1),this.getRealY(9));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(2),this.getRealY(9));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(3),this.getRealY(9));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(4),this.getRealY(9));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(5),this.getRealY(9));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(6),this.getRealY(9));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(7),this.getRealY(9));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(8),this.getRealY(9));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(9),this.getRealY(9));
        Wall wall53 = new Wall("H");
        addObject(wall53,this.getRealX(10),this.getRealY(9));
        Wall wall54 = new Wall("H");
        addObject(wall54,this.getRealX(11),this.getRealY(9));
        
        
        int style = (int)(Math.random()*3);
        Spieler player56 = new Spieler(this.loadCharacter());
        if (style == 0) {
            //Oberer Raum: Stil 1
            //Wände
            Wall wall57 = new Wall("F");
            addObject(wall57,this.getRealX(11),this.getRealY(7));
            Wall wall58 = new Wall("F");
            addObject(wall58,this.getRealX(11),this.getRealY(6));
            Wall wall59 = new Wall("F");
            addObject(wall59,this.getRealX(11),this.getRealY(7));
            Wall wall60 = new Wall("F");
            addObject(wall60,this.getRealX(9),this.getRealY(7));
            Wall wall61 = new Wall("F");
            addObject(wall61,this.getRealX(6),this.getRealY(7));
            Wall wall62 = new Wall("F");
            addObject(wall62,this.getRealX(5),this.getRealY(7));
            Wall wall63 = new Wall("F");
            addObject(wall63,this.getRealX(6),this.getRealY(8));
            Wall wall64 = new Wall("F");
            addObject(wall64,this.getRealX(1),this.getRealY(8));
            Wall wall65 = new Wall("F");
            addObject(wall65,this.getRealX(3),this.getRealY(6));
            Wall wall66 = new Wall("F");
            addObject(wall66,this.getRealX(6),this.getRealY(5));
            //Checkpoints
            
            Checkpoint c55 = new Checkpoint(0);
            addObject(c55,this.getRealX(10),this.getRealY(7));
            Checkpoint c56 = new Checkpoint(0);
            addObject(c56,this.getRealX(10),this.getRealY(6));
            Checkpoint c57 = new Checkpoint(0);
            addObject(c57,this.getRealX(10),this.getRealY(5));
            Checkpoint c58 = new Checkpoint(0);
            addObject(c58,this.getRealX(9),this.getRealY(5));
            Checkpoint c59 = new Checkpoint(0);
            addObject(c59,this.getRealX(8),this.getRealY(5));
            Checkpoint c60 = new Checkpoint(0);
            addObject(c60,this.getRealX(8),this.getRealY(6));
            Checkpoint c61 = new Checkpoint(0);
            addObject(c61,this.getRealX(7),this.getRealY(6));
            Checkpoint c62 = new Checkpoint(0);
            addObject(c62,this.getRealX(6),this.getRealY(6));
            Checkpoint c63 = new Checkpoint(0);
            addObject(c63,this.getRealX(5),this.getRealY(6));
            Checkpoint c64 = new Checkpoint(0);
            addObject(c64,this.getRealX(5),this.getRealY(5));
            Checkpoint c65 = new Checkpoint(0);
            addObject(c65,this.getRealX(4),this.getRealY(5));
            Checkpoint c66 = new Checkpoint(0);
            addObject(c66,this.getRealX(3),this.getRealY(5));
            Checkpoint c67 = new Checkpoint(0);
            addObject(c67,this.getRealX(2),this.getRealY(5));
            Checkpoint c68 = new Checkpoint(0);
            addObject(c68,this.getRealX(2),this.getRealY(6));
            Checkpoint c69 = new Checkpoint(0);
            addObject(c69,this.getRealX(2),this.getRealY(7));
            Checkpoint c70 = new Checkpoint(0);
            addObject(c70,this.getRealX(2),this.getRealY(8));
            Checkpoint c71 = new Checkpoint(0);
            addObject(c71,this.getRealX(3),this.getRealY(8));
            Checkpoint c72 = new Checkpoint(0);
            addObject(c72,this.getRealX(4),this.getRealY(8));
            Checkpoint c73 = new Checkpoint(0);
            addObject(c73,this.getRealX(5),this.getRealY(8));
            
            
            //Spieler
            addObject(player56,this.getRealX(10),this.getRealY(8));
            player56.setRotation(270);
            
        } else if (style == 1) {
            //Oberer Raum: Stil 2
            //Wände
            Wall wall57 = new Wall("F");
            addObject(wall57,this.getRealX(2),this.getRealY(6));
            Wall wall58 = new Wall("F");
            addObject(wall58,this.getRealX(4),this.getRealY(5));
            Wall wall59 = new Wall("F");
            addObject(wall59,this.getRealX(6),this.getRealY(6));
            Wall wall60 = new Wall("F");
            addObject(wall60,this.getRealX(7),this.getRealY(8));
            Wall wall61 = new Wall("F");
            addObject(wall61,this.getRealX(8),this.getRealY(8));
            Wall wall62 = new Wall("F");
            addObject(wall62,this.getRealX(8),this.getRealY(7));
            Wall wall63 = new Wall("F");
            addObject(wall63,this.getRealX(9),this.getRealY(7));
              
            Wall wall64 = new Wall("F");
            addObject(wall64,this.getRealX(2),this.getRealY(7));
            //Checkpoints
            
            Checkpoint c55 = new Checkpoint(0);
            addObject(c55,this.getRealX(10),this.getRealY(8));
            Checkpoint c56 = new Checkpoint(0);
            addObject(c56,this.getRealX(10),this.getRealY(7));
            Checkpoint c57 = new Checkpoint(0);
            addObject(c57,this.getRealX(10),this.getRealY(6));
            Checkpoint c58 = new Checkpoint(0);
            addObject(c58,this.getRealX(9),this.getRealY(6));
            Checkpoint c59 = new Checkpoint(0);
            addObject(c59,this.getRealX(8),this.getRealY(6));
            Checkpoint c60 = new Checkpoint(0);
            addObject(c60,this.getRealX(7),this.getRealY(6));
            Checkpoint c61 = new Checkpoint(0);
            addObject(c61,this.getRealX(7),this.getRealY(7));
            Checkpoint c62 = new Checkpoint(0);
            addObject(c62,this.getRealX(6),this.getRealY(7));
            Checkpoint c63 = new Checkpoint(0);
            addObject(c63,this.getRealX(5),this.getRealY(7));
            Checkpoint c64 = new Checkpoint(0);
            addObject(c64,this.getRealX(4),this.getRealY(7));
            Checkpoint c65 = new Checkpoint(0);
            addObject(c65,this.getRealX(4),this.getRealY(8));
            Checkpoint c66 = new Checkpoint(0);
            addObject(c66,this.getRealX(3),this.getRealY(8));
            Checkpoint c67 = new Checkpoint(0);
            addObject(c67,this.getRealX(2),this.getRealY(8));
            Checkpoint c68 = new Checkpoint(0);
            addObject(c68,this.getRealX(1),this.getRealY(8));
            Checkpoint c69 = new Checkpoint(0);
            addObject(c69,this.getRealX(1),this.getRealY(7));
            Checkpoint c70 = new Checkpoint(0);
            addObject(c70,this.getRealX(1),this.getRealY(6));
            Checkpoint c71 = new Checkpoint(0);
            addObject(c71,this.getRealX(1),this.getRealY(5));
            Checkpoint c72 = new Checkpoint(0);
            addObject(c72,this.getRealX(2),this.getRealY(5));
            Checkpoint c73 = new Checkpoint(0);
            addObject(c73,this.getRealX(3),this.getRealY(5));
            
            
            //Spieler
            addObject(player56,this.getRealX(9),this.getRealY(8));
            player56.setRotation(0);
        } else if (style == 2) {
            //Oberer Raum: Stil 3
            //Wände
            Wall wall57 = new Wall("F");
            addObject(wall57,this.getRealX(2),this.getRealY(7));
            Wall wall58 = new Wall("F");
            addObject(wall58,this.getRealX(3),this.getRealY(5));
            Wall wall59 = new Wall("F");
            addObject(wall59,this.getRealX(4),this.getRealY(7));
            Wall wall60 = new Wall("F");
            addObject(wall60,this.getRealX(5),this.getRealY(5));
            Wall wall61 = new Wall("F");
            addObject(wall61,this.getRealX(9),this.getRealY(6));
            Wall wall62 = new Wall("F");
            addObject(wall62,this.getRealX(9),this.getRealY(7));
            Wall wall63 = new Wall("F");
            addObject(wall63,this.getRealX(10),this.getRealY(6));
            Wall wall64 = new Wall("F");
            addObject(wall64,this.getRealX(11),this.getRealY(6));
            Wall wall65 = new Wall("F");
            addObject(wall65,this.getRealX(11),this.getRealY(7));
            Wall wall66 = new Wall("F");
            addObject(wall66,this.getRealX(7),this.getRealY(8));
            //Checkpoints
            
            Checkpoint c55 = new Checkpoint(0);
            addObject(c55,this.getRealX(4),this.getRealY(6));
            Checkpoint c56 = new Checkpoint(0);
            addObject(c56,this.getRealX(3),this.getRealY(6));
            Checkpoint c57 = new Checkpoint(0);
            addObject(c57,this.getRealX(2),this.getRealY(6));
            Checkpoint c58 = new Checkpoint(0);
            addObject(c58,this.getRealX(1),this.getRealY(6));
            Checkpoint c59 = new Checkpoint(0);
            addObject(c59,this.getRealX(1),this.getRealY(7));
            Checkpoint c60 = new Checkpoint(0);
            addObject(c60,this.getRealX(1),this.getRealY(8));
            Checkpoint c61 = new Checkpoint(0);
            addObject(c61,this.getRealX(2),this.getRealY(8));
            Checkpoint c62 = new Checkpoint(0);
            addObject(c62,this.getRealX(3),this.getRealY(8));
            Checkpoint c63 = new Checkpoint(0);
            addObject(c63,this.getRealX(4),this.getRealY(8));
            Checkpoint c64 = new Checkpoint(0);
            addObject(c64,this.getRealX(5),this.getRealY(8));
            Checkpoint c65 = new Checkpoint(0);
            addObject(c65,this.getRealX(6),this.getRealY(8));
            Checkpoint c66 = new Checkpoint(0);
            addObject(c66,this.getRealX(6),this.getRealY(7));
            Checkpoint c67 = new Checkpoint(0);
            addObject(c67,this.getRealX(6),this.getRealY(6));
            Checkpoint c68 = new Checkpoint(0);
            addObject(c68,this.getRealX(6),this.getRealY(5));
            Checkpoint c69 = new Checkpoint(0);
            addObject(c69,this.getRealX(7),this.getRealY(5));
            Checkpoint c70 = new Checkpoint(0);
            addObject(c70,this.getRealX(8),this.getRealY(5));
            Checkpoint c71 = new Checkpoint(0);
            addObject(c71,this.getRealX(8),this.getRealY(5));
            Checkpoint c72 = new Checkpoint(0);
            addObject(c72,this.getRealX(8),this.getRealY(6));
            Checkpoint c73 = new Checkpoint(0);
            addObject(c73,this.getRealX(8),this.getRealY(7));
            Checkpoint c74 = new Checkpoint(0);
            addObject(c74,this.getRealX(8),this.getRealY(8));
            Checkpoint c75 = new Checkpoint(0);
            addObject(c75,this.getRealX(9),this.getRealY(8));
            Checkpoint c76 = new Checkpoint(0);
            addObject(c76,this.getRealX(10),this.getRealY(8));
            Checkpoint c77 = new Checkpoint(0);
            addObject(c77,this.getRealX(10),this.getRealY(7));
            
            
            //Spieler
            addObject(player56,this.getRealX(4),this.getRealY(5));
            player56.setRotation(90);
            
        }
        
        
        style = (int)(Math.random()*3);
        Spieler player57 = new Spieler(this.loadCharacter());
        if (style == 0) {
            //Unterer Raum: Stil 1
            //Wände
            Wall wallx57 = new Wall("F");
            addObject(wallx57,this.getRealX(4),this.getRealY(10));
            Wall wallx58 = new Wall("F");
            addObject(wallx58,this.getRealX(4),this.getRealY(11));
            Wall wallx59 = new Wall("F");
            addObject(wallx59,this.getRealX(3),this.getRealY(11));
            Wall wallx60 = new Wall("F");
            addObject(wallx60,this.getRealX(2),this.getRealY(13));
            Wall wallx61 = new Wall("F");
            addObject(wallx61,this.getRealX(6),this.getRealY(11));
            Wall wallx62 = new Wall("F");
            addObject(wallx62,this.getRealX(6),this.getRealY(12));
            Wall wallx63 = new Wall("F");
            addObject(wallx63,this.getRealX(7),this.getRealY(11));
            Wall wallx64 = new Wall("F");
            addObject(wallx64,this.getRealX(8),this.getRealY(11));
            Wall wallx65 = new Wall("F");
            addObject(wallx65,this.getRealX(8),this.getRealY(12));
            
            //Checkpoints
            
            Checkpoint cx55 = new Checkpoint(0);
            addObject(cx55,this.getRealX(2),this.getRealY(10));
            Checkpoint cx56 = new Checkpoint(0);
            addObject(cx56,this.getRealX(1),this.getRealY(10));
            Checkpoint cx57 = new Checkpoint(0);
            addObject(cx57,this.getRealX(1),this.getRealY(11));
            Checkpoint cx58 = new Checkpoint(0);
            addObject(cx58,this.getRealX(1),this.getRealY(12));
            Checkpoint cx59 = new Checkpoint(0);
            addObject(cx59,this.getRealX(2),this.getRealY(12));
            Checkpoint cx60 = new Checkpoint(0);
            addObject(cx60,this.getRealX(3),this.getRealY(12));
            Checkpoint cx61 = new Checkpoint(0);
            addObject(cx61,this.getRealX(3),this.getRealY(13));
            Checkpoint cx62 = new Checkpoint(0);
            addObject(cx62,this.getRealX(4),this.getRealY(13));
            Checkpoint cx63 = new Checkpoint(0);
            addObject(cx63,this.getRealX(5),this.getRealY(13));
            Checkpoint cx64 = new Checkpoint(0);
            addObject(cx64,this.getRealX(6),this.getRealY(13));
            Checkpoint cx65 = new Checkpoint(0);
            addObject(cx65,this.getRealX(7),this.getRealY(13));
            Checkpoint cx66 = new Checkpoint(0);
            addObject(cx66,this.getRealX(7),this.getRealY(12));
            
            
            
            //Spieler
            addObject(player57,this.getRealX(3),this.getRealY(10));
            player57.setRotation(180);
            
        } else if (style == 1) {
            //Unterer Raum: Stil 1
            //Wände
            Wall wallx57 = new Wall("F");
            addObject(wallx57,this.getRealX(1),this.getRealY(11));
            Wall wallx58 = new Wall("F");
            addObject(wallx58,this.getRealX(1),this.getRealY(12));
            Wall wallx59 = new Wall("F");
            addObject(wallx59,this.getRealX(1),this.getRealY(13));
            Wall wallx60 = new Wall("F");
            addObject(wallx60,this.getRealX(7),this.getRealY(11));
            Wall wallx61 = new Wall("F");
            addObject(wallx61,this.getRealX(7),this.getRealY(12));
            Wall wallx62 = new Wall("F");
            addObject(wallx62,this.getRealX(10),this.getRealY(11));
            Wall wallx63 = new Wall("F");
            addObject(wallx63,this.getRealX(10),this.getRealY(12));
            Wall wallx64 = new Wall("F");
            addObject(wallx64,this.getRealX(11),this.getRealY(12));
            
            //Checkpoints
            
            Checkpoint cx55 = new Checkpoint(0);
            addObject(cx55,this.getRealX(10),this.getRealY(13));
            Checkpoint cx56 = new Checkpoint(0);
            addObject(cx56,this.getRealX(9),this.getRealY(13));
            Checkpoint cx57 = new Checkpoint(0);
            addObject(cx57,this.getRealX(8),this.getRealY(13));
            Checkpoint cx58 = new Checkpoint(0);
            addObject(cx58,this.getRealX(7),this.getRealY(13));
            Checkpoint cx59 = new Checkpoint(0);
            addObject(cx59,this.getRealX(6),this.getRealY(13));
            Checkpoint cx60 = new Checkpoint(0);
            addObject(cx60,this.getRealX(5),this.getRealY(13));
            Checkpoint cx61 = new Checkpoint(0);
            addObject(cx61,this.getRealX(4),this.getRealY(13));
            Checkpoint cx62 = new Checkpoint(0);
            addObject(cx62,this.getRealX(3),this.getRealY(13));
            Checkpoint cx63 = new Checkpoint(0);
            addObject(cx63,this.getRealX(2),this.getRealY(13));
            Checkpoint cx64 = new Checkpoint(0);
            addObject(cx64,this.getRealX(2),this.getRealY(12));
            Checkpoint cx65 = new Checkpoint(0);
            addObject(cx65,this.getRealX(2),this.getRealY(11));
            Checkpoint cx66 = new Checkpoint(0);
            addObject(cx66,this.getRealX(3),this.getRealY(11));
            Checkpoint cx67 = new Checkpoint(0);
            addObject(cx67,this.getRealX(4),this.getRealY(11));
            Checkpoint cx68 = new Checkpoint(0);
            addObject(cx68,this.getRealX(5),this.getRealY(11));
            Checkpoint cx69 = new Checkpoint(0);
            addObject(cx69,this.getRealX(5),this.getRealY(10));
            Checkpoint cx70 = new Checkpoint(0);
            addObject(cx70,this.getRealX(6),this.getRealY(10));
            Checkpoint cx71 = new Checkpoint(0);
            addObject(cx71,this.getRealX(7),this.getRealY(10));
            Checkpoint cx72 = new Checkpoint(0);
            addObject(cx72,this.getRealX(8),this.getRealY(10));
            Checkpoint cx73 = new Checkpoint(0);
            addObject(cx73,this.getRealX(9),this.getRealY(10));
            Checkpoint cx74 = new Checkpoint(0);
            addObject(cx74,this.getRealX(10),this.getRealY(10));
            Checkpoint cx75 = new Checkpoint(0);
            addObject(cx75,this.getRealX(11),this.getRealY(10));
            Checkpoint cx76 = new Checkpoint(0);
            addObject(cx76,this.getRealX(11),this.getRealY(11));
            
            
            
            //Spieler
            addObject(player57,this.getRealX(11),this.getRealY(13));
            player57.setRotation(180);
        } else if (style == 2) {
            //Unterer Raum: Stil 3
            //Wände
            Wall wallx57 = new Wall("F");
            addObject(wallx57,this.getRealX(3),this.getRealY(12));
            Wall wallx58 = new Wall("F");
            addObject(wallx58,this.getRealX(3),this.getRealY(13));
            Wall wallx59 = new Wall("F");
            addObject(wallx59,this.getRealX(5),this.getRealY(10));
            Wall wallx60 = new Wall("F");
            addObject(wallx60,this.getRealX(5),this.getRealY(11));
            Wall wallx61 = new Wall("F");
            addObject(wallx61,this.getRealX(7),this.getRealY(12));
            Wall wallx62 = new Wall("F");
            addObject(wallx62,this.getRealX(7),this.getRealY(13));
            Wall wallx63 = new Wall("F");
            addObject(wallx63,this.getRealX(10),this.getRealY(10));
            Wall wallx64 = new Wall("F");
            addObject(wallx64,this.getRealX(10),this.getRealY(11));
            
            //Checkpoints
            
            Checkpoint cx55 = new Checkpoint(0);
            addObject(cx55,this.getRealX(2),this.getRealY(12));
            Checkpoint cx56 = new Checkpoint(0);
            addObject(cx56,this.getRealX(2),this.getRealY(11));
            Checkpoint cx57 = new Checkpoint(0);
            addObject(cx57,this.getRealX(3),this.getRealY(11));
            Checkpoint cx58 = new Checkpoint(0);
            addObject(cx58,this.getRealX(4),this.getRealY(11));
            Checkpoint cx59 = new Checkpoint(0);
            addObject(cx59,this.getRealX(4),this.getRealY(12));
            Checkpoint cx60 = new Checkpoint(0);
            addObject(cx60,this.getRealX(5),this.getRealY(12));
            Checkpoint cx61 = new Checkpoint(0);
            addObject(cx61,this.getRealX(6),this.getRealY(12));
            Checkpoint cx62 = new Checkpoint(0);
            addObject(cx62,this.getRealX(6),this.getRealY(11));
            Checkpoint cx63 = new Checkpoint(0);
            addObject(cx63,this.getRealX(7),this.getRealY(11));
            Checkpoint cx64 = new Checkpoint(0);
            addObject(cx64,this.getRealX(8),this.getRealY(11));
            Checkpoint cx65 = new Checkpoint(0);
            addObject(cx65,this.getRealX(8),this.getRealY(12));
            Checkpoint cx66 = new Checkpoint(0);
            addObject(cx66,this.getRealX(9),this.getRealY(12));
            Checkpoint cx67 = new Checkpoint(0);
            addObject(cx67,this.getRealX(10),this.getRealY(12));
            Checkpoint cx68 = new Checkpoint(0);
            addObject(cx68,this.getRealX(11),this.getRealY(12));
            Checkpoint cx69 = new Checkpoint(0);
            addObject(cx69,this.getRealX(11),this.getRealY(11));
            Checkpoint cx70 = new Checkpoint(0);
            addObject(cx70,this.getRealX(11),this.getRealY(10));
            
            
            
            
            //Spieler
            addObject(player57,this.getRealX(1),this.getRealY(12));
            player57.setRotation(0);
        }
        
        
        
        
        
        
        
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player56,player57},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L05() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall11x = new Wall("FNH");
        addObject(wall11x,this.getRealX(12),this.getRealY(4));
        Wall wall11xx = new Wall("FNH");
        addObject(wall11xx,this.getRealX(13),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(14),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(14),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(14),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(14),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(14),this.getRealY(8));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(14),this.getRealY(9));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(14),this.getRealY(10));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(14),this.getRealY(11));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(14),this.getRealY(12));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(14),this.getRealY(13));
        Wall wall22 = new Wall("FOLNW");
        addObject(wall22,this.getRealX(14),this.getRealY(14));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(1),this.getRealY(14));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(2),this.getRealY(14));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(3),this.getRealY(14));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(4),this.getRealY(14));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(5),this.getRealY(14));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(6),this.getRealY(14));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(7),this.getRealY(14));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(8),this.getRealY(14));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(9),this.getRealY(14));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(10),this.getRealY(14));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(11),this.getRealY(14));
        Wall wall33x = new Wall("FSH");
        addObject(wall33x,this.getRealX(12),this.getRealY(14));
        Wall wall33xx = new Wall("FSH");
        addObject(wall33xx,this.getRealX(13),this.getRealY(14));
        Wall wall34 = new Wall("FOLEN");
        addObject(wall34,this.getRealX(0),this.getRealY(14));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(5));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(6));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(7));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(8));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(9));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(10));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(11));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(12));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(13));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(1),this.getRealY(9));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(2),this.getRealY(9));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(3),this.getRealY(9));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(4),this.getRealY(9));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(5),this.getRealY(9));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(6),this.getRealY(9));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(7),this.getRealY(9));
        Wall wall51 = new Wall("H");
        addObject(wall51,this.getRealX(8),this.getRealY(9));
        Wall wall52 = new Wall("H");
        addObject(wall52,this.getRealX(9),this.getRealY(9));
        Wall wall53 = new Wall("H");
        addObject(wall53,this.getRealX(10),this.getRealY(9));
        Wall wall54 = new Wall("H");
        addObject(wall54,this.getRealX(11),this.getRealY(9));
        Wall wall54x = new Wall("H");
        addObject(wall54x,this.getRealX(12),this.getRealY(9));
        Wall wall54xx = new Wall("H");
        addObject(wall54xx,this.getRealX(13),this.getRealY(9));
        
        //Verschiedene Level
        
        Spieler player55 = new Spieler(this.loadCharacter());
        int type = (int)(Math.random()*3);
        if (type == 0) {
            //Oben, Typ 1
            
            //Wände
            Wall wall000 = new Wall("F");
            addObject(wall000,this.getRealX(2),this.getRealY(5));
            Wall wall001 = new Wall("F");
            addObject(wall001,this.getRealX(3),this.getRealY(5));
            Wall wall002 = new Wall("F");
            addObject(wall002,this.getRealX(4),this.getRealY(5));
            Wall wall003 = new Wall("F");
            addObject(wall003,this.getRealX(5),this.getRealY(5));
            Wall wall004 = new Wall("F");
            addObject(wall004,this.getRealX(6),this.getRealY(5));
            Wall wall005 = new Wall("F");
            addObject(wall005,this.getRealX(7),this.getRealY(5));
            Wall wall006 = new Wall("F");
            addObject(wall006,this.getRealX(8),this.getRealY(5));
            Wall wall007 = new Wall("F");
            addObject(wall007,this.getRealX(10),this.getRealY(5));
            Wall wall008 = new Wall("F");
            addObject(wall008,this.getRealX(11),this.getRealY(5));
            Wall wall009 = new Wall("F");
            addObject(wall009,this.getRealX(12),this.getRealY(5));
            Wall wall010 = new Wall("F");
            addObject(wall010,this.getRealX(13),this.getRealY(5));
            
            Wall wall011 = new Wall("F");
            addObject(wall011,this.getRealX(4),this.getRealY(6));
            Wall wall012 = new Wall("F");
            addObject(wall012,this.getRealX(10),this.getRealY(6));
            
            Wall wall013 = new Wall("F");
            addObject(wall013,this.getRealX(2),this.getRealY(7));
            Wall wall014 = new Wall("F");
            addObject(wall014,this.getRealX(3),this.getRealY(7));
            Wall wall015 = new Wall("F");
            addObject(wall015,this.getRealX(4),this.getRealY(7));
            Wall wall016 = new Wall("F");
            addObject(wall016,this.getRealX(5),this.getRealY(7));
            Wall wall017 = new Wall("F");
            addObject(wall017,this.getRealX(7),this.getRealY(7));
            Wall wall018 = new Wall("F");
            addObject(wall018,this.getRealX(8),this.getRealY(7));
            Wall wall019 = new Wall("F");
            addObject(wall019,this.getRealX(10),this.getRealY(7));
            Wall wall020 = new Wall("F");
            addObject(wall020,this.getRealX(11),this.getRealY(7));
            Wall wall021 = new Wall("F");
            addObject(wall021,this.getRealX(13),this.getRealY(7));
            
            Wall wall022 = new Wall("F");
            addObject(wall022,this.getRealX(7),this.getRealY(8));
            Wall wall023 = new Wall("F");
            addObject(wall023,this.getRealX(13),this.getRealY(8));
            
            
            //Markierung
            Outline o56 = new Outline();
            addObject(o56,this.getRealX(11),this.getRealY(6));
            //Spieler
            addObject(player55,this.getRealX(3),this.getRealY(6));
            player55.setRotation(180);
            
        } else if (type == 1) {
            //Oben, Typ 2
            
            //Wände
            Wall wall000 = new Wall("F");
            addObject(wall000,this.getRealX(7),this.getRealY(5));
            Wall wall001 = new Wall("F");
            addObject(wall001,this.getRealX(8),this.getRealY(5));
            
            Wall wall002 = new Wall("F");
            addObject(wall002,this.getRealX(1),this.getRealY(6));
            Wall wall003 = new Wall("F");
            addObject(wall003,this.getRealX(3),this.getRealY(6));
            Wall wall004 = new Wall("F");
            addObject(wall004,this.getRealX(4),this.getRealY(6));
            Wall wall005 = new Wall("F");
            addObject(wall005,this.getRealX(5),this.getRealY(6));
            Wall wall006 = new Wall("F");
            addObject(wall006,this.getRealX(7),this.getRealY(6));
            Wall wall007 = new Wall("F");
            addObject(wall007,this.getRealX(8),this.getRealY(6));
            Wall wall008 = new Wall("F");
            addObject(wall008,this.getRealX(10),this.getRealY(6));
            Wall wall009 = new Wall("F");
            addObject(wall009,this.getRealX(11),this.getRealY(6));
            Wall wall010 = new Wall("F");
            addObject(wall010,this.getRealX(12),this.getRealY(6));
            
            Wall wall011 = new Wall("F");
            addObject(wall011,this.getRealX(1),this.getRealY(7));
            Wall wall012 = new Wall("F");
            addObject(wall012,this.getRealX(3),this.getRealY(7));
            Wall wall013 = new Wall("F");
            addObject(wall013,this.getRealX(10),this.getRealY(7));
            Wall wall014 = new Wall("F");
            addObject(wall014,this.getRealX(12),this.getRealY(7));
            
            Wall wall015 = new Wall("F");
            addObject(wall015,this.getRealX(1),this.getRealY(8));
            Wall wall016 = new Wall("F");
            addObject(wall016,this.getRealX(3),this.getRealY(8));
            Wall wall017 = new Wall("F");
            addObject(wall017,this.getRealX(4),this.getRealY(8));
            Wall wall018 = new Wall("F");
            addObject(wall018,this.getRealX(5),this.getRealY(8));
            Wall wall019 = new Wall("F");
            addObject(wall019,this.getRealX(6),this.getRealY(8));
            Wall wall020 = new Wall("F");
            addObject(wall020,this.getRealX(7),this.getRealY(8));
            Wall wall021 = new Wall("F");
            addObject(wall021,this.getRealX(8),this.getRealY(8));
            Wall wall022 = new Wall("F");
            addObject(wall022,this.getRealX(10),this.getRealY(8));

            
            
            //Markierung
            Outline o56 = new Outline();
            addObject(o56,this.getRealX(11),this.getRealY(7));
            //Spieler
            addObject(player55,this.getRealX(2),this.getRealY(8));
            player55.setRotation(270);
        } else if (type == 2) {
            //Oben, Typ 3
            
            //Wände
            Wall wall000 = new Wall("F");
            addObject(wall000,this.getRealX(1),this.getRealY(5));
            
            Wall wall001 = new Wall("F");
            addObject(wall001,this.getRealX(1),this.getRealY(6));
            Wall wall002 = new Wall("F");
            addObject(wall002,this.getRealX(3),this.getRealY(6));
            Wall wall003 = new Wall("F");
            addObject(wall003,this.getRealX(4),this.getRealY(6));
            Wall wall004 = new Wall("F");
            addObject(wall004,this.getRealX(5),this.getRealY(6));
            Wall wall005 = new Wall("F");
            addObject(wall005,this.getRealX(7),this.getRealY(6));
            Wall wall006 = new Wall("F");
            addObject(wall006,this.getRealX(8),this.getRealY(6));
            Wall wall007 = new Wall("F");
            addObject(wall007,this.getRealX(9),this.getRealY(6));
            Wall wall008 = new Wall("F");
            addObject(wall008,this.getRealX(10),this.getRealY(6));
            Wall wall009 = new Wall("F");
            addObject(wall009,this.getRealX(11),this.getRealY(6));
            Wall wall010 = new Wall("F");
            addObject(wall010,this.getRealX(12),this.getRealY(6));
            Wall wall011 = new Wall("F");
            addObject(wall011,this.getRealX(13),this.getRealY(6));
            
            Wall wall012 = new Wall("F");
            addObject(wall012,this.getRealX(4),this.getRealY(7));
            Wall wall013 = new Wall("F");
            addObject(wall013,this.getRealX(5),this.getRealY(7));
            Wall wall014 = new Wall("F");
            addObject(wall014,this.getRealX(6),this.getRealY(7));
            Wall wall015 = new Wall("F");
            addObject(wall015,this.getRealX(7),this.getRealY(7));
            Wall wall016 = new Wall("F");
            addObject(wall016,this.getRealX(11),this.getRealY(7));
            
            Wall wall017 = new Wall("F");
            addObject(wall017,this.getRealX(1),this.getRealY(8));
            Wall wall018 = new Wall("F");
            addObject(wall018,this.getRealX(2),this.getRealY(8));
            Wall wall019 = new Wall("F");
            addObject(wall019,this.getRealX(9),this.getRealY(8));
            Wall wall020 = new Wall("F");
            addObject(wall020,this.getRealX(13),this.getRealY(8));
            
            
            
            //Markierung
            Outline o56 = new Outline();
            addObject(o56,this.getRealX(13),this.getRealY(7));
            //Spieler
            addObject(player55,this.getRealX(6),this.getRealY(6));
            player55.setRotation(270);
        }
        
        Spieler player56 = new Spieler(this.loadCharacter());
        
        type = (int)(Math.random()*3);
        
        if (type == 0) {
            //Unten, Typ 1
            
            //Wände
            Wall wall100 = new Wall("F");
            addObject(wall100,this.getRealX(1),this.getRealY(10));
            Wall wall101 = new Wall("F");
            addObject(wall101,this.getRealX(2),this.getRealY(10));
            Wall wall102 = new Wall("F");
            addObject(wall102,this.getRealX(3),this.getRealY(10));
            Wall wall103 = new Wall("F");
            addObject(wall103,this.getRealX(4),this.getRealY(10));
            Wall wall104 = new Wall("F");
            addObject(wall104,this.getRealX(5),this.getRealY(10));
            Wall wall105 = new Wall("F");
            addObject(wall105,this.getRealX(6),this.getRealY(10));
            Wall wall106 = new Wall("F");
            addObject(wall106,this.getRealX(7),this.getRealY(10));
            Wall wall107 = new Wall("F");
            addObject(wall107,this.getRealX(12),this.getRealY(10));
            Wall wall108 = new Wall("F");
            addObject(wall108,this.getRealX(13),this.getRealY(10));
            
            Wall wall109 = new Wall("F");
            addObject(wall109,this.getRealX(9),this.getRealY(11));
            Wall wall110 = new Wall("F");
            addObject(wall110,this.getRealX(10),this.getRealY(11));
            Wall wall117 = new Wall("F");
            addObject(wall117,this.getRealX(12),this.getRealY(11));
            Wall wall118 = new Wall("F");
            addObject(wall118,this.getRealX(13),this.getRealY(11));
            
            Wall wall111 = new Wall("F");
            addObject(wall111,this.getRealX(1),this.getRealY(12));
            Wall wall112 = new Wall("F");
            addObject(wall112,this.getRealX(2),this.getRealY(12));
            Wall wall113 = new Wall("F");
            addObject(wall113,this.getRealX(3),this.getRealY(12));
            Wall wall114 = new Wall("F");
            addObject(wall114,this.getRealX(5),this.getRealY(12));
            Wall wall115 = new Wall("F");
            addObject(wall115,this.getRealX(6),this.getRealY(12));
            Wall wall116 = new Wall("F");
            addObject(wall116,this.getRealX(7),this.getRealY(12));
            Wall wall131 = new Wall("F");
            addObject(wall131,this.getRealX(9),this.getRealY(12));
            
            Wall wall119 = new Wall("F");
            addObject(wall119,this.getRealX(1),this.getRealY(13));
            Wall wall120 = new Wall("F");
            addObject(wall120,this.getRealX(2),this.getRealY(13));
            Wall wall121 = new Wall("F");
            addObject(wall121,this.getRealX(3),this.getRealY(13));
            Wall wall122 = new Wall("F");
            addObject(wall122,this.getRealX(5),this.getRealY(13));
            Wall wall124 = new Wall("F");
            addObject(wall124,this.getRealX(6),this.getRealY(13));
            Wall wall125 = new Wall("F");
            addObject(wall125,this.getRealX(7),this.getRealY(13));
            Wall wall126 = new Wall("F");
            addObject(wall126,this.getRealX(9),this.getRealY(13));
            Wall wall127 = new Wall("F");
            addObject(wall127,this.getRealX(10),this.getRealY(13));
            Wall wall128 = new Wall("F");
            addObject(wall128,this.getRealX(11),this.getRealY(13));
            Wall wall129 = new Wall("F");
            addObject(wall129,this.getRealX(12),this.getRealY(13));
            Wall wall130 = new Wall("F");
            addObject(wall130,this.getRealX(13),this.getRealY(13));
            
            
            
            //Markierung
            Outline o57 = new Outline();
            addObject(o57,this.getRealX(10),this.getRealY(12));
            //Spieler
            addObject(player56,this.getRealX(4),this.getRealY(13));
            player56.setRotation(270);
        } else if (type == 1) {
            //Unten, Typ 2
            
            //Wände
            Wall wall100 = new Wall("F");
            addObject(wall100,this.getRealX(1),this.getRealY(10));
            Wall wall101 = new Wall("F");
            addObject(wall101,this.getRealX(2),this.getRealY(10));
            Wall wall102 = new Wall("F");
            addObject(wall102,this.getRealX(4),this.getRealY(10));
            Wall wall103 = new Wall("F");
            addObject(wall103,this.getRealX(5),this.getRealY(10));
            Wall wall104 = new Wall("F");
            addObject(wall104,this.getRealX(6),this.getRealY(10));
            Wall wall105 = new Wall("F");
            addObject(wall105,this.getRealX(7),this.getRealY(10));
            Wall wall106 = new Wall("F");
            addObject(wall106,this.getRealX(8),this.getRealY(10));
            Wall wall107 = new Wall("F");
            addObject(wall107,this.getRealX(12),this.getRealY(10));
            
            Wall wall108 = new Wall("F");
            addObject(wall108,this.getRealX(4),this.getRealY(11));
            Wall wall109 = new Wall("F");
            addObject(wall109,this.getRealX(5),this.getRealY(11));
            Wall wall110 = new Wall("F");
            addObject(wall110,this.getRealX(6),this.getRealY(11));
            Wall wall117 = new Wall("F");
            addObject(wall117,this.getRealX(7),this.getRealY(11));
            Wall wall118 = new Wall("F");
            addObject(wall118,this.getRealX(8),this.getRealY(11));
            Wall wall111 = new Wall("F");
            addObject(wall111,this.getRealX(10),this.getRealY(11));
            
            Wall wall112 = new Wall("F");
            addObject(wall112,this.getRealX(1),this.getRealY(12));
            Wall wall113 = new Wall("F");
            addObject(wall113,this.getRealX(2),this.getRealY(12));
            Wall wall114 = new Wall("F");
            addObject(wall114,this.getRealX(4),this.getRealY(12));
            Wall wall115 = new Wall("F");
            addObject(wall115,this.getRealX(10),this.getRealY(12));
            Wall wall116 = new Wall("F");
            addObject(wall116,this.getRealX(11),this.getRealY(12));
            Wall wall131 = new Wall("F");
            addObject(wall131,this.getRealX(12),this.getRealY(12));
            
            Wall wall119 = new Wall("F");
            addObject(wall119,this.getRealX(6),this.getRealY(13));
            Wall wall120 = new Wall("F");
            addObject(wall120,this.getRealX(7),this.getRealY(13));
            Wall wall121 = new Wall("F");
            addObject(wall121,this.getRealX(8),this.getRealY(13));
            Wall wall122 = new Wall("F");
            addObject(wall122,this.getRealX(10),this.getRealY(13));
            
            
            
            //Markierung
            Outline o57 = new Outline();
            addObject(o57,this.getRealX(11),this.getRealY(13));
            //Spieler
            addObject(player56,this.getRealX(1),this.getRealY(11));
            player56.setRotation(0);
        } else if (type == 2) {
            //Unten, Typ 3
            
            //Wände
            Wall wall100 = new Wall("F");
            addObject(wall100,this.getRealX(1),this.getRealY(10));
            Wall wall101 = new Wall("F");
            addObject(wall101,this.getRealX(2),this.getRealY(10));
            Wall wall102 = new Wall("F");
            addObject(wall102,this.getRealX(3),this.getRealY(10));
            Wall wall103 = new Wall("F");
            addObject(wall103,this.getRealX(11),this.getRealY(10));
            Wall wall104 = new Wall("F");
            addObject(wall104,this.getRealX(12),this.getRealY(10));
            Wall wall105 = new Wall("F");
            addObject(wall105,this.getRealX(13),this.getRealY(10));
            
            Wall wall106 = new Wall("F");
            addObject(wall106,this.getRealX(2),this.getRealY(11));
            Wall wall107 = new Wall("F");
            addObject(wall107,this.getRealX(3),this.getRealY(11));
            Wall wall108 = new Wall("F");
            addObject(wall108,this.getRealX(5),this.getRealY(11));
            Wall wall109 = new Wall("F");
            addObject(wall109,this.getRealX(6),this.getRealY(11));
            Wall wall110 = new Wall("F");
            addObject(wall110,this.getRealX(8),this.getRealY(11));
            Wall wall117 = new Wall("F");
            addObject(wall117,this.getRealX(9),this.getRealY(11));
            Wall wall118 = new Wall("F");
            addObject(wall118,this.getRealX(10),this.getRealY(11));
            Wall wall111 = new Wall("F");
            addObject(wall111,this.getRealX(11),this.getRealY(11));
            Wall wall112 = new Wall("F");
            addObject(wall112,this.getRealX(12),this.getRealY(11));
            Wall wall113 = new Wall("F");
            addObject(wall113,this.getRealX(13),this.getRealY(11));
            
            Wall wall114 = new Wall("F");
            addObject(wall114,this.getRealX(3),this.getRealY(12));
            Wall wall115 = new Wall("F");
            addObject(wall115,this.getRealX(4),this.getRealY(12));
            Wall wall116 = new Wall("F");
            addObject(wall116,this.getRealX(5),this.getRealY(12));
            Wall wall131 = new Wall("F");
            addObject(wall131,this.getRealX(8),this.getRealY(12));
            Wall wall119 = new Wall("F");
            addObject(wall119,this.getRealX(9),this.getRealY(12));
            Wall wall120 = new Wall("F");
            addObject(wall120,this.getRealX(10),this.getRealY(12));
            Wall wall121 = new Wall("F");
            addObject(wall121,this.getRealX(11),this.getRealY(12));
            Wall wall122 = new Wall("F");
            addObject(wall122,this.getRealX(12),this.getRealY(12));
            Wall wall124 = new Wall("F");
            addObject(wall124,this.getRealX(13),this.getRealY(12));
            
            Wall wall125 = new Wall("F");
            addObject(wall125,this.getRealX(1),this.getRealY(13));
            Wall wall126 = new Wall("F");
            addObject(wall126,this.getRealX(7),this.getRealY(13));
            Wall wall127 = new Wall("F");
            addObject(wall127,this.getRealX(8),this.getRealY(13));
            Wall wall128 = new Wall("F");
            addObject(wall128,this.getRealX(9),this.getRealY(13));
            Wall wall129 = new Wall("F");
            addObject(wall129,this.getRealX(10),this.getRealY(13));
            Wall wall130 = new Wall("F");
            addObject(wall130,this.getRealX(11),this.getRealY(13));
            Wall wall133 = new Wall("F");
            addObject(wall133,this.getRealX(12),this.getRealY(13));
            Wall wall132 = new Wall("F");
            addObject(wall132,this.getRealX(13),this.getRealY(13));
            
            
            
            //Markierung
            Outline o57 = new Outline();
            addObject(o57,this.getRealX(4),this.getRealY(11));
            //Spieler
            addObject(player56,this.getRealX(1),this.getRealY(11));
            player56.setRotation(90);
        }
        
  
        
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player55,player56},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L06() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(13),this.getRealY(4));
        Wall wall14 = new Wall("FOLWS");
        addObject(wall14,this.getRealX(14),this.getRealY(4));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(14),this.getRealY(5));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(14),this.getRealY(6));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(14),this.getRealY(7));
        Wall wall18 = new Wall("FEV");
        addObject(wall18,this.getRealX(14),this.getRealY(8));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(14),this.getRealY(9));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(14),this.getRealY(10));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(14),this.getRealY(11));
        Wall wall22 = new Wall("FEV");
        addObject(wall22,this.getRealX(14),this.getRealY(12));
        Wall wall23 = new Wall("FEV");
        addObject(wall23,this.getRealX(14),this.getRealY(13));
        Wall wall24 = new Wall("FOLNW");
        addObject(wall24,this.getRealX(14),this.getRealY(14));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(1),this.getRealY(14));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(2),this.getRealY(14));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(3),this.getRealY(14));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(4),this.getRealY(14));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(5),this.getRealY(14));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(6),this.getRealY(14));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(7),this.getRealY(14));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(8),this.getRealY(14));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(9),this.getRealY(14));
        Wall wall34 = new Wall("FSH");
        addObject(wall34,this.getRealX(10),this.getRealY(14));
        Wall wall35 = new Wall("FSH");
        addObject(wall35,this.getRealX(11),this.getRealY(14));
        Wall wall36 = new Wall("FSH");
        addObject(wall36,this.getRealX(12),this.getRealY(14));
        Wall wall37 = new Wall("FSH");
        addObject(wall37,this.getRealX(13),this.getRealY(14));
        Wall wall38 = new Wall("FOLEN");
        addObject(wall38,this.getRealX(0),this.getRealY(14));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(5));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(6));
        Wall wall41 = new Wall("FWV");
        addObject(wall41,this.getRealX(0),this.getRealY(7));
        Wall wall42 = new Wall("FWV");
        addObject(wall42,this.getRealX(0),this.getRealY(8));
        Wall wall43 = new Wall("FWV");
        addObject(wall43,this.getRealX(0),this.getRealY(9));
        Wall wall44 = new Wall("FWV");
        addObject(wall44,this.getRealX(0),this.getRealY(10));
        Wall wall45 = new Wall("FWV");
        addObject(wall45,this.getRealX(0),this.getRealY(11));
        Wall wall46 = new Wall("FWV");
        addObject(wall46,this.getRealX(0),this.getRealY(12));
        Wall wall47 = new Wall("FWV");
        addObject(wall47,this.getRealX(0),this.getRealY(13));
        
        Wall wall44x = new Wall("H");
        addObject(wall44x,this.getRealX(1),this.getRealY(9));
        Wall wall45x = new Wall("H");
        addObject(wall45x,this.getRealX(2),this.getRealY(9));
        Wall wall46x = new Wall("H");
        addObject(wall46x,this.getRealX(3),this.getRealY(9));
        Wall wall47x = new Wall("H");
        addObject(wall47x,this.getRealX(4),this.getRealY(9));
        Wall wall48x = new Wall("H");
        addObject(wall48x,this.getRealX(5),this.getRealY(9));
        Wall wall49x = new Wall("H");
        addObject(wall49x,this.getRealX(6),this.getRealY(9));
        Wall wall50x = new Wall("H");
        addObject(wall50x,this.getRealX(7),this.getRealY(9));
        Wall wall51x = new Wall("H");
        addObject(wall51x,this.getRealX(8),this.getRealY(9));
        Wall wall52x = new Wall("H");
        addObject(wall52x,this.getRealX(9),this.getRealY(9));
        Wall wall53x = new Wall("H");
        addObject(wall53x,this.getRealX(10),this.getRealY(9));
        Wall wall54x = new Wall("H");
        addObject(wall54x,this.getRealX(11),this.getRealY(9));
        Wall wall54xx = new Wall("H");
        addObject(wall54xx,this.getRealX(12),this.getRealY(9));
        Wall wall54xxx = new Wall("H");
        addObject(wall54xxx,this.getRealX(13),this.getRealY(9));
        
        Spieler player55 = new Spieler(this.loadCharacter());
        int type = (int)(Math.random()*3);
        if (type == 0) {
            //Oben, Typ 1
            
            //Wände
            Wall wall000 = new Wall("F");
            addObject(wall000,this.getRealX(3),this.getRealY(5));
            Wall wall001 = new Wall("F");
            addObject(wall001,this.getRealX(8),this.getRealY(5));
            
            Wall wall002 = new Wall("F");
            addObject(wall002,this.getRealX(2),this.getRealY(6));
            Wall wall003 = new Wall("F");
            addObject(wall003,this.getRealX(3),this.getRealY(6));
            Wall wall004 = new Wall("F");
            addObject(wall004,this.getRealX(5),this.getRealY(6));
            Wall wall005 = new Wall("F");
            addObject(wall005,this.getRealX(6),this.getRealY(6));
            Wall wall006 = new Wall("F");
            addObject(wall006,this.getRealX(7),this.getRealY(6));
            Wall wall007 = new Wall("F");
            addObject(wall007,this.getRealX(8),this.getRealY(6));
            Wall wall008 = new Wall("F");
            addObject(wall008,this.getRealX(10),this.getRealY(6));
            Wall wall009 = new Wall("F");
            addObject(wall009,this.getRealX(11),this.getRealY(6));
            Wall wall010 = new Wall("F");
            addObject(wall010,this.getRealX(13),this.getRealY(6));
            
            Wall wall011 = new Wall("F");
            addObject(wall011,this.getRealX(10),this.getRealY(7));
            
            Wall wall012 = new Wall("F");
            addObject(wall012,this.getRealX(2),this.getRealY(8));
            Wall wall013 = new Wall("F");
            addObject(wall013,this.getRealX(3),this.getRealY(8));
            Wall wall014 = new Wall("F");
            addObject(wall014,this.getRealX(5),this.getRealY(8));
            Wall wall015 = new Wall("F");
            addObject(wall015,this.getRealX(6),this.getRealY(8));
            Wall wall016 = new Wall("F");
            addObject(wall016,this.getRealX(8),this.getRealY(8));
            Wall wall017 = new Wall("F");
            addObject(wall017,this.getRealX(9),this.getRealY(8));
            Wall wall018 = new Wall("F");
            addObject(wall018,this.getRealX(10),this.getRealY(8));
            Wall wall019 = new Wall("F");
            addObject(wall019,this.getRealX(11),this.getRealY(8));
            Wall wall020 = new Wall("F");
            addObject(wall020,this.getRealX(13),this.getRealY(8));
           
            
            //Markierung
            Outline o56 = new Outline();
            addObject(o56,this.getRealX(11),this.getRealY(7));
            //Spieler
            addObject(player55,this.getRealX(2),this.getRealY(5));
            player55.setRotation(180);
            
        } else if (type == 1) {
            //Oben, Typ 2
            
            //Wände
            Wall wall000 = new Wall("F");
            addObject(wall000,this.getRealX(2),this.getRealY(5));
            Wall wall001 = new Wall("F");
            addObject(wall001,this.getRealX(3),this.getRealY(5));
            Wall wall002 = new Wall("F");
            addObject(wall002,this.getRealX(5),this.getRealY(5));
            Wall wall003 = new Wall("F");
            addObject(wall003,this.getRealX(6),this.getRealY(5));
            Wall wall004 = new Wall("F");
            addObject(wall004,this.getRealX(8),this.getRealY(5));
            Wall wall005 = new Wall("F");
            addObject(wall005,this.getRealX(9),this.getRealY(5));
            Wall wall006 = new Wall("F");
            addObject(wall006,this.getRealX(11),this.getRealY(5));
            Wall wall007 = new Wall("F");
            addObject(wall007,this.getRealX(12),this.getRealY(5));
            
            Wall wall008 = new Wall("F");
            addObject(wall008,this.getRealX(11),this.getRealY(6));
            Wall wall009 = new Wall("F");
            addObject(wall009,this.getRealX(12),this.getRealY(6));
            
            Wall wall010 = new Wall("F");
            addObject(wall010,this.getRealX(2),this.getRealY(7));
            Wall wall011 = new Wall("F");
            addObject(wall011,this.getRealX(3),this.getRealY(7));
            Wall wall012 = new Wall("F");
            addObject(wall012,this.getRealX(5),this.getRealY(7));
            Wall wall013 = new Wall("F");
            addObject(wall013,this.getRealX(6),this.getRealY(7));
            Wall wall014 = new Wall("F");
            addObject(wall014,this.getRealX(7),this.getRealY(7));
            Wall wall015 = new Wall("F");
            addObject(wall015,this.getRealX(9),this.getRealY(7));
            
            Wall wall016 = new Wall("F");
            addObject(wall016,this.getRealX(2),this.getRealY(8));
            Wall wall017 = new Wall("F");
            addObject(wall017,this.getRealX(9),this.getRealY(8));
            Wall wall018 = new Wall("F");
            addObject(wall018,this.getRealX(10),this.getRealY(8));
            Wall wall019 = new Wall("F");
            addObject(wall019,this.getRealX(12),this.getRealY(8));
            Wall wall020 = new Wall("F");
            addObject(wall020,this.getRealX(13),this.getRealY(8));
           
            
            //Markierung
            Outline o56 = new Outline();
            addObject(o56,this.getRealX(11),this.getRealY(8));
            //Spieler
            addObject(player55,this.getRealX(4),this.getRealY(5));
            player55.setRotation(90);
            
        } else if (type == 2) {
            //Oben, Typ 3
            
            //Wände
            Wall wall000 = new Wall("F");
            addObject(wall000,this.getRealX(1),this.getRealY(5));
            Wall wall001 = new Wall("F");
            addObject(wall001,this.getRealX(2),this.getRealY(5));
            Wall wall002 = new Wall("F");
            addObject(wall002,this.getRealX(4),this.getRealY(5));
            Wall wall003 = new Wall("F");
            addObject(wall003,this.getRealX(5),this.getRealY(5));
            Wall wall004 = new Wall("F");
            addObject(wall004,this.getRealX(6),this.getRealY(5));
            Wall wall005 = new Wall("F");
            addObject(wall005,this.getRealX(8),this.getRealY(5));
            Wall wall006 = new Wall("F");
            addObject(wall006,this.getRealX(9),this.getRealY(5));
            Wall wall007 = new Wall("F");
            addObject(wall007,this.getRealX(10),this.getRealY(5));
            Wall wall008 = new Wall("F");
            addObject(wall008,this.getRealX(12),this.getRealY(5));
            Wall wall009 = new Wall("F");
            addObject(wall009,this.getRealX(13),this.getRealY(5));
            
            Wall wall010 = new Wall("F");
            addObject(wall010,this.getRealX(13),this.getRealY(6));
            
            Wall wall011 = new Wall("F");
            addObject(wall011,this.getRealX(1),this.getRealY(7));            
            Wall wall012 = new Wall("F");
            addObject(wall012,this.getRealX(2),this.getRealY(7));
            Wall wall013 = new Wall("F");
            addObject(wall013,this.getRealX(4),this.getRealY(7));
            Wall wall014 = new Wall("F");
            addObject(wall014,this.getRealX(5),this.getRealY(7));
            Wall wall015 = new Wall("F");
            addObject(wall015,this.getRealX(6),this.getRealY(7));
            Wall wall016 = new Wall("F");
            addObject(wall016,this.getRealX(8),this.getRealY(7));
            Wall wall017 = new Wall("F");
            addObject(wall017,this.getRealX(9),this.getRealY(7));
            Wall wall018 = new Wall("F");
            addObject(wall018,this.getRealX(10),this.getRealY(7));
            Wall wall019 = new Wall("F");
            addObject(wall019,this.getRealX(12),this.getRealY(7));
            Wall wall020 = new Wall("F");
            addObject(wall020,this.getRealX(13),this.getRealY(7));
            
            Wall wall021 = new Wall("F");
            addObject(wall021,this.getRealX(1),this.getRealY(8));
            Wall wall022 = new Wall("F");
            addObject(wall022,this.getRealX(13),this.getRealY(8));
           
            
            //Markierung
            Outline o56 = new Outline();
            addObject(o56,this.getRealX(1),this.getRealY(6));
            //Spieler
            addObject(player55,this.getRealX(12),this.getRealY(6));
            player55.setRotation(180);
            
        }
        
        Spieler player56 = new Spieler(this.loadCharacter());
        
        type = (int)(Math.random()*3);
        
        if (type == 0) {
            //Unten, Typ 1
            
            //Wände
            Wall wall100 = new Wall("F");
            addObject(wall100,this.getRealX(1),this.getRealY(10));
            Wall wall101 = new Wall("F");
            addObject(wall101,this.getRealX(2),this.getRealY(10));
            Wall wall102 = new Wall("F");
            addObject(wall102,this.getRealX(6),this.getRealY(10));
            Wall wall103 = new Wall("F");
            addObject(wall103,this.getRealX(8),this.getRealY(10));
            Wall wall104 = new Wall("F");
            addObject(wall104,this.getRealX(9),this.getRealY(10));
            Wall wall105 = new Wall("F");
            addObject(wall105,this.getRealX(13),this.getRealY(10));
            
            Wall wall106 = new Wall("F");
            addObject(wall106,this.getRealX(1),this.getRealY(11));
            Wall wall107 = new Wall("F");
            addObject(wall107,this.getRealX(4),this.getRealY(11));
            Wall wall108 = new Wall("F");
            addObject(wall108,this.getRealX(11),this.getRealY(11));
            
            Wall wall109 = new Wall("F");
            addObject(wall109,this.getRealX(1),this.getRealY(12));
            Wall wall110 = new Wall("F");
            addObject(wall110,this.getRealX(3),this.getRealY(12));
            Wall wall117 = new Wall("F");
            addObject(wall117,this.getRealX(4),this.getRealY(12));
            Wall wall118 = new Wall("F");
            addObject(wall118,this.getRealX(5),this.getRealY(12));
            Wall wall111 = new Wall("F");
            addObject(wall111,this.getRealX(6),this.getRealY(12));
            Wall wall112 = new Wall("F");
            addObject(wall112,this.getRealX(7),this.getRealY(12));
            Wall wall113 = new Wall("F");
            addObject(wall113,this.getRealX(9),this.getRealY(12));
            Wall wall114 = new Wall("F");
            addObject(wall114,this.getRealX(10),this.getRealY(12));
            
            Wall wall115 = new Wall("F");
            addObject(wall115,this.getRealX(4),this.getRealY(13));
            Wall wall116 = new Wall("F");
            addObject(wall116,this.getRealX(5),this.getRealY(13));
            Wall wall131 = new Wall("F");
            addObject(wall131,this.getRealX(10),this.getRealY(13));
            Wall wall119 = new Wall("F");
            addObject(wall119,this.getRealX(11),this.getRealY(13));
            Wall wall120 = new Wall("F");
            addObject(wall120,this.getRealX(12),this.getRealY(13));
            
            
            
            
            //Markierung
            Outline o57 = new Outline();
            addObject(o57,this.getRealX(11),this.getRealY(12));
            //Spieler
            addObject(player56,this.getRealX(6),this.getRealY(13));
            player56.setRotation(0);
        } else if (type == 1) {
            //Unten, Typ 2
            
            //Wände
            Wall wall100 = new Wall("F");
            addObject(wall100,this.getRealX(12),this.getRealY(10));
            
            Wall wall101 = new Wall("F");
            addObject(wall101,this.getRealX(2),this.getRealY(11));
            Wall wall102 = new Wall("F");
            addObject(wall102,this.getRealX(4),this.getRealY(11));
            Wall wall103 = new Wall("F");
            addObject(wall103,this.getRealX(5),this.getRealY(11));
            Wall wall104 = new Wall("F");
            addObject(wall104,this.getRealX(6),this.getRealY(11));
            Wall wall105 = new Wall("F");
            addObject(wall105,this.getRealX(7),this.getRealY(11));
            Wall wall106 = new Wall("F");
            addObject(wall106,this.getRealX(8),this.getRealY(11));
            Wall wall107 = new Wall("F");
            addObject(wall107,this.getRealX(10),this.getRealY(11));
            Wall wall108 = new Wall("F");
            addObject(wall108,this.getRealX(12),this.getRealY(11));
            
            Wall wall109 = new Wall("F");
            addObject(wall109,this.getRealX(2),this.getRealY(12));
            Wall wall110 = new Wall("F");
            addObject(wall110,this.getRealX(3),this.getRealY(12));
            Wall wall117 = new Wall("F");
            addObject(wall117,this.getRealX(4),this.getRealY(12));
            Wall wall118 = new Wall("F");
            addObject(wall118,this.getRealX(6),this.getRealY(12));
            Wall wall111 = new Wall("F");
            addObject(wall111,this.getRealX(8),this.getRealY(12));
            Wall wall112 = new Wall("F");
            addObject(wall112,this.getRealX(10),this.getRealY(12));
            Wall wall113 = new Wall("F");
            addObject(wall113,this.getRealX(11),this.getRealY(12));
            Wall wall114 = new Wall("F");
            addObject(wall114,this.getRealX(12),this.getRealY(12));
            
            Wall wall115 = new Wall("F");
            addObject(wall115,this.getRealX(6),this.getRealY(13));
            
            
            
            
            
            //Markierung
            Outline o57 = new Outline();
            addObject(o57,this.getRealX(11),this.getRealY(11));
            //Spieler
            addObject(player56,this.getRealX(3),this.getRealY(11));
            player56.setRotation(270);
        } else if (type == 2) {
            //Unten, Typ 3
            
            //Wände
            Wall wall100 = new Wall("F");
            addObject(wall100,this.getRealX(5),this.getRealY(10));
            Wall wall101 = new Wall("F");
            addObject(wall101,this.getRealX(7),this.getRealY(10));
            Wall wall102 = new Wall("F");
            addObject(wall102,this.getRealX(11),this.getRealY(10));
            
            Wall wall103 = new Wall("F");
            addObject(wall103,this.getRealX(1),this.getRealY(11));
            Wall wall104 = new Wall("F");
            addObject(wall104,this.getRealX(3),this.getRealY(11));
            Wall wall105 = new Wall("F");
            addObject(wall105,this.getRealX(4),this.getRealY(11));
            Wall wall106 = new Wall("F");
            addObject(wall106,this.getRealX(5),this.getRealY(11));
            Wall wall107 = new Wall("F");
            addObject(wall107,this.getRealX(7),this.getRealY(11));
            Wall wall108 = new Wall("F");
            addObject(wall108,this.getRealX(8),this.getRealY(11));
            Wall wall109 = new Wall("F");
            addObject(wall109,this.getRealX(9),this.getRealY(11));
            Wall wall110 = new Wall("F");
            addObject(wall110,this.getRealX(11),this.getRealY(11));
            Wall wall117 = new Wall("F");
            addObject(wall117,this.getRealX(13),this.getRealY(11));
            
            Wall wall118 = new Wall("F");
            addObject(wall118,this.getRealX(1),this.getRealY(13));
            Wall wall111 = new Wall("F");
            addObject(wall111,this.getRealX(3),this.getRealY(13));
            Wall wall112 = new Wall("F");
            addObject(wall112,this.getRealX(5),this.getRealY(13));
            Wall wall113 = new Wall("F");
            addObject(wall113,this.getRealX(7),this.getRealY(13));
            Wall wall114 = new Wall("F");
            addObject(wall114,this.getRealX(9),this.getRealY(13));
            Wall wall115 = new Wall("F");
            addObject(wall115,this.getRealX(11),this.getRealY(13));
            Wall wall116 = new Wall("F");
            addObject(wall116,this.getRealX(13),this.getRealY(13));
            
            
            
            
            //Markierung
            Outline o57 = new Outline();
            addObject(o57,this.getRealX(8),this.getRealY(10));
            //Spieler
            addObject(player56,this.getRealX(6),this.getRealY(13));
            player56.setRotation(270);
        }

        
 
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player55, player56},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L07() {
        
        
        Wall wall7 = new Wall("FOLSE");
        addObject(wall7,this.getRealX(0),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(1),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(2),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(3),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(4),this.getRealY(4));
        Wall wall12 = new Wall("FNH");
        addObject(wall12,this.getRealX(5),this.getRealY(4));
        Wall wall13 = new Wall("FNH");
        addObject(wall13,this.getRealX(6),this.getRealY(4));
        Wall wall14 = new Wall("FNH");
        addObject(wall14,this.getRealX(7),this.getRealY(4));
        Wall wall15 = new Wall("FNH");
        addObject(wall15,this.getRealX(8),this.getRealY(4));
        Wall wall16 = new Wall("FNH");
        addObject(wall16,this.getRealX(9),this.getRealY(4));
        Wall wall17 = new Wall("FNH");
        addObject(wall17,this.getRealX(10),this.getRealY(4));
        Wall wall18 = new Wall("FOLWS");
        addObject(wall18,this.getRealX(11),this.getRealY(4));
        Wall wall19 = new Wall("FEV");
        addObject(wall19,this.getRealX(11),this.getRealY(5));
        Wall wall20 = new Wall("FEV");
        addObject(wall20,this.getRealX(11),this.getRealY(6));
        Wall wall21 = new Wall("FEV");
        addObject(wall21,this.getRealX(11),this.getRealY(7));
        Wall wall22 = new Wall("FEV");
        addObject(wall22,this.getRealX(11),this.getRealY(8));
        Wall wall23 = new Wall("FEV");
        addObject(wall23,this.getRealX(11),this.getRealY(9));
        Wall wall24 = new Wall("FOLNW");
        addObject(wall24,this.getRealX(11),this.getRealY(10));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(1),this.getRealY(10));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(2),this.getRealY(10));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(3),this.getRealY(10));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(4),this.getRealY(10));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(5),this.getRealY(10));
        Wall wall30 = new Wall("FSH");
        addObject(wall30,this.getRealX(6),this.getRealY(10));
        Wall wall31 = new Wall("FSH");
        addObject(wall31,this.getRealX(7),this.getRealY(10));
        Wall wall32 = new Wall("FSH");
        addObject(wall32,this.getRealX(8),this.getRealY(10));
        Wall wall33 = new Wall("FSH");
        addObject(wall33,this.getRealX(9),this.getRealY(10));
        Wall wall34 = new Wall("FSH");
        addObject(wall34,this.getRealX(10),this.getRealY(10));
        Wall wall35 = new Wall("FOLEN");
        addObject(wall35,this.getRealX(0),this.getRealY(10));
        Wall wall36 = new Wall("FWV");
        addObject(wall36,this.getRealX(0),this.getRealY(5));
        Wall wall37 = new Wall("FWV");
        addObject(wall37,this.getRealX(0),this.getRealY(6));
        Wall wall38 = new Wall("FWV");
        addObject(wall38,this.getRealX(0),this.getRealY(7));
        Wall wall39 = new Wall("FWV");
        addObject(wall39,this.getRealX(0),this.getRealY(8));
        Wall wall40 = new Wall("FWV");
        addObject(wall40,this.getRealX(0),this.getRealY(9));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(1),this.getRealY(7));
        Wall wall42 = new Wall("H");
        addObject(wall42,this.getRealX(2),this.getRealY(7));
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(3),this.getRealY(7));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(4),this.getRealY(7));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(5),this.getRealY(7));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(6),this.getRealY(7));
        Wall wall47 = new Wall("H");
        addObject(wall47,this.getRealX(7),this.getRealY(7));
        Wall wall48 = new Wall("H");
        addObject(wall48,this.getRealX(8),this.getRealY(7));
        Wall wall49 = new Wall("H");
        addObject(wall49,this.getRealX(9),this.getRealY(7));
        Wall wall50 = new Wall("H");
        addObject(wall50,this.getRealX(10),this.getRealY(7));
        
        int pl1 = (int)(Math.random()*20);
        Platform p0 = new Platform(pl1); //Zufälliger Wert
        addObject(p0,this.getRealX(1),this.getRealY(6));
        
        //Nun werden 9 Kugeln kreiiert, alle mit zufälligen Werten, aber eine davon hat definitiv die richtige Zahl
        int who = (int)(Math.random()*9);
        int st1 = 1;
        int en1 = 1;
        int st2 = 9;
        int en2 = 9;
    
        if (who == 0) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(2),this.getRealY(5));
            
            st1 = 0;
            en1 = 0;
            st2 = 2;
            en2 = 9;
        } else if (who == 1) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(3),this.getRealY(5));
            
            st1 = 1;
            en1 = 1;
            st2 = 3;
            en2 = 9;
        }  else if (who == 2) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(4),this.getRealY(5));
            
            st1 = 1;
            en1 = 2;
            st2 = 4;
            en2 = 9;
        }  else if (who == 3) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(5),this.getRealY(5));
            
            st1 = 1;
            en1 = 3;
            st2 = 5;
            en2 = 9;
        }  else if (who == 4) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(6),this.getRealY(5));
            
            st1 = 1;
            en1 = 4;
            st2 = 6;
            en2 = 9;
        }  else if (who == 5) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(7),this.getRealY(5));
            
            st1 = 1;
            en1 = 5;
            st2 = 7;
            en2 = 9;
        }  else if (who == 6) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(8),this.getRealY(5));
            
            st1 = 1;
            en1 = 6;
            st2 = 8;
            en2 = 9;
        }  else if (who == 7) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(9),this.getRealY(5));
            
            st1 = 1;
            en1 = 7;
            st2 = 9;
            en2 = 9;
        }  else if (who == 8) {
            Sphere s1 = new Sphere(pl1);
            addObject(s1,this.getRealX(10),this.getRealY(5));
            
            st1 = 1;
            en1 = 8;
            st2 = 0;
            en2 = 0;
        }
        
        if (st1 != 0) {
            for (int x = 0; en1-st1-x >= 0; x++) {
                addObject(new Sphere((int)(Math.random()*20)),this.getRealX(2+x),this.getRealY(5));
            }
        }
        if (st2 != 0) {
            for (int x = 0; en2-st2-x >= 0; x++) {
                addObject(new Sphere((int)(Math.random()*20)),this.getRealX(2+x+(who+1)),this.getRealY(5));
            }
        }
        
        pl1 = (int)(Math.random()*20);
        Platform p1 = new Platform(pl1); //Zufälliger Wert
        addObject(p1,this.getRealX(1),this.getRealY(9));
        
        //Nun werden 9 Kugeln kreiiert, alle mit zufälligen Werten, aber eine davon hat definitiv die richtige Zahl
        who = (int)(Math.random()*9);
        st1 = 1;
        en1 = 1;
        st2 = 9;
        en2 = 9;
    
        if (who == 0) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(2),this.getRealY(8));
            
            st1 = 0;
            en1 = 0;
            st2 = 2;
            en2 = 9;
        } else if (who == 1) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(3),this.getRealY(8));
            
            st1 = 1;
            en1 = 1;
            st2 = 3;
            en2 = 9;
        }  else if (who == 2) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(4),this.getRealY(8));
            
            st1 = 1;
            en1 = 2;
            st2 = 4;
            en2 = 9;
        }  else if (who == 3) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(5),this.getRealY(8));
            
            st1 = 1;
            en1 = 3;
            st2 = 5;
            en2 = 9;
        }  else if (who == 4) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(6),this.getRealY(8));
            
            st1 = 1;
            en1 = 4;
            st2 = 6;
            en2 = 9;
        }  else if (who == 5) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(7),this.getRealY(8));
            
            st1 = 1;
            en1 = 5;
            st2 = 7;
            en2 = 9;
        }  else if (who == 6) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(8),this.getRealY(8));
            
            st1 = 1;
            en1 = 6;
            st2 = 8;
            en2 = 9;
        }  else if (who == 7) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(9),this.getRealY(8));
            
            st1 = 1;
            en1 = 7;
            st2 = 9;
            en2 = 9;
        }  else if (who == 8) {
            Sphere s2 = new Sphere(pl1);
            addObject(s2,this.getRealX(10),this.getRealY(8));
            
            st1 = 1;
            en1 = 8;
            st2 = 0;
            en2 = 0;
        }
        
        if (st1 != 0) {
            for (int x = 0; en1-st1-x >= 0; x++) {
                addObject(new Sphere((int)(Math.random()*20)),this.getRealX(2+x),this.getRealY(8));
            }
        }
        if (st2 != 0) {
            for (int x = 0; en2-st2-x >= 0; x++) {
                addObject(new Sphere((int)(Math.random()*20)),this.getRealX(2+x+(who+1)),this.getRealY(8));
            }
        }
        


        Spieler player5 = new Spieler(this.loadCharacter());
        addObject(player5,this.getRealX(2),this.getRealY(6));
        player5.setRotation(180);
        Spieler player6 = new Spieler(this.loadCharacter());
        addObject(player6,this.getRealX(2),this.getRealY(9));
        player6.setRotation(180);
       
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player5,player6},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L08() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FOLWS");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FEV");
        addObject(wall12,this.getRealX(11),this.getRealY(5));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(11),this.getRealY(6));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(11),this.getRealY(7));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(11),this.getRealY(8));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(11),this.getRealY(9));
        Wall wall17 = new Wall("FOLNW");
        addObject(wall17,this.getRealX(11),this.getRealY(10));
        Wall wall18 = new Wall("FSH");
        addObject(wall18,this.getRealX(1),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(2),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(3),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(4),this.getRealY(10));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(5),this.getRealY(10));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(6),this.getRealY(10));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(7),this.getRealY(10));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(8),this.getRealY(10));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(9),this.getRealY(10));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(10),this.getRealY(10));
        Wall wall28 = new Wall("FOLEN");
        addObject(wall28,this.getRealX(0),this.getRealY(10));
        Wall wall29 = new Wall("FWV");
        addObject(wall29,this.getRealX(0),this.getRealY(5));
        Wall wall30 = new Wall("FWV");
        addObject(wall30,this.getRealX(0),this.getRealY(6));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(7));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(8));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(9));
        Wall wall34 = new Wall("H");
        addObject(wall34,this.getRealX(1),this.getRealY(7));
        Wall wall35 = new Wall("H");
        addObject(wall35,this.getRealX(2),this.getRealY(7));
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(3),this.getRealY(7));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(4),this.getRealY(7));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(5),this.getRealY(7));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(6),this.getRealY(7));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(7),this.getRealY(7));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(8),this.getRealY(7));
        Wall wall42 = new Wall("H");
        addObject(wall42,this.getRealX(9),this.getRealY(7));
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(10),this.getRealY(7));
        
        this.setMaximumChecks(5); //Damit Abfragen gezählt werden.
        
        int pl1 = (int)(Math.random()*90);
        Platform p0 = new Platform(pl1); //Zufälliger Wert
        addObject(p0,this.getRealX(1),this.getRealY(6));
        
        //Nun werden 9 Kugeln kreiiert, alle mit zufälligen Werten, aber eine davon hat definitiv die richtige Zahl
        //Wenn pl1 < mitte
        //dann muss pl2 > mitte sein.
        
        Sphere[] spheres = new Sphere[9];
        for (int i = 0; i < 9; i++) {
            if ((pl1 >= (i*10)) && (pl1 < ((i+1)*10))) {
                spheres[i] = new Sphere(pl1);
            } else {
                int v = (int)(Math.random()*10);
                spheres[i] = new Sphere((i*10)+v);
            }
            addObject(spheres[i],this.getRealX(2+i),this.getRealY(5));
            
        }
        
        int pl2;
        if (pl1 >= 40) {
            pl2 = (int)(Math.random()*40);
        } else {
            pl2 = (int)(Math.random()*50)+40;
        }
        Platform p1 = new Platform(pl2); //Zufälliger Wert
        addObject(p1,this.getRealX(1),this.getRealY(9));
        
        //Nun werden 9 Kugeln kreiiert, alle mit zufälligen Werten, aber eine davon hat definitiv die richtige Zahl
        
        
        spheres = new Sphere[9];
        for (int i = 0; i < 9; i++) {
            if ((pl2 >= (i*10)) && (pl2 < ((i+1)*10))) {
                spheres[i] = new Sphere(pl2);
            } else {
                int v = (int)(Math.random()*10);
                spheres[i] = new Sphere((i*10)+v);
            }
            addObject(spheres[i],this.getRealX(2+i),this.getRealY(8));
            
        }
        
        
    
        
        
        
        
        
        Spieler player45 = new Spieler(this.loadCharacter());
        addObject(player45,this.getRealX(2),this.getRealY(6));
        player45.setRotation(180);
        Spieler player47 = new Spieler(this.loadCharacter());
        addObject(player47,this.getRealX(2),this.getRealY(9));
        player47.setRotation(180);
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player45,player47},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L09() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FOLNW");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(1),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(2),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(3),this.getRealY(10));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(4),this.getRealY(10));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(5),this.getRealY(10));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(6),this.getRealY(10));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(7),this.getRealY(10));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(8),this.getRealY(10));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(9),this.getRealY(10));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(10),this.getRealY(10));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(11),this.getRealY(10));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(10));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(1),this.getRealY(7));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(2),this.getRealY(7));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(3),this.getRealY(7));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(4),this.getRealY(7));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(5),this.getRealY(7));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(6),this.getRealY(7));
        Wall wall42 = new Wall("H");
        addObject(wall42,this.getRealX(7),this.getRealY(7));
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(8),this.getRealY(7));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(9),this.getRealY(7));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(10),this.getRealY(7));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(11),this.getRealY(7));
        Wall wall47 = new Wall("V");
        addObject(wall47,this.getRealX(6),this.getRealY(5));
        Wall wall48 = new Wall("V");
        addObject(wall48,this.getRealX(6),this.getRealY(6));
        Wall wall49 = new Wall("V");
        addObject(wall49,this.getRealX(6),this.getRealY(7));
        Wall wall50 = new Wall("V");
        addObject(wall50,this.getRealX(6),this.getRealY(8));
        Wall wall51 = new Wall("V");
        addObject(wall51,this.getRealX(6),this.getRealY(9));
        
        int w01 = (int)(Math.random()*100);
        int w02 = (int)(Math.random()*100);
        int w03 = (int)(Math.random()*100);
        
        int sw = 0;
        
        if (w01 < w02) {
            if (w01 < w03) {
                if (w02 < w03) {
                    //A < B < C
                    
                } else {
                    //A < C < B
                    sw = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < A < B
                sw = w01;
                w01 = w03;
                w03 = w02;
                w02 = sw;
            }
        } else {
            //B < A
            if (w02 < w03) {
                if (w01 < w03) {
                    //B < A < C
                    sw = w01;
                    w01 = w02;
                    w02 = sw;
                } else {
                    //B < C < A
                    sw = w01;
                    w01 = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < B < A
                sw = w01;
                    w01 = w03;
                    w03 = sw;
            }
        }
        
        
       
        
        Platform p01 = new Platform(w01);
        p01.setSecret();

        
        Platform p02 = new Platform(w02);
        p02.setSecret();
        
        Platform p03 = new Platform(w03);
        p03.setSecret();
        

        
        int combo = (int)(Math.random()*6);
        Sphere A = new Sphere(w01);
        Sphere B = new Sphere(w02);
        Sphere C = new Sphere(w03);
        if (combo == 0) {
            //A B C
            p01.putSphere(A);
            p02.putSphere(B);
            p03.putSphere(C);
        } else if (combo == 1) {
            //A C B
            p01.putSphere(A);
            p02.putSphere(C);
            p03.putSphere(B);
        } else if (combo == 2) {
            //B A C
            p01.putSphere(B);
            p02.putSphere(A);
            p03.putSphere(C);
        } else if (combo == 3) {
            //B C A
            p01.putSphere(B);
            p02.putSphere(C);
            p03.putSphere(A);
        } else if (combo == 4) {
            //C A B
            p01.putSphere(C);
            p02.putSphere(A);
            p03.putSphere(B);
        } else if (combo == 5) {
            //C B A 
            p01.putSphere(C);
            p02.putSphere(B);
            p03.putSphere(A);
        }
        
        
        
        
        addObject(p03,this.getRealX(4),this.getRealY(5));
        addObject(p01,this.getRealX(2),this.getRealY(5));
        addObject(p02,this.getRealX(3),this.getRealY(5));
        
        
        
        w01 = (int)(Math.random()*100);
        w02 = (int)(Math.random()*100);
        w03 = (int)(Math.random()*100);
        
        sw = 0;
        
        if (w01 < w02) {
            if (w01 < w03) {
                if (w02 < w03) {
                    //A < B < C
                    
                } else {
                    //A < C < B
                    sw = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < A < B
                sw = w01;
                w01 = w03;
                w03 = w02;
                w02 = sw;
            }
        } else {
            //B < A
            if (w02 < w03) {
                if (w01 < w03) {
                    //B < A < C
                    sw = w01;
                    w01 = w02;
                    w02 = sw;
                } else {
                    //B < C < A
                    sw = w01;
                    w01 = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < B < A
                sw = w01;
                    w01 = w03;
                    w03 = sw;
            }
        }
        
        Platform p04 = new Platform(w01);
        p04.setSecret();

        
        Platform p05 = new Platform(w02);
        p05.setSecret();
        
        Platform p06 = new Platform(w03);
        p06.setSecret();
        

        
        combo = (int)(Math.random()*6);
        A = new Sphere(w01);
        B = new Sphere(w02);
        C = new Sphere(w03);
        if (combo == 0) {
            //A B C
            p04.putSphere(A);
            p05.putSphere(B);
            p06.putSphere(C);
        } else if (combo == 1) {
            //A C B
            p04.putSphere(A);
            p05.putSphere(C);
            p06.putSphere(B);
        } else if (combo == 2) {
            //B A C
            p04.putSphere(B);
            p05.putSphere(A);
            p06.putSphere(C);
        } else if (combo == 3) {
            //B C A
            p04.putSphere(B);
            p05.putSphere(C);
            p06.putSphere(A);
        } else if (combo == 4) {
            //C A B
            p04.putSphere(C);
            p05.putSphere(A);
            p06.putSphere(B);
        } else if (combo == 5) {
            //C B A 
            p04.putSphere(C);
            p05.putSphere(B);
            p06.putSphere(A);
        }
        
        
        

        addObject(p04,this.getRealX(8),this.getRealY(5));
        addObject(p05,this.getRealX(9),this.getRealY(5));
        addObject(p06,this.getRealX(10),this.getRealY(5));
        
        w01 = (int)(Math.random()*100);
        w02 = (int)(Math.random()*100);
        w03 = (int)(Math.random()*100);
        
        sw = 0;
        
       
        if (w01 < w02) {
            if (w01 < w03) {
                if (w02 < w03) {
                    //A < B < C
                    
                } else {
                    //A < C < B
                    sw = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < A < B
                sw = w01;
                w01 = w03;
                w03 = w02;
                w02 = sw;
            }
        } else {
            //B < A
            if (w02 < w03) {
                if (w01 < w03) {
                    //B < A < C
                    sw = w01;
                    w01 = w02;
                    w02 = sw;
                } else {
                    //B < C < A
                    sw = w01;
                    w01 = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < B < A
                sw = w01;
                    w01 = w03;
                    w03 = sw;
            }
        }
        
        Platform p07 = new Platform(w01);
        p07.setSecret();

        
        Platform p08 = new Platform(w02);
        p08.setSecret();
        
        Platform p09 = new Platform(w03);
        p09.setSecret();
        

        
        combo = (int)(Math.random()*6);
        A = new Sphere(w01);
        B = new Sphere(w02);
        C = new Sphere(w03);
        if (combo == 0) {
            //A B C
            p07.putSphere(A);
            p08.putSphere(B);
            p09.putSphere(C);
        } else if (combo == 1) {
            //A C B
            p07.putSphere(A);
            p08.putSphere(C);
            p09.putSphere(B);
        } else if (combo == 2) {
            //B A C
            p07.putSphere(B);
            p08.putSphere(A);
            p09.putSphere(C);
        } else if (combo == 3) {
            //B C A
            p07.putSphere(B);
            p08.putSphere(C);
            p09.putSphere(A);
        } else if (combo == 4) {
            //C A B
            p07.putSphere(C);
            p08.putSphere(A);
            p09.putSphere(B);
        } else if (combo == 5) {
            //C B A 
            p07.putSphere(C);
            p08.putSphere(B);
            p09.putSphere(A);
        }
        
        
        

        addObject(p07,this.getRealX(2),this.getRealY(8));
        addObject(p08,this.getRealX(3),this.getRealY(8));
        addObject(p09,this.getRealX(4),this.getRealY(8));
        
        w01 = (int)(Math.random()*100);
        w02 = (int)(Math.random()*100);
        w03 = (int)(Math.random()*100);
        
        sw = 0;
        
        if (w01 < w02) {
            if (w01 < w03) {
                if (w02 < w03) {
                    //A < B < C
                    
                } else {
                    //A < C < B
                    sw = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < A < B
                sw = w01;
                w01 = w03;
                w03 = w02;
                w02 = sw;
            }
        } else {
            //B < A
            if (w02 < w03) {
                if (w01 < w03) {
                    //B < A < C
                    sw = w01;
                    w01 = w02;
                    w02 = sw;
                } else {
                    //B < C < A
                    sw = w01;
                    w01 = w02;
                    w02 = w03;
                    w03 = sw;
                }
            } else {
                //C < B < A
                sw = w01;
                    w01 = w03;
                    w03 = sw;
            }
        }
        
        Platform p17 = new Platform(w01);
        p17.setSecret();

        
        Platform p18 = new Platform(w02);
        p18.setSecret();
        
        Platform p19 = new Platform(w03);
        p19.setSecret();
        

        
        combo = (int)(Math.random()*6);
        A = new Sphere(w01);
        B = new Sphere(w02);
        C = new Sphere(w03);
        if (combo == 0) {
            //A B C
            p17.putSphere(A);
            p18.putSphere(B);
            p19.putSphere(C);
        } else if (combo == 1) {
            //A C B
            p17.putSphere(A);
            p18.putSphere(C);
            p19.putSphere(B);
        } else if (combo == 2) {
            //B A C
            p17.putSphere(B);
            p18.putSphere(A);
            p19.putSphere(C);
        } else if (combo == 3) {
            //B C A
            p17.putSphere(B);
            p18.putSphere(C);
            p19.putSphere(A);
        } else if (combo == 4) {
            //C A B
            p17.putSphere(C);
            p18.putSphere(A);
            p19.putSphere(B);
        } else if (combo == 5) {
            //C B A 
            p17.putSphere(C);
            p18.putSphere(B);
            p19.putSphere(A);
        }
        
        
        

        addObject(p17,this.getRealX(8),this.getRealY(8));
        addObject(p18,this.getRealX(9),this.getRealY(8));
        addObject(p19,this.getRealX(10),this.getRealY(8));
        
        
        Spieler player53 = new Spieler(this.loadCharacter());
        addObject(player53,this.getRealX(2),this.getRealY(6));
        player53.setRotation(270);
        Spieler player54 = new Spieler(this.loadCharacter());
        addObject(player54,this.getRealX(8),this.getRealY(6));
        player54.setRotation(270);
        Spieler player55 = new Spieler(this.loadCharacter());
        addObject(player55,this.getRealX(2),this.getRealY(9));
        player55.setRotation(270);
        Spieler player56 = new Spieler(this.loadCharacter());
        addObject(player56,this.getRealX(8),this.getRealY(9));
        player56.setRotation(270);
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player53,player54,player55,player56},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    public void prepareC06L10() {
        
        Wall wall0 = new Wall("FOLSE");
        addObject(wall0,this.getRealX(0),this.getRealY(4));
        Wall wall1 = new Wall("FNH");
        addObject(wall1,this.getRealX(1),this.getRealY(4));
        Wall wall2 = new Wall("FNH");
        addObject(wall2,this.getRealX(2),this.getRealY(4));
        Wall wall3 = new Wall("FNH");
        addObject(wall3,this.getRealX(3),this.getRealY(4));
        Wall wall4 = new Wall("FNH");
        addObject(wall4,this.getRealX(4),this.getRealY(4));
        Wall wall5 = new Wall("FNH");
        addObject(wall5,this.getRealX(5),this.getRealY(4));
        Wall wall6 = new Wall("FNH");
        addObject(wall6,this.getRealX(6),this.getRealY(4));
        Wall wall7 = new Wall("FNH");
        addObject(wall7,this.getRealX(7),this.getRealY(4));
        Wall wall8 = new Wall("FNH");
        addObject(wall8,this.getRealX(8),this.getRealY(4));
        Wall wall9 = new Wall("FNH");
        addObject(wall9,this.getRealX(9),this.getRealY(4));
        Wall wall10 = new Wall("FNH");
        addObject(wall10,this.getRealX(10),this.getRealY(4));
        Wall wall11 = new Wall("FNH");
        addObject(wall11,this.getRealX(11),this.getRealY(4));
        Wall wall12 = new Wall("FOLWS");
        addObject(wall12,this.getRealX(12),this.getRealY(4));
        Wall wall13 = new Wall("FEV");
        addObject(wall13,this.getRealX(12),this.getRealY(5));
        Wall wall14 = new Wall("FEV");
        addObject(wall14,this.getRealX(12),this.getRealY(6));
        Wall wall15 = new Wall("FEV");
        addObject(wall15,this.getRealX(12),this.getRealY(7));
        Wall wall16 = new Wall("FEV");
        addObject(wall16,this.getRealX(12),this.getRealY(8));
        Wall wall17 = new Wall("FEV");
        addObject(wall17,this.getRealX(12),this.getRealY(9));
        Wall wall18 = new Wall("FOLNW");
        addObject(wall18,this.getRealX(12),this.getRealY(10));
        Wall wall19 = new Wall("FSH");
        addObject(wall19,this.getRealX(1),this.getRealY(10));
        Wall wall20 = new Wall("FSH");
        addObject(wall20,this.getRealX(2),this.getRealY(10));
        Wall wall21 = new Wall("FSH");
        addObject(wall21,this.getRealX(3),this.getRealY(10));
        Wall wall22 = new Wall("FSH");
        addObject(wall22,this.getRealX(4),this.getRealY(10));
        Wall wall23 = new Wall("FSH");
        addObject(wall23,this.getRealX(5),this.getRealY(10));
        Wall wall24 = new Wall("FSH");
        addObject(wall24,this.getRealX(6),this.getRealY(10));
        Wall wall25 = new Wall("FSH");
        addObject(wall25,this.getRealX(7),this.getRealY(10));
        Wall wall26 = new Wall("FSH");
        addObject(wall26,this.getRealX(8),this.getRealY(10));
        Wall wall27 = new Wall("FSH");
        addObject(wall27,this.getRealX(9),this.getRealY(10));
        Wall wall28 = new Wall("FSH");
        addObject(wall28,this.getRealX(10),this.getRealY(10));
        Wall wall29 = new Wall("FSH");
        addObject(wall29,this.getRealX(11),this.getRealY(10));
        Wall wall30 = new Wall("FOLEN");
        addObject(wall30,this.getRealX(0),this.getRealY(10));
        Wall wall31 = new Wall("FWV");
        addObject(wall31,this.getRealX(0),this.getRealY(5));
        Wall wall32 = new Wall("FWV");
        addObject(wall32,this.getRealX(0),this.getRealY(6));
        Wall wall33 = new Wall("FWV");
        addObject(wall33,this.getRealX(0),this.getRealY(7));
        Wall wall34 = new Wall("FWV");
        addObject(wall34,this.getRealX(0),this.getRealY(8));
        Wall wall35 = new Wall("FWV");
        addObject(wall35,this.getRealX(0),this.getRealY(9));
        Wall wall36 = new Wall("H");
        addObject(wall36,this.getRealX(1),this.getRealY(7));
        Wall wall37 = new Wall("H");
        addObject(wall37,this.getRealX(2),this.getRealY(7));
        Wall wall38 = new Wall("H");
        addObject(wall38,this.getRealX(3),this.getRealY(7));
        Wall wall39 = new Wall("H");
        addObject(wall39,this.getRealX(4),this.getRealY(7));
        Wall wall40 = new Wall("H");
        addObject(wall40,this.getRealX(5),this.getRealY(7));
        Wall wall41 = new Wall("H");
        addObject(wall41,this.getRealX(6),this.getRealY(7));
        Wall wall42 = new Wall("H");
        addObject(wall42,this.getRealX(7),this.getRealY(7));
        Wall wall43 = new Wall("H");
        addObject(wall43,this.getRealX(8),this.getRealY(7));
        Wall wall44 = new Wall("H");
        addObject(wall44,this.getRealX(9),this.getRealY(7));
        Wall wall45 = new Wall("H");
        addObject(wall45,this.getRealX(10),this.getRealY(7));
        Wall wall46 = new Wall("H");
        addObject(wall46,this.getRealX(11),this.getRealY(7));
        
        
        
        
        Platform[] platforms = new Platform[9];
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();
        for (int i = 0; i < 9; i++) {
            int k = (int)(Math.random()*100);
            platforms[i] = new Platform(k);
            platforms[i].setSecret();
            spheres.add(new Sphere(k));

        }
        
        for (int i = 0; i < 9; i++) {
            int k = (int)(Math.random()*(9-i));
            platforms[i].putSphere(spheres.remove(k));
            
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (platforms[j].value > platforms[j+1].value) {
                    Platform k = platforms[j];
                    platforms[j] = platforms[j+1];
                    platforms[j+1] = k;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {

            addObject(platforms[i],this.getRealX(2+i),this.getRealY(5));
        }
        
        platforms = new Platform[9];
        spheres = new ArrayList<Sphere>();
        for (int i = 0; i < 9; i++) {
            int k = (int)(Math.random()*100);
            platforms[i] = new Platform(k);
            platforms[i].setSecret();
            spheres.add(new Sphere(k));

        }
        
        for (int i = 0; i < 9; i++) {
            int k = (int)(Math.random()*(9-i));
            platforms[i].putSphere(spheres.remove(k));
            
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (platforms[j].value > platforms[j+1].value) {
                    Platform k = platforms[j];
                    platforms[j] = platforms[j+1];
                    platforms[j+1] = k;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            
            addObject(platforms[i],this.getRealX(2+i),this.getRealY(8));
        }
        
        Spieler player47 = new Spieler(this.loadCharacter());
        addObject(player47,this.getRealX(2),this.getRealY(6));
        player47.setRotation(270);
        Spieler player48 = new Spieler(this.loadCharacter());
        addObject(player48,this.getRealX(2),this.getRealY(9));
        player48.setRotation(270);
        
        String[] firstPage = new String[]{};
        String[] secondPage = new String[]{};
        String wm = "";
        Multiheader mheader = new Multiheader(new String[][]{firstPage, secondPage},new Spieler[]{player47,player48},wm);
        addObject(mheader,0,0);
        mheader.setLocation(0,0);
        this.isRewritable = false;
        this.isCampaignLevel = true;
        //this.exportLevel();
    }
    
    
    
    
    


    
}
