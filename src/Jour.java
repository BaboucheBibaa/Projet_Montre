import java.awt.*;
import java.time.LocalDate;
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

    public void dessiner(Graphics g, int centreX, int centreY){
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString(getAujourdhui().toString(), centreX-40, centreY+65);
    }
}
