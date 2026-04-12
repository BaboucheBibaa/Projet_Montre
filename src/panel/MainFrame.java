package panel;

import javax.swing.*;
import java.awt.*;

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

    static void main(){
        MainFrame frame = new MainFrame();
        frame.changementPanel(PanelCadran.createFromConfig(frame));
    }
}
