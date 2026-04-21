package drawable;

import java.awt.*;
/**
 * Interface permettant de contraindre chaque classe qui l'implémente à devoir faire une méthode permettant de dessiner
 * Utile afin de contraindre un Cadran à se dessiner une Batterie.*/
public interface Drawable {
    void dessiner(Graphics g, int centreX, int centreY);
}
