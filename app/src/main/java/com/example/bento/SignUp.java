package com.example.bento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class SignUp extends AppCompatActivity {

    private Button button11;
    private Button button220;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        button11 = (Button) findViewById(R.id.button11);
        button220 = (Button) findViewById(R.id.button220);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignin();
            }
        });

        button220.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button220(view);

                openpersonalinfo();
            }
        });

    }

    public void openSignin(){

        Intent intent = new Intent(this,Signin.class);
        startActivity(intent);

    }

    public  void openpersonalinfo(){

        Intent intent = new Intent(this,Personalinfo.class);
        startActivity(intent);

    }
    //3rd activity


    public void Button220(View v) {
        Snackbar.make(v, "Button clicked." , Snackbar.LENGTH_LONG)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).setActionTextColor(getResources().getColor(R.color.green))
                .show();

    }


}