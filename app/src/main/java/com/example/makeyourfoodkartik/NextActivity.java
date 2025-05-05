package com.example.makeyourfoodkartik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    Button buttonNonVeg, buttonVeg, buttonNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next); // Make sure your XML file is named activity_next.xml

        buttonNonVeg = findViewById(R.id.non_veg);
        buttonVeg = findViewById(R.id.veg);
        buttonNew = findViewById(R.id.button);  // This is the "new" button from your layout

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
