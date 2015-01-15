
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author denzyl
 */
public class Pacman {

    private int x = 10;
    private int y = 10;
    private final int width = 50;
    private final int height = 50;
    private final int SPEED = 5;
    private boolean running = true;
    private int score=0;
    private Font font;
    
    public enum Direction {

        SOUTH, EAST, NORTH, WEST
    };
    private Direction move;
    private int deltaTime;
    private Vakje goToVakje;
    

    public void update(int deltaTime) {
        this.deltaTime = deltaTime;
        if (running) {
            try {
                if (this.getX() < this.goToVakje.getX() && this.getY() == this.goToVakje.getY()) {
                    this.goEast();
                } else if (this.getY() > this.goToVakje.getY() && this.getX() == this.goToVakje.getX()) {
                    this.goNorth();
                } else if (this.getX() > this.goToVakje.getX() && this.getY() == this.goToVakje.getY()) {
                    this.goWest();
                } else if (this.getY() < this.goToVakje.getY() && this.getX() == this.goToVakje.getX()) {
                    this.goSouth();
                } else {
                    this.running = false;
                }

            } catch (NullPointerException e) {
            }
                    
        }

    }

    private void goSouth() {
        y = y + this.SPEED;
    }

    private void goNorth() {
        y = y - this.SPEED;
    }

    private void goWest() {
        x = x -this.SPEED;
    }

    private void goEast() {

        x = x + this.SPEED;

    }

    public void stop() {
        this.running = false;
    }
       
    public Vakje getVakje()
    {
        return this.goToVakje;
    }
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, width, height);
        graphics.setColor(Color.BLACK);
        graphics.fillOval((width / 2) + x, y + 10, 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.fillArc(x, y, width, height, width, height);
        
        Font myFont = new Font("Serif",font.BOLD,28);
        graphics.setColor(Color.lightGray);
        graphics.setFont(myFont);
        graphics.drawString("Score:"+ score, 30,500);
        
        
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

    public void pacmanStartVakje(Vakje vakje) {
        this.goToVakje = vakje;
        this.setY(vakje.getY());
        this.setX(vakje.getX());

    }
   private void eetBolletje(Vakje vakje)
   { 
       
       //       if(vakje.getBolletje().getY() < this.getY() + this.getY() + this.getWidth() && vakje.getX() == this.getX())
//       {
       vakje.getBolletje().verwijderen();
       vakje.setBevat(null);
       
       score +=10;
//       }
   }

   private void gaNaarVakje(Vakje vakje)
    {     System.out.println("============");
        if(vakje.isBolletje())
        {
            System.out.println(vakje.isBolletje());
           
            this.eetBolletje(vakje);
       
           
        }
        
        this.running = true;
        this.goToVakje = vakje;
    }
    public void path(ArrayList<Vakje> path,Direction direction)
    {
        switch(direction)
        {
            case WEST:
                Collections.reverse(path);
                for(Vakje vak : path)
                {
                   // System.out.println(vak.getX() + " "+vak.isMuur());
                   if(!vak.isMuur())
                   {
                       this.gaNaarVakje(vak);
                   }else{
                       break;
                   }
                }
               break;
            case EAST:
              
                for(Vakje vak : path)
                {
                    //System.out.println(vak.getX() + " "+vak.isMuur());
                   if(!vak.isMuur())
                   {
                       this.gaNaarVakje(vak);
                   }else{
                       break;
                   }
                }
            break;
            case NORTH:
                Collections.reverse(path);
                for(Vakje vak : path)
                {
                   if(!vak.isMuur())
                   {
                       this.gaNaarVakje(vak);
                   }else{
                       break;
                   }
                }
                break;
            case SOUTH:
                 for(Vakje vak : path)
                {
                   if(!vak.isMuur())
                   {
                       this.gaNaarVakje(vak);
                   }else{
                       break;
                   }
                }
              break;
        }
    }
     
    

}
