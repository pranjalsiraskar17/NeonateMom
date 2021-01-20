package com.example.anay.kotlinmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpSelector extends AppCompatActivity {
    private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_selector);
        b1 = (Button)findViewById(R.id.choose);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpSelector.this,chooser.class);
                startActivity(intent);
            }
        });
        b2 = (Button)findViewById(R.id.upload);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpSelector.this, chooser1.class);
                startActivity(intent);

            }
        });

    }
}
