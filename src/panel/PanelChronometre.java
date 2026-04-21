package panel;

import config.GestionConfig;
import model.time.Chronometre;
import navigation.GestionNavigation;

import javax.swing.*;
import java.awt.*;

public class PanelChronometre extends BasePanel{
    private Chronometre chrono;
    private Timer timerRefresh;

    public PanelChronometre(GestionNavigation navigator, GestionConfig _config){
        super(navigator,_config);
        chrono = new Chronometre();
    }

    public void initBoutonsNavigation(){
        btnLeft.addActionListener(e -> {
            if (timerRefresh != null) timerRefresh.stop();
            this.naviguer(new PanelCalendrier(getNavigator(),getConfig()));
        });

        btnRight.addActionListener(e -> {
            if (timerRefresh != null) timerRefresh.stop();
            this.naviguer(new PanelAlarme(getNavigator(),getConfig()));
        });

        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
    }

    public void initContenuPanel() {
        // 1. On crée le panelContenu avec un GridBagLayout
        panelContenu = new JPanel(new GridBagLayout());
        panelContenu.setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH; // Permet aux éléments de prendre de la place
        gbc.insets = new Insets(10, 10, 10, 10);

        // 2. Le panel qui dessine le temps
        JPanel panelTexte = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                String temps = chrono.FormatTemps();
                g.setFont(new Font(getPolicy(), Font.BOLD, 30));
                FontMetrics fm = g.getFontMetrics();
                int x = (this.getWidth() - fm.stringWidth(temps)) / 2;
                int y = (this.getHeight() / 2) + (fm.getAscent() / 2);
                g.setColor(Color.BLACK);
                g.drawString(temps, x, y);
            }
        };
        panelTexte.setOpaque(false);
        panelTexte.setPreferredSize(new Dimension(300, 100));
        panelContenu.add(panelTexte, gbc);

        // 3. Le panel des boutons
        gbc.gridy = 1;
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.setOpaque(false);

        JButton debut = new JButton("Commencer");
        JButton stop = new JButton("Stop");
        JButton reset = new JButton("Reset");

        debut.addActionListener(e -> chrono.start());
        stop.addActionListener(e -> chrono.stop());
        reset.addActionListener(e -> chrono.reset());

        panelBoutons.add(debut);
        panelBoutons.add(stop);
        panelBoutons.add(reset);

        panelContenu.add(panelBoutons, gbc);

        // 4. IMPORTANT : Ajouter le panelContenu au BasePanel
        // Comme BasePanel hérite de BorderLayout, il faut s'assurer qu'il est bien ajouté au centre
        this.add(panelContenu, BorderLayout.CENTER);

        timerRefresh = new Timer(50, e -> panelContenu.repaint());
        timerRefresh.start();
        
        // Force la mise à jour de l'affichage
        panelContenu.revalidate();
        panelContenu.repaint();
    }
}
