
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhoog_000
 */
public class Menu extends JPanel {
    Game game;
    StartKnop startknop;
    public Menu(Game game){
        JPanel menu = new JPanel();
        this.game = game;
        this.setPreferredSize(new Dimension(200,50));
        this.setBackground(Color.yellow);
        startknop = new StartKnop(this);
        this.add(startknop);
        
        
       
    }
    public void startIsGedrukt(){
        game.spelStarten();
    }
    
}
