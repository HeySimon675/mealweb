package br.com.topi.mealweb.repository;

import br.com.topi.mealweb.dto.MealsDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealRepository {

    @GET("search.php")
    Call<MealsDTO> findByInitial(@Query("f")String initial);


}
