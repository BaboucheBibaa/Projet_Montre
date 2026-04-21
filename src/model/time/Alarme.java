package model.time;


/**
 * Classe permettant de gérer un système d'alarme unique au sein de la montre
 * */
public class Alarme {
    private int heure;
    private int minute;
    private boolean active;

    public Alarme(){
        this.heure= 0;
        this.minute=0;
        this.active=false;
    }

    public boolean doitSonner(int h, int m){
        return active && 
                (this.heure == h)  &&
                (this.minute == m) ;
    }

    public int getHeure(){return heure;}
    public void setHeure(int h){this.heure=h;}
    public int getMinute(){return minute;}
    public void setMinute(int min){this.minute=min;}

    public void setActive(boolean active){this.active = active;}    
    public boolean isActive(){return active;}

}
