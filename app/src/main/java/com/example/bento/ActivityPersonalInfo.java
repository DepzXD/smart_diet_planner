package com.example.bento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityPersonalInfo extends AppCompatActivity {
    private TextView PersTxt, GenderTxt;
    private EditText editTextAge;
    private EditText editTextHeight;
    private EditText editTextWeight;
    private RadioGroup GenderGroup;
    private RadioButton radioMale, radioFemale;
    private Spinner spinnerDiet;
    private Button Submitbtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        PersTxt = findViewById(R.id.PersTxt);
        GenderTxt = findViewById(R.id.GenderTxt);
        editTextAge = findViewById(R.id.editTextAge);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);

        GenderGroup = findViewById(R.id.GenderGroup);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        spinnerDiet = findViewById(R.id.spinnerDiet);
        Submitbtn = findViewById(R.id.Submitbtn);

        //SPINNER DIET CODE
        List<String> Diet = new ArrayList<>();
        Diet.add(0, "Select Diet");
        Diet.add("Glueten Free");
        Diet.add("Ketogenic");
        Diet.add("Vegetarian");
        Diet.add("Lacto-Vegetarian");
        Diet.add("Vegan");
        Diet.add("Pescetarian");
        Diet.add("Paleo");
        Diet.add("Primal");
        Diet.add("Low FODMAP");
        Diet.add("Whole30");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Diet);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiet.setAdapter(arrayAdapter);

        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextAge.getText().toString().isEmpty()){
                    Toast.makeText(ActivityPersonalInfo.this, "Please enter Age ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(editTextHeight.getText().toString().isEmpty()){
                    Toast.makeText(ActivityPersonalInfo.this, "Please enter Height ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editTextWeight.getText().toString().isEmpty()){
                    Toast.makeText(ActivityPersonalInfo.this, "Please enter Weight ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (GenderGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(ActivityPersonalInfo.this, "Please select Gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = Integer.parseInt(editTextAge.getText().toString());
                int height = Integer.parseInt(editTextHeight.getText().toString());
                int weight = Integer.parseInt(editTextWeight.getText().toString());
                double brm = 0;
                if (radioMale.isChecked()){
                    brm = (10 * weight) + (6.25*height)-(5*age) + 5;
                }
                else{
                    brm = (10*weight)+(6.25*height)-(5*age) -161;
                }

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                assert user != null;
                mDatabase.child("users").child(user.getUid()).child("age").setValue(age);
                mDatabase.child("users").child(user.getUid()).child("height").setValue(height);
                mDatabase.child("users").child(user.getUid()).child("weight").setValue(weight);
                mDatabase.child("users").child(user.getUid()).child("brm").setValue(brm);
                mDatabase.child("users").child(user.getUid()).child("diet").setValue(spinnerDiet.getSelectedItem().toString());
                startActivity(new Intent(ActivityPersonalInfo.this, MainActivity.class));
                finish();
            }
        });

    }




}
