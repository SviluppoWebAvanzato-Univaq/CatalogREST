package org.univaq.swa.catalogrest.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.business.SectionsService;
import org.univaq.swa.catalogrest.business.SectionsServiceFactory;
import org.univaq.swa.catalogrest.model.Section;

/**
 *
 * @author Didattica
 */
//risponde ai path .../rest/sections
@Path("/sections")
public class SectionsResource {

    private final SectionsService section_business;

    public SectionsResource() {
        this.section_business = SectionsServiceFactory.getSectionsService();
    }

    //crea "al volo" una sorta di DTO (qui realizzato semplicemente con una mappa) per le sezioni
    //che permette di esportarne tramite la API "lista" solo i dettagli che vogliamo mostrare all'esterno
    private List mapSectionsToBase(List<Section> products, UriInfo uriinfo) {
        //usiamo Jackson per convertire velocemente in mappa!
        ObjectMapper mapper = new ObjectMapper();
        return products.stream()
                .map(e -> {
                    Map<String, Object> m = mapper.convertValue(e, Map.class);
                    URI uri = uriinfo.getBaseUriBuilder()
                            .path(getClass())
                            .path(getClass(), "getSection")
                            .build(e.getCodice());
                    m.put("url", uri);
                    return m;
                })
                .toList();
    }

    
    
    //1. Lettura lista sezioni ("radice" catalogo)
    @GET
    @Produces({"application/json"})
    //1. Lettura lista sezioni ("radice" catalogo)
    public Response getSections(@Context UriInfo uriinfo) throws DatabaseException {
        return Response.ok(mapSectionsToBase(section_business.getSections(), uriinfo)).build();
    }

    //non ci sono metodi specificati, quindi per JAX-RS si tratta
    //della restituzione di una sotto-risorsa
    @Path("/{sectioncode: [a-zA-Z0-9]+}")
    public SectionResource getSection(@PathParam("sectioncode") String code) throws DatabaseException {
        try {
            return new SectionResource(section_business.getSection(code));
        } catch (NotFoundException ex) {
            return null; //ritornare null da un metodo che restituisce una sotto-risorsa equivale a un 404
        }
    }

}
