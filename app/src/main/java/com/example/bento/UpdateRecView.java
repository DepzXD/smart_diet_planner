package com.example.bento;


import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public interface UpdateRecView {
  void callback(int position, ArrayList<MealModel> mealModels, MaterialCardView cardView);
  void updateList(int position, MealModel meal);
}
