/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.vue;

import gsb.modele.Medicaments;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class JIFMedicamentsFiche extends JIFMedicaments {

    private static final long serialVersionUID = 1L;

    public JIFMedicamentsFiche(Medicaments unMedicament) {
        super();
        this.remplirText(unMedicament);
        
    }

    
}