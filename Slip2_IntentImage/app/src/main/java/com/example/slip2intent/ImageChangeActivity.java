package com.example.slip2intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

// Program 2: Button changes ImageView dynamically
public class ImageChangeActivity extends AppCompatActivity {

    ImageView img;
    boolean toggle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        img = findViewById(R.id.img);
        Button b = findViewById(R.id.btnChange);
        b.setOnClickListener(v -> {
            if (toggle) img.setImageResource(R.drawable.img1);
            else        img.setImageResource(R.drawable.img2);
            toggle = !toggle;
        });
    }
}
