import greenfoot.*;
/**
 * The superclass of Enemies, lasers and the player. Here, some methods needed
 * everywhere are defined.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameCharacter extends Actor{
    //constructor, wherein x-Position and y-Position are demanded, so that it's
    //location is set there.
    public GameCharacter(int posX, int posY){
        super();
        setLocation(posX, posY);
    }
    //Movement is getting checked, whether the moving object would go out of the picture. Movement will only commence, if this isn't the case.
    //Movement on the y-Axis
    public void goUp(int movesize){
        if(getX()>movesize){
            setLocation(getX(), getY() - movesize);
        }
    }
    public void goDown(int movesize){
        if(getX()<720 - movesize){
            setLocation(getX(), getY() + movesize);
        }
    }
    //Movement on the x-Axis
    public void goLeft(int movesize){
        if(getY() < 578 - movesize){
            setLocation(getX() - movesize, getY());
        }
    }
    public void goRight(int movesize){
        if(getY() > movesize ){
            setLocation(getX() + movesize, getY());
        }
    }
}
