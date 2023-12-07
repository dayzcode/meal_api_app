package com.example.courseworktwo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMealDBService {
    // Define the endpoint for searching meals by ingredient
    @GET("filter.php")
    Call<MealResponse> getMealsByIngredient(@Query("i") String ingredient);
    @GET("search.php")
    Call<MealResponse> searchMealsByName(@Query("s") String mealName);

    @GET("filter.php")
    Call<MealResponse> listMealsByIngredient(@Query("i") String ingredient);

    @GET("lookup.php")
    Call<MealResponse> getMealDetailsById(@Query("i") int mealId);

    @GET("random.php")
    Call<MealResponse> getRandomMeal();

    // Add more methods for other endpoints as needed
}
