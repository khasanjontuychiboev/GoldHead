package com.akaxon.goldhead.country;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {
    @GetMapping
    public void getAllCountries(){
        System.out.println("hello countries!");
    }
}
