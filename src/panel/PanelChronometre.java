package panel;

import model.time.Chronometre;

import javax.swing.*;
import java.awt.*;

public class PanelChronometre extends BasePanel{
    private Chronometre chrono;
    private Timer timerRefresh;

    public PanelChronometre(MainFrame mainFrame){
        super(mainFrame);
        chrono = new Chronometre();
    }

    public void initBoutonsNavigation(){
        btnLeft.addActionListener(e -> {
            if (timerRefresh != null) timerRefresh.stop();
            mainFrame.changementPanel(new PanelCalendrier(mainFrame));
        });
        this.add(btnLeft, BorderLayout.WEST);
    }

    public void initContenuPanel(){
        panelContenu = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                FontMetrics fm = g.getFontMetrics();
                String temps = chrono.FormatTemps();
                String police = reader.getPolicy();
                g.setFont(new Font(police,Font.BOLD,30));
                int x = (this.getWidth() - fm.stringWidth(temps)) / 15 / 2 ;
                int y = ((this.getHeight() - fm.getHeight()) / 2);

                g.drawString(temps, x, y);
            }
        };
        panelContenu.setBackground(bgColor);

        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new FlowLayout());

        JButton debut = new JButton("Commencer");
        JButton stop = new JButton("Stop");
        JButton reset = new JButton("Reset");

        debut.addActionListener(e-> chrono.start());
        stop.addActionListener(e-> chrono.stop());
        reset.addActionListener(e-> chrono.reset());

        panelBoutons.add(debut);
        panelBoutons.add(stop);
        panelBoutons.add(reset);

        panelContenu.setLayout(new BorderLayout());
        panelContenu.add(panelBoutons, BorderLayout.SOUTH);

        timerRefresh = new Timer(1, e -> panelContenu.repaint());
        timerRefresh.start();
    }
}
