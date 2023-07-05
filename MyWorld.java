import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MyWorld extends World {
    int pixelsOverBottomEdge; // for set up the position of the player over the bottom edge
    String status;
    int score;

    public MyWorld() {
        super(720, 576, 1);
        System.out.println("**********************************************************");
        pixelsOverBottomEdge = 50;
        // Create a new world with 720×576 cells with a cell size of 1x1 pixels.
        Greenfoot.setSpeed(45);
        // setBackground("images/backgroundImage1.png");
        refreshStatus("mainMenu");
        Greenfoot.start();
    }
    public void refreshStatus(String status) {
        if (status == "mainMenu") {
            System.out.println("mainMenu");
            setBackground("images/backgroundImage.png");
            Button start = new Button("images/startButton.png");
            addObject(start, 360, 288); // positions the start-button in the middle of the screen
        }
    }
}
