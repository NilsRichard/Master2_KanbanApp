package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.UserKB;

public class UserKBDao extends AbstractJpaDao<Long, UserKB> {

	public UserKBDao() {
		super(UserKB.class);
	}

}
