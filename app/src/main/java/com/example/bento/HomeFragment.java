package com.example.bento;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateRecView {
  private RecyclerView mealsCategoryRecView;
  public RecyclerView mealsRecView;
  private ArrayList<MealCategoryModel> mealCategoryModels = new ArrayList<>();
  private MealsCategoryRecycleViewAdapter mealsCategoryRecycleViewAdapter;
  private RecyclerView progressCardRecView;
  private ArrayList<ProgressModel> progressModels;
  private boolean toggleMeals = false;

  public HomeFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
    mealsRecView = root.findViewById(R.id.mealsRecView);
    mealsCategoryRecView = root.findViewById(R.id.mealsCategoryRecView);
    setMealCategoryModels();
    mealsCategoryRecycleViewAdapter = new MealsCategoryRecycleViewAdapter(root.getContext(), mealCategoryModels, this);
    mealsCategoryRecView.setAdapter(mealsCategoryRecycleViewAdapter);
    mealsCategoryRecView.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false));


    MealsRecycleViewAdapter mealsRecycleViewAdapter = new MealsRecycleViewAdapter(getContext(), new ArrayList<>(), this);
    mealsRecView.setAdapter(mealsRecycleViewAdapter);
    mealsRecView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

    progressModels = new ArrayList<>();
    progressModels.add(new ProgressModel("Calories","Kcal", R.color.green, 20));
    progressModels.add(new ProgressModel("Carbs","Kcal", R.color.blue, 40));
    progressModels.add(new ProgressModel("Protean","Kcal", R.color.pink, 10));
    progressModels.add(new ProgressModel("Fat","Kcal", R.color.yellow, 90));
    progressCardRecView = root.findViewById(R.id.progressCardRecView);
    ProgressRecycleViewAdapter progressRecycleViewAdapter = new ProgressRecycleViewAdapter(getContext(), progressModels);
    progressCardRecView.setAdapter(progressRecycleViewAdapter);
    progressCardRecView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    return root;
  }

  private void setMealCategoryModels() {
    String[] cardTitles = getResources().getStringArray(R.array.mealsCategorys);
    for (String cardTitle : cardTitles) {
      mealCategoryModels.add(new MealCategoryModel(cardTitle, ""));
    }
  }

  @SuppressLint("NotifyDataSetChanged")
  @Override
  public void callback(int position, ArrayList<MealModel> item) {
    if (!toggleMeals) {
      mealsRecView.setVisibility(View.GONE);
      toggleMeals = !toggleMeals;
      return;
    } else {
      mealsRecView.setVisibility(View.VISIBLE);
      toggleMeals = !toggleMeals;
    }
    MealsRecycleViewAdapter mealsRecycleViewAdapter = new MealsRecycleViewAdapter(getContext(), item, this);
    mealsRecycleViewAdapter.notifyDataSetChanged();
    mealsRecView.setAdapter(mealsRecycleViewAdapter);
  }

  @Override
  public void updateList(int position, MealModel meal) {
    mealCategoryModels.get(position).cardImageUrl = meal.cardImageUrl;

    mealsCategoryRecycleViewAdapter.notifyItemChanged(position);
    mealsRecView.setVisibility(View.GONE);
    toggleMeals = !toggleMeals;
  }
}