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
    public Player(int posX, int posY){
        super(posX, posY);
        setImage("images/Raumshiff1.png");
        this.setRotation(0);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("left")){
            goLeft(2);
        }
        else if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("right")){
            goRight(2);
        }
        if (((MyWorld)getWorld()).lifes == 0) {
            ((MyWorld)getWorld()).refreshStatus("gameOver");
        }
        if (isTouching(Laser.class)) {
            ((MyWorld)getWorld()).lifes --;
            System.out.println("Lifes: " + ((MyWorld)getWorld()).lifes);
            ((MyWorld)getWorld()).returnPlayer();
        }
    }
    //Bewegung nach der x-Achse
}
