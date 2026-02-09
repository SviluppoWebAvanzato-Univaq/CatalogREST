package org.univaq.swa.catalogrest.business;

import java.util.List;
import org.univaq.swa.catalogrest.exceptions.DatabaseException;
import org.univaq.swa.catalogrest.exceptions.NotFoundException;
import org.univaq.swa.catalogrest.model.Section;

/**
 *
 * @author Giuseppe Della Penna
 */
public interface SectionsService {

    List<Section> getSections() throws DatabaseException;

    Section getSection(String code) throws NotFoundException, DatabaseException;

    void updateSection(String code, Section body) throws NotFoundException, DatabaseException;

}
