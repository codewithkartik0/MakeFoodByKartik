package com.example.makeyourfoodkartik;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeListActivity extends AppCompatActivity {
    RecyclerView recipeRecyclerView;
    RecipeAdapter adapter;
    List<Recipe> recipeList;
    DatabaseHelper databaseHelper;  // To reuse the helper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        // Initialize the database helper and RecyclerView
        databaseHelper = new DatabaseHelper(this);
        recipeRecyclerView = findViewById(R.id.recipeRecyclerView);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeList = new ArrayList<>();
        loadRecipesFromDatabase();

        // If recipes were loaded, set the adapter
        if (recipeList.isEmpty()) {
            Toast.makeText(this, "No recipes found!", Toast.LENGTH_SHORT).show();
        } else {
            adapter = new RecipeAdapter(this, recipeList);
            recipeRecyclerView.setAdapter(adapter);
        }
    }

    private void loadRecipesFromDatabase() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery("SELECT * FROM recipes", null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                    String ingredients = cursor.getString(cursor.getColumnIndexOrThrow("ingredients"));
                    String steps = cursor.getString(cursor.getColumnIndexOrThrow("steps"));
                    String imagePath = cursor.getString(cursor.getColumnIndexOrThrow("imagePath"));

                    // Add the recipe to the list
                    recipeList.add(new Recipe(id, title, ingredients, steps, imagePath));
                } while (cursor.moveToNext());
            } else {
                // In case the cursor is empty, handle it
                Toast.makeText(this, "No recipes available in the database", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            // Handle any unexpected errors that might occur during database query
            e.printStackTrace();
            Toast.makeText(this, "Error loading recipes", Toast.LENGTH_SHORT).show();
        } finally {
            if (cursor != null) {
                cursor.close();  // Ensure cursor is always closed to avoid memory leaks
            }
        }
    }
}
