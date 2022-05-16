package com.example.orthoden;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.orthoden.Communication.MailActivity;
import com.example.orthoden.Communication.ReturnActivity;
import com.example.orthoden.Communication.SMSActivity;
import com.example.orthoden.Intent.LinkActivity;
import com.example.orthoden.Intent.ShareActivity;
import com.example.orthoden.Login.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    final static int REQUEST_CODE = 1200;
    Button btnSMS,btnMail,btnLink,btnShare,btnReturn;
    TextView tvUserName;
    final static int REQUEST_CODE2=100;
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

        //burasi IntentApp degiskenleri
        tvUserName=findViewById(R.id.tv_UserName);
        btnSMS=findViewById(R.id.btn_SMS);
        btnMail=findViewById(R.id.btn_Mail);
        btnShare=findViewById(R.id.btn_Share);
        btnLink=findViewById(R.id.btn_Link);
        btnReturn=findViewById(R.id.btn_Return);
        btnReturn.setOnClickListener(this);
        btnLink.setOnClickListener(this);
        btnShare.setOnClickListener(this);
        btnSMS.setOnClickListener(this);
        btnMail.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int ID= view.getId();
        Intent intent;
        switch (ID){
            case R.id.btn_SMS:
                intent =new Intent(MainActivity.this, SMSActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Mail:
                intent=new Intent(MainActivity.this, MailActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Link:
                intent=new Intent(MainActivity.this, LinkActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Share:
                intent=new Intent(MainActivity.this, ShareActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Return:
                intent=new Intent(MainActivity.this,ReturnActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.smsbutton:
                intent = new Intent(MainActivity.this, SMSActivity.class);
                startActivity(intent);
                break;
            case R.id.returnButton:
                intent = new Intent(MainActivity.this, ReturnActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.mailbutton:
                intent = new Intent(MainActivity.this, MailActivity.class);
                startActivity(intent);
                break;
            case R.id.newlogin_btn:
                intent=new Intent(MainActivity.this, LoginActivity.class );
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            // eger request code REQUEST_CODE a esitse, 55. satirdaki kodun ciktisini isleyecegiz
            if (resultCode==Activity.RESULT_OK){
                String name = data.getStringExtra("USERNAME");
                tvReturn.setText(name);
            }
        }
    }
}
