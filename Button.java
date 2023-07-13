
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor {
    String function;
    public Button(String image, String name) {
        super();
        setImage(image);
        function = name; 
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this) && function == "leaderboard") {}
        else if (Greenfoot.mouseClicked(this) && function == "newAccount") {}
        else if (Greenfoot.mouseClicked(this) && function == "signIn") {}
        else if (Greenfoot.mouseClicked(this) && function == "mainMenu") {
            ((MyWorld)getWorld()).refreshStatus("mainMenu");
        }
        else if (Greenfoot.mouseClicked(this) && function == "startGame") {
            // System.out.println("startGame");
            ((MyWorld)getWorld()).refreshStatus("inGame");
        }
        else if (Greenfoot.mouseClicked(this) && function == "selectSpaceship") {}
        else if (Greenfoot.mouseClicked(this) && function == "settings") {}
        else if (Greenfoot.mouseClicked(this) && function == "inGameMenu") {}
        else if (Greenfoot.mouseClicked(this) && function == "game") {}
        else if (Greenfoot.mouseClicked(this) && function == "gameOver") {
            ((MyWorld)getWorld()).refreshStatus("gameOver");
        }
        else if (Greenfoot.mouseClicked(this) && function == "chooseSpaceShipInGame") {}
    }
}