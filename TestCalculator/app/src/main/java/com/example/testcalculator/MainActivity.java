package com.example.testcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    TextView number1, number2, resultText, resultTextValue;
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, maius, square,
            division, values;
    Button[] list = new Button[10];
    int delNumber = 0, delNumber2 = 1;
    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (TextView) findViewById(R.id.varOneNumber);
        num1 = number1.getText().toString();
        number2 = (TextView) findViewById(R.id.varTwoNumber);
        resultText = (TextView) findViewById(R.id.resultText);
        resultTextValue = (TextView) findViewById(R.id.resultTextValue);
        int [] str = {R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine};
        plus = (Button) findViewById(R.id.plus);
        maius = (Button) findViewById(R.id.maius);
        square = (Button) findViewById(R.id.square);
        division = (Button) findViewById(R.id.division);
        values = (Button) findViewById(R.id.values);

        for (int i = 0; i < str.length; i++) {
            list[i] = (Button) findViewById(str[i]);
        }

        for (int i = 0; i < list.length; i++ ) {

            final int finalI;
            finalI = i;

            list[finalI].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    num1 = number1.getText().toString() + list[finalI].getText().toString();
                    number1.setText(num1);
                }
            });

        }

    }
}