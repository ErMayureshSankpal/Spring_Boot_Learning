package com.example.company.controller;

import com.example.company.kafkaservice.KafkaProducer;
import com.example.company.model.Countries;
import com.example.company.repo.CountryRepo;
import org.apache.logging.log4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    private static final Logger log = LogManager.getLogger(CountriesController.class);


    @Value("${spring.application.name}")
    String appName;

    @Autowired
    CountryRepo countryRepo;

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/app")
    public String getAppName(){
        log.info("Getting AppName - {}",appName);
        return appName;
    }

    @GetMapping("/all")
    public List<Countries> getAllCountries(){
        log.info("Entering into CountriesController.getAllCountries().");
        return countryRepo.findAll();
    }

    @GetMapping("/byName")
    public Countries getByName(@RequestParam String contName){
        log.info("Entering into CountriesController.getByName(@RequestParam String contName).");
        return countryRepo.findByCountryName(contName);
    }

    @GetMapping("/byRegCode")
    public Countries getByRegionCodeAndName(@RequestParam long code, @RequestParam String name){
        log.info("Entering into CountriesController.getByRegionCodeAndName(@RequestParam long code, @RequestParam String name)");
        return countryRepo.findByRegionIdAndCountryName(code, name);
    }

    @PostMapping("/addCountry")
    public Countries addCountry(@RequestBody Countries countries){
        log.info("Entering into CountriesController.addCountry(@RequestBody Countries countries), country name - {} Added.",countries.getCountryName());
        kafkaProducer.sendMsg(countries);
        return countryRepo.save(countries);
    }
}
