package cadran;

import model.Heure;
import xml.XmlReader;

import java.awt.*;
import java.time.LocalDate;

public abstract class Cadran {
    protected Heure heure;
    protected int centreX;
    protected int centreY;
    protected XmlReader reader;
    public Cadran(int _centreX, int _centreY){
        heure = new Heure();
        centreX = _centreX;
        centreY = _centreY;
        //Lecteur du fichier xml permettant d'afficher la bonne police d'écriture au sein de la montre
        try{
            reader = new XmlReader("config.xml");
        } catch (Exception e){
            e.printStackTrace();
        }
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
            XmlReader reader = new XmlReader("config.xml");
            police = reader.getPolicy();
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
