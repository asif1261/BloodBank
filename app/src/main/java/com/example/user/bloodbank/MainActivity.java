package com.example.user.bloodbank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean exit = false;

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private TextView textViewPassword;
    private TextView textViewUserRegistration;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textViewPassword.setText( 0 + s.toString().length() + "/Enter at least 6 character");
            }
        });
        textViewSignin = (TextView)findViewById(R.id.textViewSignIn);
        textViewPassword = (TextView) findViewById(R.id.textViewPassword);
        textViewUserRegistration = (TextView)findViewById(R.id.textViewUserRegistration);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == buttonRegister){

            registerUser();
        }

        if(v == textViewSignin){
            //will open login activity here
            startActivity(new Intent(this, LoginActivity.class));
        }

    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(editTextEmail.getText().toString().length() == 0){
            //email is empty
            editTextEmail.setError("This Field Can't be Empty");
            //Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            //stoping the function executing
            return;
        }

        if(TextUtils.isEmpty(password) || password.length()<6){
            //ppassword is empty
            editTextPassword.setError("Password Field Can't be Empty & You must have 6 characters in your password");
            //Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            //stoping the function executing
            return;
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            finish();
                            Intent launchNextActivity;
                            launchNextActivity = new Intent(MainActivity.this, LoginActivity.class);
                            launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(launchNextActivity);
                            Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }else{
                           // Toast.makeText(MainActivity.this, "Could not Register.. please try again", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Ragistration Failed, Check your internet connection or give a valid email and set password length al least 6 character & Retry.")
                                    .setNegativeButton("Retry",null)
                                    .create()
                                    .show();
                        }
                        progressDialog.dismiss();
                    }
                });

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
