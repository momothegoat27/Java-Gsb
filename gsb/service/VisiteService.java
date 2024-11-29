package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

/**
 * Service pour gérer les opérations sur les visites.
 * 
 * @author Isabelle
 * 17 nov. 2021
 */
public class VisiteService {

    /**
     * Recherche une visite par sa référence.
     * 
     * @param uneReference La référence de la visite à rechercher.
     * @return Une instance de Visite si trouvée, sinon null.
     */
    public static Visite rechercherVisite(String uneReference) {
        Visite uneVisite = null;
        try {
            if (uneReference == null || uneReference.isEmpty()) {
                throw new Exception("Donnée obligatoire : référence");
            }
            uneVisite = VisiteDao.rechercher(uneReference);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return uneVisite;
    }
}
