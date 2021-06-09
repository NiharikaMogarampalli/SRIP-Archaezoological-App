package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;
public class register extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText appUsername,appEmail,appTextPassword;
    Button appRegisterBtn;
    TextView appLoginView;
    FirebaseAuth fAuth;
    ProgressBar appProgressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        appUsername = findViewById(R.id.uname);
        appEmail = findViewById(R.id.email);
        appTextPassword = findViewById(R.id.password);
        appRegisterBtn = findViewById(R.id.register);
        appLoginView = findViewById(R.id.registerView);

        fAuth = FirebaseAuth.getInstance();
        appProgressBar = findViewById(R.id.progressBar);


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        appRegisterBtn.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(register.this, "Both the fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))) {
                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(register.this, "User is Registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }


                        }
                    });

                } else {
                    Toast.makeText(register.this, "Error Occurred! ", Toast.LENGTH_SHORT).show();
                }


                appProgressBar.setVisibility(View.VISIBLE);

                //register the user in firebase


            }
        });

        appLoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(register.this, MainActivity.class);
                startActivity(i);
            }
        });

//        appRegisterBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            }
//        });
    }

//    public void register(View view) {
//        Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(register.this,MainActivity.class));
//    }



}