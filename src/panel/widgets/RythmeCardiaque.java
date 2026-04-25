package panel.widgets;
import drawable.Drawable;

import java.awt.*;
import java.util.Random;
/**
 * Classe permettant de gérer le fonctionnement d'un rythme cardiaque fictif au sein de la montre ainsi que de le dessiner sur un JPanel
 * Via l'implémentation de l'interface Drawable
 * */

public class RythmeCardiaque implements Drawable {
    private int bpm;
    private final Random random;

    public  RythmeCardiaque(){
        this.bpm=75;
        this.random= new Random();
    }

    public void actualiser(){
        int variation = random.nextInt(10)-2;
        bpm+=variation;

        if(bpm < 40){ bpm=40;}
        if(bpm > 160){ bpm=160;}
    }

    public void dessiner(Graphics g , int x , int y){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial",Font.BOLD,14));
        String texte="❤"+bpm+"BPM";

        g.drawString(texte, 2*x - g.getFontMetrics().stringWidth(texte), 14);

    }
}