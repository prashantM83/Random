package com.example.practical5;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// 5a: Options Menu Demo
public class MainActivityMenus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_home) {
            Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show(); return true;
        } else if (id == R.id.menu_profile) {
            Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show(); return true;
        } else if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show(); return true;
        } else if (id == R.id.menu_help) {
            Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT).show(); return true;
        } else if (id == R.id.menu_exit) {
            finish(); return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
