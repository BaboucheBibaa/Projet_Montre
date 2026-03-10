public class AiguilleHeure extends Aiguille{
    AiguilleHeure(int _longueur,int centreX,int centreY){
        super(_longueur,centreX,centreY);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getHeures() * 30 - 90);
    }

}
