package org.univaq.swa.catalogrest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import jakarta.ws.rs.core.UriInfo;
import java.io.InputStream;
import java.io.OutputStream;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.business.ProductsService;
import org.univaq.swa.catalogrest.business.ProductsServiceFactory;
import org.univaq.swa.catalogrest.model.Product;
import org.univaq.swa.catalogrest.security.Logged;

/**
 *
 * @author Giuseppe Della Penna
 */
//essendo solo una sotto-risorsa, non ha un'annotazione @Path e non
//viene registrata nella RESTApp. I path da cui potrà essere attivata
//dipendono quindi solo dalle risorse che la restituiranno 
//(in questo caso solo EventsRespource)
public class ProductResource {

    private final ProductsService product_business;
    private final Product product;

    public ProductResource(Product e) {
        this.product_business = ProductsServiceFactory.getProductsService();
        this.product = e;
    }

    //10. Eliminazione di un prodotto", description = "", security = {    
    @DELETE
    @Logged
    public Response deleteProduct() throws NotFoundException, DatabaseException {

        product_business.deleteProduct(product.getCodice());
        return Response.noContent().build();

    }

    //7. Lettura dettagli di un prodotto
    @GET
    @Produces({"application/json"})
    public Response getProduct() {
        return Response.ok(product).build();
    }

    //9. Modifica (anche parziale) di un prodotto", description = "", security = {
    //@PATCH non funziona :)
    @PUT
    @Consumes({"application/json"})
    @Logged
    public Response updateProduct(Product product) throws NotFoundException, DatabaseException {

        product_business.updateProduct(product.getCodice(), product);
        return Response.noContent().build();

    }

    //13. Scaricamento immagine (binaria) di un prodotto", description = "", tags={ "Prodotti" })
    @GET
    @Path("/image")
    @Produces({"image/png"})
    public Response getProductImage() throws NotFoundException, DatabaseException {
        final byte[] attachment = product_business.getImage(product.getCodice());
        StreamingOutput out = (OutputStream output) -> {
            output.write(attachment); //esempio banale
            //ad esempio, potrei copiare su output un altro file
        };
        return Response
                .ok(out)
                //in output inseriremo il nome effettivo del file restituito
                .header("content-disposition", "attachment; filename=" + product.getCodice() + "_image.png")
                //in oputput, possiamo specificare il tipo dell'attachment effettivo che stiamo restituendo
                //che ovviamente deve essere compatibile con l'@Produces
                .type("image/png")
                .build();
    }

    //14. Inserimento/Aggiornamento immagine (binaria) di un prodotto", description = "", security = {
    @PUT
    @Path("/image")
    @Consumes({"image/png"})
    @Logged
    public Response updateProductImage(@Context UriInfo c,
            // Possiamo anche (per POST e PUT) dire a JAX-RS
            // di fornirci il payload sotto forma ti uno stream.
            // (utile spprattutto per payload lunghi o binari)
            InputStream data) throws NotFoundException, DatabaseException {

        product_business.updateImage(product.getCodice(), data);
        return Response.noContent().build();
    }

    //11b. Inserimento (o spostamento) di un prodotto in una sezione.", description = "", security = {
    @PUT
    @Path("/section")
    @Consumes({"application/json"})
    @Logged
    public Response moveProductToSection2(String sectioncode) throws NotFoundException, DatabaseException {
        product_business.assignProductToSection(product.getCodice(), sectioncode);
        return Response.noContent().build();
    }

}
