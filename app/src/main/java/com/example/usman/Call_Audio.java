package com.example.usman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Call_Audio extends AppCompatActivity {
    BottomNavigationView  bnavi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_audio);
        bnavi=findViewById(R.id.bottomNavigationView);
        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Intent intent = new Intent(Call_Audio.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.call:
                    intent = new Intent(Call_Audio.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(Call_Audio.this, RateUs.class);
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
}