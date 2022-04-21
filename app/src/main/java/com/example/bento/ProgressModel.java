package com.example.bento;

public class ProgressModel {
  String title;
  String shortName;
  int color;
  int progress;

  public ProgressModel(String title, String shortName, int color, int progress) {
    this.title = title;
    this.shortName = shortName;
    this.color = color;
    this.progress = progress;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }
}
