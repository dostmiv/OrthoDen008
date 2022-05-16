package com.example.orthoden.Intent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.orthoden.R;

public class ShareActivity extends AppCompatActivity {
    EditText etShare;
    ImageButton ibShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        etShare=findViewById(R.id.et_Share);
        ibShare=findViewById(R.id.ib_Share);
        ibShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String share=etShare.getText().toString();
                if(!TextUtils.isEmpty(share)){
                    Intent shareIntent=new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("plain/text");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, share);
                    startActivity(Intent.createChooser(shareIntent,"Select platform"));
                }

            }
        });
    }
}