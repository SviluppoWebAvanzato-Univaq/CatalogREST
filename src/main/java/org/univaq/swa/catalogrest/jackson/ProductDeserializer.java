package org.univaq.swa.catalogrest.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.univaq.swa.catalogrest.model.Product;

public class ProductDeserializer extends JsonDeserializer<Product> {

    @Override
    public Product deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        Product p = new Product();

        JsonNode node = jp.getCodec().readTree(jp);

        if (node.has("codice")) {
            p.setCodice(node.get("codice").asText());
        }

        if (node.has("nome")) {
            p.setNome(node.get("nome").asText());
        }

        if (node.has("descrizioneBreve")) {
            p.setDescrizioneBreve(node.get("descrizioneBreve").asText());
        }

        if (node.has("disponibile")) {
            p.setDisponibile(node.get("disponibile").asBoolean());
        }

        if (node.has("prezzo")) {
            p.setPrezzo(node.get("prezzo").asDouble());
        }

        if (node.has("dettagli")) {
            JsonNode dettagli = node.get("dettagli");

            if (dettagli.has("descrizioneLunga")) {
                p.setDescrizioneLunga(dettagli.get("descrizioneLunga").asText());
            }

            if (dettagli.has("allergeni")) {
                ObjectMapper mapper = (ObjectMapper) jp.getCodec();
                p.setAllergeni(
                        mapper.convertValue(dettagli.get("allergeni"), new TypeReference<List<String>>() {
                        }));
            }

            if (dettagli.has("etichette")) {
                ObjectMapper mapper = (ObjectMapper) jp.getCodec();
                p.setEtichette(
                        mapper.convertValue(dettagli.get("etichette"), new TypeReference<List<String>>() {
                        }));
            }
        }

        //omettiamo volontariamente dalla deserializzazione moltissimi dettagli...
        return p;
    }
}
