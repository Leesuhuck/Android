package com.example.viewflipper2_1804100283;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrev, btnNext;
        final ViewFlipper viewFlipper, play;

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(1000);

        btnPrev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
                viewFlipper.startFlipping();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
                viewFlipper.stopFlipping();
            }
        });
    }
}