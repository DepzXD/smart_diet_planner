package com.example.bento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MealsCategoryRecycleViewAdapter extends RecyclerView.Adapter<MealsCategoryRecycleViewAdapter.MyViewHolder> {
  Context context;
  ArrayList<MealCategoryModel> mealModels;
  UpdateRecView updateRecView;

  public MealsCategoryRecycleViewAdapter(Context context, ArrayList<MealCategoryModel> mealModels, UpdateRecView updateRecView) {
    this.context = context;
    this.mealModels = mealModels;
    this.updateRecView = updateRecView;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.meals_card_view, parent, false);
    return new MealsCategoryRecycleViewAdapter.MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.cardTitle.setText(mealModels.get(position).cardTitle);
    Glide.with(context).asBitmap().load(mealModels.get(position).cardImageUrl).centerCrop().into(holder.cardImg);
    holder.parent.setStrokeWidth(0);
    if (mealModels.get(position).cardImageUrl.equals("")) {
      holder.cardImg.setVisibility(View.GONE);
    } else {
      holder.cardImg.setVisibility(View.VISIBLE);
    }

    holder.parent.setOnClickListener(view -> {
      if (position == 0){
        ArrayList<MealModel> item = new ArrayList<>();
        item.add(new MealModel(0,"Meal 11","https://images.pexels.com/photos/1893573/pexels-photo-1893573.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",4,5,6,7));
        item.add(new MealModel(0,"Meal 12","https://images.pexels.com/photos/4518703/pexels-photo-4518703.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        item.add(new MealModel(0,"Meal 13","https://images.pexels.com/photos/3297363/pexels-photo-3297363.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        updateRecView.callback(0, item, holder.parent);
      } else if (position == 1) {
        ArrayList<MealModel> item = new ArrayList<>();
        item.add(new MealModel(1,"Meal 21","https://images.pexels.com/photos/1893573/pexels-photo-1893573.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",4,5,6,7));
        item.add(new MealModel(1,"Meal 22","https://images.pexels.com/photos/4518703/pexels-photo-4518703.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        item.add(new MealModel(1,"Meal 23","https://images.pexels.com/photos/3297363/pexels-photo-3297363.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        updateRecView.callback(1, item,holder.parent);
      } else if (position == 2) {
        ArrayList<MealModel> item = new ArrayList<>();
        item.add(new MealModel(2,"Meal 31","https://images.pexels.com/photos/1893573/pexels-photo-1893573.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",4,5,6,7));
        item.add(new MealModel(2,"Meal 32","https://images.pexels.com/photos/4518703/pexels-photo-4518703.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        item.add(new MealModel(2,"Meal 33","https://images.pexels.com/photos/3297363/pexels-photo-3297363.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        updateRecView.callback(2, item,holder.parent);
      } else if (position == 3) {
        ArrayList<MealModel> item = new ArrayList<>();
        item.add(new MealModel(3,"Meal 41","https://images.pexels.com/photos/1893573/pexels-photo-1893573.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",4,5,6,7));
        item.add(new MealModel(3,"Meal 42","https://images.pexels.com/photos/4518703/pexels-photo-4518703.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        item.add(new MealModel(3,"Meal 43","https://images.pexels.com/photos/3297363/pexels-photo-3297363.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1600",4,5,6,7));
        updateRecView.callback(3, item, holder.parent);
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

      parent.setStrokeColor(ContextCompat.getColor(itemView.getContext(),R.color.green));
      cardImg = itemView.findViewById(R.id.meals_card_img);
      cardTitle = itemView.findViewById(R.id.meals_card_txt);
    }
  }

}
