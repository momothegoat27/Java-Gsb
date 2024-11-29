package gsb.tests;

import gsb.modele.Visite;
import gsb.service.VisiteService;

/**
 * Classe de test pour VisiteService.
 * 
 * @author Isabelle
 * 17 nov. 2021
 */
public class VisiteServiceTest {

    /**
     * Méthode principale pour tester la recherche d'une visite.
     * 
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        // Recherche d'une visite par sa référence
        Visite uneVisite = VisiteService.rechercherVisite("V001");

        // Vérification si la visite a été trouvée
        if (uneVisite != null) {
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
            System.out.println("Aucune visite trouvée avec cette référence.");
        }
    }
}
