import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MyWorld extends World {
    String status;
    int score;
    
    // declaring of all buttons
    Button start = new Button("images/startButton.png", "startButton");
    Button newAccount = new Button("images/startButton.png", "newAccount");
    Button signIn = new Button("images/zurueckButton.png", "signIn");
    // Button ;
    // Button ;
    // Button ;
    // Button ;
    // Button ;
    // Button ;
    // Button ;    
    public MyWorld() {
        super(720, 576, 1);
        System.out.println("**********************************************************");
        Greenfoot.setSpeed(45);
        refreshStatus("mainMenu");
    }
    
    public void refreshStatus(String status) {
        if (status == "mainMenu") {
            System.out.println("mainMenu");
            setBackground("images/backgroundImage.png");
            start = new Button("images/startButton.png", "startButton");
            addObject(start, 360, 288); // positions the start-button in the middle of the screen
            
            //testing buttons
            // Button start = new Button ("images/startButton.png", "startButton");
            // addObject(start, 100, 100);
            // Button leaderboard = new Button ("images/startButton.png", "leaderboard");
            // addObject(leaderboard, 200, 100);
            // Button newAccount = new Button ("images/startButton.png", "newAccount");
            // addObject(newAccount, 300, 100);
            // Button signIn = new Button ("images/startButton.png", "signIn");
            // addObject(signIn, 400, 100);
            // Button mainMenu = new Button ("images/startButton.png", "mainMenu");
            // addObject(mainMenu, 500, 100);
            // Button startGame = new Button ("images/startButton.png", "startGame");
            // addObject(startGame, 100, 200);
            // Button selectSpaceship = new Button ("images/startButton.png", "selectSpaceship");
            // addObject(selectSpaceship, 200, 200);
            // Button settings = new Button ("images/startButton.png", "settings");
            // addObject(settings, 300, 200);
            // Button inGameMenu = new Button ("images/startButton.png", "inGameMenu");
            // addObject(inGameMenu, 400, 200);
            // Button game = new Button ("images/startButton.png", "game");
            // addObject(game, 500, 200);
            // Button gameOver = new Button ("images/startButton.png", "gameOver");
            // addObject(gameOver, 100, 300);
        }
        else if (status == "signIn") {
            addObject(newAccount, 360, 323);
            addObject(signIn, 360, 253);
            removeObject(start);
        }
    }
}
