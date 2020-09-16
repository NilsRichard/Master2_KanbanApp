package fr.istic.taa.jaxrs.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.UserKB;

public class UserKBDao extends AbstractJpaDao<Long, UserKB> {

	public UserKBDao() {
		super(UserKB.class);
	}

	public UserKB findByName(String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserKB> cq = cb.createQuery(UserKB.class);

		Root<UserKB> user = cq.from(UserKB.class);
		Predicate predicate = cb.equal(user.get("name"), name);
		cq.where(predicate);

		TypedQuery<UserKB> query = entityManager.createQuery(cq);
		return query.getSingleResult();
	}

}
