import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * The object, the player will control whilst playing the game.
 * 
 * Tobias Grampp 
 * 0.1
 */
public class Player extends GameCharacter
{
    /**
     * The player spawns a list of plasers. It also gets a cooldown.
     */
    List<Laser> lasers;
    int cooldown;
    public Player(int posX, int posY){
        //Just like in Enemy, there needs to be an invincible laser for the
        //the list to not be null.
        super(posX, posY);
        setImage("Raumshiff1.png");
        lasers = new ArrayList<>();
        Laser laser = new Laser(100,100,true,true);
        lasers.add(laser);
    }
    public void act()
    {
        //this cooldownlength says, how long the player needs to wait after
        //having shot in order to shoot again.
        //Currently the cooldown is at round about 0.25 seconds.
        int cooldownlength = 10;
        if(cooldown < cooldownlength){
            cooldown ++;
        }
        //This checks, wheter the player wishes to move. He may only move left
        //or right, but he can control movement both by numb.key and wasd.
        if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("left")){
            goLeft(2);//the Player is going 2 because after testing this
            //turned out to be a good amount of movement.
        }
        else if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("right")){
            goRight(2);
        }
        //Than the programm looks, whether the player wants to shoot. It does
        //that analogue to the enemy. He may but he may only do so, if the 
        //cooldown is over. It will than restart the cooldown.
        if(Greenfoot.isKeyDown("Space") && cooldown >= cooldownlength){
            Laser laser = new Laser(getX(), getY(), true, false);
            lasers.add(laser);
            ((MyWorld)getWorld()).addObject(laser,getX(), getY());
            cooldown = 0;
        }
        //this removes the lasers from the list just like in the Enemy.
        for(int i = 0; i < lasers.size(); i++){
            if(lasers.get(i).getIsDead()){
                    lasers.remove(i);
            }
        }
    }
}
