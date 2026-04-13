package model.date;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import xml.XmlReader;

public class Heure {

    private LocalTime heure;

    private DateTimeFormatter formatter;
    public Heure(){
        heure = LocalTime.now();
        try {
            XmlReader reader = new XmlReader("config.xml");
            String dateFormat = reader.getDateFormat();

            if("12".equals(dateFormat)){
                formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            } else {
                formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            }
        } catch(Exception e){
            // En cas d'erreur, utiliser le format 24h par défaut
            formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        }
    }

    public void setHeure() {
        this.heure = LocalTime.now();
    }

    public String getTemps() {
        return heure.format(formatter);
    }

    public int getSecondes() {
        return heure.getSecond();
    }

    public int getMinutes() {
        return heure.getMinute();
    }

    public int getHeures() {
        return heure.getHour();
    }
}