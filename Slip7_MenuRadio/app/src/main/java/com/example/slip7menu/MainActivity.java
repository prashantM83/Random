package com.example.slip7menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

// Program 1: Options Menu with Submenu (tap the ⋮ action bar menu)
// Program 2: RadioGroup gender selection — select and press Submit
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Program 2: RadioGroup
        RadioGroup rg  = findViewById(R.id.rg);
        Button btn     = findViewById(R.id.btnSubmit);
        TextView tvSel = findViewById(R.id.tvSelected);

        btn.setOnClickListener(v -> {
            int checkedId = rg.getCheckedRadioButtonId();
            if (checkedId != -1) {
                RadioButton rb = findViewById(checkedId);
                tvSel.setText("Selected: " + rb.getText());
            } else {
                tvSel.setText("No selection made");
            }
        });
    }

    // Program 1: Inflate submenu from res/menu/menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Program 1: Handle submenu item selections
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sub1) {
            Toast.makeText(this, "Sub Item 1 selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.sub2) {
            Toast.makeText(this, "Sub Item 2 selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.sub3) {
            Toast.makeText(this, "Sub Item 3 selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
