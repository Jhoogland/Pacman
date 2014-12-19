
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
class Vakje {

    private final int WIDTH = 100;
    private final int HEIGHT = 100;
    private int x, y;
    private Object bevat;

    public Vakje(Object spelelement) {

        this.bevat = spelelement;

    }

    public void draw(Graphics g) {

        if (this.bevat == null) {
            g.setColor(Color.RED);
            g.drawRect(x, y, WIDTH, HEIGHT);
        } else if (this.bevat instanceof Muur) {
            Muur muur = (Muur) this.bevat;
            muur.setX(this.x);
            muur.setY(this.y);
            muur.setWidth(this.WIDTH);
            muur.setHeight(this.HEIGHT);
            muur.draw(g);
        }else if(this.bevat instanceof Spookje)
        {
            Spookje spookje = (Spookje)this.bevat;
            spookje.setX(this.getX());
            spookje.setY(this.getY());
            spookje.setWidth(this.getWidth());
            spookje.setHeight(this.getHeight());
            spookje.draw(g);
        }
        
    }

    void setY(int y) {
        this.y = y;
    }

    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    int getWidth() {
        return this.WIDTH;
    }

    int getHeight() {
        return this.HEIGHT;
    }

    public boolean pacmanIsErop() {
        
    
          return (this.bevat instanceof Pacman);
       
    }

    public boolean isMuur()
    {
        return (this.bevat instanceof Muur);
    }
}
