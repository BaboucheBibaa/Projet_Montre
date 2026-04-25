package model.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * Classe permettant de récupérer et traiter l'heure actuelle sous différents formats afin de pouvoir l'utiliser sur la montre.
 * */
public class Heure {
    private LocalTime heure;
    private final DateTimeFormatter formatter;
    public Heure(DateTimeFormatter _formatter) {
        heure = LocalTime.now();
        formatter = _formatter;
    }

    public LocalTime getHeure() {
        return heure;
    }
    public void setHeure() {
        this.heure = LocalTime.now();
    }

    public String toString() {
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