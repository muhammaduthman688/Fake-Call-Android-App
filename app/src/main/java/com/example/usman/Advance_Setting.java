package com.example.usman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Advance_Setting extends AppCompatActivity {
  TextView textView,tv2 ;
    ImageView button;
    BottomNavigationView  bnavi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_setting);
        bnavi=findViewById(R.id.bottomNavigationView);
        button=findViewById(R.id.back_btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Advance_Setting.this,MainActivity.class);
                startActivity(intent);
            }
        });

    textView= (TextView)  findViewById(R.id.tvch_ringtone);

        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Intent intent = new Intent(Advance_Setting.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.call:
                    intent = new Intent(Advance_Setting.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(Advance_Setting.this, RateUs.class);
                    startActivity(intent);
                    return true;
                default:
                    return false;
            }
        });



        tv2= (TextView) findViewById(R.id.tvcall_audio);
        tv2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent(Advance_Setting.this,Call_Audio.class);
            startActivity(intent);
        }
    });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Advance_Setting.this,Set_Ringtone.class);
                startActivity(intent);
            }
        });
    }
}