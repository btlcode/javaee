package org.sample.jpa.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.sample.jpa.data.model.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ParameterRepositoryImpl implements ParameterRepositoryCustom {

	transient static final Logger LOG = LoggerFactory.getLogger(ParameterRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Parameter> getNamesLike(final String name) {
		LOG.debug("getByName query start with {} ", name);
		TypedQuery<Parameter> query = entityManager.createNamedQuery("Parameter.getByName", Parameter.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

}
