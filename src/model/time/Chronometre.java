package model.time;

public class Chronometre {
    private long debut;
    private long fin;
    private long tempsAccumule;
    private boolean estLance;
    public Chronometre(){
        estLance = false;
        debut = 0;
        fin = 0;
        tempsAccumule = 0;
    }
    public boolean start(){
        //si le chrono est déjà lancé, on ne peut pas le relancer
        if (estLance){
            return false;
        }
        //sinon, chrono pas lancé donc on le lance et on renvoie le fait que le chrono a été lancé
        estLance = true;
        debut = System.nanoTime();
        return true;
    }

    public boolean stop(){
        //On ne peut stopper un chrono pas lancé
        if (!estLance){
            return false;
        }
        //sinon on stoppe le chrono et on stocke le moment ou le chrono a été stoppé et on renvoie si le chrono a été stoppé ou non
        fin = System.nanoTime();
        tempsAccumule += (fin - debut);
        estLance = false;
        return true;
    }

    //Retourne le temps actuel du chronomètre s'il n'est pas terminé, sinon retourne le temps du dernier lancement avant reset (0 par défaut)
    public long tempsEcoule() {
        if (estLance) {
            // temps en cours + temps déjà accumulé
            return tempsAccumule + (System.nanoTime() - debut);
        }
        return tempsAccumule;
    }

    public void reset(){
        //reset possible uniquement si le chrono est arrêté
        fin = 0;
        debut = 0;
        tempsAccumule = 0;
        estLance = false;
    }


    public String FormatTemps(){
        long tempsActuel = tempsEcoule();
        // conversion en millisecondes
        long tempsMS = tempsActuel / 1000000;

        // millisecondes -> heures
        long tempsHeures = tempsMS / (1000 * 60 * 60);

        // millisecondes -> minutes
        long tempsMinutes = (tempsMS % (1000 * 60 * 60)) / (1000 * 60);

        // millisecondes -> secondes
        long tempsSecondes = (tempsMS % (1000 * 60)) / 1000;

        // millisecondes restantes
        long tempsMillisecondes = tempsMS % 1000;

        //Formatage du string pour affichage lisible
        return String.format("%02d:%02d:%02d:%03d",
                tempsHeures, tempsMinutes, tempsSecondes, tempsMillisecondes);
    }
}