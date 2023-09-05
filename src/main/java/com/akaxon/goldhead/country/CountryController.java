package com.akaxon.goldhead.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountry(){
        return countryService.getAllCountry();
    }

    @GetMapping("/{name}")
    public Country getCountryByName(@PathVariable("name") String name){
        return countryService.getCountryByName(name);
    }


    @GetMapping("/{name}/cities")
    public CountryWithCities getCountryByNameWithCities(@PathVariable("name") String name){
        return countryService.getCountryByNameWithCities(name);
    }

    @PostMapping
    public String createNewCountry(@RequestBody @Valid Country country){
        return countryService.createNewCountry(country);
    }



}
