package com.example.practical9;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// 9b: Handler + Runnable Timer
public class MainActivityHandler extends AppCompatActivity {
    Button btnStartStop;
    TextView tvTimer;
    int counter = 0;
    boolean isRunning = false;
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            counter++;
            tvTimer.setText("Time: " + counter);
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_handler);

        btnStartStop = findViewById(R.id.btnStartStop);
        tvTimer      = findViewById(R.id.tvTimer);

        btnStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    handler.post(runnable);
                    btnStartStop.setText("Stop Timer");
                    isRunning = true;
                } else {
                    handler.removeCallbacks(runnable);
                    btnStartStop.setText("Start Timer");
                    isRunning = false;
                }
            }
        });
    }
}
