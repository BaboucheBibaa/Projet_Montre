package panel;

import javax.swing.*;
import java.awt.*;

public class PanelParametres extends BasePanel {
    public PanelParametres(MainFrame mainFrame){
        super(mainFrame);
    }
    protected void initBoutonsNavigation(){
        JButton btnLeft = new JButton("<");
        JButton btnRight = new JButton(">");
        btnLeft.setPreferredSize(new Dimension(45, 0));
        btnRight.setPreferredSize(new Dimension(45, 0));

        // ActionListener
        btnRight.addActionListener(e -> mainFrame.changementPanel(PanelCadran.createFromConfig(mainFrame)));

        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
    }


    protected void initContenuPanel(){
        panelContenu = new JPanel(new BorderLayout());
        ImageCouleurs imageCouleurs;

        // Ajouter le label au-dessus
        JLabel label = new JLabel("Veuillez choisir la couleur du background");
        String police = reader.getPolicy();
        label.setFont(new Font(police, Font.BOLD, 10));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelContenu.add(label, BorderLayout.NORTH);
        // Ajouter l'image au centre
        imageCouleurs = new ImageCouleurs();
        panelContenu.add(imageCouleurs, BorderLayout.CENTER);

        add(panelContenu, BorderLayout.CENTER);
    }
}
