package com.example.archaezooapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class AddNewDisplayOld extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    ArrayList<RVModel> item;
    SharedPreferences filedatabase;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_display_old);

        /* recycler view */
        item=new ArrayList<>();
        recyclerView=findViewById(R.id.rv);
        rvAdapter=new RVAdapter(AddNewDisplayOld.this,item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        recyclerView.setAdapter(rvAdapter);

        /* file databse */
        filedatabase=getSharedPreferences("metadata", Context.MODE_PRIVATE);
        editor=filedatabase.edit();

        Map<String, ?> allEntries = filedatabase.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            item.add(new RVModel(R.drawable.editicon,""+entry.getKey(),R.drawable.downloadicon));
        }

    }


    public void opendialog(View view) {
        open();
    }
    public void open()
    {
        ExampleDialog exampleDialog=new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");

    }

    @Override
    public void applyTexts(String filename) {
        Toast.makeText(this, "receiced "+filename, Toast.LENGTH_SHORT).show();

        editor.putString(filename,"");
        editor.commit();
        item.add(new RVModel(R.drawable.editicon,""+filename,R.drawable.downloadicon));

    }

}