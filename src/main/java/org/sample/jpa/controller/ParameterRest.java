package org.sample.jpa.controller;

import java.util.Date;
import java.util.List;

import org.sample.jpa.data.model.Parameter;
import org.sample.jpa.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "parameterRest")
@RequestMapping(path = "/rest")
public class ParameterRest {

	@Autowired
	private ParameterService cityService;

	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	@RequestMapping(path = "/findAll")
	public List<Parameter> findAll() {
		List<Parameter> restval = this.cityService.findAll();
		restval.add(new Parameter());
		restval.get(0).setName("Test Param Rest");
		restval.get(0).setId(1);
		restval.get(0).setStartDate(new Date());

		return restval;
	}

}
