
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhoog_000
 */
public class Bolletje extends SpelElement {
    private int x;
    private int y;
    private int height;
    private int width;
 
    public void setWidth(int width)
    {
        this.width = 50;
    }
    public void setHeight(int height)
    {
        this.height = 50;
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
       g.setColor(Color.WHITE);
       g.fillOval(x,y,width,height);
        
        
    }
}
