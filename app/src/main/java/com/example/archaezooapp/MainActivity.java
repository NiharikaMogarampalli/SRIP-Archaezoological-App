package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText appUsername, appEmail, appTextPassword;
    TextView appRegister;
    Button appLoginBtn;
    FirebaseAuth mFirebaseAuth;
    ProgressBar appProgressBar;

    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appUsername = findViewById(R.id.uname);
        appEmail = findViewById(R.id.email);
        appTextPassword = findViewById(R.id.password);
        appRegister = findViewById(R.id.registerText);
        appLoginBtn = findViewById(R.id.login);
        appProgressBar = findViewById(R.id.progressBar2);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(MainActivity.this, "Not registered", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, HomeScreen.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }

            }
        };

        appLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = appEmail.getText().toString().trim();
                String password = appTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    appEmail.setError("Email is Required");
                    appEmail.requestFocus();
                }
                if (TextUtils.isEmpty(password)) {
                    appTextPassword.setError("Password is required");
                    appTextPassword.requestFocus();
                }
                if (password.length() < 6) {
                    appTextPassword.setError("Password must be greater than or equal to 6 characters");
                    return;
                } else if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {

                    Toast.makeText(MainActivity.this, "Both the fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Error!Login Again. ", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intoHome = new Intent(MainActivity.this, AddNewDisplayOld.class);
                                startActivity(intoHome);
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Error Occurred! ", Toast.LENGTH_SHORT).show();
                }
            }

        });

        appRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intoRegister = new Intent(MainActivity.this, register.class);
                startActivity(intoRegister);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    //    public void login(View view) {
//        Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(MainActivity.this,HomeScreen.class));
//    }
//
//    public void gotoregister(View view) {
//        startActivity(new Intent(this,register.class));
//    }




}