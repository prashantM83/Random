package com.example.slip10fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// SimpleFragment — receives a string via Bundle and displays it
public class SimpleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple, container, false);
        TextView tv = v.findViewById(R.id.tvFragment);

        Bundle args = getArguments();
        if (args != null) {
            tv.setText(args.getString("msg", "No message"));
        } else {
            tv.setText("Fragment loaded (no data yet)");
        }
        return v;
    }
}
