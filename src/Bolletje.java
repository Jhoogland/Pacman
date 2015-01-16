
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
    private int height = 25;
    private int width = 25;

    public void setWidth(int width) {
        this.width = width / 2;
    }

    public void setHeight(int height) {
        this.height = height /2;
    }

    public void setX(int x) {
        this.x = x + this.width /2;
    }

    public void setY(int y) {
        this.y = y + this.height /2;
    }
    public int getY()
    {
        return this.y;
    }
    public int getX()
    {
        return this.x;
        
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

}
