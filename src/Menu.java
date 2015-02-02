
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
    PauzeKnop pauzeknop;
    public Menu(Game game){
        JPanel menu = new JPanel();
        this.game = game;
        this.setPreferredSize(new Dimension(200,50));
        this.setBackground(Color.black);
        startknop = new StartKnop(this);
        pauzeknop = new PauzeKnop(this);
        
        this.add(startknop);
        this.add(pauzeknop);
        
       
    }
    public void startIsGedrukt(){
        game.spelStarten();
    }
    public void pauzeIsGedrukt(){
        Game.Status = false;
    }
    public void hervatIsGedrukt(){
        Game.Status = true;
        System.out.println(Game.Status);
    }
}
