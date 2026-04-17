package model.time;
import java.time.LocalTime;

public class Alarme {
    private int heure;
    private LocalTime heureActuelle;
    private int minute;
    private boolean active;

    public Alarme(){
        this.heure= 0;
        this.minute=0;
        this.active=false;
    }

    public boolean doitSonner(LocalTime heureActuelle){
        return active && 
                heureActuelle.getHour() == heure &&
                heureActuelle.getMinute() == minute &&
                heureActuelle.getSecond() == 0;
    }



    public int getHeure(){return heure;}
    public void setHeure(int h){this.heure=h;}
    public int getMinute(){return minute;}
    public void setMinute(int min){this.minute=min;}

    public void setActive(boolean active){this.active = active;}    
    public boolean isActive(){return active;}

}
