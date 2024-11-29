package gsb.modele;

public class Medicaments {
    protected String medDepotLegal;
    protected String medNomCommercial;
    protected String medComposition;
    protected String medEffets;
    protected String medContreIndic;
    protected float medPrixEchantillon;
    protected String famCode;
    protected String famLibelle;

    /**
     * Constructeur de la classe Medicament
     * 
     * @param medDepotLegal       Identifiant unique du médicament
     * @param medNomCommercial    Nom commercial du médicament
     * @param medComposition      Composition du médicament
     * @param medEffets           Effets du médicament
     * @param medContreIndic      Contre-indications du médicament
     * @param medPrixEchantillon  Prix de l'échantillon
     * @param famCode             Code de la famille du médicament
     * @param famLibelle          Libellé de la famille du médicament
     */
    public Medicaments(String medDepotLegal, String medNomCommercial, String medComposition,
                      String medEffets, String medContreIndic, float medPrixEchantillon,
                      String famCode, String famLibelle) {
        this.medDepotLegal = medDepotLegal;
        this.medNomCommercial = medNomCommercial;
        this.medComposition = medComposition;
        this.medEffets = medEffets;
        this.medContreIndic = medContreIndic;
        this.medPrixEchantillon = medPrixEchantillon;
        this.famCode = famCode;
        this.famLibelle = famLibelle;
    }

    // Getters et Setters pour chaque attribut

    public String getMedDepotLegal() {
        return medDepotLegal;
    }

    public void setMedDepotLegal(String medDepotLegal) {
        this.medDepotLegal = medDepotLegal;
    }

    public String getMedNomCommercial() {
        return medNomCommercial;
    }

    public void setMedNomCommercial(String medNomCommercial) {
        this.medNomCommercial = medNomCommercial;
    }

    public String getMedComposition() {
        return medComposition;
    }

    public void setMedComposition(String medComposition) {
        this.medComposition = medComposition;
    }

    public String getMedEffets() {
        return medEffets;
    }

    public void setMedEffets(String medEffets) {
        this.medEffets = medEffets;
    }

    public String getMedContreIndic() {
        return medContreIndic;
    }

    public void setMedContreIndic(String medContreIndic) {
        this.medContreIndic = medContreIndic;
    }

    public float getMedPrixEchantillon() {
        return medPrixEchantillon;
    }

    public void setMedPrixEchantillon(float medPrixEchantillon) {
        this.medPrixEchantillon = medPrixEchantillon;
    }

    public String getFamCode() {
        return famCode;
    }

    public void setFamCode(String famCode) {
        this.famCode = famCode;
    }

    public String getFamLibelle() {
        return famLibelle;
    }

    public void setFamLibelle(String famLibelle) {
        this.famLibelle = famLibelle;
    }
}
