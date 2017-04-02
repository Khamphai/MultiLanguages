package com.noobswe.kphai.multilanguages;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class AboutActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView = (TextView) findViewById(R.id.tvAbout);

        Intent intent = getIntent();
        String s = intent.getStringExtra("test");
        textView.setText(s.toString());
    }

}
