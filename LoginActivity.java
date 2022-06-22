package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText email,password;
    Button register;
    boolean isValid = true;
    ProgressBar progressBar;

    FirebaseAuth mAuth;
//    DatabaseReference dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        register.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.register:
                setupListeners();
        }
    }

    private void setupListeners() {
        String email1 = email.getText().toString();
        String password1 = password.getText().toString();

        if (email1.isEmpty()) {
            email.setError("You must enter email to login!");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            email.setError("Enter valid email!!");
            email.requestFocus();
            return;
        }

        if (password1.isEmpty()) {
            password.setError("You must enter password to login!");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email1, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();// If login is successful

                    Intent intent = new Intent(LoginActivity.this, HomeScreen.class);  // Move to home activity
                    startActivity(intent);
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    // sign-in failed
                    Toast.makeText(getApplicationContext(), "Incorrect Email or password", Toast.LENGTH_LONG).show();  //If login fails
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}