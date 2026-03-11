package com.example.practical7;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// 7c: Broadcast Receiver Demo (Airplane Mode)
public class MainActivityBroadcast extends AppCompatActivity {
    Button btnToggle;
    TextView tvStatus;
    AirplaneModeReceiver airplaneModeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broadcast);

        btnToggle = findViewById(R.id.btnToggle);
        tvStatus  = findViewById(R.id.tvStatus);

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS));
            }
        });

        boolean isOn = Settings.Global.getInt(getContentResolver(),
            Settings.Global.AIRPLANE_MODE_ON, 0) == 1;
        tvStatus.setText(isOn ? "Airplane Mode ON" : "Airplane Mode OFF");

        airplaneModeReceiver = new AirplaneModeReceiver(tvStatus);
        registerReceiver(airplaneModeReceiver,
            new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(airplaneModeReceiver);
    }
}
