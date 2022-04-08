package com.example.orthoden;


import androidx.activity.result.ActivityResult;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    final static int REQUEST_CODE = 1200;
    TextView tvReturn;
    Button btnSMSService,btnMailService,btnLinkService,btnShareService,btnReturnActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMailService=findViewById(R.id.mailbutton);
        btnSMSService=findViewById(R.id.smsbutton);
        btnReturnActivity=findViewById(R.id.returnButton);
        tvReturn=findViewById(R.id.tv_return);

        btnMailService.setOnClickListener(this);
        btnSMSService.setOnClickListener(this);
        btnReturnActivity.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int ID= view.getId();
        Intent intent;
        switch (ID){
            case R.id.smsbutton:
                intent = new Intent(MainActivity.this,SMSActivity.class);
                startActivity(intent);
                break;
            case R.id.returnButton:
                intent = new Intent(MainActivity.this,ReturnActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.mailbutton:
                intent = new Intent(MainActivity.this,MailActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            // eger request kode REQUEST_CODE a esitse, 55. satirdaki kodun ciktisini isleyecegiz
            if (resultCode==Activity.RESULT_OK){
                String name = data.getStringExtra("USERNAME");
                tvReturn.setText(name);
            }
        }
    }
//    final static int REQUEST_CODE = 1200;
//    TextView tvReturn;
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        tvReturn = findViewById(R.id.returnText);
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == REQUEST_CODE){
//            if (resultCode == Activity.RESULT_OK){
//                String name = data.getStringExtra("USERNAME");
//                tvReturn.setText(name);
//            }
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button smsbutton = findViewById(R.id.smsbutton);
//        smsbutton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Intent goIntent = new Intent(MainActivity.this, SMSActivity.class);
//                startActivity(goIntent);
//            }
//        });
//        Button mailbutton = findViewById(R.id.mailbutton);
//        mailbutton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Intent goIntent = new Intent(MainActivity.this, MailActivity.class);
//                startActivity(goIntent);
//            }
//        });
//        Button returnbutton = findViewById(R.id.returnButton);
//        returnbutton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Intent goIntent = new Intent(MainActivity.this, ReturnActivity.class);
//                startActivityForResult(goIntent,REQUEST_CODE);
//            }
//        });
//
//
//    }

}