package model.sante;
import java.awt.*;
import java.util.Random;

public class RythmeCardiaque {
    private int bpm;
    private Random random;

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
        String texte="❤️"+bpm+"BPM";
        int textWidth = g.getFontMetrics().stringWidth(texte);

        g.drawString(texte, 2*x - g.getFontMetrics().stringWidth(texte), 14);

    }
}