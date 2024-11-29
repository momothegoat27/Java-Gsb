package gsb.modele.dao;

import gsb.modele.Visite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe pour gérer les opérations sur les visites dans la base de données.
 */
public class VisiteDao {

    // Recherche une visite par sa référence.
    public static Visite rechercher(String reference) {
        Visite uneVisite = null;
        ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM VISITE WHERE REFERENCE ='" + reference + "'");
        try {
            if (reqSelection.next()) {
                uneVisite = new Visite(
                    reqSelection.getString("REFERENCE"),
                    reqSelection.getString("DATEVISITE"),
                    reqSelection.getString("COMMENTAIRE"),
                    reqSelection.getString("MATRICULE"),
                    reqSelection.getString("CODEMED"),
                    reqSelection.getString("MED_OFFERT_1"),
                    reqSelection.getInt("QUANTITE_MED_1"),
                    reqSelection.getString("MED_OFFERT_2"),
                    reqSelection.getInt("QUANTITE_MED_2")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la visite avec la référence : " + reference);
            e.printStackTrace();
        } finally {
            ConnexionMySql.fermerConnexionBd();
        }
        return uneVisite;
    }

    // Recherche une visite par sa référence (version optimisée pour utilisation dans l'interface).
    public static Visite rechercherParReference(String reference) {
        return rechercher(reference);
    }

    // Retourne une collection de toutes les visites.
    public static ArrayList<Visite> retournerCollectionDesVisites() {
        ArrayList<Visite> collectionDesVisites = new ArrayList<>();
        ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT REFERENCE FROM VISITE");
        try {
            while (reqSelection.next()) {
                String reference = reqSelection.getString(1);
                collectionDesVisites.add(VisiteDao.rechercher(reference));
            }
        } catch (SQLException e) {
            System.out.println("Erreur dans retournerCollectionDesVisites()");
            e.printStackTrace();
        }
        return collectionDesVisites;
    }

    // Retourne un dictionnaire des visites avec leur référence comme clé.
    public static HashMap<String, Visite> retournerDictionnaireDesVisites() {
        HashMap<String, Visite> dictionnaireDesVisites = new HashMap<>();
        ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT REFERENCE FROM VISITE");
        try {
            while (reqSelection.next()) {
                String reference = reqSelection.getString(1);
                dictionnaireDesVisites.put(reference, VisiteDao.rechercher(reference));
            }
        } catch (SQLException e) {
            System.out.println("Erreur dans retournerDictionnaireDesVisites()");
            e.printStackTrace();
        }
        return dictionnaireDesVisites;
    }

    // Ajout d'une visite.
    public static int creer(Visite uneVisite, JPanel p) {
        int resultat = 0;
        String requeteInsertion = "INSERT INTO VISITE (REFERENCE, DATEVISITE, COMMENTAIRE, MATRICULE, CODEMED, MED_OFFERT_1, QUANTITE_MED_1, MED_OFFERT_2, QUANTITE_MED_2) " +
                "VALUES ('" + uneVisite.getReference() + "', '" + uneVisite.getDateVisite() + "', '" + uneVisite.getCommentaire() + "', '" +
                uneVisite.getMatricule() + "', '" + uneVisite.getCodeMed() + "', '" + uneVisite.getMedOffert1() + "', " + uneVisite.getQuantiteMed1() + ", '" +
                uneVisite.getMedOffert2() + "', " + uneVisite.getQuantiteMed2() + ")";
        
        try {
            resultat = ConnexionMySql.execReqMaj(requeteInsertion);
            if (resultat > 0) {
                JOptionPane.showMessageDialog(p, "Visite ajoutée avec succès.", "Réussite", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(p, "Problème pour ajouter la visite.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Échec de l'insertion de la visite");
            e.printStackTrace();
        }
        return resultat;
    }

    // Mise à jour d'une visite dans la base de données.
    public static int mettreAJourVisite(Visite uneVisite) {
        int resultat = 0;
        String requeteUpdate = "UPDATE VISITE SET " +
            "COMMENTAIRE = '" + uneVisite.getCommentaire() + "', " +
            "MED_OFFERT_1 = '" + uneVisite.getMedOffert1() + "', " +
            "QUANTITE_MED_1 = " + uneVisite.getQuantiteMed1() + ", " +
            "MED_OFFERT_2 = '" + uneVisite.getMedOffert2() + "', " +
            "QUANTITE_MED_2 = " + uneVisite.getQuantiteMed2() + " " +
            "WHERE REFERENCE = '" + uneVisite.getReference() + "'";
        
        resultat = ConnexionMySql.execReqMaj(requeteUpdate);
        
        return resultat;
    }
}
