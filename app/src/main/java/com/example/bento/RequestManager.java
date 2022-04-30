package com.example.bento;

import android.content.Context;

import com.example.bento.Listeners.MealDetailListener;
import com.example.bento.Listeners.MealPlanListener;
import com.example.bento.Models.MealDetailRes;
import com.example.bento.Models.MealPlanRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {
   Context context;
   Retrofit retrofit = new Retrofit.Builder()
       .baseUrl("https://api.spoonacular.com")
       .addConverterFactory(GsonConverterFactory.create())
       .build();

   public RequestManager(Context context) {
      this.context = context;
   }

   public void getMealPlan(MealPlanListener listener) {
      CallMealPlan callMealPlan = retrofit.create(CallMealPlan.class);
      Call<MealPlanRes> call = callMealPlan.callGetMealPlan(context.getString(R.string.api_key), "week", "Vegetarian", 2000);
      call.enqueue(new Callback<MealPlanRes>() {
         @Override
         public void onResponse(Call<MealPlanRes> call, Response<MealPlanRes> response) {
            if (!response.isSuccessful()) {
               listener.didError(response.message());
               return;
            }
            listener.didFetch(response.body(), response.message());
         }

         @Override
         public void onFailure(Call<MealPlanRes> call, Throwable t) {
            listener.didError(t.getMessage());
            return;
         }
      });
   }

   public void getMealDetail(MealDetailListener listener, int id){
      CallMealDetail callMealDetail = retrofit.create(CallMealDetail.class);
      Call<MealDetailRes> call = callMealDetail.callMealDetail(id, context.getString(R.string.api_key), true );
      call.enqueue(new Callback<MealDetailRes>() {
         @Override
         public void onResponse(Call<MealDetailRes> call, Response<MealDetailRes> response) {
            if (!response.isSuccessful()) {
               listener.didError(response.message());
               return;
            }
            listener.didFetch(response.body(), response.message());
         }

         @Override
         public void onFailure(Call<MealDetailRes> call, Throwable t) {
            listener.didError(t.getMessage());
         }
      });
   };

   private interface CallMealDetail {
      @GET("recipes/{id}/information")
      Call<MealDetailRes> callMealDetail(
          @Path("id") int id,
          @Query("apiKey") String apiKey,
          @Query("includeNutrition") boolean includeNutrition
      );
   }

   private interface CallMealPlan {
      @GET("mealplanner/generate")
      Call<MealPlanRes> callGetMealPlan(
          @Query("apiKey") String apiKey,
          @Query("timeFrame") String timeFrame,
          @Query("diet") String diet,
          @Query("targetCalories") int targetCalories
      );
   }
}
