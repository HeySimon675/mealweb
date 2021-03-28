package br.com.topi.mealweb.controller;

import br.com.topi.mealweb.service.MealService;
import br.com.topi.mealweb.utils.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService service;

    @GetMapping
    public String findByParams(@RequestParam(value = "page", defaultValue = "a")String initial, @RequestParam(value = "name")String name, Model model){
        model.addAttribute("pageLetter", Letter.valueOf(initial.toUpperCase()));
        model.addAttribute("pageList", service.findByParams(initial,name));


        return "meals/mealList";
    }

}
