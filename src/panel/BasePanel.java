package panel;

import config.GestionConfig;
import navigation.GestionNavigation;
import model.time.Alarme;
import javax.swing.*;
import java.awt.*;


/**
 * Classe abstraite de base pour tous les panneaux de l'application.</br>
 *
 * BasePanel fournit une infrastructure commune à tous les panneaux, incluant :</br>
 * - Gestion de la configuration</br>
 * - Navigation entre les panneaux</br>
 * - Boutons de navigation (gauche/droite)</br>
 * - Gestion du background color</br>
 * - Accès aux paramètres de l'application (formats, polices, etc.)</br>
 *
 * Chaque panneau héritant de BasePanel doit implémenter :</br>
 * - {@link #initBoutonsNavigation()} pour configurer les boutons</br>
 * - {@link #initContenuPanel()} pour créer le contenu visuel
 */
public abstract class BasePanel extends JPanel{
    private final GestionConfig config;
    private final GestionNavigation navigator;
    protected PanelProvider panelProvider;
    protected JPanel panelContenu;
    private final Color bgColor;
    protected JButton btnRight;
    protected JButton btnLeft;

    /**
     * Constructeur de BasePanel.
     * Initialise la structure de base et les boutons de navigation.
     **/
    public BasePanel(GestionNavigation _navigator, GestionConfig _config, PanelProvider _panelProvider){
        setLayout(new BorderLayout());
        navigator = _navigator;
        config = _config;
        panelProvider = _panelProvider;
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
    protected String getHeureFormat() {
        return config.getHeureFormat();
    }
    protected String getDateFormat(){
        return config.getDateFormat();
    }
    protected String getClockFormat() {
        return config.getClockFormat();
    }
    protected String getPolicy() {
        return config.getPolicy();
    }
    protected void setHeureFormat(String format) {
        config.setHeureFormat(format);
    }
    protected void setDateFormat(String format){ config.setDateFormat(format);}
    protected void setClockFormat(String format) {
        config.setClockFormat(format);
    }
    protected void setPolicy(String policy) {
        config.setPolicy(policy);
    }
    protected void setRGB(String r, String g, String b) {
        config.setRGB(r, g, b);
    }
    protected void naviguer(BasePanel newPanel) {
        navigator.naviguer(newPanel);
    }
    protected Alarme getAlarme(){return config.getAlarme();}
    public void saveAlarme(Alarme a){config.saveAlarme(a);}

    // Méthodes de navigation vers les autres panels
    protected void allerVersCouleur() {
        naviguer(panelProvider.creerPanelChoixCouleur(navigator, config));
    }
    protected void allerVersCalendrier() {
        naviguer(panelProvider.creerPanelCalendrier(navigator, config));
    }
    protected void allerVersParametrage() {
        naviguer(panelProvider.creerPanelParametrage(navigator, config));
    }
    protected void allerVersChronometre() {
        naviguer(panelProvider.creerPanelChronometre(navigator, config));
    }
    protected void allerVersAlarme() {
        naviguer(panelProvider.creerPanelAlarme(navigator, config));
    }
    protected void allerVersCadran() {
        naviguer(panelProvider.creerPanelCadran(navigator, config));
    }
}
