package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View view) {
        Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,HomeScreen.class));
    }

    public void gotoregister(View view) {
        startActivity(new Intent(this,register.class));
    }
}