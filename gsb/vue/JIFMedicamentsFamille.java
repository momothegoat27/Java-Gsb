package gsb.vue;

import gsb.modele.Medicaments;
import gsb.modele.dao.MedicamentsDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JIFMedicamentsFamille extends JInternalFrame {

    private JTable table;
    private DefaultTableModel model;

    public JIFMedicamentsFamille(MenuPrincipal uneFenetreContainer) {
        super("Médicament par famille", true, true, true, true);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panneau principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        // Panneau supérieur pour la sélection de la famille
        JPanel panelFamille = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblFamille = new JLabel("Famille : ");
        JComboBox<String> comboFamille = new JComboBox<>();

        // Récupération dynamique des familles depuis la base de données
        ArrayList<String> listeFamilles = MedicamentsDao.retournerListeDesFamilles();
        for (String famille : listeFamilles) {
            comboFamille.addItem(famille);
        }

        // Ajouter un ActionListener pour mettre à jour le tableau
        comboFamille.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFamille = (String) comboFamille.getSelectedItem();
                updateTable(selectedFamille);
            }
        });

        panelFamille.add(lblFamille);
        panelFamille.add(comboFamille);
        panelPrincipal.add(panelFamille, BorderLayout.NORTH);

        // Panneau pour afficher les informations sous forme de tableau
        String[] colonnes = { "Dépôt Légal", "Nom Commercial", "Composition", "Effets", "Contre Indications" };
        model = new DefaultTableModel(null, colonnes);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Panneau inférieur avec bouton fermer
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnFermer = new JButton("FERMER");
        btnFermer.addActionListener(e -> dispose()); // Action pour fermer la fenêtre
        panelBouton.add(btnFermer);
        panelPrincipal.add(panelBouton, BorderLayout.SOUTH);

        // Ajout du panneau principal dans la fenêtre interne
        add(panelPrincipal);
        setVisible(true);
    }

    private void updateTable(String famille) {
        // Effacer le modèle de tableau actuel
        model.setRowCount(0);

        // Récupérer les médicaments de la base de données pour la famille sélectionnée
        ArrayList<Medicaments> listeMedicaments = MedicamentsDao.rechercherParFamille(famille);

        // Ajouter les données au tableau
        for (Medicaments medicament : listeMedicaments) {
            model.addRow(new Object[]{
                medicament.getMedDepotLegal(),
                medicament.getMedNomCommercial(),
                medicament.getMedComposition(),
                medicament.getMedEffets(),
                medicament.getMedContreIndic()
            });
        }
    }
}
