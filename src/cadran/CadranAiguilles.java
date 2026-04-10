package cadran;

import model.aiguille.Aiguille;
import model.aiguille.AiguilleHeure;
import model.aiguille.AiguilleMinute;
import model.aiguille.AiguilleSeconde;
import model.date.Jour;

import java.awt.*;

public class CadranAiguilles extends Cadran {

    private Aiguille heureAig;
    private Aiguille minuteAig;
    private Aiguille secondeAig;
    private int radius;
    private Jour jour;

    public CadranAiguilles(int _centreX, int _centreY, int _radius){
        super(_centreX, _centreY);
        jour = new Jour();
        radius = _radius;
        heureAig = new AiguilleHeure(radius/5);
        minuteAig = new AiguilleMinute(radius/4);
        secondeAig = new AiguilleSeconde(radius/3);
    }


    public void setRadius(int r) {
        this.radius = r;
        heureAig.setLongueur(r / 5);
        minuteAig.setLongueur(r / 4);
        secondeAig.setLongueur(r / 3);
    }

    public void dessiner(Graphics g, int centreX, int centreY){

        Graphics2D g2 = (Graphics2D) g;

        // Cercle du cadran
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(centreX - radius, centreY - radius, radius * 2, radius * 2);

        // Chiffres 1 à 12
        g2.setFont(new Font("Arial", Font.BOLD, 16));
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
        jour.dessiner(g, centreX, centreY);

        //Aiguilles
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(centreX, centreY, xH, yH);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(centreX, centreY, xM, yM);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(centreX, centreY, xS, yS);
        g2.setStroke(new BasicStroke(1));
    }

}