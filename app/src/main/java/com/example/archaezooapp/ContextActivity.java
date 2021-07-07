package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.archaezooapp.databinding.ActivityContextBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class ContextActivity extends AppCompatActivity {

    EditText dateid;
    EditText site,idno,zone,trench,layer,number;
    ActivityContextBinding binding;

    DatePickerDialog.OnDateSetListener setListener;
    String shared_preferences_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_context);
        site=binding.site;
        idno=binding.idno;
        zone=binding.zone;
        trench=binding.trench;
        layer=binding.layer;
        number=binding.number;

        Intent i=getIntent();
        shared_preferences_name=i.getStringExtra("Shared Preference Name");

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name,Context.MODE_PRIVATE);
        site.setText(sharedPreferences.getString("site",""));
        idno.setText(sharedPreferences.getString("idno",""));
        zone.setText(sharedPreferences.getString("zone",""));
        trench.setText(sharedPreferences.getString("trench",""));
        layer.setText(sharedPreferences.getString("layer",""));
        number.setText(sharedPreferences.getString("number",""));

        dateid=findViewById(R.id.date);
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        dateid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        ContextActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        dateid.setText(date);
                    }
                },year,month,day);
            datePickerDialog.show();
            }
        });


    }

    public void savethecontext(View view) {

        String sitet=site.getText().toString();
        String idnot=idno.getText().toString();
        String zonet=zone.getText().toString();
        String trencht=trench.getText().toString();
        String layert=layer.getText().toString();
        String numbert=number.getText().toString();

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("site",sitet);
        editor.putString("idno",idnot);
        editor.putString("zone",zonet);
        editor.putString("trench",trencht);
        editor.putString("layer",layert);
        editor.putString("number",numbert);
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();


    }
}