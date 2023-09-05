package com.akaxon.goldhead.city;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class City {

    private final String name;
    @NotBlank
    private final String countryName;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;

    public City(
            @JsonProperty("name") String name,
            @JsonProperty("countryName") String countryName,
            @JsonProperty("createdAt") LocalDate createdAt,
            @JsonProperty("updatedAt") LocalDate updatedAt) {
        this.name = name;
        this.countryName = countryName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
}
