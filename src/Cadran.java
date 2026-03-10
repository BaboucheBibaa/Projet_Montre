public class Cadran {
    private AiguilleHeure AigHeure;
    private AiguilleMinute AigMinutes;
    private AiguilleSeconde AigSecondes;
    private int[] centre;
    private Heure heure;
    private Jour jour;

    Cadran(int centreX, int centreY){
        centre = new int[2];
        centre[0] = centreX;
        centre[1] = centreY;
        heure = new Heure();
        jour = new Jour();
        AigHeure = new AiguilleHeure(40,centre[0],centre[1]);
        AigMinutes = new AiguilleMinute(60,centre[0],centre[1]);
        AigSecondes = new AiguilleSeconde(90,centre[0],centre[1]);
    }
}
