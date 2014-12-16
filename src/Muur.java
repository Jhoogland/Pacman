
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
public class Muur extends SpelElement{

    private int x, y;

    public Muur(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void draw(Graphics g) {
        g.drawRect(x, y, 100, 100);
    }
}
