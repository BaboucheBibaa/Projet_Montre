package panel;

import cadran.Cadran;
import cadran.CadranAiguilles;
import cadran.CadranNumerique;

import javax.swing.*;
import java.awt.*;

public abstract class BasePanel extends JPanel {
    protected JPanel panelNavigation;
    protected JPanel panelContenu;
    protected MainFrame mainFrame;
    public BasePanel(MainFrame _mainframe){
        mainFrame = _mainframe;
        setLayout(new BorderLayout());
        initBoutonsNavigation();
        initContenuPanel();
        // S'assurer que panelContenu est ajouté au CENTER
        if (panelContenu != null) {
            add(panelContenu, BorderLayout.CENTER);
        }
    }
    protected void initBoutonsNavigation(){
        panelNavigation = new JPanel(new BorderLayout());
        JButton btnLeft = new JButton("<");
        JButton btnRight = new JButton(">");
        btnLeft.setPreferredSize(new Dimension(45, 45));
        btnRight.setPreferredSize(new Dimension(45, 45));

        // ActionListener
        btnLeft.addActionListener(e -> {
            mainFrame.changementPanel(new PanelParametres(mainFrame));
        });
        btnRight.addActionListener(e -> System.out.println("Bouton > cliqué"));

        panelNavigation.add(btnLeft, BorderLayout.WEST);
        panelNavigation.add(btnRight, BorderLayout.EAST);

        // Ajouter le panelNavigation au BasePanel
        this.add(panelNavigation, BorderLayout.NORTH);
    }

    protected abstract void initContenuPanel();

    protected JPanel getPanelContenu(){ return panelContenu; }
}
