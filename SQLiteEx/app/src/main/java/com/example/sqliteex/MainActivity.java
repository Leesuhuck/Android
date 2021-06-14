package com.example.sqliteex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtNm, edtNum, edtNmResult, edtNumResult;
    Button btnInit, btnInsert, btnSelect, btnUpdate, btnDel;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtNm = (EditText) findViewById(R.id.btnName);
        edtNum = (EditText) findViewById(R.id.btnNumber);
        edtNmResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumResult = (EditText) findViewById(R.id.edtNumberResult);
        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDel = (Button) findViewById(R.id.btnDelect);

        myHelper = new myDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //읽기 및 쓰기에 사용할 데이터베이스를 생성 및 / 또는 엽니다. 이것이 처음 호출되면
                // 데이터베이스가 열리고 onCreate onUpdate 등등 열리게 됩니다. 초기화 할때 디스크 용량 주의
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }

        });

        btnInsert.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + edtNm.getText().toString() + "', " +
                        edtNum.getText().toString() + "); ");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨", 0).show();
            }

        });

        btnSelect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 읽기전용 데이터 베이스로 반환되어 엽니다.
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹이름" + "\r\n" + "_______" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "_______" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                edtNmResult.setText(strNames);
                edtNumResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }

        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("UPDATE groupTBL SET PeopleNumber = '" + edtNum.getText().toString() +
                        "' WHERE PeopleName = '" + edtNm.getText().toString() + "';");
                sqlDB.close();
                //Toast.makeText(getApplicationContext(), "수정됨", 0).show();

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM groupTBL WHERE PeopleName ='" +
                        edtNm.getText().toString() + "';");
                sqlDB.close();
                //Toast.makeText(getApplicationContext(), "삭제되었음", 0).show();

                btnSelect.callOnClick();

            }
        });
    }

    //SQLiteOpenHelper
    /*
        애뮬레이터 AVD 실행시 playstore 애뮬레이터 설치 버전이 없는 AVD로 실행하여 충돌을 막을것
     */
    public class myDBHelper extends SQLiteOpenHelper {

        public myDBHelper(Context context) {
            super(context, "groupDB",
                    null, 1);
        }

        // 테이블을 생성한 SQL문은 SQLiteDatabase 클래스의 execSQL() 메소드로 실행함
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL (PeopleName CHAR(20) PRIMARY KEY," +
                    " PeopleNumber INTEGER);");
        }

        // 테이블 삭제하고 새로 생성(초기화)
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}