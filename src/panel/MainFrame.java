package panel;

import javax.swing.*;

//Classe modélisant la frame courante du projet.
public class MainFrame extends JFrame {
    private BasePanel panelCourant;

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
        //par défaut on affiche l'horloge
        changementPanel(PanelCadran.createFromConfig(this));
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
}
