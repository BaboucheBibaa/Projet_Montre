package model.date;

import xml.XmlReader;

import java.awt.*;
import java.time.LocalDate;

public class Jour {
    public void dessiner(Graphics g, int centreX, int centreY){
        LocalDate today = LocalDate.now();
        String police = "";
        String dateStr = today.toString();
        //Lecture du xml pour avoir le format de police correspondant
        try {
            XmlReader reader = new XmlReader("config.xml");
            police = reader.getPolicy();
        } catch (Exception e){
            e.printStackTrace();
        }
        g.setFont(new Font(police, Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();

        int textWidth = fm.stringWidth(dateStr);
        int x = centreX - textWidth / 2;
        int y = centreY + 40;

        g.drawString(dateStr, x, y);
    }
}
