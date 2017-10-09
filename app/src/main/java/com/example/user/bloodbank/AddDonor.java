package com.example.user.bloodbank;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class AddDonor extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference databaseReference;

    private TextView tvDonorDetails;
    private EditText edName, edAddress, edContact, edAge;
    private Button btnAddDonor, btnUpdateDonor;
    private MaterialBetterSpinner materialDesignSpinner,spinnerSex;
    private TextInputLayout nameInputLayout,addressInputLayout,contactInputLayout,ageInputLayout;

    private FirebaseAuth firebaseAuth;

    //private DatabaseReference databaseReference;

    String[] SPINNERLIST = {"A+", "A-","B+", "B-","O+", "O-","AB+", "AB-"};
    String[] SPINNERLISTSEX = {"Male", "Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor);

        firebaseAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("donors");

        FirebaseUser user = firebaseAuth.getCurrentUser();

        tvDonorDetails = (TextView)findViewById(R.id.textViewDonorDetails);
        edName = (EditText)findViewById(R.id.editTextName);
        edAddress = (EditText)findViewById(R.id.editTextAddress);
        edContact = (EditText)findViewById(R.id.editTextContact);
        edAge = (EditText)findViewById(R.id.editTextAge);
        nameInputLayout = (TextInputLayout)findViewById(R.id.name_input_layout);
        ageInputLayout = (TextInputLayout)findViewById(R.id.age_input_layout);
        addressInputLayout = (TextInputLayout)findViewById(R.id.adderss_input_layout);
        contactInputLayout = (TextInputLayout)findViewById(R.id.contact_input_layout);
        btnAddDonor = (Button)findViewById(R.id.btnAddDonor);
        btnUpdateDonor = (Button)findViewById(R.id.btnUpdateDonor);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        materialDesignSpinner = (MaterialBetterSpinner)findViewById(R.id.spinnerBloodGroup);
        materialDesignSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapterSex = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLISTSEX);
        spinnerSex = (MaterialBetterSpinner)findViewById(R.id.spinnerSex);
        spinnerSex.setAdapter(arrayAdapterSex);

        btnAddDonor.setOnClickListener(this);
        btnUpdateDonor.setOnClickListener(this);

    }

    private void addDonorInformation(){
        String name = edName.getText().toString().trim();
        if(edName.getText().toString().trim().isEmpty()){
            nameInputLayout.setError("You must enter your name");
            edName.requestFocus();

            return;
        }

        String bloodGroup = materialDesignSpinner.getText().toString().trim();
        if(materialDesignSpinner.getText().toString().length() == 0){
            materialDesignSpinner.setError("You must select your blood group");
            return;
        }

        String sex = spinnerSex.getText().toString().trim();
        if(spinnerSex.getText().toString().length() == 0){
            spinnerSex.setError("You must select your gender");
            return;
        }

        String age = edAge.getText().toString().trim();
        if(edAge.getText().toString().trim().isEmpty()){
            ageInputLayout.setError("You must enter your age");
            edAge.requestFocus();
            return;
        }

        String address = edAddress.getText().toString().trim();
        if(edAddress.getText().toString().trim().isEmpty()){
            addressInputLayout.setError("You must enter your address here");
            edAddress.requestFocus();
            return;
        }

        String contactNumber = edContact.getText().toString().trim();
        if(edContact.getText().toString().trim().isEmpty()){
            contactInputLayout.setError("You must enter your contact number");
            edContact.requestFocus();
            return;
        }

        DonorInformation donorInformation = new DonorInformation(name, bloodGroup, sex, age, address, contactNumber);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(donorInformation);

        Toast.makeText(this, "Information Saved...", Toast.LENGTH_SHORT).show();

    }

    private void updateDonorInformation(){
        String name = edName.getText().toString().trim();
        if(edName.getText().toString().trim().isEmpty()){
            nameInputLayout.setError("You must enter your name");
            edName.requestFocus();

            return;
        }

        String bloodGroup = materialDesignSpinner.getText().toString().trim();
        if(materialDesignSpinner.getText().toString().length() == 0){
            materialDesignSpinner.setError("You must select your blood group");
            return;
        }

        String sex = spinnerSex.getText().toString().trim();
        if(spinnerSex.getText().toString().length() == 0){
            spinnerSex.setError("You must select your gender");
            return;
        }

        String age = edAge.getText().toString().trim();
        if(edAge.getText().toString().trim().isEmpty()){
            ageInputLayout.setError("You must enter your age");
            edAge.requestFocus();
            return;
        }

        String address = edAddress.getText().toString().trim();
        if(edAddress.getText().toString().trim().isEmpty()){
            addressInputLayout.setError("You must enter your address here");
            edAddress.requestFocus();
            return;
        }

        String contactNumber = edContact.getText().toString().trim();
        if(edContact.getText().toString().trim().isEmpty()){
            contactInputLayout.setError("You must enter your contact number");
            edContact.requestFocus();
            return;
        }

        DonorInformation donorInformation = new DonorInformation(name, bloodGroup, sex, age, address, contactNumber);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(donorInformation);

        Toast.makeText(this, "Information Updated...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {

        if(v == btnAddDonor){
            addDonorInformation();
        }
        if(v == btnUpdateDonor){
            updateDonorInformation();
        }
//        if(v == textViewAboutUs){
//            startActivity(new Intent(this, About.class));
//        }

    }
}
