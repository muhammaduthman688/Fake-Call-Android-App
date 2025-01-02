package com.example.usman;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.usman.ModelRV_Call_hist.Model_CallHistory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
public class Call_Screen extends AppCompatActivity {
ImageView imageView;
LottieAnimationView lottieAnimationView_accept,lottieAnimationView_decline;
TextView textView,contactTextView,callDurationTextView;
LinearLayout incomingCallLayout,ongoingCallLayout;
ImageView acceptButton,declineButton,decline2;
    private final ArrayList<Call> callList = new ArrayList<>();
    private int callDuration = 0;
    private Timer callTimer;
    private Ringtone ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_screen);
        imageView=findViewById(R.id.iv_caller);
        textView=findViewById(R.id.caller_name);
        contactTextView=findViewById(R.id.caller_num);
//        acceptButton=findViewById(R.id.accept_call);
        lottieAnimationView_accept=findViewById(R.id.accept_call1);
//        declineButton=findViewById(R.id.decline_call);
        lottieAnimationView_decline=findViewById(R.id.decline_call1);
        decline2=findViewById(R.id.decline_call_later);
        ongoingCallLayout=findViewById(R.id.ongoing_call_lay);
        incomingCallLayout=findViewById(R.id.incoming_call_lay);
       callDurationTextView = findViewById(R.id.call_duration_tv);


        ongoingCallLayout.setVisibility(View.INVISIBLE);
        lottieAnimationView_decline.playAnimation();
        lottieAnimationView_accept.playAnimation();


        decline2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stop the call timer and close the call screen activity
                if (callTimer != null) {
                    callTimer.cancel();
                    callTimer = null;

                }
                SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
                editor.putString("name", textView.getText().toString());
                editor.putString("number", contactTextView.getText().toString());
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] byteArray = baos.toByteArray();
                String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                editor.putString("image", imageString);
                editor.putInt("callDuration", callDuration);
                editor.apply();

//                ArrayList<Model_CallHistory> callList = new ArrayList<>();
//                Model_CallHistory callData = new Model_CallHistory(textView, contactTextView, callDuration, bitmap);
//                callList.add(callData);
                finish();

            }
        });

        lottieAnimationView_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ringtone.stop();
                lottieAnimationView_accept.pauseAnimation();

                incomingCallLayout.setVisibility(View.GONE);
                ongoingCallLayout.setVisibility(View.VISIBLE);
                callTimer = new Timer();
                callTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        callDuration++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updatecallDurationTextView();
                            }
                        });
                    }
                }, 0, 1000);
            }
        });

lottieAnimationView_decline.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (ringtone.isPlaying()) {
            ringtone.stop();
        }
        // finish the activity
        finish();
    }
});


        Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        ringtone = RingtoneManager.getRingtone(this, ringtoneUri);
        ringtone.play();


        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = prefs.getString("name", "");
        String number = prefs.getString("number", "");
        String imageString = prefs.getString("image", "");
        if (!imageString.equals("")) {
            byte[] byteArray = Base64.decode(imageString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imageView.setImageBitmap(bitmap);
        }
        textView.setText(name);
        contactTextView.setText(number);


    }
    private void updatecallDurationTextView() {

        int hours = callDuration / 3600;
        int minutes = (callDuration % 3600) / 60;
        int seconds = callDuration % 60;
        String timeString = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
        callDurationTextView.setText(timeString);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //  to stop the call timer when the activity is destroyed
        if (callTimer != null) {
            callTimer.cancel();
            callTimer = null;
        }
    }
}

