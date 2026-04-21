package panel;

import config.GestionConfig;
import model.time.Chronometre;
import navigation.GestionNavigation;

import javax.swing.*;
import java.awt.*;


/**
 * Panel utilisant {@link Chronometre} afin de pouvoir afficher le chronomètre et de pouvoir l'utiliser au sein de la montre.
 * */
public class PanelChronometre extends BasePanel{
    private final Chronometre chrono;
    private Timer timerRefresh;

    public PanelChronometre(GestionNavigation navigator, GestionConfig _config, PanelProvider provider) {
        super(navigator, _config, provider);
        chrono = new Chronometre();
    }
    public void initBoutonsNavigation() {
        btnLeft.addActionListener(_ -> {
            if (timerRefresh != null) timerRefresh.stop();
            allerVersCalendrier();
        });

        btnRight.addActionListener(_ -> {
            if (timerRefresh != null) timerRefresh.stop();
            allerVersAlarme();
        });

        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
    }
    public void initContenuPanel(){
        panelContenu = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                FontMetrics fm = g.getFontMetrics();
                String temps = chrono.FormatTemps();
                String police = getPolicy();
                g.setFont(new Font(police,Font.BOLD,30));
                int x = this.getWidth()  / 2 - fm.stringWidth(temps)-30; //-30 car offset créé avec la taille de police
                int y = (this.getHeight() / 2);

                g.drawString(temps, x, y);
            }
        };
        panelContenu.setBackground(getBgColor());

        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new FlowLayout());
        panelBoutons.setBackground(getBgColor());

        JButton debut = new JButton("Commencer");
        JButton stop = new JButton("Stop");
        JButton reset = new JButton("Reset");

        debut.addActionListener(_-> chrono.start());
        stop.addActionListener(_-> chrono.stop());
        reset.addActionListener(_-> chrono.reset());

        panelBoutons.add(debut);
        panelBoutons.add(stop);
        panelBoutons.add(reset);

        panelContenu.setLayout(new BorderLayout());
        panelContenu.add(panelBoutons, BorderLayout.SOUTH);

        timerRefresh = new Timer(1, _ -> panelContenu.repaint());
        timerRefresh.start();
    }
}
