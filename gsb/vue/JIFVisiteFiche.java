/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.vue;

import gsb.modele.Visite;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class JIFVisiteFiche extends JIFVisite {

    private static final long serialVersionUID = 1L;

    public JIFVisiteFiche(Visite uneVisite) {
        super();
        this.remplirText(uneVisite);
    }

}