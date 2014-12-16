<<<<<<< HEAD

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author denzyl
 */
public class Game extends JFrame{

    private JFrame frame = new JFrame();
    private final String title = "PACMAN";
    public Speelveld speelveld;

    public enum gamestate {

        RUNNING, STOPPED, PAUSED
    }
    Panel panel;
    public final int WIDTH = 800;
    public final int HEIGHT = 800;

    public Game() {
        speelveld = new Speelveld();
        panel = new Panel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame = new JFrame();
        frame.setTitle(title);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

    class Panel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
         
            speelveld.draw(g);
          //  panel.repaint();
        }
    }
}
=======

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author denzyl
 */
public class Game extends JFrame{

    private JFrame frame = new JFrame();
    private final String title = "PACMAN";
    public Speelveld speelveld;
    public SpelElement pacman;
    public enum gamestate {

        RUNNING, STOPPED, PAUSED
    }
    Panel panel;
    public final int WIDTH = 800;
    public final int HEIGHT = 800;

    public Game() {
        speelveld = new Speelveld();
        pacman = new Pacman();
        panel = new Panel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame = new JFrame();
        frame.setTitle(title);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) {
        Game game = new Game();
       
    }

    class Panel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillRect(30, 30, 20, 30);
            speelveld.draw(g);
          //  panel.repaint();
        }
        public Panel(){
            this.setFocusable(true);
            KeyHandler kh = new KeyHandler();
            kh.setPacman(pacman);
            this.addKeyListener(kh);
            System.out.println("ja");
    }
}
}
>>>>>>> 88e6dd04d208bf90056236e194da7458dc1454ef
