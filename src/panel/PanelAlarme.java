package panel;

import config.GestionConfig;
import config.XMLConfig;
import model.time.Alarme;
import navigation.GestionNavigation;
import javax.swing.*;
import java.awt.*;


public class PanelAlarme extends BasePanel {
    private Alarme alarme;

    public PanelAlarme(GestionNavigation navigator , GestionConfig _config){
        super(navigator, _config); // on les appellepr initialiser la navig
        /*if(getConfig() instanceof XMLConfig){ // on vérifie si la cinfig reçue est bien de type XMLConfig
            this.alarme=((XMLConfig) getConfig()).getAlarme(); // si on on récup l'alarme dans le fichier XML
            System.out.println("Test");
        }else{
            this.alarme= new Alarme();
            System.out.println("8h");
        }
        System.out.println("9h");*/
    }

    

    protected void initContenuPanel(){
        panelContenu = new JPanel(new GridLayout(4,1,10,10)); // creer un panel ayant une grille de 4 ligne et 1 colonne
        panelContenu.setBackground(getBgColor());
        this.alarme= this.getAlarme();
        // JSpinner permet de choisir un nombre avec les flèches haut et bas

        JSpinner spinnerHeure = new JSpinner(new SpinnerNumberModel(alarme.getHeure(), 0, 23, 1));
        JSpinner spinnerMin = new JSpinner(new SpinnerNumberModel(alarme.getMinute(), 0, 59, 1));
        JCheckBox checkactive= new JCheckBox("Alarme Activée", alarme.isActive());
        JButton btnSauver = new JButton("Sauvegarder");

        btnSauver.addActionListener(e ->{
            //met à jour l'alarme avec les new valeurs
            alarme.setHeure((int)spinnerHeure.getValue());
            alarme.setMinute((int)spinnerMin.getValue());
            alarme.setActive(checkactive.isSelected());
            getConfig().saveAlarme(alarme);
            JOptionPane.showMessageDialog(this, "Alarme Enregistrée !"); //Affiche fenetre de confirmation
        });

        JPanel pTime = new JPanel();
        pTime.setBackground(getBgColor());
        pTime.add(new JLabel("H :"));
        pTime.add(spinnerHeure);
        pTime.add(new JLabel("Min :"));
        pTime.add(spinnerMin);

        //panelContenu.add(new JLabel("Heure (0-23) : ", SwingConstants.CENTER));
        //panelContenu.add(spinnerHeure);
        panelContenu.add(pTime);
        panelContenu.add(checkactive);
        panelContenu.add(btnSauver);

    }

    protected void initBoutonsNavigation(){
            btnLeft.addActionListener(e-> this.naviguer(new PanelChronometre(getNavigator(), getConfig())));
            this.add(btnLeft,BorderLayout.WEST);
        }

}
