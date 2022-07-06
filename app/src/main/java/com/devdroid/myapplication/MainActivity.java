package com.devdroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {
    private String output = "", input = "", newOutput = "";
    NeumorphButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn00;
    NeumorphButton btn_add, btn_mul, btn_sub, btn_divide, btn_percentage, btn_allClear, btn_clear, btn_dot;
    NeumorphButton btn_equal;
    TextView inputText, outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // id find
        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        btn0 = findViewById(R.id.btn0);
        btn00 = findViewById(R.id.btn00);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_divide = findViewById(R.id.btn_divide);
        btn_percentage = findViewById(R.id.btn_percentage);
        btn_clear = findViewById(R.id.btn_clear);
        btn_allClear = findViewById(R.id.btn_allClear);
        btn_dot = findViewById(R.id.btn_dot);

    }

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = "";
                output = "";
                newOutput = "";
                outputText.setText("");
                break;
            case "^":
                solve();
                input += "^";
                break;
            case "×":
                solve();
                input += "×";
                break;
            case "=":
                solve();
                break;
            case "%":
                input += "%";
                double d = Double.parseDouble(inputText.getText().toString()) / 100;
                outputText.setText(String.valueOf(d));
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("÷") || data.equals("-")) {
                    solve();
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\×").length == 2) {
            String numbers[] = input.split("\\×");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\÷").length == 2) {
            String numbers[] = input.split("\\÷");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\^").length == 2) {
            String numbers[] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), 2);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])) {
                double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText("-" + newOutput);
                input = d + "";
            } else {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            }

            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
    }

    private String cutDecimal(String number) {
        String n[] = number.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0"))
                number = n[0];
        }
        return number;
    }
}