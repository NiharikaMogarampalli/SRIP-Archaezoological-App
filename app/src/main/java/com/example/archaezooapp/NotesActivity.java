package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {
    EditText notes;
    String shared_preferences_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notes=findViewById(R.id.notes);
        Intent i=getIntent();
        shared_preferences_name=i.getStringExtra("Shared Preference Name");

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name, Context.MODE_PRIVATE);
        notes.setText(sharedPreferences.getString("notes",""));
    }

    public void savethenotes(View view) {
        String notest=notes.getText().toString();
        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("notes",notest);
        editor.commit();
        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();
    }
}