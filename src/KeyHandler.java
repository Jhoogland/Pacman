
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jhoog_000
 */
public class KeyHandler implements KeyListener {

   Speelveld speelveld;

    public void setSpeelveld(Speelveld speelveld) {
        this.speelveld = speelveld;

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {

            case 40:
             this.speelveld.gaSouth();
                break;
            case 38:
               this.speelveld.gaNorth();
                break;
            case 39:
                         this.speelveld.gaEast();
                break;
            case 37:
      this.speelveld.gaWest();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}
