package panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class PanelCalendrier extends BasePanel{
    private LocalDate dateAffichee;
    private int JourSelectionne = -1;

    public PanelCalendrier(MainFrame mainFrame){
        super(mainFrame);
        this.dateAffichee=LocalDate.now();

        if(this.getPanelContenu() != null){
            this.getPanelContenu().setBackground(bgColor);
            this.getPanelContenu().setLayout(new BorderLayout());
        }
        remplirCalendrier();
    }

    protected void initContenuPanel(){
        if(this.panelContenu == null){
            this.panelContenu= new JPanel();
        }
    }

    public void remplirCalendrier(){
        JPanel contenu = this.getPanelContenu();
        if(contenu == null){return;}

        contenu.removeAll();

        JPanel zoneTitre= new JPanel(new BorderLayout());
        zoneTitre.setBackground(bgColor);

        JButton btnPrecedent = new JButton("<");
        styleBoutonFleche(btnPrecedent);
        btnPrecedent.addActionListener(e ->{
            dateAffichee= dateAffichee.minusMonths(1);
            remplirCalendrier();
        });



        String nomMois= dateAffichee.getMonth().getDisplayName(TextStyle.FULL,Locale.FRENCH);
        JLabel titre= new JLabel(nomMois.toUpperCase()+ " " + dateAffichee.getYear(),SwingConstants.CENTER);
        titre.setForeground(Color.WHITE);
        titre.setFont(new Font("Arial", Font.BOLD,18));

        JButton btnSuivant = new JButton(">");
        styleBoutonFleche(btnSuivant);
        btnSuivant.addActionListener(e ->{
            dateAffichee= dateAffichee.plusMonths(1);
            remplirCalendrier();
        });

        zoneTitre.add(btnPrecedent,BorderLayout.WEST);
        zoneTitre.add(titre,BorderLayout.CENTER);
        zoneTitre.add(btnSuivant,BorderLayout.EAST);

        contenu.add(zoneTitre, BorderLayout.NORTH);

        JPanel grille = new JPanel(new GridLayout(0,7));
        grille.setBackground(bgColor);

        String[] jourSemaine= {"L","Mar","Mer","J","V","S","D"};
        for(String j : jourSemaine){
            JLabel lbl= new JLabel(j, SwingConstants.CENTER);
            lbl.setForeground(Color.BLACK);
            grille.add(lbl);
        }

        YearMonth moisActuel= YearMonth.from(dateAffichee);
        int premierJourDeSemaine= moisActuel.atDay(1).getDayOfWeek().getValue();
        int nbJoursDansMois= moisActuel.lengthOfMonth();

        for(int i=1; i< premierJourDeSemaine ; i++){
            grille.add(new JLabel(""));
        }

        for(int jour=1 ; jour <= nbJoursDansMois ; jour++){
            final int j=jour;

            JLabel lblJour = new JLabel(String.valueOf(jour),SwingConstants.CENTER);
            lblJour.setForeground(Color.WHITE);
            lblJour.setOpaque(true);
            lblJour.setBackground(bgColor);

            if(jour == JourSelectionne){
                lblJour.setBorder(new LineBorder(Color.WHITE,1));
            }

            if(jour == LocalDate.now().getDayOfMonth() && moisActuel.equals(YearMonth.now())){
                lblJour.setBackground(Color.GRAY);
                lblJour.setFont(lblJour.getFont().deriveFont(Font.BOLD));
            }

            lblJour.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    if(j != JourSelectionne){
                        lblJour.setBorder(new LineBorder(Color.GRAY,1));
                    }
                }

                public void mouseExited(MouseEvent e){
                    if(j != JourSelectionne){
                        lblJour.setBorder(null);
                    }
                }

                public void mouseClicked(MouseEvent e){
                    JourSelectionne = j;
                    remplirCalendrier();
                }

            });



            grille.add(lblJour);
        }
        contenu.add(grille,BorderLayout.CENTER);
        contenu.revalidate();
        contenu.repaint();
    }

    private void styleBoutonFleche(JButton btn){
        btn.setForeground(Color.WHITE);
        btn.setBackground(bgColor);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFont(new Font("Arial",Font.BOLD,18));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}