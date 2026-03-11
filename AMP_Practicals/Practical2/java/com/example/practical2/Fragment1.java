package com.example.practical2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    String TAG = "Fragment1";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override public void onStart()       { super.onStart();       Log.d(TAG, "onStart"); }
    @Override public void onResume()      { super.onResume();      Log.d(TAG, "onResume"); }
    @Override public void onPause()       { super.onPause();       Log.d(TAG, "onPause"); }
    @Override public void onStop()        { super.onStop();        Log.d(TAG, "onStop"); }
    @Override public void onDestroyView() { super.onDestroyView(); Log.d(TAG, "onDestroyView"); }
    @Override public void onDestroy()     { super.onDestroy();     Log.d(TAG, "onDestroy"); }
}
