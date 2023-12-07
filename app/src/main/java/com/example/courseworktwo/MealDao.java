package com.example.courseworktwo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeals(List<Meal> meals);

    @Query("SELECT * FROM meals WHERE strMeal LIKE '%' || :name || '%'")
    LiveData<List<Meal>> findMealsByName(String name);

    @Query("SELECT * FROM meals WHERE strIngredient1 LIKE '%' || :ingredient || '%' " +
            "OR strIngredient2 LIKE '%' || :ingredient || '%' " +
            "OR strIngredient3 LIKE '%' || :ingredient || '%' " +
            "OR strIngredient4 LIKE '%' || :ingredient || '%' " +
            "OR strIngredient5 LIKE '%' || :ingredient || '%' ")
    LiveData<List<Meal>> findMealsByIngredient(String ingredient);

    @Query("SELECT * FROM meals")
    LiveData<List<Meal>> getAllMeals();
}
