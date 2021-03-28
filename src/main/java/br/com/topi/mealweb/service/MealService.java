package br.com.topi.mealweb.service;

import br.com.topi.mealweb.dto.MealDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    MealDataService dataService;

    public List<MealDTO> findByParams(String initial,String name){
        if(name != null){
            return findByName(name);
        }
        return findByInitialLetter(initial);

    }

    private List<MealDTO> findByName(String name){
        return dataService.findMealsByName(name).getMeals();
    }

    private List<MealDTO> findByInitialLetter(String initial){
        return dataService.findMealsByInitial(initial).getMeals();
    }


}
