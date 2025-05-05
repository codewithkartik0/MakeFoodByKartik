package com.example.makeyourfoodkartik;

public class Recipe {
    public int id;
    public String title;
    public String ingredients;
    public String steps;
    public String imagePath;

    public Recipe(int id, String title, String ingredients, String steps, String imagePath) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.imagePath = imagePath;
    }
}
