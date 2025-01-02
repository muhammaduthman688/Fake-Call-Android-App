package com.example.usman.B_reciever;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.example.usman.Call_Screen;

import java.util.Calendar;


public class ReceiverTest extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Calculate the time when the Call_Screen activity should be triggered
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10); // Set the desired time interval (e.g., 10 seconds)

        // Create an explicit intent for the Call_Screen activity
        Intent callScreenIntent = new Intent(context, Call_Screen.class);

        // Create a PendingIntent for the Call_Screen activity
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, callScreenIntent, PendingIntent.FLAG_ONE_SHOT);

        // Get the AlarmManager service
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // Schedule the Call_Screen activity to be triggered at the specified time
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            } else {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        }
    }
}