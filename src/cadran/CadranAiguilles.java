package cadran;

import config.GestionConfig;
import drawable.Drawable;
import model.aiguille.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Font;
/**
 * Classe héritant de Cadran qui permet de dessiner un cadran à aiguilles au sein d'une JPanel.
 * */
public class CadranAiguilles extends Cadran implements Drawable {

    private final Aiguille heureAig;
    private final Aiguille minuteAig;
    private final Aiguille secondeAig;
    private int radius;

    public CadranAiguilles(int _centreX, int _centreY, int _radius, GestionConfig _config){
        super(_centreX, _centreY,_config);
        radius = _radius;
        heureAig = new AiguilleHeure(radius/5);
        minuteAig = new AiguilleMinute(radius/4);
        secondeAig = new AiguilleSeconde(radius/3);
    }

    /**
    * Permet de dessiner le cadran à aiguilles en fonction des coordonnées du centre de l'application
    * */
    public void dessiner(Graphics g, int centreX, int centreY){

        Graphics2D g2 = (Graphics2D) g;

        // Cercle du cadran
        g2.setBackground(Color.ORANGE);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(centreX - radius, centreY - radius, radius * 2, radius * 2);
        //Même les chiffres sont dans la bonne police !
        String police = config.getPolicy();
        // Chiffres 1 à 12
        g2.setFont(new Font(police, Font.BOLD, 16));
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(i * 30 - 90);
            int x = centreX + (int)((radius - 25) * Math.cos(angle));
            int y = centreY + (int)((radius - 25) * Math.sin(angle));
            String chiffre = String.valueOf(i);
            int textWidth = g2.getFontMetrics().stringWidth(chiffre);
            int textHeight = g2.getFontMetrics().getHeight();
            g2.drawString(chiffre, x - textWidth / 2, y + textHeight / 4);
        }

        double angleH = heureAig.calculAngle(heure);
        double angleM = minuteAig.calculAngle(heure);
        double angleS = secondeAig.calculAngle(heure);

        int xH = centreX + (int)(heureAig.getLongueur() * Math.cos(angleH));
        int yH = centreY + (int)(heureAig.getLongueur() * Math.sin(angleH));

        int xM = centreX + (int)(minuteAig.getLongueur() * Math.cos(angleM));
        int yM = centreY + (int)(minuteAig.getLongueur() * Math.sin(angleM));

        int xS = centreX + (int)(secondeAig.getLongueur() * Math.cos(angleS));
        int yS = centreY + (int)(secondeAig.getLongueur() * Math.sin(angleS));

        //Affichage de la date sous l'horloge
        dessinerJour(g, centreX, centreY);

        //Aiguilles
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(centreX, centreY, xH, yH);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(centreX, centreY, xM, yM);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(centreX, centreY, xS, yS);
        g2.setStroke(new BasicStroke(1));
    }


    // setter
    public void setRadius(int r) {
        this.radius = r;
        heureAig.setLongueur(r / 5);
        minuteAig.setLongueur(r / 4);
        secondeAig.setLongueur(r / 3);
    }



}