package com.example.bento;

public class MealCategoryModel {
  String cardTitle;
  String cardImageUrl;

  public MealCategoryModel() {

  }

  public MealCategoryModel(String cardTitle, String cardImageUrl) {
    this.cardTitle = cardTitle;
    this.cardImageUrl = cardImageUrl;
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
}
