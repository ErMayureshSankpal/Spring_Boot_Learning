package com.example.company.controller;

import com.example.company.model.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/callApi")
public class CallApiController {

    private static final Logger log = LogManager.getLogger(CallApiController.class);

    @GetMapping("/allCountries")
    public List<Countries> getAllCountriesThroughCallApi(){
        log.info("Entering into CallApiController.getAllCountriesThroughCallApi().");
        String url = "http://localhost:8080/countries";
//        System.out.println(url);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        builder.path("/all");

        System.out.println(builder.toUriString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Countries>> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Countries>>() {});

        return responseEntity.getBody();
    }
}
