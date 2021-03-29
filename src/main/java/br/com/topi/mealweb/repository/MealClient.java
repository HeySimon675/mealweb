package br.com.topi.mealweb.repository;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Duration;

public class MealClient {

    private static final String apiUrl = "https://www.themealdb.com/api/json/v1/1/";

    public static MealRepository getMealApi() {
        return MealClient.mealRetrofit().create(MealRepository.class);
    }

    private static Retrofit mealRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(apiUrl)
                .client(provideOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    static Interceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE);
    }

    static OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(Duration.ofMillis(8000))
                .readTimeout(Duration.ofMillis(15000))
                .addNetworkInterceptor(provideLoggingInterceptor())
                .build();
    }
}
