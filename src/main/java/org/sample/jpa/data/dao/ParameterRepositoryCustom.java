package org.sample.jpa.data.dao;

import java.util.List;

import org.sample.jpa.data.model.Parameter;

public interface ParameterRepositoryCustom {

	public List<Parameter> getNamesLike(final String name);
}
