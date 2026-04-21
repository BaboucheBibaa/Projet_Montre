package panel;

import config.GestionConfig;
import navigation.GestionNavigation;

import javax.swing.*;
import java.awt.*;

public class PanelParametrage extends BasePanel {
    public PanelParametrage(GestionNavigation navigator, GestionConfig _config){
        super(navigator, _config);
    }
    public void initBoutonsNavigation(){
        btnRight.addActionListener(e -> this.naviguer(new PanelChoixCouleur(getNavigator(),getConfig())));
        this.add(btnRight, BorderLayout.EAST);
    }
    protected void initContenuPanel() {
        panelContenu = new JPanel();
        panelContenu.setBackground(getBgColor());
        panelContenu.setLayout(new BoxLayout(panelContenu, BoxLayout.Y_AXIS));

        String typeActuel = getClockFormat();
        String policeActuelle = getPolicy();
        String formatHeureActuelle = getHeureFormat();
        String formatDateActuelle = getDateFormat();

        String[] typeAffiche = {"Horloge à Aiguilles", "Horloge Numérique"};
        String[] policeAffiche = {"Monospaced", "Arial", "Sans Sérif"};
        String[] formatHeureAffichee = {"12 Heures", "24 Heures"};
        String[] formatDateAffichee = {"Jour-Mois-Annee", "Annee-Mois-Jour","Mois-Jour-Annee"};

        String[] type = {"analog", "numeric"};
        String[] police = {"MONOSPACED", "ARIAL", "SANS_SERIF"};
        String[] formatHeure = {"12", "24"};
        String[] formatDate = {"dd-MM-yyyy","yyyy-MM-dd","MM-dd-yyyy"};

        JComboBox<String> comboType = new JComboBox<>(typeAffiche);
        JComboBox<String> comboPolice = new JComboBox<>(policeAffiche);
        JComboBox<String> comboFormatHeure = new JComboBox<>(formatHeureAffichee);
        JComboBox<String> comboFormatDate = new JComboBox<>(formatDateAffichee);

        // Sélectionner les valeurs par défaut selon l'indice
        int indexType = -1;
        for (int i = 0; i < type.length; i++) {
            if (type[i].equals(typeActuel)) {
                indexType = i;
                break;
            }
        }
        if (indexType >= 0) {
            comboType.setSelectedIndex(indexType);
        }

        int indexPolice = -1;
        for (int i = 0; i < police.length; i++) {
            if (police[i].equals(policeActuelle)) {
                indexPolice = i;
                break;
            }
        }
        if (indexPolice >= 0) {
            comboPolice.setSelectedIndex(indexPolice);
        }

        int indexFormatHeure = -1;
        for (int i = 0; i < formatHeure.length; i++) {
            if (formatHeure[i].equals(formatHeureActuelle)) {
                indexFormatHeure = i;
                break;
            }
        }
        if (indexFormatHeure >= 0) {
            comboFormatHeure.setSelectedIndex(indexFormatHeure);
        }

        int indexFormatDate = -1;
        for (int i = 0; i < formatDate.length; i++){
            if (formatDate[i].equals(formatDateActuelle)){
                indexFormatDate = i;
                break;
            }
        }
        if (indexFormatDate >=0){
            comboFormatDate.setSelectedIndex(indexFormatDate);
        }


        JLabel labelPolice = new JLabel("Police d'écriture");
        JLabel labelHorloge = new JLabel("Format de l'Horloge");
        JLabel labelFormatHeure = new JLabel("Format d'affichage de l'heure");
        JLabel labelFormatDate = new JLabel("Format d'affichage de la date");

        labelPolice.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelHorloge.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelFormatHeure.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelFormatDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboType.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboPolice.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboFormatHeure.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboFormatDate.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ajouter un ActionListener pour écrire dans le xml
        comboType.addActionListener(e -> {
            int index = comboType.getSelectedIndex();
            if (index >= 0 && index < type.length) {
                String valueToSave = type[index];
                setClockFormat(valueToSave);
            }
        });
        comboPolice.addActionListener(e -> {
            int index = comboPolice.getSelectedIndex();
            if (index >= 0 && index < police.length) {
                String valueToSave = police[index];
                setPolicy(valueToSave);
            }
        });
        comboFormatHeure.addActionListener(e -> {
            int index = comboFormatHeure.getSelectedIndex();
            if (index >= 0 && index < formatHeure.length) {
                String valueToSave = formatHeure[index];
                setHeureFormat(valueToSave);
            }
        });

        comboFormatDate.addActionListener(e -> {
            int index = comboFormatDate.getSelectedIndex();
            if (index >= 0 && index < formatDate.length) {
                String valueToSave = formatDate[index];
                setDateFormat(valueToSave);
            }
        });

        panelContenu.add(Box.createVerticalGlue());
        panelContenu.add(labelHorloge);
        panelContenu.add(Box.createVerticalStrut(30));
        panelContenu.add(comboType);
        panelContenu.add(Box.createVerticalGlue());
        panelContenu.add(labelPolice);
        panelContenu.add(Box.createVerticalStrut(30));
        panelContenu.add(comboPolice);
        panelContenu.add(Box.createVerticalGlue());
        panelContenu.add(labelFormatHeure);
        panelContenu.add(Box.createVerticalStrut(30));
        panelContenu.add(comboFormatHeure);
        panelContenu.add(Box.createVerticalGlue());
        panelContenu.add(labelFormatDate);
        panelContenu.add(Box.createVerticalStrut(30));
        panelContenu.add(comboFormatDate);

        this.add(panelContenu, BorderLayout.CENTER);
    }
}
