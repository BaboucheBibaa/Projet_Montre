package panel;
import xml.XmlReader;
import xml.XmlWriter;

import javax.swing.*;
import java.awt.*;

public abstract class BasePanel extends JPanel {
    protected JPanel panelContenu;
    protected MainFrame mainFrame;
    protected XmlReader reader;
    protected XmlWriter writer;
    protected Color bgColor;
    public BasePanel(MainFrame _mainframe){
        mainFrame = _mainframe;
        setLayout(new BorderLayout());
        try {
            reader = new XmlReader("config.xml");
            writer = new XmlWriter("config.xml");
            bgColor = new Color(Integer.parseInt(reader.getR()),Integer.parseInt(reader.getG()),Integer.parseInt(reader.getB()));

        } catch (Exception e){
            e.printStackTrace();
        }
        initBoutonsNavigation();
        initContenuPanel();

        // S'assurer que panelContenu est ajouté au CENTER
        if (panelContenu != null) {
            add(panelContenu, BorderLayout.CENTER);
        }
    }
    protected void initBoutonsNavigation(){
        JButton btnLeft = new JButton("<");
        JButton btnRight = new JButton(">");
        btnLeft.setPreferredSize(new Dimension(45, 0));
        btnRight.setPreferredSize(new Dimension(45, 0));

        // ActionListener
        btnLeft.addActionListener(e -> mainFrame.changementPanel(new PanelParametres(mainFrame)));
        btnRight.addActionListener(e -> System.out.println("Bouton > cliqué"));

        // Ajouter les boutons directement sur les côtés du BasePanel
        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
    }

    protected abstract void initContenuPanel();

    protected JPanel getPanelContenu(){ return panelContenu; }
}
