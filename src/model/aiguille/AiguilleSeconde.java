package model.aiguille;

import model.date.Heure;

public class AiguilleSeconde extends Aiguille {
    public AiguilleSeconde(int _longueur){
        super(_longueur);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getSecondes() * 6 - 90);
    }

}
