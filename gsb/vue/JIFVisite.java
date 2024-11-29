package gsb.vue;

import gsb.modele.Visite;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Interface graphique pour afficher et gérer les informations d'une visite.
 * 
 * @author Isabelle
 * Créé le 25 nov. 2024
 */
public class JIFVisite extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    // Panneaux
    protected JPanel p;  
    protected JPanel pTexte;
    protected JPanel pBoutons;

    // Labels
    protected JLabel JLreference;
    protected JLabel JLdateVisite;
    protected JLabel JLcommentaire;
    protected JLabel JLmatricule;
    protected JLabel JLcodeMed;
    protected JLabel JLmedOffert1;
    protected JLabel JLquantiteMed1;
    protected JLabel JLmedOffert2;
    protected JLabel JLquantiteMed2;

    // Zones de texte
    protected JTextField JTreference;
    protected JTextField JTdateVisite;
    protected JTextField JTcommentaire;
    protected JTextField JTmatricule;
    protected JTextField JTcodeMed;
    protected JTextField JTmedOffert1;
    protected JTextField JTquantiteMed1;
    protected JTextField JTmedOffert2;
    protected JTextField JTquantiteMed2;

    // Constructeur
    public JIFVisite() {
        p = new JPanel();  // panneau principal
        pBoutons = new JPanel();    // panneau pour les boutons
        pTexte = new JPanel(new GridLayout(9, 2)); // grille pour aligner les labels et champs

        // Initialisation des labels
        JLreference = new JLabel("Référence");
        JLdateVisite = new JLabel("Date de visite");
        JLcommentaire = new JLabel("Commentaire");
        JLmatricule = new JLabel("Matricule");
        JLcodeMed = new JLabel("Code médecin");
        JLmedOffert1 = new JLabel("Médicament offert 1");
        JLquantiteMed1 = new JLabel("Quantité médicament 1");
        JLmedOffert2 = new JLabel("Médicament offert 2");
        JLquantiteMed2 = new JLabel("Quantité médicament 2");

        // Initialisation des champs de texte
        JTreference = new JTextField(20);
        JTdateVisite = new JTextField();
        JTcommentaire = new JTextField();
        JTmatricule = new JTextField();    
        JTcodeMed = new JTextField();
        JTmedOffert1 = new JTextField();
        JTquantiteMed1 = new JTextField();
        JTmedOffert2 = new JTextField();
        JTquantiteMed2 = new JTextField();

        // Ajout des labels et champs au panneau texte
        pTexte.add(JLreference);
        pTexte.add(JTreference);
        pTexte.add(JLdateVisite);
        pTexte.add(JTdateVisite);
        pTexte.add(JLcommentaire);
        pTexte.add(JTcommentaire);
        pTexte.add(JLmatricule);
        pTexte.add(JTmatricule);
        pTexte.add(JLcodeMed);
        pTexte.add(JTcodeMed);
        pTexte.add(JLmedOffert1);
        pTexte.add(JTmedOffert1);
        pTexte.add(JLquantiteMed1);
        pTexte.add(JTquantiteMed1);
        pTexte.add(JLmedOffert2);
        pTexte.add(JTmedOffert2);
        pTexte.add(JLquantiteMed2);
        pTexte.add(JTquantiteMed2);

        // Ajout des panneaux au panneau principal
        p.add(pTexte);
        p.add(pBoutons);

        // Ajout du panneau principal au conteneur
        Container contentPane = getContentPane();
        contentPane.add(p);
    }

    /**
     * Remplit les champs de texte avec les données d'une visite.
     * 
     * @param uneVisite La visite à afficher.
     */
    public void remplirText(Visite uneVisite) {
        JTreference.setText(uneVisite.getReference());
        JTdateVisite.setText(uneVisite.getDateVisite());
        JTcommentaire.setText(uneVisite.getCommentaire());
        JTmatricule.setText(uneVisite.getMatricule());
        JTcodeMed.setText(uneVisite.getCodeMed());
        JTmedOffert1.setText(uneVisite.getMedOffert1());
        JTquantiteMed1.setText(String.valueOf(uneVisite.getQuantiteMed1()));
        JTmedOffert2.setText(uneVisite.getMedOffert2());
        JTquantiteMed2.setText(String.valueOf(uneVisite.getQuantiteMed2()));
    }

    /**
     * Vide les champs de texte.
     */
    public void viderText() {
        JTreference.setText("");
        JTdateVisite.setText("");
        JTcommentaire.setText("");
        JTmatricule.setText("");
        JTcodeMed.setText("");
        JTmedOffert1.setText("");
        JTquantiteMed1.setText("");
        JTmedOffert2.setText("");
        JTquantiteMed2.setText("");
    }
}
