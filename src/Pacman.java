
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author denzyl
 */
public class Pacman extends SpelElement {


    private int score=0;
    private int leven=3;
    private Font font;
    boolean isLevend=true;
    boolean isSuper = false;
    boolean timer=false;
    boolean tijd=false;
    private long begin;
    private long nu;
    private long spelTijd;
    public int aantalGegetenBolletjes;
    private Vakje startVakje;
    private boolean first = true;
    public Pacman() {

        this.SNELHEID = 5;
        this.width = 50;
        this.height = 50;
        
    }
    
    

    

    @Override
    public void tekenen(Graphics graphics) {
     if(this.isLevend)
     {
         if(begin+10==System.currentTimeMillis()/1000){            
                isSuper=false;
            }
        if(!isSuper)
        {
        graphics.setColor(Color.YELLOW);
        }else{
          graphics.setColor(Color.GRAY);      
        }
        


  graphics.fillArc(x,y,width,height,30,300);
       
     }
        
        Font myFont = new Font("Serif",font.BOLD,28);
        graphics.setColor(Color.lightGray);
        graphics.setFont(myFont);
        graphics.drawString("Score: "+ score, 500,50);
        
        graphics.setColor(Color.lightGray);
        graphics.setFont(myFont);
        graphics.drawString("Levens: "+ leven,500,100);
        
        nu = System.currentTimeMillis()/1000;
        
        graphics.setColor(Color.lightGray);
        graphics.setFont(myFont);
        graphics.drawString("Tijd: " +(nu - spelTijd) + " seconden",500,150);
        
        
        
        
    }
   

    private void eetBolletje() {

        vakje.bolletjeVerwijderen();
        aantalGegetenBolletjes = aantalGegetenBolletjes+1;
        score +=10;

    }
    @Override
       public void startVakje(Vakje vakje) {
        if(first)
        {
        this.startVakje = vakje;
        first = false;
 
        }
        this.vakje = vakje;
        this.vakje.setPacman(this);
        this.setY(vakje.getY());
        this.setX(vakje.getX());
        spelTijd = System.currentTimeMillis()/1000;
    }


    @Override
    protected void gaNaarVakje(Vakje vakje) {
        this.vakje.pacman = null;
        this.vakje = vakje;
        if (vakje.isNormaalBolletje()) {
            this.eetBolletje();
            
        }else if(vakje.isSpookje()&&!isSuper)
        {
            this.dood();
            
        }else if(vakje.isSpookje()&&isSuper){
            vakje.setBevat(this);
        }
        
        else if(vakje.isSuperBolletje())
        {
            
             begin = System.currentTimeMillis()/1000;
 
            this.eetBolletje();
            isSuper=true;
             
           
        }
        this.lopend = true;
       
        vakje.setPacman(this);
    }
    private void opniew()
    {
        this.vakje.pacman = null;
       this.startVakje(this.startVakje);
          this.vakje.setPacman(null);
        this.isLevend = true;
    }

    void dood() {
        if(isLevend){
        
        
        leven = leven -1;
      
        
       
         isLevend = false;
        
            if(leven <0){
                Game. Status=false;
            }else
            {
        this.opniew();
            }
        
    }
    }

}
