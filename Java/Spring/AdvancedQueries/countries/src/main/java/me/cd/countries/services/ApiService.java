package me.cd.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import me.cd.countries.repositories.CountryRepository;

@Service
public class ApiService {
    private final CountryRepository countryRepository;

    public ApiService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Object> findCountryByLanguage(String language) {
        return countryRepository.joinCountryByLanguage(language);
    }

    public List<Object> sortCountriesByCityAmount() {
        return countryRepository.sortCountriesByCityAmount();
    }

    public List<Object> sortByCityPopulation(String country) {
        return countryRepository.sortByCityPopulation(country);
    }

    public List<Object> getLanguages() {
        return countryRepository.getLanguages();
    }

    public List<Object> sortByArea() {
        return countryRepository.sortByArea();
    }

    public List<Object> getByGovernment(String type) {
        return countryRepository.getByGovernmentType(type);
    }

    public List<Object> getCountryCitiesByDistrict(String country) {
        return countryRepository.getCountryCitiesByDistrict(country);
    }

    public List<Object> getCountryAmountByRegion() {
        return countryRepository.getCountryAmountByRegion();
    }
}
