package org.univaq.swa.catalogrest.business;

/**
 *
 * @author Giuseppe Della Penna
 */
public class ProductsServiceFactory {

    private final static ProductsServiceImpl service = new ProductsServiceImpl();

    public static ProductsServiceImpl getProductsService() {
        return service;
    }

}
