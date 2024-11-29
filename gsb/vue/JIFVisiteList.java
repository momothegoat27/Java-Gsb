package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Fenêtre interne pour afficher la liste des visites et leurs détails.
 */
public class JIFVisiteList extends JInternalFrame implements ActionListener {

    // Composants principaux
    private JPanel panelListe;
    private JPanel panelRecapitulatif;
    private JTable tableVisites;
    private DefaultTableModel tableModel;
    private JButton btnVisiteDetaillee;
    private JButton btnRetour;

    // Champs pour le panneau récapitulatif
    private JTextField txtReference;
    private JTextField txtDateVisiteRecap;
    private JTextField txtMatriculeVisiteur;
    private JTextField txtCodeMedecin;
    private JTextArea txtCommentaire;
    private JTextField txtMedicament1DepotLegal;
    private JTextField txtMedicament1Quantite;
    private JTextField txtMedicament2DepotLegal;
    private JTextField txtMedicament2Quantite;

    /**
     * Constructeur : initialise les composants et affiche la liste des visites.
     */
    public JIFVisiteList(MenuPrincipal uneFenetreContainer) {
        super("Liste des visites", true, true, true, true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new CardLayout());

        // Initialisation des panneaux
        panelListe = new JPanel(new BorderLayout());
        panelRecapitulatif = new JPanel(new GridLayout(10, 2, 10, 10));
        panelRecapitulatif.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initPanelListe();
        initPanelRecapitulatif();

        // Ajouter les panneaux à la fenêtre
        this.add(panelListe, "Liste");
        this.add(panelRecapitulatif, "Recapitulatif");

        // Afficher par défaut la liste
        panelListe.setVisible(true);
        panelRecapitulatif.setVisible(false);
    }

    /**
     * Initialise le panneau contenant la liste des visites.
     */
    private void initPanelListe() {
        // Modèle de la table
        tableModel = new DefaultTableModel(new Object[]{"Référence", "Date Visite", "Matricule Visiteur", "Code Médecin"}, 0);
        tableVisites = new JTable(tableModel);

        // Chargement des données dans la table
        chargerDonneesVisites();

        // Bouton pour afficher les détails
        btnVisiteDetaillee = new JButton("Afficher les détails");
        btnVisiteDetaillee.addActionListener(this);

        // Ajout des composants au panneau
        panelListe.add(new JScrollPane(tableVisites), BorderLayout.CENTER);
        panelListe.add(btnVisiteDetaillee, BorderLayout.SOUTH);
    }

    /**
     * Initialise le panneau pour afficher les détails d'une visite.
     */
    private void initPanelRecapitulatif() {
        // Champs pour afficher les informations de la visite
        panelRecapitulatif.add(new JLabel("Référence :"));
        txtReference = new JTextField();
        txtReference.setEditable(false);
        panelRecapitulatif.add(txtReference);

        panelRecapitulatif.add(new JLabel("Date Visite :"));
        txtDateVisiteRecap = new JTextField();
        txtDateVisiteRecap.setEditable(false);
        panelRecapitulatif.add(txtDateVisiteRecap);

        panelRecapitulatif.add(new JLabel("Matricule Visiteur :"));
        txtMatriculeVisiteur = new JTextField();
        txtMatriculeVisiteur.setEditable(false);
        panelRecapitulatif.add(txtMatriculeVisiteur);

        panelRecapitulatif.add(new JLabel("Code Médecin :"));
        txtCodeMedecin = new JTextField();
        txtCodeMedecin.setEditable(false);
        panelRecapitulatif.add(txtCodeMedecin);

        panelRecapitulatif.add(new JLabel("Commentaire :"));
        txtCommentaire = new JTextArea(3, 20);
        txtCommentaire.setEditable(false);
        txtCommentaire.setLineWrap(true);
        txtCommentaire.setWrapStyleWord(true);
        panelRecapitulatif.add(new JScrollPane(txtCommentaire));

        panelRecapitulatif.add(new JLabel("Médicament 1 (Dépôt légal) :"));
        txtMedicament1DepotLegal = new JTextField();
        txtMedicament1DepotLegal.setEditable(false);
        panelRecapitulatif.add(txtMedicament1DepotLegal);

        panelRecapitulatif.add(new JLabel("Quantité Médicament 1 :"));
        txtMedicament1Quantite = new JTextField();
        txtMedicament1Quantite.setEditable(false);
        panelRecapitulatif.add(txtMedicament1Quantite);

        panelRecapitulatif.add(new JLabel("Médicament 2 (Dépôt légal) :"));
        txtMedicament2DepotLegal = new JTextField();
        txtMedicament2DepotLegal.setEditable(false);
        panelRecapitulatif.add(txtMedicament2DepotLegal);

        panelRecapitulatif.add(new JLabel("Quantité Médicament 2 :"));
        txtMedicament2Quantite = new JTextField();
        txtMedicament2Quantite.setEditable(false);
        panelRecapitulatif.add(txtMedicament2Quantite);

        // Bouton de retour
        btnRetour = new JButton("Retour à la liste");
        btnRetour.addActionListener(this);
        panelRecapitulatif.add(new JPanel()); // Espace vide pour alignement
        panelRecapitulatif.add(btnRetour);
    }

    /**
     * Charge les données des visites dans le modèle de table.
     */
    private void chargerDonneesVisites() {
        ArrayList<Visite> listeVisites = VisiteDao.retournerCollectionDesVisites();
        for (Visite visite : listeVisites) {
            tableModel.addRow(new Object[]{
                visite.getReference(),
                visite.getDateVisite(),
                visite.getMatricule(),
                visite.getCodeMed()
            });
        }
    }

    /**
     * Gère les actions des boutons.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVisiteDetaillee) {
            // Afficher les détails d'une visite
            int selectedRow = tableVisites.getSelectedRow();
            if (selectedRow != -1) {
                String reference = (String) tableModel.getValueAt(selectedRow, 0);
                Visite visite = VisiteDao.rechercher(reference);
                if (visite != null) {
                    afficherDetailsVisite(visite);
                    panelListe.setVisible(false);
                    panelRecapitulatif.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Aucune visite trouvée pour cette référence.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une visite dans la liste.", "Attention", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnRetour) {
            // Revenir à la liste des visites
            panelRecapitulatif.setVisible(false);
            panelListe.setVisible(true);
        }
    }

    /**
     * Remplit les champs du panneau récapitulatif avec les détails de la visite.
     *
     * @param visite La visite sélectionnée.
     */
    private void afficherDetailsVisite(Visite visite) {
        txtReference.setText(visite.getReference());
        txtDateVisiteRecap.setText(visite.getDateVisite());
        txtMatriculeVisiteur.setText(visite.getMatricule());
        txtCodeMedecin.setText(visite.getCodeMed());
        txtCommentaire.setText(visite.getCommentaire());
        txtMedicament1DepotLegal.setText(visite.getMedOffert1());
        txtMedicament1Quantite.setText(String.valueOf(visite.getQuantiteMed1()));
        txtMedicament2DepotLegal.setText(visite.getMedOffert2());
        txtMedicament2Quantite.setText(String.valueOf(visite.getQuantiteMed2()));
    }
}
