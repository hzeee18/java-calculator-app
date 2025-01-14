package com.zeee.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button ac = findViewById(R.id.ac);
        Button del = findViewById(R.id.del);
        Button times = findViewById(R.id.times);
        Button min = findViewById(R.id.min);
        Button plus = findViewById(R.id.plus);
        Button equal = findViewById(R.id.equal);
        Button div = findViewById(R.id.div);
        Button point = findViewById(R.id.point);

        TextView screen = findViewById(R.id.screen);

        off.setOnClickListener(view -> screen.setVisibility(View.GONE));
        on.setOnClickListener(v -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });


        ArrayList<Button> nums = new ArrayList<>();
        nums.addAll(Arrays.asList(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, point));
        for (Button b : nums) {
            b.setOnClickListener(v -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(plus);
        opers.add(min);
        for (Button b : opers) {
            b.setOnClickListener(v -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        del.setOnClickListener(v -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        point.setOnClickListener(v -> {
            if (screen.getText().length() > 0) {
                screen.setText(screen.getText().toString() + ".");
            }
        });

        equal.setOnClickListener(v -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = firstNum / secondNum;
                    break;
                case "X":
                    result = firstNum * secondNum;
                    break;
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                default:
                    result = secondNum;
            }

            System.out.println(firstNum);

            screen.setText(String.valueOf(result));
            firstNum = result;

        });


        ac.setOnClickListener(v -> {
            firstNum = 0;
            screen.setText("0");
        });

    }

}