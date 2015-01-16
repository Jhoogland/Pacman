
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

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
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.fillOval(x + width / 4, y + 10, 10, 10);
        g.fillOval(x + width / 2, y + 10, 10, 10);
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
