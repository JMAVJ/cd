package me.cd.countries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cd.countries.services.ApiService;

@RestController
public class MainController {
    private final ApiService apiService;

    public MainController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/")
    public List<Object> index() {
        // List<Object> output = new ArrayList<>();
        // for (Object country : apiService.findCountryByLanguage("slovene")) {
        //     output.add((Country) country);
        // }
        // System.out.println(apiService.findCountryByLanguage("slovene"));
        
        // return apiService.findCountryByLanguage("english");
        // return apiService.sortCountriesByCityAmount();
        // return apiService.sortByCityPopulation("Mexico");
        // return apiService.getLanguages();
        // return apiService.sortByArea();
        // return apiService.getByGovernment("Constitutional Monarchy");
        // return apiService.getCountryCitiesByDistrict("Argentina");
        return apiService.getCountryAmountByRegion();
    }
}
