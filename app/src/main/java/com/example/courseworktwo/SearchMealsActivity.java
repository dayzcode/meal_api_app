package com.example.courseworktwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchMealsActivity extends AppCompatActivity {

    private EditText ingredientEditText;
    private Button retrieveMealsButton;
    private Button saveMealsButton;
    private TextView mealDetailsTextView;

    // Retrofit instance for API requests
    private Retrofit retrofit;
    private TheMealDBService mealService;

    // MealRepository for database operations
    private MealRepository mealRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_meals);

        ingredientEditText = findViewById(R.id.ingredientEditText);
        retrieveMealsButton = findViewById(R.id.retrieveMealsButton);
        saveMealsButton = findViewById(R.id.saveMealsButton);
        mealDetailsTextView = findViewById(R.id.mealDetailsTextView);

        // Create a Retrofit instance for API requests
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create a MealService instance
        mealService = retrofit.create(TheMealDBService.class);

        // Initialize MealRepository
        mealRepository = new MealRepository(getApplication());

        retrieveMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve meals based on the ingredient
                String ingredient = ingredientEditText.getText().toString();
                retrieveMealsFromApi(ingredient);
            }
        });

        saveMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement saving meal details to the database
                String mealDetails = mealDetailsTextView.getText().toString();
                saveMealsToDatabase(mealDetails);
            }
        });
    }

    private void retrieveMealsFromApi(String ingredient) {
        // Make an API request to retrieve meals containing the specified ingredient
        Call<MealResponse> call = mealService.getMealsByIngredient(ingredient);

        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Handle the API response and display meal details
                    MealResponse mealResponse = response.body();
                    displayMealDetails(mealResponse);
                } else {
                    // Handle API error
                    mealDetailsTextView.setText("Error: Unable to retrieve meals.");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                // Handle API request failure
                mealDetailsTextView.setText("Error: Failed to retrieve meals.");
            }
        });
    }

    private void displayMealDetails(MealResponse mealResponse) {
        // Extract meal details from the response and display them in mealDetailsTextView
        // You can format the details as needed for your UI
        // For example, iterate through mealResponse.getMeals() to access individual meals
        // and their details.
    }

    private void saveMealsToDatabase(String mealDetails) {
        // Implement saving meal details to the database
        // Parse the mealDetails JSON and insert it into your Room database using MealRepository.
        // You can call a method in MealRepository to perform the insertion.
    }
}
