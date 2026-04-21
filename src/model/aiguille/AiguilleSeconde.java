package model.aiguille;

import model.time.Heure;

/**
 * Classe modélisant l'aiguille des secondes au sein d'une horloge analogique.
 * */
public class AiguilleSeconde extends Aiguille {
    public AiguilleSeconde(int _longueur){
        super(_longueur);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getSecondes() * 6 - 90);
    }

}
