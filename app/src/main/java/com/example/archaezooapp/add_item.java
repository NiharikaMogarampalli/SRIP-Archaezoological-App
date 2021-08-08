package com.example.archaezooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class add_item extends AppCompatActivity {
    String shared_preferences_name;
    SharedPreferences sharedPreferences;
    static int counter=1;
    static File filePath = new File(Environment.getExternalStorageDirectory() + "/AppData.xls");
    static HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
    static HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");
    String columnnames[]= {"Site","Date","Id No","Zone","Trench","Layer","Number","Geo cordinates","Orientation","Dip","Soil","Isolated","Articulated",
                           "Dimensions","Length","Breadth","Thickness","Colour","Weight","Remains","Sampled","Photographed","Integrity state",
                            "Taxon Genus","Species","Unidentified","Size","Skeletal element","Laterality","Tooth","Wearing stage","Refitting",
                            "No. of fragments","Association No.","Measurements","Diaphysis/Shaft Length","Circumference","Fracture pattern",
                            "Calcination","Colour of charring","Concentration","Oxide","Erosion","Exofoliation","Root Etching","Weathering stage",
                            "Rolling","Trampling","Porous","Later intrusions","Worked Bone","Cut Marks","Chop Marks","Scraping Marks","Tooth Marks",
                            "Other Anthropic marks","Pathology","Notes"};
    static  HSSFRow columnrow = hssfSheet.createRow(0);
    String site,date,idno,zone,trench,layer,number,geocordinates,orientation,dip,soil,isolated,articulated,dimensions,length,breadth,thickness,colour,weight,remains,sampled,photographed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Intent i=getIntent();
        shared_preferences_name=i.getStringExtra("Shared Preference Name");
        sharedPreferences=getSharedPreferences(shared_preferences_name, Context.MODE_PRIVATE);

        /* adding column heading data to excel sheet*/
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        for(int t=0;t<columnnames.length;t++)
        {
            hssfSheet.setColumnWidth(t, 15*256);
            columnrow.createCell(t).setCellValue(columnnames[t]);

        }

        /*end*/


    }

    public void additemtosheet(View view) {
        site=sharedPreferences.getString("site","");
        date=sharedPreferences.getString("date","");
        idno=sharedPreferences.getString("idno","");
        zone=sharedPreferences.getString("zone","");
        trench=sharedPreferences.getString("trench","");
        layer=sharedPreferences.getString("layer","");
        number=sharedPreferences.getString("number","");
        geocordinates="latlong";
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

        HSSFRow hssfRow = hssfSheet.createRow(counter);
        counter+=1;
        hssfRow.createCell(0).setCellValue(site);
        hssfRow.createCell(1).setCellValue(date);
        hssfRow.createCell(2).setCellValue(idno);
        hssfRow.createCell(3).setCellValue(zone);
        hssfRow.createCell(4).setCellValue(trench);
        hssfRow.createCell(5).setCellValue(layer);
        hssfRow.createCell(6).setCellValue(number);
        hssfRow.createCell(7).setCellValue(geocordinates);
        hssfRow.createCell(8).setCellValue(orientation);
        hssfRow.createCell(9).setCellValue(dip);
        hssfRow.createCell(10).setCellValue(soil);
        hssfRow.createCell(11).setCellValue(isolated);
        hssfRow.createCell(12).setCellValue(articulated);
        hssfRow.createCell(13).setCellValue(dimensions);
        hssfRow.createCell(14).setCellValue(length);
        hssfRow.createCell(15).setCellValue(breadth);
        hssfRow.createCell(16).setCellValue(thickness);
        hssfRow.createCell(17).setCellValue(colour);
        hssfRow.createCell(18).setCellValue(weight);
        hssfRow.createCell(19).setCellValue(remains);
        hssfRow.createCell(20).setCellValue(sampled);
        hssfRow.createCell(21).setCellValue(photographed);


        hssfRow.createCell(22).setCellValue(sharedPreferences.getString("integritystate",""));
        hssfRow.createCell(23).setCellValue(sharedPreferences.getString("taxongenus",""));
        hssfRow.createCell(24).setCellValue(sharedPreferences.getString("species",""));
        hssfRow.createCell(25).setCellValue(sharedPreferences.getString("unidentified",""));
        hssfRow.createCell(26).setCellValue(sharedPreferences.getString("size",""));
        hssfRow.createCell(27).setCellValue(sharedPreferences.getString("skeletalelement",""));
        hssfRow.createCell(28).setCellValue(sharedPreferences.getString("laterality",""));
        hssfRow.createCell(29).setCellValue(sharedPreferences.getString("tooth",""));
        hssfRow.createCell(30).setCellValue(sharedPreferences.getString("wearingstage",""));
        hssfRow.createCell(31).setCellValue(sharedPreferences.getString("refitting",""));
        hssfRow.createCell(32).setCellValue(sharedPreferences.getString("nooffragments",""));
        hssfRow.createCell(33).setCellValue(sharedPreferences.getString("associationno",""));
        hssfRow.createCell(34).setCellValue(sharedPreferences.getString("measurements",""));

        hssfRow.createCell(35).setCellValue(sharedPreferences.getString("diap",""));
        hssfRow.createCell(36).setCellValue(sharedPreferences.getString("circum",""));
        hssfRow.createCell(37).setCellValue(sharedPreferences.getString("fract",""));
        hssfRow.createCell(38).setCellValue(sharedPreferences.getString("calc",""));
        hssfRow.createCell(39).setCellValue(sharedPreferences.getString("colourofcharring",""));
        hssfRow.createCell(40).setCellValue(sharedPreferences.getString("concen",""));
        hssfRow.createCell(41).setCellValue(sharedPreferences.getString("oxide",""));
        hssfRow.createCell(42).setCellValue(sharedPreferences.getString("erosion",""));
        hssfRow.createCell(43).setCellValue(sharedPreferences.getString("exofo",""));
        hssfRow.createCell(44).setCellValue(sharedPreferences.getString("root",""));
        hssfRow.createCell(45).setCellValue(sharedPreferences.getString("weath",""));
        hssfRow.createCell(46).setCellValue(sharedPreferences.getString("roll",""));
        hssfRow.createCell(47).setCellValue(sharedPreferences.getString("tramp",""));
        hssfRow.createCell(48).setCellValue(sharedPreferences.getString("por",""));
        hssfRow.createCell(49).setCellValue(sharedPreferences.getString("later",""));
        hssfRow.createCell(50).setCellValue(sharedPreferences.getString("work",""));
        hssfRow.createCell(51).setCellValue(sharedPreferences.getString("cut",""));
        hssfRow.createCell(52).setCellValue(sharedPreferences.getString("chop",""));
        hssfRow.createCell(53).setCellValue(sharedPreferences.getString("scrap",""));
        hssfRow.createCell(54).setCellValue(sharedPreferences.getString("tooth",""));
        hssfRow.createCell(55).setCellValue(sharedPreferences.getString("otheranthropic",""));
        hssfRow.createCell(56).setCellValue(sharedPreferences.getString("pat",""));

        hssfRow.createCell(57).setCellValue(sharedPreferences.getString("notes",""));


        Toast.makeText(this, "Data successfully added to AppData.xls file and thus downloaded to file manager", Toast.LENGTH_LONG).show();
        try {
            if (!filePath.exists()){
                filePath.createNewFile();
            }

            FileOutputStream fileOutputStream= new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);

            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}