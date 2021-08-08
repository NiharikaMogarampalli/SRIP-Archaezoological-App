package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.archaezooapp.databinding.ActivityTaphonomyBinding;

public class TaphonomyActivity extends AppCompatActivity {

    ActivityTaphonomyBinding binding;
    String shared_preferences_name;

    RadioGroup diap,circum,fract,calc,concen,oxide,erosion,exofo,root,weath,roll,tramp,por,later,work,cut,chop,scrap,tooth,pat;
    EditText colour,anthro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taphonomy);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_taphonomy);
        diap=binding.diaphysis;
        circum=binding.circumference;
        fract=binding.fracture;
        calc=binding.calcination;
        concen=binding.concentration;
        oxide=binding.oxide;
        erosion=binding.erosion;
        exofo=binding.exfoliation;
        root=binding.rootetching;
        weath=binding.weatheringstage;
        roll=binding.rolling;
        tramp=binding.trampling;
        por=binding.porous;
        later=binding.laterintrusions;
        work=binding.workedbone;
        cut=binding.cutmarks;
        chop=binding.chopmarks;
        scrap=binding.scrapingmarks;
        tooth=binding.toothmarks;
        pat=binding.pathology;
        colour=binding.colourofcharring;
        anthro=binding.otheranthropic;

        Intent i=getIntent();
        shared_preferences_name=i.getStringExtra("Shared Preference Name");

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name, Context.MODE_PRIVATE);
        colour.setText(sharedPreferences.getString("colourofcharring",""));
        anthro.setText(sharedPreferences.getString("otheranthropic",""));

    }

    public void savethetaphonomy(View view) {

        String colourt=colour.getText().toString();
        String anthrot=anthro.getText().toString();

        RadioButton radioButton1 = (RadioButton) findViewById(diap.getCheckedRadioButtonId());
        RadioButton radioButton2 = (RadioButton) findViewById(circum.getCheckedRadioButtonId());
        RadioButton radioButton3 = (RadioButton) findViewById(fract.getCheckedRadioButtonId());
        RadioButton radioButton4 = (RadioButton) findViewById(calc.getCheckedRadioButtonId());
        RadioButton radioButton5 = (RadioButton) findViewById(concen.getCheckedRadioButtonId());
        RadioButton radioButton6 = (RadioButton) findViewById(oxide.getCheckedRadioButtonId());
        RadioButton radioButton7 = (RadioButton) findViewById(erosion.getCheckedRadioButtonId());
        RadioButton radioButton8 = (RadioButton) findViewById(exofo.getCheckedRadioButtonId());
        RadioButton radioButton9 = (RadioButton) findViewById(root.getCheckedRadioButtonId());
        RadioButton radioButton10 = (RadioButton) findViewById(weath.getCheckedRadioButtonId());
        RadioButton radioButton11= (RadioButton) findViewById(roll.getCheckedRadioButtonId());
        RadioButton radioButton12 = (RadioButton) findViewById(tramp.getCheckedRadioButtonId());
        RadioButton radioButton13 = (RadioButton) findViewById(por.getCheckedRadioButtonId());
        RadioButton radioButton14= (RadioButton) findViewById(later.getCheckedRadioButtonId());
        RadioButton radioButton15 = (RadioButton) findViewById(work.getCheckedRadioButtonId());
        RadioButton radioButton16 = (RadioButton) findViewById(cut.getCheckedRadioButtonId());
        RadioButton radioButton17 = (RadioButton) findViewById(chop.getCheckedRadioButtonId());
        RadioButton radioButton18 = (RadioButton) findViewById(scrap.getCheckedRadioButtonId());
        RadioButton radioButton19 = (RadioButton) findViewById(tooth.getCheckedRadioButtonId());
        RadioButton radioButton20 = (RadioButton) findViewById(pat.getCheckedRadioButtonId());

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("diap",radioButton1.getText().toString());
        editor.putString("circum",radioButton2.getText().toString());
        editor.putString("fract",radioButton3.getText().toString());
        editor.putString("calc",radioButton4.getText().toString());
        editor.putString("colourofcharring",colourt);
        editor.putString("concen",radioButton5.getText().toString());
        editor.putString("oxide",radioButton6.getText().toString());
        editor.putString("erosion",radioButton7.getText().toString());
        editor.putString("exofo",radioButton8.getText().toString());
        editor.putString("root",radioButton9.getText().toString());
        editor.putString("weath",radioButton10.getText().toString());
        editor.putString("roll",radioButton11.getText().toString());
        editor.putString("tramp",radioButton12.getText().toString());
        editor.putString("por",radioButton13.getText().toString());
        editor.putString("later",radioButton14.getText().toString());
        editor.putString("work",radioButton15.getText().toString());
        editor.putString("cut",radioButton16.getText().toString());
        editor.putString("chop",radioButton17.getText().toString());
        editor.putString("scrap",radioButton18.getText().toString());
        editor.putString("tooth",radioButton19.getText().toString());
        editor.putString("otheranthropic",anthrot);
        editor.putString("pat",radioButton20.getText().toString());



        editor.commit();
        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();


    }
}