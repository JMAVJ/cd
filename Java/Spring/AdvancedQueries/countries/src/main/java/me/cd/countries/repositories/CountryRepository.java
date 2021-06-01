package me.cd.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cd.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    @Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage DESC")
    List<Object> joinCountryByLanguage(String language);

    @Query("SELECT a.name, (SELECT COUNT(*) FROM a.cities) as cities FROM Country a ORDER BY cities DESC")
    List<Object> sortCountriesByCityAmount();

    @Query("SELECT city.name, city.population FROM City city WHERE city.country.name = ?1 AND city.population > 500000 ORDER BY city.population DESC")
    List<Object> sortByCityPopulation(String country);

    @Query("SELECT l.country.name, l.language, l.percentage FROM Language l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
    List<Object> getLanguages();

    @Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501 AND c.population > 100000")
    List<Object> sortByArea();

    @Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form = ?1 AND c.surface_area > 200 AND c.life_expectancy > 75")
    List<Object> getByGovernmentType(String type);

    @Query("SELECT city.country.name, city.name, city.district, city.population FROM City city WHERE city.country.name = ?1 AND city.district = 'Buenos Aires' AND city.population > 500000")
    List<Object> getCountryCitiesByDistrict(String country);

    @Query("SELECT c.region, COUNT(*) as countries FROM Country c GROUP BY c.region ORDER BY countries DESC")
    List<Object> getCountryAmountByRegion();
}
