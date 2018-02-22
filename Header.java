import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Header here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Header extends Actor
{
    /**
     * Act - do whatever the Header wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean firstAct = true;
    private int firstX = 60;
    private int secondX = 0;
    
    private int width;
    private int size;
    
    private boolean playMode = false;
    private String[] text;
    
    public Header() {
        GreenfootImage gf = new GreenfootImage(1000,250);
        gf.setColor(new Color(255,255,255,255));
        gf.fill();
        this.setLocation(0,0);
        this.setImage(gf);
        this.playMode = true;
    }
    
    public Header(String[] text) {
        this.setText(text);
        this.playMode = false;
    }
    
    public void updateHeader() {
        GreenfootImage bg = new GreenfootImage((this.width+1)*this.size,4*this.size);
        this.setLocation(((width-1)*this.size)/2 ,75);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        
        bg.setFont(new Font(24));
        
        bg.drawString("Player 1", firstX, 60);
        bg.drawString("Player 2", secondX, 60);
        
        this.drawPoints(bg);
        
        //TODO draw HP
        
        int[] info = this.getPlayerInfo();
        ArrayList<Color> c = this.getWorldOfType(Stage.class).colors;
        
        if (!c.isEmpty()) {
            this.drawHP(bg, c.get(0),info[2],info[0],firstX, 140);
            this.drawHP(bg, c.get(1),info[4],info[0],secondX, 140);
            
            this.drawInk(bg, c.get(0),info[3],info[1],(this.width*this.size)/2-(size), 60);
            this.drawInk(bg, c.get(1),info[5],info[1],(this.width*this.size)/2+(4*size/3), 60);
            
            this.drawTime(bg, (this.width*this.size)/2, 150);
            
            this.drawWeapon(bg, this.getWorldOfType(Stage.class).players.get(0).weapon, firstX, 120);
            this.drawWeapon(bg, this.getWorldOfType(Stage.class).players.get(1).weapon, secondX, 120);
        }
             
        this.setImage(bg);
    
    }
    
    public void drawPoints(GreenfootImage header) {
        Stage s = this.getWorldOfType(Stage.class);
        header.setFont(new Font(24));
        if (!s.colors.isEmpty()) {
            header.drawString("Felder: " + s.countColor(s.colors.get(0)), firstX, 90); 
            header.drawString("Felder: " + s.countColor(s.colors.get(1)), secondX, 90);
        } else {
            header.drawString("Felder: 0", firstX, 90); 
            header.drawString("Felder: 0", secondX, 90);
        }
    }
    
    public void drawHP(GreenfootImage header, Color c, int hp, int max, int x, int y) {
        Stage s = this.getWorldOfType(Stage.class);
        header.setColor(new Color(0,0,0,255));
        header.drawRect(x,y,max*30 + (max-1)*2,20);
        header.setColor(c);
        for (int i = 0; i < hp; i++) {
            if (i == 0) {
                header.fillRect(x+i*30+1,y+1,29,19);
            } else {
                header.fillRect(x+i*30+2*i,y+1,30,19);
            }
        }
    }
    
    public void drawInk(GreenfootImage header, Color c, int ink, int max, int x, int y) {
        Stage s = this.getWorldOfType(Stage.class);
        Color bl = new Color(0,0,0,255);
        header.setColor(bl);
        header.drawRect(x,y,30,max*10 + (max-1)*2);
        
        for (int i = 0; i < ink; i++) {
            if (i == 0) {
                header.setColor(bl);
                header.drawRect(x,y+max*10 -i*10,30,10);
                header.setColor(c);
                header.fillRect(x,y+max*10- i*10,30,10);
            } else {
                header.setColor(bl);
                header.drawRect(x,y+max*10-i*10 - i*2,30,10);
                header.setColor(c);
                header.fillRect(x,y+max*10-i*10 - i*2,30,10);
            }
        }
    }
    
    public void drawWeapon(GreenfootImage header, String weapon, int x, int y) {
        Stage s = this.getWorldOfType(Stage.class);
        Color bl = new Color(0,0,0,255);
        header.setColor(bl);
        header.setFont(new Font(24));
        header.drawString("Waffe: " + weapon, x, y);
    }
    
    public void drawTime(GreenfootImage header, int x, int y) {
        String s = "" + (this.getWorldOfType(Stage.class).END_TIME - this.getWorldOfType(Stage.class).gameTime);
        header.setColor(new Color(0,0,0,255));
        header.setFont(new Font(24));
        header.drawString(s, x, y);
    }
    
    public int[] getPlayerInfo() {
        Stage s = this.getWorldOfType(Stage.class);
        int playerNumber = 0;
        int[] info = new int[1];
        if (!s.players.isEmpty()) {
           info = new int[s.players.size()*2 + 2];
           info[0] = s.players.get(0).MAX_HP;
           info[1] = s.players.get(0).MAX_INK;
           for (int i = 0; i < s.players.size(); i++) {
               info[i*2+2] = s.players.get(i).hp;
               info[i*2+3] = s.players.get(i).ink;
           }
           return info;
        } else {
           return new int[]{-1};
        }
        //[0] max hp
        //[1] max ink
        //[2] hp 1
        //[3] ink 1
        //[4] hp 2
        //[5] ink 2
    }
    
    public void setText(String[] text) {
        this.text = text;
    }
    
    public void missionHeader() {
        GreenfootImage bg = new GreenfootImage((this.width+1)*this.size,4*this.size);
        this.setLocation(((width-1)*this.size)/2 ,100);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        
        bg.setFont(new Font(24));
        
        for (int i = 0; i < this.text.length; i++) {
            bg.drawString(text[i], firstX, (i+1)*30);
        }
               
        this.setImage(bg);
    } 
    
    public void act() 
    {
        if (this.firstAct) {
            Stage s = this.getWorldOfType(Stage.class);
            this.width = s.getWidth()/s.width;
            this.size = s.width;
          
            secondX = this.width*this.size - 100;
            this.firstAct = false;
        } else {
            if (!this.playMode) {
                this.missionHeader();
            } else {
                this.updateHeader();
            }
        }
        
    }    
}
