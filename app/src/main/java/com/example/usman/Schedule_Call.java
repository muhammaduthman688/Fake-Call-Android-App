package com.example.usman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class Schedule_Call extends AppCompatActivity {
    BottomNavigationView bnavi;
    LinearLayout call_30sec;
    ImageView button;
    private static final String CHANNEL_ID = "call_screen_channel";
    private static final int NOTIFICATION_ID = 1;
    private static final long INTERVAL_MILLIS = 10 * 1000; // 10 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_call);
        bnavi = findViewById(R.id.bottomNavigationView);
        button = findViewById(R.id.back_btn6);
        call_30sec = findViewById(R.id.sec30);
        call_30sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleCallScreen();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Schedule_Call.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bnavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Intent intent = new Intent(Schedule_Call.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.call:
                    intent = new Intent(Schedule_Call.this, Call_Screen.class);
                    startActivity(intent);
                    return true;
                case R.id.rateus:
                    intent = new Intent(Schedule_Call.this, RateUs.class);
                    startActivity(intent);
                    return true;
                default:
                    return false;
            }
        });

    }

    private void scheduleCallScreen() {
        // Calculate the time when the Call_Screen activity should be triggered
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10); // Set the desired time interval (e.g., 10 seconds)

        // Create an explicit intent for the Call_Screen activity
        Intent callScreenIntent = new Intent(this, Call_Screen.class);
        callScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Create a PendingIntent for the Call_Screen activity
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, callScreenIntent, PendingIntent.FLAG_ONE_SHOT);

        // Get the AlarmManager service
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Schedule the Call_Screen activity to be triggered at the specified time
        if (alarmManager != null) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }

        // Display a notification to indicate that the time has been set
        showNotification();
    }

    private void showNotification() {
        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.fake_call)
                .setContentTitle("Time Set")
                .setContentText("The call screen will appear after 10 seconds.")
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "Call Screen";
            String channelDescription = "Channel for displaying Call Screen notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            channel.setDescription(channelDescription);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }

        }
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}