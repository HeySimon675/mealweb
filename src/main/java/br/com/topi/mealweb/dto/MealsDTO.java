package br.com.topi.mealweb.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MealsDTO {

    @SerializedName("meals")
    @Expose
    private List<MealDTO> meals;

    public MealsDTO() {
        meals = null;
    }

    public List<MealDTO> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDTO> meals) {
        this.meals = meals;
    }
}
