package gsb.tests;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import java.util.HashMap;

/**
 * Classe de test pour retourner un dictionnaire des visites.
 * 
 * @author Isabelle
 * 17 nov. 2021
 */
public class VisiteDaoTestRetournerDictionnaire {

    /**
     * Méthode principale pour tester la méthode retournerDictionnaireDesVisites.
     * 
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {

        // Appel de la méthode pour obtenir le dictionnaire des visites
        HashMap<String, Visite> unDictionnaire = VisiteDao.retournerDictionnaireDesVisites();

        // Vérifie si une visite avec la référence "V001" est présente
        if (unDictionnaire.containsKey("V001")) {
            // Récupère et affiche les informations de la visite
            Visite uneVisite = unDictionnaire.get("V001");
            System.out.println("Référence : " + uneVisite.getReference());
            System.out.println("Date de visite : " + uneVisite.getDateVisite());
            System.out.println("Commentaire : " + uneVisite.getCommentaire());
            System.out.println("Matricule : " + uneVisite.getMatricule());
            System.out.println("Code médecin : " + uneVisite.getCodeMed());
            System.out.println("Médicament offert 1 : " + uneVisite.getMedOffert1());
            System.out.println("Quantité médicament 1 : " + uneVisite.getQuantiteMed1());
            System.out.println("Médicament offert 2 : " + uneVisite.getMedOffert2());
            System.out.println("Quantité médicament 2 : " + uneVisite.getQuantiteMed2());
        } else {
            System.out.println("La visite avec la référence 'V001' n'est pas présente dans le dictionnaire.");
        }
    }
}
