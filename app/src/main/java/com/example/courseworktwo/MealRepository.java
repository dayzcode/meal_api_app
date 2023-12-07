package com.example.courseworktwo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;


public class MealRepository {
    private MealDao mealDao;
    private LiveData<List<Meal>> allMeals;

    public MealRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        mealDao = database.mealDao();
        allMeals = mealDao.getAllMeals();
    }

    public void insertMeals(List<Meal> meals) {
        AppDatabase.databaseWriteExecutor.execute(() -> mealDao.insertMeals(meals));
    }

    public LiveData<List<Meal>> getAllMeals() {
        return allMeals;
    }

    public LiveData<List<Meal>> findMealsByName(String name) {
        return mealDao.findMealsByName(name);

    }}