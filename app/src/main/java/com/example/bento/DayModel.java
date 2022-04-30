package com.example.bento;

public class DayModel {
  String name;
  int date;

  public DayModel(String name) {
    this.name = name;
  }

  public DayModel(String name, int date) {
    this.name = name;
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }
}
