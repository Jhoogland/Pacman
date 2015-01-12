
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
<<<<<<< HEAD
    private int height = 25;
    private int width = 25;

    public void setWidth(int width) {
        this.width = width / 3;
    }

    public void setHeight(int height) {
        this.height = height / 3;
    }

    public void setX(int x) {
        this.x = x + this.width / 3;
    }

    public void setY(int y) {
        this.y = y + this.height / 3;
=======
    private int height;
    private int width;
 
    public void setWidth(int width)
    {
        this.width = 25;
    }
    public void setHeight(int height)
    {
        this.height = 25;
    }
    public void setX(int x)
    {
        this.x = x+35;
>>>>>>> e4d907c4962ddf94f33489a433cc1044f42e77a6
    }
    public int getY()
    {
<<<<<<< HEAD
        return this.y;
=======
        this.y = y+35;
>>>>>>> e4d907c4962ddf94f33489a433cc1044f42e77a6
    }
    public int getX()
    {
        return this.x;
        
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    public void verwijderen() {
        this.height = 0;
        this.width = 0;
        this.x = -1000;
        this.y = -1000;
     }
}
