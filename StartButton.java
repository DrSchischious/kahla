import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
public class StartButton extends Button
{
    Spieler[] player;
    CampaignLevel stage;
    Multiheader mh;

    /**
     * Act - do whatever the Pagebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public StartButton(Spieler[] a, Multiheader h) {
        super("Starte Code");
        this.player = a;
        this.mh = h;
    }
    
    public void startCode() {
        this.disable();
        
        for (int i = 0; i < player.length; i++) {
            this.player[i].code();
            this.player[i].run();
        }
        
        this.stage = this.player[0].getWorldOfType(CampaignLevel.class);
        
        //different Conditions for different number of players.
        
        if (player.length == 1) {
            if (stage.checkForEndingConditions() && !this.player[0].hasError()) {
                //WON (SAVE CODE & Save Data & getEXP!)
                this.mh.next.enable();
                this.saveState(this.stage.chapter, this.stage.level);
                this.player[0].outputCode();
                this.player[0].updateIndex();
                
                mh.displayWinningMessage();
            
            } else if (this.player[0].hasError()) {
                Greenfoot.ask(this.player[0].getError());
                this.stage.resetStage();
            } else {
                Greenfoot.ask("Ziel nicht erreicht.");
                this.stage.resetStage();
            }
        } else if (player.length == 2) {
            if (stage.checkForEndingConditions() && !this.player[0].hasError() && !this.player[1].hasError()) {
                //WON (SAVE CODE & Save Data & getEXP!)
                this.mh.next.enable();
                this.saveState(this.stage.chapter, this.stage.level);
                this.player[0].outputCode();
                this.player[0].updateIndex();
                
                mh.displayWinningMessage();
            
            } else if (this.player[0].hasError()) {
                Greenfoot.ask(this.player[0].getError());
                this.stage.resetStage();
            } else if(this.player[1].hasError()) {
                Greenfoot.ask(this.player[1].getError());
                this.stage.resetStage();
            } else {
                Greenfoot.ask("Ziel nicht erreicht.");
                this.stage.resetStage();
            }
        } else if (player.length == 3) {
            if (stage.checkForEndingConditions() && !this.player[0].hasError() && !this.player[1].hasError() && !this.player[2].hasError()) {
                //WON (SAVE CODE & Save Data & getEXP!)
                this.mh.next.enable();
                this.saveState(this.stage.chapter, this.stage.level);
                this.player[0].outputCode();
                this.player[0].updateIndex();
                mh.displayWinningMessage();
            
            } else if (this.player[0].hasError()) {
                Greenfoot.ask(this.player[0].getError());
                this.stage.resetStage();
            } else if(this.player[1].hasError()) {
                Greenfoot.ask(this.player[1].getError());
                this.stage.resetStage();
            } else if(this.player[2].hasError()) {
                Greenfoot.ask(this.player[2].getError());
                this.stage.resetStage();
            } else {
                Greenfoot.ask("Ziel nicht erreicht.");
                this.stage.resetStage();
            }
        } else if (player.length == 4) {
            if (stage.checkForEndingConditions() && !this.player[0].hasError() && !this.player[1].hasError() && !this.player[2].hasError() && !this.player[3].hasError()) {
                //WON (SAVE CODE & Save Data & getEXP!)
                this.mh.next.enable();
                this.saveState(this.stage.chapter, this.stage.level);
                this.player[0].outputCode();
                this.player[0].updateIndex();
                mh.displayWinningMessage();
            
            } else if (this.player[0].hasError()) {
                Greenfoot.ask(this.player[0].getError());
                this.stage.resetStage();
            } else if(this.player[1].hasError()) {
                Greenfoot.ask(this.player[1].getError());
                this.stage.resetStage();
            } else if(this.player[2].hasError()) {
                Greenfoot.ask(this.player[2].getError());
                this.stage.resetStage();
            } else if(this.player[3].hasError()) {
                Greenfoot.ask(this.player[3].getError());
                this.stage.resetStage();
            } else {
                Greenfoot.ask("Ziel nicht erreicht.");
                this.stage.resetStage();
            }
        } else if (player.length == 5) {
            if (stage.checkForEndingConditions() && !this.player[0].hasError() && !this.player[1].hasError() && !this.player[2].hasError() && !this.player[3].hasError()&& !this.player[4].hasError()) {
                //WON (SAVE CODE & Save Data & getEXP!)
                this.mh.next.enable();
                this.saveState(this.stage.chapter, this.stage.level);
                this.player[0].outputCode();
                this.player[0].updateIndex();
                mh.displayWinningMessage();
            
            } else if (this.player[0].hasError()) {
                Greenfoot.ask(this.player[0].getError());
                this.stage.resetStage();
            } else if(this.player[1].hasError()) {
                Greenfoot.ask(this.player[1].getError());
                this.stage.resetStage();
            } else if(this.player[2].hasError()) {
                Greenfoot.ask(this.player[2].getError());
                this.stage.resetStage();
            } else if(this.player[3].hasError()) {
                Greenfoot.ask(this.player[3].getError());
                this.stage.resetStage();
            } else if(this.player[4].hasError()) {
                Greenfoot.ask(this.player[4].getError());
                this.stage.resetStage();
            } else {
                Greenfoot.ask("Ziel nicht erreicht.");
                this.stage.resetStage();
            }
        }
        
    }
    
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
               
           }
           
        } catch (FileNotFoundException e) {
            
        }
        return progress;
        //Step 4 - Rewrite it into new File();
        
        //Step 5 - Delete it?
    }
    
    public void saveState(int chapter, int level) {
        boolean[] progress = this.loadState();
        progress[(chapter-1)*10+(level-1)] = true;
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/state.txt"));  
            
            for (int i = 0; i < 60; i++) {
                if (progress[i] == true) {
                    out.write("y\n");
                } else {
                    out.write("n\n");
                }
            }
            out.close();
        
        } catch(IOException e) {
            
        } 
    }
    
  
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {
            this.startCode();
        }
    }
    
    public void act() 
    {
        if (this.isEnabled()) {
            this.action();
        }
    }    
}
