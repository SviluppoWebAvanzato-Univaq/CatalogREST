package org.univaq.swa.catalogrest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.business.ProductsService;
import org.univaq.swa.catalogrest.business.ProductsServiceFactory;
import org.univaq.swa.catalogrest.business.SectionsService;
import org.univaq.swa.catalogrest.business.SectionsServiceFactory;
import org.univaq.swa.catalogrest.model.Section;
import org.univaq.swa.catalogrest.security.Logged;

/**
 *
 * @author Giuseppe Della Penna
 */
//essendo solo una sotto-risorsa, non ha un'annotazione @Path e non
//viene registrata nella RESTApp. I path da cui potrà essere attivata
//dipendono quindi solo dalle risorse che la restituiranno 
//(in questo caso solo EventsRespource)
public class SectionResource {

    private final SectionsService section_business;
    private final ProductsService product_business;
    private final Section section;

    public SectionResource(Section e) {
        this.section_business = SectionsServiceFactory.getSectionsService();
        this.product_business = ProductsServiceFactory.getProductsService();
        this.section = e;
    }

    //2. Lettura dettagli di una sezione
    @GET
    @Produces({"application/json"})
    public Response getSection() {
        return Response.ok(section).build();
    }

    //3. Aggiornamento descrizione di una sezione
    @PUT
    @Path("/description")
    @Consumes({"application/json","text/plain"})
    public Response updateSectionDescription(String description) throws NotFoundException, DatabaseException {
        section.setDescrizione(description);
        section_business.updateSection(section.getCodice(), section);
        return Response.noContent().build();
    }

    //4. Lettura prodotti di una sezione
    @GET
    @Path("/products")
    @Produces({"application/json"})
    public Response getSectionProducts(@Context UriInfo uriinfo) throws DatabaseException {
        return Response.ok(ProductsResource.mapProductsToBase(product_business.getProducts(null, section.getCodice(), null, null, null, null, null), uriinfo)).build();

    }

    //5. Lettura dei soli prodotti di una sezione attualmente disponibili
    @GET
    @Path("/products/available")
    @Produces({"application/json"})
    public Response getSectionProductsAvailable(@Context UriInfo uriinfo) throws DatabaseException {
        return Response.ok(ProductsResource.mapProductsToBase(product_business.getProducts(null, section.getCodice(), true, null, null, null, null), uriinfo)).build();
    }

    //6b. Calcolo numero prodotti per sezione
    @GET
    @Path("/products/count")
    @Produces({"application/json","text/plain"})
    public Response getSectionProductCount() throws DatabaseException {
        //poco efficiente, ma se la logica non ci fornisce il metodo giusto...
        return Response.ok(product_business.getProducts(null, section.getCodice(), null, null, null, null, null).size()).build();
    }

    //11a. Inserimento (o spostamento) di un prodotto in una sezione
    @POST
    @Path("/products")
    @Consumes({"application/json","text/plain"})
    @Logged
    public Response moveProductToSection1(String productcode, @Context UriInfo uriinfo) throws NotFoundException, DatabaseException {
        product_business.assignProductToSection(productcode, section.getCodice());
        //dovendo ritornare qualcosa, restituiamo la URL del prodotto spostato
        URI p = uriinfo.getBaseUriBuilder()
                .path(ProductsResource.class)
                .path(ProductsResource.class, "getProduct")
                .build(productcode);
        return Response.created(p).build();
    }
}
