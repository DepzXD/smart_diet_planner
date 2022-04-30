package com.example.bento;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bento.Listeners.MealPlanListener;
import com.example.bento.Models.MealPlanRes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

public class WeekRecViewAdaptor extends RecyclerView.Adapter<WeekRecViewAdaptor.MyViewHolder> {
  Context context;
  ArrayList<String> weekModel;
  UpdateDayRecView updateDayRecView;
  RequestManager manager;
  private final DatabaseReference mDatabase;
  private DatabaseReference weekRef;
  private final FirebaseUser user;
  int pos;
  boolean check = true, select = true;

  public WeekRecViewAdaptor(Context context, ArrayList<String> weekModel, UpdateDayRecView updateDayRecView) {
    this.context = context;
    this.weekModel = weekModel;
    manager = new RequestManager(context);
    this.updateDayRecView = updateDayRecView;
    mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    user = mAuth.getCurrentUser();
    weekRef = FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid()).child("week").getRef();
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_week, parent,false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
    if (check) {
      mDatabase.child("users").child(user.getUid()).child("week").child("mon").addValueEventListener(mealLis);
      check = false;
    }
    holder.dayTxt.setText(weekModel.get(position));

    holder.parent.setOnClickListener(view -> {
      pos = position;
      notifyDataSetChanged();

      if (position == 0) {
        mDatabase.child("users").child(user.getUid()).child("week").child("mon").addValueEventListener(mealLis);
      } else if (position == 1) {
        mDatabase.child("users").child(user.getUid()).child("week").child("tue").addValueEventListener(mealLis);
      } else if (position == 2) {
        mDatabase.child("users").child(user.getUid()).child("week").child("wed").addValueEventListener(mealLis);
      } else if (position == 3) {
        mDatabase.child("users").child(user.getUid()).child("week").child("thu").addValueEventListener(mealLis);
      } else if (position == 4) {
        mDatabase.child("users").child(user.getUid()).child("week").child("fri").addValueEventListener(mealLis);
      } else if (position == 5) {
        mDatabase.child("users").child(user.getUid()).child("week").child("sat").addValueEventListener(mealLis);
      } else {
        mDatabase.child("users").child(user.getUid()).child("week").child("sun").addValueEventListener(mealLis);
      }
    });

    if (select) {
      if (position == 0) {
       holder.dayTxt.setTextColor(ContextCompat.getColor(context, R.color.white));
      }
      select = false;
    } else {
      if (pos == position) {
        holder.dayTxt.setTextColor(ContextCompat.getColor(context, R.color.white));
      } else {
        holder.dayTxt.setTextColor(ContextCompat.getColor(context, R.color.light_gray));
      }
    }
  }

  @Override
  public int getItemCount() {
    return weekModel.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView dayTxt;
    CardView parent;
    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      dayTxt = itemView.findViewById(R.id.weekDayTxt);
      parent = itemView.findViewById(R.id.weekCard);
    }
  }
  ValueEventListener mealLis = new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
      GenericTypeIndicator<List<MealModel>> genericTypeIndicator =new GenericTypeIndicator<List<MealModel>>(){};
      List<MealModel> taskDesList = snapshot.getValue(genericTypeIndicator);
      updateDayRecView.updateMealModel(pos, (ArrayList<MealModel>) taskDesList);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {
      Log.e("TAG", "onCancelled: Erro");
    }
  };
}
