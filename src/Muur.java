
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
public class Muur extends SpelElement{

    private int x, y;
    private int width,height;
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y =y;
    }
    public void setWidth(int width)
    {
        this.width =width;
       
    }
    public void setHeight(int height)
    {
        this.height =height;
    }
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,width,height);
    }
}
