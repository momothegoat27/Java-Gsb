package gsb.modele.dao;

import gsb.modele.Medicaments;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe pour gérer les opérations sur les médicaments dans la base de données.
 */
public class MedicamentsDao {

    // Recherche un médicament par son dépôt légal
    public static Medicaments rechercher(String medDepotLegal) {
        Medicaments unMedicament = null;
        ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM MEDICAMENT WHERE MED_DEPOTLEGAL ='" + medDepotLegal + "'");
        try {
            if (reqSelection.next()) {
                unMedicament = new Medicaments(
                    reqSelection.getString("MED_DEPOTLEGAL"),
                    reqSelection.getString("MED_NOMCOMMERCIAL"),
                    reqSelection.getString("MED_COMPOSITION"),
                    reqSelection.getString("MED_EFFETS"),
                    reqSelection.getString("MED_CONTREINDIC"),
                    reqSelection.getFloat("MED_PRIXECHANTILLON"),
                    reqSelection.getString("FAM_CODE"),
                    reqSelection.getString("FAM_LIBELLE")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du médicament avec MED_DEPOTLEGAL = '" + medDepotLegal + "'");
            e.printStackTrace();
        } finally {
            ConnexionMySql.fermerConnexionBd();
        }
        return unMedicament;
    }

    // Retourne une collection de médicaments
    public static ArrayList<Medicaments> retournerCollectionDesMedicaments() {
        ArrayList<Medicaments> collectionDesMedicaments = new ArrayList<>();
        ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT MED_DEPOTLEGAL FROM MEDICAMENT");
        try {
            while (reqSelection.next()) {
                String medDepotLegal = reqSelection.getString(1);
                collectionDesMedicaments.add(MedicamentsDao.rechercher(medDepotLegal));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans retournerCollectionDesMedicaments()");
        }
        return collectionDesMedicaments;
    }

    // Retourne un dictionnaire de médicaments
    public static HashMap<String, Medicaments> retournerDictionnaireDesMedicaments() {
        HashMap<String, Medicaments> dicoDesMedicaments = new HashMap<>();
        ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT MED_DEPOTLEGAL FROM MEDICAMENT");
        try {
            while (reqSelection.next()) {
                String medDepotLegal = reqSelection.getString(1);
                dicoDesMedicaments.put(medDepotLegal, MedicamentsDao.rechercher(medDepotLegal));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans retournerDictionnaireDesMedicaments()");
        }
        return dicoDesMedicaments;
    }

    // Ajout d'un médicament
    public static int creer(Medicaments unMedicament, JPanel p) {
        int resultat = 0;
        String requeteInsertion = "INSERT INTO MEDICAMENT (MED_DEPOTLEGAL, MED_NOMCOMMERCIAL, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON, FAM_CODE, FAM_LIBELLE) " +
                "VALUES ('" + unMedicament.getMedDepotLegal() + "', '" + unMedicament.getMedNomCommercial() + "', '" + unMedicament.getMedComposition() + "', '" +
                unMedicament.getMedEffets() + "', '" + unMedicament.getMedContreIndic() + "', " + unMedicament.getMedPrixEchantillon() + ", '" + unMedicament.getFamCode() + "', '" + unMedicament.getFamLibelle() + "')";
        
        try {
            resultat = ConnexionMySql.execReqMaj(requeteInsertion);
            if (resultat > 0) {
                JOptionPane.showMessageDialog(p, "Médicament ajouté avec succès.", "Réussite", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(p, "Problème pour ajouter le médicament.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Échec de l'insertion du médicament");
            e.printStackTrace();
        }
        return resultat;
    }

    // Nouvelle méthode : récupérer toutes les familles disponibles
    public static ArrayList<String> retournerListeDesFamilles() {
        ArrayList<String> listeFamilles = new ArrayList<>();
        String requete = "SELECT DISTINCT FAM_LIBELLE FROM MEDICAMENT";
        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);

        try {
            while (reqSelection.next()) {
                listeFamilles.add(reqSelection.getString("FAM_LIBELLE"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des familles de médicaments.");
            e.printStackTrace();
        } finally {
            ConnexionMySql.fermerConnexionBd();
        }

        return listeFamilles;
    }

    // Nouvelle méthode : récupérer les médicaments par famille
    public static ArrayList<Medicaments> rechercherParFamille(String famille) {
        ArrayList<Medicaments> listeMedicaments = new ArrayList<>();
        String requete = "SELECT * FROM MEDICAMENT WHERE FAM_LIBELLE = '" + famille + "'";
        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);

        try {
            while (reqSelection.next()) {
                Medicaments unMedicament = new Medicaments(
                    reqSelection.getString("MED_DEPOTLEGAL"),
                    reqSelection.getString("MED_NOMCOMMERCIAL"),
                    reqSelection.getString("MED_COMPOSITION"),
                    reqSelection.getString("MED_EFFETS"),
                    reqSelection.getString("MED_CONTREINDIC"),
                    reqSelection.getFloat("MED_PRIXECHANTILLON"),
                    reqSelection.getString("FAM_CODE"),
                    reqSelection.getString("FAM_LIBELLE")
                );
                listeMedicaments.add(unMedicament);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des médicaments pour la famille : " + famille);
            e.printStackTrace();
        } finally {
            ConnexionMySql.fermerConnexionBd();
        }

        return listeMedicaments;
    }
    
}
