
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
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
    Menu menu;
    Boolean isAanHetLopen=true;
    long desiredFPS = 60;
    long desiredDeltaLoop = (1000 * 1000 * 1000) / desiredFPS;
    
    public void spelStarten(){
    new Thread(this).start();
    panel.setFocusable(true);
        
    }
    public void run() {
        System.out.println("hel");
        long beginLoopTime;
        long endLoopTime;
        long currentUpdateTime = System.nanoTime();
        long lastUpdateTime;
        long deltaLoop;

        while (isAanHetLopen) {
            beginLoopTime = System.nanoTime();

            render();

            lastUpdateTime = currentUpdateTime;
            currentUpdateTime = System.nanoTime();
            update((int) ((currentUpdateTime - lastUpdateTime) / (1000 * 1000)));

            endLoopTime = System.nanoTime();
            deltaLoop = endLoopTime - beginLoopTime;

            if (deltaLoop > desiredDeltaLoop) {
                //Do nothing. We are already late.
            } else {
                try {
                    Thread.sleep((desiredDeltaLoop - deltaLoop) / (1000 * 1000));
                } catch (InterruptedException e) {
                    //Do nothing
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
        pacman.draw(g);
    }

    
            

    public Game() {
      GridLayout layout = new GridLayout();
        menu = new Menu(this);
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        
       
        speelveld = new Speelveld();
        pacman = new Pacman();
        panel = new Panel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.add(canvas);

         KeyHandler kh = new KeyHandler();
        kh.setPacman(pacman);
        canvas.addKeyListener(kh);
        
        
        frame = new JFrame();
        frame.setTitle(title);
        layout.setColumns(1);
        layout.setRows(2);
        frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.setLayout(layout);
        frame.add(menu);
        frame.add(panel);
       // frame.setContentPane(menu);
       // frame.setContentPane(panel);
       
        frame.setVisible(true);
        frame.setResizable(true);
        
        frame.pack();

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();

        canvas.requestFocus();
    }

    public static void main(String[] args) {
        Game game = new Game();
      

    }

    class Panel extends JPanel {

     
    }
}
