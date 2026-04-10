package panel;

import cadran.Cadran;
import cadran.CadranNumerique;

import javax.swing.*;
import java.awt.*;

public class PanelParametres extends BasePanel {
    private ImageCouleurs imageCouleurs;
    public PanelParametres(MainFrame mainFrame){
        super(mainFrame);
    }
    protected void initBoutonsNavigation(){
        panelNavigation = new JPanel(new BorderLayout());
        JButton btnLeft = new JButton("<");
        JButton btnRight = new JButton(">");
        btnLeft.setPreferredSize(new Dimension(45, 45));
        btnRight.setPreferredSize(new Dimension(45, 45));

        // ActionListener
        btnRight.addActionListener(e ->
        {       Cadran nouveauCadran = new CadranNumerique(200,200);
                mainFrame.changementPanel(new PanelCadran(nouveauCadran,mainFrame));
    });

        panelNavigation.add(btnLeft, BorderLayout.WEST);
        panelNavigation.add(btnRight, BorderLayout.EAST);

        // Ajouter le panelNavigation au BasePanel
        this.add(panelNavigation, BorderLayout.NORTH);
    }


    protected void initContenuPanel(){
        panelContenu = new JPanel(new BorderLayout());
        imageCouleurs = new ImageCouleurs();
        panelContenu.add(imageCouleurs, BorderLayout.CENTER);
        add(panelContenu, BorderLayout.CENTER);
    }
}
