package com.akaxon.goldhead.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCitiesByCountryName(String countryName){
        String lowerCaseName = countryName.toLowerCase();
        return cityRepository.findCityByCountryName(lowerCaseName);
    }

}
