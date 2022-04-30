package com.example.bento.Listeners;

import com.example.bento.Models.MealDetailRes;

public interface MealDetailListener {
  void didFetch(MealDetailRes res, String msg);
  void didError(String msg);
}
