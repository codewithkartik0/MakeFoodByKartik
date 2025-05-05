package com.example.makeyourfoodkartik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VegActivity extends AppCompatActivity {
    Button paneerbuttermasala, vegetablebiryani, pastaprimavera, chickpeacurry, vegetablestirfry, mushroomstroganoff, palakpaneer, vegetablelasagna, aloogobi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg); // create this XML file also

        paneerbuttermasala = findViewById(R.id.Paneer_Butter_Masala);
        vegetablebiryani = findViewById(R.id.Vegetable_Biryani);
        pastaprimavera = findViewById(R.id.Pasta_Primavera);
        chickpeacurry = findViewById(R.id.Chickpea_Curry);
        vegetablestirfry = findViewById(R.id.Vegetable_Stir_Fry);
        mushroomstroganoff = findViewById(R.id.Mushroom_Stroganoff);
        palakpaneer = findViewById(R.id.Palak_Paneer);
        vegetablelasagna = findViewById(R.id.Vegetable_Lasagna);
        aloogobi = findViewById(R.id.Aloo_Gobi);
        paneerbuttermasala.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, PannerButterMasalaActivity.class));
        });
        vegetablebiryani.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, VegetableBiryaniActivity.class));
        });
        pastaprimavera.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, PastaPrimaveraActivity.class));
        });
        chickpeacurry.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, ChickpeaCurryActivity.class));
        });
        vegetablestirfry.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, VegetableStirFryActivity.class));
        });
        mushroomstroganoff.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, MushroomStroganoffActivity.class));
        });
        palakpaneer.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, PalakPaneerActivity.class));
        });
        vegetablelasagna.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, VegetableLasagnaActivity.class));
        });
        aloogobi.setOnClickListener(v -> {
            startActivity(new Intent(VegActivity.this, AlooGobiActivity.class));
        });
        // Add more buttons and their corresponding activities as needed


    }
}
