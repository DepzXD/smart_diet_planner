package com.example.bento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bento.Listeners.MealDetailListener;
import com.example.bento.Models.MealDetailRes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MealDetailRecViewAdaptor extends RecyclerView.Adapter<MealDetailRecViewAdaptor.MyViewHolder> {
  Context context;
  ArrayList<MealModel> mealModels;

  public MealDetailRecViewAdaptor(Context context, ArrayList<MealModel> mealModels) {
    this.context = context;
    this.mealModels = mealModels;
  }


  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_meal_details,parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    holder.mealCal.setText(mealModels.get(position).getCalories() + "");
    holder.mealName.setText(mealModels.get(position).getCardTitle());
    Glide.with(context).asBitmap().load(mealModels.get(position).getCardImageUrl()).into(holder.mealImg);
  }

  @Override
  public int getItemCount() {
    return mealModels.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mealName, mealCal;
    ImageView mealImg;
    ConstraintLayout parent;
    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      mealCal = itemView.findViewById(R.id.meal_detail_calories);
      mealName = itemView.findViewById(R.id.meal_detail_name);
      mealImg = itemView.findViewById(R.id.meal_detail_img);
      parent = itemView.findViewById(R.id.meal_detail_recview);
    }
  }
}
