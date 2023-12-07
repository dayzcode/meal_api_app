package com.example.courseworktwo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meals")
public class Meal {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "strMeal")
    private String strMeal;

    @ColumnInfo(name = "strDrinkAlternate")
    private String strDrinkAlternate;

    @ColumnInfo(name = "strCategory")
    private String strCategory;

    @ColumnInfo(name = "strArea")
    private String strArea;

    @ColumnInfo(name = "strMealThumb")
    private String strMealThumb;

    @ColumnInfo(name = "strTags")
    private String strTags;

    @ColumnInfo(name = "strYoutube")
    private String strYoutube;

    @ColumnInfo(name = "strSource")
    private String strSource;

    @ColumnInfo(name = "strIngredient1")
    private String strIngredient1;

    @ColumnInfo(name = "strIngredient2")
    private String strIngredient2;

    @ColumnInfo(name = "strIngredient3")
    private String strIngredient3;

    @ColumnInfo(name = "strIngredient4")
    private String strIngredient4;

    @ColumnInfo(name = "strIngredient5")
    private String strIngredient5;

    // Getter and Setter methods for all fields

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }
}
