package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String firstNumber = "";
    String operator = "+";
    boolean newOperator = true;
    EditText edl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edl = findViewById(R.id.editText);
    }

    public void numEvent(View view) {

        if (newOperator)
            edl.setText("");
        newOperator = false;

        String number = edl.getText().toString();
        switch (view.getId()){
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btnDot:
                number += ".";
                break;
        }
        edl.setText(number);
    }

    public void operatorEvent(View view) {
        newOperator = true;
        firstNumber = edl.getText().toString();
        switch (view.getId()) {
            case R.id.btnDiv: operator = "/"; break;
            case R.id.btnMul: operator = "*"; break;
            case R.id.btnMinus: operator = "-"; break;
            case R.id.btnPlus: operator = "+"; break;
        }

    }

    public void equalEvent(View view) {
        String secondNumber = edl.getText().toString();
        double result = 0.0;
        switch (operator) {
            case "/":
                result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                break;
            case "*":
                result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                break;
            case "-":
                result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                break;
            case "+":
                result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                break;
        }
        edl.setText(result+"");
    }

    public void acEvent(View view) {
        edl.setText("0");
        newOperator = true;
    }

    public void perEvent(View view) {
        double no = Double.parseDouble(edl.getText().toString())/100;
        edl.setText(no+"");
        newOperator = true;
    }

    public void cEvent(View view) {
        if (edl.getText().equals("0")) {
            edl.setText(null);
        } else {
            int len = edl.getText().length();
            String s = edl.getText().toString();
            if (s.charAt(len - 1) == '.') {
                newOperator = true;
                edl.setText(edl.getText().subSequence(0, edl.getText().length() - 1));

            } else {
                edl.setText(edl.getText().subSequence(0, edl.getText().length() - 1));
            }
        }
    }
}