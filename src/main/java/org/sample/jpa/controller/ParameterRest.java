package org.sample.jpa.controller;

import java.util.Date;
import java.util.List;

import org.sample.jpa.data.model.Parameter;
import org.sample.jpa.service.ParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "parameterRest")
@RequestMapping(path = "/rest")
public class ParameterRest {

	transient static final Logger LOG = LoggerFactory.getLogger(ParameterRest.class);

	@Autowired
	private ParameterService parameterService;

	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	@RequestMapping(path = "/findAll")
	public List<Parameter> findAll() {
		List<Parameter> restval = this.parameterService.findAllCustom();
		restval.add(new Parameter());
		restval.get(0).setName("Test Param Rest");
		restval.get(0).setId(1);
		restval.get(0).setStartDate(new Date());

		return restval;
	}

	@GetMapping("/")
	@ResponseBody()
	@Transactional(readOnly = true)
	@RequestMapping(path = "/getByName")
	public List<Parameter> getByName(@RequestParam(name = "name", defaultValue = "33") final String name) {
		LOG.debug("start rest service");
		List<Parameter> restval = parameterService.findNamesLike(name);
		restval.add(new Parameter());
		restval.get(restval.size() - 1).setName("Test Param Rest");
		restval.get(restval.size() - 1).setId(1);
		restval.get(restval.size() - 1).setStartDate(new Date());
		LOG.debug("end rest service retval.size {}", restval.size());
		return restval;
	}

	@RequestMapping(value = "/parameters", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody()
	public HttpEntity<PagedResources<Parameter>> parameters(Pageable pageable, PagedResourcesAssembler assembler) {

		Page<Parameter> parameters = parameterService.findAll(pageable);
		return new ResponseEntity<>(assembler.toResource(parameters), HttpStatus.OK);
	}

}
