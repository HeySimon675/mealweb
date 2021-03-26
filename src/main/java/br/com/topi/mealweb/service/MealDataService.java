package br.com.topi.mealweb.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MealDataService {

    private final RestTemplate restTemplate;

    public MealDataService() {
        restTemplate = new RestTemplateBuilder().rootUri("https://www.themealdb.com/api/json/v1/1/").build();
    }

}
