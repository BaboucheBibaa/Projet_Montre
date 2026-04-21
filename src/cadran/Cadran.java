package cadran;

import config.GestionConfig;
import model.time.Heure;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Cadran {
    protected Heure heure;
    protected int centreX;
    protected int centreY;
    protected GestionConfig config;
    private String dateFormat;
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

    public Heure getHeure() {
        return heure;
    }

    public int getCentreX() {
        return centreX;
    }

    public int getCentreY() {
        return centreY;
    }

    public void setHeure(){
        heure.setHeure();
    }
    public String getTemps(){
        return heure.getTemps();
    }

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
    public void setCentre(int x, int y) {
        this.centreX = x;
        this.centreY = y;
    }
}
