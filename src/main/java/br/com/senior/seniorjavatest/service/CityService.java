package br.com.senior.seniorjavatest.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.senior.seniorjavatest.exception.FileUploadErrorException;
import br.com.senior.seniorjavatest.exception.ResourceNotFoundException;
import br.com.senior.seniorjavatest.exception.UnsupportedOperationException;
import br.com.senior.seniorjavatest.model.City;
import br.com.senior.seniorjavatest.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository repository;
		
	private String[][] getStatesCountCities() {
				
		String[][] content = repository.getStatesCountCities();
		
		if(content.length == 0) 
			throw new ResourceNotFoundException("Sorry, we don't have baseline yet. "
					+ "Please, try upload values at path /cities/upload");
		
		return content;
	}
	
	private boolean isNumeric(String strNumber) {
		if (strNumber == null) 
			return false;
		
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	private boolean hasNumeric(String strWord) {
		if (strWord == null) 
			return false;
		
		return strWord.matches((".*\\d.*"));
	}
	
	public City findById(Long id) {
		return repository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for ID: " + id));
	}
	
	public List<City> findAll() {
		return repository.findAll();
	}
	
	public Long getTotal() {
		return repository.count();
	}
	
	public List<City> findCapitals(){
		return repository.findCapitals();
	}
	
	public void deleteCity(String id) {
		if(!isNumeric(id))
			throw new UnsupportedOperationException("Please, use only numbers to find by ID");
		
		City city = repository.findById(Long.parseLong(id)).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for ID: " + id));
		
		repository.delete(city);
	}
	
	public City insertCity(City city) {
		return repository.save(city);
	}
	
	public City updateCity(City city) {
		City cityToUpdate = repository.findById(city.getId()).orElseThrow(()
				-> new ResourceNotFoundException("No records found for ID: " + city.getId()));
		
		cityToUpdate.setCapital(city.isCapital());
		cityToUpdate.setIdIbge(city.getIdIbge());
		cityToUpdate.setName(city.getName());
		cityToUpdate.setPopulation(city.getPopulation());
		cityToUpdate.setState(city.getState());

		return repository.save(cityToUpdate);
	}

	public String LeastMostCitiesByState() { 
		JSONArray jsonArrayLeasts = new JSONArray();
		JSONArray jsonArrayMosts = new JSONArray();
		JSONObject jsonResponse = new JSONObject();

		String[][] statesCounted = getStatesCountCities();
		
		int lastValue = statesCounted.length - 1;
		int leastCitiesNumber = Integer.parseInt(statesCounted[0][1]);
		int mostCitiesNumber = Integer.parseInt(statesCounted[lastValue][1]);
		
		for (int i = 0; i < statesCounted.length; i++) {
			JSONObject jsonObj = new JSONObject();

			jsonObj.put("State", statesCounted[i][0]);
			jsonObj.put("Cities", statesCounted[i][1]);

			if(Integer.parseInt(statesCounted[i][1]) == leastCitiesNumber)	
				jsonArrayLeasts.put(jsonObj);
		
			if(Integer.parseInt(statesCounted[i][1]) == mostCitiesNumber)
				jsonArrayMosts.put(jsonObj);
		}
			
		jsonResponse.put("Leats_Cities_States",jsonArrayLeasts);
		jsonResponse.put("Mosts_Cities_States",jsonArrayMosts);
		
		return jsonResponse.toString();
	}
	
	public List<City> uploadCsv(MultipartFile file){
		try {
			String fileLines = new String();
			Scanner reader = new Scanner(file.getInputStream());
			
			reader.nextLine();
			
			while(reader.hasNextLine()) {
				fileLines = reader.nextLine();
			
				String[] column = fileLines.split(",");
				
				City city = new City();
				city.setIdIbge(column[0]);
				city.setCapital(Boolean.parseBoolean(column[1]));
				city.setName(column[2]);
				city.setPopulation(Long.parseLong(column[3]));
				city.setState(column[4]);
				
				repository.save(city);
			}
			
			reader.close();
			
			return findAll();
			
		} catch (Exception e) {
			throw new FileUploadErrorException("Sorry, for some reason isn't "
					+ "possible upload your file. Details: " + e.getMessage());
		}
	}

	public String findStatesCountCities() {
		String[][] statesCounted = getStatesCountCities();
	
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonResponse = new JSONObject();
		
		for (int i = 0; i < statesCounted.length; i++) {
			JSONObject jsonObj = new JSONObject();
			
			jsonObj.put("State", statesCounted[i][0]);
			jsonObj.put("Cities", statesCounted[i][1]);
			
			jsonArray.put(jsonObj);
		} 
		
		jsonResponse.put("States_Cities_Counted", jsonArray);
		
		return jsonResponse.toString();
	}
		
	public List<String> getCitiesByState(String state) {
		if(hasNumeric(state) || state.length() != 2) {
			throw new UnsupportedOperationException("Please, use only 2 letters to get cities by state");
		}
		
		List<String> cities = repository.getCitiesByState(state);
		
		if(cities.isEmpty()) {
			throw new ResourceNotFoundException("This state does't exists at baseline. Please, try again!");
		}
		
		return cities;
	}

	public City findByIbgeId(String id) {	
		City city = repository.findByIbgeId(id);
		
		if(city == null) {
			throw new ResourceNotFoundException("This IBGE ID does't exists at baseline. Please, try again!");
		}
		
		return city;
	}

	public List<String> getCitiesByColumn(String column, String filter) {
		if(column.isBlank())
			return null;
		
		List<String> contentResponse = new ArrayList<String>();

		List<City> allRecords = repository.findAll();
		
		if(allRecords.isEmpty()) 
			throw new ResourceNotFoundException("Sorry, we don't have baseline yet. Please, "
					+ "try upload values at path /cities/upload");

		for(City city: allRecords) {
			switch (column) {
			case "name":
				contentResponse.add(city.getName());
				break;
				
			case "id_ibge":
				contentResponse.add(city.getIdIbge());
				break;
			
			case "state":
				contentResponse.add(city.getState());
				break;
				
			case "population":
					contentResponse.add(city.getPopulation().toString());
				break;
			
			case "is_capital":
				if (city.isCapital()) {
					contentResponse.add("true");
				} else {
					contentResponse.add("flase");
				}
				break;
				
			default:
				throw new ResourceNotFoundException("Sorry, the column '" 
						+ column + "' does't exists. Please, try again!");
			}
		}
		
		LinkedHashSet<String> hashSetClean = new LinkedHashSet<>(contentResponse);
		contentResponse.clear();
        contentResponse = new ArrayList<>(hashSetClean);
         
		if(filter.isBlank()) {
			String numberItens = contentResponse.size() + "";
			contentResponse.clear();
			contentResponse.add(numberItens);
		} else {
			contentResponse.removeIf(s -> !s.contains(filter));
		}

		return contentResponse;
	}
	
}
