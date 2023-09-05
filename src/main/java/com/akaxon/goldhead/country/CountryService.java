package com.akaxon.goldhead.country;

import com.akaxon.goldhead.city.City;
import com.akaxon.goldhead.city.CityService;
import com.akaxon.goldhead.exception.ApiRequestException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final CityService cityService;

    @Autowired
    public CountryService(CountryRepository countryRepository, CityService cityService) {
        this.countryRepository = countryRepository;
        this.cityService = cityService;
    }

    List<Country> getAllCountry(){
        return countryRepository.findAllCountry();
    }

    Country getCountryByName(String name){
        String lowerCaseName = name.toLowerCase();
        return countryRepository.findCountryByName(lowerCaseName);
    }

    CountryWithCities getCountryByNameWithCities(String name){

        Country country = this.getCountryByName(name);
        List<City> cities = cityService.getCitiesByCountryName(name);

        return new CountryWithCities(
                country.getName(),
                country.getCreatedAt(),
                country.getUpdatedAt(),
                cities
        );
    }

     String createNewCountry(Country country){
        try {
            LocalDate nowCreatedAt = Optional.ofNullable(country.getCreatedAt()).orElse(LocalDate.now());
            country.setCreatedAt(nowCreatedAt);

            LocalDate nowUpdatedAt = Optional.ofNullable(country.getUpdatedAt()).orElse(LocalDate.now());
            country.setUpdatedAt(nowUpdatedAt);

            String capitalizedName = StringUtils.capitalize(country.getName().toLowerCase());
            country.setName(capitalizedName);

            countryRepository.insertCountry(country);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }

        return "Saved Successful";

    }

}
