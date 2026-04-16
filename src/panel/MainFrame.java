package panel;

import config.XMLConfig;
import navigation.GestionNavigation;
import config.GestionConfig;

import javax.swing.*;

//Classe modélisant la frame courante du projet.
public class MainFrame extends JFrame implements GestionNavigation {
    private BasePanel panelCourant;

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        //par défaut on affiche l'horloge
        try {
            GestionConfig config = new XMLConfig("config.xml");
            naviguer(PanelCadran.createFromConfig(this, config));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement de la configuration");
        }
        setVisible(true);
    }
    public void naviguer(BasePanel nouveauPanel){
        if (panelCourant != null){
            remove(panelCourant);
        }
        panelCourant = nouveauPanel;
        add(panelCourant);
        revalidate();
        repaint();
    }
}
