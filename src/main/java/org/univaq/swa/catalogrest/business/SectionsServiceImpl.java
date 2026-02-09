package org.univaq.swa.catalogrest.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.model.Section;

/**
 *
 * @author Giuseppe Della Penna
 */
public class SectionsServiceImpl implements SectionsService {

    @Override
    public List<Section> getSections() throws DatabaseException {
        //dummy
        return createDummySectionList();
    }

    @Override
    public Section getSection(String code) throws NotFoundException, DatabaseException {
        //dummy
        return createDummySection(code);
    }

    @Override
    public void updateSection(String code, Section body) throws NotFoundException, DatabaseException {
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

    private List<Section> createDummySectionList() {
        List<Section> result = new ArrayList<>();
        int n = random.nextInt(1, 10);
        for (int i = 0; i < n; ++i) {
            result.add(createDummySection("S-" + createUID()));
        }
        return result;
    }

    private Section createDummySection(String code) {
        Section e = new Section();
        e.setCodice(code);
        e.setDescrizione("Questa è la sezione " + code);
        e.setNome("Sezione " + code);
        return e;
    }
}
