package br.com.topi.mealweb.repository;

import br.com.topi.mealweb.dto.MealDTOList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealRepository {

    @GET("search.php")
    Call<MealDTOList> findByInitial(@Query("f")String initial);

    @GET("search.php")
    Call<MealDTOList> findByName(@Query("s")String mealName);


}
