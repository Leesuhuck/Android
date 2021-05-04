package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button[] Btn = {};
    Button[] sachiBtn = {};
    Integer[] Intbuttons = {R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five,
                            R.id.six, R.id.seven, R.id.eight, R.id.night};
    Integer[] IntsachiBtn = {R.id.plus, R.id.pplus, R.id.maius, R.id.mamaius, R.id.delects};
    TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.numberFrist);
        number2 = findViewById(R.id.numberSed);
        value = findViewById(R.id.values);

        number1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < Intbuttons.length; i++) {
                    Btn[i] = findViewById(Intbuttons[i]);

                    int finalI = i;
                    Btn[i].setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {

                            String numbers = Btn[finalI].getText().toString();

                            number1.setText(numbers);

                            return false;
                        }
                    });
                }
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < Intbuttons.length; i++) {
                    Btn[i] = findViewById(Intbuttons[i]);

                    int finalI = i;
                    Btn[i].setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {

                            String numbers = Btn[finalI].getText().toString();

                            number2.setText(numbers);

                            return false;
                        }
                    });
                }
            }
        });

        for (int i = 0; i < IntsachiBtn.length; i++) {
            sachiBtn[i] = findViewById(IntsachiBtn[i]);
        }



    }
}