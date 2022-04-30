package com.example.bento;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bento.Listeners.MealDetailListener;
import com.example.bento.Listeners.MealPlanListener;
import com.example.bento.Models.MealDetailRes;
import com.example.bento.Models.MealPlanRes;

import java.util.ArrayList;

public class InterviewFragment extends Fragment implements UpdateDayRecView {

  RecyclerView mealDetailRecView, weeksRecView;
  RequestManager manager;
  ArrayList<MealModel> mealModels;
  ArrayList<String> weekDayModel;
  int tempPos;
  public InterviewFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_interview, container, false);
    mealDetailRecView = root.findViewById(R.id.meal_detail_recview);
    weeksRecView = root.findViewById(R.id.weeksRecView);
    weekDayModel = new ArrayList<>();
    weekDayModel.add("Mon");
    weekDayModel.add("Tue");
    weekDayModel.add("Wed");
    weekDayModel.add("Thu");
    weekDayModel.add("Fri");
    weekDayModel.add("Sat");
    weekDayModel.add("Sun");
    WeekRecViewAdaptor weekRecViewAdaptor = new WeekRecViewAdaptor(getContext(), weekDayModel, this);
    weeksRecView.setAdapter(weekRecViewAdaptor);
    weeksRecView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    mealDetailRecView.setLayoutManager(new LinearLayoutManager(getContext()));
    return root;
  }

  @Override
  public void updateMealModel(int pos, ArrayList<MealModel> mealModels) {
    MealDetailRecViewAdaptor adaptor = new MealDetailRecViewAdaptor(getContext(), mealModels);
    adaptor.notifyDataSetChanged();
    mealDetailRecView.setAdapter(adaptor);
  }
}