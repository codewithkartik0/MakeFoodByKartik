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

import com.example.makeyourfoodkartik.DatabaseHelper;
import com.example.makeyourfoodkartik.R;

public class AddRecipeActivity extends AppCompatActivity {

    private EditText recipeName, ingredients, steps;
    private ImageView recipeImage;
    private Button saveRecipeButton;
    private Uri selectedImageUri; // For storing the selected image URI

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe_activity);

        recipeName = findViewById(R.id.recipeName);
        ingredients = findViewById(R.id.ingredients);
        steps = findViewById(R.id.steps);
        recipeImage = findViewById(R.id.recipeImage);
        saveRecipeButton = findViewById(R.id.saveRecipeButton);

        // Set up image selection onClick
        recipeImage.setOnClickListener(v -> selectImage());

        // Save button click listener
        saveRecipeButton.setOnClickListener(v -> saveRecipe());
    }

    // Function to open an image picker
    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);  // Request code 1 for image selection
    }

    // Handle image selection result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            recipeImage.setImageURI(selectedImageUri);  // Display selected image
        }
    }

    // Save the recipe data (for simplicity, you can use SharedPreferences or SQLite to store it)
    private void saveRecipe() {
        String name = recipeName.getText().toString();
        String ingredientsText = ingredients.getText().toString();
        String stepsText = steps.getText().toString();

        // You can save this data to SQLite database or SharedPreferences for persistence.
        // Here is an example of saving to SQLite:

        SQLiteDatabase db = new DatabaseHelper(this).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("recipe_name", name);
        values.put("ingredients", ingredientsText);
        values.put("steps", stepsText);

        if (selectedImageUri != null) {
            values.put("image_uri", selectedImageUri.toString()); // Store image URI as string
        }

        long newRowId = db.insert("recipes", null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Recipe saved successfully", Toast.LENGTH_SHORT).show();
            finish();  // Close the activity and return to the previous one
        } else {
            Toast.makeText(this, "Failed to save recipe", Toast.LENGTH_SHORT).show();
        }
    }
}
