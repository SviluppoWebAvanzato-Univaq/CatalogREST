package org.univaq.swa.catalogrest.business;

import java.io.InputStream;
import java.util.List;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.model.Product;

/**
 *
 * @author Giuseppe Della Penna
 */
public interface ProductsService {

    String addProduct(Product body)throws DatabaseException;

    void deleteProduct(String code) throws NotFoundException, DatabaseException;
    
    void assignProductToSection(String productcode, String sectioncode) throws NotFoundException, DatabaseException;

    List<Product> getProducts(String name, String section, Boolean available, Double minPrice, Double maxPrice, List<String> tags, Integer page)  throws DatabaseException;

    Product getProduct(String code) throws NotFoundException, DatabaseException;

    int getNumberOfProducts(String section) throws DatabaseException;

    void updateProduct(String code, Product body) throws NotFoundException, DatabaseException;

    void updateImage(String code, InputStream data) throws NotFoundException, DatabaseException;

    byte[] getImage(String code) throws NotFoundException, DatabaseException;

}
