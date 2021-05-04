package com.example.androidtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.num4_17);

        TextView tv1, tv2, tv3, tv4;

        tv1 = (TextView) findViewById(R.id.Textview1);
        tv2 = (TextView) findViewById(R.id.Textview2);
        tv3 = (TextView) findViewById(R.id.Textview3);
        tv4 = (TextView) findViewById(R.id.Textview4);

        tv1.setText("안녕하세요?");
        tv2.setTextSize(30);
        tv2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        tv3.setText("setSingleLinesetSingleLinesetSingleLinesetSingleLine" +
                "setSingleLinesetSingleLine");
        tv3.setSingleLine();
        tv4.setText("TrueSingLineTrueSingLineTrueSingLineTrueSingLineTrueSingLine" +
                "TrueSingLineTrueSingLineTrueSingLineTrueSingLineTrueSingLine");
        tv4.setTextSize(20);
        tv4.setSingleLine(true);



    }
}