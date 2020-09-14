package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.CardKB;

public class CardKBDao extends AbstractJpaDao<Long, CardKB> {

	public CardKBDao() {
		super(CardKB.class);
	}

}
