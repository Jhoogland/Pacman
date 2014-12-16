
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

    Pacman pacman;

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        

        switch (ke.getKeyCode()) {

            case 40:
                this.pacman.bewegen(Pacman.Direction.SOUTH);
                break;
            case 38:
                this.pacman.bewegen(Pacman.Direction.NORTH);
                break;
            case 39:
                this.pacman.bewegen(Pacman.Direction.EAST);
                break;
            case 37:
                this.pacman.bewegen(Pacman.Direction.WEST);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}
