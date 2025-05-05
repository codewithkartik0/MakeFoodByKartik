package com.example.makeyourfoodkartik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NonVegActivity extends AppCompatActivity {
    Button tandoori ,butter,afghani,chilli,curry,garlic,malai,chicken65,kolhapuri,vindaloo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonveg); // create this XML file also
        tandoori = findViewById(R.id.tandoori_chicken);
        butter = findViewById(R.id.butter_chicken);
        afghani = findViewById(R.id.afghani_chicken);
        chilli = findViewById(R.id.chilli_chicken);
        curry = findViewById(R.id.chicken_curry);
        garlic = findViewById(R.id.garlic_chicken);
        malai = findViewById(R.id.malai_chicken);
        chicken65 = findViewById(R.id.chicken65);
        kolhapuri = findViewById(R.id.chicken_kolhapuri);
        vindaloo = findViewById(R.id.chicken_vindaloo);

        tandoori.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, TandooriChickenActivity.class));
        });
        butter.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, ButterChickenActivity.class));
        });
        afghani.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, AfghaniChickenActivity.class));
        });
        chilli.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, ChilliChickenActivity.class));
        });
        curry.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, ChickenCurryActivity.class));
        });
        garlic.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, GarlicChickenActivity.class));
        });
        malai.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, MalaiChickenActivity.class));
        });
        chicken65.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, Chicken65Activity.class));
        });
        kolhapuri.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, ChickenKolhapuriActivity.class));
        });
        vindaloo.setOnClickListener(v -> {
            startActivity(new Intent(NonVegActivity.this, ChickenVindalooActivity.class));
        });

    }
}
