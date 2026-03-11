package com.example.practical5;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

// 5b: Date & Time Picker Dialog Demo
public class MainActivityDialog extends AppCompatActivity {
    Button btnDatePicker, btnTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialog);

        btnDatePicker = findViewById(R.id.btnDatePicker);
        btnTimePicker = findViewById(R.id.btnTimePicker);

        btnDatePicker.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year  = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day   = calendar.get(Calendar.DAY_OF_MONTH);

            new DatePickerDialog(MainActivityDialog.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    Toast.makeText(MainActivityDialog.this, "Selected Date: " + date,
                        Toast.LENGTH_SHORT).show();
                }, year, month, day).show();
        });

        btnTimePicker.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour   = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            new TimePickerDialog(MainActivityDialog.this,
                (view, selectedHour, selectedMinute) -> {
                    String time = selectedHour + ":" + String.format("%02d", selectedMinute);
                    Toast.makeText(MainActivityDialog.this, "Selected Time: " + time,
                        Toast.LENGTH_SHORT).show();
                }, hour, minute, true).show();
        });
    }
}
