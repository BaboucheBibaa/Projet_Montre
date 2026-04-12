package cadran;

import model.date.Heure;
import xml.XmlReader;

import java.awt.*;

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
    public void setHeure(){ heure.setHeure();}
    public abstract void dessiner(Graphics g, int centreX, int centreY);
    public void setCentre(int x, int y) {
        this.centreX = x;
        this.centreY = y;
    }
}
