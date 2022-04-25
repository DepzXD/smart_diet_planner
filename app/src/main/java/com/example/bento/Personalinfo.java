package com.example.bento;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.snackbar.Snackbar;

public class Personalinfo extends AppCompatActivity {

    private Button button303;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        button303 = (Button) findViewById(R.id.button303);

        button303.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

    }


    public void openMainActivity(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }



}


