package panel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ImageCouleurs extends JPanel{
    private BufferedImage image;
    ImageCouleurs(){
        int width = 300;
        int height = 300;

        // Création de l'image avec toutes les couleurs HSB
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
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getX() >= 0 && e.getX() < width && e.getY() >= 0 && e.getY() < height){
                    int rgb = image.getRGB(e.getX(), e.getY());
                    Color c = new Color(rgb);
                    System.out.println("Couleur choisie : " + c);
                    // Exemple : changer le fond du panel avec la couleur choisie
                    setBackground(c);
                    repaint();
                }
            }
        });
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

}
