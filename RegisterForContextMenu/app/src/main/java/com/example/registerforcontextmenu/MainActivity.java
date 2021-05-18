package com.example.registerforcontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btnBG, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        baseLayout = findViewById(R.id.baseLayout);
        btnBG = findViewById(R.id.btnBackg);
        registerForContextMenu(btnBG);
        btn = findViewById(R.id.btn);
        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        if (v == btnBG) {
            menu.setHeaderTitle("배경색 변경");

            menuInflater.inflate(R.menu.background_chang, menu);

            if (menu.getItem(0).equals(R.id.itemRed)) {
                baseLayout.setBackgroundColor(Color.RED);
            }
            else if (menu.getItem(1).equals(R.id.itemGreen)) {
                baseLayout.setBackgroundColor(Color.GREEN);
            }
            else if (menu.getItem(2).equals(R.id.itemblue)) {
                baseLayout.setBackgroundColor(Color.BLUE);
            }
        }

        if (v == btn) {
            menu.setHeaderTitle("버튼 변경");

            menuInflater.inflate(R.menu.button_chang, menu);

            if (menu.getItem(1).equals(R.id.itemRed)) {
                btn.setRotation(45);
            }
            else if (menu.getItem(2).equals(R.id.itemGreen)) {
                btn.setScaleX(2);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemblue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                btn.setRotation(45);
                return true;
            case R.id.subSize:
                btn.setScaleX(2);
                return true;
                /*
            case R.id.itemRed:
                baseLayot.setBackgroundColor(Color.RED);
                return true;
                 */
        }

        return false;
    }
}