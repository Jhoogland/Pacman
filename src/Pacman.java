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
    private final int width = 100;
    private final int height = 100;
    private final int SPEED = 5;
    private boolean running = false;
    public enum Direction{SOUTH,EAST,NORTH,WEST};
    private int deltaTime;
    public void update(int deltaTime) {
        this.deltaTime = deltaTime;
       if(running)
       {
          
       }
     }
    private void goSouth(int deltaTime)
    {
      y = y+deltaTime;   
    }
    private void goNorth(int deltaTime)
    {
        y = y- deltaTime;
    }
    private void goWest(int deltaTime)
    {
        x =x -deltaTime;
    }
    private void goEast(int deltaTime)
    { 
        x = x + deltaTime;
    }
    public void stop()
    {
        this.running = false;
    }
            
   
    
    public void draw(Graphics graphics)
    {   
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, width, height);    
        graphics.setColor(Color.BLACK);
        graphics.fillOval((width/2)+x,y+10,20,20);
        graphics.setColor(Color.BLACK);
        graphics.fillArc(x, y, width, height, width, height);
    }
 
    void bewegen(Direction direction)
    {   running = true;
        
        switch(direction)
        {
         
            case SOUTH:
                this.goSouth(deltaTime);
                break;
            case EAST:
                
               this.goEast(deltaTime);
                break;
            case NORTH:
                this.goNorth(deltaTime);
                break;
            case WEST:
                this.goWest(deltaTime);
                break;
             
                
        }
                
        
    }
    
   
}