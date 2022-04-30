package com.example.bento;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bento.Listeners.MealDetailListener;
import com.example.bento.Listeners.MealPlanListener;
import com.example.bento.Models.MealDetailRes;
import com.example.bento.Models.MealPlanRes;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateRecView {
  private RecyclerView mealsCategoryRecView;
  public RecyclerView mealsRecView;
  private TextView greetUsrTxt;
  private ImageView profilePic;
  private ArrayList<MealCategoryModel> mealCategoryModels;
  private MealsCategoryRecycleViewAdapter mealsCategoryRecycleViewAdapter;
  private RecyclerView progressCardRecView;
  private ArrayList<ProgressModel> progressModels;
  private boolean toggleMeals = false;
  private int toggleCategoryPosition = -1;
  private FirebaseAuth mAuth;
  private DatabaseReference mDatabase;
  private ArrayList<MealModel> mealModels;
  private int pos;
  private FirebaseUser user;
  private RequestManager manager;
  ArrayList<MealModel> mon;
  ArrayList<MealModel> tue;
  ArrayList<MealModel> wed;
  ArrayList<MealModel> thu;
  ArrayList<MealModel> fri;
  ArrayList<MealModel> sat;
  ArrayList<MealModel> sun;
  public HomeFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
    mAuth = FirebaseAuth.getInstance();
    mDatabase = FirebaseDatabase.getInstance().getReference();
    manager = new RequestManager(getContext());
    if (null == mealModels) {
      manager.getMealPlan(listener);
    }
    user = mAuth.getCurrentUser();
    if (user == null) {
      getActivity().finish();
    }

    greetUsrTxt = root.findViewById(R.id.greetUserTxt);
    profilePic = root.findViewById(R.id.userProfile);
    Glide.with(getContext()).asBitmap().load(user.getPhotoUrl()).centerCrop().into(profilePic);
    greetUsrTxt.setText("Hi "+ user.getDisplayName());
    mealsRecView = root.findViewById(R.id.mealsRecView);
    mealsCategoryRecView = root.findViewById(R.id.mealsCategoryRecView);
    mDatabase.child("users").child(user.getUid()).child("week").child("mon").addValueEventListener(mealLis);
    MealsRecycleViewAdapter mealsRecycleViewAdapter = new MealsRecycleViewAdapter(getContext(), new ArrayList<>(), this);
    mealsRecView.setAdapter(mealsRecycleViewAdapter);
    mealsRecView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    if (mealCategoryModels != null) {
    mealsCategoryRecycleViewAdapter = new MealsCategoryRecycleViewAdapter(getContext(), mealCategoryModels);
    mealsCategoryRecView.setAdapter(mealsCategoryRecycleViewAdapter);
    mealsCategoryRecView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }
    progressModels = new ArrayList<>();
    progressModels.add(new ProgressModel("Calories","Kcal", R.color.green, 20));
    progressModels.add(new ProgressModel("Carbs","Kcal", R.color.blue, 40));
    progressModels.add(new ProgressModel("Protean","Kcal", R.color.pink, 10));
    progressModels.add(new ProgressModel("Fat","Kcal", R.color.yellow, 90));
    progressCardRecView = root.findViewById(R.id.progressCardRecView);
    ProgressRecycleViewAdapter progressRecycleViewAdapter = new ProgressRecycleViewAdapter(getContext(), progressModels);
    progressCardRecView.setAdapter(progressRecycleViewAdapter);
    progressCardRecView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    toggleMeals = false;

    return root;
  }

  @SuppressLint("NotifyDataSetChanged")
  @Override
  public void callback(int position, ArrayList<MealModel> item, MaterialCardView cardView) {
    if (toggleCategoryPosition == -1 && !toggleMeals) {
      mealsRecView.setVisibility(View.VISIBLE);
      toggleMeals = true;
      cardView.setStrokeWidth(20);
      toggleCategoryPosition = position;
      MealsRecycleViewAdapter mealsRecycleViewAdapter = new MealsRecycleViewAdapter(getContext(), item, this);
      mealsRecycleViewAdapter.notifyDataSetChanged();
      mealsRecView.setAdapter(mealsRecycleViewAdapter);
    } else if (toggleCategoryPosition == position && toggleMeals) {
      mealsRecView.setVisibility(View.GONE);
      toggleMeals = !toggleMeals;
      cardView.setStrokeWidth(0);
      toggleCategoryPosition = -1;
    }
  }

  @Override
  public void updateList(int position, MealModel meal) {
    mealCategoryModels.get(position).cardImageUrl = meal.cardImageUrl;

    mealsCategoryRecycleViewAdapter.notifyItemChanged(position);
    mealsRecView.setVisibility(View.GONE);
    toggleMeals = false;
    toggleCategoryPosition = -1;
  }

  public final MealPlanListener listener = new MealPlanListener(){
    @Override
    public void didFetch(MealPlanRes res, String msg) {
      mon = new ArrayList<>();
      tue = new ArrayList<>();
      wed = new ArrayList<>();
      thu = new ArrayList<>();
      fri = new ArrayList<>();
      sat = new ArrayList<>();
      ArrayList<MealModel> sun = new ArrayList<>();
      for (int i=0; i<res.week.monday.meals.size(); i++){
        mon.add(new MealModel(
            res.week.monday.meals.get(i).id,
            res.week.monday.meals.get(i).title,
            res.week.monday.meals.get(i).sourceUrl + "." + res.week.monday.meals.get(i).imageType,
            (int)(res.week.monday.nutrients.carbohydrates),
            (int)(res.week.monday.nutrients.calories),
            (int)(res.week.monday.nutrients.fat),
            (int)(res.week.monday.nutrients.protein)
        ));
        tue.add(new MealModel(
            res.week.tuesday.meals.get(i).id,
            res.week.tuesday.meals.get(i).title,
            res.week.tuesday.meals.get(i).sourceUrl + "." + res.week.monday.meals.get(i).imageType,
            (int)(res.week.tuesday.nutrients.carbohydrates),
            (int)(res.week.tuesday.nutrients.calories),
            (int)(res.week.tuesday.nutrients.fat),
            (int)(res.week.tuesday.nutrients.protein)
        ));
        wed.add(new MealModel(
            res.week.wednesday.meals.get(i).id,
            res.week.wednesday.meals.get(i).title,
            res.week.wednesday.meals.get(i).sourceUrl + "." + res.week.monday.meals.get(i).imageType,
            (int)(res.week.wednesday.nutrients.carbohydrates),
            (int)(res.week.wednesday.nutrients.calories),
            (int)(res.week.wednesday.nutrients.fat),
            (int)(res.week.wednesday.nutrients.protein)
        ));
        thu.add(new MealModel(
            res.week.thursday.meals.get(i).id,
            res.week.thursday.meals.get(i).title,
            res.week.thursday.meals.get(i).sourceUrl + "." + res.week.monday.meals.get(i).imageType,
            (int)(res.week.thursday.nutrients.carbohydrates),
            (int)(res.week.thursday.nutrients.calories),
            (int)(res.week.thursday.nutrients.fat),
            (int)(res.week.thursday.nutrients.protein)
        ));
        fri.add(new MealModel(
            res.week.friday.meals.get(i).id,
            res.week.friday.meals.get(i).title,
            res.week.friday.meals.get(i).sourceUrl + "." + res.week.monday.meals.get(i).imageType,
            (int)(res.week.friday.nutrients.carbohydrates),
            (int)(res.week.friday.nutrients.calories),
            (int)(res.week.friday.nutrients.fat),
            (int)(res.week.friday.nutrients.protein)
        ));
        sat.add(new MealModel(
            res.week.saturday.meals.get(i).id,
            res.week.saturday.meals.get(i).title,
            res.week.saturday.meals.get(i).sourceUrl + "." + res.week.monday.meals.get(i).imageType,
            (int)(res.week.saturday.nutrients.carbohydrates),
            (int)(res.week.saturday.nutrients.calories),
            (int)(res.week.saturday.nutrients.fat),
            (int)(res.week.saturday.nutrients.protein)
        ));
        sun.add(new MealModel(
            res.week.sunday.meals.get(i).id,
            res.week.sunday.meals.get(i).title,
            res.week.sunday.meals.get(i).sourceUrl + "." + res.week.monday.meals.get(i).imageType,
            (int)(res.week.sunday.nutrients.carbohydrates),
            (int)(res.week.sunday.nutrients.calories),
            (int)(res.week.sunday.nutrients.fat),
            (int)(res.week.sunday.nutrients.protein)
        ));
      }
        mDatabase.child("users").child(user.getUid()).child("week").child("mon").setValue(mon);
        mDatabase.child("users").child(user.getUid()).child("week").child("tue").setValue(tue);
        mDatabase.child("users").child(user.getUid()).child("week").child("wed").setValue(wed);
        mDatabase.child("users").child(user.getUid()).child("week").child("thu").setValue(thu);
        mDatabase.child("users").child(user.getUid()).child("week").child("fri").setValue(fri);
        mDatabase.child("users").child(user.getUid()).child("week").child("sat").setValue(sat);
        mDatabase.child("users").child(user.getUid()).child("week").child("sun").setValue(sun);
    }
    @Override
    public void didError(String msg) {
      Toast.makeText(getContext(), "Something went wrong!!!" + msg, Toast.LENGTH_SHORT).show();
    }
  };

  ValueEventListener mealLis = new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
      GenericTypeIndicator<List<MealModel>> genericTypeIndicator =new GenericTypeIndicator<List<MealModel>>(){};
      List<MealModel> taskDesList = snapshot.getValue(genericTypeIndicator);
      mealModels = (ArrayList<MealModel>) taskDesList;

      if (null != mealCategoryModels){
        return;
      }
      String[] cardTitles = getResources().getStringArray(R.array.mealsCategorys);

      mealCategoryModels = new ArrayList<>();
      for (int i = 0; i< cardTitles.length; i++) {
        mealCategoryModels.add(new MealCategoryModel(mealModels.get(i).cardTitle, mealModels.get(i).cardImageUrl));
      }

      mealsCategoryRecycleViewAdapter = new MealsCategoryRecycleViewAdapter(getContext(), mealCategoryModels);
      mealsCategoryRecView.setAdapter(mealsCategoryRecycleViewAdapter);
      mealsCategoryRecView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {
      Log.e("TAG", "onCancelled: Erro");
    }
  };
}