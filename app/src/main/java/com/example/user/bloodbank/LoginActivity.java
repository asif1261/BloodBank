package com.example.user.bloodbank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Boolean exit = false;

    private Button buttonLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private TextView textViewUserlogin;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        editTextEmail = (EditText)findViewById(R.id.editTextEmailLogin);
        editTextPassword = (EditText)findViewById(R.id.editTextPasswordLogin);
        textViewSignUp = (TextView)findViewById(R.id.textViewSignUp);
        textViewUserlogin = (TextView)findViewById(R.id.textViewUserLogin);

        buttonLogin.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogin){
            userLogin();
        }

        if(v == textViewSignUp){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(editTextEmail.getText().toString().length() == 0){
            editTextEmail.setError("This Field Can't be Empty");
            return;
        }
        if(TextUtils.isEmpty(password) || password.length()<6){
            editTextPassword.setError("Password Field Can't be Empty & You must have 6 characters in your password");
            return;
        }
        progressDialog.setMessage("Logging in User...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            finish();
                            Intent launchNextActivity;
                            launchNextActivity = new Intent(LoginActivity.this, ProfileActivity.class);
                            launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(launchNextActivity);
                            Toast.makeText(LoginActivity.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }else {
                            //Toast.makeText(LoginActivity.this, "Could not Login.. please try again", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setMessage("Login Failed, check your internet connection or email spelling or password and Retry.")
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
