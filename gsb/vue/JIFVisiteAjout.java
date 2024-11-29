package gsb.vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface graphique pour l'ajout d'une visite.
 */
public class JIFVisiteAjout extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtReference;
    private JTextField txtDateVisite;
    private JTextField txtCommentaire;
    private JTextField txtMatriculeVisiteur;
    private JTextField txtCodeMedecin;
    private JButton btnAjouter;

    /**
     * Constructeur de la fenêtre d'ajout de visite.
     * 
     * @param uneFenetreContainer Le conteneur principal (MenuPrincipal).
     */
    public JIFVisiteAjout(MenuPrincipal uneFenetreContainer) {
        super("Ajout d'une visite", true, true, true, true);
        setSize(400, 250);
        setLayout(null);

        // Création des labels et champs de texte
        JLabel lblReference = new JLabel("Référence");
        lblReference.setBounds(20, 20, 120, 20);
        add(lblReference);
        txtReference = new JTextField();
        txtReference.setBounds(150, 20, 200, 20);
        add(txtReference);

        JLabel lblDateVisite = new JLabel("Date visite");
        lblDateVisite.setBounds(20, 50, 120, 20);
        add(lblDateVisite);
        txtDateVisite = new JTextField();
        txtDateVisite.setBounds(150, 50, 200, 20);
        add(txtDateVisite);

        JLabel lblCommentaire = new JLabel("Commentaire");
        lblCommentaire.setBounds(20, 80, 120, 20);
        add(lblCommentaire);
        txtCommentaire = new JTextField();
        txtCommentaire.setBounds(150, 80, 200, 20);
        add(txtCommentaire);

        JLabel lblMatriculeVisiteur = new JLabel("Matricule visiteur");
        lblMatriculeVisiteur.setBounds(20, 110, 120, 20);
        add(lblMatriculeVisiteur);
        txtMatriculeVisiteur = new JTextField();
        txtMatriculeVisiteur.setBounds(150, 110, 200, 20);
        add(txtMatriculeVisiteur);

        JLabel lblCodeMedecin = new JLabel("Code médecin");
        lblCodeMedecin.setBounds(20, 140, 120, 20);
        add(lblCodeMedecin);
        txtCodeMedecin = new JTextField();
        txtCodeMedecin.setBounds(150, 140, 200, 20);
        add(txtCodeMedecin);

        // Bouton d'ajout
        btnAjouter = new JButton("AJOUTER");
        btnAjouter.setBounds(150, 180, 100, 30);
        add(btnAjouter);

        // Ajout du listener au bouton
        btnAjouter.addActionListener(this);

        // Fermeture par défaut
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * Action déclenchée lors de l'appui sur un bouton.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAjouter) {
            String reference = txtReference.getText();
            String dateVisite = txtDateVisite.getText();
            String commentaire = txtCommentaire.getText();
            String matriculeVisiteur = txtMatriculeVisiteur.getText();
            String codeMedecin = txtCodeMedecin.getText();

            // Logique pour ajouter une visite
            // Par exemple : VisiteDao.ajouterVisite(reference, dateVisite, commentaire, matriculeVisiteur, codeMedecin);
            JOptionPane.showMessageDialog(this, "Visite ajoutée avec succès !");
        }
    }
}
