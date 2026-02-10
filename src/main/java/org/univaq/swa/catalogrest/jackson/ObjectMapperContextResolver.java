package org.univaq.swa.catalogrest.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
import org.univaq.swa.catalogrest.model.Product;

/**
 *
 * @author didattica
 */
@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public ObjectMapperContextResolver() {
        this.mapper = createObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper m = new ObjectMapper();
        //abilitiamo una feature nuova...
        m.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule customSerializer = new SimpleModule("CustomSerializersModule");
        customSerializer.addSerializer(Product.class, new ProductSerializer());
        customSerializer.addDeserializer(Product.class, new ProductDeserializer());

        //
        m.registerModule(customSerializer);

        //per il supporto alla serializzazione automatica dei tipi Date/Time di Java 8 (ZonedDateTime, LocalTime, ecc.)
        //è necessario aggiungere alle dipendenze la libreria com.fasterxml.jackson.datatype:jackson-datatype-jsr310
        //mapper.registerModule(new JavaTimeModule());
        //questa feature fa cercare a Jackson tutti i moduli compatibili inseriti nel contesto...
        m.findAndRegisterModules();
        //perchè le date appaiano "human readable"
        m.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return m;
    }
}
