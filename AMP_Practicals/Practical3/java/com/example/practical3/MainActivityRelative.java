package com.example.practical3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Relative Layout Demo
public class MainActivityRelative extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
    }

    public void show(View v) {
        EditText d = findViewById(R.id.txtComments);
        String str = d.getText().toString();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void clear(View v) {
        EditText d = findViewById(R.id.txtComments);
        d.setText("");
        Toast.makeText(this, "Text Clear", Toast.LENGTH_SHORT).show();
    }
}
