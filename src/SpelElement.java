
import java.util.Collections;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *@author Denzyl
 *
 */
public abstract class SpelElement {
    
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int SNELHEID;
    protected boolean lopend = true;
    protected Vakje vakje;
    protected Speelveld speelveld;
    
    abstract public void tekenen(Graphics g);
    
    protected void gaNaarVakje(Vakje vakje) {
        
         if(this instanceof Bolletje == false )
        {
        if (this instanceof Spookje && vakje.isPacman()) {
           
           vakje.pacman.dood();
        }
   

         this.vakje = vakje;
  
        }
    }
    
    protected enum Richting {
        
        SOUTH, EAST, WEST, NORTH
    }
    
    private Richting richting;
    
    public void setSpeelVeld(Speelveld speelveld) {
        this.speelveld = speelveld;
    }
    
    void setY(int y) {
        this.y = y;
    }
    
    void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        
        return this.y;
    }
    
    
    protected void goSouth() {
        if (this.y < this.vakje.getY()) {
            y = y + this.SNELHEID;
        }
            
    }
    
    protected void goNorth() {
        if (this.y > this.vakje.getY()) {
            y = y - this.SNELHEID;
        }
    }
    
    protected void goWest() {
        if (this.x > this.vakje.getX()) {
            x = x - this.SNELHEID;
        }
    }
    
    protected void goEast() {
        if (this.x < this.vakje.getX()) {
            x = x + this.SNELHEID;
        }
    }
    
    public Vakje getVakje() {
        return this.vakje;
    }
    
    public void update() {
        
        if (lopend) {
            try {
                
                if (richting == Richting.EAST) {
                    this.goEast();
                } else if (richting == Richting.WEST) {
                    this.goWest();
                } else if (richting == Richting.NORTH) {
                    this.goNorth();
                } else if (richting == Richting.SOUTH) {
                    this.goSouth();
                }
                
            } catch (NullPointerException e) {
            }
            
        }
        
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void startVakje(Vakje vakje) {
        this.vakje = vakje;
        
        if(this instanceof Pacman)
        {
       
        this.vakje.setPacman((Pacman)this);
        }else if(this instanceof Spookje)                
                {
                 this.vakje.setSpookje((Spookje)this);
                }
        this.setY(vakje.getY());
        this.setX(vakje.getX());
        
    }

    /**
     * Geef sein dat spelelement moet gaan
     *
     * @param direction
     */
    public void beweeg(Richting richting) {
        //verbeteren naar een betere implementatie
        ArrayList<Vakje> path = this.speelveld.getPath(this.getVakje(), richting, this);
        this.path(path, richting);
    }

    /**
     * Mogellijke path vinden
     *
     * @param path
     * @param direction
     */
    private void path(ArrayList<Vakje> path, Richting direction) {
        this.richting = direction;
        if (path.size() > 0) {
            if (direction == Richting.WEST || direction == Richting.NORTH) {
                Collections.reverse(path);
            }
            /**
             * Zet dit in een for loop dan beweegt het spel smoother
             */
            
            Vakje vak = (Vakje) path.get(0);
            if (!vak.isMuur()) {
                this.gaNaarVakje(vak);
            } else {
                
            }
        }
    }
}
