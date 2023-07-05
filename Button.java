import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor {
    public Button(String image) {
        super();
        setImage(image);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println("test");

        }
    }
}