import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class Pagebutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextButton extends Button
{
    
    
    
    /**
     * Act - do whatever the Pagebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public NextButton() {
        super("Nächstes Level");
    }
    
    public void resetPage() {
        try {
            
            BufferedWriter out = new BufferedWriter(new FileWriter("data/actualPage.txt"));  
            out.write(""+1);
            out.close();
            
        } catch(IOException e) {
            
        } 
    }
    
    public void nextLevel() {
            
            int chapter = this.getWorldOfType(CampaignLevel.class).chapter;
            int level = this.getWorldOfType(CampaignLevel.class).level;
            
            resetPage();
            if (chapter == 1) {
                if (level == 1) {
                    Greenfoot.setWorld(new CampaignLevel(1,2,10,3,50));
                } else if (level == 2) {
                    Greenfoot.setWorld(new CampaignLevel(1,3,10,3,50));
                } else if (level == 3) {
                    Greenfoot.setWorld(new CampaignLevel(1,4,10,3,50));
                } else if (level == 4) {
                    Greenfoot.setWorld(new CampaignLevel(1,5,10,4,50));
                } else if (level == 5) {
                    Greenfoot.setWorld(new CampaignLevel(1,6,11,6,50));
                } else if (level == 6) {
                    Greenfoot.setWorld(new CampaignLevel(1,7,11,7,50));
                } else if (level == 7) {
                    Greenfoot.setWorld(new CampaignLevel(1,8,10,4,50));
                } else if (level == 8) {
                    Greenfoot.setWorld(new CampaignLevel(1,9,11,5,50));
                } else if (level == 9) {
                    Greenfoot.setWorld(new CampaignLevel(1,10,10,7,50));
                } else if (level == 10) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
                        out.write("");
                        out.close();
                        
                    } catch(IOException e) {
                        
                    } 
                    Greenfoot.setWorld(new Menu());
                }
            } else if (chapter == 2) {
                if (level == 1) {
                    Greenfoot.setWorld(new CampaignLevel(2,2,11,7,50));
                } else if (level == 2) {
                    Greenfoot.setWorld(new CampaignLevel(2,3,9,5,50));
                } else if (level == 3) {
                    Greenfoot.setWorld(new CampaignLevel(2,4,11,7,50));
                } else if (level == 4) {
                    Greenfoot.setWorld(new CampaignLevel(2,5,11,6,50));
                } else if (level == 5) {
                    Greenfoot.setWorld(new CampaignLevel(2,6,10,5,50));
                } else if (level == 6) {
                    Greenfoot.setWorld(new CampaignLevel(2,7,12,7,50));
                } else if (level == 7) {
                    Greenfoot.setWorld(new CampaignLevel(2,8,13,8,50));
                } else if (level == 8) {
                    Greenfoot.setWorld(new CampaignLevel(2,9,13,13,50));
                } else if (level == 9) {
                    Greenfoot.setWorld(new CampaignLevel(2,10,17,8,50));
                } else if (level == 10) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
                        out.write("");
                        out.close();
                        
                    } catch(IOException e) {
                        
                    } 
                    Greenfoot.setWorld(new Menu());
                }
            }  else if (chapter == 3) {
                if (level == 1) {
                    Greenfoot.setWorld(new CampaignLevel(3,2,10,5,50));
                } else if (level == 2) {
                    Greenfoot.setWorld(new CampaignLevel(3,3,11,5,50));
                } else if (level == 3) {
                    Greenfoot.setWorld(new CampaignLevel(3,4,11,5,50));
                } else if (level == 4) {
                    Greenfoot.setWorld(new CampaignLevel(3,5,9,5,50));
                } else if (level == 5) {
                    Greenfoot.setWorld(new CampaignLevel(3,6,11,8,50));
                } else if (level == 6) {
                    Greenfoot.setWorld(new CampaignLevel(3,7,9,5,50));
                } else if (level == 7) {
                    Greenfoot.setWorld(new CampaignLevel(3,8,13,7,50));
                } else if (level == 8) {
                    Greenfoot.setWorld(new CampaignLevel(3,9,11,7,50));
                } else if (level == 9) {
                    Greenfoot.setWorld(new CampaignLevel(3,10,11,5,50));
                } else if (level == 10) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
                        out.write("");
                        out.close();
                        
                    } catch(IOException e) {
                        
                    } 
                    Greenfoot.setWorld(new Menu());
                }

            }  else if (chapter == 4) {
                if (level == 1) {
                    Greenfoot.setWorld(new CampaignLevel(4,2,9,7,50));
                } else if (level == 2) {
                    Greenfoot.setWorld(new CampaignLevel(4,3,9,8,50));
                } else if (level == 3) {
                    Greenfoot.setWorld(new CampaignLevel(4,4,9,9,50));
                } else if (level == 4) {
                    Greenfoot.setWorld(new CampaignLevel(4,5,11,12,50));
                } else if (level == 5) {
                    Greenfoot.setWorld(new CampaignLevel(4,6,13,9,50));
                } else if (level == 6) {
                    Greenfoot.setWorld(new CampaignLevel(4,7,12,9,50));
                } else if (level == 7) {
                    Greenfoot.setWorld(new CampaignLevel(4,8,11,11,50));
                } else if (level == 8) {
                    Greenfoot.setWorld(new CampaignLevel(4,9,12,9,50));
                } else if (level == 9) {
                    Greenfoot.setWorld(new CampaignLevel(4,10,11,11,50));
                } else if (level == 10) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
                        out.write("");
                        out.close();
                        
                    } catch(IOException e) {
                        
                    } 
                    Greenfoot.setWorld(new Menu());
                }

            }  else if (chapter == 5) {
            if (level == 1) {
                Greenfoot.setWorld(new CampaignLevel(5,2,9,9,50));
            } else if (level == 2) {
                Greenfoot.setWorld(new CampaignLevel(5,3,9,9,50));
            } else if (level == 3) {
                Greenfoot.setWorld(new CampaignLevel(5,4,10,13,50));
            } else if (level == 4) {
                Greenfoot.setWorld(new CampaignLevel(5,5,11,10,50));
            } else if (level == 5) {
                Greenfoot.setWorld(new CampaignLevel(5,6,10,7,50));
            } else if (level == 6) {
                Greenfoot.setWorld(new CampaignLevel(5,7,9,11,50));
            } else if (level == 7) {
                Greenfoot.setWorld(new CampaignLevel(5,8,13,9,50));
            } else if (level == 8) {
                Greenfoot.setWorld(new CampaignLevel(5,9,13,13,50));
            } else if (level == 9) {
                Greenfoot.setWorld(new CampaignLevel(5,10,13,13,50));
            } else if (level == 10) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
                        out.write("");
                        out.close();
                        
                    } catch(IOException e) {
                        
                    } 
                    Greenfoot.setWorld(new Menu());
                }
            }   else if (chapter == 6) {
                if (level == 1) {
                    Greenfoot.setWorld(new CampaignLevel(6,2,13,7,50));
                } else if (level == 2) {
                    Greenfoot.setWorld(new CampaignLevel(6,3,13,11,50));
                } else if (level == 3) {
                    Greenfoot.setWorld(new CampaignLevel(6,4,13,11,50));
                } else if (level == 4) {
                    Greenfoot.setWorld(new CampaignLevel(6,5,15,11,50));
                } else if (level == 5) {
                    Greenfoot.setWorld(new CampaignLevel(6,6,15,11,50));
                } else if (level == 6) {
                    Greenfoot.setWorld(new CampaignLevel(6,7,12,7,50));
                } else if (level == 7) {
                    Greenfoot.setWorld(new CampaignLevel(6,8,12,7,50));
                } else if (level == 8) {
                    Greenfoot.setWorld(new CampaignLevel(6,9,13,7,50));
                } else if (level == 9) {
                    Greenfoot.setWorld(new CampaignLevel(6,10,13,7,50));
                } else if (level == 10) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("data/actualLevel.txt"));  
                        out.write("");
                        out.close();
                        
                    } catch(IOException e) {
                        
                    } 
                    Greenfoot.setWorld(new Menu());
                }
            }
            
            
            //Greenfoot.stop(); 
        
            //And so forth...
        }
    
    public void action() {
        if (Greenfoot.mouseClicked(this)) {
            this.nextLevel();
        }
    }
    
    public void act() 
    {
        if (this.isEnabled()) {
            this.action();
        }
    }    
}
