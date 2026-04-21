package cadran;

import config.GestionConfig;
import model.time.Heure;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Classe abstraite modélisant un cadran d'horloge.
 * Cette classe fournit les fonctionnalités de base pour afficher une horloge,
 * incluant la gestion du temps, de la date et du positionnement.
 * Les classes filles doivent implémenter la méthode {@link #dessiner(Graphics, int, int)}
 * pour définir leur propre rendu visuel.
 */
public abstract class Cadran {
    protected Heure heure;

    protected int centreX;
    protected int centreY;
    protected GestionConfig config;
    private final String dateFormat;

    /**
     * Constructeur du Cadran.
     * Initialise le cadran avec les coordonnées et la configuration fournie.
     * Configure également le format de l'heure et de la date selon les paramètres.
     *
     * @param _centreX la coordonnée X du centre du cadran
     * @param _centreY la coordonnée Y du centre du cadran
     * @param _config la configuration globale contenant les formats de date/heure
     */
    public Cadran(int _centreX, int _centreY, GestionConfig _config){
        config = _config;
        String heureFormat = config.getHeureFormat();
        dateFormat = config.getDateFormat();
        DateTimeFormatter formatter;
        if ("12".equals(heureFormat)) {
            formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        } else {
            formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        }
        // Passe le formatter à Heure
        heure = new Heure(formatter);
        centreX = _centreX;
        centreY = _centreY;
    }

    /**
     * Permet de dessiner la date du jour au sein du panel.
     * */
    public void dessinerJour(Graphics g, int centreX, int centreY){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern(dateFormat);
        String text = today.format(formatters);
        String police = "";

        //Lecture du xml pour avoir le format de police correspondant
        try {
            police = config.getPolicy();
        } catch (Exception e){
            e.printStackTrace();
        }
        g.setFont(new Font(police, Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();

        int textWidth = fm.stringWidth(text);
        int x = centreX - textWidth / 2;
        int y = centreY + 40;

        g.drawString(text, x, y);
    }

    public abstract void dessiner(Graphics g, int centreX, int centreY);


    //getters / setters
    public Heure getHeure() {
        return heure;
    }
    public void setHeure(){
        heure.setHeure();
    }
    public String getTemps(){
        return heure.getTemps();
    }
    public void setCentre(int x, int y) {
        this.centreX = x;
        this.centreY = y;
    }
}
