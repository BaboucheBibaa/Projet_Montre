public class AiguilleHeure extends Aiguille{
    AiguilleHeure(int _longueur){
        super(_longueur);
    }

    public double calculAngle(Heure heure){
        return Math.toRadians(heure.getHeures() * 30 - 90);
    }

}
