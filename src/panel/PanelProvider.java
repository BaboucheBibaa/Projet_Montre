package panel;

import config.GestionConfig;
import navigation.GestionNavigation;

/**
 * Interface de fournisseur de panneaux (Factory Pattern).
 *
 * PanelProvider permet aux panels de dépendre d'une abstraction plutôt que d'une classe concrète.
 * Afin de ne connaître que l'interface, pas l'implémentation, lors de l'utilisation des méthodes.
 */
public interface PanelProvider {
    BasePanel creerPanelCadran(GestionNavigation navigator, GestionConfig config);
    BasePanel creerPanelChoixCouleur(GestionNavigation navigator, GestionConfig config);
    BasePanel creerPanelParametrage(GestionNavigation navigator, GestionConfig config);
    BasePanel creerPanelCalendrier(GestionNavigation navigator, GestionConfig config);
    BasePanel creerPanelChronometre(GestionNavigation navigator, GestionConfig config);
    BasePanel creerPanelAlarme(GestionNavigation navigator, GestionConfig config);
}
