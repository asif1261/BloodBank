package com.example.user.bloodbank;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private Boolean exit = false;


    private FirebaseAuth firebaseAuth;
    private TextView textViewuserEmail,textViewAboutUs;
    private Button buttonLogout;
    private ImageView imageViewAddDonor;
    private ImageView imageViewSeeDonorList;
    private ImageView imageViewOrganization;
    private ImageView imageViewBloodBank;
    private ImageView imageViewCalculator;
    private ImageView imageViewBloodRules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        buttonLogout = (Button)findViewById(R.id.buttonLogout);
        textViewuserEmail = (TextView)findViewById(R.id.textViewEmail);
        textViewuserEmail.setTypeface(Typeface.SANS_SERIF);
        textViewuserEmail.setTypeface(textViewuserEmail.getTypeface(), Typeface.BOLD);
        textViewAboutUs = (TextView)findViewById(R.id.textViewAboutUs);
        imageViewAddDonor = (ImageView)findViewById(R.id.imageViewAddDonor);
        imageViewSeeDonorList = (ImageView)findViewById(R.id.imageViewSeeDonorList);
        imageViewOrganization = (ImageView)findViewById(R.id.imageViewOrganization);
        imageViewBloodBank = (ImageView)findViewById(R.id.imageViewBloodBank);
        imageViewCalculator = (ImageView)findViewById(R.id.imageViewCalculator);
        imageViewBloodRules = (ImageView)findViewById(R.id.imageViewBloodRules);


        textViewuserEmail.setText("Welcome "+user.getEmail());

        buttonLogout.setOnClickListener(this);
        imageViewAddDonor.setOnClickListener(this);
        imageViewSeeDonorList.setOnClickListener(this);
        imageViewOrganization.setOnClickListener(this);
        imageViewBloodBank.setOnClickListener(this);
        imageViewCalculator.setOnClickListener(this);
        imageViewBloodRules.setOnClickListener(this);
        textViewAboutUs.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(v == imageViewBloodRules){
            startActivity(new Intent(this, BloodGroupRules.class));
        }
        if(v == imageViewAddDonor){
            startActivity(new Intent(this, AddDonor.class));
        }
        if(v == imageViewSeeDonorList){
            startActivity(new Intent(this, DonorList.class));
        }
        if(v == imageViewOrganization){
            startActivity(new Intent(this, Organization_ex.class));
        }
        if(v == imageViewBloodBank){
            startActivity(new Intent(this, BloodBankList.class));
        }
        if(v == imageViewCalculator){
            startActivity(new Intent(this, Calender.class));
        }
        if(v == textViewAboutUs){
            startActivity(new Intent(this, About.class));
        }


    }


    @Override
    protected void onResume() {
        super.onResume();
        // .... other stuff in my onResume ....
        this.exit = false;
    }


    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }
}
