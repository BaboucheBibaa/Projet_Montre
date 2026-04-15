package model.aiguille;

import model.time.Heure;

public class AiguilleHeure extends Aiguille {
    public AiguilleHeure(int _longueur){
        super(_longueur);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getHeures() * 30 - 90);
    }

}
