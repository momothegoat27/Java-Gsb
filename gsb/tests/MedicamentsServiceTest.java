/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.tests;

import gsb.modele.Medicaments;
import gsb.service.MedicamentsService;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MedicamentsServiceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Medicaments unMedicament = MedicamentsService.rechercherMedicament("3MYC7"); // Remplacez par un dépôt légal valide
        if (unMedicament != null) {
            System.out.println("Dépôt légal : " + unMedicament.getMedDepotLegal());
            System.out.println("Nom commercial : " + unMedicament.getMedNomCommercial());
            System.out.println("Composition : " + unMedicament.getMedComposition());
            System.out.println("Effets : " + unMedicament.getMedEffets());
            System.out.println("Contre-indications : " + unMedicament.getMedContreIndic());
            System.out.println("Prix échantillon : " + unMedicament.getMedPrixEchantillon());
            System.out.println("Code famille : " + unMedicament.getFamCode());
            System.out.println("Libellé famille : " + unMedicament.getFamLibelle());
        } else {
            System.out.println("Aucun médicament trouvé avec le dépôt légal spécifié.");
        }
    }
}