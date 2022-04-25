package com.example.bento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.ArrayList;

public class ProgressRecycleViewAdapter extends RecyclerView.Adapter<ProgressRecycleViewAdapter.MyViewHolder> {
  ArrayList<ProgressModel> progressModels;
  Context context;

  public ProgressRecycleViewAdapter(Context context, ArrayList<ProgressModel> progressModels) {
    this.progressModels = progressModels;
    this.context = context;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.circular_progressbar_card, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.cardTitle.setText(progressModels.get(position).getTitle());
    holder.cardPercentage.setText(progressModels.get(position).getProgress() + "%");
    holder.cardShort.setText(progressModels.get(position).getShortName());
    holder.cardShort.setTextColor(ContextCompat.getColor(context, progressModels.get(position).getColor()));
    holder.circularProgressIndicator.setIndicatorColor(ContextCompat.getColor(context, progressModels.get(position).getColor()));
    holder.circularProgressIndicator.setProgress(progressModels.get(position).getProgress());
  }

  @Override
  public int getItemCount() {
    return progressModels.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder {
    MaterialCardView parent;
    TextView cardTitle, cardShort, cardPercentage;
    CircularProgressIndicator circularProgressIndicator;
    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      parent = itemView.findViewById(R.id.circular_progressbar_card);
      cardTitle = itemView.findViewById(R.id.progress_card_title);
      cardShort = itemView.findViewById(R.id.progress_card_name);
      cardPercentage = itemView.findViewById(R.id.progress_card_percentage);
      circularProgressIndicator = itemView.findViewById(R.id.circular_progressbar_indicator);
    }
  }
}
