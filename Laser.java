import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The Projectile thrown at the enemie/ the player to destroy each other
 * 
 * Tobias Grampp 
 * 0.1
 */
public class Laser extends GameCharacter
{
    boolean playerShooting;
    boolean isDead;
    boolean testshot;
    /**
     * Due to the laser having to spawn at the right korridinates, x and y are
     * necessary. I use a boolean to determin, whether the enemy or the player
     * is shooting a lasor.
     */
    public Laser(int posX, int posY, boolean PlayerShooting, boolean Testshot){
        super(posX, posY);
        playerShooting = PlayerShooting;
        isDead = false;
        testshot = Testshot;
    }
    /**
     * this is the part, where the Laser is moving towards an Object.
     */
    public void act()
    {
        boolean touched = false;
        if(playerShooting){
            if( touched = false){
                goUp(2);
                touched = isAtEdge();
                if(isTouching(Enemy.class)){
                    removeTouching(Enemy.class);
                    touched = true;
                }
            }
            else{
                if(testshot = false){
                    isDead = true;
                }
            }
        }
        else{
             if( touched != true){
                goDown(2);
                touched = isAtEdge();
                if(isTouching(Player.class)){
                    removeTouching(Player.class);
                    touched = true;
                }
            }
            else{
                if(testshot = false){
                    isDead = true;
                }
            }
        }
    }
    public boolean getIsDead(){
        return(isDead);
    }
}
