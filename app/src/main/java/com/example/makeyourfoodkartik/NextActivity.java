package com.example.makeyourfoodkartik;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    Button buttonNonVeg, buttonVeg, buttonNew, viewRecipesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next); // Make sure your XML file is named activity_next.xml

        // Initialize buttons
        buttonNonVeg = findViewById(R.id.non_veg);
        buttonVeg = findViewById(R.id.veg);
        buttonNew = findViewById(R.id.button);  // This is the "new" button from your layout
        viewRecipesBtn = findViewById(R.id.button2); // Make sure this matches the ID in XML

        // Set the View Recipes button click listener
        viewRecipesBtn.setOnClickListener(v -> {
            Log.d("NextActivity", "View Recipes button clicked");  // Debugging Log
            startActivity(new Intent(NextActivity.this, RecipeListActivity.class));
        });

        // Navigate to NonVegActivity
        buttonNonVeg.setOnClickListener(v -> {
            startActivity(new Intent(NextActivity.this, NonVegActivity.class));
        });

        // Navigate to VegActivity
        buttonVeg.setOnClickListener(v -> {
            startActivity(new Intent(NextActivity.this, VegActivity.class));
        });

        // Navigate to AddRecipeActivity when "new" button is clicked
        buttonNew.setOnClickListener(v -> {
            startActivity(new Intent(NextActivity.this, AddRecipeActivity.class));
        });
    }
}
