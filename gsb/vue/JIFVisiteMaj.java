package gsb.vue;

import gsb.modele.dao.VisiteDao;
import gsb.modele.Visite;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIFVisiteMaj extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtReference;
    private JTextField txtDateVisite;
    private JTextField txtMatriculeVisiteur;
    private JTextField txtCodeMedecin;
    private JTextField txtCommentaire;

    private JTextField txtMedicament1DepotLegal;
    private JTextField txtMedicament1Quantite;
    private JTextField txtMedicament2DepotLegal;
    private JTextField txtMedicament2Quantite;

    private JButton btnModifier;

    public JIFVisiteMaj(MenuPrincipal uneFenetreContainer) {
        super("Mise à jour d'une visite", true, true, true, true);
        setSize(500, 400);
        setLayout(null);

        // Champs pour la visite
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
        txtDateVisite.setEditable(false); // Champ non modifiable
        add(txtDateVisite);

        JLabel lblMatriculeVisiteur = new JLabel("Matricule visiteur");
        lblMatriculeVisiteur.setBounds(20, 80, 120, 20);
        add(lblMatriculeVisiteur);
        txtMatriculeVisiteur = new JTextField();
        txtMatriculeVisiteur.setBounds(150, 80, 200, 20);
        txtMatriculeVisiteur.setEditable(false); // Champ non modifiable
        add(txtMatriculeVisiteur);

        JLabel lblCodeMedecin = new JLabel("Code médecin");
        lblCodeMedecin.setBounds(20, 110, 120, 20);
        add(lblCodeMedecin);
        txtCodeMedecin = new JTextField();
        txtCodeMedecin.setBounds(150, 110, 200, 20);
        txtCodeMedecin.setEditable(false); // Champ non modifiable
        add(txtCodeMedecin);

        JLabel lblCommentaire = new JLabel("Commentaire");
        lblCommentaire.setBounds(20, 140, 120, 20);
        add(lblCommentaire);
        txtCommentaire = new JTextField();
        txtCommentaire.setBounds(150, 140, 200, 20);
        add(txtCommentaire);

        // Champs pour les médicaments
        JLabel lblMedicament1 = new JLabel("Médicament 1");
        lblMedicament1.setBounds(20, 180, 120, 20);
        add(lblMedicament1);
        txtMedicament1DepotLegal = new JTextField();
        txtMedicament1DepotLegal.setBounds(150, 180, 150, 20);
        add(txtMedicament1DepotLegal);

        JLabel lblQuantite1 = new JLabel("Quantité offerte");
        lblQuantite1.setBounds(320, 180, 120, 20);
        add(lblQuantite1);
        txtMedicament1Quantite = new JTextField();
        txtMedicament1Quantite.setBounds(400, 180, 50, 20);
        add(txtMedicament1Quantite);

        JLabel lblMedicament2 = new JLabel("Médicament 2");
        lblMedicament2.setBounds(20, 210, 120, 20);
        add(lblMedicament2);
        txtMedicament2DepotLegal = new JTextField();
        txtMedicament2DepotLegal.setBounds(150, 210, 150, 20);
        add(txtMedicament2DepotLegal);

        JLabel lblQuantite2 = new JLabel("Quantité offerte");
        lblQuantite2.setBounds(320, 210, 120, 20);
        add(lblQuantite2);
        txtMedicament2Quantite = new JTextField();
        txtMedicament2Quantite.setBounds(400, 210, 50, 20);
        add(txtMedicament2Quantite);

        // Bouton de mise à jour
        btnModifier = new JButton("MODIFIER");
        btnModifier.setBounds(200, 260, 100, 30);
        add(btnModifier);

        btnModifier.addActionListener(this);

        // Fermeture par défaut
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnModifier) {
            // Récupérer les valeurs des champs
            String reference = txtReference.getText();
            String commentaire = txtCommentaire.getText();
            String medicament1DepotLegal = txtMedicament1DepotLegal.getText();
            String medicament1Quantite = txtMedicament1Quantite.getText();
            String medicament2DepotLegal = txtMedicament2DepotLegal.getText();
            String medicament2Quantite = txtMedicament2Quantite.getText();

            // Convertir les quantités en entiers
            int quantite1 = Integer.parseInt(medicament1Quantite);
            int quantite2 = Integer.parseInt(medicament2Quantite);

            // Créer l'objet Visite avec les nouvelles valeurs
            Visite visiteModifiee = new Visite(
                    reference, 
                    txtDateVisite.getText(), // Date visite (non modifiable)
                    commentaire,
                    txtMatriculeVisiteur.getText(), // Matricule visiteur (non modifiable)
                    txtCodeMedecin.getText(), // Code médecin (non modifiable)
                    medicament1DepotLegal, 
                    quantite1,
                    medicament2DepotLegal, 
                    quantite2
            );

            // Appeler la méthode pour mettre à jour la visite
            int resultat = VisiteDao.mettreAJourVisite(visiteModifiee);

            // Afficher un message en fonction du résultat
            if (resultat > 0) {
                JOptionPane.showMessageDialog(this, "Visite mise à jour avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour de la visite.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
