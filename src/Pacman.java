
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
public class Pacman {

    private int x = 10;
    private int y = 10;
    private final int width = 100;
    private final int height = 100;
    private final int SPEED = 10;
    private boolean running = true;

    public enum Direction {

        SOUTH, EAST, NORTH, WEST
    };
    private Direction move;
    private int deltaTime;
    private Vakje goToVakje;

    public void update(int deltaTime) {
        this.deltaTime = deltaTime;
        if (running) {
            try {
                if (this.getX() < this.goToVakje.getX() && this.getY() == this.goToVakje.getY()) {
                    this.goEast(deltaTime);
                } else if (this.getY() > this.goToVakje.getY() && this.getX() == this.goToVakje.getX()) {
                    this.goNorth(deltaTime);
                } else if (this.getX() > this.goToVakje.getX() && this.getY() == this.goToVakje.getY()) {
                    this.goWest(deltaTime);
                } else if (this.getY() < this.goToVakje.getY() && this.getX() == this.goToVakje.getX()) {
                    this.goSouth(deltaTime);
                } else {
                    this.running = false;
                }

            } catch (NullPointerException e) {
            }
                    
        }

    }

    private void goSouth(int deltaTime) {
        y = y + this.SPEED;
    }

    private void goNorth(int deltaTime) {
        y = y - this.SPEED;
    }

    private void goWest(int deltaTime) {
        x = x -this.SPEED;
    }

    private void goEast(int deltaTime) {

        x = x + this.SPEED;

    }

    public void stop() {
        this.running = false;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, width, height);
        graphics.setColor(Color.BLACK);
        graphics.fillOval((width / 2) + x, y + 10, 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.fillArc(x, y, width, height, width, height);
    }

    void setY(int y) {
        this.y = y;
    }

    void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {

        return this.y;
    }

    public void pacmanStartVakje(Vakje vakje) {
        this.setY(vakje.getY());
        this.setX(vakje.getX());

    }

    public void gaNaarVakje(Vakje vakje) {
        System.out.println(vakje.getY());
        System.out.println(this.getY());
        this.running = true;
        this.goToVakje = vakje;

    }

}
