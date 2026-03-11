package com.example.slip4lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

// Program 1: Activity Lifecycle — logs all lifecycle callbacks to Logcat.
// Run the app, navigate away, come back, and press back.
// Filter Logcat by tag "ActivityLifeCycle" to observe the sequence:
//   onCreate -> onStart -> onResume -> (app visible + interactive)
//   onPause  -> (another activity in front)
//   onStop   -> (app no longer visible)
//   onDestroy-> (activity destroyed)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifeCycle";
    private TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLog = findViewById(R.id.tvLog);
        appendLog("onCreate called");
        Log.d(TAG, "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        appendLog("onStart called");
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        appendLog("onResume called");
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        appendLog("onPause called");
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        appendLog("onStop called");
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appendLog("onDestroy called");
        Log.d(TAG, "onDestroy called");
    }

    private void appendLog(String msg) {
        if (tvLog != null)
            tvLog.setText(tvLog.getText() + "\n" + msg);
    }
}
