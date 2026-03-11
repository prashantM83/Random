package com.example.slip10fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

// Program 1: Activity hosts a Fragment and passes a String to it via Bundle
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load SimpleFragment initially (no arguments)
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new SimpleFragment())
                .commit();

        EditText etInput = findViewById(R.id.etInput);
        Button btnSend   = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String msg = etInput.getText().toString().trim();
            if (msg.isEmpty()) msg = "Hello Fragment!";

            // Pass data to Fragment using Bundle
            Bundle args = new Bundle();
            args.putString("msg", msg);

            SimpleFragment frag = new SimpleFragment();
            frag.setArguments(args);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, frag)
                    .commit();
        });
    }
}
