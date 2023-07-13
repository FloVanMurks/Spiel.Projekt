import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MyWorld extends World {
    String status;
    int score;
    
    // declaring of all buttons
    Button start = new Button("images/startButton.png", "mainMenu");
    Button newAccount = new Button("images/startButton.png", "newAccount");
    Button signIn = new Button("images/zurueckButton.png", "signIn");
    Button backToStart = new Button("images/zurueckButton.png", "mainMenu");
    Button startGame  = new Button("images/startGameButton.png", "startGame");
    // Player player1 = new Player(/*"images/playerImage"*/);
    // Button ;
    // Button ;
    // Button ;
    // Button ;
    // Button ;    
    public MyWorld() {
        super(720, 576, 1);
        System.out.println("**********************************************************");
        Greenfoot.setSpeed(45);
        Greenfoot.start();
        refreshStatus("started");
    }
    
    public void refreshStatus(String status) {
        if (status == "started") {
            System.out.println(status);
            setBackground("images/backgroundImage.png");
            addObject(start, 360, 288); // positions the start-button in the middle of the screen
        }
        else if (status == "mainMenu") {
            System.out.println(status);
            setBackground("images/backgroundImage.png");
            // addObject(backToStart, 360, 323);
            // addObject(startGame, 360, 253);
            addObject(startGame, 360, 288);
            removeObject(start);
        }
        else if (status == "inGame") {
            System.out.println(status);
            removeObject(startGame);
            removeObject(backToStart);
            // add Player, Enemies, ... 
            // addObject(player1, 360, 526);
        }
        else if (status == "gameOver") {
            System.out.println(status);
            // removeObject(player1)
            // Remove all Enemies
            // show Score
        }
    }
}
