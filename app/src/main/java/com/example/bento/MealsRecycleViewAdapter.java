package com.example.bento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MealsRecycleViewAdapter extends RecyclerView.Adapter<MealsRecycleViewAdapter.MyViewHolder> {
  Context context;
  ArrayList<MealModel> mealModels;
  UpdateRecView updateRecView;

  public MealsRecycleViewAdapter(Context context, ArrayList<MealModel> mealModels, UpdateRecView updateRecView) {
    this.context = context;
    this.mealModels = mealModels;
    this.updateRecView = updateRecView;
  }

  @NonNull
  @Override
  public MealsRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view =  inflater.inflate(R.layout.meals_card_view, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MealsRecycleViewAdapter.MyViewHolder holder, int position) {
    holder.cardImg.setVisibility(View.VISIBLE);
    holder.cardTitle.setText(mealModels.get(position).cardTitle);
    Glide.with(context).asBitmap().load(mealModels.get(position).cardImageUrl).centerCrop().into(holder.cardImg);
    holder.parent.setOnClickListener(view -> updateRecView.updateList(mealModels.get(position).position, mealModels.get(position)));
  }

  @Override
  public int getItemCount() {
    return mealModels.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder  {
      MaterialCardView parent;
      ImageView cardImg;
      TextView cardTitle;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView.findViewById(R.id.meals_card_view);
        cardImg = itemView.findViewById(R.id.meals_card_img);
        cardTitle = itemView.findViewById(R.id.meals_card_txt);
    }
  }
}
