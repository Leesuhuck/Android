package com.example.onactivityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("SecondActivity");

        Intent getIntent = getIntent();
        final Double hapVal = getIntent.getDoubleExtra("Num1", 0) +
                getIntent.getDoubleExtra("Num2",0);

        Button btnReturn = (Button) findViewById(R.id.returnBtn);

        btnReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", hapVal);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }
}