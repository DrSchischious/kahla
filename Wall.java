import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.Serializable;

/**
 * Write a description of class Walls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor implements Serializable
{
    
    public final int RGB_RED = 180;
    public final int RGB_GREEN = 180;
    public final int RGB_BLUE = 180;
    public final int RGB_ALPHA = 255;
    String type;
    

    
    public boolean isWalkable;
    public Wall() {
        
    }
    
    public Wall(String s) {
        this.type = s;
        if (s.equals("LEN")) {
            this.drawWallLEN();
            this.isWalkable = true;
        } else if (s.equals("LWS")) {
            this.drawWallLWS();
            this.isWalkable = true;
        } else if (s.equals("LSE")) {
            this.drawWallLSE();
            this.isWalkable = true;
        } else if (s.equals("LNW")) {
            this.drawWallLNW();
            this.isWalkable = true;
        } else if (s.equals("V")) {
            this.drawWallV();
            this.isWalkable = true;
        } else if (s.equals("H")) {
            this.drawWallH();
            this.isWalkable = true;
        } else if (s.equals("FILEN")) {
            this.fillWallInsideLEN();
            this.isWalkable = false;
        } else if (s.equals("FOLEN")) {
            this.fillWallOutsideLEN();
            this.isWalkable = false;
        } else if (s.equals("BFOLEN")) {
            this.fillBorderWallOutsideLEN();
            this.isWalkable = false;
        } else if (s.equals("FILWS")) {
            this.fillWallInsideLWS();
            this.isWalkable = false;
        } else if (s.equals("FOLWS")) {
            this.fillWallOutsideLWS();
            this.isWalkable = false;
        } else if (s.equals("BFOLWS")) {
            this.fillBorderWallOutsideLWS();
            this.isWalkable = false;
        } else if (s.equals("FILNW")) {
            this.fillWallInsideLNW();
            this.isWalkable = false;
        } else if (s.equals("FOLNW")) {
            this.fillWallOutsideLNW();
            this.isWalkable = false;
        } else if (s.equals("BFOLNW")) {
            this.fillBorderWallOutsideLNW();
            this.isWalkable = false;
        } else if (s.equals("FILSE")) {
            this.fillWallInsideLSE();
            this.isWalkable = false;
        } else if (s.equals("FOLSE")) {
            this.fillWallOutsideLSE();
            this.isWalkable = false;
        } else if (s.equals("BFOLSE")) {
            this.fillBorderWallOutsideLSE();
            this.isWalkable = false;
        } else if (s.equals("FWV")) {
            this.fillWallLeftV();
            this.isWalkable = false;
        } else if (s.equals("FEV")) {
            this.fillWallRightV();
            this.isWalkable = false;
        } else if (s.equals("FNH")) {
            this.fillWallUpH();
            this.isWalkable = false;
        } else if (s.equals("FSH")) {
            this.fillWallDownH();
            this.isWalkable = false;
        } else if (s.equals("BFWV")) {
            this.fillBorderWallLeftV();
            this.isWalkable = false;
        } else if (s.equals("BFEV")) {
            this.fillBorderWallRightV();
            this.isWalkable = false;
        } else if (s.equals("BFNH")) {
            this.fillBorderWallUpH();
            this.isWalkable = false;
        } else if (s.equals("BFSH")) {
            this.fillBorderWallDownH();
            this.isWalkable = false;
        } else if (s.equals("F")) {
            this.fillWallFull();
            this.isWalkable = false;
        } else if (s.equals("TN")) {
            this.drawWallTN();
            this.isWalkable = true;
        } else if (s.equals("TE")) {
            this.drawWallTE();
            this.isWalkable = true;
        } else if (s.equals("TS")) {
            this.drawWallTS();
            this.isWalkable = true;
        } else if (s.equals("TW")) {
            this.drawWallTW();
            this.isWalkable = true;
        } else if (s.equals("FTN")) {
            this.fillWallTN();
            this.isWalkable = false;
        } else if (s.equals("FTE")) {
            this.fillWallTE();
            this.isWalkable = false;
        } else if (s.equals("FTS")) {
            this.fillWallTS();
            this.isWalkable = false;
        } else if (s.equals("FTW")) {
            this.fillWallTW();
            this.isWalkable = false;
        } 
        
        
    }
    
    public void redraw() {
        if (type.equals("LEN")) {
            this.drawWallLEN();
            this.isWalkable = true;
        } else if (type.equals("LWS")) {
            this.drawWallLWS();
            this.isWalkable = true;
        } else if (type.equals("LSE")) {
            this.drawWallLSE();
            this.isWalkable = true;
        } else if (type.equals("LNW")) {
            this.drawWallLNW();
            this.isWalkable = true;
        } else if (type.equals("V")) {
            this.drawWallV();
            this.isWalkable = true;
        } else if (type.equals("H")) {
            this.drawWallH();
            this.isWalkable = true;
        } else if (type.equals("FILEN")) {
            this.fillWallInsideLEN();
            this.isWalkable = false;
        } else if (type.equals("FOLEN")) {
            this.fillWallOutsideLEN();
            this.isWalkable = false;
        } else if (type.equals("BFOLEN")) {
            this.fillBorderWallOutsideLEN();
            this.isWalkable = false;
        } else if (type.equals("FILWS")) {
            this.fillWallInsideLWS();
            this.isWalkable = false;
        } else if (type.equals("FOLWS")) {
            this.fillWallOutsideLWS();
            this.isWalkable = false;
        } else if (type.equals("BFOLWS")) {
            this.fillBorderWallOutsideLWS();
            this.isWalkable = false;
        } else if (type.equals("FILNW")) {
            this.fillWallInsideLNW();
            this.isWalkable = false;
        } else if (type.equals("FOLNW")) {
            this.fillWallOutsideLNW();
            this.isWalkable = false;
        } else if (type.equals("BFOLNW")) {
            this.fillBorderWallOutsideLNW();
            this.isWalkable = false;
        } else if (type.equals("FILSE")) {
            this.fillWallInsideLSE();
            this.isWalkable = false;
        } else if (type.equals("FOLSE")) {
            this.fillWallOutsideLSE();
            this.isWalkable = false;
        } else if (type.equals("BFOLSE")) {
            this.fillBorderWallOutsideLSE();
            this.isWalkable = false;
        } else if (type.equals("FWV")) {
            this.fillWallLeftV();
            this.isWalkable = false;
        } else if (type.equals("FEV")) {
            this.fillWallRightV();
            this.isWalkable = false;
        } else if (type.equals("FNH")) {
            this.fillWallUpH();
            this.isWalkable = false;
        } else if (type.equals("FSH")) {
            this.fillWallDownH();
            this.isWalkable = false;
        } else if (type.equals("BFWV")) {
            this.fillBorderWallLeftV();
            this.isWalkable = false;
        } else if (type.equals("BFEV")) {
            this.fillBorderWallRightV();
            this.isWalkable = false;
        } else if (type.equals("BFNH")) {
            this.fillBorderWallUpH();
            this.isWalkable = false;
        } else if (type.equals("BFSH")) {
            this.fillBorderWallDownH();
            this.isWalkable = false;
        } else if (type.equals("F")) {
            this.fillWallFull();
            this.isWalkable = false;
        } else if (type.equals("TN")) {
            this.drawWallTN();
            this.isWalkable = true;
        } else if (type.equals("TE")) {
            this.drawWallTE();
            this.isWalkable = true;
        } else if (type.equals("TS")) {
            this.drawWallTS();
            this.isWalkable = true;
        } else if (type.equals("TW")) {
            this.drawWallTW();
            this.isWalkable = true;
        } else if (type.equals("FTN")) {
            this.fillWallTN();
            this.isWalkable = false;
        } else if (type.equals("FTE")) {
            this.fillWallTE();
            this.isWalkable = false;
        } else if (type.equals("FTS")) {
            this.fillWallTS();
            this.isWalkable = false;
        } else if (type.equals("FTW")) {
            this.fillWallTW();
            this.isWalkable = false;
        } 
        
    }
    
    public void drawWallLEN() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(size/2-size/10,size/2 - size/10,size/2+size/10,size/5); //EM
        
        bg.drawRect(size/2-size/10,0,size/5,size/2+size/10); //MN
        
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(size/2-size/10,size/2 - size/10,size/2+size/10,size/5); //EM
        
        bg.fillRect(size/2-size/10,0,size/5,size/2+size/10); //MN
        
        
        this.setImage(bg);
    }
    
    public void fillWallInsideLEN() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(size/2-size/10,0,size/2+size/10,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(size/2-size/10+1,0,size/2+size/10,size/2+size/10);
        
        this.setImage(bg);
    }
    
    
    
    public void fillWallOutsideLEN() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,0,size/2+size/10,size/2+size/10);

        bg.drawRect(0,size/2-size/10,size,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(1,0,size/2+size/10-1,size/2+size/10);
        
        bg.fillRect(1,size/2-size/10+1,size,size/2+size/10);
        
        
        this.setImage(bg);
    }
    
    public void fillBorderWallOutsideLEN() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,0,size/2+size/10,size/2+size/10);

        bg.drawRect(0,size/2-size/10,size,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(0,0,size/2+size/10,size/2+size/10);
        
        bg.fillRect(0,size/2-size/10,size,size/2+size/10);
        
        
        this.setImage(bg);
    }
    

    
    public void drawWallLWS() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,size/2 - size/10,size/2,size/5); //WM
        
        bg.drawRect(size/2-size/10,size/2-size/10,size/5,size/2+size/10); //MS
        
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(0,size/2 - size/10,size/2,size/5); //WM
        
        bg.fillRect(size/2-size/10,size/2-size/10,size/5,size/2+size/10); //MS
        
        
        this.setImage(bg);
    }
    
    public void fillWallInsideLWS() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,size/2-size/10,size/2+size/10,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(0,size/2-size/10+1,size/2+size/10,size/2+size/10);
        
        this.setImage(bg);
    }
    
    public void fillWallOutsideLWS() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(size/2-size/10,size/2-size/10,size/2+size/10,size/2+size/10);

        bg.drawRect(0,0,size,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(size/2-size/10+1,size/2-size/10,size/2+size/10,size/2+size/10);
        
        bg.fillRect(0,1,size,size/2+size/10-1);
        
        
        this.setImage(bg);
    }
    
    public void fillBorderWallOutsideLWS() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(size/2-size/10,size/2-size/10,size/2+size/10,size/2+size/10);

        bg.drawRect(0,0,size,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(size/2-size/10,size/2-size/10,size/2+size/10,size/2+size/10);
        
        bg.fillRect(0,0,size,size/2+size/10-1);
        
        
        this.setImage(bg);
    }
    
    public void drawWallLSE() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(size/2-size/10,size/2 - size/10,size/2+size/10,size/5); //ME
        bg.drawRect(size/2-size/10,size/2-size/10,size/5,size/2+size/10); //MS
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(size/2-size/10,size/2 - size/10,size/2+size/10,size/5); //ME
        bg.fillRect(size/2-size/10,size/2-size/10,size/5,size/2+size/10); //MS
       
        
        
        this.setImage(bg);
    }
    
    public void fillWallInsideLSE() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(size/2-size/10,size/2-size/10,size/2+size/10,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(size/2-size/10+1,size/2-size/10+1,size/2+size/10,size/2+size/10);
        
        this.setImage(bg);
    }
    
    
    
    public void fillWallOutsideLSE() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,0,size,size/2+size/10);

        bg.drawRect(0,size/2-size/10,size/2+size/10,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(1,1,size,size/2+size/10-1);

        bg.fillRect(1,size/2-size/10,size/2+size/10-1,size/2+size/10);
        
        
        this.setImage(bg);
    }
    
    public void fillBorderWallOutsideLSE() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,0,size,size/2+size/10);

        bg.drawRect(0,size/2-size/10,size/2+size/10,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(0,0,size,size/2+size/10);

        bg.fillRect(0,size/2-size/10,size/2+size/10,size/2+size/10);
        
        
        this.setImage(bg);
    }
    
    public void drawWallLNW() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,size/2 - size/10,size/2,size/5); //WM
        
        bg.drawRect(size/2-size/10,0,size/5,size/2+size/10); //MN
        
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(0,size/2 - size/10,size/2,size/5); //WM
        
        bg.fillRect(size/2-size/10,0,size/5,size/2+size/10); //MN
        
        
        this.setImage(bg);
    }
    
    public void fillWallInsideLNW() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,0,size/2+size/10,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(0,0,size/2+size/10,size/2+size/10);
        
        this.setImage(bg);
    }
    
    public void fillWallOutsideLNW() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(size/2-size/10,0,size/2+size/10,size/2+size/10);

        bg.drawRect(0,size/2-size/10,size,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(size/2-size/10+1,0,size/2+size/10,size/2+size/10);

        bg.fillRect(0,size/2-size/10+1,size,size/2+size/10);
        
        
        this.setImage(bg);
    }
    
    public void fillBorderWallOutsideLNW() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(size/2-size/10,0,size/2+size/10,size/2+size/10);

        bg.drawRect(0,size/2-size/10,size,size/2+size/10);
 
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        
        bg.fillRect(size/2-size/10,0,size/2+size/10,size/2+size/10);

        bg.fillRect(0,size/2-size/10,size,size/2+size/10);
        
        
        this.setImage(bg);
    }
    
    public void drawWallV() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(size/2 - size/10,0,size/5,size);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(size/2 - size/10+1,0,size/5-1,size);
        
        this.setImage(bg);
    }
    
    public void fillWallLeftV() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,0,size/2+size/10,size);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(1,0,size/2+size/10-1,size);
        
        this.setImage(bg);
    }
    
    public void fillWallRightV() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(size/2-size/10,0,size/2+size/10,size);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(size/2-size/10+1,0,size/2+size/10,size);
        
        this.setImage(bg);
    }
    
    public void fillBorderWallLeftV() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,0,size/2+size/10,size);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,0,size/2+size/10,size);
        
        this.setImage(bg);
    }
    
    public void fillBorderWallRightV() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(size/2-size/10,0,size/2+size/10,size);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(size/2-size/10,0,size/2+size/10,size);
        
        this.setImage(bg);
    }
    
    public void drawWallH() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,size/2 - size/10,size,size/5);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,size/2 - size/10,size,size/5);
        this.setImage(bg);
    }
    
    public void fillWallUpH() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,0,size,size/2+size/10);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,1,size,size/2+size/10-1);
        
        this.setImage(bg);
    }
    
    public void fillWallDownH() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,size/2-size/10,size,size/2+size/10);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,size/2-size/10+1,size,size/2+size/10);
        
        this.setImage(bg);
    }
    
    public void fillBorderWallUpH() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,0,size,size/2+size/10);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,0,size,size/2+size/10-1);
        
        this.setImage(bg);
    }
    
    public void fillBorderWallDownH() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,size/2-size/10,size,size/2+size/10);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,size/2-size/10,size,size/2+size/10);
        
        this.setImage(bg);
    }
    
    public void fillWallFull() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size+1, size+1);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,0,size,size);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,0,size+1,size+1);
        
        this.setImage(bg);
    }
    
    public void drawWallTN() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,size/2 - size/10,size,size/5);
        bg.drawRect(size/2-size/10,0,size/5,size/2+size/10);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,size/2 - size/10,size,size/5);
        bg.fillRect(size/2-size/10,0,size/5,size/2+size/10);
        this.setImage(bg);
    }
    
    public void fillWallTN() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        
        bg.drawRect(0,size/2 - size/10,size,size/2+size/10);
        
        bg.drawRect(size/2-size/10,0,size/5,size/2+size/10);
        
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,size/2 - size/10+1,size,size/2+size/10-1);
        
        bg.fillRect(size/2-size/10+1,0,size/5-1,size/2+size/10);
        this.setImage(bg);
    }
    
    public void drawWallTE() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(size/2 - size/10,0,size/5,size);
        bg.drawRect(size/2 -size/10,size/2-size/10,size/10+size/2,size/5);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(size/2 - size/10,0,size/5,size);
        bg.fillRect(size/2 -size/10,size/2-size/10,size/10+size/2,size/5);
        
        this.setImage(bg);
    }
    
    public void fillWallTE() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,0,size/2+size/10,size);
        bg.drawRect(size/2 -size/10,size/2-size/10,size/10+size/2,size/5);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,0,size/2+size/10,size);
        bg.fillRect(size/2 -size/10,size/2-size/10,size/10+size/2,size/5);
        
        this.setImage(bg);
    }
    
    public void drawWallTS() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,size/2 - size/10,size,size/5);
        bg.drawRect(size/2-size/10,size/2-size/10,size/5,size/2+size/10);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,size/2 - size/10,size,size/5);
        bg.fillRect(size/2-size/10+1,size/2-size/10,size/5-1,size/2+size/10);
        this.setImage(bg);
    }
    
    public void fillWallTS() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(0,0,size,size/2+size/10);
        bg.drawRect(size/2-size/10,size/2-size/10,size/5,size/2+size/10);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(0,1,size,size/2+size/10-1);
        bg.fillRect(size/2-size/10+1,size/2-size/10,size/5-1,size/2+size/10);
        this.setImage(bg);
    }
    
    public void drawWallTW() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(size/2 - size/10,0,size/5,size);
        bg.drawRect(0,size/2-size/10,size/10+size/2,size/5);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(size/2 - size/10,0,size/5,size);
        bg.fillRect(0,size/2-size/10,size/10+size/2,size/5);
        
        this.setImage(bg);
    }
    
    public void fillWallTW() {
        int size = 50;
        GreenfootImage bg = new GreenfootImage(size, size);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        bg.drawRect(size/2 - size/10,0,size/2+size/10,size);
        bg.drawRect(0,size/2-size/10,size/10+size/2,size/5);
        bg.setColor(new Color(this.RGB_RED,this.RGB_GREEN,this.RGB_BLUE,this.RGB_ALPHA));
        bg.fillRect(size/2 - size/10,0,size/2+size/10,size);
        bg.fillRect(0,size/2-size/10,size/10+size/2,size/5);
        
        this.setImage(bg);
    }
    
    public void drawWall() {
        
    }
    
    /**
     * Act - do whatever the Walls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
        // Add your action code here.
    }    
    
   
}
