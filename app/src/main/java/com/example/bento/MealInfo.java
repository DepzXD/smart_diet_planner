package com.example.bento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MealInfo extends AppCompatActivity {
    private TextView mealName, fatTxt, proteinTxt, carbsTxt, calTxt, recTxt;
    ImageView mealImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_info);
        mealName =findViewById(R.id.meal_info__name);
        mealImg = findViewById(R.id.meaInfolImg);
        fatTxt = findViewById(R.id.fatTxt);
        proteinTxt = findViewById(R.id.protienTxt);
        carbsTxt = findViewById(R.id.carbsTxt);
        recTxt = findViewById(R.id.resTxt);
        calTxt = findViewById(R.id.calTxt);
        Intent intent = getIntent();
        fatTxt.setText(intent.getStringExtra("fat"));
        proteinTxt.setText(intent.getStringExtra("protein"));
        carbsTxt.setText(intent.getStringExtra("carbs"));
        calTxt.setText(intent.getStringExtra("cal"));
        mealName.setText(intent.getStringExtra("name"));
        recTxt.setText("coming Soon!");
        String url = "https://heeasdasa44ds.asdakd.jpg";
//        Glide.with(this).asBitmap().load(url).into(mealImg);
        mealImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background));
    }
}