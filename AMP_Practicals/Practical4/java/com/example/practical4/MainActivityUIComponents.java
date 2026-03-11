package com.example.practical4;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

// 4c: UI Components Demo
public class MainActivityUIComponents extends AppCompatActivity {
    EditText editText;
    Button button;
    ImageButton imageButton;
    CheckBox checkBox;
    RadioGroup radioGroup;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);

        editText    = findViewById(R.id.editTextName);
        button      = findViewById(R.id.btnSubmit);
        imageButton = findViewById(R.id.imageButton);
        checkBox    = findViewById(R.id.checkBox);
        radioGroup  = findViewById(R.id.radioGroup);
        toggleButton = findViewById(R.id.toggleButton);

        button.setOnClickListener(v -> {
            String name = editText.getText().toString();
            Toast.makeText(this, "Name: " + name, Toast.LENGTH_SHORT).show();
        });

        imageButton.setOnClickListener(v ->
            Toast.makeText(this, "ImageButton Clicked", Toast.LENGTH_SHORT).show()
        );

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                Toast.makeText(this, "Toggle ON", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Toggle OFF", Toast.LENGTH_SHORT).show();
        });
    }
}
