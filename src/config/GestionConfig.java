package config;

import java.awt.*;

import model.time.Alarme;

public interface GestionConfig {
    String getDateFormat();
    String getClockFormat();
    String getPolicy();
    Color getBackgroundColor();
    void setDateFormat(String format);
    void setClockFormat(String format);
    void setPolicy(String policy);
    void setRGB(String r, String g, String b);

    public Alarme getAlarme();
    public void saveAlarme(Alarme a);
}
