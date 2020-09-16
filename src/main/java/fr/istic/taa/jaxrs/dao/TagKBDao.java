package fr.istic.taa.jaxrs.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.TagKB;

public class TagKBDao extends AbstractJpaDao<Long, TagKB> {

	public TagKBDao() {
		super(TagKB.class);
	}
	
	public TagKB findByLabel(String label) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<TagKB> cq = cb.createQuery(TagKB.class);

		Root<TagKB> tag = cq.from(TagKB.class);
		Predicate predicate = cb.equal(tag.get("label"), label);
		cq.where(predicate);

		TypedQuery<TagKB> query = entityManager.createQuery(cq);
		return query.getSingleResult();
	}

}
