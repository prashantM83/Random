package com.example.slip11imagetimer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

// Program 2: Start/Stop Timer using Handler + Runnable
public class TimerActivity extends AppCompatActivity {

    TextView tvTime;
    int seconds = 0;
    boolean running = false;
    Handler handler;

    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (running) {
                seconds++;
                tvTime.setText(formatTime(seconds));
            }
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tvTime           = findViewById(R.id.tvTime);
        Button btnStart  = findViewById(R.id.btnStart);
        Button btnStop   = findViewById(R.id.btnStop);
        Button btnReset  = findViewById(R.id.btnReset);

        handler = new Handler(Looper.getMainLooper());
        handler.post(timerRunnable);   // start the loop

        btnStart.setOnClickListener(v -> running = true);
        btnStop.setOnClickListener(v  -> running = false);
        btnReset.setOnClickListener(v -> {
            running = false;
            seconds = 0;
            tvTime.setText("00:00");
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(timerRunnable);
    }

    private String formatTime(int totalSeconds) {
        int mins = totalSeconds / 60;
        int secs = totalSeconds % 60;
        return String.format("%02d:%02d", mins, secs);
    }
}
