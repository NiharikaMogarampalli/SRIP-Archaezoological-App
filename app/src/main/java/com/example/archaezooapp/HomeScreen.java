package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
public class HomeScreen extends AppCompatActivity {

    Button logoutBtn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

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
        startActivity(new Intent(HomeScreen.this,ContextActivity.class));
    }

    public void gotoidentification(View view) {
        startActivity(new Intent(HomeScreen.this,IdentificationActivity.class));
    }

    public void gototaphonomy(View view) {
        startActivity(new Intent(HomeScreen.this,TaphonomyActivity.class));
    }

    public void gotonotes(View view) {
        startActivity(new Intent(HomeScreen.this,NotesActivity.class));

    }
}