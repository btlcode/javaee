package org.sample.jpa.data.dao;

import java.util.List;

import org.sample.jpa.data.model.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface IParameterRepository extends Repository<Parameter, Long> {

	public List<Parameter> findAll();

	public Page<Parameter> findByNameContainingAllIgnoringCase(final String name, final Pageable pageable);

}
