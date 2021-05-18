package com.example.inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayot;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기");
        baseLayot = findViewById(R.id.baseLayout);
        btn1 = findViewById(R.id.btn1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);

        /*
        menu.add(0, 1, 0, "배경색(빨강)");
        menu.add(0, 2, 0, "배경색(초록)");
        menu.add(0, 3, 0, "배경색(파랑)");

        SubMenu subMenu = menu.addSubMenu("버튼 변경 >>");
        subMenu.add(0,4,0, "버튼 45도 회전");
        subMenu.add(0,5,0, "버튼 2배 확대");
        */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayot.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayot.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemblue:
                baseLayot.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                btn1.setRotation(45);
                return true;
            case R.id.subSize:
                btn1.setScaleX(2);
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