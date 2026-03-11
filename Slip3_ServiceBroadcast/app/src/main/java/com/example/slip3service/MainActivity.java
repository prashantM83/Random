package com.example.slip3service;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

// Program 1: Start/Stop background music Service
// Program 2: BroadcastReceiver for Airplane mode (dynamically registered)
public class MainActivity extends AppCompatActivity {

    private AirplaneReceiver airplaneReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop  = findViewById(R.id.btnStop);
        TextView tvStatus = findViewById(R.id.tvStatus);

        // Program 1: Service buttons
        btnStart.setOnClickListener(v -> {
            startService(new Intent(this, MusicService.class));
            tvStatus.setText("Music Service: STARTED");
        });
        btnStop.setOnClickListener(v -> {
            stopService(new Intent(this, MusicService.class));
            tvStatus.setText("Music Service: STOPPED");
        });

        // Program 2: Register BroadcastReceiver dynamically (required API 26+)
        airplaneReceiver = new AirplaneReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister receiver to avoid memory leaks
        if (airplaneReceiver != null) {
            unregisterReceiver(airplaneReceiver);
        }
    }
}
