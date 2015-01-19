
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author denzyl
 */
class Vakje {

    private final int WIDTH = 50;
    private final int HEIGHT =50;
    private int x= 0, y=0;
    public SpelElement bevat;
    private Bolletje bolletje;
    public Pacman pacman;
    
    public Vakje(SpelElement spelelement) {

        this.bevat = spelelement;
       
    }
    public Vakje(Bolletje bolletje)
    {
        this.bolletje = bolletje;
    }
            

    public void draw(Graphics g) {

     if (this.bevat instanceof Muur) {
            Muur muur = (Muur) this.bevat;
            muur.setX(this.x);
            muur.setY(this.y);
            muur.setWidth(this.WIDTH);
            muur.setHeight(this.HEIGHT);
            muur.tekenen(g);
        }else if(this.isNormaalBolletje() || this.isSuperBolletje())
        {
            bolletje.setX(this.getX());
            bolletje.setY(this.getY());
            bolletje.setWidth(this.getWidth());
            bolletje.setHeight(this.getHeight());
            bolletje.tekenen(g);
        }
        
    }

    void setY(int y) {
        this.y = y;
    }

    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    int getWidth() {
        return this.WIDTH;
    }

    int getHeight() {
        return this.HEIGHT;
    }

    public boolean isPacman() {
        
    
          return (this.pacman instanceof Pacman);
       
    }
    public void setPacman(Pacman pacman)
    {
       
      this.pacman = pacman;       
    }
    
    public void setSpookje(Spookje spookje)
    {
        this.bevat = spookje;
    }
    
    
    public Boolean isSpookje()
    {
        return (this.bevat instanceof Spookje);
    }
    public boolean isMuur()
    {
        return (this.bevat instanceof Muur);
    }
    public boolean isNormaalBolletje()
    {
        return(this.bolletje instanceof NormaalBolletje);
    }
    public boolean isSuperBolletje()
    {
        return(this.bolletje instanceof SuperBolletje);
    }

    Bolletje getBolletje() {
        
            return this.bolletje;
        
        
    }
 
    public void bolletjeVerwijderen()
    {
        this.bolletje = null;
    }

    void setBevat(Object object) {
        this.bevat =  (SpelElement)null;
    }
   
}
