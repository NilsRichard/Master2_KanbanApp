package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.ColoredTagKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public class ColoredTagKBDao extends AbstractJpaDao<Long, ColoredTagKB> {

    public ColoredTagKBDao() {
        super(ColoredTagKB.class);
    }

}
