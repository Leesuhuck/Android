package com.example.onactivityresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        Button btnNewActivity = (Button) findViewById(R.id.btnVal);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtFirst    = (EditText) findViewById(R.id.edtValfirst);
                EditText edtTwo      = (EditText) findViewById(R.id.edtValtwo);
                Intent intent        = new Intent(getApplicationContext(),
                        SecondActivity.class);

                intent.putExtra("Num1", Double.valueOf(edtFirst.getText().toString()));
                intent.putExtra("Num2", Double.valueOf(edtTwo.getText().toString()));

                startActivityForResult(intent, 0);

            }
        });
    }

    //@SuppressLint("MissingSuperCall") // 린트 검사를 사용 중지하는 방법, 경고 에러 무시
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            Double hap = data.getDoubleExtra("Hap",0);

            Toast.makeText(getApplicationContext(), "합계 : " + hap,
                    Toast.LENGTH_SHORT).show();
        }

    }

}