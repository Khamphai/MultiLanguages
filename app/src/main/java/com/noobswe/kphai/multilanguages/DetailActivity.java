package com.noobswe.kphai.multilanguages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textViewTopic, textViewDetail;
    ImageView imvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewTopic = (TextView) findViewById(R.id.tvTopic);
        textViewDetail = (TextView) findViewById(R.id.tvDetail);
        imvShow = (ImageView) findViewById(R.id.imvShow);

        checkData();

    } //end of OnCreate-----------------------------------------------------------------------------

    private void checkData() {

        Intent intent = getIntent();

        if (intent.getStringExtra("A") != null) {
            String s = intent.getStringExtra("A");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_khao_soii);
            textViewDetail.setText(R.string.detailTest);
        }
        if (intent.getStringExtra("B") != null) {
            String s = intent.getStringExtra("B");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_khao_niew);
            textViewDetail.setText(R.string.detailTest);
        }
        if (intent.getStringExtra("C") != null) {
            String s = intent.getStringExtra("C");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_papaya);
            textViewDetail.setText(R.string.detailTest);
        }
        if (intent.getStringExtra("D") != null) {
            String s = intent.getStringExtra("D");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_larb);
            textViewDetail.setText(R.string.detailTest);
        }
        if (intent.getStringExtra("E") != null) {
            String s = intent.getStringExtra("E");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_khao_larm);
            textViewDetail.setText(R.string.detailTest);
        }
        if (intent.getStringExtra("F") != null) {
            String s = intent.getStringExtra("F");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_khao_g);
            textViewDetail.setText(R.string.detailTest);
        }
        if (intent.getStringExtra("G") != null) {
            String s = intent.getStringExtra("G");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_mieng);
            textViewDetail.setText(R.string.detailTest);
        }
        if (intent.getStringExtra("H") != null) {
            String s = intent.getStringExtra("H");
            textViewTopic.setText(s.toString());
            imvShow.setImageResource(R.drawable.btn_fer);
            textViewDetail.setText(R.string.detailTest);
        } //end of loop


    } // end of Method checkData--------------------------------------------------------------------


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_share) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


} //end of Main Class-------------------------------------------------------------------------------
