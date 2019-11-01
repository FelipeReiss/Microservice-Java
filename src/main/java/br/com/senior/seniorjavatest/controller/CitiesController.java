package br.com.senior.seniorjavatest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.senior.seniorjavatest.model.City;
import br.com.senior.seniorjavatest.service.CityService;

@RestController
@RequestMapping("/cities")
public class CitiesController {
	
	@Autowired
	private CityService services;
	
	// Method to upload CSV files to database
	@PostMapping(value = "/upload",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<City> fileUpload(@RequestParam("file") MultipartFile file) {
		return services.uploadCsv(file);
	}
	
	// Method to insert a new city at database
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public City insertCity(@RequestBody City city) {
		return services.insertCity(city);
	}
	
	// Method to update a existent city at database
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public City updateCity(@RequestBody City city) {
		return services.updateCity(city);
	}
	
	// Method to delete some city
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCity(@PathVariable("id") String id) {
		services.deleteCity(id);
	}
	
	// Method to get total of cities at database
	@GetMapping(value = "/total",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Long getTotal() {
		return services.getTotal();
	}
	
	// Method to get total of cities at database
	@GetMapping(value = "/bigger-distance",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCitiesMostDistant() {
		return services.getCitiesMostDistant();
	}
	
	// Method to get only Capitals (considering the database will have what is or not capital)
	@GetMapping(value = "/capitals",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<City> findCapitals() {
		return services.findCapitals();
	}
	
	// Method to get least and most numbers of cities by state
	@GetMapping(value = "/states/least-most",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String findStatesLimits() {
		return services.LeastMostCitiesByState();
	}
	
	// Method to get a cities number list by state
	@GetMapping(value = "/states",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String findCitiesByState() {
		return services.findStatesCountCities();
	}
	
	// Method to get a single city through IBGE ID 
	@GetMapping(value = "/ibge/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public City findByIbgeId(@PathVariable("id") String id) {
		return services.findByIbgeId(id);
	}
	
	// Method to get a list city to a specific state
	@GetMapping(value = "/states/{state}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCitiesByState(@PathVariable("state") String state) {
		return services.getCitiesByState(state);
	}
	
	// Method to get number of unique records to a specific column 
	// or filter strings to specific column, unique values as well 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCities(
			@RequestParam(value="column", defaultValue="") String column,
			@RequestParam(value="filter", defaultValue="") String filter) {
		return services.getCitiesByColumn(column,filter);
	}
}
