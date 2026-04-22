package panel;

import cadran.Cadran;
import cadran.CadranAiguilles;
import cadran.CadranNumerique;
import config.GestionConfig;
import config.ScreenDimensions;
import panel.widgets.Batterie;
import panel.widgets.RythmeCardiaque;
import navigation.GestionNavigation;


/**
 * Design Pattern factory permettant de générer des objets dont on ne connaît pas le type lors de l'appel.
 * Cela est pertinent ici car chaque Panel ne doit pas savoir quel Panel est à côté, tout cela est géré au sein de {@link BasePanel}.
 * */
public class PanelFactory implements PanelProvider {

    /** Configuration globale */
    private final GestionConfig config;

    /** Dimensions de la fenêtre */
    private final ScreenDimensions dimensions;

    /**
     * Constructeur de PanelFactory.
     *
     * @param _config la configuration globale
     * @param _dimensions les dimensions de la fenêtre
     */
    public PanelFactory(GestionConfig _config, ScreenDimensions _dimensions) {
        config = _config;
        dimensions = _dimensions;
    }

    /**
     * Crée un panneau d'affichage de l'horloge.
     * Le type de cadran (aiguilles ou numérique) dépend de la configuration.
     *
     * @param navigator l'interface de navigation
     * @param gestionConfig la configuration
     * @return un panneau PanelCadran configuré
     */
    public BasePanel creerPanelCadran(GestionNavigation navigator, GestionConfig gestionConfig) {
        try {
            int h = dimensions.getHauteur();
            int l = dimensions.getLargeur();
            String clockFormat = config.getClockFormat();
            Cadran cadran;

            if ("numeric".equals(clockFormat)) {
                cadran = new CadranNumerique(h, l, config);
            } else {
                cadran = new CadranAiguilles(h, l, (h+l)/2, config);
            }

            Batterie b = new Batterie();
            RythmeCardiaque rc = new RythmeCardiaque();
            return new PanelCadran(cadran, navigator, config, b, rc, this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la création du PanelCadran", e);
        }
    }

    /**
     * Crée un panneau de sélection de couleur de background.
     *
     * @param navigator l'interface de navigation
     * @param gestionConfig la configuration
     * @return un panneau PanelChoixCouleur
     */
    public BasePanel creerPanelChoixCouleur(GestionNavigation navigator, GestionConfig gestionConfig) {
        return new PanelChoixCouleur(navigator, config, this);
    }

    /**
     * Crée un panneau de paramétrage (format heure, date, police, etc.).
     *
     * @param navigator l'interface de navigation
     * @param gestionConfig la configuration
     * @return un panneau PanelParametrage
     */
    public BasePanel creerPanelParametrage(GestionNavigation navigator, GestionConfig gestionConfig) {
        return new PanelParametrage(navigator, config, this);
    }

    /**
     * Crée un panneau affichant un calendrier.
     *
     * @param navigator l'interface de navigation
     * @param gestionConfig la configuration
     * @return un panneau PanelCalendrier
     */
    public BasePanel creerPanelCalendrier(GestionNavigation navigator, GestionConfig gestionConfig) {
        return new PanelCalendrier(navigator, config, this);
    }

    /**
     * Crée un panneau chronomètre.
     *
     * @param navigator l'interface de navigation
     * @param gestionConfig la configuration
     * @return un panneau PanelChronometre
     */
    public BasePanel creerPanelChronometre(GestionNavigation navigator, GestionConfig gestionConfig) {
        return new PanelChronometre(navigator, config, this);
    }

    /**
     * Crée un panneau pour la gestion des alarmes.
     *
     * @param navigator l'interface de navigation
     * @param gestionConfig la configuration
     * @return un panneau PanelAlarme
     */
    public BasePanel creerPanelAlarme(GestionNavigation navigator, GestionConfig gestionConfig) {
        return new PanelAlarme(navigator, config, this);
    }
}
