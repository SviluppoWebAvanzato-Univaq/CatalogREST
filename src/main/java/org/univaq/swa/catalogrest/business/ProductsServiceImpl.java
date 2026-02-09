package org.univaq.swa.catalogrest.business;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.model.Product;

/**
 *
 * @author Giuseppe Della Penna
 */
public class ProductsServiceImpl implements ProductsService {

    @Override
    public String addProduct(Product product) {
        //dummy
        return product.getCodice();
    }

    @Override
    public void deleteProduct(String code) throws NotFoundException, DatabaseException {
        //dummy
    }

    @Override
    public List<Product> getProducts(String name, String section, Boolean available, Double minPrice, Double maxPrice, List<String> tags, Integer page) {
        //dummy
        return createDummyProductList();
    }

    @Override
    public Product getProduct(String code) throws NotFoundException {
        //dummy
        return createDummyProduct(code);
    }

    @Override
    public int getNumberOfProducts(String section) {
        //dummy
        return 10;
    }

    @Override
    public void updateProduct(String code, Product body) throws NotFoundException, DatabaseException {
        //dummy
    }

    @Override
    public void updateImage(String code, InputStream data) throws NotFoundException, DatabaseException {
        //dummy
    }

    @Override
    public byte[] getImage(String code) throws NotFoundException, DatabaseException {
        //dummy
        return new byte[0];
    }

    @Override
    public void assignProductToSection(String productcode, String sectioncode) throws NotFoundException, DatabaseException {
        //dummy
    }

    ///////
    Random random = new Random();

    private String createUID() {
        int leftLimit = 48; // '0'
        int rightLimit = 122; // 'z'
        int targetStringLength = 10;

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    private List<Product> createDummyProductList() {
        List<Product> result = new ArrayList<>();
        int n = random.nextInt(1, 10);
        for (int i = 0; i < n; ++i) {
            result.add(createDummyProduct("P-" + createUID()));
        }
        return result;
    }

    private Product createDummyProduct(String code) {
        Product e = new Product();
        e.setCodice(code);
        e.setDescrizioneBreve("Questo è il prodotto " + code);
        e.setDisponibile(Boolean.TRUE);
        e.setNome("Prodotto " + code);
        e.setPrezzo(Math.round(random.nextDouble() * 100.0) / 100.0);
        e.getDettagli().setModalitaConservazione("Pronto al consumo");
        e.getDettagli().getValoriNutrizionali().setKcal(10.0);
        e.getDettagli().setEtichette(List.of("A", "B"));
        return e;
    }

}
