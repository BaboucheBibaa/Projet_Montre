package model.aiguille;

import model.Heure;

public abstract class Aiguille {
    protected int longueur;

    public Aiguille(int longueur){
        this.longueur = longueur;
    }

    public abstract double calculAngle(Heure heure);

    public int getLongueur() {
        return longueur;
    }
    public void setLongueur(int _longueur) { longueur = _longueur; }
}
