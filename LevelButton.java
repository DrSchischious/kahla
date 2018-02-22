import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelButton extends Button
{
    
    int rewardedEXP;
    boolean isTutorial = false;
    int loc;
    int perfectLOC;
    int standardLOC;
    
    
    
    
    public LevelButton(String s, boolean done, boolean locked,int loc) {
        super(s);
        
        this.loc = loc;
        
        if (s.equals("C01L01")) {
            
            rewardedEXP = 10;
            this.perfectLOC = 3;
            this.standardLOC = 4;
            
            isTutorial = true;
            this.drawLevelImage("L01",done,locked);
        } else if (s.equals("C01L02")) {
           
            rewardedEXP = 10;
            this.perfectLOC = 5;
            this.standardLOC = 6;
            
            isTutorial = true;
            this.drawLevelImage("L02",done,locked);
        } else if (s.equals("C01L03")) {
            
            rewardedEXP = 10;
            this.perfectLOC = 6;
            this.standardLOC = 7;
            
            isTutorial = true;
            this.drawLevelImage("L03",done,locked);
        } else if (s.equals("C01L04")) {
            
            this.perfectLOC = 3;
            this.standardLOC = 4;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L04",done,locked);
        } else if (s.equals("C01L05")) {
            this.perfectLOC = 5;
            this.standardLOC = 6;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L05",done,locked);
        } else if (s.equals("C01L06")) {
            this.perfectLOC = 14;
            this.standardLOC = 16;
            rewardedEXP = 10;
            this.drawLevelImage("L06",done,locked);
        } else if (s.equals("C01L07")) {
            this.perfectLOC = 10;
            this.standardLOC = 11;
            rewardedEXP = 10;
            this.drawLevelImage("L07",done,locked);
        } else if (s.equals("C01L08")) {
            this.perfectLOC = 25;
            this.standardLOC = 27;
            rewardedEXP = 20;
            this.drawLevelImage("L08",done,locked);
        } else if (s.equals("C01L09")) {
            this.perfectLOC = 18;
            this.standardLOC = 20;
            rewardedEXP = 20;
            this.drawLevelImage("L09",done,locked);
        } else if (s.equals("C01L10")) {
            this.perfectLOC = 20;
            this.standardLOC = 22;
            rewardedEXP = 30;
            this.drawLevelImage("L10",done,locked);
        } else if (s.equals("C02L01")) {
            this.perfectLOC = 14;
            this.standardLOC = 16;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L01",done,locked);
        } else if (s.equals("C02L02")) {
            this.perfectLOC = 28;
            this.standardLOC = 30;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L02",done,locked);
        } else if (s.equals("C02L03")) {
            this.perfectLOC = 19;
            this.standardLOC = 21;
            rewardedEXP = 10;
            this.drawLevelImage("L03",done,locked);
        } else if (s.equals("C02L04")) {
            this.perfectLOC = 30;
            this.standardLOC = 33;
            rewardedEXP = 10;
            this.drawLevelImage("L04",done,locked);
        } else if (s.equals("C02L05")) {
            this.perfectLOC = 28;
            this.standardLOC = 30;
            rewardedEXP = 10;
            this.drawLevelImage("L05",done,locked);
        } else if (s.equals("C02L06")) {
            this.perfectLOC = 35;
            this.standardLOC = 38;
            rewardedEXP = 10;
            this.drawLevelImage("L06",done,locked);
        } else if (s.equals("C02L07")) {
            this.perfectLOC = 35;
            this.standardLOC = 37;
            rewardedEXP = 10;
            this.drawLevelImage("L07",done,locked);
        } else if (s.equals("C02L08")) {
            this.perfectLOC = 36;
            this.standardLOC = 39;
            rewardedEXP = 20;
            this.drawLevelImage("L08",done,locked);
        } else if (s.equals("C02L09")) {
            this.perfectLOC = 28;
            this.standardLOC = 32;
            rewardedEXP = 20;
            this.drawLevelImage("L09",done,locked);
        } else if (s.equals("C02L10")) {
            this.perfectLOC = 61;
            this.standardLOC = 65;
            rewardedEXP = 30;
            this.drawLevelImage("L10",done,locked);
        } else if (s.equals("C03L01")) {
            this.perfectLOC = 5;
            this.standardLOC = 7;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L01",done,locked);
        } else if (s.equals("C03L02")) {
            this.perfectLOC = 7;
            this.standardLOC = 9;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L02",done,locked);
        } else if (s.equals("C03L03")) {
            this.perfectLOC = 13;
            this.standardLOC = 15;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L03",done,locked);
        } else if (s.equals("C03L04")) {
            this.perfectLOC = 7;
            this.standardLOC = 9;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L04",done,locked);
        } else if (s.equals("C03L05")) {
            this.perfectLOC = 10;
            this.standardLOC = 12;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L05",done,locked);
        } else if (s.equals("C03L06")) {
            this.perfectLOC = 16;
            this.standardLOC = 20;
            rewardedEXP = 10;
            this.drawLevelImage("L06",done,locked);
        } else if (s.equals("C03L07")) {
            this.perfectLOC = 10;
            this.standardLOC = 13;
            rewardedEXP = 10;
            this.drawLevelImage("L07",done,locked);
        } else if (s.equals("C03L08")) {
            this.perfectLOC = 15;
            this.standardLOC = 18;
            rewardedEXP = 20;
            this.drawLevelImage("L08",done,locked);
        } else if (s.equals("C03L09")) {
            this.perfectLOC = 27;
            this.standardLOC = 30;
            rewardedEXP = 20;
            this.drawLevelImage("L09",done,locked);
        } else if (s.equals("C03L10")) {
            this.perfectLOC = 15;
            this.standardLOC = 18;
            rewardedEXP = 30;
            this.drawLevelImage("L10",done,locked);
        } else if (s.equals("C04L01")) {
            this.perfectLOC = 7;
            this.standardLOC = 9;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L01",done,locked);
        } else if (s.equals("C04L02")) {
            this.perfectLOC = 8;
            this.standardLOC = 10;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L02",done,locked);
        } else if (s.equals("C04L03")) {
            this.perfectLOC = 9;
            this.standardLOC = 11;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L03",done,locked);
        } else if (s.equals("C04L04")) {
            this.perfectLOC = 8;
            this.standardLOC = 10;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L04",done,locked);
        } else if (s.equals("C04L05")) {
            this.perfectLOC = 12;
            this.standardLOC = 15;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L05",done,locked);
        } else if (s.equals("C04L06")) {
            this.perfectLOC = 15;
            this.standardLOC = 18;
            rewardedEXP = 10;
            this.drawLevelImage("L06",done,locked);
        } else if (s.equals("C04L07")) {
            this.perfectLOC = 23;
            this.standardLOC = 27;
            rewardedEXP = 10;
            this.drawLevelImage("L07",done,locked);
        } else if (s.equals("C04L08")) {
            this.perfectLOC = 28;
            this.standardLOC = 31;
            rewardedEXP = 20;
            this.drawLevelImage("L08",done,locked);
        } else if (s.equals("C04L09")) {
            this.perfectLOC = 16;
            this.standardLOC = 18;
            rewardedEXP = 20;
            this.drawLevelImage("L09",done,locked);
        } else if (s.equals("C04L10")) {
            this.perfectLOC = 21;
            this.standardLOC = 24;
            rewardedEXP = 30;
            this.drawLevelImage("L10",done,locked);
        } else if (s.equals("C05L01")) {
            this.perfectLOC = 10;
            this.standardLOC = 12;
            rewardedEXP = 10;
            isTutorial = true;
            this.drawLevelImage("L01",done,locked);
        } else if (s.equals("C05L02")) {
            rewardedEXP = 10;
            this.perfectLOC = 24;
            this.standardLOC = 26;
            isTutorial = true;
            this.drawLevelImage("L02",done,locked);
        } else if (s.equals("C05L03")) {
            rewardedEXP = 10;
            this.perfectLOC = 25;
            this.standardLOC = 27;
            isTutorial = true;
            this.drawLevelImage("L03",done,locked);
        } else if (s.equals("C05L04")) {
            rewardedEXP = 10;
            this.perfectLOC = 33;
            this.standardLOC = 36;
            isTutorial = true;
            this.drawLevelImage("L04",done,locked);
        } else if (s.equals("C05L05")) {
            rewardedEXP = 10;
            this.perfectLOC = 59;
            this.standardLOC = 65;
            isTutorial = true;
            this.drawLevelImage("L05",done,locked);
        } else if (s.equals("C05L06")) {
            rewardedEXP = 10;
            this.perfectLOC = 30;
            this.standardLOC = 34;
            this.drawLevelImage("L06",done,locked);
        } else if (s.equals("C05L07")) {
            rewardedEXP = 10;
            this.perfectLOC = 51;
            this.standardLOC = 55;
            this.drawLevelImage("L07",done,locked);
        } else if (s.equals("C05L08")) {
            rewardedEXP = 20;
            this.perfectLOC = 65;
            this.standardLOC = 70;
            this.drawLevelImage("L08",done,locked);
        } else if (s.equals("C05L09")) {
            rewardedEXP = 20;
            this.perfectLOC = 47;
            this.standardLOC = 52;
            this.drawLevelImage("L09",done,locked);
        } else if (s.equals("C05L10")) {
            rewardedEXP = 30;
            this.perfectLOC = 82;
            this.standardLOC = 86;
            this.drawLevelImage("L10",done,locked);
        } else if (s.equals("C06L01")) {
            rewardedEXP = 10;
            this.perfectLOC = 24;
            this.standardLOC = 28;
            this.drawLevelImage("L01",done,locked);
        } else if (s.equals("C06L02")) {
            rewardedEXP = 10;
            this.perfectLOC = 90;
            this.standardLOC = 105;
            this.drawLevelImage("L02",done,locked);
        } else if (s.equals("C06L03")) {
            rewardedEXP = 10;
            this.perfectLOC = 90;
            this.standardLOC = 105;
            this.drawLevelImage("L03",done,locked);
        } else if (s.equals("C06L04")) {
            rewardedEXP = 10;
            this.perfectLOC = 16;
            this.standardLOC = 22;
            this.drawLevelImage("L04",done,locked);
        } else if (s.equals("C06L05")) {
            rewardedEXP = 10;
            this.perfectLOC = 17;
            this.standardLOC = 23;
            this.drawLevelImage("L05",done,locked);
        } else if (s.equals("C06L06")) {
            rewardedEXP = 10;
            this.perfectLOC = 25;
            this.standardLOC = 35;
            this.drawLevelImage("L06",done,locked);
        } else if (s.equals("C06L07")) {
            rewardedEXP = 10;
            this.perfectLOC = 22;
            this.standardLOC = 35;
            this.drawLevelImage("L07",done,locked);
        } else if (s.equals("C06L08")) {
            rewardedEXP = 20;
            this.perfectLOC = 65;
            this.standardLOC = 80;
            this.drawLevelImage("L08",done,locked);
        } else if (s.equals("C06L09")) {
            rewardedEXP = 20;
            this.perfectLOC = 140;
            this.standardLOC = 160;
            this.drawLevelImage("L09",done,locked);
        } else if (s.equals("C06L10")) {
            rewardedEXP = 30;
            this.perfectLOC = 110;
            this.standardLOC = 140;
            this.drawLevelImage("L10",done,locked);
        }
        
    }
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.text.equals("   C01L01   ")) {
                //Greenfoot.setWorld(new CampaignLevel(1,1,10,3,50));
                Level lv = CampaignLevel.loadLevelFromData();
                System.out.println(lv.width);
                System.out.println(lv.height);
                
                Greenfoot.setWorld(new CampaignLevel(lv.width,lv.height,lv));
            } else if (this.text.equals("   C01L02   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,2,10,3,50));
            } else if (this.text.equals("   C01L03   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,3,10,3,50));
            } else if (this.text.equals("   C01L04   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,4,10,3,50));
            } else if (this.text.equals("   C01L05   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,5,10,4,50));
            } else if (this.text.equals("   C01L06   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,6,11,6,50));
            } else if (this.text.equals("   C01L07   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,7,11,7,50));
            } else if (this.text.equals("   C01L08   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,8,10,4,50));
            } else if (this.text.equals("   C01L09   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,9,11,5,50));
            } else if (this.text.equals("   C01L10   ")) {
                Greenfoot.setWorld(new CampaignLevel(1,10,10,7,50));
            } else if (this.text.equals("   C02L01   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,1,11,3,50));
                
            } else if (this.text.equals("   C02L02   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,2,11,7,50));
            } else if (this.text.equals("   C02L03   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,3,9,5,50));
            } else if (this.text.equals("   C02L04   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,4,11,7,50));
            } else if (this.text.equals("   C02L05   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,5,11,6,50));
            } else if (this.text.equals("   C02L06   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,6,10,5,50));
            } else if (this.text.equals("   C02L07   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,7,12,7,50));
            } else if (this.text.equals("   C02L08   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,8,13,8,50));
            } else if (this.text.equals("   C02L09   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,9,13,13,50));
            } else if (this.text.equals("   C02L10   ")) {
                Greenfoot.setWorld(new CampaignLevel(2,10,17,8,50));
            } else if (this.text.equals("   C03L01   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,1,11,3,50));
                
            } else if (this.text.equals("   C03L02   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,2,10,5,50));
            } else if (this.text.equals("   C03L03   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,3,11,5,50));
            } else if (this.text.equals("   C03L04   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,4,11,5,50));
            } else if (this.text.equals("   C03L05   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,5,9,5,50));
            } else if (this.text.equals("   C03L06   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,6,11,8,50));
            } else if (this.text.equals("   C03L07   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,7,9,5,50));
            } else if (this.text.equals("   C03L08   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,8,13,7,50));
            } else if (this.text.equals("   C03L09   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,9,11,7,50));
            } else if (this.text.equals("   C03L10   ")) {
                Greenfoot.setWorld(new CampaignLevel(3,10,11,5,50));
            } else if (this.text.equals("   C04L01   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,1,10,9,50));
            } else if (this.text.equals("   C04L02   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,2,9,7,50));
            } else if (this.text.equals("   C04L03   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,3,9,8,50));
            } else if (this.text.equals("   C04L04   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,4,9,9,50));
            } else if (this.text.equals("   C04L05   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,5,11,12,50));
            } else if (this.text.equals("   C04L06   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,6,13,9,50));
            } else if (this.text.equals("   C04L07   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,7,12,9,50));
            } else if (this.text.equals("   C04L08   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,8,11,11,50));
            } else if (this.text.equals("   C04L09   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,9,12,9,50));
            } else if (this.text.equals("   C04L10   ")) {
                Greenfoot.setWorld(new CampaignLevel(4,10,11,11,50));
            } else if (this.text.equals("   C05L01   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,1,9,3,50));
            } else if (this.text.equals("   C05L02   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,2,9,9,50));
            } else if (this.text.equals("   C05L03   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,3,9,9,50));
            } else if (this.text.equals("   C05L04   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,4,10,13,50));
            } else if (this.text.equals("   C05L05   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,5,11,10,50));
            } else if (this.text.equals("   C05L06   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,6,10,7,50));
            } else if (this.text.equals("   C05L07   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,7,9,11,50));
            } else if (this.text.equals("   C05L08   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,8,13,9,50));
            } else if (this.text.equals("   C05L09   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,9,13,13,50));
            } else if (this.text.equals("   C05L10   ")) {
                Greenfoot.setWorld(new CampaignLevel(5,10,13,13,50));
            } else if (this.text.equals("   C06L01   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,1,13,6,50));
            } else if (this.text.equals("   C06L02   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,2,13,7,50));
            } else if (this.text.equals("   C06L03   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,3,13,11,50));
            } else if (this.text.equals("   C06L04   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,4,13,11,50));
            } else if (this.text.equals("   C06L05   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,5,15,11,50));
            } else if (this.text.equals("   C06L06   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,6,15,11,50));
            } else if (this.text.equals("   C06L07   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,7,12,7,50));
            } else if (this.text.equals("   C06L08   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,8,12,7,50));
            } else if (this.text.equals("   C06L09   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,9,13,7,50));
            } else if (this.text.equals("   C06L10   ")) {
                Greenfoot.setWorld(new CampaignLevel(6,10,13,7,50));
            }
            //Update with new Level
        }
    }
    
    public void drawButton(String text) {
        
    }
    
    public void drawLevelImage(String s, boolean done, boolean locked) {
        GreenfootImage gf = new GreenfootImage(100,100);
        
        if (done == true) {
            gf.setColor(new Color(0,0,0,255));
            gf.drawRect(0,0,99,99);
            if (isTutorial == true) {
               gf.drawRect(1,1,97,97);
               gf.drawRect(2,2,95,95);
               gf.drawRect(3,3,93,93);
               
               if (this.loc <= this.perfectLOC) {
                   gf.setColor(new Color(0,100,0,255));
               } else if (this.loc <= this.standardLOC) {
                   gf.setColor(new Color(220,220,0,255));
               } else {
                    gf.setColor(new Color(150,0,0,255));
               }
                
               gf.fillRect(4,4,92,92);
               
               if (this.loc <= this.perfectLOC) {
                   gf.setColor(new Color(255,255,255,255));
               } else if (this.loc <= this.standardLOC) {
                   gf.setColor(new Color(0,0,0,255));
               } else {
                    gf.setColor(new Color(255,255,255,255));
               }
               
               gf.setFont(new Font(12));
               gf.drawString("LoC: " + this.loc,7,92);
               
            } else {
               if (this.loc <= this.perfectLOC) {
                   gf.setColor(new Color(0,100,0,255));
               } else if (this.loc <= this.standardLOC) {
                   gf.setColor(new Color(220,220,0,255));
               } else {
                    gf.setColor(new Color(150,0,0,255));
               }
                
               
                
               gf.fillRect(0,0,99,99);
               
               gf.setColor(new Color(0,0,0,255));
               gf.drawRect(0,0,99,99);
               
               if (this.loc <= this.perfectLOC) {
                   gf.setColor(new Color(255,255,255,255));
               } else if (this.loc <= this.standardLOC) {
                   gf.setColor(new Color(0,0,0,255));
               } else {
                    gf.setColor(new Color(255,255,255,255));
               }
               
               gf.setFont(new Font(12));
               gf.drawString("LoC: " + this.loc,7,92);
            }
            
            
            gf.setColor(new Color(255,255,255,255));
            this.enable();
            
            gf.setFont(new Font(30));
            gf.drawString(s,25,60);
        } else if (locked == true) {
            gf.setColor(new Color(0,0,0,255));
            gf.drawRect(0,0,99,99);
            if (isTutorial == true) {
               gf.drawRect(1,1,97,97);
               gf.drawRect(2,2,95,95);
            }
            
            gf.setColor(new Color(127,127,127,255));
            GreenfootImage kh = new GreenfootImage("keyhole.png");
            kh.scale(70, 70);
            gf.drawImage(kh, 15, 15);

            gf.setFont(new Font(15));

            this.disable();
        } else {
            
            gf.setColor(new Color(0,0,0,255));
            gf.drawRect(0,0,99,99);
            if (isTutorial == true) {
               gf.drawRect(1,1,97,97);
               gf.drawRect(2,2,95,95);
               gf.drawRect(3,3,93,93);
            }
            this.enable();
            
            gf.setFont(new Font(30));
            gf.drawString(s,25,60);
            
            gf.setFont(new Font(12));
            gf.drawString("+ "+this.rewardedEXP+" EXP",10,90);
        }
        
        
        
        
        this.setImage(gf);
    }
    
    public void act() 
    {
        if (this.isEnabled()) {
            this.action();
        }
    }    
}
