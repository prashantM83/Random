package com.example.practical4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExampleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        Button button = view.findViewById(R.id.buttonFragment);
        button.setOnClickListener(v ->
            Toast.makeText(getActivity(), "Button clicked in Fragment!", Toast.LENGTH_SHORT).show()
        );
        return view;
    }
}
