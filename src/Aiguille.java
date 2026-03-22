public abstract class Aiguille {
    protected int longueur;

    public Aiguille(int longueur){
        this.longueur = longueur;
    }

    public abstract double calculAngle(Heure heure);

    public int getLongueur() {
        return longueur;
    }
}
