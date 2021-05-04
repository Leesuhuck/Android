package com.example.app4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView cLkView;
    RadioGroup cRdGup;
    RadioButton[] cRdBtn = new RadioButton[3];
    Button cExitBtn, cReBtn;
    Switch cSwitchBtn;
    ImageView cIgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cLkView = (TextView)findViewById(R.id.likeText);
        cRdGup = (RadioGroup)findViewById(R.id.rdGup);
        cRdBtn[0] = (RadioButton)findViewById(R.id.rdBtnP);
        cRdBtn[1] = (RadioButton)findViewById(R.id.rdBtnQ);
        cRdBtn[2] = (RadioButton)findViewById(R.id.rdBtnR);
        cExitBtn = (Button)findViewById(R.id.exitBtn);
        cReBtn = (Button)findViewById(R.id.reBtn);
        cSwitchBtn = (Switch)findViewById(R.id.switchBtn);
        cIgView = (ImageView)findViewById(R.id.iconView);

        cSwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cSwitchBtn.isChecked() == true) {
                    cLkView.setVisibility(View.VISIBLE);
                    cRdGup.setVisibility(View.VISIBLE);
                    cRdBtn[0].setVisibility(View.VISIBLE);
                    cRdBtn[1].setVisibility(View.VISIBLE);
                    cRdBtn[2].setVisibility(View.VISIBLE);
                    cIgView.setVisibility(View.VISIBLE);
                    cExitBtn.setVisibility(View.VISIBLE);
                    cReBtn.setVisibility(View.VISIBLE);
                } else{
                    cLkView.setVisibility(View.INVISIBLE);
                    cRdGup.setVisibility(View.INVISIBLE);
                    cRdBtn[0].setVisibility(View.INVISIBLE);
                    cRdBtn[1].setVisibility(View.INVISIBLE);
                    cRdBtn[2].setVisibility(View.INVISIBLE);
                    cIgView.setVisibility(View.INVISIBLE);
                    cExitBtn.setVisibility(View.INVISIBLE);
                    cReBtn.setVisibility(View.INVISIBLE);
                }
            }
        });

        for (int index = 0; index< cRdBtn.length; index++) {

            cRdBtn[index].setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    switch (cRdGup.getCheckedRadioButtonId()){
                        case R.id.rdBtnP:
                            cIgView.setImageResource(0);
                            cIgView.setImageResource(R.drawable.ic_baseline_adb_24);
                            break;

                        case R.id.rdBtnQ:
                            cIgView.setImageResource(0);
                            cIgView.setImageResource(R.drawable.ic_baseline_airplanemode_active_24);
                            break;

                        case R.id.rdBtnR:
                            cIgView.setImageResource(0);
                            cIgView.setImageResource(R.drawable.ic_baseline_airplay_24);
                            break;

                        default:
                            return false;
                    }

                    return false;
                }
            });

        }

        cExitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cReBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cLkView.setVisibility(View.INVISIBLE);
                cRdGup.setVisibility(View.INVISIBLE);
                cRdBtn[0].setVisibility(View.INVISIBLE);
                cRdBtn[1].setVisibility(View.INVISIBLE);
                cRdBtn[2].setVisibility(View.INVISIBLE);
                cIgView.setVisibility(View.INVISIBLE);
                cExitBtn.setVisibility(View.INVISIBLE);
                cReBtn.setVisibility(View.INVISIBLE);

                cRdGup.clearCheck();
                cIgView.setImageResource(0);
                cSwitchBtn.setChecked(false);

            }
        });


    }
}