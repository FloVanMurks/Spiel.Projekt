import greenfoot.*;
/**
 * Write a description of class GameCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameCharacter extends Actor{
    public GameCharacter(){
        super();
        turn(-90);
    }
    //Bewegung nach der x-Achse
    public void goRight(){
        if(getX()<2){
            turn(90);
            move(2);
            turn(-90);
        }
    }
    public void goLeft(){
        if(getX()>718){
            turn(-90);
            move(2);
            turn(90);
        }
    }
    //Bewegung nach der y-Achse
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
