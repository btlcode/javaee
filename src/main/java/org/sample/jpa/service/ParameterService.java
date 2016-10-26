package org.sample.jpa.service;

import java.util.List;

import org.sample.jpa.controller.ParameterRest;
import org.sample.jpa.data.dao.ParameterRepository;
import org.sample.jpa.data.dao.impl.ParameterDAO;
import org.sample.jpa.data.model.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional
@Component("parameterService")
public class ParameterService {

	transient static final Logger LOG = LoggerFactory.getLogger(ParameterRest.class);

	@Autowired
	private transient ParameterRepository parameterRepository;

	@Autowired
	private transient ParameterDAO parameterDAO;

	public Page<Parameter> findParameter(String name, Pageable pageable) {
		Assert.notNull(name, "Criteria must not be null");
		return parameterRepository.findByNameContainingAllIgnoringCase(name.trim(), pageable);
	}

	public Page<Parameter> findAll(Pageable pageable) {
		LOG.debug("service layer parameterRepository");
		return parameterRepository.findAll(pageable);
	}

	public List<Parameter> findAllCustom() {
		LOG.debug("service layer parameterDAO");
		//return parameterDAO.findAll();
		return null;
	}

	public List<Parameter> findNamesLike(final String name) {
		LOG.debug("service layer");
		return parameterRepository.getNamesLike(name);
	}

}
