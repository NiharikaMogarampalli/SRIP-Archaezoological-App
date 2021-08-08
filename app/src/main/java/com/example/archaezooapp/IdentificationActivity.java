package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.archaezooapp.databinding.ActivityContextBinding;
import com.example.archaezooapp.databinding.ActivityIdentificationBinding;

public class IdentificationActivity extends AppCompatActivity {

    ActivityIdentificationBinding binding;
    String shared_preferences_name;

    RadioGroup integritystate,unidentified,laterality,refitting;
    EditText taxongenus,species,skeletalelement,tooth,wearingstage,nooffragments,associationno,measurements;
    Spinner size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_identification);

        integritystate=binding.integritystate;
        unidentified=binding.unidentified;
        laterality=binding.laterality;
        refitting=binding.refitting;
        taxongenus=binding.taxongennus;
        species=binding.species;
        skeletalelement=binding.skeletalelement;
        tooth=binding.tooth;
        wearingstage=binding.wearingstage;
        nooffragments=binding.nooffragments;
        associationno=binding.associationno;
        measurements=binding.measurements;
        size=binding.size;
        Intent i=getIntent();
        shared_preferences_name=i.getStringExtra("Shared Preference Name");

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name, Context.MODE_PRIVATE);
        taxongenus.setText(sharedPreferences.getString("taxongenus",""));
        species.setText(sharedPreferences.getString("species",""));
        skeletalelement.setText(sharedPreferences.getString("skeletalelement",""));
        tooth.setText(sharedPreferences.getString("tooth",""));
        wearingstage.setText(sharedPreferences.getString("wearingstage",""));
        nooffragments.setText(sharedPreferences.getString("nooffragments",""));
        associationno.setText(sharedPreferences.getString("associationno",""));
        measurements.setText(sharedPreferences.getString("measurements",""));
    }

    public void savetheidentification(View view) {
        String taxongenust=taxongenus.getText().toString();
        String speciest=species.getText().toString();
        String skeletalelementt=skeletalelement.getText().toString();
        String tootht=tooth.getText().toString();
        String wearingstaget=wearingstage.getText().toString();
        String nooffragmentst=nooffragments.getText().toString();
        String associationt=associationno.getText().toString();
        String measurementst=measurements.getText().toString();

        int genid1=integritystate.getCheckedRadioButtonId();
        RadioButton radioButton1 = (RadioButton) findViewById(genid1);
        String integritystatet=radioButton1.getText().toString();

        int genid2=unidentified.getCheckedRadioButtonId();
        RadioButton radioButton2= (RadioButton) findViewById(genid2);
        String unidentifiedt=radioButton2.getText().toString();

        int genid3=laterality.getCheckedRadioButtonId();
        RadioButton radioButton3 = (RadioButton) findViewById(genid3);
        String lateralityt=radioButton3.getText().toString();

        int genid4=refitting.getCheckedRadioButtonId();
        RadioButton radioButton4= (RadioButton) findViewById(genid4);
        String refittingt=radioButton4.getText().toString();

        String sizet=size.getSelectedItem().toString();

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("integritystate",integritystatet);
        editor.putString("taxongenus",taxongenust);
        editor.putString("species",speciest);
        editor.putString("unidentified",unidentifiedt);
        editor.putString("size",sizet);
        editor.putString("skeletalelement",skeletalelementt);
        editor.putString("laterality",lateralityt);
        editor.putString("tooth",tootht);
        editor.putString("wearingstage",wearingstaget);
        editor.putString("refitting",refittingt);
        editor.putString("nooffragments",nooffragmentst);
        editor.putString("associationno",associationt);
        editor.putString("measurements",measurementst);


        editor.commit();
        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();


    }
}