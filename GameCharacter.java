import greenfoot.*;
/**
 * Write a description of class GameCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameCharacter extends Actor{
    public GameCharacter(int posX, int posY){
        super();
        setLocation(posX, posY);
        turn(180);
    }
    //Bewegung nach der y-Achse
    public void goUp(int movesize){
        if(getX()>2){
            turn(90);
            move(movesize);
            turn(-90);
        }
    }
    public void goDown(int movesize){
        if(getX()<718){
            turn(-90);
            move(movesize);
            turn(90);
        }
    }
    //Bewegung nach der x-Achse
    public void goLeft(int movesize){
        if(getY() < 576){
            move(movesize);
        }
    }
    public void goRight(int movesize){
        if(getY() >1 ){
            turn(180);
            move(movesize);
            turn(180);
        }
    }
}
