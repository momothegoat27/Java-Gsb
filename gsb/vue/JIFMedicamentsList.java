package gsb.vue;

import gsb.modele.Medicaments;
import gsb.modele.dao.MedicamentsDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe pour afficher la liste des médicaments et permettre la consultation des fiches.
 */
public class JIFMedicamentsList extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private ArrayList<Medicaments> lesMedicaments;
    protected JPanel p;
    protected JScrollPane scrollPane;
    protected JPanel pSaisie;
    protected JTextField JTdepotLegal;
    protected JButton JBafficherFiche;
    protected JTable table;
    protected MenuPrincipal fenetreContainer;

    public JIFMedicamentsList(MenuPrincipal uneFenetreContainer) {
        super("Liste des Médicaments", true, true, true, true);
        fenetreContainer = uneFenetreContainer;

        // Récupération des données Médicaments dans la collection
        lesMedicaments = MedicamentsDao.retournerCollectionDesMedicaments();

        // Initialisation des composants
        p = new JPanel(); // panneau principal de la fenêtre
        pSaisie = new JPanel();
        JTdepotLegal = new JTextField(20);
        JBafficherFiche = new JButton("Afficher Fiche médicament");
        JBafficherFiche.addActionListener(this);

        // Création du modèle de table
        String[] columnNames = {"Dépôt Légal", "Nom Commercial", "Composition", "Effets", "Contre-indications", "Prix"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        // Remplissage du modèle avec les données des médicaments
        for (Medicaments medicament : lesMedicaments) {
            Object[] row = {
                medicament.getMedDepotLegal(),
                medicament.getMedNomCommercial(),
                medicament.getMedComposition(),
                medicament.getMedEffets(),
                medicament.getMedContreIndic(),
                medicament.getMedPrixEchantillon()
            };
            model.addRow(row);
        }

        // Création du JTable avec le modèle
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 200)); // Ajustez la taille selon vos besoins

        // Ajout des composants au panneau
        pSaisie.add(JTdepotLegal);
        pSaisie.add(JBafficherFiche);
        p.add(pSaisie);
        p.add(scrollPane); // Ajout du JScrollPane contenant le JTable

        // Mise en forme de la fenêtre
        Container contentPane = getContentPane();
        contentPane.add(p);

        // Configuration de la taille de la fenêtre
        setPreferredSize(new Dimension(600, 400));
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object source = arg0.getSource();
        if (source == JBafficherFiche) {
            String depotLegal = JTdepotLegal.getText().trim(); // Récupérer le dépôt légal saisi
            if (depotLegal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir un dépôt légal.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Medicaments unMedicament = MedicamentsDao.rechercher(depotLegal); // Rechercher le médicament
            if (unMedicament != null) {
            	System.out.println(unMedicament.getMedComposition());
                fenetreContainer.ouvrirFenetre(new JIFMedicamentsFiche(unMedicament)); // Ouvrir la fiche du médicament
            } else {
                JOptionPane.showMessageDialog(this, "Aucun médicament trouvé avec ce dépôt légal.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}