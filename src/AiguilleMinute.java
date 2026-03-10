public class AiguilleMinute extends Aiguille{
    public AiguilleMinute(int _longueur, int centreX, int centreY){
        super(_longueur, centreX, centreY);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getMinutes() * 6 - 90);
    }
}
