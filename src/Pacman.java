
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author denzyl
 */
public class Pacman extends SpelElement {

    public Pacman() {

        this.SPEED = 5;

        this.width = 50;
        this.height = 50;
    }

    public void stop() {
        this.running = false;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, width, height);
        graphics.setColor(Color.BLACK);
        graphics.fillOval((width / 2) + x, y + 10, 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.fillArc(x, y, width, height, width, height);
    }

    private void eetBolletje(Vakje vakje) {

        
        vakje.bolletjeVerwijderen();

    }
       public void startVakje(Vakje vakje) {
        this.vakje = vakje;
        
        
        this.vakje.setPacman(this);
        
        this.setY(vakje.getY());
        this.setX(vakje.getX());
        
    }

    protected void gaNaarVakje(Vakje vakje) {
        if (vakje.isBolletje()) {
            this.eetBolletje(vakje);
        }else if(vakje.isSpookje())
        {
            this.dood();
        }
        
        this.running = true;
        this.vakje = vakje;
        vakje.setPacman(this);
    }

    void dood() {
        this.x = 100000;
        this.y = -1000;
        
        //PACMAN IS DOOD
    }
    

}
