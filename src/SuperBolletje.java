
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
public class SuperBolletje extends Bolletje{
    
    public void tekenen(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }

    
}
