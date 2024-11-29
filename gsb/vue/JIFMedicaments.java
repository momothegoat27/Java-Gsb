package gsb.vue;

import gsb.modele.Medicaments;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class JIFMedicaments extends JInternalFrame {
    /**
     * Commentaire pour <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;
    protected JPanel p;  
    protected JPanel pTexte;
    protected JPanel pBoutons;

    protected JLabel JLdepotLegal;
    protected JLabel JLnomCommercial;
    protected JLabel JLcomposition;
    protected JLabel JLeffets;
    protected JLabel JLcontreIndications;
    protected JLabel JLprixEchantillon;
    protected JLabel JLcodeFamille;
    protected JLabel JLlibelleFamille;

    protected JTextField JTdepotLegal;
    protected JTextField JTnomCommercial;
    protected JTextField JTcomposition;
    protected JTextField JTeffets;
    protected JTextField JTcontreIndications;
    protected JTextField JTprixEchantillon;
    protected JTextField JTcodeFamille;
    protected JTextField JTlibelleFamille;

    public JIFMedicaments() {
        p = new JPanel();  // panneau principal de la fenetre
        pTexte = new JPanel(new GridLayout(8, 2)); // Panneau pour les champs de texte
        
        // Initialisation des labels
        JLdepotLegal = new JLabel("Dépôt légal");
        JLnomCommercial = new JLabel("Nom commercial");
        JLcomposition = new JLabel("Composition");
        JLeffets = new JLabel("Effets");
        JLcontreIndications = new JLabel("Contre-indications");
        JLprixEchantillon = new JLabel("Prix échantillon");
        JLcodeFamille = new JLabel("Code famille");
        JLlibelleFamille = new JLabel("Libellé famille");

        // Initialisation des champs de texte
        JTdepotLegal = new JTextField(20);
        JTnomCommercial = new JTextField();
        JTcomposition = new JTextField();
        JTeffets = new JTextField();
        JTcontreIndications = new JTextField();
        JTprixEchantillon = new JTextField();
        JTcodeFamille = new JTextField();
        JTlibelleFamille = new JTextField();

        // Ajout des labels et champs de texte au panneau
        pTexte.add(JLdepotLegal);
        pTexte.add(JTdepotLegal);
        pTexte.add(JLnomCommercial);
        pTexte.add(JTnomCommercial);
        pTexte.add(JLcomposition);
        pTexte.add(JTcomposition);
        pTexte.add(JLeffets);
        pTexte.add(JTeffets);
        pTexte.add(JLcontreIndications);
        pTexte.add(JTcontreIndications);
        pTexte.add(JLprixEchantillon);
        pTexte.add(JTprixEchantillon);
        pTexte.add(JLcodeFamille);
        pTexte.add(JTcodeFamille);
        pTexte.add(JLlibelleFamille);
        pTexte.add(JTlibelleFamille);
        
        // Mise en forme de la fenêtre
        p.add(pTexte);
        //p.add(pBoutons);
        Container contentPane = getContentPane();
        contentPane.add(p);
        
    }

    public void remplirText(Medicaments unMedicament) {
        // Remplir les champs de texte avec les informations du médicament
        JTdepotLegal.setText(unMedicament.getMedDepotLegal());
        JTnomCommercial.setText(unMedicament.getMedNomCommercial());
        JTcomposition.setText(unMedicament.getMedComposition());
        JTeffets.setText(unMedicament.getMedEffets());
        JTcontreIndications.setText(unMedicament.getMedContreIndic());
        JTprixEchantillon.setText(String.valueOf(unMedicament.getMedPrixEchantillon()));
        JTcodeFamille.setText(unMedicament.getFamCode());
        JTlibelleFamille.setText(unMedicament.getFamLibelle());
    }

    public void viderText() {
        // Vider les champs de texte
        JTdepotLegal.setText("");
        JTnomCommercial.setText("");
        JTcomposition.setText("");
        JTeffets.setText("");
        JTcontreIndications.setText("");
        JTprixEchantillon.setText("");
        JTcodeFamille.setText("");
        JTlibelleFamille.setText("");
    }
}