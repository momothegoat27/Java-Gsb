package gsb.service;

import gsb.modele.Medicaments;
import gsb.modele.dao.MedicamentsDao;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MedicamentsService {

    // Recherche un médicament par son dépôt légal
    public static Medicaments rechercherMedicament(String depotLegal) {
        Medicaments medicament = null;
        try {
            if (depotLegal == null) {
                throw new Exception("Donnee obligatoire : dépôt légal");
            }
            medicament = MedicamentsDao.rechercher(depotLegal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return medicament;
    }
    
}