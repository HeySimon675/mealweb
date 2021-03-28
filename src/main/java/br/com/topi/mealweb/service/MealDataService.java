package br.com.topi.mealweb.service;

import br.com.topi.mealweb.dto.MealDTOList;
import br.com.topi.mealweb.repository.MealClient;
import br.com.topi.mealweb.repository.MealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service
public class MealDataService {

    private final MealRepository repository;

    private Logger logger = LoggerFactory.getLogger(MealDataService.class);

    public MealDataService() {
        repository = MealClient.getMealApi();
    }

    public MealDTOList findMealsByInitial(String initial) {
        MealDTOList mealDTOList = new MealDTOList();

        try {
                Response<MealDTOList> mealsResponse = repository.findByInitial(initial).execute();
                mealDTOList = mealsResponse.body();
        } catch (IOException e) {
            logger.error("Erro ao buscar refeições", e);
        }

        return mealDTOList;
    }

    public MealDTOList findMealsByName(String name) {
        MealDTOList mealDTOList = new MealDTOList();
        try {
            Response<MealDTOList> mealsResponse = repository.findByName(name).execute();
            mealDTOList = mealsResponse.body();
        } catch (IOException e) {
            logger.error("Erro ao buscar refeições", e);
        }
        return mealDTOList;

    }
}
