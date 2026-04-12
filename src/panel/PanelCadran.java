package panel;

import cadran.Cadran;
import cadran.CadranAiguilles;
import cadran.CadranNumerique;
import xml.XmlReader;

import javax.swing.*;
import java.awt.*;

public class PanelCadran extends BasePanel {
    private Cadran cadran;

    public PanelCadran(Cadran c,MainFrame mainFrame) {
        super(mainFrame);
        this.cadran = c;
        lancerHorloge();
    }

    /**
     * Méthode static qui créé un objet de type Cadran en fonction du format contenu dans le XML
     * Afin de pouvoir retourner le Panel corespondant au format stocké dans le XML
     * Patron de conception fabrique -> Génère des objets dont on ne connaît pas à l'avance le type.
     */

    public static PanelCadran createFromConfig(MainFrame mainFrame) {
        try {
            //récupère le format de l'horloge dans le xml pour afficher le bon type de cadran.
            XmlReader xmlReader = new XmlReader("config.xml");
            String clockFormat = xmlReader.getClockFormat();

            //instanciation du cadran
            Cadran c;
            if ("numeric".equals(clockFormat)) {
                c = new CadranNumerique(400, 400);
            } else {
                // Par défaut, utiliser l'horloge à aiguilles (analog)
                c = new CadranAiguilles(400, 400, 400);
            }
            //Retourne le panel final contenant le cadran demandé.
            return new PanelCadran(c, mainFrame);
        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur, utiliser l'horloge à aiguilles par défaut
            Cadran c = new CadranAiguilles(400, 400, 400);
            return new PanelCadran(c, mainFrame);
        }
    }

    protected void initContenuPanel(){
        panelContenu = new JPanel(){
            //Redéfinition de classe anonyme de JPanel + surdéfinition de la méthode paintComponent
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(bgColor);
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