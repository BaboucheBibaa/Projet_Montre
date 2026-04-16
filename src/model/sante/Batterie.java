package model.sante;
import drawable.Drawable;

import java.awt.*;

public class Batterie implements Drawable {
    private int niveau;

    public Batterie(){
        this.niveau = 100;
    }

    public void actualiser(){
        if(Math.random() > 0.99 && niveau >0){
            niveau--;
        }
    }

    public void dessiner(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 30, 15);
        g.fillRect(x+30, y+4, 3, 7);

        if(niveau >20){
            g.setColor(Color.GREEN);
        }else{
            g.setColor(Color.RED);
        }

        int largeurInterne=(int)(28*(niveau/100.0));
        g.fillRect(x+1, y+1, largeurInterne, 13);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.PLAIN,10));
        g.drawString(niveau+ "%", x+35, y+12);
    }
}