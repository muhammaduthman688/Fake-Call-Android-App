package com.example.usman;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
 TextView button,button2,textView;
 NavigationView navi;
 BottomNavigationView  bnavi;
 DrawerLayout drawer;

ConstraintLayout conlayout,conlayout1,conlayout2,conlayout3;

 ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        button2=findViewById(R.id.btn2);
        textView=findViewById(R.id.tvsc);
        navi = findViewById(R.id.nav);
        drawer=findViewById(R.id.drawer);
        conlayout=findViewById(R.id.constraintLayout15);
        conlayout1=findViewById(R.id.constraintLayout17);
        conlayout2=findViewById(R.id.constraintLayout16);
        conlayout3=findViewById(R.id.constraintLayout1);
        bnavi=findViewById(R.id.btm_navi);


        conlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, callerCaller_info.class);
                startActivity(intent);
            }
        });

        conlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Advance_Setting.class);
                startActivity(intent) ;

            }
        });
        conlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,call_history.class);
                startActivity(intent);

            }
        });
        conlayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Schedule_Call.class);
                startActivity(intent);
            }
        });

        Toolbar  toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);


        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_menu_24);


        navi.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId())
            {
                case R.id.nav_home :
                    Intent intent = new Intent(MainActivity.this, callerCaller_info.class);
                    startActivity(intent);
                    drawer.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_gallery :
                    intent = new Intent(MainActivity.this, call_history.class);
                    startActivity(intent);
                    drawer.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_rateus:
                    intent = new Intent(MainActivity.this,RateUs.class);
                    startActivity(intent);
                    break;
                case R.id.nav_quit:
                    intent = new Intent(MainActivity.this,Quit.class);
                    startActivity(intent);
                    break;
                case R.id.nav_setting :
                    intent= new Intent(MainActivity.this,Settings.class);
                    startActivity(intent);
                    break;
            }

            return true;
        });;

        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.call:
                    Intent intent = new Intent(MainActivity.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(MainActivity.this, RateUs.class);
                    startActivity(intent);
                    return true;
                default:
                    return false;
            }
        });


    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        (dialog, id) -> {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        })

                .setNegativeButton("No", (dialog, id) -> dialog.cancel());

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

public void Call_now(View view) {

        Intent intent = new Intent(MainActivity.this, Call_Screen.class);
        startActivity(intent);
    }
}