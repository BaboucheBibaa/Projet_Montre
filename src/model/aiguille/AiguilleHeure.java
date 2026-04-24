package model.aiguille;

import model.time.Heure;

/**
 * Classe modélisant l'aiguille des heures au sein d'une horloge analogique.
 * */
public class AiguilleHeure extends Aiguille {
    public AiguilleHeure(int _longueur){
        super(_longueur);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getHeures() * 30 - 90);
    }
}
