package model.aiguille;

import model.time.Heure;


/**
 * Classe modélisant l'aiguille des minutes au sein d'une horloge analogique.
 * */
public class AiguilleMinute extends Aiguille {
    public AiguilleMinute(int _longueur){
        super(_longueur);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getMinutes() * 6 - 90);
    }
}
