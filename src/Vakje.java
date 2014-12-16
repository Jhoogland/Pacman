
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
   private final int HEIGH = 100;
   private int x,y;
   
   private SpelElement bevat;
   public Vakje(SpelElement spelelement,int x,int y)
   {
           this.bevat = spelelement;
           this.x = x;
           this.y = y;
       
   }
   
   public void draw(Graphics g)
   {
     this.bevat.draw(g);
     g.drawRect(x,y, WIDTH, WIDTH);
   }
   
    
}
