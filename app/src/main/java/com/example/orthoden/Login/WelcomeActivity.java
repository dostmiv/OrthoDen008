package com.example.orthoden.Login;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.orthoden.R;

public class WelcomeActivity extends AppCompatActivity {
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvWelcome=findViewById(R.id.tv_Welcome);
        String userName=getIntent().getStringExtra("USERNAME");
        tvWelcome.setText(userName);
    }
}