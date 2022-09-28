package com.example.ex0122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity {
    Intent gi;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        tv1 = findViewById(R.id.tv1);
        gi = getIntent();
        double sum = gi.getDoubleExtra("sum",-1);
        String text = "Calculator's Last answer was: "+sum;
        tv1.setText(text);
    }

    public void backButton(View view) {
        finish();
    }
}