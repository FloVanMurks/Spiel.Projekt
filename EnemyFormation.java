/**
 * Write a description of class EnemyFormation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyFormation
{
    
    // instance variables - replace the example below with your own
    Enemy[] Enemies;
    /**
     * Constructor for objects of class EnemyFormation
     */
    public EnemyFormation(int amount, int xPos, int yPos)
    {
        Enemies = new Enemy[amount];
        if(amount == 1){
            Enemies[0] = new Enemy(xPos, yPos);
        }
        else if(amount == 2){
            Enemies[0] = new Enemy(xPos, yPos);
            double d = Math.random();
            if(d < 0.142857){
                //a)
                Enemies[1] = new Enemy(xPos, yPos - 10);
            }
            else if(d < 0.285714){
                //b)
                Enemies[1] = new Enemy(xPos - 10, yPos + 10);
            }
            else if(d < 0.428571){
                //c)
                Enemies[1] = new Enemy(xPos - 10, yPos - 10);
            }
            else if(d < 0.571428){
                //d)
                Enemies[1] = new Enemy(xPos + 10, yPos - 10);
            }
             else if(d < 0.714285){
                //e)
                Enemies[1] = new Enemy(xPos + 10, yPos + 10);
            }
             else if(d < 0.857142){
                //f)
                Enemies[1] = new Enemy(xPos - 10, yPos);
            }
             else if(d < 2){
                //g)
                Enemies[1] = new Enemy(xPos + 10, yPos);
            }
        }else if(amount == 2){
            Enemies[0] = new Enemy(xPos, yPos);
            double d = Math.random();
            if(d < 0.142857){
                //a)
                Enemies[1] = new Enemy(xPos - 10, yPos - 10);
                Enemies[2] = new Enemy(xPos + 10, yPos + 10);
            }
            else if(d < 0.285714){
                //b)
                Enemies[1] = new Enemy(xPos + 10, yPos - 10);
                Enemies[2] = new Enemy(xPos - 10, yPos + 10);
            }
            else if(d < 0.428571){
                //c)
                Enemies[1] = new Enemy(xPos - 10, yPos);
                Enemies[2] = new Enemy(xPos + 10, yPos);
            }
            else if(d < 0.571428){
                //d)
                Enemies[1] = new Enemy(xPos, yPos - 10);
                Enemies[2] = new Enemy(xPos, yPos + 10);
            }
             else if(d < 0.714285){
                //e)
                Enemies[1] = new Enemy(xPos - 10, yPos + 10);
                Enemies[2] = new Enemy(xPos + 10, yPos + 10);
            }
             else if(d < 0.857142){
                //f)
                Enemies[1] = new Enemy(xPos - 10, yPos - 10);
                Enemies[2] = new Enemy(xPos + 10, yPos - 10);
            }
             else if(d < 2){
                //g)
                Enemies[1] = new Enemy(xPos - 20, yPos);
                Enemies[2] = new Enemy(xPos + 20, yPos);
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
}
