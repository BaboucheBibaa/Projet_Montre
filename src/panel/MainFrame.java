package panel;

import cadran.Cadran;
import cadran.CadranAiguilles;

import javax.swing.*;

public class MainFrame extends JFrame {
    private BasePanel panelCourant;

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void changementPanel(BasePanel nouveauPanel){
        if (panelCourant != null){
            remove(panelCourant);
        }
        panelCourant = nouveauPanel;
        add(panelCourant);
        revalidate();
        repaint();
    }

    public static void main(String[] args){
        MainFrame frame = new MainFrame();
        Cadran c = new CadranAiguilles(400,400,400);
        frame.changementPanel(new PanelCadran(c,frame));
    }
}
