import java.awt.*;

public class CadranNumerique extends Cadran {

    private Jour jour;

    CadranNumerique(int _centreX, int _centreY){
        super(_centreX,_centreY);
        jour = new Jour();
    }
    public void dessiner(Graphics g, int centreX, int centreY){
        jour.dessiner(g,centreX,centreY);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(heure.getTemps(), centreX - 50, centreY);
    }
}