package gsb.modele;



public class Visite {
    private String reference;
    private String dateVisite;
    private String commentaire;
    private String matricule;
    private String codeMed;
    private String medOffert1;
    private int quantiteMed1;
    private String medOffert2;
    private int quantiteMed2;

    /**
     * Constructeur complet de la classe Visite.
     * 
     * @param reference     Référence de la visite
     * @param dateVisite    Date de la visite
     * @param commentaire   Commentaire sur la visite
     * @param matricule     Matricule du visiteur
     * @param codeMed       Code du médecin
     * @param medOffert1    Médicament offert 1
     * @param quantiteMed1  Quantité du médicament 1
     * @param medOffert2    Médicament offert 2
     * @param quantiteMed2  Quantité du médicament 2
     */
    public Visite(String reference, String dateVisite, String commentaire, String matricule, String codeMed,
                  String medOffert1, int quantiteMed1, String medOffert2, int quantiteMed2) {
        this.reference = reference;
        this.dateVisite = dateVisite;
        this.commentaire = commentaire;
        this.matricule = matricule;
        this.codeMed = codeMed;
        this.medOffert1 = medOffert1;
        this.quantiteMed1 = quantiteMed1;
        this.medOffert2 = medOffert2;
        this.quantiteMed2 = quantiteMed2;
    }

    // Getters et Setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(String dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCodeMed() {
        return codeMed;
    }

    public void setCodeMed(String codeMed) {
        this.codeMed = codeMed;
    }

    public String getMedOffert1() {
        return medOffert1;
    }

    public void setMedOffert1(String medOffert1) {
        this.medOffert1 = medOffert1;
    }

    public int getQuantiteMed1() {
        return quantiteMed1;
    }

    public void setQuantiteMed1(int quantiteMed1) {
        this.quantiteMed1 = quantiteMed1;
    }

    public String getMedOffert2() {
        return medOffert2;
    }

    public void setMedOffert2(String medOffert2) {
        this.medOffert2 = medOffert2;
    }

    public int getQuantiteMed2() {
        return quantiteMed2;
    }

    public void setQuantiteMed2(int quantiteMed2) {
        this.quantiteMed2 = quantiteMed2;
    }
}
