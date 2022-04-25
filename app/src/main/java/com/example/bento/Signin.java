package com.example.bento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    private EditText emailTxt, passwordTxt;
    TextView toSignUp;
    private Button signInBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        emailTxt = findViewById(R.id.usrEmailEditTxt);
        passwordTxt = findViewById(R.id.passwordEditTxt);
        signInBtn = findViewById(R.id.signInBtn);
        toSignUp = findViewById(R.id.mvvToSignUpBtn);

        toSignUp.setOnClickListener(view -> {
                startActivity(new Intent(this, SignUp.class));
                finish();
        });

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            signInBtn.setOnClickListener(view -> {
                String email, password;
                email = emailTxt.getText().toString();
                password = passwordTxt.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Please Provide Correct Details", Toast.LENGTH_SHORT).show();
                } else{

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            navToHome();
                        } else {
                            Toast.makeText(Signin.this, "Sign In Failed, Try Valid Combo!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                }
            });
        }
    }
    void navToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}