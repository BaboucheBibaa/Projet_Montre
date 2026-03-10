import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {


    public Heure heure;
    public Jour journee;
    GUI(int w, int h){
        super("Montre");
        heure = new Heure();
        journee = new Jour();

        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(w,h);
        this.setResizable(false);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        super.paint(g);

        int centreX = 200;
        int centreY = 200;
        int longueur = 100;
        int secondes = heure.getSecondes();

        double angle = Math.toRadians(secondes * 6 - 90);

        int x = centreX + (int)(longueur * Math.cos(angle));
        int y = centreY + (int)(longueur * Math.sin(angle));

        g.drawLine(centreX, centreY, x, y);
    }

    public static void main() throws InterruptedException{
        GUI gui = new GUI(400,400);

        while (true){
            gui.heure.setHeure();
            Thread.sleep(1000);
            gui.repaint();
        }
    }

}
