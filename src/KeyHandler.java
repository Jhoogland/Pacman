
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

    public setPacman(Pacman pacman) {
        this.pacman = pacman;

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("Hello world");
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        switch (ke.getKeyCode()) {

            case KeyEvent.VK_DOWN:
                this.pacman.bewegen(direction.SOUTH);
                break;
            case KeyEvent.VK_UP:
                this.pacman.bewegen(direction.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                this.pacman.bewegen(direction.EAST);
                break;
            case KeyEvent.VK_LEFT:
                this.pacman.bewegen(direction.WEST);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("Hello world");
    }

}
