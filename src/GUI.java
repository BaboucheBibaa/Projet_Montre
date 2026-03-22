import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private Cadran cadran;
    private Cadran cadran2;
    int centreX;
    int centreY;
    int radius;
    GUI(int w, int h){
        super("Montre");
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(w,h);
        this.setResizable(false);
        this.setVisible(true);
        centreX = 200;
        centreY = 200;
        radius = 200;
        //cadran = new CadranNumerique(centreX, centreY);
        cadran = new CadranAiguilles(centreX, centreY, radius);
    }
    public Cadran getCadran(){
        return cadran;
    }
    public void paint(Graphics g) {
        super.paint(g);
        //Utile car tout est exécuté en parallèle, donc le constructeur peut ne pas être appelé avant de faire paint
        //Cela génère une erreur sinon
        if (cadran != null){
            cadran.dessiner(g, centreX, centreY);
        }
    }

    public static void main() throws InterruptedException {
        GUI gui = new GUI(400, 400);
        while (true) {
            gui.getCadran().getHeure().setHeure();
            Thread.sleep(1000);
            gui.repaint();
        }
    }

}
