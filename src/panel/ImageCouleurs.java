package panel;

import xml.XmlWriter;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ImageCouleurs extends JPanel{
    private BufferedImage image;
    private XmlWriter writer;

    ImageCouleurs(){
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int rgb = image.getRGB(e.getX(), e.getY());
                Color c = new Color(rgb);
                writer = new XmlWriter("config.xml");
                writer.setR(String.valueOf(c.getRed()));
                writer.setG(String.valueOf(c.getGreen()));
                writer.setB(String.valueOf(c.getBlue()));
                System.out.println("Couleur choisie : " + c);
                repaint();
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

        if (image == null || image.getWidth() != width || image.getHeight() != height) {
            generateImage(width, height);
        }

        g.drawImage(image, 0, 0, null);
    }

}
