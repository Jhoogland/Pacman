
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    static boolean Status = true;
    public int aantalGegetenBolletjes;
    public int aantalBolletjes;
    Canvas canvas;
    BufferStrategy bufferStrategy;
    public List<Spookje> spoken = new ArrayList<Spookje>();

    long desiredFPS = 60;
    long desiredDeltaLoop = (1000 * 1000 * 1000) / desiredFPS;

    public void run() {

        long beginLoopTime;
        long endLoopTime;
        long currentUpdateTime = System.nanoTime();
        long lastUpdateTime;
        long deltaLoop;

        while (Status) {
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

 

    /**
     * Elementen bewegen
     */
    protected void update(int deltaTime) {
        pacman.update();
        for (Iterator it = spoken.iterator(); it.hasNext();) {
            Spookje spook = (Spookje) it.next();
            spook.update();
        }
    }

    /**
     * Elementen tekenen
     */
    protected void render(Graphics2D g) {

        speelveld.draw(g);
        pacman.tekenen(g);
        for (Iterator it = spoken.iterator(); it.hasNext();) {
            Spookje spook = (Spookje) it.next();
            spook.tekenen(g);
            spook.randomBewegen();
            
//            if(speelveld.aantalBolletjes/2<=pacman.aantalGegetenBolletjes){
//          g.setColor(Color.RED);
          g.fillOval(210, 410, 30, 30);
           
//      }
         }

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
        spoken.add(new Spookje());
        spoken.add(new Spookje());
        spoken.add(new Spookje());
        spoken.add(new Spookje());
        speelveld.setSpoken(spoken);
        speelveld.laden();
        speelveld.setPacman(pacman);
        panel = new Panel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.add(canvas);
        KeyHandler kh = new KeyHandler();
        kh.setPacman(pacman);
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
        System.out.println(pacman.aantalGegetenBolletjes);
        System.out.println(speelveld.aantalBolletjes);
//        if(speelveld.aantalBolletjes/2==pacman.aantalGegetenBolletjes){
//           // setKers();
//           System.out.println("setKers");
//      }
        
    }
    private void opniewLaden(int level)
    {
        this.speelveld.laden();
        Status = true;
    }
    public static void  spelStoppen()
    {
        Game.Status = false;
      
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
