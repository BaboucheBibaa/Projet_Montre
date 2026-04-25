package panel;

import config.GestionConfig;
import config.ScreenDimensions;
import config.XMLConfig;
import navigation.GestionNavigation;

import javax.swing.*;

/**
 * Classe permettant de modéliser l'affichage courant d'un Panel de la montre.
 * Implémente GestionNavigation car la navigation au sein de la montre se fait à partir de la fenêtre courante.
 * */
public class MainFrame extends JFrame implements GestionNavigation {
    private BasePanel panelCourant;

    /**
     * Constructeur de MainFrame.
     * Initialise la fenêtre avec les dimensions spécifiées et crée le premier panneau (PanelCadran).
     *
     * @param _h la hauteur de la fenêtre en pixels
     * @param _l la largeur de la fenêtre en pixels
     */
    public MainFrame(int _h, int _l) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(_h, _l);

        ScreenDimensions dimensions = new ScreenDimensions(_h, _l);

        try {
            GestionConfig config = new XMLConfig("config.xml");
            PanelProvider panelFactory = new PanelFactory(config, dimensions);

            BasePanel panel = panelFactory.creerPanelCadran(this, config);
            this.naviguer(panel);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création du Panel", e);
        }

        setVisible(true);
    }

    public void naviguer(BasePanel nouveauPanel) {
        if (panelCourant != null) {
            remove(panelCourant);
        }
        panelCourant = nouveauPanel;
        add(panelCourant);
        revalidate();
        repaint();
    }
}
