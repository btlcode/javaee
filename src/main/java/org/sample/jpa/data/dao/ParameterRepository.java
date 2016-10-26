package org.sample.jpa.data.dao;

import org.sample.jpa.data.model.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long>, ParameterRepositoryCustom {

	public Page<Parameter> findByNameContainingAllIgnoringCase(final String name, final Pageable pageable);

}
