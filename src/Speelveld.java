
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
        vakken.add(new Vakje(new Bolletje()));
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Bolletje()));
  
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
        vakken.add(new Vakje(null));
        vakken.add(new Vakje(new Muur()));
        vakken.add(new Vakje(new Spookje()));
        vakken.add(new Vakje(null));
        vakken.add(pacmanStartVakje);
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
        Vakje tempVakje = this.pacman.getVakje();
        ArrayList<Vakje> pacmanPath = new ArrayList<Vakje>();
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (this.pacman.getY() == vakje.getY()) {
            

                if (tempVakje.getX() <  vakje.getX()) {
                    pacmanPath.add(vakje);
                }
            }
        }
        tempVakje.setPacman(pacman);
        this.pacman.path(pacmanPath,Pacman.Direction.EAST);

    }

    public void gaWest() {
        Vakje tempVakje = this.pacman.getVakje();
        ArrayList<Vakje> pacmanPath = new ArrayList<Vakje>();

        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (this.pacman.getY() == vakje.getY()) {
                
                if (tempVakje.getX() > vakje.getX()) {
                  
                  pacmanPath.add(vakje);
                }

            }
        }
        tempVakje.setPacman(this.pacman);
        this.pacman.path(pacmanPath,Pacman.Direction.WEST);
    }

    public void gaNorth() {

        try {
            Vakje tempVakje = this.pacman.getVakje();
            ArrayList<Vakje> pacmanPath = new ArrayList<Vakje>();
            for (Iterator it = vakken.iterator(); it.hasNext();) {

                Vakje vakje = (Vakje) it.next();

                if (this.pacman.getX() == vakje.getX() ) {

                    if (vakje.getY() < tempVakje.getY()) {

                        pacmanPath.add(vakje);

                    }

                }
            }

            this.pacman.path(pacmanPath,Pacman.Direction.NORTH);

        } catch (NullPointerException e) {

        }

    }

    public void gaSouth() {

        Vakje tempVakje = this.pacman.getVakje();
        ArrayList<Vakje> pacmanPath = new ArrayList<Vakje>();
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (this.pacman.getX() == vakje.getX() && vakje.isMuur() == false) {

                if (vakje.getY() > this.pacman.getY()) {

                    pacmanPath.add(vakje);

                }

            }
        }

        this.pacman.path(pacmanPath,Pacman.Direction.SOUTH);
    }

}
