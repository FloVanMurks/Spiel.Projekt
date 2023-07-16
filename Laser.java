import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The Projectile thrown at the enemie/ the player to destroy each other.
 * 
 * Tobias Grampp 
 * 0.1
 */
public class Laser extends GameCharacter
{
    boolean playerShooting;
    boolean isDead;
    boolean testshot;
    int movementSpeed;
    /**
     * The first two parameters are the position of the laser. The third
     * determines, who was shooting the laser. This is necessary because
     * a laser shot by the player mustn't hurt the player and a laser fired
     * by the Enemies mustn't hurt other enemies. The forth parameter tells
     * the programm, whether it may ever delete the Laser. Both Enemy and 
     * Player need the ability to create an undeletable laser, as seen in 
     * these classes. If the Enemy is shooting, the laser has to rotate in
     * order to have the graphics work.
     */
    public Laser(int posX, int posY, boolean PlayerShooting, boolean Testshot){
        super(posX, posY);
        setImage("laser 1.png");
        playerShooting = PlayerShooting;
        if(playerShooting == false){
            turn(180);
        }
        isDead = false;
        testshot = Testshot;
        movementSpeed = 5;
    }
    /**
     * Here, the laser will move up if it's fired by a player and down if it's
     * fired by an Enemy. If it touches the edge, it turns isDead true. It also 
     * does so, if it hit Enemy if it was sent by the player of if it hits the
     * player if it was sent by an Enemy. The hit Object will despawn.
     */
    public void act()
    {
        if(playerShooting){
            goUp(movementSpeed);
            isDead = isAtEdge();
            if(isTouching(Enemy.class)){
                removeTouching(Enemy.class);
                isDead = true;
                ((MyWorld)getWorld()).score ++;
                System.out.println("Score: " + ((MyWorld)getWorld()).score);
            }
        }
        else{
            goDown(movementSpeed);
            isDead = isAtEdge();
            if(isTouching(Player.class)){
                // removeTouching(Player.class);
                isDead = true;
                ((MyWorld)getWorld()).lifes --;
                System.out.println("Lifes: " +((MyWorld)getWorld()).lifes);
                ((MyWorld)getWorld()).playerShot();
            }
        }
        //If the laser has turned dead, it will now despawn itself from the world.
        if(isDead){
            ((MyWorld)getWorld()).removeObject(this);
        }
    }
    //In order to remove Lasers frome Enemy and Player Lists, the laser needs
    //to be able to tell other objects, whether it is dead.
    public boolean getIsDead(){
        return(isDead);
    }
}
