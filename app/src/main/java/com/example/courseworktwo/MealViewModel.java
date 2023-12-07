package com.example.courseworktwo;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MealViewModel extends AndroidViewModel {
    private MealRepository repository;
    private LiveData<List<Meal>> allMeals;
    private MutableLiveData<List<Meal>> mealsByIngredient;

    public MealViewModel(Application application) {
        super(application);
        repository = new MealRepository(application);
        allMeals = repository.getAllMeals();
        mealsByIngredient = new MutableLiveData<>();
    }

    // Method to get all meals
    public LiveData<List<Meal>> getAllMeals() {
        return allMeals;
    }

    // Method to add predefined meals to the database
    public void addPredefinedMeals() {
        List<Meal> predefinedMeals = getPredefinedMeals();
        repository.insertMeals(predefinedMeals);
    }

    // Method to handle API response and update LiveData
    public void handleApiResponse(MealResponse response) {
        // Convert response to a list of Meal objects and post it to the LiveData
        // Implement this based on your MealResponse structure
        List<Meal> meals = convertResponseToMeals(response);
        mealsByIngredient.postValue(meals);
    }

    // Placeholder method to convert MealResponse to a list of Meal objects
    private List<Meal> convertResponseToMeals(MealResponse response) {
        // Implement conversion logic based on MealResponse structure
        // This is just a placeholder
        return null;
    }

    // Method to get meals by ingredient
    public LiveData<List<Meal>> getMealsByIngredient() {
        return mealsByIngredient;
    }

    // Method to generate predefined meals
    private List<Meal> getPredefinedMeals() {
        List<Meal> meals = new ArrayList<>();

        meals.add(new Meal());
        meals.get(0).setId(1);
        meals.get(0).setStrMeal("Sweet and Sour Pork");
        meals.get(0).setStrCategory("Pork");
        meals.get(0).setStrArea("Chinese");
        meals.get(0).setStrMealThumb("https://www.themealdb.com/images/media/meals/1529442316.jpg");
        meals.get(0).setStrTags("Sweet");
        meals.get(0).setStrYoutube("https://www.youtube.com/watch?v=mdaBIhgEAMo");
        meals.get(0).setStrIngredient1("Pork");
        meals.get(0).setStrIngredient2("Egg");
        meals.get(0).setStrIngredient3("Water");
        meals.get(0).setStrIngredient4("Salt");
        meals.get(0).setStrIngredient5("Sugar");

        meals.add(new Meal());
        meals.get(1).setId(2);
        meals.get(1).setStrMeal("Chicken Marengo");
        meals.get(1).setStrCategory("Chicken");
        meals.get(1).setStrArea("French");
        meals.get(1).setStrMealThumb("https://www.themealdb.com/images/media/meals/qpxvuq1511798906.jpg");
        meals.get(1).setStrYoutube("https://www.youtube.com/watch?v=U33HYUr-0Fw");
        meals.get(1).setStrIngredient1("Olive Oil");
        meals.get(1).setStrIngredient2("Mushrooms");
        meals.get(1).setStrIngredient3("Chicken Legs");
        meals.get(1).setStrIngredient4("Passata");
        meals.get(1).setStrIngredient5("Chicken Stock Cube");

        // Add more predefined meals as needed

        return meals;
    }

    // Additional ViewModel methods...
}
