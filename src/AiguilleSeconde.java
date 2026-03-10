public class AiguilleSeconde extends Aiguille{
    public AiguilleSeconde(int _longueur, int centreX, int centreY){
        super(_longueur, centreX, centreY);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getSecondes() * 6 - 90);
    }
}
