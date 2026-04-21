package config;

import java.awt.*;

import model.time.Alarme;

public interface GestionConfig {
    String getDateFormat();
    String getHeureFormat();
    String getClockFormat();
    String getPolicy();
    Color getBackgroundColor();
    void setHeureFormat(String format);
    void setClockFormat(String format);
    void setPolicy(String policy);
    void setDateFormat(String format);
    void setRGB(String r, String g, String b);

    Alarme getAlarme();
    void saveAlarme(Alarme a);
}
