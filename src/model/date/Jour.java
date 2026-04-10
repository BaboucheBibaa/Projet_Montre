package model.date;

import java.awt.*;
import java.time.LocalDate;

public class Jour {
    public void dessiner(Graphics g, int centreX, int centreY){
        LocalDate today = LocalDate.now();
        String dateStr = today.toString(); // ou format personnalisé

        g.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();

        int textWidth = fm.stringWidth(dateStr);
        int x = centreX - textWidth / 2;
        int y = centreY + 40; // ton offset vertical

        g.drawString(dateStr, x, y);
    }
}
