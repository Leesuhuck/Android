package com.example.fianl_1804100283;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인화면");
    }

    // 메뉴등록
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.usermenu, menu);

        return true;
    }

    // 메뉴 기능 설계
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {

            // 회원가입
            case R.id.createUser :

                Intent intentLogin = new Intent(getApplicationContext(), CreateUserDB.class);
                startActivity(intentLogin);

                return true;

            // 로그인
            case R.id.pushUser :

                return true;

            case R.id.menuHome :

                Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentHome);

                return true;
        }

        return false;
    }


}