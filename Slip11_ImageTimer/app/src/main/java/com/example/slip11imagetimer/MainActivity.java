package com.example.slip11imagetimer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

// Program 1: ImageView click shows Toast "Image clicked!"
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.img);
        iv.setOnClickListener(v ->
            Toast.makeText(this, "Image clicked!", Toast.LENGTH_SHORT).show()
        );

        // Button to navigate to Timer (Program 2)
        Button btnTimer = findViewById(R.id.btnOpenTimer);
        btnTimer.setOnClickListener(v ->
            startActivity(new Intent(this, TimerActivity.class))
        );
    }
}
