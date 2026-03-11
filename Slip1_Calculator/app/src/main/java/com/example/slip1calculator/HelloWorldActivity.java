package com.example.slip1calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// Program 2: Hello World — demonstrates MainActivity & activity_hello.xml binding.
// MainActivity is the launcher Activity class — it controls behavior & lifecycle
// (onCreate, onStart, etc.). activity_hello.xml is the layout resource that defines
// UI elements. setContentView(R.layout.activity_hello) binds the layout to the
// Activity so you can find views (findViewById) and manipulate them in code.
public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_hello.xml is inflated here and becomes the UI for this Activity
        setContentView(R.layout.activity_hello);
        TextView tv = findViewById(R.id.tvHello);
        tv.setText("Hello World! (from HelloWorldActivity)");
    }
}
