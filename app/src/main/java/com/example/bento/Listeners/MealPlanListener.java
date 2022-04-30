package com.example.bento.Listeners;

import com.example.bento.Models.MealPlanRes;

public interface MealPlanListener {
  void didFetch(MealPlanRes res, String msg);
  void didError(String msg);
}
