
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

    private final int WIDTH = 50;
    private final int HEIGHT =50;
    private int x, y;
    private Object bevat;

    public Vakje(Object spelelement) {

        this.bevat = spelelement;

    }

    public void draw(Graphics g) {

     if (this.bevat instanceof Muur) {
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
        }else if(this.bevat instanceof Bolletje)
        {
           
            Bolletje bolletje = (Bolletje)this.bevat;
            bolletje.setX(this.getX());
            bolletje.setY(this.getY());
            bolletje.setWidth(this.getWidth());
            bolletje.setHeight(this.getHeight());
            bolletje.draw(g);
            this.bevat = bolletje;
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
    public void setPacman(Pacman pacman)
    {
          
      this.bevat = pacman;       
    }
    
    public Boolean isSpookje()
    {
        return (this.bevat instanceof Spookje);
    }
    public boolean isMuur()
    {
        return (this.bevat instanceof Muur);
    }
    public boolean isBolletje()
    {
        return(this.bevat instanceof Bolletje);
    }

    Bolletje getBolletje() {
        
            return (Bolletje)this.bevat;
        
        
    }
    
    public void verwijdren()
    {
        this.bevat = null;
    }

    void setBevat(Object object) {
        this.bevat =  null;
    }
}
