package com.example.bento;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
  private String m_Text = "";

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
//creating alertdialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        input.setHint("Enter Your Name");
        input.setBackground(getResources().getDrawable(R.drawable.dialog_input_round_corner));
        input.setPadding(40,20,20,20);

        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            m_Text = input.getText().toString();
            Toast.makeText(getContext(), "Button Worked & entered name is: " + m_Text, Toast.LENGTH_SHORT).show();
          }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.cancel();
          }
        });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
          dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_corner_round));
          dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
          dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
          dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.green));
          dialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
          dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setAllCaps(false);
          dialog.getButton(AlertDialog.BUTTON_POSITIVE).getResources().getDrawable(R.drawable.dialog_button_padding);
          }
        });
        dialog.show();
      }
    });




//    EditAgeButton Code
    EditAgebtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        input.setHint("Enter Your Age");
        input.setBackground(getResources().getDrawable(R.drawable.dialog_input_round_corner));
        input.setPadding(40,20,20,20);

        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            m_Text = input.getText().toString();
          }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.cancel();
          }
        });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_corner_round));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.green));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).getResources().getDrawable(R.drawable.dialog_button_padding);
          }
        });
        dialog.show();
      }
    });

//    EditHeightButton code
    EditHeightbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        input.setHint("Enter Your Height in cm");
        input.setBackground(getResources().getDrawable(R.drawable.dialog_input_round_corner));
        input.setPadding(40,20,20,20);

        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            m_Text = input.getText().toString();
          }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.cancel();
          }
        });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_corner_round));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.green));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).getResources().getDrawable(R.drawable.dialog_button_padding);





          }
        });

        dialog.show();

      }
    });

//    EditWeightButton Code
    EditWeightbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        input.setHint("Enter Your Weight in kg");
        input.setBackground(getResources().getDrawable(R.drawable.dialog_input_round_corner));
        input.setPadding(40,20,20,20);

        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            m_Text = input.getText().toString();
          }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.cancel();
          }
        });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_corner_round));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.green));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).getResources().getDrawable(R.drawable.dialog_button_padding);





          }
        });

        dialog.show();
      }
    });

//    EMAIL BUTTON CODE
    Emailbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        input.setHint("Enter Your E-mail");
        input.setBackground(getResources().getDrawable(R.drawable.dialog_input_round_corner));
        input.setPadding(40,20,20,20);

        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            m_Text = input.getText().toString();
          }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.cancel();
          }
        });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_corner_round));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.green));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).getResources().getDrawable(R.drawable.dialog_button_padding);





          }
        });

        dialog.show();

      }
    });

//    PASSWORD BUTTON CODE
    Passwordbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        input.setHint("Enter New Password");
        input.setBackground(getResources().getDrawable(R.drawable.dialog_input_round_corner));
        input.setPadding(40,20,20,20);

        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            m_Text = input.getText().toString();
          }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.cancel();
          }
        });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_corner_round));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.green));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).getResources().getDrawable(R.drawable.dialog_button_padding);





          }
        });

        dialog.show();

      }
    });

//    DELETE BUTTON CODE
    Deletebtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Are you sure you want to delete the account?");


        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {

          }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.cancel();
          }
        });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_corner_round));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.green));
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setAllCaps(false);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).getResources().getDrawable(R.drawable.dialog_button_padding);





          }
        });

        dialog.show();

      }
    });
    return root;
  }

}