package com.example.practical5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ButtonDialogFragment extends DialogFragment {
    private static final String ARG_MESSAGE = "message";

    public static ButtonDialogFragment newInstance(String message) {
        ButtonDialogFragment fragment = new ButtonDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_MESSAGE, message);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_button, container, false);
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        Button btnOk = view.findViewById(R.id.btnOk);

        if (getArguments() != null) {
            tvMessage.setText(getArguments().getString(ARG_MESSAGE));
        }
        btnOk.setOnClickListener(v -> dismiss());
        return view;
    }
}
