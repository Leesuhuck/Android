package com.example.fianl_1804100283;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginView extends AppCompatActivity {

    EditText edtId, edtPw;
    Button btnLogin, btnReset, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        setTitle("로그인창");

        edtId = (EditText) findViewById(R.id.idVal);
        edtPw = (EditText) findViewById(R.id.pwVal);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnReset = (Button) findViewById(R.id.btnReturn);
        btnHome = (Button) findViewById(R.id.btnReHome);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentLoginVal = new Intent(getApplicationContext(), LoginValueView.class);
                intentLoginVal.putExtra("userID", edtId.getText().toString());
                intentLoginVal.putExtra("userPW", edtPw.getText().toString());
                startActivityForResult(intentLoginVal, 0);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String hap = edtId.getText().toString();
            Toast.makeText(getApplicationContext(), "로그인이 정상처리되었습니다." +
                    hap, Toast.LENGTH_SHORT).show();
        } else {

            String hap = edtId.getText().toString();
            Toast.makeText(getApplicationContext(), "로그인이 실패하였습니다." +
                    hap, Toast.LENGTH_SHORT).show();
        }

    }
}