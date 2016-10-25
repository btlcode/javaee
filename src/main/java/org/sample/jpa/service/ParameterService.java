package org.sample.jpa.service;

import java.util.List;

import org.sample.jpa.data.dao.IParameterRepository;
import org.sample.jpa.data.model.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional
@Component("parameterService")
public class ParameterService {

	@Autowired
	private transient IParameterRepository parameterRepo;

	public Page<Parameter> findCities(String name, Pageable pageable) {

		Assert.notNull(name, "Criteria must not be null");

		return this.parameterRepo.findByNameContainingAllIgnoringCase(name.trim(), pageable);
	}

	public List<Parameter> findAll() {
		return this.parameterRepo.findAll();
	}

}
