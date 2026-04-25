package model.aiguille;

import model.time.Heure;
/**
 * CLasse abstraite modélisant le fonctionnement d'une aiguille générique
 * Abstraite car on ne sait pas comment doit se calculer le décalage d'angle sur une horloge analogique pour une aiguille générique
 * */
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
