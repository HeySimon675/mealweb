package br.com.topi.mealweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"", "/home"})
    public String home(){
        return "redirect:/meals";
    }

    @GetMapping("/error")
    public String erro() {
        return "error";
    }

}
