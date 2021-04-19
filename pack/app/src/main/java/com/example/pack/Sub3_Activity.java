package com.example.pack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class Sub3_Activity extends AppCompatActivity {

    private TextView text_end_I_w, text_end_R_w, text_end_S_w, text_theorem_I_R_w;

    String Max_ful_w, Max_ful2_w, Max_ful3_w, str, btr, ctr, value_w_1, value_w_2, value_w_3;

    DecimalFormat formatter = new DecimalFormat("###,###"); // 숫자 사이에 ,를 넣는 함수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3_);
        text_end_I_w = findViewById(R.id.text_end_I_w);
        text_end_R_w = findViewById(R.id.text_end_R_w);
        text_end_S_w = findViewById(R.id.text_end_S_w);
        text_theorem_I_R_w = findViewById(R.id.text_theorem_I_R_w);

        Intent intent4 = getIntent(); // intent4 저장값 가져오기

        str = intent4.getStringExtra("str"); // 사용자 원하는 str 입력값
        btr = intent4.getStringExtra("btr"); // 사용자 원하는 btr 입력값
        ctr = intent4.getStringExtra("ctr"); // 사용자 원하는 ctr 입력값

        value_w_1 = intent4.getStringExtra("value_w_1"); // 사용자 이자 값 수식 결과 가져오기
        value_w_2 = intent4.getStringExtra("value_w_2"); // 사용자 이자 값 수식 결과 가져오기
        value_w_3 = intent4.getStringExtra("value_w_3"); // 사용자 이자 값 수식 결과 가져오기

        text_end_I_w.setText(String.valueOf(value_w_1)); // 원금 이자 결과 화면에 적용
        text_end_R_w.setText(String.valueOf(value_w_2)); // 원금 이자 결과 화면에 적용
        text_end_S_w.setText(String.valueOf(value_w_3));

        double inter_m = Double.valueOf(btr).doubleValue() / 100; // 정수로 들어온 이자율을 백분율로 계산 → ex) 2%로 들어온 경우 0.02로 계산

        double inte_m = inter_m / 12; // 월 이자율을 구하는 공식

        int first_w = Integer.parseInt(str); // 원금의 초기값 저장을 위해서 새로운 변수에 저장

        int money = Integer.parseInt(str); // 원금을 정수로 저장
        int month = Integer.parseInt(ctr); // 개월 수를 정수로 저장

        double molecular = first_w * (inte_m * pow(1 + inte_m, month)); // 분자의 값을 구하는 공식
        double denominater = pow(1 + inte_m, month) - 1; // 분모의 값을 구하는 공식

        double princ = round(molecular / denominater); // 월 상환금을 구하는 공식 (이자비용 + 납입원금)

        double inte_w = 0, mmoney_w = 0; // 매달 납입이자를  임시 저장하는 변수
        int sum_w = 0; // sum_w = 최종 이자비용의 총합을 저장하는 변수, mmoney_w = 매달 상환금을 임시 저장하는 변수

        text_theorem_I_R_w.setText("▶ 실행 결과\n\n");

        for (int i = 1; i <= month; i++) {
            inte_w = round(money * inte_m); // 각 달의 이자비용을 구하는 공식
            mmoney_w = princ - inte_w; // 원금에서 상환금에서 이자비용을 뺀 결과 → 상환금 - 이자비용 = 납입원금

            if (i < 10) {
                Max_ful_w = ("0"+ i +"번째 달 상환 금액 \n");
                text_theorem_I_R_w.append(Max_ful_w); //텍스트 덧붙이기
                Max_ful2_w = ("☞ 이자비용 : "+ formatter.format(inte_w) +"원 +  납입원금 : " + formatter.format(mmoney_w) + "원 \n");
                text_theorem_I_R_w.append(Max_ful2_w);
                Max_ful3_w = ("납부 금액 : " + formatter.format(inte_w + mmoney_w) + "원 \n\n");
                text_theorem_I_R_w.append(Max_ful3_w);
            } else if (i < month) {
                Max_ful_w = (i +"번째 달 상환 금액 \n");
                text_theorem_I_R_w.append(Max_ful_w); //텍스트 덧붙이기
                Max_ful2_w = ("☞ 이자비용 : "+ formatter.format(inte_w) +"원 +  납입원금 : " + formatter.format(mmoney_w) + "원 \n");
                text_theorem_I_R_w.append(Max_ful2_w);
                Max_ful3_w = ("납부 금액 : " + formatter.format(inte_w + mmoney_w) + "원 \n\n");
                text_theorem_I_R_w.append(Max_ful3_w);
            } else {
                Max_ful_w = (i +"번째 달 상환 금액 \n");
                text_theorem_I_R_w.append(Max_ful_w); //텍스트 덧붙이기
                Max_ful2_w = ("☞ 이자비용 : "+ formatter.format(inte_w) +"원 +  납입원금 : " + formatter.format(mmoney_w) + "원 \n");
                text_theorem_I_R_w.append(Max_ful2_w);
                Max_ful3_w = ("납부 금액 : " + formatter.format(inte_w + mmoney_w) + "원 \n");
                text_theorem_I_R_w.append(Max_ful3_w);
            }

            money -= mmoney_w; // 원금에서 각 달의 납입원금을 빼는 공식
            sum_w += inte_w; // 매달 이자비용을 저장하는 공식
        }

        int total_w = sum_w + first_w; // 최종 상환비용을 구하는 공식

    }
}