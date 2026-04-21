package config;

import xml.XmlReader;
import xml.XmlWriter;

import java.awt.*;

import model.time.Alarme;

public class XMLConfig implements GestionConfig {
    private XmlReader reader;
    private XmlWriter writer;
    public XMLConfig(String filename) throws Exception {
        this.reader = new XmlReader(filename);
        this.writer = new XmlWriter(filename);
    }
    public String getDateFormat(){
        return reader.getDateFormat();
    }
    public String getClockFormat(){
        return reader.getClockFormat();
    }
    public String getPolicy(){
        return reader.getPolicy();
    }
    public Color getBackgroundColor() {
        return new Color(reader.getR(), reader.getG(), reader.getB());
    }
    public void setDateFormat(String format){
        writer.setDateFormat(format);
    }
    public void setClockFormat(String format){
        writer.setClockFormat(format);
    }
    public void setPolicy(String format){
        writer.setPolicy(format);
    }
    public void setRGB(String r, String g, String b){
        writer.setRGB(r,g,b);
    }

    public Alarme getAlarme(){
        Alarme a = new Alarme();
        a.setHeure(reader.getAlarmeHeure());
        a.setMinute(reader.getAlarmeMinute());
        a.setActive(reader.isAlarmeActive());
        return a;
    }

    public void saveAlarme(Alarme a){
        writer.setAlarme(a.getHeure(),a.getMinute(), a.isActive());
    }

    //@Override
    public String getFormeBoitier(){
        return reader.getTagValue("forme","rond");
    }


    //@Override
    public void setFormeBoitier(String forme){
        writer.setFormeBoitier(forme);
    }

}
