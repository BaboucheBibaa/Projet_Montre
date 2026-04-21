package panel;

import cadran.Cadran;
import cadran.CadranAiguilles;
import config.GestionConfig;
import model.sante.*;
import navigation.GestionNavigation;

import javax.swing.*;
import java.awt.*;


/**
 * Classe permettant d'afficher le contenu du cadran en fonction des données choisies par l'utilisateur.
 * Cadran Numérique ou Analogique
 * */
public class PanelCadran extends BasePanel {
    private final Cadran cadran;
    private final RythmeCardiaque rythme;
    private final Batterie batterie;
    public PanelCadran(Cadran c, GestionNavigation navigator, GestionConfig _config, Batterie _batterie, RythmeCardiaque rc, PanelProvider provider) {
        super(navigator, _config, provider);
        this.cadran = c;
        this.rythme = rc;
        this.batterie = _batterie;
        lancerHorloge();
    }

    protected void initBoutonsNavigation() {
        btnLeft.addActionListener(_ -> allerVersCouleur());
        btnRight.addActionListener(_ -> allerVersCalendrier());

        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
    }
    protected void initContenuPanel(){
        panelContenu = new JPanel(){
            //Redéfinition de classe anonyme de JPanel + surdéfinition de la méthode paintComponent
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(getBgColor());
                int centreX = getWidth() / 2;
                int centreY = getHeight() / 2;
                int radius = Math.min(getWidth(), getHeight()) / 3;
                rythme.dessiner(g, centreX, centreY+60);
                batterie.dessiner(g, 0, 0);

                cadran.setCentre(centreX, centreY);
                if (cadran instanceof CadranAiguilles ca) {
                    ca.setRadius(radius);
                }
                cadran.dessiner(g, centreX, centreY);
            }
        };
    }
    private void lancerHorloge(){
        //timer de rafraîchissement toutes les secondes
        Timer timer = new Timer(1000, _ -> {
            cadran.setHeure();
            model.time.Alarme alarme = this.getAlarme();
            java.time.LocalTime maintenant= java.time.LocalTime.now();

            if(maintenant.getSecond() == 0 && alarme.doitSonner(maintenant.getHour(),maintenant.getMinute())){
                declencherAlarme();
            }
            panelContenu.repaint();
        });
        timer.start();
    }
    private void declencherAlarme(){
        java.awt.Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(this,"C'est l'heure"+ java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")),"ALARME", JOptionPane.WARNING_MESSAGE);
    }
}