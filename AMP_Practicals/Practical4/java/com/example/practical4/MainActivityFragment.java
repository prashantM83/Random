package com.example.practical4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// 4b: Fragment Demo - loads ExampleFragment into container
public class MainActivityFragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragmentContainer, new ExampleFragment())
            .commit();
    }
}
