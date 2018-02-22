import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StageOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_01 extends Stage
{

    /**
     * Constructor for objects of class StageOne.
     * 
     */
    public Level_01()
    {
        super(12,13,50);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,this.getRealX(2),this.getRealY(7));
        Player player2 = new Player();
        player2.setRotation(180);
        player2.changeControl();
        addObject(player2,this.getRealX(7),this.getRealY(7));

        Header header = new Header();
        addObject(header,0,0);
        header.setLocation(0,0);
        Wall vwall = new Wall("V");
        addObject(vwall,this.getRealX(5),this.getRealY(5));
      
    }
}
