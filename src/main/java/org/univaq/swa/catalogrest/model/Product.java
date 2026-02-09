package org.univaq.swa.catalogrest.model;

public class Product {

    private String codice = null;
    private String nome = null;
    private Double prezzo = null;
    private Boolean disponibile = true;
    private String descrizioneBreve = null;
    private ProductDetails dettagli = new ProductDetails();

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

    /**
     * @return the dettagli
     */
    public ProductDetails getDettagli() {
        return dettagli;
    }

    /**
     * @param dettagli the dettagli to set
     */
    public void setDettagli(ProductDetails dettagli) {
        this.dettagli = dettagli;
    }
}
