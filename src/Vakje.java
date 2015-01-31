
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
    public int bolletjes = 0;
    private boolean onthoudBolletje = false; 
    public Object bolletjeHouder;
    
    public Vakje(SpelElement spelelement) {

        this.bevat = spelelement;
       
    }
 
    

    public void draw(Graphics g) {
 
      
       if (this.isMuur()) {
            Muur muur = (Muur) this.bevat;
            muur.setX(this.x);
            muur.setY(this.y);
            muur.setWidth(this.WIDTH);
            muur.setHeight(this.HEIGHT);
            muur.tekenen(g);
        }else if(this.isNormaalBolletje() || this.isSuperBolletje())
        {
            Bolletje bolletje = (Bolletje)this.bevat;
            bolletje.setX(this.getX());
            bolletje.setY(this.getY());
            bolletje.setWidth(this.getWidth());
            bolletje.setHeight(this.getHeight());
            bolletje.tekenen(g);
        }else if(this.isKers()){
            Kers kers = (Kers)this.bevat;
            kers.setX(this.getX());
            kers.setY(this.getY());
            kers.setWidth(this.getWidth());
            kers.setHeight(this.getHeight());
            kers.tekenen(g);
        }
       if(bolletjeHouder instanceof Bolletje)
       {
           this.bevat = (Bolletje)this.bolletjeHouder;
          
       }
         if (this.isSpookje()) {
            g.setColor(Color.RED);
            g.drawRect(x, y, WIDTH, WIDTH);            
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
        
    
          return (this.bevat instanceof Pacman);
       
    }
    public void setPacman(Pacman pacman)
    {System.out.println("====");
        System.out.println(this.isSpookje());
       if(this.isSpookje() && this.bevat.intersect(pacman))
       {
        
       }else
       {
      this.bevat = pacman;  
       }
    }
    
    public void setSpookje(Spookje spookje)
    {
       
        if(this.isNormaalBolletje() || this.isSuperBolletje())
        {
            this.bolletjeHouder = this.bevat;
            
                                  
        }
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
        
        return(this.bevat instanceof NormaalBolletje);
    }
    public boolean isSuperBolletje()
    {
        return(this.bevat instanceof SuperBolletje);
    }
    public boolean isKers()
    {   
        return(this.bevat instanceof Kers);
        
    }
    
    Kers getKers(){
        return(Kers) this.bevat;
    }
    Bolletje getBolletje() {
        
            return (Bolletje)this.bevat;   
     
    }
    public void kersVerwijderen()
    {
      
        this.bevat=null;
        
    }
    public void bolletjeVerwijderen()
    {this.bevat =null;
      this.bolletjeHouder =  null;
    }


    void kers() {
      this.bevat = new Kers();
    }

   
}
