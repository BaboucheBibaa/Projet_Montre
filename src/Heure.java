import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Heure {

    private LocalTime heure;

    private DateTimeFormatter formatter;
    Heure(){
        heure = LocalTime.now();
        formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
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