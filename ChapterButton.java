import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChapterButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChapterButton extends Button
{
    
    Menu menu;
    int neededEXP;
    
    public ChapterButton(String s, Menu m) {
        super(s);
        menu = m;
        
        this.drawButton(s,this.isLocked(s,m.exp));

    }
    
    
    public boolean isLocked(String s, int exp) {
        if (s.equals("Kapitel 1")) {
            this.neededEXP = 0;
            return false; 

        } else if (s.equals("Kapitel 2")) { //TODO: && m.progress[x] && m.progress[x+1]...
            this.neededEXP = 90;
        } else if (s.equals("Kapitel 3")) { //TODO: && m.progress[x] && m.progress[x+1]...
            this.neededEXP = 180;
        } else if (s.equals("Kapitel 4")) { //TODO: && m.progress[x] && m.progress[x+1]...
            this.neededEXP = 270;
        } else if (s.equals("Kapitel 5")) { //TODO: && m.progress[x] && m.progress[x+1]...
            this.neededEXP = 360;
        } else if (s.equals("Kapitel 6")) { //TODO: && m.progress[x] && m.progress[x+1]...
            this.neededEXP = 450;
        }
        
        if (exp >= this.neededEXP) {
            return false;
        }
        return true;
        
    }
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.text.equals("   Kapitel 1   ") || (this.text.equals("   Kapitel 1 ★   "))) {
                this.chapterOne();
            } else if (this.text.equals("   Kapitel 2   ") || (this.text.equals("   Kapitel 2 ★   "))) {
                this.chapterTwo();
            } else if (this.text.equals("   Kapitel 3   ") || (this.text.equals("   Kapitel 3 ★   "))) {
                this.chapterThree();
            } else if (this.text.equals("   Kapitel 4   ") || (this.text.equals("   Kapitel 4 ★   "))) {
                this.chapterFour();
            } else if (this.text.equals("   Kapitel 5   ") || (this.text.equals("   Kapitel 5 ★   "))) {
                this.chapterFive();
            } else if (this.text.equals("   Kapitel 6   ") || (this.text.equals("   Kapitel 6 ★   "))) {
                this.chapterSix();
            } else if (this.text.equals("   Kapitel 7   ") || (this.text.equals("   Kapitel 7 ★   "))) {
                this.chapterSeven();
            } 
            this.menu.draw();
        }
    }
    
    public void drawButton(String text, boolean locked) {
        GreenfootImage gf = new GreenfootImage(200,80);
        
        if (locked == true) {
            gf.setColor(new Color(127,127,127,255));
            gf.drawRect(0,0,199,79);     
            gf.setFont(new Font(15));
            gf.drawString(""+this.neededEXP+ " EXP",10,17);
            
            this.disable();
        } else {

            gf.setColor(new Color(0,0,0,255));
            gf.drawRect(0,0,199,79);        
            this.enable();
        }
        
        gf.setFont(new Font(36));
        if (text.contains("★")) {
             gf.setColor(new Color(200,100,0,255));
             gf.drawString(text,13,50);   
        } else {
            gf.drawString(text,32,50);
        }
        
        
        this.setImage(gf);
        
    } 
    
    public void chapterOne() {
        this.menu.setMode("Chapter One");
    }
    
    public void chapterTwo() {
        this.menu.setMode("Chapter Two");
    }
    
    public void chapterThree() {
        this.menu.setMode("Chapter Three");
    }
    
    public void chapterFour() {
        this.menu.setMode("Chapter Four");
    }
    
    public void chapterFive() {
        this.menu.setMode("Chapter Five");
    }
    
    public void chapterSix() {
        this.menu.setMode("Chapter Six");
    }
    
    public void chapterSeven() {
        this.menu.setMode("Chapter Seven");
    }
    
    public void act() {
        if (this.isEnabled()) {
            this.action();
        }
    }
}
