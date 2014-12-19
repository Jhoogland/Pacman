

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Game implements Runnable {

    private JFrame frame = new JFrame();
    private final String title = "PACMAN";
    public Speelveld speelveld;
    public Pacman pacman;
    public Panel panel;
    public final int WIDTH = 800;
    public final int HEIGHT = 800;
    Canvas canvas;
    BufferStrategy bufferStrategy;

    long desiredFPS = 60;
    long desiredDeltaLoop = (1000 * 1000 * 1000) / desiredFPS;

    public void run() {

        long beginLoopTime;
        long endLoopTime;
        long currentUpdateTime = System.nanoTime();
        long lastUpdateTime;
        long deltaLoop;

        while (Status.RUNNING.equals(Status.RUNNING)) {
            beginLoopTime = System.nanoTime();

            render();

            lastUpdateTime = currentUpdateTime;
            currentUpdateTime = System.nanoTime();
            update((int) ((currentUpdateTime - lastUpdateTime) / (1000 * 1000)));

            endLoopTime = System.nanoTime();
            deltaLoop = endLoopTime - beginLoopTime;

            if (deltaLoop > desiredDeltaLoop) {
                
                //Te laat
            } else {
                try {
                    Thread.sleep((desiredDeltaLoop - deltaLoop) / (1000 * 1000));
                } catch (InterruptedException e) {
                    //Niks doen
                }
            }
        }
    }

    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        render(g);
        g.dispose();
        bufferStrategy.show();
    }

    //TESTING
    private double x = 0;

    /**
     * Rewrite this method for your game
     */
    protected void update(int deltaTime) {
        pacman.update(deltaTime);
    }

    /**
     * Rewrite this method for your game
     */
    protected void render(Graphics2D g) {

        speelveld.draw(g);
        pacman.draw(g);
    }

    public enum Status {

        RUNNING, STOPPED, PAUSED
    }

    public void spelStarten() {
        new Thread(this).start();
        panel.setFocusable(true);

    }

    public Game() {

        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        speelveld = new Speelveld();
        pacman = new Pacman();
        speelveld.setPacman(pacman);

        panel = new Panel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.add(canvas);

        KeyHandler kh = new KeyHandler();
        kh.setSpeelveld(speelveld);
        canvas.addKeyListener(kh);

        frame = new JFrame();
        frame.setTitle(title);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();

        canvas.requestFocus();
    }

    public static void main(String[] args) {

        Game game = new Game();
    game.spelStarten();

    }

    class Panel extends JPanel {

        public Panel() {

        }
    }
}
