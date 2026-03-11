package com.example.practical7;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// 7a: Service Demo
public class MainActivityService extends AppCompatActivity {
    Button startBtn, stopBtn, bindBtn, unbindBtn;
    Intent serviceIntent;
    boolean isBound = false;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) { isBound = true; }
        @Override
        public void onServiceDisconnected(ComponentName name) { isBound = false; }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);

        startBtn   = findViewById(R.id.startService);
        stopBtn    = findViewById(R.id.stopService);
        bindBtn    = findViewById(R.id.bindService);
        unbindBtn  = findViewById(R.id.unbindService);
        serviceIntent = new Intent(this, MyService.class);

        startBtn.setOnClickListener(v -> startService(serviceIntent));
        stopBtn.setOnClickListener(v -> stopService(serviceIntent));

        bindBtn.setOnClickListener(v -> {
            if (!isBound) {
                bindService(serviceIntent, serviceConnection, BIND_AUTO_CREATE);
                isBound = true;
            }
        });

        unbindBtn.setOnClickListener(v -> {
            if (isBound) {
                unbindService(serviceConnection);
                isBound = false;
            }
        });
    }
}
