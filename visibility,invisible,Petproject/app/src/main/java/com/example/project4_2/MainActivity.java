package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textCik, textPet;
    CheckBox chkAgree;
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCik = (TextView) findViewById(R.id.textIcon);
        textPet = (TextView) findViewById(R.id.textPet);
        chkAgree = (CheckBox) findViewById(R.id.CikBox);
        rGroup = (RadioGroup) findViewById(R.id.Rgroup);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        btnOK = (Button) findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        setTitle("애완동물 사진 보기");

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkAgree.isChecked() == true) {
                    textPet.setVisibility(android.view.View.VISIBLE);
                    rGroup.setVisibility(android.view.View.VISIBLE);
                    btnOK.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                }
                else {
                    textPet.setVisibility(android.view.View.INVISIBLE);
                    rGroup.setVisibility(android.view.View.INVISIBLE);
                    btnOK.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        btnOK.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;

                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하시오", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

    }
}