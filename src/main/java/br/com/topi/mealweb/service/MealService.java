package br.com.topi.mealweb.service;

import br.com.topi.mealweb.dto.MealDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    MealDataService dataService;

    public List<MealDTO> findByInitialLetter(String initial){
        return dataService.findMealsByInitial(initial).getMeals();
    }


}
