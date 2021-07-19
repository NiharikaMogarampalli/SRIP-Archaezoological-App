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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.archaezooapp.databinding.ActivityContextBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class ContextActivity extends AppCompatActivity {

    EditText dateid;
    EditText site,date,idno,zone,trench,layer,number,orientation,dip,soil,dimension,length,breadth,thickness,colour,weight,remains;
    RadioGroup isolated,articulated,sampled,photographed;
    Spinner dimunits,weigthuts;


    ActivityContextBinding binding;
    DatePickerDialog.OnDateSetListener setListener;
    String shared_preferences_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_context);

        site=binding.site;
        date=binding.date;
        idno=binding.idno;
        zone=binding.zone;
        trench=binding.trench;
        layer=binding.layer;
        number=binding.number;
        orientation=binding.orientation;
        dip=binding.dip;
        soil=binding.soil;
        isolated=  binding.isolated;
        articulated= binding.articuated;
        dimension=binding.dimensions;
        dimunits=binding.dimensionsspinner;
        length=binding.length;
        breadth=binding.breadth;
        thickness=binding.thickness;
        colour=binding.colour;
        weight=binding.weight;
        weigthuts=binding.weightspinner;
        remains=binding.remains;
        sampled=binding.sampled;
        photographed=binding.photographed;


        Intent i=getIntent();
        shared_preferences_name=i.getStringExtra("Shared Preference Name");

        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name,Context.MODE_PRIVATE);
        site.setText(sharedPreferences.getString("site",""));
        date.setText(sharedPreferences.getString("date",""));
        idno.setText(sharedPreferences.getString("idno",""));
        zone.setText(sharedPreferences.getString("zone",""));
        trench.setText(sharedPreferences.getString("trench",""));
        layer.setText(sharedPreferences.getString("layer",""));
        number.setText(sharedPreferences.getString("number",""));
        orientation.setText(sharedPreferences.getString("orientation",""));
        dip.setText(sharedPreferences.getString("dip",""));
        soil.setText(sharedPreferences.getString("soil",""));
        length.setText(sharedPreferences.getString("length",""));
        breadth.setText(sharedPreferences.getString("breadth",""));
        thickness.setText(sharedPreferences.getString("thickness",""));
        colour.setText(sharedPreferences.getString("colour",""));
        remains.setText(sharedPreferences.getString("remains",""));


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
        String datet=date.getText().toString();
        String idnot=idno.getText().toString();
        String zonet=zone.getText().toString();
        String trencht=trench.getText().toString();
        String layert=layer.getText().toString();
        String numbert=number.getText().toString();
        String orientationt=orientation.getText().toString();
        String dipt=dip.getText().toString();
        String soilt=soil.getText().toString();

        int genid1=isolated.getCheckedRadioButtonId();
        RadioButton radioButton1 = (RadioButton) findViewById(genid1);
        String isolatedt=radioButton1.getText().toString();
        int genid2=articulated.getCheckedRadioButtonId();
        RadioButton radioButton2 = (RadioButton) findViewById(genid2);
        String articulatedt=radioButton2.getText().toString();

        String dimensiont=dimension.getText().toString();
        String dimensionunitt=dimunits.getSelectedItem().toString();

        String lengtht=length.getText().toString();
        String breadtht=breadth.getText().toString();
        String thicknesst=thickness.getText().toString();
        String colourt=colour.getText().toString();
        String weightt=weight.getText().toString();
        String weightutst=weigthuts.getSelectedItem().toString();
        String remainst=remains.getText().toString();

        int genid3=sampled.getCheckedRadioButtonId();
        RadioButton radioButton3 = (RadioButton) findViewById(genid3);
        String sampledt=radioButton3.getText().toString();
        int genid4=articulated.getCheckedRadioButtonId();
        RadioButton radioButton4 = (RadioButton) findViewById(genid4);
        String photographedt=radioButton4.getText().toString();


        SharedPreferences sharedPreferences=getSharedPreferences(shared_preferences_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("site",sitet);
        editor.putString("date",datet);
        editor.putString("idno",idnot);
        editor.putString("zone",zonet);
        editor.putString("trench",trencht);
        editor.putString("layer",layert);
        editor.putString("number",numbert);
        editor.putString("orientation",orientationt);
        editor.putString("dip",dipt);
        editor.putString("soil",soilt);
        editor.putString("isolated",isolatedt);
        editor.putString("articulated",articulatedt);
        String dimt=dimensiont+" "+dimensionunitt;
        editor.putString("dimensions",dimt);
        editor.putString("length",lengtht);
        editor.putString("breadth",breadtht);
        editor.putString("thickness",thicknesst);
        editor.putString("colour",colourt);
        String weit=weightt+" "+weightutst;
        editor.putString("weight",weit);
        editor.putString("remains",remainst);
        editor.putString("sampled",sampledt);
        editor.putString("photographed",photographedt);
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();


    }
}