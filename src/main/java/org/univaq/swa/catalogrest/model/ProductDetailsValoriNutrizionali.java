package org.univaq.swa.catalogrest.model;

public class ProductDetailsValoriNutrizionali {

    private Double kcal = null;
    private Double grassi = null;
    private Double carboidrati = null;
    private Double proteine = null;

    public ProductDetailsValoriNutrizionali() {
    }

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
