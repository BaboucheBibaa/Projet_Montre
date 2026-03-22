import java.awt.*;
import java.util.ArrayList;

public abstract class Cadran {
    protected Heure heure;
    protected int centreX;
    protected int centreY;
    Cadran(int _centreX, int _centreY){
        heure = new Heure();
        centreX = _centreX;
        centreY = _centreY;
    }

    public Heure getHeure() {
        return heure;
    }
    public abstract void dessiner(Graphics g, int centreX, int centreY);
}
