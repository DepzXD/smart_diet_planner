package com.example.bento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MealsRecycleViewAdapter extends RecyclerView.Adapter<MealsRecycleViewAdapter.MyViewHolder> {
  Context context;
  ArrayList<MealModel> mealModels;

  public MealsRecycleViewAdapter(Context context, ArrayList<MealModel> mealModels) {
    this.context = context;
    this.mealModels = mealModels;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.meals_card_view, parent, false);
    return new MealsRecycleViewAdapter.MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.cardTitle.setText(mealModels.get(position).cardTitle);
    Glide.with(context).asBitmap().load(mealModels.get(position).cardImageUrl).centerCrop().into(holder.cardImg);
    holder.parent.setOnClickListener(view -> {
      // TODO: Show hide meal Rec view
      if (holder.cardImg.getVisibility() == View.GONE){
        holder.cardImg.setVisibility(View.VISIBLE);
      } else {
        holder.cardImg.setVisibility(View.GONE);
      }
    });
  }

  @Override
  public int getItemCount() {
    return mealModels.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder {
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
