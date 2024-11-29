/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.tests;

import gsb.modele.Medicaments;
import gsb.modele.dao.MedicamentsDao;

import java.util.HashMap;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MedicamentsDaoTestRetournerDictionnaire {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        HashMap<String, Medicaments> dicMedicaments = new HashMap<String, Medicaments>();
        dicMedicaments = MedicamentsDao.retournerDictionnaireDesMedicaments();
        
        // Vérifier si un médicament avec un dépôt légal spécifique existe
        String depotLegalTest = "3MYC7"; // Remplacez par un dépôt légal valide
        if (dicMedicaments.containsKey(depotLegalTest)) {
            Medicaments medicament = dicMedicaments.get(depotLegalTest);
            System.out.println("Dépôt légal : " + medicament.getMedDepotLegal());
            System.out.println("Nom commercial : " + medicament.getMedNomCommercial());
            System.out.println("Composition : " + medicament.getMedComposition());
            System.out.println("Effets : " + medicament.getMedEffets());
            System.out.println("Contre-indications : " + medicament.getMedContreIndic());
            System.out.println("Prix échantillon : " + medicament.getMedPrixEchantillon() + "€");
            System.out.println("Code famille : " + medicament.getFamCode());
            System.out.println("Libellé famille : " + medicament.getFamLibelle());
        } else {
            System.out.println("Aucun médicament trouvé avec le dépôt légal spécifié.");
        }
    }
}