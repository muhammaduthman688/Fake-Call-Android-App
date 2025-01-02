package com.example.usman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.usman.Adapter.Adapter_CallHistory;
import com.example.usman.ModelRV_Call_hist.Model_CallHistory;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class call_history extends AppCompatActivity {
    BottomNavigationView bnavi;
    ImageView button;
    Adapter_CallHistory adapter;
    private ArrayList<Model_CallHistory> callHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_history);
        bnavi = findViewById(R.id.bottomNavigationView);
        button = findViewById(R.id.back_btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(call_history.this, MainActivity.class);
                startActivity(intent);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.RV_call_hist);

//        ArrayList<Model_CallHistory>list=new ArrayList<>();


//        adapter = new Adapter_CallHistory(list,this);
//        recyclerView.setAdapter (adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Load call history data from SharedPreferences
        callHistoryList = new ArrayList<>();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = prefs.getString("name", "");
        String number = prefs.getString("number", "");
        String imageString = prefs.getString("image", "");
        int callDuration = prefs.getInt("callDuration", 0);
        Bitmap imageBitmap = decodeBase64(imageString);

        // Add call history data to list
        Model_CallHistory callHistory = new Model_CallHistory(name, number, callDuration, imageBitmap);
        callHistoryList.add(callHistory);



        // Set adapter for RecyclerView
        adapter = new Adapter_CallHistory(callHistoryList, this);
        recyclerView.setAdapter(adapter);






        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Intent intent = new Intent(call_history.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.call:
                    intent = new Intent(call_history.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(call_history.this, RateUs.class);
                    startActivity(intent);
                    return true;
                default:
                    return false;
            }
        });





    }


    @Override
    public void onBackPressed() {
        finish();
    }
    private Bitmap decodeBase64(String input) {
        byte[] decodedBytes = Base64.decode(input, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
//    private List<Model_CallHistory> getCallHistory() {
//        // Retrieve call history data from SharedPreferences
//        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//        String caller_name = prefs.getString("name", "");
//        String caller_number = prefs.getString("number", "");
////        String imageString = prefs.getString("image", "");
//        int call_duration = prefs.getInt("callDuration", 0);
//
//        // Convert image string to Bitmap
////        byte[] imageBytes = Base64.decode(imageString, Base64.DEFAULT);
////        Bitmap imageBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
//
//        // Create a new CallHistoryItem object
//        Model_CallHistory item = new Model_CallHistory(caller_name, caller_number,  call_duration);
//
//        // Add the item to the list
//        List<Model_CallHistory> callHistory = new ArrayList<>();
//        callHistory.add(item);
//
//        return callHistory;
//    }
    }
