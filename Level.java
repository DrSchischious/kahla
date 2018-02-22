
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
    
    HashMap<Spieler, GamePoint> players;
    HashMap<Wall, GamePoint> walls;
    HashMap<Checkpoint, GamePoint> checkpoints;
    
    ArrayList<String[]> memos;
    
    String[][] memoArchive;
    Spieler[] playerArchive;
    Multiheader mh;

    String winningMessage;
    /*
    Spieler[] players;
    String[][] texts;
    String winningMessage;
    
    Checkpoint[] checkpoints;
    Item[] items;
    Target[] targets;
    
    Sphere[] spheres;
    Platform[] platforms;
    
    Wall[] walls;
    */
    
    
    public Level() {
        this.players = new HashMap<Spieler, GamePoint>();
        this.walls = new HashMap<Wall, GamePoint>();
        this.checkpoints = new HashMap<Checkpoint, GamePoint>();
        
        this.memos = new ArrayList<String[]>();
        
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
    
    public void level1() {
        this.width = 10;
        this.height = 3;
        
        this.players.put(new Spieler(this.loadCharacter()), new GamePoint(4,5));
        this.playerArchive = new Spieler[this.players.keySet().size()];
        
        int count = 0;
        Iterator it = this.players.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            this.playerArchive[count] = (Spieler)pair.getKey();
            count++;
        }
        
        this.memos.add(new String[]{"Willkommen bei \"Java mit Kahla\"", "Gegeben ist das unten zu sehende Spielfeld.","","Klicke hier unten auf den Pfeil für weitere","Informationen."});
        this.memos.add(new String[]{"Gut!","","Der kleine Kreis mit der Spitze ist deine","Spielfigur."});
        this.memos.add(new String[]{"Die Spitze deutet die Richtung an,","in die deine Spielfigur gedreht ist."});
        this.memos.add(new String[]{"Die grauen Bereiche deuten Wände","an. Deine Spielfigur kann diese nicht","begehen."});
        this.memos.add(new String[]{"Der türkise Kreis ist ein Checkpoint!","","Ziel dieses Levels ist es, deine Spielfigur","mit bestimmten Befehlen zum Checkpoint", "zu führen."});
        this.memos.add(new String[]{"Suche dazu auf der rechten Seite","das Element 'Spieler' und klicke doppelt","darauf."});
        this.memos.add(new String[]{"Du befindest dich nun im Editor.","Hier kannst du nun nach dem Befehl", "'public void code()' suchen.",""});
        this.memos.add(new String[]{"Innerhalb des Bereiches kannst du","Befehle formulieren.","","Probiere es doch mal mit dem Befehl","'schritt();'",""});
        this.memos.add(new String[]{"Führe dann die Befehle über den","Button 'Starte Code' aus"});
        this.memoArchive = new String[this.memos.size()][];
        
        count = 0;
        for (String[] s : this.memos) {
            this.memoArchive[count] = s;
            count++;
        }
        
        this.winningMessage = "Sehr gut!\nDu kannst nun das nächste Level über\nden Button 'Nächstes Level' erreichen.";
        
        this.mh = new Multiheader(this.memoArchive,this.playerArchive,this.winningMessage);
        
        this.walls.put(new Wall("FNH"), new GamePoint(1,4));
        this.walls.put(new Wall("FNH"), new GamePoint(2,4));
        this.walls.put(new Wall("FNH"), new GamePoint(3,4));
        this.walls.put(new Wall("FNH"), new GamePoint(4,4));
        this.walls.put(new Wall("FNH"), new GamePoint(5,4));
        this.walls.put(new Wall("FNH"), new GamePoint(6,4));
        this.walls.put(new Wall("FNH"), new GamePoint(7,4));
        this.walls.put(new Wall("FNH"), new GamePoint(8,4));
        this.walls.put(new Wall("FSH"), new GamePoint(1,6));
        this.walls.put(new Wall("FSH"), new GamePoint(2,6));
        this.walls.put(new Wall("FSH"), new GamePoint(3,6));
        this.walls.put(new Wall("FSH"), new GamePoint(4,6));
        this.walls.put(new Wall("FSH"), new GamePoint(5,6));
        this.walls.put(new Wall("FSH"), new GamePoint(6,6));
        this.walls.put(new Wall("FSH"), new GamePoint(7,6));
        this.walls.put(new Wall("FSH"), new GamePoint(8,6));
        this.walls.put(new Wall("FOLEN"), new GamePoint(0,6));
        this.walls.put(new Wall("FOLNW"), new GamePoint(9,6));
        this.walls.put(new Wall("FOLWS"), new GamePoint(9,4));
        this.walls.put(new Wall("FOLSE"), new GamePoint(0,4));
        this.walls.put(new Wall("FWV"), new GamePoint(0,5));
        this.walls.put(new Wall("FEV"), new GamePoint(9,5));
        
        this.checkpoints.put(new Checkpoint(0), new GamePoint(5,5));

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
            System.out.println("Done");
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
