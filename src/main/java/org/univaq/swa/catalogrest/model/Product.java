package org.univaq.swa.catalogrest.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private String codice = null;
    private String nome = null;
    private Double prezzo = null;
    private Boolean disponibile = true;
    private String descrizioneBreve = null;

    //
    private String descrizioneLunga = null;
    private File immagine = null;
    private List<String> ingredienti = new ArrayList<String>();
    private List<String> allergeni = new ArrayList<String>();
    private String modalitaConservazione = null;
    private String modalitaPreparazione = null;
    private String origine = null;
    private List<String> etichette = new ArrayList<String>();

    //
    private Double kcal = null;
    private Double grassi = null;
    private Double carboidrati = null;
    private Double proteine = null;

    public Product() {
    }

    /**
     * @return the codice
     */
    public String getCodice() {
        return codice;
    }

    /**
     * @param codice the codice to set
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the prezzo
     */
    public Double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the disponibile
     */
    public Boolean getDisponibile() {
        return disponibile;
    }

    /**
     * @param disponibile the disponibile to set
     */
    public void setDisponibile(Boolean disponibile) {
        this.disponibile = disponibile;
    }

    /**
     * @return the descrizioneBreve
     */
    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    /**
     * @param descrizioneBreve the descrizioneBreve to set
     */
    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }

    //////////
    
    /**
     * @return the descrizioneLunga
     */
    public String getDescrizioneLunga() {
        return descrizioneLunga;
    }

    /**
     * @param descrizioneLunga the descrizioneLunga to set
     */
    public void setDescrizioneLunga(String descrizioneLunga) {
        this.descrizioneLunga = descrizioneLunga;
    }

    /**
     * @return the immagine
     */
    public File getImmagine() {
        return immagine;
    }

    /**
     * @param immagine the immagine to set
     */
    public void setImmagine(File immagine) {
        this.immagine = immagine;
    }

    /**
     * @return the ingredienti
     */
    public List<String> getIngredienti() {
        return ingredienti;
    }

    /**
     * @param ingredienti the ingredienti to set
     */
    public void setIngredienti(List<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    /**
     * @return the allergeni
     */
    public List<String> getAllergeni() {
        return allergeni;
    }

    /**
     * @param allergeni the allergeni to set
     */
    public void setAllergeni(List<String> allergeni) {
        this.allergeni = allergeni;
    }

    /**
     * @return the modalitaConservazione
     */
    public String getModalitaConservazione() {
        return modalitaConservazione;
    }

    /**
     * @param modalitaConservazione the modalitaConservazione to set
     */
    public void setModalitaConservazione(String modalitaConservazione) {
        this.modalitaConservazione = modalitaConservazione;
    }

    /**
     * @return the modalitaPreparazione
     */
    public String getModalitaPreparazione() {
        return modalitaPreparazione;
    }

    /**
     * @param modalitaPreparazione the modalitaPreparazione to set
     */
    public void setModalitaPreparazione(String modalitaPreparazione) {
        this.modalitaPreparazione = modalitaPreparazione;
    }

    /**
     * @return the origine
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * @param origine the origine to set
     */
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    /**
     * @return the etichette
     */
    public List<String> getEtichette() {
        return etichette;
    }

    /**
     * @param etichette the etichette to set
     */
    public void setEtichette(List<String> etichette) {
        this.etichette = etichette;
    }

    //////////
    
    
    /**
     * @return the kcal
     */
    public Double getKcal() {
        return kcal;
    }

    /**
     * @param kcal the kcal to set
     */
    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    /**
     * @return the grassi
     */
    public Double getGrassi() {
        return grassi;
    }

    /**
     * @param grassi the grassi to set
     */
    public void setGrassi(Double grassi) {
        this.grassi = grassi;
    }

    /**
     * @return the carboidrati
     */
    public Double getCarboidrati() {
        return carboidrati;
    }

    /**
     * @param carboidrati the carboidrati to set
     */
    public void setCarboidrati(Double carboidrati) {
        this.carboidrati = carboidrati;
    }

    /**
     * @return the proteine
     */
    public Double getProteine() {
        return proteine;
    }

    /**
     * @param proteine the proteine to set
     */
    public void setProteine(Double proteine) {
        this.proteine = proteine;
    }

}
