
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denzyl
 */
public class Pacman{
    private int x = 10;
    private int y =  10;    
    private final int width = 50;
    private final int height = 50;
    private final int SPEED = 5;
    private enum direction{SOUTH,EAST,NORTH,WEST};
    
    public void draw(Graphics graphics)
    {   
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, width, height);      
       // graphics.fillOval((width/2)x,y,20,20);
    }
   
    private void move()
    {
        switch(direction.EAST)
        {
         
            case SOUTH:
                this.y = this.y - this.SPEED;
                break;
            case EAST:
                
                this.x = this.x + this.SPEED;
                break;
            case NORTH:
                this.y = this.y + this.SPEED;
                break;
            case WEST:
                this.x = this.x - this.SPEED;
                break;
             
                
        }
                
        
    }
    
   
}
