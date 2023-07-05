import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The object, the player will control whilst playing the game.
 * 
 * Tobias Grampp 
 * 0.1
 */
public class Player extends GameCharacter
{
    /**
     * Act - do whatever the PLAYER wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player(){
        super();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("left")){
            goLeft(2);
        }
        else if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("right")){
            goRight(2);
        }
    }
    //Bewegung nach der x-Achse
}
