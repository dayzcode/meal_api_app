package com.example.courseworktwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealViewHolder> {

    private final Context context;
    private List<Meal> meals;

    public MealsAdapter(Context context) {
        this.context = context;
        this.meals = new ArrayList<>(); // Initialize the list here
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = meals.get(position);

        // Set the meal name to the TextView
        holder.mealNameTextView.setText(meal.getStrMeal());

        // Load the meal image using Glide
        Glide.with(context)
                .load(meal.getStrMealThumb())
                .into(holder.mealImageView);
    }

    @Override
    public int getItemCount() {
        return meals != null ? meals.size() : 0;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        ImageView mealImageView;
        TextView mealNameTextView;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            mealImageView = itemView.findViewById(R.id.imageViewMeal);
            mealNameTextView = itemView.findViewById(R.id.textViewMealName);
        }
    }
}
