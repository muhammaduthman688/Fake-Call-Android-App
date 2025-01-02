package com.example.usman;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class callerCaller_info extends AppCompatActivity {

EditText edt_enter_name,edt_enter_nmbr;
ImageView button ,charac_image;
ConstraintLayout constraintLayout,textView;


    private static final int RESULT_PICK_CONTACT  = 100;
    BottomNavigationView  bnavi;
//          Intent intent;
//          String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller_caller_info);
        textView=findViewById(R.id.cons_contact);
        constraintLayout=findViewById(R.id.constraintLayout6);
        charac_image=findViewById(R.id.iv_charac);
        edt_enter_name=findViewById(R.id.edt_enter_name);
        edt_enter_nmbr=findViewById(R.id.edt_enter_nmbr);

        bnavi=findViewById(R.id.bottomNavigationView);
        button=findViewById(R.id.back_btn);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = prefs.getString("c_name", "");

        String imageString = prefs.getString("c_image", "");
        if (!imageString.equals("")) {
            byte[] byteArray = Base64.decode(imageString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            charac_image.setImageBitmap(bitmap);
        }
        edt_enter_name.setText(name);

//        Intent intent = getIntent();
//        if (intent != null) {
//            Bitmap bitmap = intent.getParcelableExtra("BitmapImage");
//            if (bitmap != null) {
//                charac_image=findViewById(R.id.iv_charac);
//                charac_image.setImageBitmap(bitmap);
//            } else {
//                charac_image=findViewById(R.id.iv_charac);
//                charac_image.setImageResource(R.drawable.pic);
//            }
//        }
//
//        data=intent.getStringExtra("charac_name");
//        edt_enter_name.setText(data);
//        charac_image.setImageBitmap(imageBitmap);
//        charac_image.setImageURI(uri);

//        String imagePath = getIntent().getStringExtra("imgcharac");
//        uri= intent.getParcelableExtra("imgcharac");
//        intent=getIntent();
//        uri = intent.getParcelableExtra("imgcharac");
//
//        data=intent.getStringExtra("charac_name");
//        edt_enter_name.setText(data);
//        charac_image.setImageURI(uri);


        button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(callerCaller_info.this,MainActivity.class);
        startActivity(intent);
    }
});
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(callerCaller_info.this,Character.class);
                startActivity(intent);
            }
        });


        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Intent intent = new Intent(callerCaller_info.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.call:
                    intent = new Intent(callerCaller_info.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(callerCaller_info.this, RateUs.class);
                    startActivity(intent);
                    return true;

                default:
                    return false;
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult (intent,RESULT_PICK_CONTACT);

            }



        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_PICK_CONTACT) {
                contactPicked(data);
            }
        }
        else {
            Toast.makeText(this, "Failed To pick contact", Toast.LENGTH_SHORT).show();
        }
    }

    private void contactPicked(Intent data) {
        Cursor cursor = null;

        try {
            String phoneNo = null;
            Uri uri = data.getData ();
            cursor = getContentResolver ().query (uri, null, null,null,null);
            cursor.moveToFirst ();
            int phoneIndex = cursor.getColumnIndex (ContactsContract.CommonDataKinds.Phone.NUMBER);

            phoneNo = cursor.getString (phoneIndex);

            edt_enter_nmbr.setText (phoneNo);


        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void Save(View view) {


        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
        String name =  edt_enter_name.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        editor.putString("name", name);

        String number =  edt_enter_nmbr.getText().toString();

        if (number.isEmpty()) {
            Toast.makeText(this, "Please enter Number", Toast.LENGTH_SHORT).show();
            return;
        }
        editor.putString("number",number);

        // Convert the bitmap to a Base64 encoded string
        Bitmap bitmap = ((BitmapDrawable) charac_image.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] byteArray = baos.toByteArray();
        String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        editor.putString("image", imageString);
        editor.apply();
        Toast.makeText(callerCaller_info.this, "Data saved", Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}


