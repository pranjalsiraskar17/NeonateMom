package com.example.anay.kotlinmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class chooser1 extends AppCompatActivity {
    private ImageButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser1);
        b1 = (ImageButton)findViewById(R.id.choose);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooser1.this,ImageRetrieve.class);
                startActivity(intent);
            }
        });
        b2 = (ImageButton)findViewById(R.id.upload);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooser1.this, VideoRetrieve.class);
                startActivity(intent);

            }
        });

    }

    public void back(View view) {
        super.onBackPressed();
    }

    public void home(View view) {
        super.onBackPressed();
    }
}
