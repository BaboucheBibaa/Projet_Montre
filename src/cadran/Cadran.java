package cadran;

import config.GestionConfig;
import model.time.Heure;
import xml.XmlReader;

import java.awt.*;
import java.time.LocalDate;

public abstract class Cadran {
    protected Heure heure;
    protected int centreX;
    protected int centreY;
    protected GestionConfig config;
    public Cadran(int _centreX, int _centreY, GestionConfig _config){
        config = _config;
        heure = new Heure(config);
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
        String police = "";
        String dateStr = today.toString();
        //Lecture du xml pour avoir le format de police correspondant
        try {
            police = config.getPolicy();
        } catch (Exception e){
            e.printStackTrace();
        }
        g.setFont(new Font(police, Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();

        int textWidth = fm.stringWidth(dateStr);
        int x = centreX - textWidth / 2;
        int y = centreY + 40;

        g.drawString(dateStr, x, y);
    }
    public abstract void dessiner(Graphics g, int centreX, int centreY);
    public void setCentre(int x, int y) {
        this.centreX = x;
        this.centreY = y;
    }
}
