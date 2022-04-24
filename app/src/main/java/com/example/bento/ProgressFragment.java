package com.example.bento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ProgressFragment extends Fragment {
  private RecyclerView weeklyProgressRecView;
  private ArrayList<ProgressModel> progressModels;

  public ProgressFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_progress, container, false);

    weeklyProgressRecView = root.findViewById(R.id.weeklyProgressRecView);
    progressModels = new ArrayList<>();
    progressModels.add(new ProgressModel("Calories","Kcal", R.color.green, 10));
    progressModels.add(new ProgressModel("Carbs","Kcal", R.color.blue, 80));
    progressModels.add(new ProgressModel("Protean","Kcal", R.color.pink, 20));
    progressModels.add(new ProgressModel("Fat","Kcal", R.color.yellow, 60));
    ProgressRecycleViewAdapter progressRecycleViewAdapter = new ProgressRecycleViewAdapter(getContext(),progressModels);
    weeklyProgressRecView.setAdapter(progressRecycleViewAdapter);
    weeklyProgressRecView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    return root;
  }
}