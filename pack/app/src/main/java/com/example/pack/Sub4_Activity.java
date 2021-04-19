package com.example.pack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Sub4_Activity extends AppCompatActivity {

    private TextView text_end_I_m, text_end_R_m, text_end_S_m, text_theorem_I_R_m;

    String Max_ful_m, Max_ful2_m, Max_ful3_m, str, btr, ctr, value_m_1, value_m_2, value_m_3;

    DecimalFormat formatter = new DecimalFormat("###,###"); // 숫자 사이에 ,를 넣는 함수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4_);
        text_end_I_m = findViewById(R.id.text_end_I_m);
        text_end_R_m = findViewById(R.id.text_end_R_m);
        text_end_S_m = findViewById(R.id.text_end_S_m);
        text_theorem_I_R_m = findViewById(R.id.text_theorem_I_R_m);

        Intent intent5 = getIntent(); // intent5 저장값 가져오기

        str = intent5.getStringExtra("str"); // 사용자 원하는 str 입력값
        btr = intent5.getStringExtra("btr"); // 사용자 원하는 btr 입력값
        ctr = intent5.getStringExtra("ctr"); // 사용자 원하는 ctr 입력값

        value_m_1 = intent5.getStringExtra("value_m_1"); // 사용자 이자 값 수식 결과 가져오기
        value_m_2 = intent5.getStringExtra("value_m_2"); // 사용자 이자 값 수식 결과 가져오기
        value_m_3 = intent5.getStringExtra("value_m_3"); // 사용자 이자 값 수식 결과 가져오기

        text_end_I_m.setText(String.valueOf(value_m_1)); // 원금 이자 결과 화면에 적용
        text_end_R_m.setText(String.valueOf(value_m_2)); // 원금 이자 결과 화면에 적용
        text_end_S_m.setText(String.valueOf(value_m_3));

        double inter_m = Double.valueOf(btr).doubleValue() / 100; // 정수로 들어온 이자율을 백분율로 계산 → ex) 2%로 들어온 경우 0.02로 계산

        double inte_m = Double.valueOf(str).doubleValue() * inter_m / 12; // 월 이자 비용을 구하는 공식
        int minte = (int) inte_m; // 이자비용을 정수 형태로 변환

        int sum_m = 0; // 이자비용의 총합을 저장하기 위한 변수

        int money = Integer.parseInt(str); // 원금을 정수로 저장
        int month = Integer.parseInt(ctr); // 개월 수를 정수로 저장

        text_theorem_I_R_m.setText("▶ 실행 결과\n\n");

        for (int i = 1; i < month; i++) {

            if (i < 10) {
                Max_ful_m = ("0"+ i +"번째 달 상환 금액 \n");
                text_theorem_I_R_m.append(Max_ful_m); //텍스트 덧붙이기
                Max_ful2_m = ("☞ 이자비용 : "+ formatter.format(inte_m) +"원 +  납입원금 :  0원 \n");
                text_theorem_I_R_m.append(Max_ful2_m);
                Max_ful3_m = ("납부 금액 : " + formatter.format(inte_m) + "원 \n\n");
                text_theorem_I_R_m.append(Max_ful3_m);
            } else  {
                Max_ful_m = (i +"번째 달 상환 금액 \n");
                text_theorem_I_R_m.append(Max_ful_m); //텍스트 덧붙이기
                Max_ful2_m = ("☞ 이자비용 : "+ formatter.format(inte_m) +"원 +  납입원금 :  0원 \n");
                text_theorem_I_R_m.append(Max_ful2_m);
                Max_ful3_m = ("납부 금액 : " + formatter.format(inte_m) + "원 \n\n");
                text_theorem_I_R_m.append(Max_ful3_m);
            }

            sum_m += minte; // 상환 기간동안 이자비용의 총합을 구하는 공식
        }

        if (month < 10) {
            Max_ful_m = ("0" + month +"번째 달 상환 금액 \n");
            text_theorem_I_R_m.append(Max_ful_m); //텍스트 덧붙이기
            Max_ful2_m = ("☞ 이자비용 : "+ formatter.format(inte_m) +"원 +  납입원금 : " + formatter.format(money) + " 원 \n");
            text_theorem_I_R_m.append(Max_ful2_m);
            Max_ful3_m = ("납부 금액 : " + formatter.format(inte_m + money) + "원 \n");
            text_theorem_I_R_m.append(Max_ful3_m);
        } else {
            Max_ful_m = (month +"번째 달 상환 금액 \n");
            text_theorem_I_R_m.append(Max_ful_m); //텍스트 덧붙이기
            Max_ful2_m = ("☞ 이자비용 : "+ formatter.format(inte_m) +"원 +  납입원금 : " + formatter.format(money) + " 원 \n");
            text_theorem_I_R_m.append(Max_ful2_m);
            Max_ful3_m = ("납부 금액 : " + formatter.format(inte_m + money) + "원 \n");
            text_theorem_I_R_m.append(Max_ful3_m);
        }


    }
}