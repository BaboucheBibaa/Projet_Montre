import java.awt.*;
import java.util.ArrayList;

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
        heureAig = new AiguilleHeure(50);
        minuteAig = new AiguilleMinute(70);
        secondeAig = new AiguilleSeconde(90);
    }

    private ArrayList<Graduation> getListGraduations(){

            ArrayList<Graduation> listGraduations = new ArrayList<>(60);

            for(int i = 0; i < 60; i++){
                double angle = Math.toRadians(i * 6);

                int x1 = centreX + (int)((radius/2 - 5) * Math.cos(angle));
                int y1 = centreY + (int)((radius/2 - 5) * Math.sin(angle));

                int x2 = centreX + (int)((radius/2) * Math.cos(angle));
                int y2 = centreY + (int)((radius/2) * Math.sin(angle));

                listGraduations.add(new Graduation(x1,y1,x2,y2));
            }

            return listGraduations;
        }
    public void dessiner(Graphics g, int centreX, int centreY){

        double angleH = heureAig.calculAngle(heure);
        double angleM = minuteAig.calculAngle(heure);
        double angleS = secondeAig.calculAngle(heure);

        ArrayList<Graduation> listGraduations = getListGraduations();
        int xH = centreX + (int)(heureAig.getLongueur() * Math.cos(angleH));
        int yH = centreY + (int)(heureAig.getLongueur() * Math.sin(angleH));

        int xM = centreX + (int)(minuteAig.getLongueur() * Math.cos(angleM));
        int yM = centreY + (int)(minuteAig.getLongueur() * Math.sin(angleM));

        int xS = centreX + (int)(secondeAig.getLongueur() * Math.cos(angleS));
        int yS = centreY + (int)(secondeAig.getLongueur() * Math.sin(angleS));
        for (int i = 0; i<  60; i++){
            g.drawLine(listGraduations.get(i).getX1(),listGraduations.get(i).getY1(),listGraduations.get(i).getX2(),listGraduations.get(i).getY2());
        }
        jour.dessiner(g, centreX, centreY);
        g.drawLine(centreX, centreY, xH, yH);
        g.drawLine(centreX, centreY, xM, yM);
        g.drawLine(centreX, centreY, xS, yS);
        g.drawOval(centreX-(radius/2),centreY-(radius/2),radius,radius);
    }

}