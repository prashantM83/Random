package com.example.practical7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class AirplaneModeReceiver extends BroadcastReceiver {
    private TextView tvStatus;

    public AirplaneModeReceiver(TextView tvStatus) {
        this.tvStatus = tvStatus;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isOn = intent.getBooleanExtra("state", false);
            tvStatus.post(new Runnable() {
                @Override
                public void run() {
                    tvStatus.setText(isOn ? "Airplane Mode ON" : "Airplane Mode OFF");
                }
            });
        }
    }
}
