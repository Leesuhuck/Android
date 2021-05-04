package com.example.miderterm2_1804100283;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText getNmOne, getNmTwo;
    Button plus, mainus, mult, divide, reDivide;
    String num1, num2;
    double values;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNmOne    = (EditText) findViewById(R.id.varNumberOne);
        getNmTwo    = (EditText) findViewById(R.id.varNumberTwo);
        plus        = (Button) findViewById(R.id.plus);
        mainus      = (Button) findViewById(R.id.mainus);
        mult        = (Button) findViewById(R.id.multiplication);
        divide      = (Button) findViewById(R.id.divide);
        reDivide    = (Button) findViewById(R.id.remainingDivide);
        result      = (TextView) findViewById(R.id.resultView);

        // 더하기
        plus.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("WrongConstant")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (getNmOne.getText().toString().equals("") || getNmTwo.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(),"입력 값이 없습니다.",Toast.LENGTH_SHORT).show();

                } else {

                    num1    = getNmOne.getText().toString();
                    num2    = getNmTwo.getText().toString();
                    values  = Double.valueOf(num1) + Double.valueOf(num2);

                    result.setText("계산 결과 : " + Math.round(values*100)/100.0);

                }

                return false;
            }
        });

        // 빼기
        mainus.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (getNmOne.getText().toString().equals("") || getNmTwo.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(),"입력 값이 없습니다.",Toast.LENGTH_SHORT).show();

                } else {

                    num1    = getNmOne.getText().toString();
                    num2    = getNmTwo.getText().toString();
                    values  = Double.valueOf(num1) - Double.valueOf(num2);

                    result.setText("계산 결과 : " + Math.round(values*100)/100.0);
                }
                return false;
            }
        });

        // 곱하기
        mult.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (getNmOne.getText().toString().equals("") || getNmTwo.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(),"입력 값이 없습니다.",Toast.LENGTH_SHORT).show();

                } else {

                    num1    = getNmOne.getText().toString();
                    num2    = getNmTwo.getText().toString();
                    values  = Double.valueOf(num1) * Double.valueOf(num2);

                    result.setText("계산 결과 : " + Math.round(values*100)/100.0);
                }
                return false;
            }
        });

        // 나누기
        divide.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (getNmOne.getText().toString().equals("") || getNmTwo.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(),"입력 값이 없습니다.",Toast.LENGTH_SHORT).show();

                } else if (getNmOne.getText().toString().equals("0") || getNmTwo.getText().toString().equals("0")) {

                    Toast.makeText(getApplicationContext(),"0으로 나눗셈이나 나머지는 구할수 없습니다.",
                            Toast.LENGTH_SHORT).show();

                }
                else {
                    num1    = getNmOne.getText().toString();
                    num2    = getNmTwo.getText().toString();
                    values  = Double.valueOf(num1) / Double.valueOf(num2);

                    result.setText("계산 결과 : " + Math.round(values*100)/100.0);
                }
                return false;
            }
        });

        // 나머지
        reDivide.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (getNmOne.getText().toString().equals("") || getNmTwo.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(),"입력 값이 없습니다.",Toast.LENGTH_SHORT).show();

                } else if (getNmOne.getText().toString().equals("0") || getNmTwo.getText().toString().equals("0")) {

                    Toast.makeText(getApplicationContext(),"0으로 나눗셈이나 나머지는 구할수 없습니다.",
                            Toast.LENGTH_SHORT).show();

                } else {

                    num1    = getNmOne.getText().toString();
                    num2    = getNmTwo.getText().toString();
                    values  = Double.valueOf(num1) % Double.valueOf(num2);

                    result.setText("계산 결과 : " + Math.round(values*100)/100.0);
                }
                return false;

            }
        });
    }
}