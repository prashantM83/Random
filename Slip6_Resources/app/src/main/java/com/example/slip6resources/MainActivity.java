package com.example.slip6resources;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

// Program 1: Demonstrate Android resources — colors, strings, drawables, themes.
// Resources are referenced via @color/, @string/, @drawable/ in XML and
// via R.color, R.string, R.drawable in Java.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Accessing string resource programmatically
        TextView tv = findViewById(R.id.tv);
        tv.setText(getString(R.string.hello_text));

        // Button to launch Registration Form (Program 2)
        Button btn = findViewById(R.id.btnOpenReg);
        btn.setOnClickListener(v ->
            startActivity(new Intent(this, RegistrationActivity.class))
        );
    }
}
