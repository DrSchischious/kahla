
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Level implements Serializable {

    int width;
    int height;
    
    HashMap<Player, GamePoint> players;
    HashMap<Wall, GamePoint> walls;
    HashMap<Checkpoint, GamePoint> checkpoints;
    HashMap<Item, GamePoint> items;
    HashMap<Target, GamePoint> targets;
    HashMap<Outline, GamePoint> outlines;
    HashMap<Sphere, GamePoint> spheres;
    HashMap<Platform, GamePoint> platforms;
    
    
    ArrayList<String[]> memos;
    
    String[][] memoArchive;
    Player[] playerArchive;
    Multiheader mh;
    
    int chapter;
    int level;
    
    boolean isRewritable;
    boolean isCampaignLevel;

    String winningMessage;
   
    public Level() {
        this.players = new HashMap<Player, GamePoint>();
        this.walls = new HashMap<Wall, GamePoint>();
        this.checkpoints = new HashMap<Checkpoint, GamePoint>();
        this.items = new HashMap<Item, GamePoint>();
        this.targets = new HashMap<Target, GamePoint>();
        this.outlines = new HashMap<Outline, GamePoint>();
        this.spheres = new HashMap<Sphere, GamePoint>();
        this.platforms = new HashMap<Platform, GamePoint>();
        this.memos = new ArrayList<String[]>();
        this.chapter = 0;
        this.level = 0;
        this.isRewritable = true;
        this.isCampaignLevel = false;
    }
    
    public boolean loadCharacter() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/character.txt"));
           String x = in.readLine();
           if (x.equals("Kahla")) {
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
    
    public void exportLevel() {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileFilter ff = new FileNameExtensionFilter("Kahla-Levels","lvl");
        
        chooser.addChoosableFileFilter(ff);
        
        chooser.showSaveDialog(null);
        String path = "";
        if (!chooser.getSelectedFile().toString().contains(".lvl")) {
            path = chooser.getSelectedFile() + ".lvl";
        } else {
            path = chooser.getSelectedFile().toString();
        }
        
        
        try {
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            CampaignLevel.savePath(path);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if (oos != null) {
                try {
                    oos.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
    }
    
    public Level importLevel() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileFilter ff = new FileNameExtensionFilter("Kahla-Levels","lvl");
        
        chooser.addChoosableFileFilter(ff);
        chooser.showOpenDialog(null);
        
        String path = chooser.getSelectedFile().toString();

        Level read = null;
        
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            read = (Level)ois.readObject();
            
            System.out.println("Done");
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
    
    
    
    
    
    
    
    
    
    
    
}
