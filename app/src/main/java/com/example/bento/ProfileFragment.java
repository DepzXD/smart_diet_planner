package com.example.bento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ProfileFragment extends Fragment {

  public ProfileFragment() {
    // Required empty public constructor
  }
  private TextView txtProfile;
  private TextView txtAccount;

  private Button EditNamebtn;
  private Button EditAgebtn;
  private Button EditHeightbtn;
  private Button EditWeightbtn;
  private Button Emailbtn;
  private Button Passwordbtn;
  private Button Deletebtn;

  private ImageView userpic;

//  FIND VIEW BY ID
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_profile, container, false);
    EditNamebtn = root.findViewById(R.id.EditNamebtn);
    EditAgebtn = root.findViewById(R.id.EditAgebtn);
    EditHeightbtn = root.findViewById(R.id.EditHeightbtn);
    EditWeightbtn = root.findViewById(R.id.EditWeightbtn);
    Emailbtn = root.findViewById(R.id.Emailbtn);
    Passwordbtn = root.findViewById(R.id.Passwordbtn);
    Deletebtn = root.findViewById(R.id.Deletebtn);
    userpic = root.findViewById(R.id.userpic);
    txtProfile = root.findViewById(R.id.textProfile);
    txtAccount = root.findViewById(R.id.textProfile);


//    ImageView Code

    Glide.with(getContext()).asBitmap().load("https://thumbs.gfycat.com/TepidAstonishingBernesemountaindog-mobile.jpg").into(userpic);

//    EditNameButton Code
    EditNamebtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });




//    EditAgeButton Code
    EditAgebtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getContext(), "This button worked for AGE", Toast.LENGTH_SHORT).show();
      }
    });

//    EditHeightButton code
    EditHeightbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getContext(), "This button worked FOR HEIGHT ", Toast.LENGTH_SHORT).show();

      }
    });

//    EditWeightButton Code
    EditWeightbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getContext(), "This button worked FOR WEIGHT ", Toast.LENGTH_SHORT).show();

      }
    });

//    EMAIL BUTTON CODE
    Emailbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getContext(), "This button worked FOR EMAIL ", Toast.LENGTH_SHORT).show();

      }
    });

//    PASSWORD BUTTON CODE
    Passwordbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getContext(), "This button worked FOR PASSWORD ", Toast.LENGTH_SHORT).show();

      }
    });

//    DELETE BUTTON CODE
    Deletebtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getContext(), "This button worked FOR DELETE", Toast.LENGTH_SHORT).show();

      }
    });
    return root;
  }

}