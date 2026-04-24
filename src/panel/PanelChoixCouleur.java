package panel;

import config.GestionConfig;
import navigation.GestionNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


/**
 * Panel permettant à l'utilisateur de choisir une couleur de background sur toute la montre.
 * */
public class PanelChoixCouleur extends BasePanel {
    public PanelChoixCouleur(GestionNavigation navigator, GestionConfig _config, PanelProvider provider) {
        super(navigator, _config, provider);
    }

    protected void initBoutonsNavigation() {
        btnLeft.setPreferredSize(new Dimension(45, 0));
        btnRight.setPreferredSize(new Dimension(45, 0));

        btnRight.addActionListener(e -> allerVersCadran());
        btnLeft.addActionListener(e -> allerVersParametrage());
        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
    }
    protected void initContenuPanel(){
        panelContenu = new JPanel(new BorderLayout());

        // Ajouter le label au-dessus
        JLabel label = new JLabel("Veuillez choisir la couleur du background");
        String police = getPolicy();
        label.setFont(new Font(police, Font.BOLD, 10));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelContenu.add(label, BorderLayout.NORTH);

        //Classe interne pour l'affichage du panel des couleurs
        class ImageCouleurs extends JPanel {
            private BufferedImage image;

            public ImageCouleurs(){
                addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        // Vérifier que l'image existe et les coordonnées sont valides
                        if (image != null && e.getX() >= 0 && e.getY() >= 0 &&
                                e.getX() < image.getWidth() && e.getY() < image.getHeight()) {

                            int rgb = image.getRGB(e.getX(), e.getY());
                            Color c = new Color(rgb);

                            setRGB(String.valueOf(c.getRed()),
                                    String.valueOf(c.getGreen()),
                                    String.valueOf(c.getBlue()));
                            repaint();
                        }
                    }
                });
            }

            private void generateImage(int width, int height) {
                image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        float hue = (float) x / width;           // 0 → 1
                        float saturation = 1.0f - ((float) y / height); // 1 → 0
                        float brightness = 1.0f;

                        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
                        image.setRGB(x, y, rgb);
                    }
                }
            }

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int width = getWidth();
                int height = getHeight();
                generateImage(width, height);

                // Afficher l'image
                g.drawImage(image, 0, 0, null);
            }

        }
        ImageCouleurs imageCouleurs = new ImageCouleurs();
        panelContenu.add(imageCouleurs, BorderLayout.CENTER);

        add(panelContenu, BorderLayout.CENTER);
    }
}
