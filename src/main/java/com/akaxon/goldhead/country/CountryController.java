package com.akaxon.goldhead.country;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {
    @GetMapping
    public void getAllCountries(){
        System.out.println("hello countries!");
    }
    @GetMapping(path = "/{id}")
    public void getCountry(@PathVariable("id") String id){
        System.out.println("One Country By ID");
    }
}
