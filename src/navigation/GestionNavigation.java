package navigation;

import panel.BasePanel;

/**
 * Interface permettant de contraindre tout type de Panel au sein de la montre à naviguer d'une façon bien spécifique.
 * Cette méthode de navigation peut varier en fonction de l'implémentation de la fonctionnalité au sein de la montre.
 * */
public interface GestionNavigation {
    void naviguer(BasePanel panel);
}
