package cadran;

import model.date.Jour;

import java.awt.*;

public class CadranNumerique extends Cadran {

    private Jour jour;

    public CadranNumerique(int _centreX, int _centreY){
        super(_centreX,_centreY);
        jour = new Jour();
    }
    public void dessiner(Graphics g, int centreX, int centreY){
        String temps = heure.getTemps();
        jour.dessiner(g,centreX,centreY);
        //lecture du XML (reader = variable protected, accessible via héritage) pour récupérer la police d'écriture
        String police = reader.getPolicy();
        g.setFont(new Font(police, Font.BOLD, 30));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(temps);
        int x = centreX - textWidth / 2;
        int y = centreY + 40;

        g.drawString(temps, x, y-50);
    }
}