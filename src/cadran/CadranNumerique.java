package cadran;

import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;

public class CadranNumerique extends Cadran {
    public CadranNumerique(int _centreX, int _centreY){
        super(_centreX,_centreY);
    }
    public void dessiner(Graphics g, int centreX, int centreY){
        String temps = this.getTemps();
        dessinerJour(g,centreX,centreY);
        String police = reader.getPolicy();
        g.setFont(new Font(police, Font.BOLD, 30));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(temps);
        int x = centreX - textWidth / 2;
        int y = centreY + 40;

        g.drawString(temps, x, y-50);
    }
}