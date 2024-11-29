package gsb.vue;

import gsb.modele.Medicaments;
import gsb.modele.dao.MedicamentsDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface graphique pour l'ajout d'un médicament.
 */
public class JIFMedicamentsAjout extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel p;
    private JPanel pBoutons;
    private JPanel pTexte;

    private JLabel JLdepotLegal;
    private JLabel JLnomCommercial;
    private JLabel JLcomposition;
    private JLabel JLeffets;
    private JLabel JLcontreIndications;
    private JLabel JLcodeFamille;
    private JLabel JLlibelleFamille;

    private JTextField JTdepotLegal;
    private JTextField JTnomCommercial;
    private JTextField JTcomposition;
    private JTextField JTeffets;
    private JTextField JTcontreIndications;
    private JTextField JTcodeFamille;
    private JTextField JTlibelleFamille;

    private JButton btnAjouter;
    private JButton btnFermer;

    public JIFMedicamentsAjout(MenuPrincipal uneFenetreContainer) {
        super("Ajout d'un médicament", true, true, true, true);
        setSize(400, 300);
        setLayout(new BorderLayout());

        p = new JPanel(new GridLayout(8, 2));
        pBoutons = new JPanel();

        // Initialisation des labels
        JLdepotLegal = new JLabel("Dépôt légal");
        JLnomCommercial = new JLabel("Nom commercial");
        JLcomposition = new JLabel("Composition");
        JLeffets = new JLabel("Effets");
        JLcontreIndications = new JLabel("Contre indications");
        JLcodeFamille = new JLabel("Code Famille");
        JLlibelleFamille = new JLabel("Libellé famille");

        // Initialisation des champs de texte
        JTdepotLegal = new JTextField();
        JTnomCommercial = new JTextField();
        JTcomposition = new JTextField();
        JTeffets = new JTextField();
        JTcontreIndications = new JTextField();
        JTcodeFamille = new JTextField();
        JTlibelleFamille = new JTextField();

        // Ajout des labels et champs de texte au panneau
        p.add(JLdepotLegal);
        p.add(JTdepotLegal);
        p.add(JLnomCommercial);
        p.add(JTnomCommercial);
        p.add(JLcomposition);
        p.add(JTcomposition);
        p.add(JLeffets);
        p.add(JTeffets);
        p.add(JLcontreIndications);
        p.add(JTcontreIndications);
        p.add(JLcodeFamille);
        p.add(JTcodeFamille);
        p.add(JLlibelleFamille);
        p.add(JTlibelleFamille);

        // Boutons
        btnAjouter = new JButton("AJOUTER");
        btnFermer = new JButton("FERMER");
        pBoutons.add(btnAjouter);
        pBoutons.add(btnFermer);

        // Ajout des panneaux à la fenêtre
        add(p, BorderLayout.CENTER);
        add(pBoutons, BorderLayout.SOUTH);

        // Action des boutons
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vérification des champs
                if (JTdepotLegal.getText().isEmpty() || JTnomCommercial.getText().isEmpty() ||
                    JTcomposition.getText().isEmpty() || JTeffets.getText().isEmpty() ||
                    JTcontreIndications.getText().isEmpty() || JTcodeFamille.getText().isEmpty() ||
                    JTlibelleFamille.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(p, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Création de l'objet Medicaments
                    Medicaments nouveauMedicament = new Medicaments(
                        JTdepotLegal.getText(),
                        JTnomCommercial.getText(),
                        JTcomposition.getText(),
                        JTeffets.getText(),
                        JTcontreIndications.getText(),
                        0.0f, // Prix échantillon par défaut
                        JTcodeFamille.getText(),
                        JTlibelleFamille.getText()
                    );

                    // Ajout du médicament à la base de données
                    int result = MedicamentsDao.creer(nouveauMedicament, p);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(p, "Médicament ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        // Réinitialisation des champs après ajout
                        JTdepotLegal.setText("");
                        JTnomCommercial.setText("");
                        JTcomposition.setText("");
                        JTeffets.setText("");
                        JTcontreIndications.setText("");
                        JTcodeFamille.setText("");
                        JTlibelleFamille.setText("");
                    } else {
                        JOptionPane.showMessageDialog(p, "Erreur lors de l'ajout du médicament.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Action pour le bouton Fermer
        btnFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Méthode non utilisée mais requise par l'interface ActionListener
    }
}