
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author denzyl
 */
public class Pacman extends SpelElement {


    private int score=0;
    private Font font;
    public Pacman() {

        this.SPEED = 5;

        this.width = 50;
        this.height = 50;
    }
    
    public enum Direction {


        SOUTH, EAST, NORTH, WEST
    };
    private Direction move;
    private int deltaTime;
    private Vakje goToVakje;
    

    public void update(int deltaTime) {
        this.deltaTime = deltaTime;
        if (running) {
            try {
                if (this.getX() < this.goToVakje.getX() && this.getY() == this.goToVakje.getY()) {
                    this.goEast();
                } else if (this.getY() > this.goToVakje.getY() && this.getX() == this.goToVakje.getX()) {
                    this.goNorth();
                } else if (this.getX() > this.goToVakje.getX() && this.getY() == this.goToVakje.getY()) {
                    this.goWest();
                } else if (this.getY() < this.goToVakje.getY() && this.getX() == this.goToVakje.getX()) {
                    this.goSouth();
                } else {
                    this.running = false;
                }

            } catch (NullPointerException e) {
            }
                    
        }

    }

    

    public void stop() {
        this.running = false;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, width, height);
        graphics.setColor(Color.BLACK);
        graphics.fillOval((width / 2) + x, y + 10, 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.fillArc(x, y, width, height, width, height);
        
        Font myFont = new Font("Serif",font.BOLD,28);
        graphics.setColor(Color.lightGray);
        graphics.setFont(myFont);
        graphics.drawString("Score:"+ score, 30,500);
        
        
    }

    private void eetBolletje(Vakje vakje) {

        
        vakje.bolletjeVerwijderen();

       score +=10;

    }
    @Override
       public void startVakje(Vakje vakje) {
        this.vakje = vakje;
        
        
        this.vakje.setPacman(this);
        
        this.setY(vakje.getY());
        this.setX(vakje.getX());
        
    }


    @Override
    protected void gaNaarVakje(Vakje vakje) {
        if (vakje.isBolletje()) {
            this.eetBolletje(vakje);
        }else if(vakje.isSpookje())
        {
            this.dood();
        }
        
        this.running = true;
        this.vakje = vakje;
        vakje.setPacman(this);
    }

    void dood() {
        this.x = 100000;
        this.y = -1000;
        
        //PACMAN IS DOOD
    }
    

}
