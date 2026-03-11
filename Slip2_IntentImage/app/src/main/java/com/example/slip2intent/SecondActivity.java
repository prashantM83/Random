package com.example.slip2intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// Program 1: Intent Receiver Activity
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String name = getIntent().getStringExtra("name");
        TextView tv = findViewById(R.id.tvName);
        tv.setText("Received: " + (name == null ? "" : name));
    }
}
