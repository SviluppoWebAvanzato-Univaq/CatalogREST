package org.univaq.swa.catalogrest.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProductDetails {

    private String descrizioneLunga = null;
    private File immagine = null;
    private List<String> ingredienti = new ArrayList<String>();
    private List<String> allergeni = new ArrayList<String>();
    private ProductDetailsValoriNutrizionali valoriNutrizionali = new ProductDetailsValoriNutrizionali();
    private String modalitaConservazione = null;
    private String modalitaPreparazione = null;
    private String origine = null;
    private List<String> etichette = new ArrayList<String>();

    public ProductDetails() {
    }

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
     * @return the valoriNutrizionali
     */
    public ProductDetailsValoriNutrizionali getValoriNutrizionali() {
        return valoriNutrizionali;
    }

    /**
     * @param valoriNutrizionali the valoriNutrizionali to set
     */
    public void setValoriNutrizionali(ProductDetailsValoriNutrizionali valoriNutrizionali) {
        this.valoriNutrizionali = valoriNutrizionali;
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
}
