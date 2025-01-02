package com.example.usman.Services;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.usman.Call_Screen;

public class CallScreenService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Create an explicit intent to start the call screen activity
        Intent callScreenIntent = new Intent(this, Call_Screen.class);
        callScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callScreenIntent);

        // Stop the service after starting the activity
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
