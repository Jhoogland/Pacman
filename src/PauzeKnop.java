
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhoog_000
 */
public class PauzeKnop extends JButton implements MouseListener {
    Menu menu;
    public PauzeKnop(Menu menu)
    {   this.menu = menu;
        this.setText("pauze");
        addMouseListener(this);
        setFocusable(true);
        
    }
    

    @Override
    public void mouseClicked(MouseEvent me) {
       
        if(this.getText().equals("pauze")){
        this.menu.pauzeIsGedrukt();
            this.setText("hervat");
        }
        else{ 
            this.menu.hervatIsGedrukt();
            
            this.setText("pauze");
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
