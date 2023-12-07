package com.example.courseworktwo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewMealsActivity extends AppCompatActivity {
    private MealViewModel mealViewModel;
    private RecyclerView recyclerView;
    private MealsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_meals);

        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        recyclerView = findViewById(R.id.recyclerViewMeals);
        adapter = new MealsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mealViewModel.getAllMeals().observe(this, meals -> {
            adapter.setMeals(meals);
        });
    }
}
