package com.example.courseworktwo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MealDetailsActivity extends AppCompatActivity {

    private TextView mealDetailsTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_meals);

        // Initialize TextView
        mealDetailsTextView = findViewById(R.id.mealDetailsTextView);

        // Retrieve meal details from intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("mealDetails")) {
            String mealDetails = intent.getStringExtra("mealDetails");
            mealDetailsTextView.setText(mealDetails);
        } else {
            mealDetailsTextView.setText("No meal details available.");
        }
    }
}
