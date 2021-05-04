package com.example.ex4_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textOne, textTwo;
    Button btnPlus, btntMaius, btnPlPlus, btnMaMaius;
    TextView textResult;
    String num1, num2; 
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 처음 화면 실행될때 실행
        setContentView(R.layout.ex_211);
        /*
        textOne = (EditText) findViewById(R.id.EdtbtnNumberOne);
        textTwo = (EditText) findViewById(R.id.EdtbtnNumberTwo);
        textResult = (TextView) findViewById(R.id.result);
        btnPlus = (Button) findViewById(R.id.btnPlus);       // 더하기
        btntMaius = (Button) findViewById(R.id.btnMaius);    // 빼기
        btnPlPlus = (Button) findViewById(R.id.btnPlPlus);   // 곱하기
        btnMaMaius = (Button) findViewById(R.id.btnMaMaius); // 나누기


        btnPlus.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                num1 = textOne.getText().toString();
                num2 = textTwo.getText().toString();

                result = Integer.parseInt(num1) + Integer.parseInt(num2);

                textResult.setText("계산결과 = " + result.toString());

                return false;
            }
        });

        btntMaius.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                num1 = textOne.getText().toString();
                num2 = textTwo.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);

                textResult.setText("계산결과 = " + result.toString());

                return false;
            }
        });

        btnPlPlus.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                num1 = textOne.getText().toString();
                num2 = textTwo.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);

                textResult.setText("계산결과 = " + result.toString());

                return false;
            }
        });

        btnMaMaius.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                num1 = textOne.getText().toString();
                num2 = textTwo.getText().toString();

                result = Integer.parseInt(num1) / Integer.parseInt(num2);

                textResult.setText("계산결과 = " + result.toString());

                return false;
            }
        });
        */
    }
}