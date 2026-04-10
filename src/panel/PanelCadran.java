package panel;

import cadran.Cadran;
import cadran.CadranAiguilles;

import javax.swing.*;
import java.awt.*;

public class PanelCadran extends BasePanel {
    private Cadran cadran;

    public PanelCadran(Cadran c,MainFrame mainFrame) {
        super(mainFrame);
        this.cadran = c;
        lancerHorloge();
    }

    protected void initContenuPanel(){
        panelContenu = new JPanel(){
            //Redéfinition de classe anonyme de JPanel + surdéfinition de la méthode paintComponent
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int centreX = getWidth() / 2;
                int centreY = getHeight() / 2;
                int radius = Math.min(getWidth(), getHeight()) / 3;

                cadran.setCentre(centreX, centreY);
                if (cadran instanceof CadranAiguilles ca) {
                    ca.setRadius(radius);
                }
                cadran.dessiner(g, centreX, centreY);
            }
        };
    }

    private void lancerHorloge(){
        Timer timer = new Timer(1000, e -> {cadran.setHeure(); panelContenu.repaint();});
        timer.start();
    }
}