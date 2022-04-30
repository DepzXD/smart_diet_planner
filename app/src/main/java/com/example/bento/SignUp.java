package com.example.bento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUp extends AppCompatActivity {

    private EditText emailTxt, userNameTxt, passwordTxt;
    TextView toSignIn;
    private Button signUpBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        emailTxt = findViewById(R.id.setEmailEditTxt);
        userNameTxt = findViewById(R.id.setUserNameEditTxt);
        passwordTxt = findViewById(R.id.setPasswordEditTxt);
        signUpBtn = findViewById(R.id.signUpBtn);
        toSignIn = findViewById(R.id.mvToSignInBtn);

        toSignIn.setOnClickListener(view -> {
            startActivity(new Intent(this, Signin.class));
            finish();
        });

        signUpBtn.setOnClickListener(view -> {
            String name, email, password;
            name = userNameTxt.getText().toString();
            email = emailTxt.getText().toString();
            password = passwordTxt.getText().toString();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .setPhotoUri(Uri.parse("https://raw.githubusercontent.com/DepzXD/bento/main/assets/defaultProfile.jpg"))
                            .build();
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        assert user != null;
                        user.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        showMain();
                                    }
                                }
                            });
                    } else {
                        Toast.makeText(SignUp.this, "Authentication Failed Try with something else", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
    }

    void showMain(){
        Intent intent = new Intent(this, ActivityPersonalInfo.class);
        startActivity(intent);
        finish();
    }

}