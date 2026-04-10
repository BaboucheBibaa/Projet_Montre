package cadran;

import model.date.Heure;

import java.awt.*;

public abstract class Cadran {
    protected Heure heure;
    protected int centreX;
    protected int centreY;
    public Cadran(int _centreX, int _centreY){
        heure = new Heure();
        centreX = _centreX;
        centreY = _centreY;
    }
    public void setHeure(){ heure.setHeure();}
    public Heure getHeure() {
        return heure;
    }
    public abstract void dessiner(Graphics g, int centreX, int centreY);
    public void setCentre(int x, int y) {
        this.centreX = x;
        this.centreY = y;
    }
}
