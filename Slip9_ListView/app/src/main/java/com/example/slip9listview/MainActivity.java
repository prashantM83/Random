package com.example.slip9listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// Program 1: ListView populated from a String array using ArrayAdapter
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listView);

        String[] names = {
            "Alice", "Bob", "Charlie", "David", "Eve",
            "Frank", "Grace", "Heidi", "Ivan", "Judy",
            "Kevin", "Laura", "Mike", "Nancy", "Oscar"
        };

        // android.R.layout.simple_list_item_1 is a built-in single-text row layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names);
        lv.setAdapter(adapter);

        // Item click listener
        lv.setOnItemClickListener((parent, view, position, id) ->
            Toast.makeText(this, "Clicked: " + names[position], Toast.LENGTH_SHORT).show()
        );
    }
}
