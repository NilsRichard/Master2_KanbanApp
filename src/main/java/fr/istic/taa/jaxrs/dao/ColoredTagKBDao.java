package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.ColoredTagKB;

public class ColoredTagKBDao extends AbstractJpaDao<Long, ColoredTagKB> {

	public ColoredTagKBDao() {
		super(ColoredTagKB.class);
	}

}
