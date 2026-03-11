package com.example.slip2intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

// Program 1: Pass data from one Activity to another using Intent (Sender)
public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et  = findViewById(R.id.etName);
        btn = findViewById(R.id.btnSend);

        btn.setOnClickListener(v -> {
            String name = et.getText().toString().trim();
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("name", name);
            startActivity(i);
        });
    }
}
