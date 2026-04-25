package config;

import java.awt.*;

import model.time.Alarme;

/**
* Interface permettant de contraindre les classes implémentant cette interface de gérer la lecture / écriture dans un fichier, peu importe son type
 * Fonctionne pour de la lecture de fichiers JSON / YAML, une classe permettant de lire ces fichiers doit implémenter GestionConfig afin de pouvoir être cohérente avec le projet.
*/
public interface GestionConfig {
    String getDateFormat();
    String getHeureFormat();
    String getClockFormat();
    String getPolicy();
    Color getBackgroundColor();
    void setHeureFormat(String format);
    void setClockFormat(String format);
    void setPolicy(String policy);
    void setDateFormat(String format);
    void setRGB(String r, String g, String b);

    Alarme getAlarme();
    void saveAlarme(Alarme a);
}
