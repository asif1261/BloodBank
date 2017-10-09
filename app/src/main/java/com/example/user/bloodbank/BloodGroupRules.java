package com.example.user.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class BloodGroupRules extends AppCompatActivity {

    TextView textViewAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_group_rules);

        textViewAboutUs = (TextView)findViewById(R.id.textViewAboutUsRC);

        textViewAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BloodGroupRules.this, About.class));
            }
        });
    }
}
