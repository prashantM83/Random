package com.example.practical5;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// 5c: Dialog Fragment Demo
public class MainActivityDialogFragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialog_fragment);

        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);

        btnOne.setOnClickListener(v -> showDialog("Button One clicked"));
        btnTwo.setOnClickListener(v -> showDialog("Button Two clicked"));
    }

    private void showDialog(String message) {
        ButtonDialogFragment dialog = ButtonDialogFragment.newInstance(message);
        dialog.show(getSupportFragmentManager(), "ButtonDialog");
    }
}
