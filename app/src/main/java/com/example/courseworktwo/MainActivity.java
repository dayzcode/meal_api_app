package com.example.courseworktwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText searchQueryEditText;
    private Button addMealsButton;
    private Button searchByIngredientButton;
    private Button searchMealsButton;
    private RecyclerView recyclerViewMeals;
    private MealsAdapter mealsAdapter;
    private TheMealDBService mealDBService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        searchQueryEditText = findViewById(R.id.editTextSearchQuery);
        addMealsButton = findViewById(R.id.btnAddMealsToDB);
        searchByIngredientButton = findViewById(R.id.btnSearchMealsByIngredient);
        searchMealsButton = findViewById(R.id.btnSearchMeals);
        recyclerViewMeals = findViewById(R.id.recyclerViewMeals);

        // Set up Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/") // Base URL of the API
                .addConverterFactory(GsonConverterFactory.create()) // JSON converter
                .build();

        // Initialize the MealDBService
        mealDBService = retrofit.create(TheMealDBService.class);

        // Set up RecyclerView
        mealsAdapter = new MealsAdapter(this);
        recyclerViewMeals.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMeals.setAdapter(mealsAdapter);

        // Set click listeners for buttons
        addMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to add meals to the local database
                // TODO: Add logic for adding meals
            }
        });

        searchByIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to search meals by ingredient
                String ingredient = searchQueryEditText.getText().toString();
                if (!ingredient.isEmpty()) {
                    filterMealsByIngredient(ingredient);
                }
            }
        });

        searchMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to search meals by user input
                String mealName = searchQueryEditText.getText().toString();
                if (!mealName.isEmpty()) {
                    searchMealsByName(mealName);
                }
            }
        });
    }

    // API call to search meals by name
    private void searchMealsByName(String mealName) {
        Call<MealResponse> call = mealDBService.searchMealsByName(mealName);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful()) {
                    MealResponse mealResponse = response.body();
                    if (mealResponse != null) {
                        List<Meal> meals = mealResponse.getMeals();
                        mealsAdapter.setMeals(meals);
                    }
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    // API call to filter meals by ingredient
    private void filterMealsByIngredient(String ingredient) {
        Call<MealResponse> call = mealDBService.listMealsByIngredient(ingredient);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful()) {
                    MealResponse mealResponse = response.body();
                    if (mealResponse != null) {
                        List<Meal> meals = mealResponse.getMeals();
                        mealsAdapter.setMeals(meals);
                    }
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    // Add the methods to fulfill the remaining marking criteria here

    // For example:
    // Method to add meals to the local database
    // private void addMealsToDatabase() {
    //     // Implement the logic to add meals to the local database
    // }
    // Method to add meals to the local database
    private void addMealsToDatabase(List<Meal> meals) {
        // Initialize the Room database
        AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "meal-database").build();

        // Create a new thread for database operations
        new Thread(() -> {
            // Get the DAO (Data Access Object) for meals
            MealDao mealDao = database.mealDao();

            // Insert meals into the database

            // Close the database
            database.close();
        }).start();
    }

}
