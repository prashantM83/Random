package com.example.practical9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// 9a: Background Thread with runOnUiThread
public class MainActivityThread extends AppCompatActivity {
    Button btnStartThread;
    TextView tvThreadStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thread);

        btnStartThread  = findViewById(R.id.btnStartThread);
        tvThreadStatus  = findViewById(R.id.tvThreadStatus);

        btnStartThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 5; i++) {
                            final int count = i;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvThreadStatus.setText("Count: " + count);
                                }
                            });
                            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvThreadStatus.setText("Thread finished!");
                            }
                        });
                    }
                });
                thread.start();
            }
        });
    }
}
