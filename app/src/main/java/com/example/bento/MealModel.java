package com.example.bento;

public class MealModel extends MealCategoryModel {
  int position;
  int carbs;
  int calories;
  int fat;
  int protein;

  public MealModel() {
    super();
  }

  public MealModel(int position, String cardTitle, String cardImageUrl, int carbs, int calories, int fat, int protein) {
    super(cardTitle, cardImageUrl);
    this.carbs = carbs;
    this.calories = calories;
    this.fat = fat;
    this.protein = protein;
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public String getCardTitle() {
    return cardTitle;
  }

  public void setCardTitle(String cardTitle) {
    this.cardTitle = cardTitle;
  }

  public String getCardImageUrl() {
    return cardImageUrl;
  }

  public void setCardImageUrl(String cardImageUrl) {
    this.cardImageUrl = cardImageUrl;
  }

  public int getCarbs() {
    return carbs;
  }

  public void setCarbs(int carbs) {
    this.carbs = carbs;
  }

  public int getCalories() {
    return calories;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  public int getFat() {
    return fat;
  }

  public void setFat(int fat) {
    this.fat = fat;
  }

  public int getProtein() {
    return protein;
  }

  public void setProtein(int protein) {
    this.protein = protein;
  }
}
