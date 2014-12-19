
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denzyl
 */
public class StartKnop extends JButton implements MouseListener{
    Menu menu;
    public StartKnop(Menu menu)
    {   this.menu = menu;
        this.setText("start");
        addMouseListener(this);
        setFocusable(true);
        
    }
    

    @Override
    public void mouseClicked(MouseEvent me) {
        this.menu.startIsGedrukt();
       
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
