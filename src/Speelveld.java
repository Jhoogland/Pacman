
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

class Speelveld{
   private ArrayList vakken = new ArrayList<Vakje>();     
   public Pacman pacman;
   public Speelveld()
   {
       pacman = new Pacman();
   }
   public void draw(Graphics g)
   {  
      pacman.draw(g);
   }
}
