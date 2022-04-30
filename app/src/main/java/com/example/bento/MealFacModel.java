package com.example.bento;

import java.util.Random;

public class MealFacModel {
  String url;
  int pro;
  int carbs;
  int fat;
  int cal;
  int id;

  public MealFacModel() {

  }
  public MealFacModel(int id, String url, int pro, int carbs, int fat) {
    this.url = url;
    this.id = id;
    this.pro = pro;
    this.carbs = carbs;
    this.fat = fat;

//    Random random = new Random();
//    int value = random.nextInt(200 + 90) + 90;
    cal = 550;
  }
}
