package com.example.ex6_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoText;
    MultiAutoCompleteTextView multAutoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoText     = findViewById(R.id.autoTextV);
        multAutoText = findViewById(R.id.multAutoTextV);

        String[] itmes = {
                "CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미", "Friends", "Fringe", "Lost",
                "브로드캐스팅-blog", "BMS"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, itmes);

        autoText.setAdapter(arrayAdapter);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multAutoText.setTokenizer(token);
        multAutoText.setAdapter(arrayAdapter);

    }
}