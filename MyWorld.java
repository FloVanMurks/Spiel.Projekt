import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MyWorld extends World {
    int pixelsOverBottomEdge; // for set up the position of the player over the bottom edge
    public MyWorld() {
        super(720, 576, 1);
        pixelsOverBottomEdge = 50;
        // Create a new world with 720×576 cells with a cell size of 1x1 pixels.
        Greenfoot.setSpeed(45);
        this.setBackground("images/backgroundImage.png");
        Player player = new Player();
        addObject(player, 360, 576-pixelsOverBottomEdge); // places the player horizontally in the middle and vertically pixelsOverBottomEdge over the bottom edge
        player.setImage("images/playerImage.png");
    }
    
}
