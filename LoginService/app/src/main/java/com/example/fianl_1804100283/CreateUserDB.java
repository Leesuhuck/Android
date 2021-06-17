package com.example.fianl_1804100283;

import androidx.annotation.Nullable;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateUserDB extends AppCompatActivity {

    userSQL userSQLInit;
    EditText edtId, edtPw, edtNm, edtYY, edtNum, edtIDResult, edtPWResult, edtNmResult,
            edtSexResult, edtYYResult, edtNumResult;
    RadioButton rBtnM, rBtnY;
    Button btnReset, btnInsert, btnInit, btnDel, btnHome;
    SQLiteDatabase sqlDB;
    RadioGroup group;
    String rBtnMY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_d_b);
        setTitle("회원관리");

        edtId = (EditText) findViewById(R.id.idUser);
        edtPw = (EditText) findViewById(R.id.pwUser);
        edtNm = (EditText) findViewById(R.id.nmUser);
        edtYY = (EditText) findViewById(R.id.edtYY);
        edtNum = (EditText) findViewById(R.id.numUser);
        edtIDResult = (EditText) findViewById(R.id.edtIDResult);
        edtPWResult = (EditText) findViewById(R.id.edtPWResult);
        edtNmResult = (EditText) findViewById(R.id.edtNmResult);
        edtSexResult = (EditText) findViewById(R.id.edtSexResult);
        edtYYResult = (EditText) findViewById(R.id.edtYYResult);
        edtNumResult = (EditText) findViewById(R.id.edtNumResult);

        // 성별
        rBtnM = (RadioButton) findViewById(R.id.userM);
        rBtnY = (RadioButton) findViewById(R.id.userY);
        group = (RadioGroup) findViewById(R.id.gupt);

        btnReset = (Button) findViewById(R.id.btnReset);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInit = (Button) findViewById(R.id.btnVal);
        btnDel = (Button) findViewById(R.id.btnDelete);
        btnHome = (Button) findViewById(R.id.btnHome);

        userSQLInit = new userSQL(this);

        // 남성 클릭시
        rBtnM.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rBtnMY = "남성";
            }
        });

        rBtnY.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rBtnMY = "여성";
            }
        });

        // 초기화이벤트
        btnReset.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

               sqlDB = userSQLInit.getWritableDatabase();
               userSQLInit.onUpgrade(sqlDB, 1, 2);
               sqlDB.close();

               btnInit.callOnClick();
               edtId.getText().clear();
               edtPw.getText().clear();
               edtNm.getText().clear();
               edtYY.getText().clear();
               edtNum.getText().clear();
               group.clearCheck();

           }
       });

        // 입력이벤트
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @SuppressLint({"WrongConstant", "ShowToast"})
            @Override
            public void onClick(View v) {


                sqlDB = userSQLInit.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + edtId.getText().toString() + "', '"
                        + edtPw.getText().toString() + "', '" + edtNm.getText().toString() + "', '"
                        + rBtnMY + "', '" + edtYY.getText().toString()
                        + "', " + edtNum.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨", 0).show();
            }
        });

        // 삭제이벤트
        btnDel.setOnClickListener(new View.OnClickListener() {

            @SuppressLint({"ShowToast", "WrongConstant"})
            @Override
            public void onClick(View v) {

                sqlDB = userSQLInit.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM groupTBL WHERE userId ='" +
                        edtId.getText().toString() + "';");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "삭제됨", 0).show();

                btnInit.callOnClick();

            }
        });

        // 조회이벤트
        btnInit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sqlDB = userSQLInit.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strId = "아이디" + "\n" + "_____" + "\n";
                String strPw = "비밀번호" + "\n" + "_____" + "\n";
                String strNames = "이름" + "\n" + "_____" + "\n";
                String strSex = "성별" + "\n" + "_____" + "\n";
                String strYY = "생년월일" + "\n" + "_____" + "\n";
                String strNumbers = "전화번호" + "\n" + "_____" + "\n";

                while (cursor.moveToNext()) {
                    strId += cursor.getString(0) + "\r\n";
                    strPw += cursor.getString(1) + "\r\n";
                    strNames += cursor.getString(2) + "\r\n";
                    strSex += cursor.getString(3) + "\r\n";
                    strYY += cursor.getString(4) + "\r\n";
                    strNumbers += cursor.getString(5) + "\r\n";
                }

                edtIDResult.setText(strId);
                edtPWResult.setText(strPw);
                edtNmResult.setText(strNames);
                edtSexResult.setText(strSex);
                edtYYResult.setText(strYY);
                edtNumResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();

            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }

    public class userSQL extends SQLiteOpenHelper {

        public userSQL(@Nullable Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE groupTBL (userId CHAR(25) PRIMARY KEY, userPw CHAR(30)," +
                    "userNm CHAR(10), userSex CHAR(5), userYY CHAR(10), userNum CHAR(20));");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}