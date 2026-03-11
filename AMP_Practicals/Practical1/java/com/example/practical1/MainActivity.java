package com.example.practical1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ResourceDemo);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.myText);
        ImageView imageView = findViewById(R.id.myImage);
        textView.setText(getString(R.string.hello_text));
        textView.setTextColor(getColor(R.color.myTextColor));
        imageView.setImageResource(R.drawable.cats);
    }
}
