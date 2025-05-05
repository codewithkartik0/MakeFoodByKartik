package com.example.makeyourfoodkartik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    Button buttonNonVeg, buttonVeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        buttonNonVeg = findViewById(R.id.non_veg);
        buttonVeg = findViewById(R.id.veg);
        buttonNonVeg.setOnClickListener(v -> {
            startActivity(new Intent(NextActivity.this, NonVegActivity.class));
        });
        buttonVeg.setOnClickListener(v -> {
            startActivity(new Intent(NextActivity.this, VegActivity.class));
        });
    }
}

