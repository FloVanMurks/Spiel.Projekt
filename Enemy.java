import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * The enemieys, the player will face during missions.
 * 
 * Tobias Grampp
 * 0.1
 */
public class Enemy extends GameCharacter
{
    //Every Enemy has his Laser-List. Here the Laser, the Enemy has shot, are stored
    List<Laser> lasers;
    int Xcord;
    int Ycord;
    int movementArea;
    int movementSpeedInArea;
    int movementSpeedInAreaM;
    //There is one additional laser, to make sure the size of the array (which
    //sometimes needs to be checked) is never null.
    Laser laser;
    public Enemy(int posX, int posY){
        super(posX, posY);
        setImage("Gegnershiff1.png");
        Xcord=posX;
        Ycord=posY;
        lasers = new ArrayList<>();
        movementArea = 5; // speed within its cell
        movementSpeedInArea = 3; // the less the faster
        movementSpeedInAreaM = 0;
        //Here, the laser is put into the array, so that it is never null.
        //Since the last parameter is true, it can never despawn.
        laser = new Laser(100,100,true,true);
        lasers.add(laser);
        //The Enemy needs to turn for the graphic to work.
        // turn(180);
    }
    public void act()
    {
        //The Enemy will move randomly in one direction every act.
        //But it will only do so, if it is still relativelyclose to its
        //position assigned in the start. This will prevent Enemies from
        //crashing into other enemies.
        double d = Math.random();
        if (movementSpeedInAreaM == movementSpeedInArea) {
            if(d<0.25){
                if(getY() - 1 > Ycord - 3){
                    goUp(movementArea);
                }
            }
            else if(d<0.50){
                if(getY() + 1 < Ycord + 2){
                    goDown(movementArea);
                }
            }
            else if(d<0.75){
                if(getX() + 1 < Xcord + 2){
                    goRight(movementArea);
                }
            }
            else{
                if(getX() - 1 > Xcord - 3){
                    goLeft(movementArea);
                }
            }
            movementSpeedInAreaM = 0;
        }
        else {
            movementSpeedInAreaM ++;
        }
        //Lasers can delete themselves off the world, but to save performance,
        //they also get removed from the list, if they touched the end of the
        //screen or an Enemy
            for(int i = 0; i < lasers.size(); i++){
            if(lasers.get(i).getIsDead()){
                lasers.remove(i);
            }
        }
        //The Enemy will than shoot.
        shoot();
    }
    public void shoot(){
        //When getting the order shoot(), the Enemy has a chance of 0.1% of
        //shooting. Othervise the game would be unplayable.
        double d = Math.random();
        // System.out.println(d);
        if(d < 0.001){
            //If the Enemy decides to shoot, it will spawn a laser. It starts
            //at the Enemies exact position. Since the 3rd parameter is false,
            //it will not hurt Enemies. But it will despawn, since it has false
            //as its last parameter.
            Laser laser = new Laser(getX(), getY(), false, false);
            lasers.add(laser);
            ((MyWorld)getWorld()).addObject(laser,getX(), getY());
        }
    }
}
