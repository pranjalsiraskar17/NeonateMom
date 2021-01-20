package com.example.anay.kotlinmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class chooser extends AppCompatActivity {
    private ImageButton b1,b2;
    private TextView b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        b1 = (ImageButton)findViewById(R.id.choose);
        b2 = (ImageButton)findViewById(R.id.upload);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooser.this,uploadimage.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooser.this, uploadvideo.class);
                startActivity(intent);

            }
        });
        b3 = (TextView) findViewById(R.id.back_to_register_textview);
        b4 = (TextView) findViewById(R.id.textView16);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooser.this,PhysicianGrowthGuideExperienceActivity.class);
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooser.super.onBackPressed();

            }
        });

    }
}
