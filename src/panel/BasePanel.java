package panel;

import config.GestionConfig;
import config.XMLConfig;
import navigation.GestionNavigation;

import model.time.Alarme;

import javax.swing.*;

import cadran.CadranAiguilles;
import java.awt.*;


//Classe modélisant le contenu du panel courant affiché au sein de la frame courante du projet.
public abstract class BasePanel extends JPanel{
    private GestionConfig config;
    private GestionNavigation navigator;

    protected JPanel panelContenu;
    private Color bgColor;
    protected JButton btnRight;
    protected JButton btnLeft;
    public BasePanel(GestionNavigation _navigator, GestionConfig _config){
        config = _config;
        navigator = _navigator;

        setLayout(new BorderLayout());

        bgColor = config.getBackgroundColor();
        btnLeft = new JButton("<");
        btnRight = new JButton(">");

        initBoutonsNavigation();
        initContenuPanel();
        // S'assurer que panelContenu est ajouté au CENTER
        if (panelContenu != null) {
            add(panelContenu, BorderLayout.CENTER);
        }
    }

    protected abstract void initBoutonsNavigation();

    protected abstract void initContenuPanel();

    protected JPanel getPanelContenu(){ return panelContenu; }

    protected Color getBgColor() {
        return bgColor;
    }

    protected String getDateFormat() {
        return config.getDateFormat();
    }

    protected String getClockFormat() {
        return config.getClockFormat();
    }

    protected String getPolicy() {
        return config.getPolicy();
    }

    protected void setDateFormat(String format) {
        config.setDateFormat(format);
    }

    protected void setClockFormat(String format) {
        config.setClockFormat(format);
    }

    protected void setPolicy(String policy) {
        config.setPolicy(policy);
    }
    protected GestionConfig getConfig(){
        return config;
    }

    protected void setRGB(String r, String g, String b) {
        config.setRGB(r, g, b);
    }

    public GestionNavigation getNavigator() {
        return navigator;
    }

    protected void naviguer(BasePanel newPanel) {
        navigator.naviguer(newPanel);
    }

    protected Alarme getAlarme(){return config.getAlarme();}
    public void saveAlarme(Alarme a){config.saveAlarme(a);}

    @Override
    protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                setBackground(config.getBackgroundColor());
                int centreX = getWidth() / 2;
                int centreY = getHeight() / 2;
                //int radius = Math.min(getWidth(), getHeight()) / 3;
                

              /*   cadran.setCentre(centreX, centreY);
                if (cadran instanceof CadranAiguilles ca) {
                    ca.setRadius(radius);
                }*/

                g.setColor(Color.BLACK);
                String forme = getConfig().getFormeBoitier();

                //int cx = getWidth() / 2 ;
                //int cy = getHeight() / 2 ;
                int size = Math.min(getWidth(), getHeight()) - 60 ;
                int demi= size/2;

                if("carre".equals(forme)){
                    g.drawRect(centreX - demi, centreY - demi,size , size);
                }else{
                    g.drawOval(centreX - demi, centreY - demi,size , size);
                }

                
    }

    
    
}
