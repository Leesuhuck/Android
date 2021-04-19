package com.example.pack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity {

    Button btn_text;

    EditText text, text2, text3;

    String str, btr, ctr, Map_p_1, Map_p_2, Map_p_3, Map_w_1, Map_w_2, Map_w_3, Map_m_1, Map_m_2, Map_m_3;

    double inte_mmoney_p ;

    String value_p_1, value_p_2, value_p_3, value_w_1, value_w_2, value_w_3, value_m_1, value_m_2, value_m_3;

    DecimalFormat formatter = new DecimalFormat("###,###"); // 숫자 사이에 ,를 넣는 함수

    public void A(String str, String btr, String ctr){
        // 원금 균등 상환 방식

        double inter_p = Double.valueOf(btr).doubleValue() / 100; // 정수로 들어온 이자율을 백분율로 계산 → ex) 2%로 들어온 경우 0.02로 계산
        double inte_m = inter_p / 12;

        int money = Integer.parseInt(str); // 원금을 정수로 저장
        int month = Integer.parseInt(ctr); // 개월 수를 정수로 저장

        int first_w = Integer.parseInt(str); // 원금의 초기값 저장을 위해서 새로운 변수에 저장

        double mmoney_p = first_w / month; // 매달 상환해야 하는 원금을 구하는 공식

        double inte_p = 0, sum_p = 0;

        for (int i = 1; i <= month; i++) {

            inte_p = (money * inte_m) / 10 * 10; // 매달 상환해야 하는 이자비용

            money -= mmoney_p; // 원금에서 상환원금을 빼는 공식
            sum_p += inte_p; // 매달 이자비용을 저장하는 공식
        };

        int total_p = (int)sum_p + first_w; // 최종 상환비용을 구하는 공식

        value_p_1 = formatter.format(sum_p); // 납부해야 하는 이자비용 총합
        value_p_2 = formatter.format(first_w); // 납부해야 하는 원금
        value_p_3 = formatter.format(total_p); // 총 납부액
    }

    public void B(String str, String btr, String ctr){
        // 원리금 균등 상환 방식

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

        for (int i = 1; i <= month; i++) {
            inte_w = round(money * inte_m); // 각 달의 이자비용을 구하는 공식
            mmoney_w = princ - inte_w; // 원금에서 상환금에서 이자비용을 뺀 결과 → 상환금 - 이자비용 = 납입원금

            money -= mmoney_w; // 원금에서 각 달의 납입원금을 빼는 공식
            sum_w += inte_w; // 매달 이자비용을 저장하는 공식
        }

        int total_w = sum_w + first_w; // 최종 상환비용을 구하는 공식

        value_w_1 = formatter.format(sum_w); // 납부해야 하는 이자비용 총합
        value_w_2 = formatter.format(first_w); // 납부해야 하는 원금
        value_w_3 = formatter.format(total_w); // 총 납부액
    }

    public void C(String str, String btr, String ctr) {
        // 원금 만기 일시 상환 방식

        double inter_m = Double.valueOf(btr).doubleValue() / 100; // 정수로 들어온 이자율을 백분율로 계산 → ex) 2%로 들어온 경우 0.02로 계산

        double inte_m = Double.valueOf(str).doubleValue() * inter_m / 12; // 월 이자 비용을 구하는 공식
        int minte = (int) inte_m; // 이자비용을 정수 형태로 변환

        int sum_m = 0; // 이자비용의 총합을 저장하기 위한 변수

        int money = Integer.parseInt(str); // 원금을 정수로 저장
        int month = Integer.parseInt(ctr); // 개월 수를 정수로 저장

        for (int i = 1; i <= month; i++) {
            sum_m += minte; // 상환 기간동안 이자비용의 총합을 구하는 공식
        }

        int total_m = sum_m + money; // 최종 상환비용을 구하는 공식

        value_m_1 = formatter.format(sum_m); // 납부해야 하는 이자비용 총합
        value_m_2 = formatter.format(money); // 납부해야 하는 원금
        value_m_3 = formatter.format(total_m); // 총 납부액
    }

    //return 적용
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);

        Button btn_text = (Button)findViewById(R.id.btn1);

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, SubActivity.class); //이동경로
                str = text.getText().toString();
                btr = text2.getText().toString();
                ctr = text3.getText().toString();

                A(str, btr, ctr);

                B(str, btr, ctr);

                C(str, btr, ctr);

                Map_p_1 = "" + value_p_1; // 원금 이자 문자열로 변환
                Map_w_1 = "" + value_w_1; // 원리금 이자 문자열로 변환
                Map_m_1 = "" + value_m_1; // 만기금 이자 문자열로 변환

                Map_p_2 = "" + value_p_2; // 원금 상환 문자열로 변환
                Map_w_2 = "" + value_w_2; // 원리금 상환 문자열로 변환
                Map_m_2 = "" + value_m_2; // 만기금 상환 문자열로 변환

                Map_p_3 = "" + value_p_3;
                Map_w_3 = "" + value_w_3;
                Map_m_3 = "" + value_m_3;


                intent2.putExtra("value_p_1", Map_p_1); //원금 이자 값저장
                intent2.putExtra("value_p_2", Map_p_2); //원금 상환 값저장
                intent2.putExtra("value_p_3", Map_p_3); //원금 상환 값저장

                intent2.putExtra("value_w_1", Map_w_1); //원리금 이자 값저장
                intent2.putExtra("value_w_2", Map_w_2); //원리금 상환 값저장
                intent2.putExtra("value_w_3", Map_w_3); //원금 상환 값저장

                intent2.putExtra("value_m_1", Map_m_1); //만리금 이자 값저장
                intent2.putExtra("value_m_2", Map_m_2); //만리금 상환 값저장
                intent2.putExtra("value_m_3", Map_m_3); //원금 상환 값저장

                intent2.putExtra("str", str); //만리금 상환 값저장
                intent2.putExtra("btr", btr); //만리금 상환 값저장
                intent2.putExtra("ctr", ctr); //만리금 상환 값저장

                startActivity(intent2);

            }
        });

        text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == event.KEYCODE_ENTER) {
                        return true;
                    }
                }
                return false;
            }
        });

        text2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == event.KEYCODE_ENTER) {
                        return true;
                    }
                }
                return false;
            }
        });

        text3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    //android:singleLine = "true" 한줄입력 처리하기
                    //android:lines = "1" 라인사이즈 한줄
                    //이벤트안에 있는 자식인 액션을가져옴
                    // 액션메소드안에 있는 키인벤트에 액션다운이라는 실행을 가져옴
                    // 액션다운은 키를 눌렀을 때를 뜻함

                    if (keyCode == event.KEYCODE_ENTER) {
                        return true;
                        // 여기서 알수 있듯이 내가 어던키? 즉 키를 눌렀지만 어떤키를
                        // 눌렀을때 실행차별을 두기위해 엔터키를 찾아 지정함
                    }
                }
                return false;
            }
        });
    }
}