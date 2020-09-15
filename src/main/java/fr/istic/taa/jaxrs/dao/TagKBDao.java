package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.TagKB;

public class TagKBDao extends AbstractJpaDao<Long, TagKB> {

	public TagKBDao() {
		super(TagKB.class);
	}

}
