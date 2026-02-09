package org.univaq.swa.catalogrest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.business.ProductsService;
import org.univaq.swa.catalogrest.business.ProductsServiceFactory;
import org.univaq.swa.catalogrest.model.Product;
import org.univaq.swa.catalogrest.security.Logged;

/**
 *
 * @author Didattica
 */
//risponde ai path .../rest/products
@Path("/products")
public class ProductsResource {

    private final ProductsService product_business;

    public ProductsResource() {
        this.product_business = ProductsServiceFactory.getProductsService();

    }

    //crea "al volo" una sorta di DTO (qui realizzato semplicemente con una mappa) per i prodotti
    //che permette di esportarne tramite la API "lista" solo i dettagli che vogliamo mostrare all'esterno
    public static List mapProductsToBase(List<Product> products, UriInfo uriinfo) {
        return products.stream()
                .map(e -> {
                    URI uri = uriinfo.getBaseUriBuilder()
                            .path(ProductsResource.class)
                            .path(ProductsResource.class, "getProduct")
                            .build(e.getCodice());
                    return Map.of("url", uri,
                            "codice", e.getCodice(),
                            "descrizioneBreve", e.getDescrizioneBreve(),
                            "disponibile", e.getDisponibile(),
                            "nome", e.getNome(),
                            "prezzo", e.getPrezzo());
                })
                .toList();
    }
    
    //6a. Calcolo numero prodotti globale
    @GET
    @Path("/count")
    @Produces({"application/json"})
    public Response getProductCount() throws DatabaseException {
        return Response.ok(product_business.getNumberOfProducts(null)).build();
    }

    //8. Inserimento di un nuovo prodotto.", description = "", security = {
    @POST
    @Consumes({"application/json"})
    @Logged
    public Response addProduct(Product product,
            @Context SecurityContext securityContext, @Context ContainerRequestContext requestcontext,
            @Context UriInfo uriinfo) throws DatabaseException {
        //essendo Logged, possiamo estrarre le informazioni
        //impostate dal LoggedFilter iniettando le opportune
        //classi tra i parametri del metodo:     
        //solo per debug...
        System.out.println(securityContext.getUserPrincipal().getName());
        System.out.println(requestcontext.getProperty("token"));

        String codice = product_business.addProduct(product);
        URI uri = uriinfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "getProduct")
                .build(codice);
        return Response.created(uri).entity(uri.toString()).build();

    }

    //12. Ricerca di prodotti per codice e/o nome e/o tag e/o sezione e/o fascia di prezzo e/o disponibilità    
    @GET
    @Produces({"application/json"})
    public Response listProducts(@QueryParam("code") String code, @QueryParam("name") String name,
            @QueryParam("tag") List<String> tag, @QueryParam("available") Boolean available,
            @QueryParam("section") String section, @QueryParam("minPrice") Double minPrice, @QueryParam("maxPrice") Double maxPrice,
            @QueryParam("page") Integer page, @Context UriInfo uriinfo) throws DatabaseException {
        return Response.ok(mapProductsToBase(product_business.getProducts(name, section, available, minPrice, maxPrice, tag, page), uriinfo)).build();
    }

    //non ci sono metodi specificati, quindi per JAX-RS si tratta
    //della restituzione di una sotto-risorsa
    @Path("/{productcode: P-[A-Za-z0-9]+}")
    public ProductResource getProduct(@PathParam("productcode") String code) throws DatabaseException {
        try {
            return new ProductResource(product_business.getProduct(code));
        } catch (NotFoundException ex) {
            return null; //ritornare null da un metodo che restituisce una sotto-risorsa equivale a un 404
        }
    }
}
