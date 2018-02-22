import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.io.Serializable;

/**
 * Write a description of class Player here.
 * 
 * @author Daniel Schisch
 * @version 0.3
 */

public class Player extends Actor implements Serializable
{
    //public Color inkColor;
    public int inkColor_r;
    public int inkColor_g;
    public int inkColor_b;
    public int inkColor_a;
    //public Color subColor;
    public int subColor_r;
    public int subColor_g;
    public int subColor_b;
    public int subColor_a;
    
    
    public String weapon;
    public int ink;
    public final int MAX_INK = 6;
    public boolean diveMode;
    private int fillTime = 0;
    public int hp;
    public final int MAX_HP = 3;
    private int dmgTime = 0;
    private boolean isControllable;
    private boolean firstAct;
    private int respawnTime = 0;
    private boolean isDead = false;
    private boolean animationRight = false;
    private boolean animationLeft = false;
    private boolean animationShootPistol = false;
    private boolean animationShootBrush = false;
    private boolean animationShootShotgun = false;
    private boolean animationShootRifle = false;
    private boolean animationShootGrounder = false;
    private boolean animationMoveForward = false;
    private boolean animationMoveSidewaysLeft = false;
    private boolean animationMoveSidewaysRight = false;
    private boolean animationMoveBackward = false;
    
    private boolean animationBubble = false;
    private Bubble errorBubble = null;
    
    private char shootDirection;
    private int animationTime = 0;
    private Inkblob[] shots;
    private boolean hasError = false;
    private String error = "";
    private String bubbleType = "";
    
    private boolean outlineGoal = false;
    
    public boolean isRunnable = false;
    
    
    public ArrayList<String> orders;
    public int orderCount = 0;
    
    public boolean hasSphere = false;
    public Sphere sphere;
    private int wert = 0;
    public int hasChecked = 0;
    
    /**
     * Constructor for objects of class Player.
     * It draws a Player according to the cell-size and a given color.
     */
    
    
    public Player(Color c, int size) {
      this.inkColor_r = c.getRed();
      this.inkColor_g = c.getGreen();
      this.inkColor_b = c.getBlue();
      this.inkColor_a = c.getAlpha();
      this.changeWeapon("Pistol");
      this.ink = this.MAX_INK;
      this.diveMode = false;
      this.hp = this.MAX_HP;
      this.drawPlayer(size);
      this.isControllable = true;
      this.firstAct = true;
      
      this.orders = new ArrayList<String>();
      this.cheatUnlimitedAmmo();
      this.hp = 1;
    }
    
    /**
     * Standard-Constructor for objects of class Player.
     * It draws a Player with a cell-size of 50 and a random color.
     */
    public Player() {
        
       int r = Greenfoot.getRandomNumber(255);
       int g = Greenfoot.getRandomNumber(255);
       int b = Greenfoot.getRandomNumber(255);
       
       this.inkColor_r = r;
       this.inkColor_g = g;
       this.inkColor_b = b;
       this.inkColor_a = 255;

       
       this.changeWeapon("Pistol");
       this.ink = this.MAX_INK;
       this.hp = this.MAX_HP;
       this.diveMode = false;
       this.drawPlayer(50);      
       this.isControllable = true;
       this.firstAct = true;
       
       this.orders = new ArrayList<String>();
       this.cheatUnlimitedAmmo();
       this.hp = 1;
    }
    
    public Player(boolean kahla) {
        
       if (kahla == true) {
           this.setRandomColorForKahla();
       } else {
            this.setRandomColorForFarbi();
       }
       
       this.changeWeapon("Pistol");
       this.ink = this.MAX_INK;
       this.hp = this.MAX_HP;
       this.diveMode = false;
       this.drawPlayer(50);      
       this.isControllable = true;
       this.firstAct = true;
       
       this.orders = new ArrayList<String>();
       this.cheatUnlimitedAmmo();
       this.hp = 1;
    }
    
    public void redraw() {
        this.drawPlayer(50);
    }
    
    public void setRandomColorForKahla() {
        int i = (int) (Math.random()*30);
        //Insert some Black SubColors.
        Color mainColor = new Color(0,0,0,255);
        Color subColor = new Color(0,0,0,255);
        if (i == 0) {
            mainColor = new Color(170,57,57,255);
            subColor = new Color(45,136,45,255);
        } else if (i == 1) { 
            mainColor = new Color(170,106,57,255);
            subColor = new Color(35,104,99,255);
        }  else if (i == 2) {
            mainColor = new Color(228,224,0,255);
            subColor = new Color(94,7,153,255);
        }  else if (i == 3) {
            mainColor = new Color(228,130,0,255);
            subColor = new Color(7,86,147,255);
        }  else if (i == 4) {
            mainColor = new Color(228,11,0,255);
            subColor = new Color(0,177,22,255);
        }  else if (i == 5) { 
            mainColor = new Color(151,215,0,255);
            subColor = new Color(178,0,112,255);
        }  else if (i == 6) {
            mainColor = new Color(116,0,68,255);
            subColor = new Color(92,136,0,255);
        }  else if (i == 7) { 
            mainColor = new Color(146,74,0,255);
            subColor = new Color(1,71,91,255);
        }  else if (i == 8) { 
            mainColor = new Color(146,146,0,255);
            subColor = new Color(63,2,97,255);
        }  else if (i == 9) {
            mainColor = new Color(89,136,0,255);
            subColor = new Color(118,0,64,255);
        }  else if (i == 10) { 
            mainColor = new Color(170,57,57,255);
            subColor = new Color(34,102,102,255);
        }  else if (i == 11) {
            mainColor = new Color(170,109,57,255);
            subColor = new Color(46,65,114,255);
        }  else if (i == 12) { 
            mainColor = new Color(144,129,84,255);
            subColor = new Color(56,78,92,255);
        }  else if (i == 13) {
            mainColor = new Color(234,251,74,255);
            subColor = new Color(112,70,194,255);
        }  else if (i == 14) { 
            mainColor = new Color(92,223,65,255);
            subColor = new Color(255,150,75,255);
        }  else if (i == 15) { 
            mainColor = new Color(255,255,75,255);
            subColor = new Color(217,64,151,255);
        }  else if (i == 16) { 
            mainColor = new Color(255,209,10,255);
            subColor = new Color(29,94,214,255);
        }  else if (i == 17) { 
            mainColor = new Color(255,178,10,255);
            subColor = new Color(12,184,208,255);
        }  else if (i == 18) { 
            mainColor = new Color(255,123,10,255);
            subColor = new Color(31,84,215,255);
        }  else if (i == 19) { 
            mainColor = new Color(255,16,10,255);
            subColor = new Color(10,198,207,255);
        }  else if (i == 20) { 
            mainColor = new Color(25,39,0,255);
            subColor = new Color(19,1,28,255);
        }  else if (i == 21) { 
            mainColor = new Color(42,41,0,255);
            subColor = new Color(9,3,29,255);
        }  else if (i == 22) { 
            mainColor = new Color(82,78,0,255);
            subColor = new Color(0,25,25,255);
        }  else if (i == 23) { 
            mainColor = new Color(72,49,0,255);
            subColor = new Color(3,11,28,255);
        }  else if (i == 24) { 
            mainColor = new Color(72,33,0,255);
            subColor = new Color(0,22,26,255);
        }  else if (i == 25) { 
            mainColor = new Color(248,136,127,255);
            subColor = new Color(79,143,152,255);
        }  else if (i == 26) { 
            mainColor = new Color(248,191,127,255);
            subColor = new Color(91,179,127,255);
        }  else if (i == 27) { 
            mainColor = new Color(248,217,127,255);
            subColor = new Color(86,130,159,255);
        }  else if (i == 28) { 
            mainColor = new Color(248,242,127,255);
            subColor = new Color(107,99,173,255);
        }  else if (i == 29) { 
            mainColor = new Color(188,230,117,255);
            subColor = new Color(142,88,165,255);
        }
        this.inkColor_r = mainColor.getRed();
        this.inkColor_g = mainColor.getGreen();
        this.inkColor_b = mainColor.getBlue();
        this.inkColor_a = mainColor.getAlpha();
        
        this.subColor_r = subColor.getRed();
        this.subColor_g = subColor.getGreen();
        this.subColor_b = subColor.getBlue();
        this.subColor_a = subColor.getAlpha();
    }
    
    public void setRandomColorForFarbi() {
        int i = (int) (Math.random()*30);
        //Insert some Black SubColors.
        Color mainColor = new Color(0,0,0,255);
        Color subColor = new Color(0,0,0,255);
        if (i == 0) {
            mainColor = new Color(45,136,45,255);
            subColor = new Color(170,57,57,255);
        } else if (i == 1) { 
            mainColor = new Color(34,103,100,255);
            subColor = new Color(170,107,57,255);
        }  else if (i == 2) {
            mainColor = new Color(46,65,114,255);
            subColor = new Color(170,132,57,255);
        }  else if (i == 3) {
            mainColor = new Color(63,48,117,255);
            subColor = new Color(170,149,57,255);
        }  else if (i == 4) {
            mainColor = new Color(85,43,114,255);
            subColor = new Color(170,168,57,255);
        }  else if (i == 5) { 
            mainColor = new Color(127,42,104,255);
            subColor = new Color(134,161,54,255);
        }  else if (i == 6) {
            mainColor = new Color(160,0,153,255);
            subColor = new Color(160,202,0,255);
        }  else if (i == 7) { 
            mainColor = new Color(98,9,162,255);
            subColor = new Color(201,195,0,255);
        }  else if (i == 8) { 
            mainColor = new Color(66,15,164,255);
            subColor = new Color(241,210,0,255);
        }  else if (i == 9) {
            mainColor = new Color(17,53,162,255);
            subColor = new Color(201,125,0,255);
        }  else if (i == 10) { 
            mainColor = new Color(0,146,140,255);
            subColor = new Color(241,107,0,255);
        }  else if (i == 11) {
            mainColor = new Color(0,193,0,255);
            subColor = new Color(241,0,0,255);
        }  else if (i == 12) { 
            mainColor = new Color(0,193,0,255);
            subColor = new Color(0,104,104,255);
        }  else if (i == 13) {
            mainColor = new Color(0,144,144,255);
            subColor = new Color(15,59,161,255);
        }  else if (i == 14) { 
            mainColor = new Color(16,58,162,255);
            subColor = new Color(1,139,145,255);
        }  else if (i == 15) { 
            mainColor = new Color(51,18,166,255);
            subColor = new Color(134,38,191,255);
        }  else if (i == 16) { 
            mainColor = new Color(107,8,161,255);
            subColor = new Color(193,0,109,255);
        }  else if (i == 17) { 
            mainColor = new Color(133,3,170,255);
            subColor = new Color(215,181,0,255);
        }  else if (i == 18) { 
            mainColor = new Color(47,10,177,255);
            subColor = new Color(215,129,0,255);
        }  else if (i == 19) { 
            mainColor = new Color(14,14,180,255);
            subColor = new Color(215,192,0,255);
        }  else if (i == 20) { 
            mainColor = new Color(9,61,172,255);
            subColor = new Color(255,113,0,255);
        }  else if (i == 21) { 
            mainColor = new Color(1,144,157,255);
            subColor = new Color(255,13,0,255);
        }  else if (i == 22) { 
            mainColor = new Color(0,199,24,255);
            subColor = new Color(209,0,110,255);
        }  else if (i == 23) { 
            mainColor = new Color(75,154,134,255);
            subColor = new Color(222,109,129,255);
        }  else if (i == 24) { 
            mainColor = new Color(81,118,154,255);
            subColor = new Color(237,155,116,255);
        }  else if (i == 25) { 
            mainColor = new Color(106,89,163,255);
            subColor = new Color(167,166,46,255);
        }  else if (i == 26) { 
            mainColor = new Color(127,83,159,255);
            subColor = new Color(150,183,69,255);
        }  else if (i == 27) { 
            mainColor = new Color(2,16,27,255);
            subColor = new Color(102,71,0,255);
        }  else if (i == 28) { 
            mainColor = new Color(0,27,21,255);
            subColor = new Color(99,0,66,255);
        }  else if (i == 29) { 
            mainColor = new Color(0,53,22,255);
            subColor = new Color(94,0,78,255);
        }
        this.inkColor_r = mainColor.getRed();
        this.inkColor_g = mainColor.getGreen();
        this.inkColor_b = mainColor.getBlue();
        this.inkColor_a = mainColor.getAlpha();
        
        this.subColor_r = subColor.getRed();
        this.subColor_g = subColor.getGreen();
        this.subColor_b = subColor.getBlue();
        this.subColor_a = subColor.getAlpha();
    }
    
    public void cheatUnlimitedAmmo() {
        this.ink = Integer.MAX_VALUE;
    }
    
    public boolean canMoveForward() {
        char direction = this.getDirection();
        Stage s = this.getWorldOfType(Stage.class);
        if (this.isAnimating()) {
            return false;
        }
        if (direction == 'n') {
            if (this.getRealY()-1 < 4 || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()-1)) || this.hasSphereInFront() || this.hasPlatformInFront()) {
                return false;
            }
        } else if (direction == 'e') {
            if (this.getRealX()+1 >= s.getWidth()/s.width || (this.diveMode == false && s.isWall(this.getRealX()+1, this.getRealY())) || this.hasSphereInFront() || this.hasPlatformInFront()) {
                return false;
            }
        } else if (direction == 's') {
            if (this.getRealY()+1 >= s.getHeight()/s.width || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()+1)) || this.hasSphereInFront() || this.hasPlatformInFront()) {
                return false;
            }
        } else {
            if (this.getRealX()-1 < 0 || (this.diveMode == false && s.isWall(this.getRealX()-1, this.getRealY())) || this.hasSphereInFront() || this.hasPlatformInFront()) {
                return false;
            }
        }
        return true;
    }
    
    public void waitForNextOrder() {
        while (this.isAnimating()) {
            Greenfoot.delay(1);
            this.routine();

        }
    }
    
    public boolean canMoveBackward() {
        char direction = this.getDirection();
        Stage s = this.getWorldOfType(Stage.class);
        if (this.isAnimating()) {
            return false;
        }
        if (direction == 's') {
            if (this.getRealY()-1 < 4 || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()-1))) {
                return false;
            }
        } else if (direction == 'w') {
            if (this.getRealX()+1 >= s.getWidth()/s.width || (this.diveMode == false && s.isWall(this.getRealX() + 1, this.getRealY()))) {
                return false;
            }
        } else if (direction == 'n') {
            if (this.getRealX()+1 >= s.getHeight()/s.width || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()+1))) {
                return false;
            }
        } else {
            if (this.getRealX()-1 < 0 || (this.diveMode == false && s.isWall(this.getRealX()-1, this.getRealY()))) {
                return false;
            }
        }
        return true;
    }
    
    
    public boolean canMoveSidewaysLeft() {
        char direction = this.getDirection();
        Stage s = this.getWorldOfType(Stage.class);
        if (this.isAnimating()) {
            return false;
        }
        if (direction == 'e') {
            if (this.getRealY()-1 < 4 || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()-1))) {
                return false;
            }
        } else if (direction == 's') {
            if (this.getRealX()+1 >= s.getWidth()/s.width || (this.diveMode == false && s.isWall(this.getRealX()+1, this.getRealY()))) {
                return false;
            }
        } else if (direction == 'w') {
            if (this.getRealY()+1 >= s.getHeight()/s.width || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()+1))) {
                return false;
            }
        } else {
            if (this.getRealX()-1 < 0 || (this.diveMode == false && s.isWall(this.getRealX()-1, this.getRealY()))) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean canMoveSidewaysRight() {
        char direction = this.getDirection();
        Stage s = this.getWorldOfType(Stage.class);
        if (this.isAnimating()) {
            return false;
        }
        if (direction == 'w') {
            if (this.getRealY()-1 < 4 || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()-1))) {
                return false;
            }
        } else if (direction == 'n') {
            if (this.getRealX()+1 >= s.getWidth()/s.width || (this.diveMode == false && s.isWall(this.getRealX()+1, this.getRealY()))) {
                return false;
            }
        } else if (direction == 'e') {
            if (this.getRealY()+1 >= s.getHeight()/s.width || (this.diveMode == false && s.isWall(this.getRealX(), this.getRealY()+1))) {
                return false;
            }
        } else {
            if (this.getRealX()-1 < 0 || (this.diveMode == false && s.isWall(this.getRealX()-1, this.getRealY()))) { 
                return false;
            }
        }
        return true;
    }
    
    
    private void addColorToStage() {
       Stage s = this.getWorldOfType(Stage.class);
       s.colors.add(new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a));
    }
    
    private void addPlayerToStage() {
       Stage s = this.getWorldOfType(Stage.class);
       s.players.add(this);
    }
    
    public void changeControl() {
       this.isControllable = !this.isControllable;
    }
    
    /**
     * The method for drawing a Player with a given size.
     * The shape is made of outer and inner circles and a triangle.
     * Input: int
     */
    private void drawPlayer(int size) {
       GreenfootImage im = new GreenfootImage(size,size);   
       
       
       
       
       im.setColor(new Color(this.subColor_r,this.subColor_g,this.subColor_b,this.subColor_a));
       
       
       
       im.fillOval(size/2 - size/3,size/2 - size/3, 2*size/3, 2*size/3);
       im.fillPolygon(new int[]{size/2,size/2+size/3+size/8, size/2,size/2}, new int[]{size/2-size/3,size/2,size/2+size/3,size/2-size/3}, 4);
       im.setColor(new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a));
       im.fillOval(size/2 - size/3+2,size/2 - size/3+2, 2*size/3-4, 2*size/3-4);
       
       
       this.setImage(im);
    }  
    
    
    /**
     * Moves the player one field forward.
     * Works also while diving, but only if the next cell is in the same Color.
     */
    public void moveForward() {
        if (this.canMoveForward()) {
            if (this.diveMode == true) {
                if (this.checkInkFront()) {
                   this.animationMoveForward = true;
                } else {
                   if (!this.hasError()) {
                       
                       this.blase();
                       this.setError("Wand oder (Farb-)Rand getroffen!");                
                   }
                }
            } else {
                this.animationMoveForward = true;
            }
        } else {
            
            if (!this.hasError()) {
                this.bubbleType = "Wand";
                this.blase();
                this.setError("Wand oder (Farb-)Rand getroffen!");                
            }
        } //TODO: Weiteres Else-If bezogen auf Platform/Sphere
    }
    
    public boolean hasError() {
        return this.hasError;
    }
    
    public String getError() {
        return this.error;
    }
    
    private void setError(String e) {
        this.error = e;
        this.hasError = true;
    }
    
    public void animateMoveForward() {
        animationTime++;
        if (this.animationTime % 1 == 0) {
            this.move(5);
        }
        if (this.animationTime == 10) {
            this.animationMoveForward = false;
            this.animationTime = 0;
        }
    }
    
    public void moveSidewaysLeft() {
        if (this.canMoveSidewaysLeft()) {
            if (this.diveMode == true) {
                if (this.checkInkSidewaysLeft()) {
                    this.animationMoveSidewaysLeft = true;
                } else {
                    this.setError("Wand oder (Farb-)Rand getroffen!");
                }
            } else {
                this.animationMoveSidewaysLeft = true;
            }
        } else {
            this.bubbleType = "Wand";
            this.blase();
            this.setError("Wand oder (Farb-)Rand getroffen!");
        }
    }
    
    public void animateMoveSidewaysLeft() {
        animationTime++;
        if (this.animationTime % 1 == 0) {
            this.turn(-90);
            this.move(5);
            this.turn(90);
        }
        if (this.animationTime == 10) {
            this.animationMoveSidewaysLeft = false;
            this.animationTime = 0;
        }
    }
    
    
    public void moveSidewaysRight() {
        if (this.canMoveSidewaysRight()) {
            if (this.diveMode == true) {
                if (this.checkInkSidewaysRight()) {
                    this.animationMoveSidewaysRight = true;
                } else {
                    if (!this.hasError()) {
                        this.blase();
                        this.setError("Wand oder (Farb-)Rand getroffen!");                
                    }
                }
            } else {
                this.animationMoveSidewaysRight = true;
            }
        } else {
            if (!this.hasError()) {
                this.bubbleType = "Wand";
                this.blase();
                this.setError("Wand oder (Farb-)Rand getroffen!");                
            }
        }
    }
    
    public void animateMoveSidewaysRight() {
        animationTime++;
        if (this.animationTime % 1 == 0) {
            this.turn(90);
            this.move(5);
            this.turn(-90);
        }
        if (this.animationTime == 10) {
            this.animationMoveSidewaysRight = false;
            this.animationTime = 0;
        }
    }
    
    //TO animate
    /**
     * Move the player one field backward.
     * Works also while diving, but only if the next cell is in the same Color.
     */
    public void moveBackward() {
        if (this.canMoveBackward()) {
            if (this.diveMode == true) {
                if (this.checkInkBack()) {
                    this.animationMoveBackward = true;
                } else {
                    if (!this.hasError()) {
                        this.blase();
                        this.setError("Wand oder (Farb-)Rand getroffen!");                
                    }
                }
            } else {
                this.animationMoveBackward = true;
            }
        } else {
            if (!this.hasError()) {
                this.bubbleType = "Wand";
                this.blase();
                this.setError("Wand oder (Farb-)Rand getroffen!");                
            }
        }
    }
    
    public void animateMoveBackward() {
        animationTime++;
        if (this.animationTime % 1 == 0) {
            this.move(-5);
        }
        if (this.animationTime == 10) {
            this.animationMoveBackward = false;
            this.animationTime = 0;
        }
    }
    
    /**
     * Turns the player 90 degrees to the right.
     */
    public void turnRight() {
        if (!this.isAnimating()) {
            this.animationRight = true;
        }
    }
    
    private boolean isAnimating () {
        return this.animationRight || this.animationLeft || this.animationShootPistol || this.animationShootBrush || this.animationShootShotgun || this.animationShootRifle || this.animationMoveForward || this.animationMoveSidewaysLeft || this.animationMoveSidewaysRight || this.animationMoveBackward || this.animationShootGrounder || this.animationBubble;
    }
    
    public void bubbleUp() {
        if (!this.isAnimating()) {
            this.animationBubble = true;
        }
    }
    
    public void animateBubble() { //TODO
        animationTime++;
        if (this.animationTime % 1 == 0) {
            this.createBubble(animationTime);
        }
        if (this.animationTime == 20) {
            this.animationBubble = false;
            this.animationTime = 0;
        }
    }
    
    public void createBubble(int time) {
        Stage s = this.getWorldOfType(Stage.class);
        s.removeObject(this.errorBubble);
        this.errorBubble = new Bubble();
        if (bubbleType.equals("Wand")) {
            this.errorBubble.setImage("BubbleWall.png");
        } else if (bubbleType.equals("Token")) {
            this.errorBubble.setImage("BubbleToken.png");
        }
        
        this.errorBubble.getImage().scale((time)*3, (time)*3);
        s.addObject(this.errorBubble,0,0);
        this.errorBubble.setLocation(this.getX()+20, this.getY()-40);

        
    }
    
    public void animateRightTurn() {
        animationTime++;
        if (this.animationTime % 1 == 0) {
            this.turn(10);
        }
        if (this.animationTime == 9) {
            this.animationRight = false;
            this.animationTime = 0;
        }
    }
    /**
     * Turns the player 90 degrees to the left.
     */
    public void turnLeft() {
        if (!this.isAnimating()) {
            this.animationLeft = true;
        }
    }
    
    public void animateLeftTurn() {
        animationTime++;
        if (this.animationTime % 1 == 0) {
            this.turn(-10);
        }
        if (this.animationTime == 9) {
            this.animationLeft = false;
            this.animationTime = 0;
        }
    }
    
    /**
     * Will change the weapon based on a given String.
     * Input: String
     */
    public void changeWeapon(String s) {
        this.weapon = s;
    }
    
    public void shuffleWeapon() {
        if (this.weapon.equals("Pistol")) {
            this.weapon = "Brush";
        } else if (this.weapon.equals("Brush")) {
            this.weapon = "Shotgun";
        } else if (this.weapon.equals("Shotgun")) {
            this.weapon = "Rifle";
        } else {
            this.weapon = "Pistol";
        } 
    }
   
    /**
     * Will shoot with the equipped weapon.
     * Also it will check, whether there's enough ink.
     */
    public void shoot() {
        if (this.diveMode == false && !this.isAnimating()) {
            if (this.weapon.equals("Pistol")) {
                if (this.checkInk(1)) {
                    this.animationShootPistol=true;
                    this.shootDirection=this.getDirection();
                } else {
                    this.setError("Nicht genügend Munition!");
                }
                
            } else if (this.weapon.equals("Brush")) {
                if (this.checkInk(1)) {
                    this.animationShootBrush=true;
                    this.shootDirection=this.getDirection();
                } else {
                    this.setError("Nicht genügend Munition!");
                }
            } else if (this.weapon.equals("Shotgun")) {
                if (this.checkInk(3)) {
                    this.animationShootShotgun=true;
                    this.shootDirection=this.getDirection();
                } else {
                    this.setError("Nicht genügend Munition!");
                }
            } else if (this.weapon.equals("Rifle")) {
                if (this.checkInk(2)) {
                    this.animationShootRifle=true;
                    this.shootDirection=this.getDirection();
                } else {
                    this.setError("Nicht genügend Munition!");
                }
            } else if (this.weapon.equals("Grounder")) {
                if (this.checkInk(1)) {
                    this.animationShootGrounder=true;
                    this.shootDirection=this.getDirection();
                } else {
                    this.setError("Nicht genügend Munition!");
                }
            }
        } else {
            this.setError("Schuss während Tauchens nicht möglich!");
        }
    }
    
    public void animateShootPistol() {
        if (animationTime == 0) {
            shots = new Inkblob[1];
            Inkblob bl = new Inkblob();
            shots[0] = bl;
            if (shootDirection=='n') {
                bl.setRotation(270);
            } else if (shootDirection=='s') {
                bl.setRotation(90);
            } else if (shootDirection=='w') {
                bl.setRotation(180);
            }
            bl.setImage(this.drawShot());
            this.getWorldOfType(Stage.class).addObject(bl, this.getX(), this.getY());
        }
        animationTime++;
        if (this.animationTime % 1 == 0) {
            shots[0].move(10);
        }
        if (this.animationTime == 10) {
            this.getWorldOfType(Stage.class).removeObject(shots[0]);
            //HitAnimation? Like Splatter?
            
            this.usePistol();
            this.useInk(1);
            
            this.animationShootPistol = false;
            this.animationTime = 0;
        }
    }
    
    public boolean hasAmmo() {
        
        if (this.checkInk(1)) {
            return true;
        }
        return false;
    }
    
    public void animateShootBrush() {
        if (animationTime == 0) {
            shots = new Inkblob[1];
            Inkblob bl = new Inkblob();
            shots[0] = bl;
            if (shootDirection=='n') {
                bl.setRotation(270);
            } else if (shootDirection=='s') {
                bl.setRotation(90);
            } else if (shootDirection=='w') {
                bl.setRotation(180);
            }
            bl.setImage(this.drawShot());
            this.getWorldOfType(Stage.class).addObject(bl, this.getX(), this.getY());
        }
        animationTime++;
        if (this.animationTime % 1 == 0) {
            shots[0].move(5);
        }
        if (this.animationTime == 10) {
            this.getWorldOfType(Stage.class).removeObject(shots[0]);
            //HitAnimation? Like Splatter?
            
            this.useBrush();
            this.useInk(1);
            
            this.animationShootBrush = false;
            this.animationTime = 0;
        }
    }
    
    public void animateShootRifle() {
        if (animationTime == 0) {
            shots = new Inkblob[1];
            Inkblob bl = new Inkblob();
            shots[0] = bl;
            if (shootDirection=='n') {
                bl.setRotation(270);
            } else if (shootDirection=='s') {
                bl.setRotation(90);
            } else if (shootDirection=='w') {
                bl.setRotation(180);
            }
            bl.setImage(this.drawShot());
            this.getWorldOfType(Stage.class).addObject(bl, this.getX(), this.getY());
        }
        animationTime++;
        if (this.animationTime % 1 == 0) {
            shots[0].move(15);
        }
        if (this.animationTime == 10) {
            this.getWorldOfType(Stage.class).removeObject(shots[0]);
            //HitAnimation? Like Splatter?
            
            this.useRifle();
            this.useInk(2);
            
            this.animationShootRifle = false;
            this.animationTime = 0;
        }
    }
    
    public void animateShootGrounder() {
        if (animationTime == 0) {
            shots = new Inkblob[1];
            Inkblob bl = new Inkblob();
            shots[0] = bl;
            if (shootDirection=='n') {
                bl.setRotation(270);
            } else if (shootDirection=='s') {
                bl.setRotation(90);
            } else if (shootDirection=='w') {
                bl.setRotation(180);
            }
            bl.setImage(this.drawShot());
            this.getWorldOfType(Stage.class).addObject(bl, this.getX(), this.getY());
        }
        animationTime++;
        if (this.animationTime % 1 == 0) {
            shots[0].move(0);
        }
        if (this.animationTime == 1) {
            this.getWorldOfType(Stage.class).removeObject(shots[0]);
            //HitAnimation? Like Splatter?
            
            this.useGrounder();
            this.useInk(1);
            
            this.animationShootGrounder = false;
            this.animationTime = 0;
        }
    }
    
    public void animateShootShotgun() {
        if (animationTime == 0) {
            shots = new Inkblob[3];
            shots[0] = new Inkblob();
            shots[1] = new Inkblob();
            shots[2] = new Inkblob();
            if (shootDirection=='n') {
                shots[0].setRotation(270);
                shots[1].setRotation(225);
                shots[2].setRotation(315);
            } else if (shootDirection=='s') {
                shots[0].setRotation(90);
                shots[1].setRotation(45);
                shots[2].setRotation(135);
            } else if (shootDirection=='w') {
                shots[0].setRotation(180);
                shots[1].setRotation(135);
                shots[2].setRotation(225);
            } else {
                shots[0].setRotation(0);
                shots[1].setRotation(315);
                shots[2].setRotation(45);
            }
            shots[0].setImage(this.drawShot());
            shots[1].setImage(this.drawShot());
            shots[2].setImage(this.drawShot());
            this.getWorldOfType(Stage.class).addObject(shots[0], this.getX(), this.getY());
            this.getWorldOfType(Stage.class).addObject(shots[1], this.getX(), this.getY());
            this.getWorldOfType(Stage.class).addObject(shots[2], this.getX(), this.getY());
        }
        animationTime++;
        if (this.animationTime % 1 == 0) {
            shots[0].move(5);
            shots[1].move(7);
            shots[2].move(7);
        }
        if (this.animationTime == 10) {
            this.getWorldOfType(Stage.class).removeObject(shots[0]);
            this.getWorldOfType(Stage.class).removeObject(shots[1]);
            this.getWorldOfType(Stage.class).removeObject(shots[2]);
            //HitAnimation? Like Splatter?
            
            this.useShotgun();
            this.useInk(3);
            
            this.animationShootShotgun = false;
            this.animationTime = 0;
        }
    }
    
    private GreenfootImage drawShot() {
        GreenfootImage shot = new GreenfootImage(25,25);
        shot.clear();
        
        shot.setColor(new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a));
        shot.fillOval(0,0,25,25);
        shot.setColor(new Color(0,0,0,255));
        shot.drawOval(0, 0, 25, 25);
        return shot;
    }
    
    /**
     * Simulates the shooting range with a color pistol.
     */
    public void usePistol() {
        Stage stage = this.getWorldOfType(Stage.class);
        if (this.getDirection() == 'e') {
            this.paintField(this.getRealX()+2, this.getRealY(), stage, 1);
        } else if (this.getDirection() == 's'){
            this.paintField(this.getRealX(), this.getRealY()+2, stage, 1);
        } else if (this.getDirection() == 'w'){
            this.paintField(this.getRealX()-2, this.getRealY(), stage, 1);
        } else {
            this.paintField(this.getRealX(), this.getRealY()-2, stage, 1);
        }
        Greenfoot.playSound("Splat And Squirt-SoundBible.com-2136633229.wav");
    }
    
    /**
     * Simulates the hit range with a color brush.
     */
    public void useBrush() {
        Stage stage = this.getWorldOfType(Stage.class);
        if (this.getDirection() == 'e') {
            this.paintField(this.getRealX()+1, this.getRealY(), stage, 2);
        } else if (this.getDirection() == 's'){
            this.paintField(this.getRealX(), this.getRealY()+1, stage, 2);
        } else if (this.getDirection() == 'w'){
            this.paintField(this.getRealX()-1, this.getRealY(), stage, 2);
        } else {
            this.paintField(this.getRealX(), this.getRealY()-1, stage, 2);
        }
        Greenfoot.playSound("Splat And Squirt-SoundBible.com-2136633229.wav");
    }
    
    /**
     * Simulates the shooting range with a color shotgun.
     */
    public void useShotgun() {
        Stage stage = this.getWorldOfType(Stage.class);
        if (this.getDirection() == 'e') {
            this.paintField(this.getRealX()+1, this.getRealY(), stage, 1);
            this.paintField(this.getRealX()+1, this.getRealY()-1, stage, 1);
            this.paintField(this.getRealX()+1, this.getRealY()+1, stage, 1);
        } else if (this.getDirection() == 's'){
            this.paintField(this.getRealX(), this.getRealY()+1, stage, 1);
            this.paintField(this.getRealX()-1, this.getRealY()+1, stage, 1);
            this.paintField(this.getRealX()+1, this.getRealY()+1, stage, 1);
        } else if (this.getDirection() == 'w'){
            this.paintField(this.getRealX()-1, this.getRealY(), stage, 1);
            this.paintField(this.getRealX()-1, this.getRealY()+1, stage, 1);
            this.paintField(this.getRealX()-1, this.getRealY()-1, stage, 1);
        } else {
            this.paintField(this.getRealX(), this.getRealY()-1, stage, 1);
            this.paintField(this.getRealX()+1, this.getRealY()-1, stage, 1);
            this.paintField(this.getRealX()-1, this.getRealY()-1, stage, 1); 
        }
        Greenfoot.playSound("Splat And Squirt-SoundBible.com-2136633229.wav");
    }
    
    /**
     * Simulates the shooting range with a color rifle.
     */
    public void useRifle() {
        Stage stage = this.getWorldOfType(Stage.class);
        if (this.getDirection() == 'e') {
            this.paintField(this.getRealX()+3, this.getRealY(), stage, 1);
            this.paintField(this.getRealX()+4, this.getRealY(), stage, 1);
        } else if (this.getDirection() == 's'){
            this.paintField(this.getRealX(), this.getRealY()+3, stage, 1);
            this.paintField(this.getRealX(), this.getRealY()+4, stage, 1);
        } else if (this.getDirection() == 'w'){
            this.paintField(this.getRealX()-3, this.getRealY(), stage, 1);
            this.paintField(this.getRealX()-4, this.getRealY(), stage, 1);
        } else {
            this.paintField(this.getRealX(), this.getRealY()-3, stage, 1);
            this.paintField(this.getRealX(), this.getRealY()-4, stage, 1);
        }
        Greenfoot.playSound("Splat And Squirt-SoundBible.com-2136633229.wav");
    }
    
    public void useGrounder() {
        Stage stage = this.getWorldOfType(Stage.class);
        this.paintField(this.getRealX(),this.getRealY(),stage,1);
        
        Greenfoot.playSound("Splat And Squirt-SoundBible.com-2136633229.wav");
    }
   
    private void paintField(int x, int y, Stage stage, int dmg) {
        stage.paintCell(new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a), x, y);
        this.checkAndHit(x, y, dmg);
    }
    
    /**
     * Checks, if there is enough Ink to shoot.
     * Input: int
     * Output: boolean
     */
    public boolean checkInk(int amount) {
        if (amount <= this.ink) {
            return true;
        }
        return false;
    }
    
    /**
     * Decreases the Ink after a shot.
     * Input: int
     */
    public void useInk(int amount) {
        this.ink -= amount;
    }
    
    /**
     * Checks the direction the character faces.
     * Output: char
     */
    private char getDirection() {
        if (this.getRotation() >= 0 && this.getRotation() < 90) {
            return 'e';
        } else if (this.getRotation() >= 90 && this.getRotation() < 180) {
            return 's';
        } else if (this.getRotation() >= 180 && this.getRotation() < 270) {
            return 'w';
        } else {
            return 'n';
        }
    }
    
    /**
     * Calculates the complementary color to a given Color.
     * Input: Color
     * Output: Color
     */
    private Color calculateComplementary(Color c) {
        /*
         * 1. Convert your colour to HSL.

         * 2. Change the Hue value to that of the Hue opposite (e.g., if your Hue is 50°, the opposite one will be at 230° on the wheel — 180° further around).

         * 3. Leave the Saturation and Lightness values as they were.

         * 4. Convert this new HSL value back to your original colour notation (RGB or whatever).

         */
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        
        double r2 = (double)r/255;
        double g2 = (double)g/255;
        double b2 = (double)b/255;
        
        //Convert RGB to HSL with r2,g2,b2
        double min = Math.min(Math.min(r2, g2),b2);
        double max = Math.max(Math.max(r2, g2),b2);
        
        double diff = max - min;
        
        
        double l = (max + min)/2;
        double h = 0;
        double s;

        
        
        if (diff == 0) {
            h = 0;
            s = 0;
        } else {
            if (l < 0.5) {
                s = diff/(max+min);
            } else {
                s = diff/(2-max-min);
            }
            
            double r3 = (((max - r2) / 6) + (diff / 2)) / diff;
            double g3 = (((max - g2) / 6) + (diff / 2)) / diff;
            double b3 = (((max - b2) / 6) + (diff / 2)) / diff;
            
      
            if (r2 == max) {
                h = b3 - g3;
            } else if (g2 == max) {
                h = (1 / 3) + r3 - b3;
            } else if (b2 == max) {
                h = (2 / 3) + g3 - r3;
            }
            
            if (h < 0) {
                h += 1;
            }
            
            if (h > 1){
                h -= 1;
            }
        }
        
        //Calculate the opposite hue
        double h2 = h + 0.5;
        if (h2 > 1) {
            h2 -= 1;
        }
        
        double r4;
        double g4;
        double b4;
        
        double var1;
        double var2;
        
        //Converting to RGB
        
        if (s == 0) {
            r4 = l*255;
            g4 = l*255;
            b4 = l*255;
        } else {
            if (l < 0.5) {
                var2 = l * (1+s); 
            } else {
                var2 = (l+s)-(s*l);
            }
            
            var1 = 2*l - var2;
            
            r4 = 255*hue_to_rgb(var1,var2,h2+(1/3));
            g4 = 255*hue_to_rgb(var1,var2,h2);
            b4 = 255*hue_to_rgb(var1,var2,h2-(1/3));
             
        }
        if (r4 >= 255 || g4 >= 255 || b4 >= 255) {
            return new Color(255,255,255,255);
        }
        if (r4 < 0 || g4 < 0 || b4 < 0) {
            return new Color(0,0,0,255);
        }
        return new Color((int)r4,(int)g4,(int)b4,255);
    }
    
    /**
     * Transforms a Color from HUE to RGB.
     * Input: double, double, double
     * Output: double
     */
    private double hue_to_rgb(double v1, double v2, double vh) {
        if (vh < 0) {
            vh += 1;
        }
        
        if (vh > 1) {
            vh -= 1;
        }
        
        if ((6*vh) < 1) {
            return (v1 + (v2-v1)*6*vh);
        }
        
        if ((2*vh) < 1) {
            return v2;
        }
        
        if ((3*vh) < 2) {
            return (v1 + (v2-v1)*((2/3-vh)*6));
        }
        
        return v1;
    }
    
    /**
     * Lets the character dive if standing on the same Color.
     */
    public void dive() {
        if (checkInkGround()) {
            if (this.diveMode == false) {
                this.diveMode = true;
                GreenfootImage gf = this.getImage();
                gf.scale(40, 40);
                this.setImage(gf);
                Greenfoot.playSound("Squish 1-SoundBible.com-662226724.wav");
            }
        }
    }
    
    /**
     * Lets the character emerge out of diving.
     */
    public void emerge() {
        if (this.diveMode == true && !this.isUnderWall()) {
            this.diveMode = false;
                this.drawPlayer(50);
            Greenfoot.playSound("Squishy 2-SoundBible.com-1775292371.wav");
        }
   
    }
    
    /**
     * Will increase the amount of ink by one.
     */
    private void fillUp() {
        if (this.ink < this.MAX_INK) {
            this.ink++;
        }
    }
    
    /**
     * Checks the cell, the character currently is standing on, for the color.
     * Output: boolean
     */
    public boolean checkInkGround() {
        if (this.getWorldOfType(Stage.class).field[this.getRealX()][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
           return true;
        }
        return false;
    }
    
    private boolean checkEnemyInkGround() {
        if (this.compareColor(this.getWorldOfType(Stage.class).field[this.getRealX()][this.getRealY()], new Color(255,255,255,255))) {
            return false;
        } else if (this.checkInkGround()) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean compareColor(Color c1, Color c2) {
        if (c1.getRed() != c2.getRed()) {
            return false;
        }
        if (c1.getBlue() != c2.getBlue()) {
            return false;
        }
        if (c1.getGreen() != c2.getGreen()) {
            return false;
        }
        if (c1.getAlpha() != c2.getAlpha()) {
            return false;
        }
        return true;
    }
    
    /**
     * Checks the following cell and returns true, when that cell is in the same color of the character.
     * Output: boolean
     */
    private boolean checkInkFront() {
        Stage st = this.getWorldOfType(Stage.class);
        
        if (this.getDirection() == 'e') {
            if (this.getRealX()+1 < st.getWidth()/st.width) {
                if (st.field[this.getRealX()+1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }   
        } else if (this.getDirection() == 's'){
            if (this.getRealY()+1 < st.getHeight()/st.width) {
                if (st.field[this.getRealX()][this.getRealY()+1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
        } else if (this.getDirection() == 'w') {
            if (this.getRealX()-1 >= 0) {
                if (st.field[this.getRealX()-1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                   return true;
                }    
            }
            
        } else {
            if (this.getRealY()-1 >= 0) {
                if (st.field[this.getRealX()][this.getRealY()-1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
           
        }
        return false;  
       
    }
    
    /**
     * Checks the cell behind the character and returns true, when that cell is in the same color of the character.
     * Output: boolean
     */
    private boolean checkInkBack() {
        Stage st = this.getWorldOfType(Stage.class);
        
        if (this.getDirection() == 'e') {
            if (this.getRealX()-1 >= 0) {
                if (st.field[this.getRealX()-1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }   
        } else if (this.getDirection() == 's'){
            if (this.getRealY()-1 >= 0) {
                if (st.field[this.getRealX()][this.getRealY()-1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
        } else if (this.getDirection() == 'w') {
            if (this.getRealX()+1 < st.getWidth()/st.width) {
                if (st.field[this.getRealX()+1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                   return true;
                }    
            }
            
        } else {
            if (this.getRealY()+1 < st.getHeight()/st.width) {
                if (st.field[this.getRealX()][this.getRealY()+1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
           
        }
        return false;  
    }
    
    private boolean checkInkSidewaysLeft() {
        Stage st = this.getWorldOfType(Stage.class);
        
        if (this.getDirection() == 's') {
            if (this.getRealX()+1 < st.getWidth()/st.width) {
                if (st.field[this.getRealX()+1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }   
        } else if (this.getDirection() == 'w'){
            if (this.getRealY()+1 < st.getHeight()/st.width) {
                if (st.field[this.getRealX()][this.getRealY()+1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
        } else if (this.getDirection() == 'n') {
            if (this.getRealX()-1 >= 0) {
                if (st.field[this.getRealX()-1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                   return true;
                }    
            }
            
        } else {
            if (this.getRealY()-1 >= 0) {
                if (st.field[this.getRealX()][this.getRealY()-1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
           
        }
        return false;  
       
    }
    
    private boolean checkInkSidewaysRight() {
        Stage st = this.getWorldOfType(Stage.class);
        
        if (this.getDirection() == 'n') {
            if (this.getRealX()+1 < st.getWidth()/st.width) {
                if (st.field[this.getRealX()+1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }   
        } else if (this.getDirection() == 'e'){
            if (this.getRealY()+1 < st.getHeight()/st.width) {
                if (st.field[this.getRealX()][this.getRealY()+1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
        } else if (this.getDirection() == 's') {
            if (this.getRealX()-1 >= 0) {
                if (st.field[this.getRealX()-1][this.getRealY()] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                   return true;
                }    
            }
            
        } else {
            if (this.getRealY()-1 >= 0) {
                if (st.field[this.getRealX()][this.getRealY()-1] == new Color(this.inkColor_r,this.inkColor_g,this.inkColor_b,this.inkColor_a)) {
                    return true;
                }
            }
           
        }
        return false;  
       
    }
    
    
    /**
     * Defines the control scheme of the character
     * Input: String
     */
    private void control(String s) {
        if (s != null) {
            if (s.equals("a")) {
                this.turnLeft();
            } else if (s.equals("d")) {
                this.turnRight();
            } else if (s.equals("w")) {
                this.moveForward();
            } else if (s.equals("s")) {
                this.moveBackward();
            } else if (s.equals("space")) {
                this.shoot();
            } else if (s.equals("q")) {
                this.moveSidewaysLeft(); 
            } else if (s.equals("e")) {
                this.moveSidewaysRight();
            } else if (s.equals("m")) {
                if (this.diveMode == true) {
                    this.emerge();
                } else {
                    this.dive();
                }
            } else if (s.equals("n")) {
                this.shuffleWeapon();
            }
        }
    }
    
    /**
     * Refill the Ink, if in diving mode.
     */
    private void refillInk() {
         if (this.diveMode == true) {
        
            this.fillTime++;
            if (fillTime > 75) {
                this.fillUp();
                this.fillTime = 0;
            }
        }
    }
    
    private void groundDamage() {
         if (this.checkEnemyInkGround() == true) {      
            this.dmgTime++;
            if (dmgTime > 150) {
                this.getDamaged(1);
                this.dmgTime = 0;
            }
        } else {
            this.dmgTime = 0;
        }
    }
    
    public boolean isTarget() {
        
        
        Stage s = this.getWorldOfType(Stage.class);
        if (this.getDirection() == 'n') {
            List<Target> ti = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()-2),Target.class);
            if (!ti.isEmpty()) {
                return true;
            } else {
                return false;
            }
            
        } else if (this.getDirection() == 'e') {
            List<Target> ti = s.getObjectsAt(s.getRealX(this.getRealX()+2),s.getRealY(this.getRealY()),Target.class);
            if (!ti.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else if (this.getDirection() == 's') {
            List<Target> ti = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()+2),Target.class);
            if (!ti.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else if (this.getDirection() == 'w') {
            List<Target> ti = s.getObjectsAt(s.getRealX(this.getRealX()-2),s.getRealY(this.getRealY()),Target.class);
            if (!ti.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
        return true;
        
        
    }
    
    public boolean isCheckpoint() {
        
        Stage s = this.getWorldOfType(Stage.class);
        int width = s.getWidth()/s.width;
        int height = s.getHeight()/s.width;
        
        
        if (this.getDirection() == 'n') {
            for (int y = this.getRealY(); y >= 4; y--) {
                List<Checkpoint> c = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(y),Checkpoint.class);
                if (!c.isEmpty()) {
                    return true;
                }
                List<Wall> w = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(y),Wall.class);
                if (!w.isEmpty()) {
                    return false;
                }
                
            }
            return false;
          
        } else if (this.getDirection() == 'e') {
            for (int x = this.getRealX(); x < width; x++) {

                List<Checkpoint> c = s.getObjectsAt(s.getRealX(x),s.getRealY(this.getRealY()),Checkpoint.class);
                if (!c.isEmpty()) {
                    return true;
                } 
                List<Wall> w = s.getObjectsAt(s.getRealX(x),s.getRealY(this.getRealY()),Wall.class);
                if (!w.isEmpty()) {
                    return false;
                }
            }
            return false;
        } else if (this.getDirection() == 's') {
            for (int y = this.getRealY(); y < height; y++) {
                List<Checkpoint> c = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(y),Checkpoint.class);
                if (!c.isEmpty()) {
                    return true;
                }
                List<Wall> w = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(y),Wall.class);
                if (!w.isEmpty()) {
                    return false;
                }
            }
            return false;
        } else if (this.getDirection() == 'w') {
            for (int x = this.getRealX(); x >= 0; x--) {
                List<Checkpoint> c = s.getObjectsAt(s.getRealX(x),s.getRealY(this.getRealY()),Checkpoint.class);
                if (!c.isEmpty()) {
                    return true;
                }
                List<Wall> w = s.getObjectsAt(s.getRealX(x),s.getRealY(this.getRealY()),Wall.class);
                if (!w.isEmpty()) {
                    return false;
                }
            }
            return false;
        }
        return true;
        
        
    }
    
    public boolean isItem() {
        
        Stage s = this.getWorldOfType(Stage.class);
        List<Item> it = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()),Item.class);
        if (!it.isEmpty()) {
            return true;
        } else {
            return false;
        } 
    }
    
    public boolean isOutline() {
        
        Stage s = this.getWorldOfType(Stage.class);
        List<Outline> ot = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()),Outline.class);
        if (!ot.isEmpty()) {
            if (ot.get(0).isSecret == false) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        } 
    }
    
    public Sphere getSphere() {
                
        Stage s = this.getWorldOfType(Stage.class);
        if (this.getDirection() == 'n') {
            List<Sphere> sp = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()-1),Sphere.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
            
        } else if (this.getDirection() == 'e') {
            List<Sphere> sp = s.getObjectsAt(s.getRealX(this.getRealX()+1),s.getRealY(this.getRealY()),Sphere.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
        } else if (this.getDirection() == 's') {
            List<Sphere> sp = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()+1),Sphere.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
        } else if (this.getDirection() == 'w') {
            List<Sphere> sp = s.getObjectsAt(s.getRealX(this.getRealX()-1),s.getRealY(this.getRealY()),Sphere.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
        }
        return null;
        
        
    }
    
    public Platform getPlatform() {
                
        Stage s = this.getWorldOfType(Stage.class);
        if (this.getDirection() == 'n') {
            List<Platform> sp = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()-1),Platform.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
            
        } else if (this.getDirection() == 'e') {
            List<Platform> sp = s.getObjectsAt(s.getRealX(this.getRealX()+1),s.getRealY(this.getRealY()),Platform.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
        } else if (this.getDirection() == 's') {
            List<Platform> sp = s.getObjectsAt(s.getRealX(this.getRealX()),s.getRealY(this.getRealY()+1),Platform.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
        } else if (this.getDirection() == 'w') {
            List<Platform> sp = s.getObjectsAt(s.getRealX(this.getRealX()-1),s.getRealY(this.getRealY()),Platform.class);
            if (!sp.isEmpty()) {
                return sp.get(0);
            } else {
                return null;
            }
        }
        return null;
        
        
    }
    
    private void checkAndHit(int x, int y, int dmg) {
        Stage s = this.getWorldOfType(Stage.class);
        List<Player> li = s.getObjectsAt(s.getRealX(x),s.getRealY(y),Player.class);
        if (!li.isEmpty()) {
            Player p = li.get(0);
            if (!p.equals(null)) {
                if (!p.equals(this)) {
                    this.hitEnemy(p,dmg);
                    //hit
                }
            }
            if (li.size() == 2) {
                p = li.get(1);
                if (!p.equals(null)) {
                    if (!p.equals(this)) {
                        this.hitEnemy(p,dmg);
                        
                        //hit
                    }
                }
            }
           
        }
        //CheckForTargets
        List<Target> ti = s.getObjectsAt(s.getRealX(x),s.getRealY(y),Target.class);
        if (!ti.isEmpty()) {
            Target t = ti.get(0);
            if (!t.equals(null)) {
                if (!t.equals(this)) {
                    this.hitTarget(t);
                    //hit
                }
            }
        }
        
        List<Outline> ol = s.getObjectsAt(s.getRealX(x),s.getRealY(y),Outline.class);
        if (!ol.isEmpty()) {
            Outline o = ol.get(0);
            if (!o.equals(null)) {
                if (!o.equals(this)) {
                    this.fillOutline(o);
                    //hit
                }
            }
        } else {
            if (this.outlineGoal) {
                this.setError("Nicht-Markierungen wurden gefärbt!");
            }
            
        }
        
            //not hit
    }
    
    public int getPlatformValue() {
        if (this.hasPlatformInFront()) {
            return this.getPlatform().value;
        } else {
            //ERROR - keine Plattform
        }
        return -1;
    }
    
    public void rememberValue() {
        int v = -1;
        if (this.hasSphereInFront()) {
            //Merke Wert der Kugel
            v = this.getSphere().value;
        } else if (this.hasPlatformInFront()) {
            Platform p = this.getPlatform();
            //Falls Plattform Kugel hat, deren Wert merken
            if (p.hasSphere) {
                v = p.sphere.value;
            } else {
                //Merke Wert der Plattform
                v = p.value;
            }
            
            
            
            this.wert = v;
        } else {
            //ERROR - keine Kugel oder Plattform
        }
        
    }
    
    public boolean isValue() {
        if (this.wert >= 0) {
            if (this.hasSphereInFront()) {
                if (this.wert == this.getSphere().value) {
                    return true;  
                } else {
                    //Nicht der richtige Wert
                    return false;
                }
            } else {
                if (this.hasPlatformInFront()) {
                    Platform p = this.getPlatform();
                    if (p.hasSphere) {
                        if (this.wert == p.sphere.value) {
                            return true;
                        }
                    }
                } else {
                    
                }
                //ERROR - keine Sphäre vor dir
                
                return false; ///???
            }
        } else {
            //ERROR - keinen Wert gemerkt
            
            return false; //????TODO
        }
    }
    
    public boolean isValueSmaller() {
        if (this.wert >= 0) {
            if (this.hasSphereInFront()) {
                if (this.wert < this.getSphere().value) {
                    return true;  
                } else {
                    //Nicht der richtige Wert
                    return false;
                }
            } else {
                if (this.hasPlatformInFront()) {
                    Platform p = this.getPlatform();
                    if (p.hasSphere) {
                        if (this.wert < p.sphere.value) {
                            return true;
                        }
                    }
                } else {
                    
                }
                //ERROR - keine Sphäre vor dir
                
                return false; ///???
            }
        } else {
            //ERROR - keinen Wert gemerkt
            
            return false; //????TODO
        }
    }
    
    public boolean isValueBigger() {
        if (this.wert >= 0) {
            if (this.hasSphereInFront()) {
                if (this.wert > this.getSphere().value) {
                    return true;  
                } else {
                    //Nicht der richtige Wert
                    return false;
                }
            } else {
                if (this.hasPlatformInFront()) {
                    Platform p = this.getPlatform();
                    if (p.hasSphere) {
                        if (this.wert > p.sphere.value) {
                            return true;
                        }
                    }
                } else {
                    
                }
                //ERROR - keine Sphäre vor dir
                
                return false; ///???
            }
        } else {
            //ERROR - keinen Wert gemerkt
            
            return false; //????TODO
        }
    }
    
    public void setOutlineAsOnlyGoal() {
        this.outlineGoal = true;
    }
    
    public boolean hasWallInFront() {
        
        if (this.getDirection() == 'n') {
            return this.getWorldOfType(Stage.class).isWall(getRealX(),this.getRealY()-1);
        } else if (this.getDirection() == 'e') {
            return this.getWorldOfType(Stage.class).isWall(getRealX()+1,this.getRealY());
        } else if (this.getDirection() == 's') {
            return this.getWorldOfType(Stage.class).isWall(getRealX(),this.getRealY()+1);
        } else if (this.getDirection() == 'w') {
            return this.getWorldOfType(Stage.class).isWall(getRealX()-1,this.getRealY());
        }
        return true;
    }
    
    public boolean hasColorInFront() {
        
        if (this.getDirection() == 'n') {
            return this.getWorldOfType(Stage.class).isColor(getRealX(),this.getRealY()-1);
        } else if (this.getDirection() == 'e') {
            return this.getWorldOfType(Stage.class).isColor(getRealX()+1,this.getRealY());
        } else if (this.getDirection() == 's') {
            return this.getWorldOfType(Stage.class).isColor(getRealX(),this.getRealY()+1);
        } else if (this.getDirection() == 'w') {
            return this.getWorldOfType(Stage.class).isColor(getRealX()-1,this.getRealY());
        }
        return true;
    }

    public boolean hasSphereInFront() {
        
        if (this.getDirection() == 'n') {
            return this.getWorldOfType(Stage.class).isSphere(getRealX(),this.getRealY()-1);
        } else if (this.getDirection() == 'e') {
            return this.getWorldOfType(Stage.class).isSphere(getRealX()+1,this.getRealY());
        } else if (this.getDirection() == 's') {
            return this.getWorldOfType(Stage.class).isSphere(getRealX(),this.getRealY()+1);
        } else if (this.getDirection() == 'w') {
            return this.getWorldOfType(Stage.class).isSphere(getRealX()-1,this.getRealY());
        }
        return true;
    }
    
    public boolean hasPlatformInFront() {
        
        if (this.getDirection() == 'n') {
            return this.getWorldOfType(Stage.class).isPlatform(getRealX(),this.getRealY()-1);
        } else if (this.getDirection() == 'e') {
            return this.getWorldOfType(Stage.class).isPlatform(getRealX()+1,this.getRealY());
        } else if (this.getDirection() == 's') {
            return this.getWorldOfType(Stage.class).isPlatform(getRealX(),this.getRealY()+1);
        } else if (this.getDirection() == 'w') {
            return this.getWorldOfType(Stage.class).isPlatform(getRealX()-1,this.getRealY());
        }
        return true;
    }
    
    private boolean isUnderWall() {
        return this.getWorldOfType(Stage.class).isWall(this.getRealX(), this.getRealY());
    }
    
    private void hitEnemy(Player p, int dmg) {
        p.getDamaged(dmg);
    }
    
    private void getDamaged(int dmg) {
        this.hp -= dmg;
        if (this.hp <= 0) {
            this.dissolve();
        }
    }
    
    private void dissolve() {
        this.setImage(new GreenfootImage(1,1));
        this.isDead = true;
    }
    
    private void respawn() {
        if (this.isDead == true) {
            this.respawnTime++;
            if (this.respawnTime == 200) {
                this.drawPlayer(this.getWorldOfType(Stage.class).width);
                this.hp = this.MAX_HP;
                this.ink = this.MAX_INK;
                this.respawnTime = 0;
                this.isDead = false;
            }
        }
    }
    
    private void checkCheckpoint() {
        Checkpoint cp = (Checkpoint)this.getOneIntersectingObject(Checkpoint.class);
        if (cp != null) {
            this.getWorldOfType(Stage.class).check(cp);
        }
    }
    
    private void hitTarget(Target t) {
        this.getWorldOfType(Stage.class).hitTarget(t);
    }
    
    private void fillOutline(Outline o) {
        this.getWorldOfType(Stage.class).fillOutline(o);
    }
    
    private boolean checkItem() {
        Item it = (Item)this.getOneIntersectingObject(Item.class);
        if (it != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void take() {
        if (this.checkItem()) {
            this.getWorldOfType(Stage.class).takeItem((Item)this.getOneIntersectingObject(Item.class));
        } else {
            if (!this.hasError()) {
                this.bubbleType = "Token";
                this.blase();
                this.setError("Kein Token auf dem Boden!");                
            }
        }
    }
    
    public void pickUp() {
        
        if (!this.hasSphere) {
            if (this.hasSphereInFront()) {
                Sphere s = this.getSphere();
                
                this.sphere = s;
                this.hasSphere = true;
                this.getWorldOfType(Stage.class).pickUpSphere(s);
                
            } else if (this.hasPlatformInFront()) {
                Platform p = this.getPlatform();
                
                if (p.hasSphere) {
                    Sphere s = p.takeSphere();
                    
                    this.sphere = s;
                    this.hasSphere = true;
                   
                } else {
                    if (!this.hasError()) {
                        this.bubbleType = "NoSphereInPlatform";
                        this.blase();
                        this.setError("Keine Kugel auf der Platform!");                
                    }
                }
                
                
            } else {
                if (!this.hasError()) {
                    this.bubbleType = "NoSphereOnGround";
                    this.blase();
                    this.setError("Keine Kugel auf dem Boden!");                
                }
            }
        } else {
            if (!this.hasError()) {
                this.bubbleType = "TwoSpheres";
                this.blase();
                this.setError("Bereits eine Kugel in der Hand!");                
            }
        }
        
    }
    
    public void putDown() {
        
        if (this.hasSphere) {
            if (this.hasPlatformInFront()) {
                //Get Platform
                Platform p = this.getPlatform();
                
                if (!p.hasSphere) {
                    p.putSphere(this.sphere);
                    this.sphere = null;
                    this.hasSphere = false;
                } else {
                    if (!this.hasError()) {
                        this.bubbleType = "SphereInPlatform";
                        this.blase();
                        this.setError("Bereits eine Kugel auf der Platform!");                
                    }
                }
                
                
                
                
                //Put into Platform
            } else if (this.hasWallInFront()) {
                if (!this.hasError()) {
                    this.bubbleType = "SphereWall";
                    this.blase();
                    this.setError("Kugel kann nicht auf Wand abgelegt werden.");                
                }
            } else {
   
                Stage s = this.getWorldOfType(Stage.class);
                if (this.getDirection() == 'n') {
                    s.putDownSphere(this.sphere, this.getRealX(), this.getRealY() - 1);
                } else if (this.getDirection() == 's') {
                    s.putDownSphere(this.sphere, this.getRealX(), this.getRealY() + 1);
                } else if (this.getDirection() == 'e') {
                    s.putDownSphere(this.sphere, this.getRealX() + 1, this.getRealY());
                } else {
                    s.putDownSphere(this.sphere, this.getRealX() - 1, this.getRealY());
                }
                this.sphere = null;
                this.hasSphere = false;
                
                //Einfaches ablegen.
            }
            
            //TODO: Nicht auf Checkpoint oder Zielscheibe ablegbar
            
            
        } else {
            if (!this.hasError()) {
                this.bubbleType = "NoSphereInHand";
                this.blase();
                this.setError("Keine Kugel zum Ablegen in der Hand!");                
            }
        }
    }
    
    public int getValue() {
        if (this.hasSphere) {
            return this.sphere.value;
        }
        else {
            return -1;
        }
    }
    
    public boolean compareSpheres() {
        if (this.hasSphere) {
            if (this.hasSphereInFront()) {
                //True, wenn meine Sphäre größer
                if (this.sphere.value > this.getSphere().value) {
                    return true;
                } else {
                    return false;
                }
                //False, wenn meine Sphäre kleiner
                
            } else {
                if (!this.hasError()) {
                    this.bubbleType = "NoSphereInPlatformToCompare";
                    this.blase();
                    this.setError("Keine Kugel zum Vergleichen in der Hand!");                
                }
            }
        } else {
            if (!this.hasError()) {
                this.bubbleType = "NoSphereInHandToCompare";
                this.blase();
                this.setError("Keine Kugel zum Vergleichen in der Hand!");                
            }
        }
        return false;
    }
    
    public int getRealX() {
        return this.getX()/this.getWorldOfType(Stage.class).width;
    }
    
    public int getRealY() {
        return this.getY()/this.getWorldOfType(Stage.class).width;
    }
    
    
    public void routine() {
        if (this.firstAct == true) {
            this.addColorToStage();
            this.addPlayerToStage();
            
            
            this.firstAct = false;
        }
        if (!isDead) {
            if (isControllable == true) {
                String s = Greenfoot.getKey();
                this.control(s);
            } else {
                //KI
            }
            if (animationRight == true) {
                this.animateRightTurn();
            } else if (animationLeft == true) {
                this.animateLeftTurn();
            } else if (animationShootPistol == true) {
                this.animateShootPistol();
            } else if (animationShootBrush == true) {
                this.animateShootBrush();
            } else if (animationShootShotgun == true) {
                this.animateShootShotgun();
            } else if (animationShootRifle == true) {
                this.animateShootRifle();
            } else if (animationShootGrounder == true) {
                this.animateShootGrounder();
            } else if (animationMoveForward == true) {
                this.animateMoveForward();
            } else if (animationMoveSidewaysLeft == true) {
                this.animateMoveSidewaysLeft();
            } else if (animationMoveSidewaysRight == true) {
                this.animateMoveSidewaysRight();
            } else if (animationMoveBackward == true) {
                this.animateMoveBackward();
            } else if (animationBubble == true) {
                this.animateBubble();
            }
            this.refillInk();
            this.groundDamage();
            this.checkCheckpoint();
        } else {
            this.animationRight = false;
            animationLeft = false;
            animationShootPistol = false;
            animationShootBrush = false;
            animationShootShotgun = false;
            animationShootRifle = false;
            animationShootGrounder = false;
            animationMoveForward = false;
            animationMoveSidewaysLeft = false;
            animationMoveSidewaysRight = false;
            animationMoveBackward = false;
            animationBubble = false;
        }
       
        this.respawn();
    }
    
    public String startHTML() {
        CampaignLevel cl = this.getWorldOfType(CampaignLevel.class);
        String ch = ""+cl.chapter;
        String lv = ""+cl.level;
        
        String html = "";
        html += "<!DOCTYPE html>\n";
        html += "<html>\n";
        html += "\t<head>\n";
        html += "\t\t<title>Lösung</title>\n";
        html += "\t\t<link href=\"css/main.css\" type=\"text/css\" rel=\"stylesheet\"/>\n";
        html += "\t\t<meta charset=\"utf-8\"/>\n";
        html += "\t</head>\n";
        html += "\t<body>\n";
        
        //inhalt
        html += "\t\t<div class=\"main\">\n";
        html += "\t\t\t<h1>Deine Lösung</h1>\n";
        html += "\t\t\t<h2>"+ch+". Kapitel</h2>\n";
        html += "\t\t\t<h2>"+lv+". Level</h2>\n";
        html += "\t\t\t<p><a class=\"back\" href=\"index.html\">Zurück</a></p>\n";
        
        html += "\t\t\t<table>\n";
       
        return html;
    }
    
    public String endHTML(String first, String second, int loc) {
        String html = "";
        html += "\t\t\t\t<tr>\n";
        html += "\t\t\t\t\t<td>"+first+"</td>\n";
        html += "\t\t\t\t\t<td>"+second+"</td>\n";
 
        html += "\t\t\t\t</tr>\n";
        html += "\t\t\t</table>\n";
        html += "\t\t\t<p class=\"loc\">Lines of Code (LoC): " +loc+"</p>\n";
        html += "\t\t\t<p><a class=\"back\" href=\"index.html\">Zurück</a></p>\n";
        html += "\t\t</div>\n";
        html += "\t</body>\n";
        html += "</html>\n";
        return html;
    }
    
    public void updateIndex() {
        String html = "";
        html += "<!DOCTYPE html>\n";
        html += "<html>\n";
        html += "\t<head>\n";
        html += "\t\t<title>Lösung</title>\n";
        html += "\t\t<link href=\"css/main.css\" type=\"text/css\" rel=\"stylesheet\"/>\n";
        html += "\t\t<meta charset=\"utf-8\"/>\n";
        html += "\t</head>\n";
        html += "\t<body>\n";
        
        //inhalt
        html += "\t\t<div class=\"main\">\n";
        html += "\t\t\t<h1>Willkommen</h1>\n";
        html += "\t\t\t<h2>Hier findest du alle deine bisherigen Lösungen</h2>\n";
        html += "\t\t\t<table>\n";
        html += "\t\t\t\t<tr>\n";
        html += "\t\t\t\t\t<th>Kapitel 1</th>\n";
        html += "\t\t\t\t\t<th>Kapitel 2</th>\n";
        html += "\t\t\t\t\t<th>Kapitel 3</th>\n";
        html += "\t\t\t\t\t<th>Kapitel 4</th>\n";
        html += "\t\t\t\t\t<th>Kapitel 5</th>\n";
        html += "\t\t\t\t\t<th>Kapitel 6</th>\n";
        html += "\t\t\t\t</tr>\n";
        html += "\t\t\t\t<tr>\n";
        
        //Alle Hyperlinks!
        boolean[] progress = loadState();
        int ch;
        int lv;
        int max = 0;
        for (int i = 0; i < progress.length; i++) {
            int j = (int)((i/10) + 1);
            if (j != max) {
                max = j;
                if (max == 1) {
                    html += "\t\t\t\t\t<td class=\"hyper\">\n";
                    html += "\t\t\t\t\t\t<ul>\n";
                    
                }
                if (max == 2) {
                    html += "\t\t\t\t\t\t</ul>\n";
                    html += "\t\t\t\t\t</td>\n";
                    html += "\t\t\t\t\t<td class=\"hyper\">\n";
                    html += "\t\t\t\t\t\t<ul>\n";
                }
                if (max == 3) {
                    html += "\t\t\t\t\t\t</ul>\n";
                    html += "\t\t\t\t\t</td>\n";
                    html += "\t\t\t\t\t<td class=\"hyper\">\n";
                    html += "\t\t\t\t\t\t<ul>\n";
                }
                if (max == 4) {
                    html += "\t\t\t\t\t\t</ul>\n";
                    html += "\t\t\t\t\t</td>\n";
                    html += "\t\t\t\t\t<td class=\"hyper\">\n";
                    html += "\t\t\t\t\t\t<ul>\n";
                }
                if (max == 5) {
                    html += "\t\t\t\t\t\t</ul>\n";
                    html += "\t\t\t\t\t</td>\n";
                    html += "\t\t\t\t\t<td class=\"hyper\">\n";
                    html += "\t\t\t\t\t\t<ul>\n";
                }
                if (max == 6) {
                    html += "\t\t\t\t\t\t</ul>\n";
                    html += "\t\t\t\t\t</td>\n";
                    html += "\t\t\t\t\t<td class=\"hyper\">\n";
                    html += "\t\t\t\t\t\t<ul>\n";
                }
            }
            
            if (progress[i] == true) {
                //i = 0 --> C01L01
                //i = 5 --> C01L06
                //i = 12 --> C02L03
                ch = (int)(i/10)+1;
                lv = (i%10)+1;
                if (lv < 10) {
                    html += "\t\t\t\t\t\t\t<li><a href=\"solC0"+ch+"L0"+lv+".html\">Level 0"+lv+"</a></li>\n";
                } else {
                    html += "\t\t\t\t\t\t\t<li><a href=\"solC0"+ch+"L"+lv+".html\">Level "+lv+"</a></li>\n";
                }
                
                
            } 
        }
        html += "\t\t\t\t\t\t</ul>\n";
        html += "\t\t\t\t\t</td>\n";
        html += "\t\t\t\t</tr>\n";
        html += "\t\t\t<table>\n";
        
        html += "\t\t</div>\n";
        html += "\t</body>\n";
        html += "</html>\n";
        
       
        BufferedWriter out;
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
           
        }
        try {
            out = new BufferedWriter(new FileWriter("data/Lösungen/index.html"));
            out.write(html);
            out.close();
        } catch (IOException e) {
            
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
   
    public boolean[] searchForUsed(ArrayList<String> commands, ArrayList<ArrayList<String>> newCommands, int position, ArrayList<String> newCommandTitles, boolean[] universalUsed) {
        //Prüfe jede Zeile aus newCommand
        
        boolean[] used = new boolean[newCommandTitles.size()];
        
        for (int i = 0; i < used.length; i++) {
            used[i] = universalUsed[i];
        }
        
        
        for (int i = 1; i < newCommands.get(position).size(); i++) {
            String x = newCommands.get(position).get(i);
            x = x.replace(";","");

           
            //Wenn sie einen Befehl aus command hat, passiert nichts.
            int commandCount = 0;
            for (int j = 0; j < commands.size(); j++) {
                if (x.contains(commands.get(j))) {
                    
                    break;
                } else {
                    commandCount++;
                }
            }
            String newCommandTitle = "";
            if (commandCount == commands.size()) {
                //Wenn sie keinen Befehl aus command hat, so prüfe die Position in der newCommandTitles Liste
                for (int k = 0; k < newCommandTitles.size(); k++) {
                    newCommandTitle = newCommandTitles.get(k);
                    newCommandTitle = newCommandTitle.replace(" ","");
                    
                    if (x.contains(newCommandTitle) && used[k] == false) {
                        used[k] = true;
                    
                        used = searchForUsed(commands, newCommands, k,newCommandTitles, used);
                    }
                }
            }
            
            
            
        }
         
        
        return used;
    }
    

    public String createOutputCode(ArrayList<ArrayList<String>> newCommands, ArrayList<String> commands) {
        String txt = startHTML();
        int line = 1;   
        
        int loc = 0;
        
        String txtFirstTD = "";
        String txtSecondTD = "";
        
        int numberOfNewCommands = newCommands.size();
        
        boolean[] isUsed = new boolean[numberOfNewCommands];
        
        for (int i = 0; i < isUsed.length; i++) {
            isUsed[i] = false;
        }
        
        ArrayList<String> newCommandTitles = new ArrayList<String>();
        
        int positionOfCode = 0;
        
        for (int i = 0; i < newCommands.size(); i++) { //search for code();
            String x = newCommands.get(i).get(0);

            x = x.replace("public void", "");
            x = x.replace("public boolean", "");
            x = x.replace("{","");
            x = x.replace(" ","");
            x = " "+x;
            newCommandTitles.add(x);
           
            
            if (newCommands.get(i).get(0).contains("code()")) {
                positionOfCode = i;
                isUsed[i] = true;
            }
        }
        
        
        
        
        isUsed = this.searchForUsed(commands, newCommands,positionOfCode, newCommandTitles,isUsed);
        
        
        for (int i = 0; i < isUsed.length; i++) {
            
            if (isUsed[i] == true) {
                for (int j = 0; j < newCommands.get(i).size(); j++) {
                    String x = newCommands.get(i).get(j);
                    String t = new String(x);
                  
                       
                    t = t.replace("\t","");
                    t = t.replace("\n","");
                    t = t.replace(" ", "");
                       
                       
                    if (t.equals("")) {
                        
                    } else {
                            
                         //Old:txt += "Zeile " + line + " : " + x + "\n";
                         
                         //New for HTML
                         //x.replace \t\t\t durch <span class="thirdLevel"> und hinten dran hängen </span>
                         //Dann in css: .thirdLevel { margin-left: 3em; }
                         
                         txtFirstTD += "Zeile "+line+":<br>\n";
                         
                         if ((x.contains("//") || x.contains("/*") || x.contains("*") || x.contains("*/")) && !x.contains(";")){
               
                         } else {
                             
                             loc++;
                         }
                         
                         
                         if (x.contains("                                                ")) {
                             x = x.replace("                                                ", "<span class=\"twelthLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                                            ")) {
                             x = x.replace("                                            ", "<span class=\"eleventhLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                                        ")) {
                             x = x.replace("                                        ", "<span class=\"tenthLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                                    ")) {
                             x = x.replace("                                    ", "<span class=\"ninthLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                                ")) {
                             x = x.replace("                                ", "<span class=\"eigthLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                            ")) {
                             x = x.replace("                            ", "<span class=\"seventhLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                        ")) {
                             x = x.replace("                        ", "<span class=\"sixthLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                    ")) {
                             x = x.replace("                    ", "<span class=\"fifthLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("                ")) {
                             x = x.replace("                ", "<span class=\"fourthLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("            ")) {
                             x = x.replace("            ", "<span class=\"thirdLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("        ")) {
                             x = x.replace("        ", "<span class=\"secondLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else if (x.contains("    ")) {
                             x = x.replace("    ", "<span class=\"firstLevel\">");
                             txtSecondTD += x+"</span><br>\n";
                         } else {
                             txtSecondTD += "<span>"+x+"</span><br>\n";
                         }
                         


                         line++;
                    }
                       
                    
                    
                   
                }
                /*
                txt += "Zeile " + line + " : \n";
                line++;
                */
            }
        }
        
        
        //Read / Write LoC here
        CampaignLevel cl = this.getWorldOfType(CampaignLevel.class);
        
        this.updateLoC(cl.chapter, cl.level, loc); //Benötigt KAPITEL, LEVEL, LOC
        //
        
        txt += endHTML(txtFirstTD,txtSecondTD,loc);
        
        return txt;
        
        
        
        //Search Code for new Commands.
        
        //Search new Commands for new Commands.
        
        
        
    }
    
    public void updateLoC(int chapter, int level, int loc) {
        //Step 1: Read old LoC & Save in Array
        int[] locArr = new int[60];
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader("data/lines.txt"));
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                  locArr[i] = Integer.parseInt(x);
                  i++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        }
        
        
        //Step 2: Update the LoC-Array with new LoC
        //Chapter = 1 [0 - 9]
        //Level = 1
        //loc = 0
        locArr[((chapter-1)*10) + (level-1)] = loc;
        //chapter = 2 [10 - 19]
        //level = 4 
        //loc = 13
        
        //Step 3: Write in File
        
        BufferedWriter out;
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
            
        }
        try {
            out = new BufferedWriter(new FileWriter("data/lines.txt"));
            for (int k = 0; k < locArr.length; k++) {
                out.write(""+locArr[k]+"\n");
            }
            out.close();
        } catch (IOException e) {
            
        } 
    }

    public void outputCode() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("Spieler");
        commands.add(" run()");
        commands.add(" schritt()");
        commands.add(" linksDrehen()");
        commands.add(" rechtsDrehen()");
        commands.add(" aufheben()");
        commands.add(" schießen()");
        commands.add(" färben()");
        commands.add(" nehmen()");
        commands.add(" hinlegen()");
        commands.add(" merkeWert()");

        
        commands.add(" hatTinte()");
        commands.add(" istVorWand()");
        commands.add(" istZielscheibeInReichweite()");
        commands.add(" istAufTinte()");
        commands.add(" istAufToken()");
        commands.add(" istAufMarkierung()");
        commands.add(" siehtCheckpoint()");
        commands.add(" istVorKugel()");
        commands.add(" istVorPlattform()");
        commands.add(" siehtNachOsten()");
        commands.add(" siehtNachNorden()");
        commands.add(" siehtNachWesten()");
        commands.add(" siehtNachSüden()");
        commands.add(" istWert()");
        commands.add(" istWertKleiner()");
        commands.add(" istWertGroesser()");
    
       
        commands.add(" act()");
      
        /*
         * Idee: Mache es so wie jetzt und speichere alle neuen Methoden in Arrays.
         * newCommand[0] = zweiSchritt()\n...
         * newCommand[1] = umdrehen()\n...
         * 
         * und einen weiteren boolean Array, der speichert, ob eine Methode im Code verwendet wurde.
         * isUsed[0] = true
         * isUsed[1] = false
         * 
         * Dann werden nur die ausgegeben, die bereits als true gekennzeichnet wurden!
         */
        
        ArrayList<ArrayList<String>> newCommands = new ArrayList<ArrayList<String>>();
        
        int line = 0;
        String txt = "";
        try {
           BufferedReader in = new BufferedReader(new FileReader("Spieler.java"));
           
               

           boolean begin = false;
           int open = 0;
           int close = 0;
           int commandCount = 0;
           
           int newCommandCount = 0;
           ArrayList<String> newCommand = new ArrayList<String>();
           try {
               for (String x = in.readLine(); x != null; x = in.readLine()) {
                   
                   if (x.contains("public") && !x.contains("contains")) {
                       for (int i = 0; i < commands.size(); i++) {
                           if (!x.contains(commands.get(i))) {
                               commandCount++;
                               
                           }
                       }
                       if (commandCount == commands.size()) {
                           begin  = true; 
                       }
                       commandCount = 0;
                   } 
                   
                   
                   if (begin == true) {
                       if (x.contains("{")) {
                           open++;
                       } 
                       if (x.contains("}")) {
                           close++;
                       }
                       
                       
                       
                       newCommand.add(x);

                       if (open == close && open != 0) {
                           begin = false;
                           open = 0;
                           close = 0;
                           newCommands.add(newCommand);
                           newCommandCount++;
                           newCommand = new ArrayList<String>();
                           
                           
                       }
                   }
                   
                   
                
               }
           } catch(IOException e) {
               
           }
           
        } catch (FileNotFoundException e) {
            
        }
        try {
            CampaignLevel cl = this.getWorldOfType(CampaignLevel.class);
            BufferedWriter out;
            if (cl.level < 10) {

                File dir = new File("data/Lösungen");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
                
                
                //OLD: out = new BufferedWriter(new FileWriter("../Lösungen/Lösung-Chapter0"+cl.chapter+"-Level0"+cl.level+".txt"));
                //OLD: out.write("Lösung für Aufgabe: Chapter 0"+cl.chapter+" Level 0"+cl.level + "" + "\n \n");
                
                out = new BufferedWriter(new FileWriter("data/Lösungen/solC0"+cl.chapter+"L0"+cl.level+".html"));
            } else {
                File dir = new File("data/Lösungen");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
                //OLD: out = new BufferedWriter(new FileWriter("../Lösungen/Lösung-Chapter0"+cl.chapter+"-Level"+cl.level+".txt"));  
                //OLD: out.write("Lösung für Aufgabe: Chapter 0"+cl.chapter+" Level "+cl.level + "" + "\n \n");
                
                out = new BufferedWriter(new FileWriter("data/Lösungen/solC0"+cl.chapter+"L"+cl.level+".html"));
            }
            
            txt = this.createOutputCode(newCommands, commands);
            
            out.write(txt);

            out.close();
            
            //this.openHTML(); TEST
        
        } catch(IOException e) {
            
        } 
        //Step 4 - Rewrite it into new File();
        
        //Step 5 - Delete it?
    }
    
    public void rewrite() {
        String txt = "";
        try {
           BufferedReader in = new BufferedReader(new FileReader("Spieler.java"));    
           int line = 0;
           boolean begin = false;
           int open = 0;
           int close = 0;
           try {
               for (String x = in.readLine(); x != null; x = in.readLine()) {
                   
                   if (x.contains("code()") && !x.contains("contains") && !x.contains("txt")) {
                       begin = true;
                       
                   }
                   if (begin == true) {
                       
                       if (x.contains("{")) {
                           open++;
                       } 
                       if (x.contains("}")) {
                           close++;
                       }
                       if (open == close && open != 0) {
                           txt += ("\tpublic void code()\n");
                           txt += "\t{\n";
                           txt += "\t\n";
                           txt += "\t}\n";
                           begin = false;
                       }
                       
                   } else {
                       txt += (x + "\n");
                   }
                   
                
               }
           } catch(IOException e) {
               
           }
           
        } catch (FileNotFoundException e) {
            
        }
        try {
            
            BufferedWriter out = new BufferedWriter(new FileWriter("Spieler.java"));  
           
            out.write(txt);
            out.close();
            
        } catch(IOException e) {
            
        } 
        
             
    }
    
    static boolean isWindowsSystem() { 
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.indexOf("windows") >= 0;
    }
      
    static boolean isLinuxSystem() { 
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.indexOf("linux") >= 0;
    }
      
    static void printWindowsCommand(String command) throws Exception {
        File directory = new File(".");
        File[] flist = directory.listFiles();
        /*
        for (File file: flist) {
            System.out.println(file.getName());
        }
        */
        
        File html = new File("..\\Lösungen\\Lösung-Chapter01-Level01.html");
        
        /*
        System.out.println("Windows command: " + command);
        String line;
        */
        //Process process = Runtime.getRuntime().exec("cmd /c " + command);
        Process process = Runtime.getRuntime().exec("cmd /c " + html);
        
        /*
        Reader r = new InputStreamReader(process.getInputStream());
        BufferedReader in = new BufferedReader(r);
        while((line = in.readLine()) != null) 
            System.out.println(line);
        in.close();
        */
    }
    
    static void printMacCommand(String command) throws Exception {
        File directory = new File(".");
        File[] flist = directory.listFiles();
        /*
        for (File file: flist) {
            System.out.println(file.getName());
        }
        */
        
        File html = new File("../Lösungen/Lösung-Chapter01-Level01.html");
        
        /*
        System.out.println("Windows command: " + command);
        String line;
        */
        //Process process = Runtime.getRuntime().exec("cmd /c " + command);
        Process process = Runtime.getRuntime().exec("open /c " + html);
        
        /*
        Reader r = new InputStreamReader(process.getInputStream());
        BufferedReader in = new BufferedReader(r);
        while((line = in.readLine()) != null) 
            System.out.println(line);
        in.close();
        */
    }
      
    static void printLinuxCommand(String command) throws Exception { 
        System.out.println("Linux command: " + command);
        String line;
        
        Process process = Runtime.getRuntime().exec(command);
        Reader r = new InputStreamReader(process.getInputStream());
        BufferedReader in = new BufferedReader(r);
        while((line = in.readLine()) != null) 
            System.out.println(line);
        in.close();
    }
    
    public void openHTML() {
        if (isWindowsSystem()) { 
            
            try {
                printWindowsCommand("");
            } catch(Exception e) {
                
            }

        } else if (isLinuxSystem()) { 
            
            try {
                printLinuxCommand("ps -U hermann u");
            } catch(Exception e) {
                
            }
            
        } else { 
            try {
                printMacCommand("");
            } catch(Exception e) {
                
            }
            
            //System.exit(1);
        }
    }

    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.routine();        
        
    }    
    
    //HIER KOMMEN SPIELER-BEFEHLE
    
    public void run() {
        while(!orders.isEmpty()) {
            
            if (orders.get(0).equals("Schritt") && !this.hasError()) {
                this.moveForward();
                orders.remove(0);
                this.waitForNextOrder();
                
            } else if (orders.get(0).equals("LinksDrehen")  && !this.hasError()) {
                this.turnLeft();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("RechtsDrehen")  && !this.hasError()) {
                this.turnRight();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("Aufheben")  && !this.hasError()) {
                this.take();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("Schießen")  && !this.hasError()) {
                this.changeWeapon("Pistol");
                this.shoot();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("Färben")  && !this.hasError()) {
                this.changeWeapon("Grounder");
                this.shoot();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("Nehmen")  && !this.hasError()) {
                this.pickUp();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("Hinlegen")  && !this.hasError()) {
                this.putDown();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("MerkeWert") && !this.hasError()) {
                this.rememberValue();
                orders.remove(0);
                this.waitForNextOrder();
            } else if (orders.get(0).equals("Blase")) {
                
                this.bubbleUp();
                orders.remove(0);
                this.waitForNextOrder();
                
                
                
                
            } else if (this.hasError()) {
                
                orders.clear();
                break;
            } else {
                orders.remove(0);
            }
        }
    }
    
    public boolean checkForInfiniteLoops() {
        orderCount++;
        if (orderCount == 100000) {
            Greenfoot.ask("Endlosschleife ermittelt. Kahla wird neugestartet!");
            System.exit(1);
            return false;
        } else if (orderCount > 100000) {
            this.run();
            return false;
        } else if (orderCount%50 == 49) {
            this.run();
            return true;
        } else {
            return true;
        }
    }
    
    public void schritt() {
        if (checkForInfiniteLoops()) {
            this.orders.add("Schritt");
        }
    }
    
    public void linksDrehen() {
        if (checkForInfiniteLoops()) {
            this.orders.add("LinksDrehen");
        }
    }
    
    public void rechtsDrehen() {
        if (checkForInfiniteLoops()) {
            this.orders.add("RechtsDrehen");
        }
    }
    
    public void aufheben() {
 
        if (checkForInfiniteLoops()) {
            this.orders.add("Aufheben");
        }
    }
    
    public void schießen() {
        
        if (checkForInfiniteLoops()) {
            this.orders.add("Schießen");
        }
    }
    
    public void färben() {
     
        if (checkForInfiniteLoops()) {
            this.orders.add("Färben");
        }
    }
    
    public void nehmen() {
        
        //Vielleicht: kugelNehmen
        //kugelAufheben
        //hochheben
        
        if (checkForInfiniteLoops()) {
            this.orders.add("Nehmen");
        }
    }
    
    public void hinlegen() {
        
        if (checkForInfiniteLoops()) {
            this.orders.add("Hinlegen");
        }
    }
    
    public void merkeWert() {
        if (checkForInfiniteLoops()) {
            this.orders.add("MerkeWert");
        }
    }
    
    private void blase() {

        this.orders.add("Blase");
    }
    
    public boolean hatTinte() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.hasAmmo();
    }
    
    public boolean istVorWand() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.hasWallInFront();
    }
    
    public boolean istVorKugel() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.hasSphereInFront();
    }
    
    public boolean istVorPlattform() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.hasPlatformInFront();
    }
    
    public boolean istVorFarbe() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.hasColorInFront();
    }
    
    public boolean hatKugel() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.hasSphere;
    }
    
    public boolean siehtNachNorden() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        if (this.getDirection() == 'n') {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean siehtNachSüden() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        if (this.getDirection() == 's') {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean siehtNachWesten() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        if (this.getDirection() == 'w') {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean siehtNachOsten() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        if (this.getDirection() == 'e') {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean istZielscheibeInReichweite() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.isTarget();
    }
    
    public boolean istAufTinte() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.checkInkGround();
    }
    
    public boolean istAufToken() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.isItem();
    }
    
    public boolean istAufMarkierung() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.isOutline();                                                                                                            
    }
    
    public boolean siehtCheckpoint() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.isCheckpoint();
    }
    
    public boolean istWert() {
        if (this.hasError()) {
            return true;
        }
        this.hasChecked++;
        this.run();
        return this.isValue();
    }
    
    public boolean istWertKleiner() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.isValueSmaller();
    }
    
    public boolean istWertGroesser() {
        if (this.hasError()) {
            return true;
        }
        this.run();
        return this.isValueBigger();
    }
    
    public boolean immer() { //Nicht verwendet, allerdings noch möglich
        if (this.hasError()) {
            return false;
        }
        this.run();
        return true;
    }
    

}
