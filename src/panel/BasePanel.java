package panel;

import config.GestionConfig;
import navigation.GestionNavigation;

import javax.swing.*;
import java.awt.*;


//Classe modélisant le contenu du panel courant affiché au sein de la frame courante du projet.
public abstract class BasePanel extends JPanel{
    private GestionConfig config;
    private GestionNavigation navigator;

    protected JPanel panelContenu;
    protected Color bgColor;
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
        /*Renvoie la même couleur mais une référence différente
        * Sans ça, on peut modifier la couleur d'un panel créé dans le futur
        * Alors que tous les panels de la montre doivent avoir le même background
        * */
        return new Color(bgColor.getRGB());
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
}
