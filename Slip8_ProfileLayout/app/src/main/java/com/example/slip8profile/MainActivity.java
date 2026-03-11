package com.example.slip8profile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

// Program 1: Profile screen using RelativeLayout
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEdit     = findViewById(R.id.btnEdit);
        Button btnLifecycle = findViewById(R.id.btnLifecycle);

        btnEdit.setOnClickListener(v ->
            Toast.makeText(this, "Edit Profile clicked!", Toast.LENGTH_SHORT).show()
        );

        btnLifecycle.setOnClickListener(v ->
            startActivity(new Intent(this, LifecycleDemoActivity.class))
        );
    }
}
