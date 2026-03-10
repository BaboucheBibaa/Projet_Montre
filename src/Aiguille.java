import java.util.Vector;

public abstract class Aiguille {
    protected int longueur;
    protected int[] centre;

    public Aiguille(int longueur, int centreX, int centreY){
        this.longueur = longueur;
        centre = new int[2];
        centre[0] = centreX;
        centre[1] = centreY;
    }

    public abstract double calculAngle(Heure heure);

}
