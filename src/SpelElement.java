
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
    protected int SPEED;
    protected boolean running = true;
    protected int stapjesGelopen =0;
    protected final int maxStapjes = 5;
    protected Vakje vakje;
    protected Speelveld speelveld;
    
    abstract public void draw(Graphics g);
    
    protected void gaNaarVakje(Vakje vakje) {
        
         if(this instanceof Bolletje == false )
        {
        if (this instanceof Spookje && vakje.pacmanIsErop()) {
           
           vakje.pacman.dood();
        }
   

         this.vakje = vakje;
  
        }
    }
    
    protected enum Direction {
        
        SOUTH, EAST, WEST, NORTH
    }
    
    private Direction direction;
    
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
            y = y + this.SPEED;
        }
            
    }
    
    protected void goNorth() {
        if (this.y > this.vakje.getY()) {
            y = y - this.SPEED;
        }
    }
    
    protected void goWest() {
        if (this.x > this.vakje.getX()) {
            x = x - this.SPEED;
        }
    }
    
    protected void goEast() {
        if (this.x < this.vakje.getX()) {
            x = x + this.SPEED;
        }
    }
    
    public Vakje getVakje() {
        return this.vakje;
    }
    
    public void update() {
        
        if (running) {
            try {
                
                if (direction == Direction.EAST) {
                    this.goEast();
                } else if (direction == Direction.WEST) {
                    this.goWest();
                } else if (direction == Direction.NORTH) {
                    this.goNorth();
                } else if (direction == Direction.SOUTH) {
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
    public void beweeg(Direction direction) {
        
        ArrayList<Vakje> path = this.speelveld.getPath(this.getVakje(), direction, this);
        this.path(path, direction);
    }

    /**
     * Mogellijke path vinden
     *
     * @param path
     * @param direction
     */
    private void path(ArrayList<Vakje> path, Direction direction) {
        this.direction = direction;
        if (path.size() > 0) {
            if (direction == Direction.WEST || direction == Direction.NORTH) {
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
