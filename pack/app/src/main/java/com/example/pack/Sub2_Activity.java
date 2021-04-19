package com.example.pack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Sub2_Activity extends AppCompatActivity {

    // 원금 균등 상환 방식

    private TextView text_end_I_p, text_end_R_p,text_end_S_p, text_theorem_I_R_p;

    String Max_ful_p, Max_ful2_p, Max_ful3_p, value_p_1, value_p_2, value_p_3,  Max_value, str, btr, ctr;

    double inte_mmoney;

    DecimalFormat formatter = new DecimalFormat("###,###"); // 숫자 사이에 ,를 넣는 함수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2_);
        text_end_I_p = findViewById(R.id.text_end_I_p);
        text_end_R_p = findViewById(R.id.text_end_R_p);
        text_end_S_p = findViewById(R.id.text_end_S_p);
        text_theorem_I_R_p = findViewById(R.id.text_theorem_I_R_p);

        Intent intent3 = getIntent(); // intent3 저장값 가져오기

        value_p_1 = intent3.getStringExtra("value_p_1"); // 사용자 이자 값 수식 결과 가져오기
        value_p_2 = intent3.getStringExtra("value_p_2"); // 사용자 이자 값 수식 결과 가져오기
        value_p_3 = intent3.getStringExtra("value_p_3"); // 사용자 이자 값 수식 결과 가져오기

        //Max_value = intent3.getStringExtra("Max_ful_p"); // 사용자 이자 값 수식 결과 가져오기

        text_end_I_p.setText(String.valueOf(value_p_1)); // 원금 이자 결과 화면에 적용
        text_end_R_p.setText(String.valueOf(value_p_2)); // 원금 이자 결과 화면에 적용
        text_end_S_p.setText(String.valueOf(value_p_3));


        str = intent3.getStringExtra("str"); // 사용자 원하는 str 입력값
        btr = intent3.getStringExtra("btr"); // 사용자 원하는 btr 입력값
        ctr = intent3.getStringExtra("ctr"); // 사용자 원하는 ctr 입력값


        // for 문으로 text_thorem_i_R_P 출력하기

        double inter_p = Double.valueOf(btr).doubleValue() / 100; // 정수로 들어온 이자율을 백분율로 계산 → ex) 2%로 들어온 경우 0.02로 계산
        double inte_m = inter_p / 12;

        int money = Integer.parseInt(str); // 원금을 정수로 저장
        int month = Integer.parseInt(ctr); // 개월 수를 정수로 저장

        int first_w = Integer.parseInt(str); // 원금의 초기값 저장을 위해서 새로운 변수에 저장

        double mmoney_p = first_w / month; // 매달 상환해야 하는 원금을 구하는 공식

        double inte_p = 0, sum_p = 0;

        text_theorem_I_R_p.setText("▶ 실행 결과\n\n");

        for (int i = 1; i <= month; i++) {
            inte_p = (money * inte_m) / 10 * 10; // 매달 상환해야 하는 이자비용

            if (i < 10) {
                Max_ful_p = ("0"+ i +"번째 달 상환 금액 \n");
                text_theorem_I_R_p.append(Max_ful_p); //텍스트 덧붙이기
                Max_ful2_p = ("☞ 이자비용 : "+ formatter.format(inte_p) +"원 +  납입원금 : " + formatter.format(mmoney_p) + "원 \n");
                text_theorem_I_R_p.append(Max_ful2_p);
                Max_ful3_p = ("납부 금액 : " + formatter.format(inte_p + mmoney_p) + "원 \n\n");
                text_theorem_I_R_p.append(Max_ful3_p);
            } else if (i < month) {
                Max_ful_p = ("0"+ i +"번째 달 상환 금액 \n");
                text_theorem_I_R_p.append(Max_ful_p); //텍스트 덧붙이기
                Max_ful2_p = ("☞ 이자비용 : "+ formatter.format(inte_p) +"원 +  납입원금 : " + formatter.format(mmoney_p) + "원 \n");
                text_theorem_I_R_p.append(Max_ful2_p);
                Max_ful3_p = ("납부 금액 : " + formatter.format(inte_p + mmoney_p) + "원 \n\n");
                text_theorem_I_R_p.append(Max_ful3_p);
            } else {
                Max_ful_p = ("0"+ i +"번째 달 상환 금액 \n");
                text_theorem_I_R_p.append(Max_ful_p); //텍스트 덧붙이기
                Max_ful2_p = ("☞ 이자비용 : "+ formatter.format(inte_p) +"원 +  납입원금 : " + formatter.format(mmoney_p) + "원 \n");
                text_theorem_I_R_p.append(Max_ful2_p);
                Max_ful3_p = ("납부 금액 : " + formatter.format(inte_p + mmoney_p) + "원 \n");
                text_theorem_I_R_p.append(Max_ful3_p);
            }

            money -= mmoney_p; // 원금에서 상환원금을 빼는 공식
            sum_p += inte_p; // 매달 이자비용을 저장하는 공식
        };

    }
}