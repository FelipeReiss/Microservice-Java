package br.com.senior.seniorjavatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senior.seniorjavatest.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query(value = "select * from city where id_ibge = ?1", nativeQuery = true)
    City findByIbgeId(String idIbge);

	@Query(value = "select * from city where is_capital is true order by name", nativeQuery = true)
	List<City> findCapitals();
	
	@Query(value = "select name from city where state = ?1", nativeQuery = true)
	List<String> getCitiesByState(String state);
	
	@Query(value = "select state, count(*) as `cities` from city group by state order by `cities`, state", nativeQuery = true)
	String[][] getStatesCountCities();
}
