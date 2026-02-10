package org.univaq.swa.catalogrest.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.univaq.swa.catalogrest.model.Product;

public class ProductSerializer extends JsonSerializer<Product> {

    @Override
    public void serialize(Product item, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        //notare che omettiamo l'immagine
        jgen.writeStartObject();
        jgen.writeStringField("codice", item.getCodice());
        jgen.writeObjectField("nome", item.getNome());
        jgen.writeObjectField("descrizioneBreve", item.getDescrizioneBreve());
        jgen.writeObjectField("disponibile", item.getDisponibile());
        jgen.writeObjectField("prezzo", item.getPrezzo());
        jgen.writeObjectFieldStart("dettagli");
        jgen.writeObjectField("allergeni", item.getAllergeni());
        jgen.writeObjectField("descrizioneLunga", item.getDescrizioneLunga());
        jgen.writeObjectField("etichette", item.getEtichette());
        jgen.writeObjectField("ingredienti", item.getIngredienti());
        jgen.writeObjectField("modalitaConservazione", item.getModalitaConservazione());
        jgen.writeObjectField("modalitaPreparazione", item.getModalitaPreparazione());
        jgen.writeObjectField("origine", item.getOrigine());
        jgen.writeObjectFieldStart("valoriNutrizionali");
        jgen.writeObjectField("carboidrati", item.getCarboidrati());
        jgen.writeObjectField("proteine", item.getProteine());
        jgen.writeObjectField("grassi", item.getGrassi());
        jgen.writeObjectField("kcal", item.getKcal());        
        jgen.writeEndObject();
        jgen.writeEndObject();
        jgen.writeEndObject();
    }
}
