import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.Serializable;

public class Savestate implements Serializable{

    String name;
    boolean[] progress; 
    int[][] loc;
    
    boolean isKahla;
    int actualChapter;
    int actualLevel;
    
    
    public Savestate(String name, boolean[] progress, int[][] loc) {
        this.name = name;
        this.progress = progress;
        this.loc = loc;
    }
    
    public void exportSavestate() {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileFilter ff = new FileNameExtensionFilter("Kahla-Savestates","sav");
        
        chooser.addChoosableFileFilter(ff);
        
        chooser.showSaveDialog(null);
        String path = "";
        if (!chooser.getSelectedFile().toString().contains(".sav")) {
            path = chooser.getSelectedFile() + ".sav";
        } else {
            path = chooser.getSelectedFile().toString();
        }
        
        
        try {
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            this.savePath(path);
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
    
    public void exportSavestate(String path) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;        
        
        try {
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            this.savePath(path);
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
    
    public void savePath(String path) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualState.txt"));  
            out.write(path);
            out.close();
            
        } catch(IOException e) {
            
        } 
    }
    
    public static Savestate loadState(String path) {
        if (!path.equals("")) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
           
    
            Savestate read = null;
            
            try {
                fis = new FileInputStream(path);
                ois = new ObjectInputStream(fis);
                read = (Savestate)ois.readObject();
                
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
        } else {
            return null;
        }
    }
    
    public static Savestate loadState() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileFilter ff = new FileNameExtensionFilter("Kahla-Savestates","sav");
        
        chooser.addChoosableFileFilter(ff);
        chooser.showOpenDialog(null);
        
        String path = chooser.getSelectedFile().toString();

        Savestate read = null;
        
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            read = (Savestate)ois.readObject();
            
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
