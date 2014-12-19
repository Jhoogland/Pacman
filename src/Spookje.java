
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
public class Spookje extends SpelElement {
    private int x;
    private int y;
    private int height;
    private int width;
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    
  public void draw(Graphics g)
  {
      g.setColor(Color.MAGENTA);
      g.fillOval(x, y, width, height);
      
       g.setColor(Color.BLACK);
      g.fillOval(x+width/4, y+10, 10, 10);
       g.fillOval(x+width/2, y+10, 10, 10);       
  }
   
   
}
