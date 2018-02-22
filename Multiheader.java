import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

/**
 * Write a description of class Multiheader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Multiheader extends Header implements Serializable
{
    /**
     * Act - do whatever the Multiheader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int page = 1;
    int numberOfPages = 0;
    String[][] pages;
    
    private boolean firstAct = true;
    private int firstX = 60;
    private int secondX = 0;
    
    private int width;
    private int size;
    
    public PageButton forward;
    public PageButton backward;
    
    public StartButton start;
    
    public NextButton next;
    
    public BackButton back;
    
    public CommandButton commands;
    
    String winningMessage;
        
    public Multiheader() {
        
    }
    
    public Multiheader(int number) {
        this.numberOfPages = number;
        pages = new String[number][6];
    }
    

    
    public Multiheader(String[][] pages, Spieler[] a, String wm) {
        
        
        
        this.numberOfPages = pages.length;
        this.pages = pages;
        
        
        this.forward = new PageButton(this,">",true);
        this.backward = new PageButton(this,"<",false);
        
        
        
        this.forward.enable();
        this.backward.disable();
        
        this.start = new StartButton(a,this);
        //if (this.page == this.numberOfPages) { NUR Aktivieren, wenn Lösung für ständiges zurückgehen?
        this.start.enable();
        //}
        
        
        
        this.next = new NextButton();
        this.next.disable();
        
        this.winningMessage = wm;
       
        this.back = new BackButton();
        
        this.commands = new CommandButton();
        
        this.page = this.loadPage();
        this.checkButtons();
    }
    
    public void redraw() {
        //Redraw Everything!
        forward.redraw();
        backward.redraw();
    
        start.redraw();
    
        next.redraw();
    
        back.redraw();
    
        commands.redraw();
        
    }
    
    
    public void displayWinningMessage() {
        page = 1;
        numberOfPages = 1;
        String[] pageOne = new String[]{this.winningMessage};
        pages = new String[][]{pageOne};
        this.forward.disable();
        this.backward.disable();
    }
    
    public void checkButtons() {
        if (!this.forward.isEnabled()) {
            if (this.page < this.numberOfPages) {
                this.forward.enable();
            }
        } else {
            if (this.page == this.numberOfPages) {
                this.forward.disable();
                this.start.enable();
            }
        }
        
        
        if (!this.backward.isEnabled()) {
            if (this.page > 1) {
                this.backward.enable();
            }
        } else {
            if (this.page == 1) {
                this.backward.disable();
            }
        }
        
        this.savePage();
    }
    
    public void nextPage() {
        if (this.page + 1 <= this.numberOfPages) {
            this.page++;
        }
        
        
        this.checkButtons();
        
       
    }
    
    public void savePage() {
        try {
            
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualPage.txt"));  
            out.write(""+this.page);
            out.close();
            
        } catch(IOException e) {
            
        } 
    }
    
    public int loadPage() {
        try {
           BufferedReader in = new BufferedReader(new FileReader("data/actualPage.txt"));
           try {
               String i = in.readLine();
               int j;
               if (i != null) {
                   j = Integer.parseInt(i);
               } else {
                   j = 1;
               }


               return j;
               
           } catch(IOException e) {
               return 1;
           }

        } catch (FileNotFoundException e) {
            return 1;
        }
                
    }
    
    public void lastPage() {
        if (this.page - 1 >= 1) {
            this.page--;
        }
        this.checkButtons();
    }
    
    public void missionHeader() {
        GreenfootImage bg = new GreenfootImage((this.width+1)*this.size,4*this.size);
        this.setLocation(((width-1)*this.size)/2 ,100);
        bg.clear();
        bg.setColor(new Color(0,0,0,255));
        
        bg.setFont(new Font(24));

        for (int i = 0; i < this.pages[page-1].length; i++) {
            bg.drawString(pages[page-1][i], firstX, (i+1)*30);
        }
               
       
        
        
        this.setImage(bg);
    }
    
    public void act() 
    {
        if (this.firstAct == true) {
            Stage s = this.getWorldOfType(Stage.class);
            this.width = s.getWidth()/s.width;
            this.size = 50;
            
            

            s.addObject(forward,80,180);
            s.addObject(backward,30,180);
           
            s.addObject(start,(this.width*this.size)-80,180);
            
            s.addObject(next,200,180);
            
            s.addObject(back,(this.width*this.size)-30,20);
            s.addObject(commands,(this.width*this.size)-70,20);
            this.firstAct = false;
        } else {
            this.missionHeader();
        }
        
    }    
}
