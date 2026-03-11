package com.example.slip8profile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

// Program 2: Log Activity lifecycle methods to Logcat
// Filter Logcat by tag "LifeCycleSlip8" to observe the callback sequence
public class LifecycleDemoActivity extends AppCompatActivity {

    private static final String TAG = "LifeCycleSlip8";
    private TextView tvLog;

    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_lifecycle);
        tvLog = findViewById(R.id.tvLifecycleLog);
        log("onCreate called");
    }

    @Override protected void onStart()   { super.onStart();   log("onStart called");   }
    @Override protected void onResume()  { super.onResume();  log("onResume called");  }
    @Override protected void onPause()   { super.onPause();   log("onPause called");   }
    @Override protected void onStop()    { super.onStop();    log("onStop called");    }
    @Override protected void onDestroy() { super.onDestroy(); log("onDestroy called"); }

    private void log(String msg) {
        Log.d(TAG, msg);
        if (tvLog != null) tvLog.setText(tvLog.getText() + "\n" + msg);
    }
}
