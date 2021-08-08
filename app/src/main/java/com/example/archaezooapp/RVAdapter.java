package com.example.archaezooapp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RvViewHolder>{

    private ArrayList<RVModel> items;
    int row_index=-1;
    Context context;

    public RVAdapter(Context context,ArrayList<RVModel> items) {
        this.context=context;
        this.items = items;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rvitems,parent,false);
        RvViewHolder rvViewHolder=new RvViewHolder(v);
        return rvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, final int position) {
        RVModel currentItem=items.get(position);
        holder.rvedit.setImageResource(currentItem.getEdit());
        holder.rvtextView.setText(currentItem.getText());
        String sharedname=currentItem.getText();
        SharedPreferences sharedPreferences=context.getSharedPreferences(sharedname,Context.MODE_PRIVATE);
        holder.rvdownload.setImageResource(currentItem.getDownload());
        holder.rvedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,HomeScreen.class);
                i.putExtra("Shared Preference Name",sharedname);
                context.startActivity(i);
                notifyDataSetChanged();

            }

        });
        holder.rvdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=sharedPreferences.getString("zone","");
                Intent i=new Intent(context,add_item.class);
                i.putExtra("Shared Preference Name",sharedname);
                context.startActivity(i);

            }
        });
        holder.relativeLayout.setBackgroundResource(R.drawable.rvbackground);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RvViewHolder extends RecyclerView.ViewHolder{
        TextView rvtextView;
        ImageView rvedit,rvdownload;
        RelativeLayout relativeLayout;

        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            rvtextView=itemView.findViewById(R.id.rvtext);
            rvedit=itemView.findViewById(R.id.rvedit);
            rvdownload=itemView.findViewById(R.id.rvdownoad);
            relativeLayout=itemView.findViewById(R.id.relativelayoutid);
        }
    }

}
