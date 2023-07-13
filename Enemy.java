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
    List<Laser> lasers;
    int Xcord;
    int Ycord;
    Laser laser;
    public Enemy(int posX, int posY){
        super(posX, posY);
        Xcord=posX;
        Ycord=posY;
        lasers = new ArrayList<>();
        Laser laser = new Laser(100,100,true,true);
        lasers.add(laser);
    }
    public void act()
    {
        double d = Math.random();
        if(d<0.25){
            if(getY() - 1 > Ycord - 3){
                goUp(1);
            }
        }
        else if(d<0.50){
            if(getY() + 1 < Ycord + 2){
                goDown(1);
            }
        }
        else if(d<0.75){
            if(getX() + 1 < Xcord + 2){
                goRight(1);
            }
        }
        else{
            if(getX() - 1 > Xcord - 3){
                goLeft(1);
            }
        }
        if(lasers.size() > 0){
            for(int i = 0; i < lasers.size(); i++){
                Laser laser = lasers.get(i);
                if(laser.getIsDead()){
                    lasers.remove(i);
                }
            }
        }
    }
    //Methods only for testingreasons
    public int getXcord(){
        return Xcord;
    }
    public int getYcord(){
        return Ycord;
    }
    public void shoot(){
        if(Greenfoot.isKeyDown("Space")){
            Laser laser = new Laser(getX(), getY(), true, false);
            lasers.add(laser);
            ((MyWorld)getWorld()).addObject(laser,getX(), getY());
        }
    }
}
