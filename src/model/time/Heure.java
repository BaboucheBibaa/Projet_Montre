package model.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Heure {
    private LocalTime heure;
    private DateTimeFormatter formatter;
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