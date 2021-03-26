package br.com.topi.mealweb.service;

import br.com.topi.mealweb.dto.MealsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    MealDataService dataService;

    public MealsDTO findByInitialLetter(String initial){
        return dataService.findMealsByInitial(initial);
    }


}
