package model.aiguille;

import model.time.Heure;

public class AiguilleMinute extends Aiguille {
    public AiguilleMinute(int _longueur){
        super(_longueur);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getMinutes() * 6 - 90);
    }
}
