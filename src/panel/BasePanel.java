package panel;

import xml.XmlReader;
import xml.XmlWriter;

import javax.swing.*;
import java.awt.*;

public abstract class BasePanel extends JPanel {
    protected JPanel panelContenu;
    protected MainFrame mainFrame;
    protected Color bgColor;
    protected XmlReader reader;
    protected XmlWriter writer;
    protected JButton btnRight;
    protected JButton btnLeft;
    public BasePanel(MainFrame _mainframe){
        mainFrame = _mainframe;
        btnLeft = new JButton("<");
        btnRight = new JButton(">");
        setLayout(new BorderLayout());

        try {
            reader = new XmlReader("config.xml");
            writer = new XmlWriter("config.xml");
        } catch (Exception e){
            e.printStackTrace();
        }
        bgColor = new Color(reader.getR(),reader.getG(),reader.getB());
        initBoutonsNavigation();
        initContenuPanel();
        // S'assurer que panelContenu est ajouté au CENTER
        if (panelContenu != null) {
            add(panelContenu, BorderLayout.CENTER);
        }
    }

    protected abstract void initBoutonsNavigation();

    protected abstract void initContenuPanel();

    protected JPanel getPanelContenu(){ return panelContenu; }
}
