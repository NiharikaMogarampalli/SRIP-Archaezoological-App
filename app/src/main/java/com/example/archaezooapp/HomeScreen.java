package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeScreen extends AppCompatActivity {

    Button logoutBtn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    String shared_preferences_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Intent i=getIntent();
         shared_preferences_name=i.getStringExtra("Shared Preference Name");
        Toast.makeText(this, ""+shared_preferences_name, Toast.LENGTH_SHORT).show();

        logoutBtn = findViewById(R.id.logoutButton);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intoLogin = new Intent(HomeScreen.this,MainActivity.class);
                startActivity(intoLogin);
            }
        });
    }

    public void gotocontext(View view) {
        Intent i=new Intent(HomeScreen.this,ContextActivity.class);
        i.putExtra("Shared Preference Name",shared_preferences_name);
        startActivity(i);
    }

    public void gotoidentification(View view) {
        startActivity(new Intent(HomeScreen.this,IdentificationActivity.class));
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String s=sharedPreferences.getString("name","");
        String s2=sharedPreferences.getString("pass","");
        Toast.makeText(this, ""+s+s2, Toast.LENGTH_SHORT).show();
    }

    public void gototaphonomy(View view) {
        startActivity(new Intent(HomeScreen.this,TaphonomyActivity.class));
    }

    public void gotonotes(View view) {
        startActivity(new Intent(HomeScreen.this,NotesActivity.class));

    }
}