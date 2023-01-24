package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonShow = (Button) findViewById(R.id.SHOW);
        final Button buttonHide = (Button) findViewById(R.id.HIDE);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text_display =(TextView)findViewById(R.id.Name);
                text_display.setVisibility(View.VISIBLE);

            }

        });
        buttonHide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text_display =(TextView)findViewById(R.id.Name);
                text_display.setVisibility(View.INVISIBLE);
            }

        });


    }
}