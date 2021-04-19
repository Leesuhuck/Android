package com.example.pack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class SubActivity extends AppCompatActivity {

    private TextView text_I_p, text_R_p, text_S_p, text_I_w, text_R_w, text_S_w, text_I_m, text_R_m, text_S_m;

    Button btn_p, btn_w, btn_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 원금 균등 상환 방식

        text_I_p = findViewById(R.id.text_interest_principal); // 원금 이자비용
        text_R_p = findViewById(R.id.text_Repayment_principal); // 원금 원금
        text_S_p = findViewById(R.id.text_Sum_principal); // 상환 총액

        // 원리금 균등 상환 방식

        text_I_w = findViewById(R.id.text_interest_wonligeum); // 원리금 이자비용
        text_R_w = findViewById(R.id.text_Repayment_wonligeum); // 원리금 원금
        text_S_w = findViewById(R.id.text_Sum_wonligeum); // 상환 총액

        // 원금 만기 일시 상환 방식

        text_I_m = findViewById(R.id.text_interest_maturity); // 만기 이자비용
        text_R_m = findViewById(R.id.text_Repayment_maturity); // 만기 원금
        text_S_m = findViewById(R.id.text_Sum_maturity); // 상환 총액

        btn_p = findViewById(R.id.btn_principal); // 원금 버튼
        btn_w = findViewById(R.id.btn_wonligeum); // 원리금 버튼
        btn_m = findViewById(R.id.btn_maturity); // 만기 버튼

        Intent intent2 = getIntent(); // intent2 저장값 가져오기

        String str, btr, ctr, value_p_1, value_p_2, value_p_3, value_w_1, value_w_2, value_w_3, value_m_1, value_m_2, value_m_3; //문자열 지정

        // 원금 균등 상환 방식

        value_p_1 = intent2.getStringExtra("value_p_1"); // 납부 이자 총액 가져오기
        value_p_2 = intent2.getStringExtra("value_p_2"); // 대출 원금 가져오기
        value_p_3 = intent2.getStringExtra("value_p_3"); // 상환 총액 결과 가져오기

        // 원리금 균등 상환 방식

        value_w_1 = intent2.getStringExtra("value_w_1"); // 납부 이자 총액 가져오기
        value_w_2 = intent2.getStringExtra("value_w_2"); // 대출 원금 가져오기
        value_w_3 = intent2.getStringExtra("value_w_3"); // 상환 총액 결과 가져오기

        // 원금 만기 일시 상환 방식

        value_m_1 = intent2.getStringExtra("value_m_1"); // 납부 이자 총액 가져오기
        value_m_2 = intent2.getStringExtra("value_m_2"); // 대출 원금 가져오기
        value_m_3 = intent2.getStringExtra("value_m_3"); // 상환 총액 결과 가져오기

        str = intent2.getStringExtra("str"); // 사용자 원하는 str 입력값
        btr = intent2.getStringExtra("btr"); // 사용자 원하는 btr 입력값
        ctr = intent2.getStringExtra("ctr"); // 사용자 원하는 ctr 입력값

        // 원금 균등 상환 방식

        text_I_p.setText(String.valueOf(value_p_1)); // 납부 이자 총액 화면에 적용
        text_R_p.setText(String.valueOf(value_p_2)); // 대출 원금 화면에 적용
        text_S_p.setText(String.valueOf(value_p_3)); // 상환 총액 화면에 적용

        // 원리금 균등 상환 방식

        text_I_w.setText(String.valueOf(value_w_1)); // 납부 이자 총액 화면에 적용
        text_R_w.setText(String.valueOf(value_w_2)); // 대출 원금 화면에 적용
        text_S_w.setText(String.valueOf(value_w_3)); // 상환 총액 화면에 적용

        // 원금 만기 일시 상환 방식

        text_I_m.setText(String.valueOf(value_m_1)); // 납부 이자 총액 화면에 적용
        text_R_m.setText(String.valueOf(value_m_2)); // 대출 원금 화면에 적용
        text_S_m.setText(String.valueOf(value_m_3)); // 상환 총액 화면에 적용


        btn_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(SubActivity.this, Sub2_Activity.class); //총 원금 이동경로
                // 원금 총합 이자 상환 금액식 추가

                intent3.putExtra("str", str); //만리금 상환 값저장
                intent3.putExtra("btr", btr); //만리금 상환 값저장
                intent3.putExtra("ctr", ctr); //만리금 상환 값저장

                intent3.putExtra("value_p_1", value_p_1);
                intent3.putExtra("value_p_2", value_p_2);
                intent3.putExtra("value_p_3", value_p_3);

                startActivity(intent3);
            }
        });

        btn_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(SubActivity.this, Sub3_Activity.class); //총 원리금 이동경로
                // 원리금 총합 이자 상환 금액 추가

                intent4.putExtra("str", str); //만리금 상환 값저장
                intent4.putExtra("btr", btr); //만리금 상환 값저장
                intent4.putExtra("ctr", ctr); //만리금 상환 값저장

                // ful = Double.valueOf(str).doubleValue() + Double.valueOf(btr).doubleValue() + Double.valueOf(ctr).doubleValue(); // 원리금 총합 식 입력할것.
                intent4.putExtra("value_w_1", value_w_1);
                intent4.putExtra("value_w_2", value_w_2);
                intent4.putExtra("value_w_3", value_w_3);

                startActivity(intent4);
            }
        });

        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(SubActivity.this, Sub4_Activity.class); //총 만기 이동경로
                // 만기금 총합 이자 상환 금액 추가

                intent5.putExtra("str", str); //만리금 상환 값저장
                intent5.putExtra("btr", btr); //만리금 상환 값저장
                intent5.putExtra("ctr", ctr); //만리금 상환 값저장

                //ful = Double.valueOf(str).doubleValue() + Double.valueOf(btr).doubleValue() + Double.valueOf(ctr).doubleValue(); // 만리금 총합 식 입력할것.

                intent5.putExtra("value_m_1", value_m_1);
                intent5.putExtra("value_m_2", value_m_2);
                intent5.putExtra("value_m_3", value_m_3);

                startActivity(intent5);
            }
        });


    }
}