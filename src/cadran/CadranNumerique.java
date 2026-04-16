package cadran;

import config.GestionConfig;
import drawable.Drawable;

import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;

public class CadranNumerique extends Cadran implements Drawable {
    public CadranNumerique(int _centreX, int _centreY, GestionConfig _config){
        super(_centreX,_centreY, _config);
    }
    public void dessiner(Graphics g, int centreX, int centreY){
        String temps = this.getTemps();
        dessinerJour(g,centreX,centreY);
        String police = config.getPolicy();
        g.setFont(new Font(police, Font.BOLD, 30));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(temps);
        int x = centreX - textWidth / 2;
        int y = centreY + 40;

        g.drawString(temps, x, y-50);
    }
}