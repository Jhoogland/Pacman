
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

   Pacman Pacman;

    public void setPacman(Pacman pacman) {
       this.Pacman  = pacman;

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {

            case 40:// SOUTH
             this.Pacman.beweeg(SpelElement.Richting.SOUTH);//Pacman. beweeg(South);
                break;
            case 38://NORTH
               this.Pacman.beweeg(SpelElement.Richting.NORTH);//
                break;
            case 39://EAST
                this.Pacman.beweeg(SpelElement.Richting.EAST);
                break;
            case 37://WEST
            this.Pacman.beweeg(SpelElement.Richting.WEST);
                break;
        }
    }

}
