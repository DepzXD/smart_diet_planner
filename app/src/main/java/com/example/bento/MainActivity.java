package com.example.bento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  private BottomNavigationView bottomNavigationView;
  private final HomeFragment homeFragment = new HomeFragment();
  private final ProfileFragment profileFragment = new ProfileFragment();
  private final InterviewFragment interviewFragment = new InterviewFragment();
  private final ProgressFragment progressFragment = new ProgressFragment();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bottomNavigationView = findViewById(R.id.bottomNavigationView);
    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

    bottomNavigationView.setOnItemSelectedListener(item -> {
      if (item.getItemId() == R.id.home) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
        return true;
      } else if(item.getItemId() == R.id.profile) {
          getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
          return true;
      } else if (item.getItemId() == R.id.progress) {
          getSupportFragmentManager().beginTransaction().replace(R.id.container, progressFragment).commit();
          return true;
      } else if (item.getItemId() == R.id.interview) {
          getSupportFragmentManager().beginTransaction().replace(R.id.container, interviewFragment).commit();
          return true;
      } else { return false; }

    });
  }
}