package com.example.orthoden.Communication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orthoden.R;

public class SMSActivity extends AppCompatActivity {
    EditText etPhoneNumber,etSMSText;
    Button btnSendSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);
        etPhoneNumber = findViewById(R.id.et_PhoneNumber);
        etSMSText=findViewById(R.id.et_SMSText);
        btnSendSMS=findViewById(R.id.btn_SendSMS);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber=etPhoneNumber.getText().toString();
                String text=etSMSText.getText().toString();
                Intent smsIntent= new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:"+phoneNumber));
                smsIntent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(smsIntent);
            }
        });

    }
}