package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.CountryService;
import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@Component
@RequestMapping("/countries") 
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@Autowired
	private CountryService countryService;


	@GetMapping
	public List<Country> getAllCountries() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return countryService.getAllCountries();
	}

	@GetMapping(value = "{id}")
	public Country getCountryByCode(@PathVariable("id") String id) throws CountryNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		return countryService.findCountryById(id);
	}


	@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Started the POST request");
		LOGGER.debug("Country details: {}" , country);
		LOGGER.info("End!!");
		return country;
	}
}
