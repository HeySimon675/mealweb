package br.com.topi.mealweb.controller;

import br.com.topi.mealweb.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService service;

    @GetMapping
    public String findByParams(@RequestParam(value = "initial", defaultValue = "a")String initial){


        return "meals/mealList";
    }

}
