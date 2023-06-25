import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemieys, the player will face during missions.
 * 
 * Tobias Grampp
 * 0.1
 */
public class Enemy extends GameCharacter
{
    public Enemy(){
        super();
        turn(-90);
    }
    public void act()
    {
        // Test für noch unklare Prgogrammteile
    }
    //Bewegung nach der x-Achse
    public void goUp(){
        if(getY() < 576){
            move(2);
        }
    }
    public void goDown(){
        if(getY() >1 ){
            turn(180);
            move(2);
            turn(180);
        }
    }
}
