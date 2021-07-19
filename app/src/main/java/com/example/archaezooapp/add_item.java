package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class add_item extends AppCompatActivity {
    String shared_preferences_name;
    SharedPreferences sharedPreferences;

    String site,date,idno,zone,trench,layer,number,orientation,dip,soil,isolated,articulated,dimensions,length,breadth,thickness,colour,weight,remains,sampled,photographed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Intent i=getIntent();
        shared_preferences_name=i.getStringExtra("Shared Preference Name");
        sharedPreferences=getSharedPreferences(shared_preferences_name, Context.MODE_PRIVATE);


    }

    public void additemtosheet(View view) {
        site=sharedPreferences.getString("site","");
        date=sharedPreferences.getString("date","");
        idno=sharedPreferences.getString("idno","");
        zone=sharedPreferences.getString("zone","");
        trench=sharedPreferences.getString("trench","");
        layer=sharedPreferences.getString("layer","");
        number=sharedPreferences.getString("number","");
        orientation=sharedPreferences.getString("orientation","");
        dip=sharedPreferences.getString("dip","");
        soil=sharedPreferences.getString("soil","");
        isolated=sharedPreferences.getString("isolated","");
        articulated=sharedPreferences.getString("articulated","");
        dimensions=sharedPreferences.getString("dimensions","");
        length=sharedPreferences.getString("length","");
        breadth=sharedPreferences.getString("breadth","");
        thickness=sharedPreferences.getString("thickness","");
        colour=sharedPreferences.getString("colour","");
        weight=sharedPreferences.getString("weight","");
        remains=sharedPreferences.getString("remains","");
        sampled=sharedPreferences.getString("sampled","");
        photographed=sharedPreferences.getString("photographed","");
        /** Toast.makeText(this, "site is "+site, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "date is "+date, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "idno is "+idno, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "zone is "+zone, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "trench is "+trench, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "layer is "+layer, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "number is "+number, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "isol is "+isolated, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "art is "+articulated, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "art is "+dimensions, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "all "+orientation+dip+soil, Toast.LENGTH_SHORT).show(); **/
    }
}