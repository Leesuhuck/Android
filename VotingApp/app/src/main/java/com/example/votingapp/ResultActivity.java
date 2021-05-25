package com.example.votingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageNm = intent.getStringArrayExtra("ImageNm");

        TextView tv[] = new TextView[imageNm.length];
        RatingBar ratingBar[] = new RatingBar[imageNm.length];
        Button btnReturn = (Button) findViewById(R.id.btnTurn);

        Integer tvID[] = {
                R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7,
                R.id.tv8, R.id.tv9
        };

        Integer ratingBarID[] = {
                R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6,
                R.id.rbar7, R.id.rbar8, R.id.rbar9
        };

        for (int i = 0; i < voteResult.length; i++) {

            tv[i] = (TextView) findViewById(tvID[i]);
            ratingBar[i] = (RatingBar) findViewById(ratingBarID[i]);

        }

        for (int i = 0; i < voteResult.length; i++) {

            tv[i].setText(imageNm[i]);
            ratingBar[i].setRating((float) voteResult[i]);

        }

        btnReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
