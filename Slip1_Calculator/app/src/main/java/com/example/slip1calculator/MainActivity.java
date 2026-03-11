package com.example.slip1calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Program 1: Standard Calculator Application
public class MainActivity extends AppCompatActivity {

    TextView tv;
    String current = "";
    double first = Double.NaN;
    String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvDisplay);

        int[] nums = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                      R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot};
        View.OnClickListener numClick = v -> {
            Button b = (Button) v;
            current += b.getText().toString();
            tv.setText(current);
        };
        for (int id : nums) findViewById(id).setOnClickListener(numClick);

        findViewById(R.id.btnC).setOnClickListener(v -> {
            current = ""; first = Double.NaN; op = ""; tv.setText("0");
        });
        findViewById(R.id.btnDel).setOnClickListener(v -> {
            if (current.length() > 0) current = current.substring(0, current.length() - 1);
            tv.setText(current.isEmpty() ? "0" : current);
        });

        View.OnClickListener opClick = v -> {
            Button b = (Button) v;
            try {
                if (!Double.isNaN(first)) {
                    compute(Double.parseDouble(current));
                } else {
                    first = Double.parseDouble(current);
                }
            } catch (Exception e) { /* ignore */ }
            op = b.getText().toString();
            current = "";
        };
        findViewById(R.id.btnAdd).setOnClickListener(opClick);
        findViewById(R.id.btnSub).setOnClickListener(opClick);
        findViewById(R.id.btnMul).setOnClickListener(opClick);
        findViewById(R.id.btnDiv).setOnClickListener(opClick);

        findViewById(R.id.btnPerc).setOnClickListener(v -> {
            try { compute(Double.parseDouble(current)); op = "%"; current = ""; } catch (Exception e) {}
        });

        findViewById(R.id.btnEq).setOnClickListener(v -> {
            try {
                compute(Double.parseDouble(current));
                tv.setText(String.valueOf(first));
                current = "";
                op = "";
            } catch (Exception e) {}
        });
    }

    private void compute(double second) {
        if (op.equals("+"))      first = first + second;
        else if (op.equals("-")) first = first - second;
        else if (op.equals("x") || op.equals("X") || op.equals("*")) first = first * second;
        else if (op.equals("/")) first = second == 0 ? Double.NaN : first / second;
        else if (op.equals("%")) first = first % second;
        else                     first = second;
    }
}
