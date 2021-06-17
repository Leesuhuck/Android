package com.example.fianl_1804100283;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginValueView extends AppCompatActivity {

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_value_view);
        setTitle("로그인 결과");

        Intent getIntent = getIntent();
        final String idValue = getIntent.getStringExtra("userID");
        final String pwValue = getIntent.getStringExtra("userPW");

        btnReturn = (Button) findViewById(R.id.btnReIntent);

        btnReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent outIntent = new Intent(getApplicationContext(), LoginView.class);

                    if (idValue.equals("어떻게 가져와요?")) {
                        setResult(RESULT_OK, outIntent);
                    }
                    else {
                        setResult(RESULT_FIRST_USER, outIntent);
                    }

                finish();
            }
        });
    }
}