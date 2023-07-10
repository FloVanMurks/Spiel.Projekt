import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor {
    String function;
    public Button(String image, String name) {
        super();
        setImage(image);
        function = name; 
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this) && function == "startButton") {
            System.out.println("startButton");
            ((MyWorld)getWorld()).refreshStatus("signIn");
        }
        else if (Greenfoot.mouseClicked(this) && function == "leaderboard") {
            System.out.println("leaderboard");
        }
        else if (Greenfoot.mouseClicked(this) && function == "newAccount") {
            System.out.println("newAccount");
        }
        else if (Greenfoot.mouseClicked(this) && function == "signIn") {
            System.out.println("signIn");
        }
        else if (Greenfoot.mouseClicked(this) && function == "mainMenu") {
            System.out.println("mainMenu");
        }
        else if (Greenfoot.mouseClicked(this) && function == "startGame") {
            System.out.println("startGame");
        }
        else if (Greenfoot.mouseClicked(this) && function == "selectSpaceship") {
            System.out.println("selectSpaceship");
        }
        else if (Greenfoot.mouseClicked(this) && function == "settings") {
            System.out.println("settings");
        }
        else if (Greenfoot.mouseClicked(this) && function == "inGameMenu") {
            System.out.println("in-game-menu");
        }
        else if (Greenfoot.mouseClicked(this) && function == "game") {
            System.out.println("game");
        }
        else if (Greenfoot.mouseClicked(this) && function == "gameOver") {
            System.out.println("gameOver");
        }
    }
}