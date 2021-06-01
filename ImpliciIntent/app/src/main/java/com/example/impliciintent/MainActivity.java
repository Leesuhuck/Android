package com.example.impliciintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 예제");

        Button btnDial      = (Button) findViewById(R.id.btnDial);
        Button btnWeb       = (Button) findViewById(R.id.btnWeb);
        Button btnGoogle    = (Button) findViewById(R.id.btnGoogle);
        Button btnSearch    = (Button) findViewById(R.id.btnSearch);
        Button btnSms       = (Button) findViewById(R.id.btnSms);
        Button btnPhoto     = (Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://developer.android.com/studio/write/lint?hl=ko");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.google.co.kr/maps/place/" +
                        "%ED%95%9C%EA%B5%AD%ED%8F%B4%EB%A6%AC%ED%85%8D%EB%8C%8" +
                        "0%ED%95%99+%EB%B0%98%EB%8F%84%EC%B2%B4%EC%9C%B5%ED%95%A9%" +
                        "EC%BA%A0%ED%8D%BC%EC%8A%A4/@37.0082025,127.1741939,17z/data=!" +
                        "3m1!4b1!4m5!3m4!1s0x357b36d17df11dc3:0x7e834a07f057f2e8!8m2!3d37." +
                        "0081982!4d127.1763879?hl=ko");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드 스튜디오");
                startActivity(intent);

            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "Hi?");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-5678")));
                startActivity(intent);

            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);

            }
        });

    }
}