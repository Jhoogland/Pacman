
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Speelveld {

    private List vakken = new ArrayList<Vakje>();
    
    private final int rowMax = 9;
    Pacman pacman;
    Vakje pacmanStartVakje;

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;

        pacman.pacmanStartVakje(pacmanStartVakje);

    }

    public Speelveld() {
        pacmanStartVakje = new Vakje(null);
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Bolletje()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Spookje()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Spookje()));
        vakken.add(new Vakje(new Muur()));
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(pacmanStartVakje);
        vakken.add(new Vakje(new Muur()));      
        vakken.add(new Vakje(new Spookje()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        
        
        
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Muur()));
        
        this.vakjesVerdelen();
    }

    private void vakjesVerdelen() {
        int y = 0;
        int x = 0;
        int i = 0;
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();
            vakje.setY(y);
            vakje.setX(x);
            x = x + vakje.getWidth();
            i++;
            if (i % this.rowMax == 0) {
                y = y + vakje.getHeight();
                x = 0;
            }

            if (vakje.pacmanIsErop()) {

                this.pacmanStartVakje = vakje;
            }

        }
    }

    public void draw(Graphics g) {
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();
            vakje.draw(g);

        }
    }

    public void gaEast() {
        Vakje tempVakje = new Vakje(null);
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (this.pacman.getY() == vakje.getY() && !vakje.isMuur()) {
                tempVakje = vakje;
               
               
                        
                if (tempVakje.getX() > vakje.getX()) {
                        
                    tempVakje = vakje;
                }
            }
        }
        
     
            this.pacman.gaNaarVakje(tempVakje);
        
        }
     public void gaWest() {
        Vakje tempVakje = this.pacmanStartVakje;
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (this.pacman.getY() == vakje.getY() && !vakje.isMuur()) {
                    
                if (tempVakje.getX() > vakje.getX()) {

                    tempVakje = vakje;
                }
            }
        }

        this.pacman.gaNaarVakje(tempVakje);
    }

    public void gaNorth() {
  
        try{
                    Vakje tempVakje = this.pacmanStartVakje;
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (this.pacman.getX() == vakje.getX() && vakje.isMuur() == false) {
                
                if (vakje.getY() < tempVakje.getY()) {

                    tempVakje = vakje;

                }

            }
        }

        this.pacman.gaNaarVakje(tempVakje);
            
        }catch(NullPointerException e)
        {
            
        }

    }
    
        public void gaSouth() {
  
        Vakje tempVakje = null;
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (this.pacman.getX() == vakje.getX()  && vakje.isMuur() == false) {
                
                if (vakje.getY() > this.pacman.getY()) {

                    tempVakje = vakje;

                }

            }
        }

        this.pacman.gaNaarVakje(tempVakje);
    }

}
