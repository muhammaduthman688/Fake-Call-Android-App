package com.example.usman.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usman.ModelRV_Call_hist.Model_CallHistory;
import com.example.usman.R;

import java.util.ArrayList;


public class Adapter_CallHistory extends RecyclerView.Adapter<Adapter_CallHistory.viewHolder> {



    ArrayList<Model_CallHistory> list;
    Context context;

    public Adapter_CallHistory(ArrayList<Model_CallHistory> list, Context context)
    {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.call_history_sample, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Model_CallHistory model = list.get(position);

        // Get SharedPreferences instance and retrieve saved values
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String number = sharedPreferences.getString("number", "");
        String imageString = sharedPreferences.getString("image", "");
        int callDuration = sharedPreferences.getInt("callDuration", 0);

        // Decode image string to Bitmap and set it to ImageView
        byte[] byteArray = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        holder.callerpic.setImageBitmap(bitmap);

        // Set values to respective TextViews
        holder.callerNameTv.setText(name);
        holder.callerNumberTv.setText(number);
        holder.callDurationtv.setText(String.valueOf(callDuration));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView callerNameTv, callerNumberTv, callDurationtv, calltimeTv;
        ImageView callerpic;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            callerNameTv = itemView.findViewById(R.id.caller_name_his);
            callerNumberTv = itemView.findViewById(R.id.caller_number_his);
            callDurationtv = itemView.findViewById(R.id.call_duration);
            calltimeTv = itemView.findViewById(R.id.call_time_hist);
            callerpic = itemView.findViewById(R.id.caller_pic);

        }
    }
}
