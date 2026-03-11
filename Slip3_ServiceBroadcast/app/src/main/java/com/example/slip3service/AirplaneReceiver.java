package com.example.slip3service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

// Program 2: BroadcastReceiver — notifies user when Airplane mode changes.
// Registered dynamically in MainActivity (required for implicit broadcasts on API 26+).
public class AirplaneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isOn = intent.getBooleanExtra("state", false);
        Toast.makeText(context,
                "Airplane mode: " + (isOn ? "ON" : "OFF"),
                Toast.LENGTH_LONG).show();
    }
}
