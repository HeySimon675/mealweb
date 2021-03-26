package br.com.topi.mealweb.dto;

public class MealDTO {

    private Long id;

    private String strMeal;

    private String strCategory;

    private String strMealTumb;

    private String strMealInstructions;

    public MealDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrMealTumb() {
        return strMealTumb;
    }

    public void setStrMealTumb(String strMealTumb) {
        this.strMealTumb = strMealTumb;
    }

    public String getStrMealInstructions() {
        return strMealInstructions;
    }

    public void setStrMealInstructions(String strMealInstructions) {
        this.strMealInstructions = strMealInstructions;
    }
}
