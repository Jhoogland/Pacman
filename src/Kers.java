
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denzyl
 */
public class Kers extends SpelElement {

    @Override
    public void tekenen(Graphics g) {
        try {
          g.drawImage(ImageIO.read(new File("kers.png")), x, y,width,height, null);
        } catch (IOException ex) {
            Logger.getLogger(Kers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
