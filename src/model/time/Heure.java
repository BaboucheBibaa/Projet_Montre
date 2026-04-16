package model.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import config.GestionConfig;

public class Heure {
    private LocalTime heure;
    private DateTimeFormatter formatter;
    private GestionConfig config;
    public Heure(GestionConfig _config){
        heure = LocalTime.now();
        config = _config;
        try {
            String dateFormat = config.getDateFormat();

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


    public LocalTime getHeure() {
        return heure;
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