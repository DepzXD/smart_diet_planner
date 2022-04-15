package com.example.bento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
  private RecyclerView mealsCategoryRecView;
  private ArrayList<MealModel> mealCategoryModels = new ArrayList<>();
  public HomeFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
    mealsCategoryRecView = root.findViewById(R.id.mealsCategoryRecView);
    setMealCategoryModels();
    MealsRecycleViewAdapter adapter = new MealsRecycleViewAdapter(root.getContext(), mealCategoryModels);
    mealsCategoryRecView.setAdapter(adapter);
    LinearLayoutManager horizontalView = new LinearLayoutManager(root.getContext());
    horizontalView.setOrientation(LinearLayoutManager.HORIZONTAL);
    mealsCategoryRecView.setLayoutManager(horizontalView);
    return root;
  }

  private void setMealCategoryModels() {
    String [] cardTitles = getResources().getStringArray(R.array.mealsCategorys);
    String [] cardImgs = {"https://images.pexels.com/photos/2098085/pexels-photo-2098085.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",
        "//images.pexels.com/photos/3297363/pexels-photo-3297363.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",
        "https://images.pexels.com/photos/4518703/pexels-photo-4518703.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",
        "https://images.pexels.com/photos/1893573/pexels-photo-1893573.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",
        "https://images.pexels.com/photos/1893573/pexels-photo-1893573.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" };

    for(int i=0; i<cardTitles.length;i++){
      mealCategoryModels.add(new MealModel(cardTitles[i], cardImgs[i]));
    }
  }
}