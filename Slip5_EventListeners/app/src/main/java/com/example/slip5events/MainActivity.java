package com.example.slip5events;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

// Program 1: Event Listeners — Button click/longClick, ImageView touch, EditText key
public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn    = findViewById(R.id.btn);
        ImageView img = findViewById(R.id.img);
        EditText et   = findViewById(R.id.et);
        tv            = findViewById(R.id.tv);

        // 1. Button click listener
        btn.setOnClickListener(v -> tv.setText("Button clicked"));

        // 2. Button long-click listener
        btn.setOnLongClickListener(v -> {
            tv.setText("Button LONG clicked");
            return true;   // consume event
        });

        // 3. ImageView touch listener (ACTION_DOWN / ACTION_UP)
        img.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    tv.setText("Image: ACTION_DOWN");
                    break;
                case MotionEvent.ACTION_UP:
                    tv.setText("Image: ACTION_UP");
                    v.performClick();   // accessibility requirement
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    tv.setText("Image: POINTER_DOWN (multi-touch)");
                    break;
            }
            return true;
        });

        // 4. EditText key listener — detect Enter key press
        et.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER
                    && event.getAction() == KeyEvent.ACTION_DOWN) {
                tv.setText("Enter pressed: " + et.getText().toString());
                return true;
            }
            return false;
        });
    }
}
