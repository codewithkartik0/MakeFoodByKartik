package com.example.makeyourfoodkartik;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddRecipeActivity extends AppCompatActivity {

    private EditText recipeName, ingredients, steps;
    private ImageView recipeImage;
    private Button saveRecipeButton;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe_activity);

        recipeName = findViewById(R.id.recipeName);
        ingredients = findViewById(R.id.ingredients);
        steps = findViewById(R.id.steps);
        recipeImage = findViewById(R.id.recipeImage);
        saveRecipeButton = findViewById(R.id.saveRecipeButton);

        recipeImage.setOnClickListener(v -> selectImage());
        saveRecipeButton.setOnClickListener(v -> saveRecipe());
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            recipeImage.setImageURI(selectedImageUri);
        }
    }

    private void saveRecipe() {
        String name = recipeName.getText().toString().trim();
        String ingredientsText = ingredients.getText().toString().trim();
        String stepsText = steps.getText().toString().trim();

        if (name.isEmpty() || ingredientsText.isEmpty() || stepsText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = new DatabaseHelper(this).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", name);  // Correct column name
        values.put("ingredients", ingredientsText);
        values.put("steps", stepsText);

        if (selectedImageUri != null) {
            values.put("imagePath", selectedImageUri.toString()); // Correct column name
        }

        long newRowId = db.insert("recipes", null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Recipe saved successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Failed to save recipe", Toast.LENGTH_SHORT).show();
        }
    }
}
