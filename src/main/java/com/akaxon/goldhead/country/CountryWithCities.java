package com.akaxon.goldhead.country;

import com.akaxon.goldhead.city.City;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class CountryWithCities {
    private String name;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    private List<City> cities;


    public CountryWithCities(
            @JsonProperty("name") String name,
            @JsonProperty("createdAt") LocalDate createdAt,
            @JsonProperty("updatedAt") LocalDate updatedAt,
            @JsonProperty("cities") List<City> cities) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
