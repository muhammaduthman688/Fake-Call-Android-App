package com.example.usman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;

public class Character extends AppCompatActivity {
    LinearLayout gflayout, bflayout, policelayout, pizzalayout, momlayout, dadlayout, afridilay, gallery_lay;
    LinearLayout lay_character;
    BottomNavigationView  bnavi;
    ImageView imgcharac,button;
    TextView tvcharac;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        gflayout = findViewById(R.id.gf);
        bflayout = findViewById(R.id.bf);
        policelayout = findViewById(R.id.police);
        pizzalayout = findViewById(R.id.pizza);
        momlayout = findViewById(R.id.mom);
        dadlayout = findViewById(R.id.dad);
        afridilay = findViewById(R.id.s_afridi);
        gallery_lay = findViewById(R.id.gallery);
        lay_character = findViewById(R.id.lay_charac);
        imgcharac = findViewById(R.id.img_charac);
        tvcharac=findViewById(R.id.tv_charac);
        bnavi=findViewById(R.id.bottomNavigationView);
        button=findViewById(R.id.back_btn4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Character.this,callerCaller_info.class);
                startActivity(intent);
            }
        });

        gflayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.gf) {
                    gflayout.setBackgroundResource(R.drawable.chnge_bg_lay);
                    imgcharac.setImageResource(R.drawable.d);
                    tvcharac.setText("Girl Freind");
                    bflayout.setBackgroundResource(R.drawable.text_border);
                    policelayout.setBackgroundResource(R.drawable.text_border);
                    pizzalayout.setBackgroundResource(R.drawable.text_border);
                    momlayout.setBackgroundResource(R.drawable.text_border);
                    dadlayout.setBackgroundResource(R.drawable.text_border);
                    afridilay.setBackgroundResource(R.drawable.text_border);
                    gallery_lay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });
        bflayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.bf) {
                    bflayout.setBackgroundResource(R.drawable.chnge_bg_lay);
                    imgcharac.setImageResource(R.drawable.boyfreind);
                    tvcharac.setText("Boy Freind");
                    gflayout.setBackgroundResource(R.drawable.text_border);
                    policelayout.setBackgroundResource(R.drawable.text_border);
                    pizzalayout.setBackgroundResource(R.drawable.text_border);
                    momlayout.setBackgroundResource(R.drawable.text_border);
                    dadlayout.setBackgroundResource(R.drawable.text_border);
                    afridilay.setBackgroundResource(R.drawable.text_border);
                    gallery_lay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });
        policelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.police) {
                    policelayout.setBackgroundResource(R.drawable.chnge_bg_lay);
                    imgcharac.setImageResource(R.drawable.police);
                    tvcharac.setText("Police");
                    bflayout.setBackgroundResource(R.drawable.text_border);
                    gflayout.setBackgroundResource(R.drawable.text_border);
                    pizzalayout.setBackgroundResource(R.drawable.text_border);
                    momlayout.setBackgroundResource(R.drawable.text_border);
                    dadlayout.setBackgroundResource(R.drawable.text_border);
                    afridilay.setBackgroundResource(R.drawable.text_border);
                    gallery_lay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });
        pizzalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.pizza) {
                    pizzalayout.setBackgroundResource(R.drawable.chnge_bg_lay);
                    imgcharac.setImageResource(R.drawable.pizza_boy);
                    tvcharac.setText("Pizza Boy");
                    policelayout.setBackgroundResource(R.drawable.text_border);
                    bflayout.setBackgroundResource(R.drawable.text_border);
                    gflayout.setBackgroundResource(R.drawable.text_border);
                    momlayout.setBackgroundResource(R.drawable.text_border);
                    dadlayout.setBackgroundResource(R.drawable.text_border);
                    afridilay.setBackgroundResource(R.drawable.text_border);
                    gallery_lay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });
        momlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.mom) {
                    momlayout.setBackgroundResource(R.drawable.chnge_bg_lay);
                    imgcharac.setImageResource(R.drawable.mom);
                    tvcharac.setText("Mom");
                    policelayout.setBackgroundResource(R.drawable.text_border);
                    bflayout.setBackgroundResource(R.drawable.text_border);
                    gflayout.setBackgroundResource(R.drawable.text_border);
                    pizzalayout.setBackgroundResource(R.drawable.text_border);
                    dadlayout.setBackgroundResource(R.drawable.text_border);
                    afridilay.setBackgroundResource(R.drawable.text_border);
                    gallery_lay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });

        dadlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.dad) {
                    dadlayout.setBackgroundResource(R.drawable.chnge_bg_lay);
                    imgcharac.setImageResource(R.drawable.dad);
                    tvcharac.setText("Dad");
                    momlayout.setBackgroundResource(R.drawable.text_border);
                    policelayout.setBackgroundResource(R.drawable.text_border);
                    bflayout.setBackgroundResource(R.drawable.text_border);
                    gflayout.setBackgroundResource(R.drawable.text_border);
                    pizzalayout.setBackgroundResource(R.drawable.text_border);
                    afridilay.setBackgroundResource(R.drawable.text_border);
                    gallery_lay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });
        afridilay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.s_afridi) {
                    afridilay.setBackgroundResource(R.drawable.chnge_bg_lay);
                    imgcharac.setImageResource(R.drawable.afridi);
                    tvcharac.setText("S Afridi");
                    dadlayout.setBackgroundResource(R.drawable.text_border);
                    momlayout.setBackgroundResource(R.drawable.text_border);
                    policelayout.setBackgroundResource(R.drawable.text_border);
                    bflayout.setBackgroundResource(R.drawable.text_border);
                    gflayout.setBackgroundResource(R.drawable.text_border);
                    pizzalayout.setBackgroundResource(R.drawable.text_border);
                    gallery_lay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });

        gallery_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.gallery) {
                    Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(gallery, PICK_IMAGE);
                    gallery_lay.setBackgroundResource(R.drawable.chnge_bg_lay);
                    dadlayout.setBackgroundResource(R.drawable.text_border);
                    momlayout.setBackgroundResource(R.drawable.text_border);
                    policelayout.setBackgroundResource(R.drawable.text_border);
                    bflayout.setBackgroundResource(R.drawable.text_border);
                    gflayout.setBackgroundResource(R.drawable.text_border);
                    pizzalayout.setBackgroundResource(R.drawable.text_border);
                    afridilay.setBackgroundResource(R.drawable.text_border);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imgcharac.setImageURI(imageUri);
            tvcharac.setVisibility(View.INVISIBLE);

        }
        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Intent intent = new Intent(Character.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.call:
                    intent = new Intent(Character.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(Character.this, RateUs.class);
                    startActivity(intent);
                    return true;
                default:
                    return false;
            }
        });

    }

    public void Done(View view) {

       Intent intent = new Intent(Character.this, callerCaller_info.class);

        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();

        String cName = tvcharac.getText().toString();
        if(!cName.isEmpty()) {
            editor.putString("c_name", cName);
        }

        Drawable drawable = imgcharac.getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] byteArray = baos.toByteArray();
            String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
            editor.putString("c_image", imageString);
        } else {
            editor.remove("c_image"); // Remove the key-value pair for "c_image"
        }
        editor.apply();

        startActivity(intent);


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}


//         String data = tvcharac.getText().toString();
//        imgcharac.buildDrawingCache();
//        Bitmap bitmap = imgcharac.getDrawingCache();
//        Intent intent = new Intent(view.getContext(), callerCaller_info.class);
//        intent.putExtra("BitmapImage", bitmap);
//        intent.putExtra("charac_name", data);
//        startActivity(intent);
//        intent.putExtra("imgcharac", imgcharac.);



//        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
//        editor.putString("c_name", tvcharac.getText().toString());
//        Bitmap bitmap = ((BitmapDrawable) imgcharac.getDrawable()).getBitmap();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] byteArray = baos.toByteArray();
//        String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
//        editor.putString("c_image", imageString);
//        editor.apply();
