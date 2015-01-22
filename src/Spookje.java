
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;
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
public class Spookje extends SpelElement {

    boolean first = true;

    public Spookje() {

        this.SNELHEID = 1;
        this.width = 50;
        this.height = 50;

    }

    public void tekenen(Graphics g) {
       
        try {
            g.drawImage(ImageIO.read(new File("spookje.gif")), x, y,width,height, null);
        } catch (IOException ex) {
            Logger.getLogger(Spookje.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public boolean isStop() {
        return lopend;
    }

    private Richting volgendeRichting() {
        Random rand = new Random();
        int random = rand.nextInt(5);
        if (random == 1) {
            return Richting.WEST;
        } else if (random == 2) {
            return Richting.SOUTH;
        } else if (random == 3) {
            return Richting.NORTH;

        } else if (random == 4) {
            return Richting.EAST;
        } else {
            return Richting.EAST;
        }

    }
    Richting randomRichting;

    public void randomBewegen() {

        if (first) {
            this.setX(this.vakje.getX());
            this.setY(this.vakje.getY());
            first = false;
        }

        if (this.getX() == this.vakje.getX() && this.vakje.getY() == this.getY()) {
            randomRichting = this.volgendeRichting();
            lopend = true;
            this.beweeg(randomRichting);
        }
        
       
       

    }
}
