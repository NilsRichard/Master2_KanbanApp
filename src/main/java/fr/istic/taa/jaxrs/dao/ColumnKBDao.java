package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.ColumnKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public class ColumnKBDao extends AbstractJpaDao<Long, ColumnKB> {

    public ColumnKBDao() {
        super(ColumnKB.class);
    }

}
