import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Jour {
    private int jour;
    private int mois;
    private int annee;
    private LocalDate aujourdhui;
    private DateTimeFormatter formatter;

    Jour(){
        aujourdhui = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        jour = aujourdhui.getDayOfMonth();
        mois = aujourdhui.getMonthValue();
        annee = aujourdhui.getYear();

    }

    public int getJour(){
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public LocalDate getAujourdhui() {
        return aujourdhui;
    }


    public static void main(){
        Jour journee = new Jour();
        System.out.println(journee.getJour()+"/"+journee.getMois()+"/"+journee.getAnnee());
        System.out.println(journee.getAujourdhui());
        System.out.println("tEST");
    }
}
