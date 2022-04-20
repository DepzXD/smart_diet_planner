package com.example.bento;

import java.util.ArrayList;

public interface UpdateRecView {
  void callback(int position, ArrayList<MealModel> mealModels);
  void updateList(int position, MealModel meal);
}
