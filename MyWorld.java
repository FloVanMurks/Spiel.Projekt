import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MyWorld extends World {
    String status;
    int score;
    int lifes;
    int playerX = 360;
    int playerY = 526;
    //declaring, how many enemies there are
    int enemyAmount;
    
    // declaring of all buttons
    Button start = new Button("images/startButton.png", "mainMenu");
    Button newAccount = new Button("images/startButton.png", "newAccount");
    Button signIn = new Button("images/zurueckButton.png", "signIn");
    Button backToStart = new Button("images/zurueckButton.png", "mainMenu");
    Button startGame  = new Button("images/startGameButton.png", "startGame");
    Player player1 = new Player(playerX, playerY);
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
        int enemyAmount = 1;
    }
    
    public void refreshStatus(String status) {
        if (status == "started") {
            lifes = 5;
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
            addObject(player1, playerX, playerY);
        }
        else if (status == "gameOver") {
            System.out.println(status);
            removeObject(player1);
            // Remove all Enemies
            
            // show Score
        }
    }
    public void playerShot() {
        int X = player1.getX();
        int Y = player1.getY();
        removeObject(player1);
        player1 = new Player(X, Y);
        addObject(player1, X, Y);
    }
    public void addNewEnemieWave(){
        //here, the field is diverted into 4 rows with 7 squares each. Evers
        //square may have between 1 and 9 Enemies in it. How many there are
        //exactly is decided randomly.
        for(int u = 0; u < 4; u++){
            for(int i = 0; i < 7; i++){
                double d = Math.random();
                int x;
                if(d < 0.11111){
                    x = 1;
                }
                else if(d < 0.22222){
                    x = 2;
                }
                else if(d < 0.33333){
                    x = 3;
                }
                else if(d < 0.44444){
                    x = 4;
                }
                else if(d < 0.55555){
                    x = 5;
                }
                else if(d < 0.66666){
                    x = 6;
                }
                else if(d < 0.77777){
                    x = 7;
                }
                else if(d < 0.88888){
                    x = 8;
                }
                else{
                    x = 9;
                }
                newEnemies(x, 50 + i * 100, 50 + u*100);
                enemyAmount = enemyAmount + x;
            }
        }
    }
    public void newEnemies(int amount, int xPos, int yPos){
        //This method adds an Array of Enemies to one quadrant. It gets the
        //position of the middlepoint of the quadrant and the amount of
        //Enemies it needs to spawn. The Formations in which Enemies can 
        //randomly spawn are hardcoded to make them asthetically pleasing.
        Enemy[] Enemies;
        Enemies = new Enemy[amount];
        //this if checks, how many Enemies need to spawn.
        if(amount == 1){
            Enemies[0] = new Enemy(xPos, yPos);
            addObject(Enemies[0], xPos, yPos);
        }
        else if(amount == 2){
            Enemies[1] = new Enemy(xPos, yPos);
            addObject(Enemies[1], xPos, yPos);
            double d = Math.random();
            //this if tells, which of the different possible formations
            //has been randomly chosen.
            if(d < 0.142857){
                //a)
                Enemies[0] = new Enemy(xPos, yPos - 20);
                addObject(Enemies[0], xPos, yPos - 20);
            }
            else if(d < 0.285714){
                //b)
                Enemies[0] = new Enemy(xPos - 20, yPos + 20);
                addObject(Enemies[0], xPos - 20, yPos + 20);
            }
            else if(d < 0.428571){
                //c)
                Enemies[0] = new Enemy(xPos - 20, yPos - 20);
                addObject(Enemies[0], xPos - 20, yPos - 20);
            }
            else if(d < 0.571428){
                //d)
                Enemies[0] = new Enemy(xPos + 20, yPos - 20);
                addObject(Enemies[0], xPos + 20, yPos -20);
            }
             else if(d < 0.714285){
                //e)
                Enemies[0] = new Enemy(xPos + 20, yPos + 20);
                addObject(Enemies[0], xPos + 20, yPos +20);
            }
             else if(d < 0.857142){
                //f)
                Enemies[0] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos - 20, yPos);
            }
             else if(d < 2){
                //g)
                Enemies[0] = new Enemy(xPos + 20, yPos);
                addObject(Enemies[0], xPos + 20, yPos);
            }
        }
        //all the other parts of this function work the same.
        else if(amount == 3){
            double d = Math.random();
            Enemies[2] = new Enemy(xPos, yPos);
            addObject(Enemies[2], xPos, yPos);
            if(d < 0.142857){
                //a)
                Enemies[0] = new Enemy(xPos - 20, yPos - 20);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                addObject(Enemies[0], xPos - 20, yPos - 20);
                addObject(Enemies[1], xPos + 20, yPos - 20);
            }
            else if(d < 0.285714){
                //b)
                Enemies[0] = new Enemy(xPos + 20, yPos - 20);
                Enemies[1] = new Enemy(xPos - 20, yPos + 20);
                addObject(Enemies[0], xPos + 20, yPos - 20);
                addObject(Enemies[1], xPos - 20, yPos + 20);
            }
            else if(d < 0.428571){
                //c)
                Enemies[0] = new Enemy(xPos - 20, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos);
                addObject(Enemies[0], xPos - 20, yPos);
                addObject(Enemies[1], xPos + 20, yPos);
            }
            else if(d < 0.571428){
                //d)
                Enemies[0] = new Enemy(xPos, yPos - 20);
                Enemies[1] = new Enemy(xPos, yPos + 20);
                addObject(Enemies[0], xPos, yPos - 20);
                addObject(Enemies[1], xPos, yPos + 20);
            }
             else if(d < 0.714285){
                //e)
                Enemies[0] = new Enemy(xPos - 20, yPos + 20);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                addObject(Enemies[0], xPos - 20, yPos + 20);
                addObject(Enemies[1], xPos + 20, yPos + 20);
            }
             else if(d < 0.857142){
                //f)
                Enemies[0] = new Enemy(xPos - 20, yPos - 20);
                Enemies[1] = new Enemy(xPos + 20, yPos - 20);
                addObject(Enemies[0], xPos - 20, yPos - 20);
                addObject(Enemies[1], xPos + 20, yPos - 20);
            }
             else if(d < 2){
                //g)
                Enemies[0] = new Enemy(xPos - 20, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos);
                addObject(Enemies[0], xPos - 20, yPos);
                addObject(Enemies[1], xPos + 20, yPos);
            }
        }
        else if(amount == 4){
            double d = Math.random();
            if(d < 0.333333){
                //a)
                Enemies[0] = new Enemy(xPos - 10, yPos - 10);
                Enemies[1] = new Enemy(xPos + 10, yPos + 10);
                Enemies[2] = new Enemy(xPos - 10, yPos + 10);
                Enemies[3] = new Enemy(xPos + 10, yPos - 10);
                addObject(Enemies[0], xPos - 10, yPos - 10);
                addObject(Enemies[1], xPos + 10, yPos + 10);
                addObject(Enemies[2], xPos - 10, yPos + 10);
                addObject(Enemies[3], xPos + 10, yPos - 10);
            }
            else if(d < 0.666666){
                //b)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos, yPos + 20);
                Enemies[2] = new Enemy(xPos + 20, yPos + 20);
                Enemies[3] = new Enemy(xPos - 20, yPos + 20);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos, yPos + 20);
                addObject(Enemies[2], xPos + 20, yPos + 20);
                addObject(Enemies[3], xPos - 20, yPos + 20);
            }
            else if(d < 2){
                //c)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos, yPos - 20);
                Enemies[2] = new Enemy(xPos + 20, yPos);
                Enemies[3] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos, yPos - 20);
                addObject(Enemies[2], xPos + 20, yPos);
                addObject(Enemies[3], xPos - 20, yPos);
            }
        }
        else if(amount == 5){
            double d = Math.random();
            if(d < 0.2){
                //a)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos - 20);
                Enemies[4] = new Enemy(xPos - 20, yPos - 20);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos - 20);
                addObject(Enemies[4], xPos - 20, yPos - 20);
            }
            else if(d < 0.4){
                //b)
                Enemies[0] = new Enemy(xPos + 20, yPos);
                Enemies[1] = new Enemy(xPos - 20, yPos);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos, yPos + 20);
                Enemies[4] = new Enemy(xPos + 20, yPos + 20);
                addObject(Enemies[0], xPos + 20, yPos);
                addObject(Enemies[1], xPos - 20, yPos);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos, yPos + 20);
                addObject(Enemies[4], xPos + 20, yPos + 20);
            }
            else if(d < 0.6){
                //c)
                Enemies[0] = new Enemy(xPos + 20, yPos - 20);
                Enemies[1] = new Enemy(xPos - 20, yPos - 20);
                Enemies[2] = new Enemy(xPos - 20, yPos);
                Enemies[3] = new Enemy(xPos, yPos);
                Enemies[4] = new Enemy(xPos + 20, yPos);
                addObject(Enemies[0], xPos + 20, yPos - 20);
                addObject(Enemies[1], xPos - 20, yPos - 20);
                addObject(Enemies[2], xPos - 20, yPos);
                addObject(Enemies[3], xPos, yPos);
                addObject(Enemies[4], xPos + 20, yPos);
            }
            else if(d < 0.8){
                //d)
                Enemies[0] = new Enemy(xPos + 20, yPos);
                Enemies[1] = new Enemy(xPos - 20, yPos);
                Enemies[2] = new Enemy(xPos - 20, yPos - 20);
                Enemies[3] = new Enemy(xPos, yPos - 20);
                Enemies[4] = new Enemy(xPos + 20, yPos - 20);
                addObject(Enemies[0], xPos + 20, yPos);
                addObject(Enemies[1], xPos - 20, yPos);
                addObject(Enemies[2], xPos - 20, yPos - 20);
                addObject(Enemies[3], xPos, yPos - 20);
                addObject(Enemies[4], xPos + 20, yPos - 20);
            }
            else if(d < 2){
                //e)
                Enemies[0] = new Enemy(xPos + 20, yPos + 20);
                Enemies[1] = new Enemy(xPos - 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos);
                Enemies[3] = new Enemy(xPos, yPos);
                Enemies[4] = new Enemy(xPos + 20, yPos);
                addObject(Enemies[0], xPos + 20, yPos + 20);
                addObject(Enemies[1], xPos - 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos);
                addObject(Enemies[3], xPos, yPos);
                addObject(Enemies[4], xPos + 20, yPos);
            }
        }
            else if(amount == 6){
            double d = Math.random();
            if(d < 0.25){
                //a)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos, yPos + 20);
                Enemies[4] = new Enemy(xPos + 20, yPos);
                Enemies[5] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos,yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos, yPos + 20);
                addObject(Enemies[4], xPos + 20, yPos);
                addObject(Enemies[5], xPos - 20, yPos);
            }
            else if(d < 0.5){
                //b)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos - 20);
                Enemies[2] = new Enemy(xPos - 20, yPos - 20);
                Enemies[3] = new Enemy(xPos, yPos - 20);
                Enemies[4] = new Enemy(xPos + 20, yPos);
                Enemies[5] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos,yPos);
                addObject(Enemies[1], xPos + 20, yPos - 20);
                addObject(Enemies[2], xPos - 20, yPos - 20);
                addObject(Enemies[3], xPos, yPos - 20);
                addObject(Enemies[4], xPos + 20, yPos);
                addObject(Enemies[5], xPos - 20, yPos);
            }
            else if(d < 0.75){
                //c)
                Enemies[0] = new Enemy(xPos - 20, yPos);
                Enemies[1] = new Enemy(xPos - 20, yPos - 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos);
                Enemies[4] = new Enemy(xPos + 20, yPos - 20);
                Enemies[5] = new Enemy(xPos + 20, yPos + 20);
                addObject(Enemies[0], xPos - 20,yPos);
                addObject(Enemies[1], xPos - 20, yPos - 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos);
                addObject(Enemies[4], xPos + 20, yPos - 20);
                addObject(Enemies[5], xPos + 20, yPos + 20);
            }
            else if(d < 2){
                //d)
                Enemies[0] = new Enemy(xPos, yPos - 20);
                Enemies[1] = new Enemy(xPos - 20, yPos - 20);
                Enemies[2] = new Enemy(xPos + 20, yPos - 20);
                Enemies[3] = new Enemy(xPos, yPos + 20);
                Enemies[4] = new Enemy(xPos - 20, yPos + 20);
                Enemies[5] = new Enemy(xPos + 20, yPos + 20);
                addObject(Enemies[0], xPos, yPos - 20);
                addObject(Enemies[1], xPos - 20, yPos - 20);
                addObject(Enemies[2], xPos + 20, yPos - 20);
                addObject(Enemies[3], xPos, yPos + 20);
                addObject(Enemies[4], xPos - 20, yPos + 20);
                addObject(Enemies[5], xPos + 20, yPos + 20);
            }
        }
        else if(amount == 7){
            double d = Math.random();
            if(d < 0.5){
                //a)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos - 20);
                Enemies[4] = new Enemy(xPos - 20, yPos - 20);
                Enemies[5] = new Enemy(xPos, yPos - 20);
                Enemies[6] = new Enemy(xPos, yPos + 20);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos - 20);
                addObject(Enemies[4], xPos - 20, yPos - 20);
                addObject(Enemies[5], xPos, yPos - 20);
                addObject(Enemies[6], xPos, yPos + 20);
            }
            else if(d < 2){
                //b)
                Enemies[0] = new Enemy(xPos + 20, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos - 20);
                Enemies[4] = new Enemy(xPos - 20, yPos - 20);
                Enemies[5] = new Enemy(xPos - 20, yPos);
                Enemies[6] = new Enemy(xPos, yPos - 20);
                addObject(Enemies[0], xPos + 20, yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos - 20);
                addObject(Enemies[4], xPos - 20, yPos - 20);
                addObject(Enemies[5], xPos - 20, yPos);
                addObject(Enemies[6], xPos, yPos - 20);
            }
        }
        else if(amount == 8){
            double d = Math.random();
            if(d < 0.25){
                //a)
                Enemies[0] = new Enemy(xPos + 20, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos - 20);
                Enemies[4] = new Enemy(xPos - 20, yPos - 20);
                Enemies[5] = new Enemy(xPos, yPos - 20);
                Enemies[6] = new Enemy(xPos, yPos + 20);
                Enemies[7] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos + 20, yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos - 20);
                addObject(Enemies[4], xPos - 20, yPos - 20);
                addObject(Enemies[5], xPos, yPos - 20);
                addObject(Enemies[6], xPos, yPos + 20);
                addObject(Enemies[7], xPos - 20, yPos);
            }
            else if(d < 0.5){
                //b)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos - 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos);
                Enemies[4] = new Enemy(xPos - 20, yPos - 20);
                Enemies[5] = new Enemy(xPos, yPos - 20);
                Enemies[6] = new Enemy(xPos, yPos + 20);
                Enemies[7] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos + 20, yPos - 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos );
                addObject(Enemies[4], xPos - 20, yPos - 20);
                addObject(Enemies[5], xPos, yPos - 20);
                addObject(Enemies[6], xPos, yPos + 20);
                addObject(Enemies[7], xPos - 20, yPos);
            }
            else if(d < 0.75){
                //c)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos - 20);
                Enemies[3] = new Enemy(xPos + 20, yPos - 20);
                Enemies[4] = new Enemy(xPos + 20, yPos);
                Enemies[5] = new Enemy(xPos, yPos - 20);
                Enemies[6] = new Enemy(xPos, yPos + 20);
                Enemies[7] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos - 20);
                addObject(Enemies[3], xPos + 20, yPos - 20);
                addObject(Enemies[4], xPos + 20, yPos);
                addObject(Enemies[5], xPos, yPos - 20);
                addObject(Enemies[6], xPos, yPos + 20);
                addObject(Enemies[7], xPos - 20, yPos);
            }
            else if(d < 2){
                //d)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos - 20);
                Enemies[4] = new Enemy(xPos - 20, yPos - 20);
                Enemies[5] = new Enemy(xPos, yPos - 20);
                Enemies[6] = new Enemy(xPos + 20, yPos);
                Enemies[7] = new Enemy(xPos - 20, yPos);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos - 20);
                addObject(Enemies[4], xPos - 20, yPos - 20);
                addObject(Enemies[5], xPos, yPos - 20);
                addObject(Enemies[6], xPos + 20, yPos);
                addObject(Enemies[7], xPos - 20, yPos);
            }
        }
        else if(amount == 9){
                //a)
                Enemies[0] = new Enemy(xPos, yPos);
                Enemies[1] = new Enemy(xPos + 20, yPos + 20);
                Enemies[2] = new Enemy(xPos - 20, yPos + 20);
                Enemies[3] = new Enemy(xPos + 20, yPos - 20);
                Enemies[4] = new Enemy(xPos - 20, yPos - 20);
                Enemies[5] = new Enemy(xPos, yPos - 20);
                Enemies[6] = new Enemy(xPos, yPos + 20);
                Enemies[7] = new Enemy(xPos - 20, yPos);
                Enemies[8] = new Enemy(xPos + 20, yPos);
                addObject(Enemies[0], xPos, yPos);
                addObject(Enemies[1], xPos + 20, yPos + 20);
                addObject(Enemies[2], xPos - 20, yPos + 20);
                addObject(Enemies[3], xPos + 20, yPos - 20);
                addObject(Enemies[4], xPos - 20, yPos - 20);
                addObject(Enemies[5], xPos, yPos - 20);
                addObject(Enemies[6], xPos, yPos + 20);
                addObject(Enemies[7], xPos - 20, yPos);
                addObject(Enemies[8], xPos + 20, yPos);
        }
    }
}
