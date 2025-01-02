package com.example.usman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Set_Ringtone extends AppCompatActivity {
    BottomNavigationView  bnavi;
    ImageView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ringtone);
        bnavi=findViewById(R.id.bottomNavigationView);
        button=findViewById(R.id.back_btn7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Set_Ringtone.this,Advance_Setting.class);
                startActivity(intent);
            }
        });
        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Intent intent = new Intent(Set_Ringtone.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.call:
                    intent = new Intent(Set_Ringtone.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(Set_Ringtone.this, RateUs.class);
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