package panel;

import cadran.Cadran;
import cadran.CadranAiguilles;
import cadran.CadranNumerique;
import config.GestionConfig;
import model.sante.*;
import navigation.GestionNavigation;

import javax.swing.*;
import java.awt.*;

public class PanelCadran extends BasePanel {
    private Cadran cadran;
    private RythmeCardiaque rythme;
    private Batterie batterie;

    public PanelCadran(Cadran c, GestionNavigation navigator, GestionConfig _config) {
        super(navigator, _config);
        this.cadran = c;
        this.rythme= new RythmeCardiaque();
        this.batterie= new Batterie();
        lancerHorloge();
    }

    protected void initBoutonsNavigation(){
        // ActionListener
        btnLeft.addActionListener(e -> this.naviguer(new PanelChoixCouleur(getNavigator(),getConfig())));
        btnRight.addActionListener(e -> this.naviguer(new PanelCalendrier(getNavigator(),getConfig())));

        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
    }
    protected void initContenuPanel(){
        panelContenu = new JPanel(){
            //Redéfinition de classe anonyme de JPanel + surdéfinition de la méthode paintComponent
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(getBgColor());
                int centreX = getWidth() / 2;
                int centreY = getHeight() / 2;
                int radius = Math.min(getWidth(), getHeight()) / 3;
                rythme.dessiner(g, centreX, centreY+60);
                batterie.dessiner(g, 0, 0);

                cadran.setCentre(centreX, centreY);
                if (cadran instanceof CadranAiguilles ca) {
                    ca.setRadius(radius);
                }
                cadran.dessiner(g, centreX, centreY);
            }
        };
    }

    /**
     * Méthode static qui créé un objet de type Cadran en fonction du format contenu dans le XML
     * Afin de pouvoir retourner le Panel corespondant au format stocké dans le XML
     * Patron de conception fabrique -> Génère des objets dont on ne connaît pas à l'avance le type.
     */

    public static PanelCadran createFromConfig(GestionNavigation navigator, GestionConfig config) {
        try {

            // Récupérer le format de l'horloge
            String clockFormat = config.getClockFormat();

            Cadran c;
            if ("numeric".equals(clockFormat)) {
                c = new CadranNumerique(400, 400, config);
            } else {
                // Par défaut, utiliser l'horloge à aiguilles (analog)
                c = new CadranAiguilles(400, 400, 400, config);
            }
            // Retourne le panel final contenant le cadran demandé
            return new PanelCadran(c, navigator, config);
        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur, utiliser l'horloge à aiguilles par défaut avec config par défaut
            try {
                Cadran c = new CadranAiguilles(400, 400, 400, config);
                return new PanelCadran(c, navigator, config);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Impossible de charger la configuration", ex);
            }
        }
    }

    private void lancerHorloge(){
        //timer de rafraîchissement toutes les secondes
        Timer timer = new Timer(1000, e -> {
            cadran.setHeure();
            
           // if(mon){}
            
            panelContenu.repaint();});
        timer.start();
    }
}