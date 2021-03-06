
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Speelveld {

    private List vakken = new ArrayList<Vakje>();
    public List spoken = new ArrayList<Spookje>();
    private final int rowMax = 9;
    Vakje pacmanStartVakje = new Vakje(null);
    public int aantalBolletjes;
    int timeplayed = 1;
    private int[] level;
    private int[] level_one = {
        1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 0, 0, 0, 0, 0, 0, 0, 1,
        1, 3, 1, 1, 1, 1, 1, 0, 1,
        1, 0, 1, 0, 0, 0, 1, 0, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 1, 0, 1, 0, 0, 0, 1,
        1, 0, 0, 2, 0, 0, 1, 0, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 4, 0, 0, 0, 0, 0, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1
    };

    private int[] level_two = {
        1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 0, 0, 0, 0, 0, 0, 0, 1,
        1, 3, 1, 0, 1, 4, 1, 0, 1,
        1, 0, 0, 4, 0, 0, 0, 0, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 1, 0, 0, 0, 1, 0, 1,
        1, 0, 0, 2, 0, 0, 0, 0, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 4, 1, 0, 0, 4, 1, 0, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1
    };

    private int[] level_three = {
        1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 0, 0, 0, 0, 0, 0, 4, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 1, 0, 4, 0, 0, 0, 1,
        1, 4, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 0, 3, 0, 2, 0, 0, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 1, 0, 1, 4, 1, 0, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1
    };

    public void setPacman(Pacman pacman) {

        pacman.setSpeelVeld(this);
        pacman.startVakje(pacmanStartVakje);

    }

    private void setLevel(int[] level) {
        this.level = level;
    }

    public Speelveld() {
        this.setLevel(this.level_one);
    }

    public void setSpoken() {

        for (Iterator it = spoken.iterator(); it.hasNext();) {
            Spookje spook = (Spookje) it.next();
            spook.setSpeelVeld(this);
            Vakje vakje = new Vakje(null);
            vakje.setSpookje(spook);
            spook.startVakje(vakje);
        }

    }

    public void laden() {
        vakken = new ArrayList<Vakje>();

        this.setSpoken();
        int spokjes = 0;
        for (int i = 0; i < level.length; i++) {
            if (level[i] == 1) {
                vakken.add(new Vakje(new Muur()));
            } else if (level[i] == 0) {
                aantalBolletjes = aantalBolletjes + 1;
                vakken.add(new Vakje(new NormaalBolletje()));
            } else if (level[i] == 2) {
                vakken.add(new Vakje(new SuperBolletje()));
            } else if (level[i] == 3) {
                vakken.add(this.pacmanStartVakje);
            } else if (level[i] == 4) {
              
                if (spokjes <= spoken.size()) {

                    Spookje spook = (Spookje) spoken.get(spokjes);
                    vakken.add(spook.vakje);
                    spokjes++;
                }
            }
        }
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
            if(vakje.bevat instanceof Spookje)
            {
                vakje.bevat.setX(vakje.getX());
                vakje.bevat.setY(vakje.getY());
            }
        }
     
    }

    /**
     * Alle vakjes tekenen op het speelveld
     *
     * @param
     */
    public void draw(Graphics g) {
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();
            vakje.draw(g);

        }
    }

    /**
     * Geeft alle vakjes aan spelElement die in die richting staan
     *
     * @param vakje
     * @param direction
     * @param pathfor
     * @return
     */
    public ArrayList<Vakje> getPath(Vakje vakje, Richting direction) {
        ArrayList<Vakje> path = new ArrayList<Vakje>();
        switch (direction) {
            case EAST:
                path = this.pathNaarEast(vakje);
                break;
            case WEST:
                path = this.pathNaarWest(vakje);
                break;
            case NORTH:
                path = this.pathNaarNorth(vakje);
                break;
            case SOUTH:
                path = this.pathNaarSouth(vakje);
                break;
        }
        return path;
    }

    /**
     * Ga naar east wanneer pijltje naar rechts is gedrukt
     */
    private ArrayList<Vakje> pathNaarEast(Vakje tempVakje) {

        ArrayList<Vakje> path = new ArrayList<Vakje>();
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (tempVakje.getY() == vakje.getY()) {

                if (tempVakje.getX() < vakje.getX()) {
                    path.add(vakje);
                }
            }
        }

        return path;
    }

    private ArrayList<Vakje> pathNaarWest(Vakje tempVakje) {

        ArrayList<Vakje> path = new ArrayList<Vakje>();
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (tempVakje.getY() == vakje.getY()) {

                if (tempVakje.getX() > vakje.getX()) {
                    path.add(vakje);
                }
            }
        }

        return path;
    }

    private ArrayList<Vakje> pathNaarNorth(Vakje tempVakje) {

        ArrayList<Vakje> path = new ArrayList<Vakje>();
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (tempVakje.getX() == vakje.getX()) {

                if (vakje.getY() < tempVakje.getY()) {

                    path.add(vakje);

                }

            }
        }

        return path;
    }

    private ArrayList<Vakje> pathNaarSouth(Vakje tempVakje) {

        ArrayList<Vakje> path = new ArrayList<Vakje>();
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            if (tempVakje.getX() == vakje.getX()) {

                if (vakje.getY() > tempVakje.getY()) {

                    path.add(vakje);

                }

            }
        }
        return path;
    }

    public void volgendeLevel() {
        timeplayed++;

        if (timeplayed == 2) {
            this.setLevel(this.level_two);
        }
        if (timeplayed == 3) {
            this.setLevel(this.level_three);
        }
 if(timeplayed > 3)
 {
     Game.spelStoppen();
 }
        this.laden();

    }

}
