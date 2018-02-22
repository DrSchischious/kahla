import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Defines the basic structure of every Stage in the game.
 * Uses a 50x50 pixel-based stage.
 * 
 * @author Daniel Schisch
 * @version 0.9
 */
public class Stage extends World
{
    Color[][] field;
    public ArrayList<Color> colors;
    public ArrayList<Player> players;
    
    private boolean isFinished = false;
    int width;
    
    public ArrayList<Checkpoint> checkpoints;
    public ArrayList<Target> targets;
    public ArrayList<Item> items;
    public ArrayList<Outline> outlines;
    public ArrayList<Platform> platforms;
    public ArrayList<Sphere> spheres;
    
    private int maxChecks = -1;
    
    
    public int gameTime = 0;
    public final int END_TIME = 5000;
    
    
    /**
     * Constructor for objects of class Stage.
     * It draws a Stage, according to the number of Cells and their CellSize
     */ 
    public Stage(int horizontalCells, int verticalCells, int width)
    {    
        super(horizontalCells*width, (verticalCells+4)*width, 1);
        this.width = width;
        this.drawStage(horizontalCells, verticalCells, width);
        colors = new ArrayList<Color>();
        players = new ArrayList<Player>();
        checkpoints = new ArrayList<Checkpoint>();
        targets = new ArrayList<Target>();
        items = new ArrayList<Item>();
        outlines = new ArrayList<Outline>();
        platforms = new ArrayList<Platform>();
        spheres = new ArrayList<Sphere>();
    }
    
    /**
     * Standard-Constructor for object of class Stage.
     * It draws a Stage with 10x10 cells with a cell size of 50x50 pixels.
     * 
     */
    public Stage() {
        super(10,14,50);
        this.width = 50;
        colors = new ArrayList<Color>();
        players = new ArrayList<Player>();
        
        checkpoints = new ArrayList<Checkpoint>();
        targets = new ArrayList<Target>();
        items = new ArrayList<Item>();
        outlines = new ArrayList<Outline>();
        platforms = new ArrayList<Platform>();
        spheres = new ArrayList<Sphere>();
    }

    /**
     * Will draw the grid-based stage.
     * Input: int, int, int
     */
    public void drawStage(int horizontalCells, int verticalCells, int size)
    {
        GreenfootImage bg = new GreenfootImage(horizontalCells*size,verticalCells*size+200);
        bg.setColor(new Color(255,255,255,255));
        bg.fill();
        bg.setColor(new Color(0,0,0,255));

        for (int i = 0; i < horizontalCells; i++) {
            for (int j = 0; j < verticalCells; j++) {
                bg.drawRect(i*size,j*size+200,size,size);
            }
        }

        this.setBackground(bg);
        this.setPaintOrder(Player.class, Stage.class);
        
        this.setPaintOrder(Player.class, Wall.class);
        this.setPaintOrder(Spieler.class, Wall.class);
        this.setPaintOrder(Player.class, Outline.class);
        this.setPaintOrder(Player.class, Item.class);
        this.setPaintOrder(Player.class, Target.class);
        this.setPaintOrder(Player.class, Checkpoint.class);
        this.setPaintOrder(Button.class,Header.class);
        this.fillField();
        //this.header = new GreenfootImage(500,150);
        //this.drawHeader();
    }
    
    /**
     * Paints one cell with a given color.
     * Input: Color, int, int
     */
    public void paintCell(Color c, int x, int y) {
        int size = this.width;
        int stageWidth = this.getWidth()/this.width;
        int stageHeight = this.getHeight()/this.width;
        
        GreenfootImage bg = this.getBackground();
        bg.setColor(c);
        if (x >= stageWidth || x < 0 || y >= stageHeight || y < 4) {
            //Errorcase
        } else {
            bg.fillRect(x*size+2, y*size+2, size-2, size-2);
            field[x][y] = c;
        }
        
    }
    
    /**
     * Will initialize the field in white
     */
    public void fillField() {
        this.field = new Color[this.getWidth()/this.width][this.getHeight()/this.width];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Color(255,255,255,255);
            }
        }
    }
    
    /**
     * Counts the number of colored cells in a given color.
     * Input: Color
     * Output: int
     */
    public int countColor(Color c) {
        int count = 0;
         for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == c) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /**
     * Returns if an given field has a Wall on it.
     */
    public boolean isWall(int x, int y) {
        List<Wall> w = this.getObjectsAt(this.getRealX(x), this.getRealY(y), Wall.class);
        if (!w.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public boolean isSphere(int x, int y) {
        List<Sphere> s = this.getObjectsAt(this.getRealX(x), this.getRealY(y), Sphere.class);
        if (!s.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public boolean isPlatform(int x, int y) {
        List<Platform> p = this.getObjectsAt(this.getRealX(x), this.getRealY(y), Platform.class);
        if (!p.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public boolean isColor(int x, int y) {
        Color c = field[x][y];
        if ((c.getRed() == 255) && (c.getGreen() == 255) && (c.getBlue() == 255)) {
            return false;
        }
        return true;
    }
    
    /**
     * Will evaluate the field for a winner.
     * Counts every colored field of both players.
     */
    public void evaluateWinner() {
        int[] count = new int[players.size()];
        for (int i = 0; i < count.length; i++) {
            Player pl = players.get(i);
            count[i] = countColor(new Color(pl.inkColor_r,pl.inkColor_g,pl.inkColor_b,pl.inkColor_a));
        }
        
        int place = 0;
        int maxPoints = 0;
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxPoints) {
                place = i+1;
                maxPoints = count[i];
            }
        }
        System.out.println("Player " + place + " won with " + maxPoints + " points.");
    }
      
    /**
     * Support-Method for transforming an x-coordinate to cell-size-coordinates
     */
    public int getRealX(int x) {
        return 25 + x*this.width;
    }
    
    /**
     * Support-Method for transforming an y-coordinate to cell-size-coordinates
     */
    public int getRealY(int y) {
        return 25 + y*this.width;
    }
    
    /**
     * Sets the Stage "as finished".
     */
    public void finish() {
        this.isFinished = true;
        
    }
    
    /**
     * Returns if the Stage is finished.
     */
    public boolean isFinished() {
        return this.isFinished;
    }
    
    /**
     * Defines the ending conditions for a level.
     * In this game the level is finished, when all the checkpoints, targets, items and outlines were solved.
     */
    
    public boolean endingConditions() {
            //Prüfe ob alle Spheres in den zugehörigen Plattformen sind.
         if (this.checkpoints.size() == 0 && this.targets.size() == 0 && this.items.size() == 0 && this.outlines.size() == 0 && this.checkForCorrectSpheres() && this.checkForCorrectChecksForEveryone()) {
             return true;
         }
         
         return false;
         
    }
    
    public boolean checkForCorrectChecks(Player p) {
        if (this.maxChecks == -1) { //Kein Maximum gesetzt
            return true;
        } else {
            if (p.hasChecked > this.maxChecks) {
                //You lose
                return false;
            } else {
                return true;
            }
        }

    }
    public boolean checkForCorrectChecksForEveryone() {
        for (Player p : players) {
            if (!checkForCorrectChecks(p)) {
                return false;
            }
        }
        return true;
    }
    
    public void setMaximumChecks(int max) {
        this.maxChecks = max;
    }
    
    public boolean checkForCorrectSpheres() {
        for (Platform p : platforms) {
            if (!p.hasSphere) {
                return false;
            } else {
                if (!p.isCorrectSphere()) {
                    return false;
                }
            }
            
        }
        return true;
    }
    
    /**
     * Returns if the ending conditions are met.
     */
    public boolean checkForEndingConditions() {
        if (this.endingConditions()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a checkpoint from the Stage and checks, if the stage is finished.
     */
    public void check(Checkpoint cp) {
        cp.check();
        this.checkpoints.remove(cp);
        this.removeObject(cp);
        
        if (this.checkForEndingConditions()) {
            this.finish();
        }
    }

    /**
     * Removes a target from the Stage and checks, if the stage is finished.
     */
    public void hitTarget(Target t) {
        t.hit();
        this.targets.remove(t);
        this.removeObject(t);
        
        
        if (this.checkForEndingConditions()) {
            this.finish();
        }
    }
    
    
    /**
     * Removes a item from the Stage and checks, if the stage is finished.
     */
    public void takeItem(Item i) {
        i.take();
        this.items.remove(i);
        this.removeObject(i);
        
        if (this.checkForEndingConditions()) {
            this.finish();
        }
    }
    
    public void pickUpSphere(Sphere sp) {
        sp.pickUp();
        this.removeObject(sp);
    }
    
    public void putDownSphere(Sphere sp, int x, int y) {
        //TODO: Check for Platform: else put down.
        
        this.addObject(sp, this.getRealX(x), this.getRealY(y));
        
    }
    
    /**
     * Removes a outline from the Stage and checks, if the stage is finished.
     */
    public void fillOutline(Outline o) {
        if (o.isFilled == false) {
            o.fill();
            this.outlines.remove(o);

            if (this.checkForEndingConditions()) {
                this.finish();
            }
        }
        
    }
    
    
    /**
     * Standardroutine, that is called every act in the runtime.
     */
    public void routine() {
        if (this.isFinished()) {
            List<Header> h = this.getObjects(Header.class);
            if (h.size() != 0) {
                h.get(0).setText(new String[]{"Winner"});
            }
        } else {
           
            //Normal Game Routine
            this.gameTime++;
            if (this.gameTime == this.END_TIME) {
                this.evaluateWinner();
                this.stopped();
            }
        }

    }
    
    public void act() {
        //this.routine();
    }
}
